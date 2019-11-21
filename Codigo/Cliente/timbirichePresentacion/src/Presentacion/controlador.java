/**
 * controlador.java
 */
package Presentacion;

/**
 * Clase controladora de las entradas y salidas entre el cliente y la
 * presentación
 *
 * @author Alejandro Galindo, Francisco Felix
 */
public class controlador implements IEnviar {

    @Override
    public void enviar() {

    }

    @Override
    public void procesar() {
        //Transformar los datos a objeto tipo sala
    }

    @Override
    public void recibir(int accion) {
        switch (accion) {
            case 1:
                // code block
                break;
            case 2:
                // code block
                break;
            case 3:
                // code block
                break;
            case 4:
                // code block
                break;
        }
    }
}
