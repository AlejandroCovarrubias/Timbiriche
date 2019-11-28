package sckServer;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

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

    static List<SckServerThread> clients = new ArrayList<>();
    static int i = 0;
    static int MAX = 4;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(1234);

        Socket s;

        while (true) {
            s = ss.accept();

            if (clients.size() < MAX) {
                System.out.println("Nueva conexion por parte de cliente: " + s);

                System.out.println("Creando un hilo para el cliente");

                SckServerThread sst = new SckServerThread(s, clients);

                Thread t = new Thread(sst);

                System.out.println("Aniadiendo al cliente a la lista");
                clients.add(sst);

                t.start();
            }else{
            
            }
        }
    }
}