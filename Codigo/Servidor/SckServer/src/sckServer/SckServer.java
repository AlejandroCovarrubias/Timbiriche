package sckServer;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Alejandro Galindo
 */
public class SckServer {
    private ServerSocket serverSocket;
    private List<SckServerThread> socketThreads;
    private int maxThreads;
    private boolean alive;
    
    public SckServer(int maxThreads){
        alive = true;
        socketThreads = new ArrayList<>();
        this.maxThreads = maxThreads;
    }

    public ServerSocket getServerSocket() {
        return serverSocket;
    }

    public List<SckServerThread> getSocketThreads() {
        return socketThreads;
    }

    public int getMaxThreads() {
        return maxThreads;
    }

    public boolean isAlive() {
        return alive;
    }
    
    private synchronized void escucharClientes() throws IOException {
        SckServerThread nuevoThread;
        Socket socket;
        
        while(alive) {
            System.out.println("Esperando a un cliente");
            socket = serverSocket.accept();
            
            if(!alive){
                break;
            }
            
            if(socketThreads.size() < maxThreads){
                nuevoThread = new SckServerThread(socket, socketThreads);
                socketThreads.add(nuevoThread);
                new Thread(nuevoThread).start();
                System.out.println("Cliente conectado al servidor");
            }else{
                System.out.println("Numero maximo de conexiones alcanzado");
                socket.close();
            }
        }
        
        for (SckServerThread threadActual : socketThreads) {
            threadActual.matarThread();
        }
    }
    
    public void escuchar(int puerto) throws IOException {
        serverSocket = new ServerSocket(puerto);
        System.out.println("El server esta escuchando en el puerto " + puerto);
        escucharClientes();
    }
    
    public void matarServer() throws IOException {
        alive = false;
        
        new Socket(serverSocket.getInetAddress(), serverSocket.getLocalPort()).close();
        serverSocket.close();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        SckServer server = new SckServer(4);
        
        try {
            server.escuchar(6000);
        } catch (IOException ex) {
            ex.printStackTrace();
            server.matarServer();
        }
    }  
}