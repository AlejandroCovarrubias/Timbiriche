/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sckclient;

import Dominio.Jugador;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Alejandro Galindo
 */
public class SckClient implements Runnable{
    private Jugador jugador;
    private Socket socket;
    private ObjectInputStream clientInput;
    private ObjectOutputStream clientOutput;
    private Object objeto;
    
    

    public SckClient(Jugador jugador) {
        this.jugador = jugador;
    }

    public void conectarAlServidor(String address, int port) throws IOException{
        socket = new Socket(address, port);
        clientOutput = new ObjectOutputStream(socket.getOutputStream());
        clientOutput.flush();
        clientInput = new ObjectInputStream(socket.getInputStream());
    }
    
    public void enviarAlServidor(Object mensaje) throws IOException {
        clientOutput.writeObject(mensaje);
        clientOutput.flush();
    }
    
    public Object escucharAlServidor() throws IOException, ClassNotFoundException{
        Thread t = new Thread(this);
        t.start();
        return objeto;
    }

    @Override
    public void run() {
        while(true){
            try {
                this.objeto = clientInput.readObject();
                System.out.println(objeto);
            } catch (IOException | ClassNotFoundException ex) {
                Logger.getLogger(SckClient.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
