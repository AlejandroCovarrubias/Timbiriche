/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pipesandfilters;

import Dominio.*;

/**
 *
 * @author Alejandro Galindo
 */
public class SinkRepo {

    private static SinkRepo instance;
    private Sala sala;

    private SinkRepo() {
        sala = new Sala();
    }

    public static SinkRepo getInstance() {
        if (instance == null) {
            instance = new SinkRepo();
        }
        return instance;
    }

    public void asignarMarcador(Marcador marcador) {
        this.sala.setMarcador(marcador);
    }

    public void asignarTablero(Tablero tablero) {
        this.sala.setTablero(tablero);
    }

    public void asignarLinea(Linea linea) {
        for (Jugador jugador : this.sala.getMarcador().getJugadores()) {
            if (jugador.equals(linea.getJugador())) {
                if (linea.getPosicion().equals("HORIZONTAL")) {
                    this.sala.getTablero().getLineasHorizontales().get(linea.getIndice()).setJugador(jugador);
                } else if (linea.getPosicion().equals("VERTICAL")) {
                    this.sala.getTablero().getLineasVerticales().get(linea.getIndice()).setJugador(jugador);
                }
            }
        }
    }

    public void asignarCuadro(Cuadro cuadro) {
        for (Jugador jugador : this.sala.getMarcador().getJugadores()) {
            if(jugador.equals(cuadro.getJugador())){
                this.sala.getTablero().getCuadros().get(cuadro.getIndice()).setJugador(jugador);
                jugador.setPuntaje(jugador.getPuntaje()+1);
            }
        }
    }

    public void retirarJugador(Jugador jugador) {
        for (Jugador jugObj : this.sala.getMarcador().getJugadores()) {
            if(jugObj.equals(jugador)){
                this.sala.getMarcador().getJugadores().remove(jugObj);
                
                for (Linea vertical : this.sala.getTablero().getLineasVerticales()) {
                    if(vertical.getJugador().equals(jugObj)){
                        vertical.setJugador(null);
                    }
                }
                
                for (Linea horizontal : this.sala.getTablero().getLineasHorizontales()) {
                    if(horizontal.getJugador().equals(jugObj)){
                        horizontal.setJugador(null);
                    }
                }
                
                for (Cuadro cuadro : this.sala.getTablero().getCuadros()) {
                    if(cuadro.getJugador().equals(jugObj)){
                        cuadro.setJugador(null);
                    }
                }
            }
        }
    }

    public Sala getSala() {
        return sala;
    }
}