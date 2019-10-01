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
public class Linea extends Forma {
    
    private boolean conectado;

    public Linea(boolean conectado, int width, int height, int x, int y) {
        super(width, height, x, y);
        this.conectado = conectado;
    }

    public boolean isConectado() {
        return conectado;
    }

    public void setConectado(boolean conectado) {
        this.conectado = conectado;
    }
}