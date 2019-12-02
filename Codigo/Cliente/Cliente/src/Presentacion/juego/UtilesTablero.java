/**
 * UtilesTablero.java
 */

package presentacion.juego;

import Dominio.Cuadro;
import Dominio.Linea;
import Dominio.Punto;
import Dominio.Jugador;
import Dominio.Posicion;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Alejandro Galindo, Francisco Felix
 */
public class UtilesTablero {

    /**
     * Metodo que genera los puntos segun el tamano del tablero y retorna una
     * coleccion de ellos.
     *
     * @param height
     * @param width
     * @param tamanio
     * @param espaciado
     * @return
     */
    public static List<Punto> creaPuntos(double height, double width,
            double tamanio, double espaciado) {
        List<Punto> puntos = new ArrayList<>();
        // Crea los puntos del tablero y los guarda en el arrayList
        // Empieza 3% del tamano total a la derecha y abajo, 
        // en la esquina superior izquierda y termina dejando un margen de 3%
        // Doble for, primero para vertical y luego para horizontal
        for (double i = (height * .03); i <= (height * .97); i += espaciado) {
            for (double j = (width * .03); j <= (width * .97); j += espaciado) {
                //Crea y guarda el punto
                puntos.add(new Punto((int) tamanio, (int) tamanio, (int) i, (int) j));
            }
        }

        return puntos;
    }
    

    /**
     * Metodo que crea las lineas verticales del tablero y regresa una coleccion
     * de ellas.
     *
     * @param height
     * @param tamanio
     * @param width
     * @param espaciado
     * @param qtyPuntos
     * @return
     */
    public static List<Linea> creaLineasHorizontales(double height, double width,
            double tamanio, double espaciado, int qtyPuntos) {
        List<Linea> lineasHorizontales = new ArrayList<>();
        //Se crean n matrices de n - 1 lineas
        //Donde n es igual al ancho/alto del tablero
        //El cual se determina segun el numero de jugadores (size)

        double altura = (height * .03);
        for (int i = 0; i < qtyPuntos; i++) {
            for (double j = (width * .03); j < ((width * .97) - espaciado);
                    j += espaciado) {
                lineasHorizontales.add(
                        new Linea(Posicion.HORIZONTAL, 
                                lineasHorizontales.size(), 
                                (int) (espaciado - tamanio),
                                (int) tamanio, 
                                (int) (j + tamanio), 
                                (int) altura));
            }
            altura += espaciado;
        }

        return lineasHorizontales;
    }

    /**
     * Metodo que crea las lineas horizontales del tablero y regresa una 
     * coleccion de ellas.
     *
     * @param height
     * @param width
     * @param tamanio
     * @param espaciado
     * @param qtyPuntos
     * @return
     */
    public static List<Linea> creaLineasVerticales(double height,
            double width, double tamanio, double espaciado, int qtyPuntos) {
        List<Linea> lineasVerticales = new ArrayList<>();
        double anchura = (width * .03);
        for (int i = 0; i < qtyPuntos; i++) {
            for (double j = (height * .03); j < ((height * .97) - espaciado);
                    j += espaciado) {
                lineasVerticales.add(
                        new Linea(Posicion.VERTICAL, 
                                lineasVerticales.size(), 
                                (int) tamanio,
                                (int) (espaciado - tamanio), 
                                (int) anchura, 
                                (int) (j + tamanio)));
            }
            anchura += espaciado;
        }
        return lineasVerticales;
    }
    
    /**
     * Metodo que crea los cuadrados del tablero utilizando las lineas
     * horizontales y verticales creadas con anterioridad.
     * @param lineasHorizontales
     * @param lineasVerticales
     * @param tamanio
     * @param espaciado
     * @param cantidad
     * @return 
     */
    public static List<Cuadro> creaCuadros(List<Linea> lineasHorizontales, 
            List<Linea> lineasVerticales, double tamanio, double espaciado, int cantidad){
        List<Cuadro> cuadros = new ArrayList<>();
        
        for (int i = 0; i < cantidad - 1; i++) {
            int indicador = i;
            for (int j = i*(cantidad - 1); j < i*(cantidad - 1) + (cantidad - 1); j++) {  
                cuadros.add(new Cuadro(lineasHorizontales.get(j),
                    lineasHorizontales.get(j + (cantidad-1)), 
                    lineasVerticales.get(indicador), 
                    lineasVerticales.get(indicador + (cantidad - 1)), 
                        null, cuadros.size(),
                    (int)(espaciado - tamanio), (int)(espaciado-tamanio), 
                    (int)(lineasHorizontales.get(j).getX()), 
                    (int)(lineasHorizontales.get(j).getY() + tamanio)));
                
                indicador += (cantidad - 1);
                
            }
        }
        
        return cuadros;
    }

