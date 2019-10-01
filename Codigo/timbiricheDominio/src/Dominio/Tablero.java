/**
 * Tablero.java
 * 30 de septiembre 2019, 06:56pm.
 */
package Dominio;

import java.util.List;

/**
 *
 * @author Alejandro Galindo
 */
public class Tablero {
    private int ancho, alto;
    private List<Linea> lineasHorizontales;
    private List<Linea> lineasVerticales;
    private List<Cuadro> cuadros;
    private List<Punto> puntos;
    
    public Tablero(int tamanio){
        switch (tamanio) {
            case 2:
                this.ancho = this.alto = 10;
                break;
            case 3:
                this.ancho = this.alto = 20;
                break;
            case 4:
                this.ancho = this.alto = 40;
                break;
        }
    }

    public Tablero(int ancho, int alto, List<Linea> lineasHorizontales, List<Linea> lineasVerticales, List<Cuadro> cuadros, List<Punto> puntos) {
        this.ancho = ancho;
        this.alto = alto;
        this.lineasHorizontales = lineasHorizontales;
        this.lineasVerticales = lineasVerticales;
        this.cuadros = cuadros;
        this.puntos = puntos;
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