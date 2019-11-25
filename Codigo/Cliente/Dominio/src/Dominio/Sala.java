/**
 * Sala.java
 * 30 de Septiembre 2019, 06:54pm.
 */
package Dominio;

import java.util.List;

/**
 *
 * @author Alejandro Galindo, Francisco Felix
 */
public class Sala {
    
    private Tablero tablero;
    private Marcador marcador;
    private int tamanio;

    /**
     * Constructor de Sala
     * @param marcador
     * @param tablero
     * @param tamanio 
     */
    public Sala(Marcador marcador, Tablero tablero, int tamanio) {
        this.tablero = tablero;
        this.marcador = marcador;
        this.tamanio = tamanio;
    }

    public Sala() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Tablero getTablero() {
        return tablero;
    }

    public void setTablero(Tablero tablero) {
        this.tablero = tablero;
    }

    public Marcador getMarcador() {
        return marcador;
    }

    public void setMarcador(Marcador marcador) {
        this.marcador = marcador;
    }

    public int getTamanio() {
        return tamanio;
    }

    public void setTamanio(int tamanio) {
        this.tamanio = tamanio;
    }
    
    public void agregarJugador(Jugador jugador){
        if(this.marcador.getJugadores().size() < this.tamanio){
            this.marcador.getJugadores().add(jugador);
        }
    }
    
    public void eliminarJugador(Jugador jugador){
        this.marcador.getJugadores().remove(jugador);
    }
}