    /**
     * Regresa el espacio entre los puntos del tablero. Cambia segun la altura
     * del tablero.
     *
     * @param cantidadDePuntos
     * @param height
     * @return
     */
    public static double obtenerEspaciadoDePuntos(int cantidadDePuntos,
            double height) {
        // Para saber el espaciadoDePuntos entre los puntos a dibujar
        // En un tablero de 10x10, es el 92% de la altura dividido entre 9
        // En un tablero de 20x20, es el 92% dividido entre 19
        // En un tablero de 40x40, es el 92% dividido entre 39

        switch (cantidadDePuntos) {
            case 10:
                return (height * .92) / 9;
            case 20:
                return (height * .92) / 19;
            case 40:
                return (height * .92) / 39;
            default:
                return 0;
        }
    }

    /**
     * Metodo que itera sobre als lineas verticales y horizontales para
     * determinar si el mouse esta sobre una linea o dio click en una.
     *
     * @param locateX
     * @param locateY
     * @param lineasHorizontales
     * @param lineasVerticales
     * @param jugador
     * @param espaciado
     * @param tamanio
     * @return 
     */
    public static Linea buscarLinea(int locateX, int locateY,
            List<Linea> lineasHorizontales, List<Linea> lineasVerticales,
            Jugador jugador, double espaciado, double tamanio) {
        for (int i = 0; i < (lineasHorizontales.size()
                + lineasVerticales.size()) / 2; i++) {

            Linea lineaVertical = lineasVerticales.get(i);
            Linea lineaHorizontal = lineasHorizontales.get(i);

            Color color = Color.decode(jugador.getPreferencia()
                    .getColores().get(0));

            FormaPolygon formaPlVer = new FormaPolygon(lineaVertical, color);
            FormaPolygon formaPlHor = new FormaPolygon(lineaHorizontal, color);

            if (estaDentroPoligono(formaPlHor, locateX, locateY,
                    espaciado, tamanio)) {
                return lineaHorizontal;
            }

            if (estaDentroPoligono(formaPlVer, locateX, locateY,
                    espaciado, tamanio)) {
                return lineaVertical;
            }
        }

        return null;
    }

    /**
     * Metodo que indica que la posicion del mouse esta dentro de un poligono.
     *
     * @param forma
     * @param locateX
     * @param locateY
     * @return
     */
    private static boolean estaDentroPoligono(FormaPolygon forma, int locateX,
            int locateY, double espaciado, double tamanio) {
        int x = forma.getForma().getX();
        int y = forma.getForma().getY();

        int x2 = 0;
        int y2 = 0;
        
        if (forma.getForma().getHeight() < forma.getForma().getWidth()) {
            x2 = forma.getForma().getX() + (int) espaciado;
            y2 = forma.getForma().getY() + (int) tamanio;
        } else {
            x2 = forma.getForma().getX() + (int) tamanio;
            y2 = forma.getForma().getY() + (int) espaciado;
        }

        return ((locateX > x && locateX < x2) && (locateY > y && locateY < y2));
    }
    
    /**
     * 
     * @param cuadros
     * @param linea
     * @param jugador
     * @return 
     */
    public static List<Cuadro> verificarMovimiento(List<Cuadro> cuadros, Linea linea, Jugador jugador) {
        List<Cuadro> cuadrosTemporal = new ArrayList<>();

        for (Cuadro cuadro : cuadros) {
            if (cuadro.tieneLinea(linea)) {
                if(cuadro.getJugador() == null){
                    cuadrosTemporal.add(cuadro);
                }
            }
        }

        for (Cuadro cuadro : cuadrosTemporal) {
            if (cuadro.estaCompleto()) {
                cuadro.setJugador(jugador);
            }
        }
        
        return cuadrosTemporal;
    }
}