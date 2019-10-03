/**
 * PnlTablero.java.
 */
package Presentacion;

import Dominio.Jugador;
import Dominio.Linea;
import Dominio.Punto;
import Dominio.Sala;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import timbirichenegocios.ITimbiriche;
import timbirichenegocios.TimbiricheFacade;

/**
 *
 * @author Alejandro Galindo
 */
public class PnlTablero extends javax.swing.JPanel implements ComponenteSala, MouseListener, MouseMotionListener {

    /**
     * Tablero que se dibuja
     */
    private Sala sala;
    
    /**
     * Instancia de ITimbiriche que realiza la funcion del negocio del sistema.
     */
    private ITimbiriche control = new TimbiricheFacade();

    /**
     * Intancia del jugador que juega en este tablero.
     */
    private Jugador jugador;

    /**
     * Instancia que indica que se pico una linea.
     * En pruebas.
     */
    private volatile boolean picado = false;

    /**
     * Cantidad de puntos basada en el tamanio (nJugadores)
     */
    private int cantidadDePuntos;

    /**
     * Tamanio identificado por el numero de jugadores
     */
    private int tamanio;

    /**
     * Distancia entre dos puntos
     */
    private double espaciadoDePuntos;

    /**
     * Tamanio de los puntos dependen de la cantidadDePuntos
     */
    private double tamanioDePuntos;

    private FormaPolygon formaTemp = null;

    /**
     * Variables int globales para la posicion del mouse cuando
     * se da click y cuando se desplaza por el tablero.
     */
    private int clickX, clickY;
    private int mouseX, mouseY;
    
    /**
     * Crea el pnlTablero
     * @param sala
     * @param jugador 
     */
    public PnlTablero(Sala sala, Jugador jugador) {
        initComponents();
        addMouseListener(this);
        addMouseMotionListener(this);
        this.sala = sala;
        this.tamanio = sala.getTablero().getAlto();
        this.jugador = jugador;
    }

    /**
     * Metodo que actualiza las condiciones del tablero.
     */
    @Override
    public void actualizar() {
        estableceTablero();
        this.repaint();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        g2.setBackground(Color.WHITE);

        //Itera en todos los puntos del tablero y los dibuja
        for (Punto punto : this.sala.getTablero().getPuntos()) {
            FormaPolygon puntoPl = new FormaPolygon(punto, Color.BLACK);
            puntoPl.renderizar(g);
        }

        //itera en todas las lineas horizontales del tablero y las dibuja
        for (Linea lineaHorizontal : this.sala.getTablero().getLineasHorizontales()) {
            if(lineaHorizontal.getJugador() != null){
                int turno = this.sala.getMarcador().getJugadores().indexOf(lineaHorizontal.getJugador());
                FormaPolygon puntoPl = new FormaPolygon(lineaHorizontal,
                        Color.decode(this.jugador.getPreferencia().getColores().get(turno)));
                puntoPl.renderizar(g);
            }
        }
        
        //itera en todas las lineas verticales del tablero y las dibuja
        for (Linea lineaVertical : this.sala.getTablero().getLineasVerticales()) {
            if(lineaVertical.getJugador() != null){
                int turno = this.sala.getMarcador().getJugadores().indexOf(lineaVertical.getJugador());
                FormaPolygon puntoPl = new FormaPolygon(lineaVertical, 
                        Color.decode(this.jugador.getPreferencia().getColores().get(turno)));
                puntoPl.renderizar(g);
            }
        }
        
        //FormaTemporal sirve para renderizar la vista previa de la linea
        // que el jugador puede colocar.
        if (formaTemp != null) {
            formaTemp.renderizar(g);
            formaTemp = null;
        }
    }

