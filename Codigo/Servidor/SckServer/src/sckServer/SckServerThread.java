/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sckServer;

import DominioDTO.JugadorDTO;
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
    
    private JugadorDTO jugadorDTO;
    private ObjectInputStream input;
    private ObjectOutputStream output;
    private List<SckServerThread> threads;
    private Socket s;
    private boolean isloggedin;
    
    public SckServerThread(Socket s, List<SckServerThread> threads) throws IOException{
        this.s = s;
        this.threads = threads;
        this.isloggedin = true;
        this.output = new ObjectOutputStream(s.getOutputStream());
        this.output.flush();
        this.input = new ObjectInputStream(s.getInputStream());
    }

    @Override
    public void run() {
        Object mensajeEntrante;
        
        while(true){
            try {
                System.out.println("empece a escuchar");
                mensajeEntrante = input.readObject();
                System.out.println("Conectado");
                System.out.println(mensajeEntrante);
                
//                if(this.jugadorDTO == null){
//                    this.jugadorDTO = (JugadorDTO) mensajeEntrante;
//                    System.out.println("Conectado");
//                    System.out.println(this.jugadorDTO);
//                }else{
//                    
//                }

                for (SckServerThread thread : threads) {
                    thread.output.writeObject("Hola");
                    thread.output.flush();
                }
                
            } catch (IOException ex) {
                Logger.getLogger(SckServerThread.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(SckServerThread.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}