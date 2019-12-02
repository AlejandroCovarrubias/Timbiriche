/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sckCliente;

import Dominio.Cuadro;
import Dominio.Jugador;
import Dominio.Linea;
import DominioDTO.CuadroDTO;
import DominioDTO.JugadorDTO;
import DominioDTO.LineaDTO;
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
                Linea linea = (Linea) mensaje;
                LineaDTO mensajeNuevo = 
                        new LineaDTO(
                                linea.getPosicion().toString(), 
                                linea.getIndice(), 
                                new JugadorDTO(
                                        linea.getJugador().getNombre(), 
                                        linea.getJugador().getRutaAvatar(), 
                                        linea.getJugador().getPuntaje()));
                
                sckCliente.enviarAlServidor(mensajeNuevo);
                return true;
            } else if (mensaje instanceof Cuadro) {
                Cuadro cuadro = (Cuadro) mensaje;
                CuadroDTO mensajeNuevo = 
                        new CuadroDTO(
                                cuadro.getIndice(), 
                                new JugadorDTO(
                                        cuadro.getJugador().getNombre(), 
                                        cuadro.getJugador().getRutaAvatar(), 
                                        cuadro.getJugador().getPuntaje()));
                
                sckCliente.enviarAlServidor(mensajeNuevo);
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
