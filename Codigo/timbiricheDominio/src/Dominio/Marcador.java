/**
 * Marcador.java
 * 30 de Septiembre 2019, 06:57pm.
 */
package Dominio;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 *
 * @author Alejandro Galindo
 */
public class Marcador {
    private int tamanio;
    private Jugador lider;
    private List<Jugador> jugadores;
    
    public Marcador(Jugador lider, int tamanio){
        this.tamanio = tamanio;
        this.lider = lider;
        this.jugadores = new ArrayList<>();
        this.jugadores.add(lider);
    }

    public int getTamanio() {
        return tamanio;
    }

    public void setTamanio(int tamanio) {
        this.tamanio = tamanio;
    }

    public Jugador getLider() {
        return lider;
    }

    public void setLider(Jugador lider) {
        this.lider = lider;
    }

    public List<Jugador> getJugadores() {
        return jugadores;
    }

    public void setJugadores(List<Jugador> jugadores) {
        this.jugadores = jugadores;
    }
    
    public void turnar(){
        Collections.shuffle(this.jugadores);
    }
    
    public void agregarJugador(Jugador jugador){
        if(this.tamanio < this.jugadores.size()){
            this.jugadores.add(jugador);
        }
    }
    
    public void eliminarJugador(Jugador jugador){
        this.jugadores.remove(jugador);
    }
}