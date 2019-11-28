/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DominioDTO;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author Alejandro Galindo
 */
public class JugadorDTO implements Serializable{
    private String nombreJugador;
    private String rutaAvatar;
    private int puntaje;

    public JugadorDTO(String nombreJugador, String rutaAvatar, int puntaje) {
        this.nombreJugador = nombreJugador;
        this.rutaAvatar = rutaAvatar;
        this.puntaje = puntaje;
    }

    public String getNombreJugador() {
        return nombreJugador;
    }

    public void setNombreJugador(String nombreJugador) {
        this.nombreJugador = nombreJugador;
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

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + Objects.hashCode(this.nombreJugador);
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
        final JugadorDTO other = (JugadorDTO) obj;
        if (!Objects.equals(this.nombreJugador, other.nombreJugador)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "JugadorDTO{" + "nombreJugador=" + nombreJugador + ", rutaAvatar=" + rutaAvatar + ", puntaje=" + puntaje + '}';
    }
}