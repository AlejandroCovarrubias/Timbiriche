/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dominio;

/**
 *
 * @author Alejandro Galindo
 */
public class Cuadro extends Forma {

    private Linea[] lineasHorizontal;
    private Linea[] lineasVertical;

    public Cuadro(Linea[] lineasHorizontal, Linea[] lineasVertical, int width, int height, int x, int y) {
        super(width, height, x, y);
        this.lineasHorizontal = lineasHorizontal;
        this.lineasVertical = lineasVertical;
    }
    
    public boolean esCuadro() {
        boolean cuadrado = true;
        for (int i = 0; i < 2; i++) {
            if (!lineasHorizontal[i].isConectado() || !lineasVertical[i].isConectado()) {
                cuadrado = false;
            }
        }

        return cuadrado;
    }

    public Linea[] getLineasHorizontal() {
        return lineasHorizontal;
    }

    public void setLineasHorizontal(Linea[] lineasHorizontal) {
        this.lineasHorizontal = lineasHorizontal;
    }

    public Linea[] getLineasVertical() {
        return lineasVertical;
    }

    public void setLineasVertical(Linea[] lineasVertical) {
        this.lineasVertical = lineasVertical;
    }   
}