    /**
     * Metodo que establece las propiedades del tablero y sus Forma
     */
    public void estableceTablero() {
        this.cantidadDePuntos = this.sala.getTablero().getAlto();
        this.espaciadoDePuntos = obtenerEspaciadoDePuntos();
        this.tamanioDePuntos = 200 / this.sala.getTablero().getAlto();
        
        if(this.sala.getTablero().getPuntos().isEmpty()){
            this.sala.getTablero().setPuntos(creaPuntos());
            this.sala.getTablero().setLineasVerticales(creaLineasVerticales());
            this.sala.getTablero().setLineasHorizontales(creaLineasHorizontales());
        }
    }

    /**
     * Regresa el espacio entre los puntos del tablero.
     * Cambia segun la altura del tablero.
     * @return 
     */
    private double obtenerEspaciadoDePuntos() {
        // Para saber el espaciadoDePuntos entre los puntos a dibujar
        // En un tablero de 10x10, es el 92% dividido entre 9
        // En un tablero de 20x20, es el 92% dividido entre 19
        // En un tablero de 40x40, es el 92% dividido entre 39

        switch (this.sala.getTablero().getAlto()) {
            case 10:
                return (getHeight() * .92) / 9;
            case 20:
                return (getHeight() * .92) / 19;
            case 40:
                return (getHeight() * .92) / 39;
            default:
                return 0;
        }
    }

    /**
     * Metodo que genera los puntos segun el tamano del tablero y 
     * retorna una coleccion de ellos.
     * @return 
     */
    public List<Punto> creaPuntos() {
        List<Punto> puntos = new ArrayList<>();
        // Crea los puntos del tablero y los guarda en el arrayList
        // Empieza 3% del tamano total a la derecha y abajo, en la esquina superior izquierda y termina dejando un margen de 3%
        // Doble for, primero para vertical y luego para horizontal
        for (double i = (getHeight() * .03); i <= (getHeight() * .97); i += espaciadoDePuntos) {
            for (double j = (getWidth() * .03); j <= (getWidth() * .97); j += espaciadoDePuntos) {
                //Crea y guarda el punto
                puntos.add(new Punto((int) this.tamanioDePuntos, (int) this.tamanioDePuntos, (int) i, (int) j));
            }
        }
        
        return puntos;
    }

    /**
     * Metodo que crea las lineas verticales del tablero y regresa una
     * coleccion de ellas.
     * @return 
     */
    private List<Linea> creaLineasVerticales() {
        List<Linea> lineasVerticales = new ArrayList<>();
        //Se crean n matrices de n - 1 lineas
        //Donde n es igual al ancho/alto del tablero
        //El cual se determina segun el numero de jugadores (size)

        double altura = (getHeight() * .03);
        for (int i = 0; i < this.cantidadDePuntos; i++) {
            for (double j = (getWidth() * .03); j < ((getWidth() * .97) - this.espaciadoDePuntos); j += espaciadoDePuntos) {
                lineasVerticales.add(new Linea((int) (this.espaciadoDePuntos - this.tamanioDePuntos), (int) this.tamanioDePuntos, (int) (j + this.tamanioDePuntos), (int) altura));
            }
            altura += this.espaciadoDePuntos;
        }
        
        return lineasVerticales;
    }

    private List<Linea> creaLineasHorizontales() {
        List<Linea> lineasHorizontales = new ArrayList<>();
        double anchura = (getWidth() * .03);
        for (int i = 0; i < this.cantidadDePuntos; i++) {
            for (double j = (getHeight() * .03); j < ((getHeight() * .97) - this.espaciadoDePuntos); j += espaciadoDePuntos) {
                lineasHorizontales.add(new Linea((int) this.tamanioDePuntos, (int) (this.espaciadoDePuntos - this.tamanioDePuntos), (int) anchura, (int) (j + this.tamanioDePuntos)));
            }
            anchura += this.espaciadoDePuntos;
        }
        return lineasHorizontales;
    }

