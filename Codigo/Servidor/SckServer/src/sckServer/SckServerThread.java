/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sckServer;

import Dominio.Jugador;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Alejandro Galindo
 */
public class SckServerThread implements Runnable {

    private Socket socket;
    private ObjectInputStream serverInput;
    private ObjectOutputStream serverOutput;
    private List<SckServerThread> socketThreads;
    private boolean vivo;

    public SckServerThread(Socket socket, List<SckServerThread> socketThreads) throws IOException {
        this.socket = socket;
        this.socketThreads = socketThreads;
        vivo = true;
        serverOutput = new ObjectOutputStream(this.socket.getOutputStream());
        serverInput = new ObjectInputStream(this.socket.getInputStream());
    }
    
    public Socket getSocket(){
        return socket;
    }

    public ObjectInputStream getServerInput() {
        return serverInput;
    }

    public ObjectOutputStream getServerOutput() {
        return serverOutput;
    }

    public List<SckServerThread> getSocketThreads() {
        return socketThreads;
    }

    public boolean isVivo() {
        return vivo;
    }
    
    private void enviar(Object message) throws IOException {
        serverOutput.writeObject(message);
        serverOutput.flush();
    }
    
    private synchronized void transmitir(Object message) throws IOException {
        for (SckServerThread socketThread : socketThreads) {
            if(socketThread != this){
                socketThread.enviar(message);
            }
        }
    }
    
    private void limpiar() throws IOException {
        serverOutput.close();
        serverInput.close();
        socket.close();
        
        synchronized(socketThreads){
            socketThreads.remove(this);
        }
    }

    @Override
    public void run() {
        while(vivo){
            try {
                Object mensajeEntrante = serverInput.readObject();
                
                if(!vivo){
                    break;
                }
                
                //Mandar al protocolo el mensaje entrante
                
                //Transmitir lo que devuelva el protocolo,
                // o lo que este en el repositorio
                transmitir("Hola");
                
            } catch (IOException | ClassNotFoundException ex) {
                matarThread();
            }
        }
        
        try {
            limpiar();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
    public void matarThread(){
        vivo = false;
    }

}
