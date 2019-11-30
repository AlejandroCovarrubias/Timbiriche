/**
 * Jugador.java
 */
package Dominio;

import java.util.Objects;

/**
 *
 * @author Alejandro Galindo, Francisco Felix
 */
public class Jugador {
    private String nombre;
    private String rutaAvatar;
    private int puntaje;
    private Preferencia preferencia;
    private String color;

    public Jugador(String nombre, String rutaAvatar) {
        this.nombre = nombre;
        this.rutaAvatar = rutaAvatar;
    }

    public Jugador(String nombre, String rutaAvatar, int puntaje) {
        this.nombre = nombre;
        this.rutaAvatar = rutaAvatar;
        this.puntaje = puntaje;
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

    public int getPuntaje() {
        return puntaje;
    }

    public void setPuntaje(int puntaje) {
        this.puntaje = puntaje;
    }

    public Preferencia getPreferencia() {
        return preferencia;
    }

    public void setPreferencia(Preferencia preferencia) {
        this.preferencia = preferencia;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + Objects.hashCode(this.nombre);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Jugador other = (Jugador) obj;
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        return true;
    }
    
    @Override
    public String toString(){
        return this.nombre + " - " + this.getRutaAvatar();
    }
}