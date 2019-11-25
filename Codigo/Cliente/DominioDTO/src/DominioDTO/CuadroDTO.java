/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DominioDTO;

/**
 *
 * @author Alejandro Galindo
 */
public class CuadroDTO {
    
    private LineaDTO superior, inferior, izquierda, derecha;
    private int indice;
    private JugadorDTO jugador;

    public CuadroDTO(LineaDTO superior, LineaDTO inferior, LineaDTO izquierda, LineaDTO derecha, int indice, JugadorDTO jugador) {
        this.superior = superior;
        this.inferior = inferior;
        this.izquierda = izquierda;
        this.derecha = derecha;
        this.indice = indice;
        this.jugador = jugador;
    }

    public LineaDTO getSuperior() {
        return superior;
    }

    public void setSuperior(LineaDTO superior) {
        this.superior = superior;
    }

    public LineaDTO getInferior() {
        return inferior;
    }

    public void setInferior(LineaDTO inferior) {
        this.inferior = inferior;
    }

    public LineaDTO getIzquierda() {
        return izquierda;
    }

    public void setIzquierda(LineaDTO izquierda) {
        this.izquierda = izquierda;
    }

    public LineaDTO getDerecha() {
        return derecha;
    }

    public void setDerecha(LineaDTO derecha) {
        this.derecha = derecha;
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
        return "CuadroDTO{" + "superior=" + superior + ", inferior=" + inferior + ", izquierda=" + izquierda + ", derecha=" + derecha + ", indice=" + indice + ", jugador=" + jugador + '}';
    }
}