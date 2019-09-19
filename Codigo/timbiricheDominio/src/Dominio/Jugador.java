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
public class Jugador {
    String nombre;
    String rutaAvatar;

    public Jugador(String nombre, String rutaAvatar) {
        this.nombre = nombre;
        this.rutaAvatar = rutaAvatar;
    }
    
    public Jugador(String rutaAvatar){
        this.rutaAvatar = rutaAvatar;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRutaAvatar() {
        return rutaAvatar;
    }

    public void setRutaAvatar(String rutaAvatar) {
        this.rutaAvatar = rutaAvatar;
    }
}