/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sckclient;

import Dominio.Cuadro;
import Dominio.Jugador;
import Dominio.Linea;
import DominioDTO.JugadorDTO;
import java.io.IOException;

/**
 *
 * @author Alejandro Galindo
 */
public class Cliente implements ICliente {

    private static Cliente instance;

    private SckClient sckCliente;

    private Cliente(Jugador jugador) {
        this.sckCliente = new SckClient(jugador);
    }

    public static Cliente getInstance(Jugador jugador) {
        if (instance == null) {
            instance = new Cliente(jugador);
        }
        return instance;
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
                return true;
            } else if (mensaje instanceof Cuadro) {
                return true;
            } else if (mensaje instanceof String){
                sckCliente.enviarAlServidor(mensaje);
                return true;
            }
            return false;
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
