/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sckclient;

import Dominio.Jugador;
import java.io.IOException;

/**
 *
 * @author Alejandro Galindo
 */
public class Cliente implements ICliente{
    private SckClient sckCliente;

    public Cliente(Jugador jugador){
        this.sckCliente = new SckClient(jugador);
    }
    
    @Override
    public boolean conectarAlServidor(String address, int port) {
        try {
            sckCliente.conectarAlServidor(address, port);
            return true;
        } catch (IOException ex) {
            return false;
        }
    }

    @Override
    public boolean enviarAlServidor(Object mensaje) {
        try {
            sckCliente.enviarAlServidor(mensaje);
            return true;
        } catch (IOException ex) {
            return false;
        }
    }

    @Override
    public Object escucharAlServidor() {
        try {
            return sckCliente.escucharAlServidor();
        } catch (IOException | ClassNotFoundException ex) {
            return "Problemas al recibir la respuesta del servidor";
        }
    }
    
}
