/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sckServer;

import DominioDTO.CuadroDTO;
import DominioDTO.JugadorDTO;
import DominioDTO.LineaDTO;
import DominioDTO.MarcadorDTO;
import DominioDTO.MensajeSockets;
import DominioDTO.MovimientoDTO;
import DominioDTO.RespuestaDTO;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Alejandro Galindo
 */
public class SckServerThread implements Runnable {

    private volatile JugadorDTO jugadorDTO;
    private ObjectInputStream input;
    private ObjectOutputStream output;
    private volatile List<SckServerThread> threads;
    private SckServerProtocol ssp;
    private Socket s;
    private boolean votado;
    private int MAX;

    public SckServerThread(Socket s, List<SckServerThread> threads, int MAX) throws IOException {
        this.s = s;
        this.threads = threads;
        this.votado = false;
        this.ssp = new SckServerProtocol();
        this.output = new ObjectOutputStream(s.getOutputStream());
        this.output.flush();
        this.input = new ObjectInputStream(s.getInputStream());
        this.MAX = MAX;
    }

    @Override
    public void run() {
        Object mensajeEntrante;

        while (true) {
            try {

                //Lee entrada
                mensajeEntrante = input.readObject();

                //La procesa el protocolo
                Object mensajeSaliente = ssp.procesarEntrada(mensajeEntrante);

                //Si el jugador es nuevo
                if (mensajeSaliente == MensajeSockets.JUGADOR_NUEVO) {
                    System.out.println("Entro jugador: " + mensajeEntrante);
                    this.jugadorDTO = (JugadorDTO) mensajeEntrante;

                    //Crea una lista de Jugadores
                    List<JugadorDTO> jugadores = new ArrayList<>();
                    for (SckServerThread thread : threads) {
                        jugadores.add(thread.getJugadorDTO());
                    }

                    //La transmite a todos para actualizar
                    transmitirATodos(jugadores);

                    if (threads.size() == MAX) {
                        Object empezarPartida = ssp.empezarPartida(jugadores);
                        transmitirATodos(empezarPartida);
                    }

                    //Si es un voto
                } else if (mensajeSaliente == MensajeSockets.VOTO) {
                    //Si no voto
                    if (this.votado == false) {
                        this.votado = true;
                        mensajeSaliente = this.jugadorDTO.getNombreJugador() + " ha votado";
                        //Si ya habia votado
                    } else {
                        this.votado = false;
                        mensajeSaliente = this.jugadorDTO.getNombreJugador() + " ha cancelado el voto";
                    }

                    //Retorna accion
                    transmitirATodos(mensajeSaliente);
                } else if (mensajeSaliente instanceof MarcadorDTO) {
                    transmitirATodos(mensajeSaliente);
                } else if (mensajeSaliente instanceof RespuestaDTO) {
                    transmitirATodos(mensajeSaliente);
                }

            } catch (IOException | ClassNotFoundException ex) {
                Logger.getLogger(SckServerThread.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public JugadorDTO getJugadorDTO() {
        return jugadorDTO;
    }

    public void setJugadorDTO(JugadorDTO jugadorDTO) {
        this.jugadorDTO = jugadorDTO;
    }

    public ObjectInputStream getInput() {
        return input;
    }

    public ObjectOutputStream getOutput() {
        return output;
    }

    public boolean isVotado() {
        return votado;
    }

    public void setVotado(boolean votado) {
        this.votado = votado;
    }

    public synchronized void transmitirASiMismo(Object mensaje) {
        try {
            this.output.writeObject(mensaje);
            this.output.flush();
        } catch (IOException ex) {
            Logger.getLogger(SckServerThread.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public synchronized void transmitirATodos(Object mensaje) {
        for (SckServerThread thread : threads) {
            try {
                thread.output.writeObject(mensaje);
                thread.output.flush();
            } catch (IOException ex) {
                Logger.getLogger(SckServerThread.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
