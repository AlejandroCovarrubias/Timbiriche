/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sckclient;

import Dominio.Jugador;
import Dominio.Sala;
import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 *
 * @author Alejandro Galindo
 */
public class SckClient {
    private Jugador jugador;
    private Socket socket;
    private ObjectInputStream clientInput;
    private ObjectOutputStream clientOutput;

    public SckClient(Jugador jugador) {
        this.jugador = jugador;
    }

    public Jugador getJugador() {
        return jugador;
    }

    public Socket getSocket() {
        return socket;
    }

    public ObjectInputStream getClientInput() {
        return clientInput;
    }

    public ObjectOutputStream getClientOutput() {
        return clientOutput;
    }

    public void conectarAlServidor(String address, int port) throws IOException{
        socket = new Socket(address, port);
        clientInput = new ObjectInputStream(socket.getInputStream());
        clientOutput = new ObjectOutputStream(socket.getOutputStream());
    }
    
    public void enviarAlServidor(Object mensaje) throws IOException {
        clientOutput.writeObject(mensaje);
        clientOutput.flush();
    }
    
    public Object escucharAlServidor() throws IOException, ClassNotFoundException{
        while(true){
            Object objetoRecibido = obtenerRespuesta();
            if(objetoRecibido != null){
                return objetoRecibido;
            }else{
                return null;
            }
        }
    }
    
    private Object obtenerRespuesta() throws IOException, ClassNotFoundException {
        return clientInput.readObject();
    }
}