    /**
     * Metodo que itera sobre als lineas verticales y horizontales para
     * determinar si el mouse esta sobre una linea o dio click en una.
     * @param locateX
     * @param locateY
     * @param modal 
     */
    private void buscarLinea(int locateX, int locateY, boolean modal) {
        picado = false;
        List<Linea> lineasHorizontales = this.sala.getTablero().getLineasHorizontales();
        List<Linea> lineasVerticales = this.sala.getTablero().getLineasVerticales();
        
        for (int i = 0; i < (lineasHorizontales.size() + lineasVerticales.size()) / 2; i++) {

            Linea lineaVertical = lineasVerticales.get(i);
            Linea lineaHorizontal = lineasHorizontales.get(i);
            
            Color color = Color.decode(this.jugador.getPreferencia().getColores().get(0));

            FormaPolygon formaPlVer = new FormaPolygon(lineaVertical, color);
            FormaPolygon formaPlHor = new FormaPolygon(lineaHorizontal, color);

            if (estaDentroPoligono(formaPlHor, locateX, locateY)) {
                if (modal) {
                    
                    String agregarLinea = control.agregarLinea(lineaHorizontal, jugador);
                    if(!agregarLinea.equalsIgnoreCase("")){
                        JOptionPane.showMessageDialog(this, agregarLinea, "Error de juego", JOptionPane.INFORMATION_MESSAGE);
                        picado = false;
                    }else{
                        picado = true;
                    }
                    return;
                } else {
                    formaTemp = new FormaPolygon(new Linea(
                            lineaHorizontal.getWidth(), 
                            lineaHorizontal.getHeight(), 
                            lineaHorizontal.getX(),
                            lineaHorizontal.getY(),
                            jugador), 
                            color);
                    return;
                }
            }

            if (estaDentroPoligono(formaPlVer, locateX, locateY)) {
                if (modal) {
                    String agregarLinea = control.agregarLinea(lineaVertical, jugador);
                    
                    if(!agregarLinea.equalsIgnoreCase("")){
                        JOptionPane.showMessageDialog(this, agregarLinea, "Error de juego", JOptionPane.INFORMATION_MESSAGE);
                        picado = false;
                    }else{
                        picado = true;
                    }
                    return;
                } else {
                    formaTemp = new FormaPolygon(new Linea(
                            lineaVertical.getWidth(),
                            lineaVertical.getHeight(),
                            lineaVertical.getX(),
                            lineaVertical.getY(), 
                            jugador), 
                            color);
                    return;
                }
            }
        }
    }

    private void creaCuadros() {
        //iterar tamano-1^2
    }

    /**
     * Metodo que indica que la posicion del mouse esta dentro de un poligono.
     * @param forma
     * @param locateX
     * @param locateY
     * @return 
     */
    private boolean estaDentroPoligono(FormaPolygon forma, int locateX, int locateY) {
        int x = forma.getForma().getX();
        int y = forma.getForma().getY();

        int x2 = 0;
        int y2 = 0;
        if (forma.getForma().getHeight() < forma.getForma().getWidth()) {
            x2 = forma.getForma().getX() + (int) espaciadoDePuntos;
            y2 = forma.getForma().getY() + (int) tamanioDePuntos;
        } else {
            x2 = forma.getForma().getX() + (int) tamanioDePuntos;
            y2 = forma.getForma().getY() + (int) espaciadoDePuntos;
        }

        return ((locateX > x && locateX < x2) && (locateY > y && locateY < y2));
    }
    
    public synchronized boolean isPicado(){
        return this.picado;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    @Override
    public void mouseClicked(MouseEvent me) {
        this.clickX = me.getX();
        this.clickY = me.getY();

        System.out.println(clickX + "/" + clickY);

        buscarLinea(clickX, clickY, true);

        repaint();
    }

    @Override
    public void mousePressed(MouseEvent me) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseReleased(MouseEvent me) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseEntered(MouseEvent me) {
        ////throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseExited(MouseEvent me) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseDragged(MouseEvent me) {
        mouseMoved(me);
    }

    @Override
    public void mouseMoved(MouseEvent me) {
        this.mouseX = me.getX();
        this.mouseY = me.getY();

        System.out.println(mouseX + "/" + mouseY);

        buscarLinea(mouseX, mouseY, false);

        repaint();
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}