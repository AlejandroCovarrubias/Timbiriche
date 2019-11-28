/**
 * PnlObs.java
 */
package Presentacion;

/**
 * Interfaz de observadores.
 * 
 * @author Alejandro Galindo, Francisco Felix
 */
public interface PnlObs {
    /**
     * Metodo que agrega.
     * @param observador
     */
    void agregar(PnlObr observador);
    /**
     * Metodo que elimina.
     * @param observador
     */
    void eliminar(PnlObr observador);
    /**
     * Metodo que notifica.
     */
    void nofiticarLinea();
}
