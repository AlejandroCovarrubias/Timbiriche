/**
 * Prefencia.java
 */
package Dominio;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Alejandro Galindo, Francisco Felix
 */
public class Preferencia {
    
    private List<String> colores;

    public Preferencia(String colorLinea2, String colorLinea3, String colorLinea4) {
        colores = new ArrayList<>();
        colores.add(colorLinea2);
        colores.add(colorLinea3);
        colores.add(colorLinea4);
    }

    public List<String> getColores() {
        return colores;
    }

    public void setColores(List<String> colores) {
        this.colores = colores;
    }
}