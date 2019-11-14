
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Alejandro Galindo
 */
public class SvrSocket {    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        List<ServerSocketThread> serverHilos = new ArrayList<>();
        ServerSocket ss;
        System.out.println("Iniciando servidor");
        
        try {
            ss = new ServerSocket(8888);
            System.out.println("Servidor iniciado");
            
            while(true){
                if(serverHilos.size() <= 4){
                    Socket socket;
                    socket = ss.accept();
                    System.out.println("Nuevo cliente");
                    
                    ServerSocketThread sst = new ServerSocketThread(socket);
                    sst.start();
                    
                    serverHilos.add(sst);
                    
                }else{
                    System.out.println("lleno");
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(SvrSocket.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
