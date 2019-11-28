/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DominioDTO;

import java.io.Serializable;

/**
 *
 * @author Alejandro Galindo
 */
public class CuadroDTO implements Serializable{

    private int indice;
    private JugadorDTO jugador;

    public CuadroDTO(int indice, JugadorDTO jugador) {
        this.indice = indice;
        this.jugador = jugador;
    }

    public int getIndice() {
        return indice;
    }

    public void setIndice(int indice) {
        this.indice = indice;
    }

    public JugadorDTO getJugador() {
        return jugador;
    }

    public void setJugador(JugadorDTO jugador) {
        this.jugador = jugador;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 73 * hash + this.indice;
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
        final CuadroDTO other = (CuadroDTO) obj;
        if (this.indice != other.indice) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "CuadroDTO{" + indice + ", " + jugador + ")";
    }
}