/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sckCliente;

import Dominio.Cuadro;
import Dominio.Jugador;
import Dominio.Linea;
import DominioDTO.JugadorDTO;
import DominioDTO.MensajeSockets;
import java.io.IOException;
import presentacion.inicio.IActualizable;

/**
 *
 * @author Alejandro Galindo
 */
public class Cliente implements ICliente {

    private static Cliente instance;

    private SckClient sckCliente;
      

    public Cliente(Jugador jugador, IActualizable actualizable) {
        this.sckCliente = SckClient.getInstance(jugador, actualizable);
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
            if (mensaje instanceof Jugador) {
                Jugador jugador = (Jugador) mensaje;
                JugadorDTO mensajeNuevo = new JugadorDTO(jugador.getNombre(), jugador.getRutaAvatar(), jugador.getPuntaje());
                sckCliente.enviarAlServidor(mensajeNuevo);
                return true;
            } else if (mensaje instanceof Linea) {
                //Pasar mensaje a LineaDTO
                return true;
            } else if (mensaje instanceof Cuadro) {
                //Pasar mensaje a CuadroDTO
                return true;
            } else if (mensaje instanceof String){
                sckCliente.enviarAlServidor(mensaje);
                return true;
            } else if(mensaje instanceof MensajeSockets){
                sckCliente.enviarAlServidor(mensaje);
                return true;
            }
            return false;
        } catch (IOException ex) {
            return false;
        }
    }

    @Override
    public void escucharAlServidor() {
        try {
            sckCliente.escucharAlServidor();
        } catch (IOException | ClassNotFoundException ex) {
            System.out.println("Problemas al recibir la respuesta del servidor");
        }
    }

}
