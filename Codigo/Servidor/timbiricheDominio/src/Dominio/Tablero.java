/**
 * Tablero.java
 * 30 de septiembre 2019, 06:56pm.
 */
package Dominio;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Alejandro Galindo, Francisco Felix, Cesar Acactitla
 */
public class Tablero {
    private int dimension;
    private List<Linea> lineasHorizontales;
    private List<Linea> lineasVerticales;
    private List<Cuadro> cuadros;
    private List<Punto> puntos;
    
    public Tablero(int tamanio){
        lineasHorizontales = new ArrayList<>();
        lineasVerticales = new ArrayList<>();
        cuadros = new ArrayList<>();
        puntos = new ArrayList<>();
        
        switch (tamanio) {
            case 2:
                this.dimension = 10;
                break;
            case 3:
                this.dimension = 20;
                break;
            case 4:
                this.dimension = 40;
                break;
        }
    }

    public Tablero(int dimension, List<Linea> lineasHorizontales, List<Linea> lineasVerticales, List<Cuadro> cuadros, List<Punto> puntos) {
        this.dimension = dimension;
        this.lineasHorizontales = lineasHorizontales;
        this.lineasVerticales = lineasVerticales;
        this.cuadros = cuadros;
        this.puntos = puntos;
    }

    public int getDimension() {
        return dimension;
    }

    public void setDimension(int dimension) {
        this.dimension = dimension;
    }

    public List<Linea> getLineasHorizontales() {
        return lineasHorizontales;
    }

    public void setLineasHorizontales(List<Linea> lineasHorizontales) {
        this.lineasHorizontales = lineasHorizontales;
    }

    public List<Linea> getLineasVerticales() {
        return lineasVerticales;
    }

    public void setLineasVerticales(List<Linea> lineasVerticales) {
        this.lineasVerticales = lineasVerticales;
    }

    public List<Cuadro> getCuadros() {
        return cuadros;
    }

    public void setCuadros(List<Cuadro> cuadros) {
        this.cuadros = cuadros;
    }

    public List<Punto> getPuntos() {
        return puntos;
    }

    public void setPuntos(List<Punto> puntos) {
        this.puntos = puntos;
    }   
}