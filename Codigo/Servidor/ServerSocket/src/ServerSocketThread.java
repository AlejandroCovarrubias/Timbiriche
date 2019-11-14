
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
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
public class ServerSocketThread extends Thread {

    private Socket socket;
    private DataOutputStream output;
    private DataInputStream input;

    public ServerSocketThread(Socket socket) {
        this.socket = socket;
        try {
            output = new DataOutputStream(socket.getOutputStream());
            input = new DataInputStream(socket.getInputStream());
        } catch (IOException ex) {
            Logger.getLogger(ServerSocketThread.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void desconectar() {
        try {
            output.close();
            input.close();
            socket.close();
        } catch (IOException ex) {
            Logger.getLogger(ServerSocketThread.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void run() {
        Object accion = "";
        while (true) {
            try {
                accion = input.readUTF();
                if (accion.equals("hola")) {
                    System.out.println("Se ha unido el cliente");
                    output.writeUTF("Hola de parte del servidor");
                }else if (accion.equals("adios")){
                    System.out.println("El cliente se despide");
                    output.writeUTF("Adios de parte del servidor");
                    desconectar();
                }
            } catch (IOException ex) {
                Logger.getLogger(ServerSocketThread.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
