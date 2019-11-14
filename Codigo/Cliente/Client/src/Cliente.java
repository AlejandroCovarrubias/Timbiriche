
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
public class Cliente {

    private Socket socket;
    private DataOutputStream output;
    private DataInputStream input;
    private String nombre;
    private String ip;
    private int puerto;

    public Cliente(String nombre, String ip, int puerto) {
        this.nombre = nombre;
        this.ip = ip;
        this.puerto = puerto;
    }

    public void iniciarConexion() {
        try {
            socket = new Socket(ip, puerto);
            output = new DataOutputStream(socket.getOutputStream());
            input = new DataInputStream(socket.getInputStream());
        } catch (IOException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        iniciar();
    }

    private void iniciar() {
        try {
            System.out.println(nombre + " envía saludo");
            output.writeUTF("hola");
            String respuesta = "";
            respuesta = input.readUTF();
            System.out.println(nombre + " Servidor devuelve saludo: " + respuesta);
            input.close();
            output.close();
            socket.close();
        } catch (IOException ex) {

        }
    }
}
