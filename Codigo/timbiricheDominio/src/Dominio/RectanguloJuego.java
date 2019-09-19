/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dominio;

import java.awt.Color;
import java.awt.geom.Rectangle2D;

/**
 *
 * @author labcisco
 */
public class RectanguloJuego {
    private Rectangle2D rectangulo;
    private Color color;
    
    // Crea un cuadrado negro, para los puntos del tablero
    public RectanguloJuego(Rectangle2D rectangulo){
        this.rectangulo = rectangulo;
        color = Color.black;
    }
    
    // Crea un rectangulo con color, para las lineas del tablero
    public RectanguloJuego(Rectangle2D rectangulo, Color color){
        this.rectangulo = rectangulo;
        this.color = color;
    }

    public Rectangle2D getRectangulo() {
        return rectangulo;
    }

    public void setRectangulo(Rectangle2D rectangulo) {
        this.rectangulo = rectangulo;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
    
    
}