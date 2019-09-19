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
public class Punto {
    int A;
    int B;
    
    public Punto(int A, int B){
        this.A = A;
        this.B = B;
    }
    
    public int getA(){
        return A;
    }
    
    public int getB(){
        return B;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + this.A;
        hash = 53 * hash + this.B;
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
        final Punto other = (Punto) obj;
        if (this.A != other.A) {
            return false;
        }
        if (this.B != other.B) {
            return false;
        }
        return true;
    }
}