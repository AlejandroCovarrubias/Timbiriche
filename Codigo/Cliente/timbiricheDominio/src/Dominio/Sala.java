/**
 * Sala.java
 * 30 de Septiembre 2019, 06:54pm.
 */
package Dominio;

import java.util.List;

/**
 *
 * @author Alejandro Galindo, Francisco Felix, Cesar Acactitla
 */
public class Sala {
    
    private List<Jugador> jugadores;
    private Tablero tablero;
    private Marcador marcador;
    private int tamanio;
    private int votacion;

    /**
     * Constructor de Sala
     * @param marcador
     * @param tamanio 
     */
    public Sala(Marcador marcador, int tamanio) {
        this.tablero = new Tablero(tamanio);
        this.marcador = marcador;
        this.tamanio = tamanio;
        this.votacion = 0;
        this.jugadores = this.marcador.getJugadores();
    }

    public List<Jugador> getJugadores() {
        return jugadores;
    }

    public void setJugadores(List<Jugador> jugadores) {
        this.jugadores = jugadores;
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

    public int getVotacion() {
        return votacion;
    }

    public void setVotacion(int votacion) {
        this.votacion = votacion;
    }
    
    public void agregarJugador(Jugador jugador){
        if(this.jugadores.size() < this.tamanio){
            this.jugadores.add(jugador);
            this.marcador.setJugadores(this.jugadores);
        }
    }
    
    public void eliminarJugador(Jugador jugador){
        this.jugadores.remove(jugador);
        this.marcador.setJugadores(this.jugadores);
    }

    public void aumentarVotacion(){
        this.votacion++;
    }
    
    public void reducirVotacion(){
        this.votacion--;
    }
}
