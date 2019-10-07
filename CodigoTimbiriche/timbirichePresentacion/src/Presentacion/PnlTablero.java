/**
 * PnlTablero.java.
 */
package Presentacion;

import Dominio.Cuadro;
import Dominio.Jugador;
import Dominio.Linea;
import Dominio.Punto;
import Dominio.Sala;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.JOptionPane;
import timbirichenegocios.ITimbiriche;
import timbirichenegocios.TimbiricheFacade;

/**
 *
 * @author Alejandro Galindo, Francisco Felix, Cesar Acactitla
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

    private Linea lineaTemp = null;

    /**
     * Crea el pnlTablero
     *
     * @param sala
     * @param jugador
     */
    public PnlTablero(Sala sala, Jugador jugador) {
        initComponents();
        addMouseListener(this);
        addMouseMotionListener(this);
        this.sala = sala;
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

        g2.setBackground(Color.BLACK);

        //Itera en todos los puntos del tablero y los dibuja
        for (Punto punto : this.sala.getTablero().getPuntos()) {
            FormaPolygon puntoPl = new FormaPolygon(punto, Color.BLACK);
            puntoPl.renderizar(g);
        }

        //itera en todas las lineas horizontales del tablero y las dibuja
        for (Linea lineaHorizontal : this.sala.getTablero().getLineasHorizontales()) {
            if (lineaHorizontal.getJugador() != null) {
                int turno = this.sala.getMarcador().getJugadores().indexOf(lineaHorizontal.getJugador());
                FormaPolygon puntoPl = new FormaPolygon(lineaHorizontal,
                        Color.decode(this.jugador.getPreferencia().getColores().get(turno)));
                puntoPl.renderizar(g);
            }
        }

        //itera en todas las lineas verticales del tablero y las dibuja
        for (Linea lineaVertical : this.sala.getTablero().getLineasVerticales()) {
            if (lineaVertical.getJugador() != null) {
                int turno = this.sala.getMarcador().getJugadores().indexOf(lineaVertical.getJugador());
                FormaPolygon puntoPl = new FormaPolygon(lineaVertical,
                        Color.decode(this.jugador.getPreferencia().getColores().get(turno)));
                puntoPl.renderizar(g);
            }
        }
        
        g2.setFont(new Font("TimesRoman", Font.BOLD, 20));
        g2.setColor(Color.black);

        //itera en todos los cuadrados del tablero y los dibuja
        for (Cuadro cuadro : this.sala.getTablero().getCuadros()) {
            if(cuadro.getJugador() != null){
                int turno = this.sala.getMarcador().getJugadores().indexOf(cuadro.getJugador());
                FormaPolygon cuadroPl = new FormaPolygon(cuadro, 
                    Color.decode(this.jugador.getPreferencia().getColores().get(turno)));
                cuadroPl.renderizar(g);
                
                g2.drawString(String.valueOf(cuadro.obtenerInicial()), cuadro.getX() + 20, cuadro.getY() + 20);
                
            }
        }

        // FormaTemporal sirve para renderizar la vista previa de la linea
        // que el jugador puede colocar.
        if (lineaTemp != null) {
            FormaPolygon lineaTempPl = new FormaPolygon(lineaTemp, 
                    Color.decode(this.jugador.getPreferencia().getColores().get(0)));
            lineaTempPl.renderizar(g);
        }
    }

    /**
     * Metodo que establece las propiedades del tablero y sus Forma
     */
    public void estableceTablero() {
        int cantidad = this.sala.getTablero().getDimension();
        int tamanio = 200 / this.sala.getTablero().getDimension();
        double espaciado = UtilesTablero.obtenerEspaciadoDePuntos(cantidad, this.getHeight());

        if (this.sala.getTablero().getPuntos().isEmpty()) {
            //Crea los puntos del tablero utilizando la altura, el ancho,
            //el espaciado que deben tener los puntos del tablero,
            //el tamanio seleccionado y la cantidad de puntos necesaria.
            this.sala.getTablero().setPuntos(
                    UtilesTablero.creaPuntos(this.getHeight(), this.getWidth(),
                            tamanio, espaciado));

            //Crea las lineas horizontales del tablero.
            this.sala.getTablero().setLineasHorizontales(
                    UtilesTablero.creaLineasHorizontales(this.getHeight(),
                            this.getWidth(), tamanio, espaciado, cantidad));

            //Crea las lineas verticales del tablero.
            this.sala.getTablero().setLineasVerticales(
                    UtilesTablero.creaLineasVerticales(this.getHeight(),
                            this.getWidth(), tamanio, espaciado, cantidad));

            //Crea los cuadrados del tablero.
            this.sala.getTablero().setCuadros(
                    UtilesTablero.creaCuadros(
                            this.sala.getTablero().getLineasHorizontales(),
                            this.sala.getTablero().getLineasVerticales(),
                            tamanio, espaciado, cantidad));
        }
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
        int clickX = me.getX();
        int clickY = me.getY();

        System.out.println(clickX + "/" + clickY);

        int cantidad = this.sala.getTablero().getDimension();
        int tamanio = 200 / this.sala.getTablero().getDimension();
        double espaciado = UtilesTablero.obtenerEspaciadoDePuntos(cantidad, this.getHeight());

        Linea lineaEncontrada = UtilesTablero.buscarLinea(clickX, clickY,
                this.sala.getTablero().getLineasHorizontales(),
                this.sala.getTablero().getLineasVerticales(),
                jugador, espaciado, tamanio);

        if (lineaEncontrada != null) {
            String agregarLinea = control.agregarLinea(lineaEncontrada, jugador);
            if (!agregarLinea.equalsIgnoreCase("")) {
                JOptionPane.showMessageDialog(this, "Escoge una linea que no haya sido marcada anteriormente", "Error de juego", JOptionPane.INFORMATION_MESSAGE);
            }else{
                control.verficarMovimiento(this.sala.getTablero().getCuadros(), lineaEncontrada, jugador);
            }
        }

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
        int mouseX = me.getX();
        int mouseY = me.getY();

        System.out.println(mouseX + "/" + mouseY);

        int cantidad = this.sala.getTablero().getDimension();
        int tamanio = 200 / this.sala.getTablero().getDimension();
        double espaciado = UtilesTablero.obtenerEspaciadoDePuntos(cantidad, this.getHeight());

        lineaTemp = UtilesTablero.buscarLinea(mouseX, mouseY,
                this.sala.getTablero().getLineasHorizontales(),
                this.sala.getTablero().getLineasVerticales(),
                jugador, espaciado, tamanio);

        repaint();
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}