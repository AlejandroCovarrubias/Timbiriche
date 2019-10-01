/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;

import Dominio.Forma;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;

/**
 *
 * @author Alejandro Galindo
 */
public class FormaPolygon{
    private Forma forma;
    private Color color;
    private Polygon shape;
    
    public FormaPolygon(Color color, Forma forma){
        this.color = color;
        this.forma = forma;
        this.shape = new Polygon();
        
        this.shape.addPoint((int) -forma.getWidth()/2, (int) -forma.getHeight()/2);
        this.shape.addPoint((int) -forma.getWidth()/2, (int) forma.getHeight()/2);
        this.shape.addPoint((int) forma.getWidth()/2, (int) forma.getHeight()/2);
        this.shape.addPoint((int) forma.getWidth()/2, (int) -forma.getHeight()/2);
    }
    
    public void renderizar(Graphics g){
        g.setColor(color);
        
        Polygon rendered = new Polygon();
        for (int i = 0; i < shape.npoints; i++) {
            int renderedx = (int) (shape.xpoints[i] + forma.getX() + forma.getWidth() / 2);
            int renderedy = (int) (shape.ypoints[i] + forma.getY() + forma.getHeight() / 2);
            rendered.addPoint(renderedx, renderedy);
        }
        
        g.fillPolygon(rendered);
    }
    
    public boolean tienePuntos(int x, int y){
        return shape.contains(x - this.forma.getX() - this.forma.getWidth() / 2,
                y - this.forma.getY() - this.forma.getHeight() / 2);
    }

    public Forma getForma() {
        return forma;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Polygon getShape() {
        return shape;
    }
}