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
    
    private SinkRepo(){
        instance = new SinkRepo();
        sala = new Sala();
    }
    
    public static SinkRepo getInstance(){
        if(instance == null){
            instance = new SinkRepo();
        }
        return instance;
    }
    
    public void asignarMarcador(Marcador marcador){
        this.sala.setMarcador(marcador);
    }
    
    public void asignarTablero(Tablero tablero){
        this.sala.setTablero(tablero);
    }
    
    public void asignarLinea(Linea linea){
        
    }
    
    public void asignarCuadro(Cuadro cuadro){
    
    }
    
    public void retirarJugador(Jugador jugador){
    
    }

    public Sala getSala() {
        return sala;
    }
}