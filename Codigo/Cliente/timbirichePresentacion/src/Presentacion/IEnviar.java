/**
 * IEnviar.java
 */
package Presentacion;

/**
 * Interface de comunicación entre el cliente y la presentación
 * 
 * @author Alejandro Galindo, Francisco Felix
 */
public interface IEnviar {
    
    void enviar();
    
    void procesar();
    
    void recibir(int accion); //Puede que no
}
