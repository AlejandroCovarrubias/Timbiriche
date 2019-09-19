/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dominio;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Alejandro Galindo
 */
public class Tablero {
    int ancho, alto;
    List<Punto> puntos = new ArrayList<>();
    List<Linea> lineas = new ArrayList<>();
    
    public Tablero(int ancho, int alto){
        this.alto = alto;
        this.ancho = ancho;
    }
    
    public Tablero(int ancho, int alto, List<Punto> puntos, List<Linea> lineas){
        this.alto = alto;
        this.ancho = ancho;
        this.puntos = puntos;
        this.lineas = lineas;
    }

    public int getAncho() {
        return ancho;
    }

    public void setAncho(int ancho) {
        this.ancho = ancho;
    }

    public int getAlto() {
        return alto;
    }

    public void setAlto(int alto) {
        this.alto = alto;
    }

    public List<Punto> getPuntos() {
        return puntos;
    }

    public void setPuntos(List<Punto> puntos) {
        this.puntos = puntos;
    }

    public List<Linea> getLineas() {
        return lineas;
    }

    public void setLineas(List<Linea> lineas) {
        this.lineas = lineas;
    }
}
