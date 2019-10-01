/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;

import Dominio.Cuadro;
import Dominio.Forma;
import Dominio.Jugador;
import Dominio.Linea;
import Dominio.Punto;
import Dominio.Tablero;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Alejandro Galindo
 */
public class PnlTablero extends javax.swing.JPanel implements ComponenteSala, MouseListener, MouseMotionListener {

    /**
     * Tablero que se dibuja
     */
    private Tablero tablero;
    private List<Punto> puntos = new ArrayList<>();
    private List<Cuadro> cuadros = new ArrayList<>();
    private List<Linea> lineasHorizontales = new ArrayList<>();
    private List<Linea> lineasVerticales = new ArrayList<>();

    private Jugador jugador;
    private int turno;

    private Map<Forma, Integer> mapa;

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

    private int clickX;
    private int clickY;

    private int mouseX;
    private int mouseY;

    public PnlTablero(Tablero tablero, Jugador jugador) {
        initComponents();
        addMouseListener(this);
        addMouseMotionListener(this);
        this.tablero = tablero;
        this.tamanio = tablero.getAlto();
        this.jugador = jugador;
        this.puntos = new ArrayList<>();
        this.lineasVerticales = new ArrayList<>();
        this.lineasHorizontales = new ArrayList<>();
        this.cuadros = new ArrayList<>();
        this.mapa = new HashMap<>();
    }

    @Override
    public void actualizar() {
        estableceTablero();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        g2.setBackground(Color.WHITE);

        for (Punto punto : puntos) {
            FormaPolygon puntoPl = new FormaPolygon(Color.BLACK, punto);
            puntoPl.renderizar(g);
        }

        for (Map.Entry<Forma, Integer> entry : mapa.entrySet()) {
            FormaPolygon lineaPl = new FormaPolygon(
                    Color.decode(this.jugador.getPreferencia().getColores().get(entry.getValue())),
                    entry.getKey());
            lineaPl.renderizar(g);
        }

//        for (Linea punto : lineasHorizontales) {
//            FormaPolygon puntoPl = new FormaPolygon(Color.BLACK, punto);
//            puntoPl.renderizar(g);
//        }
//        
//        for (Linea punto : lineasVerticales) {
//            FormaPolygon puntoPl = new FormaPolygon(Color.BLACK, punto);
//            puntoPl.renderizar(g);
//        }
        if (formaTemp != null) {
            formaTemp.renderizar(g);
            formaTemp = null;
        }
    }

    private void estableceTablero() {
        this.cantidadDePuntos = this.tablero.getAlto();
        this.espaciadoDePuntos = obtenerEspaciadoDePuntos();
        this.tamanioDePuntos = 200 / this.tablero.getAlto();
        creaPuntos();
        creaLineasVerticales();
        creaLineasHorizontales();
    }

    private double obtenerEspaciadoDePuntos() {
        // Para saber el espaciadoDePuntos entre los puntos a dibujar
        // En un tablero de 10x10, es el 92% dividido entre 9
        // En un tablero de 20x20, es el 92% dividido entre 19
        // En un tablero de 40x40, es el 92% dividido entre 39

        switch (this.tablero.getAlto()) {
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

    public void creaPuntos() {
        // Crea los puntos del tablero y los guarda en el arrayList
        // Empieza 3% del tamano total a la derecha y abajo, en la esquina superior izquierda y termina dejando un margen de 3%
        // Doble for, primero para vertical y luego para horizontal
        for (double i = (getHeight() * .03); i <= (getHeight() * .97); i += espaciadoDePuntos) {
            for (double j = (getWidth() * .03); j <= (getWidth() * .97); j += espaciadoDePuntos) {
                //Crea y guarda el punto
                this.puntos.add(new Punto((int) this.tamanioDePuntos, (int) this.tamanioDePuntos, (int) i, (int) j));
            }
        }
    }

    private void creaLineasVerticales() {
        //Se crean n matrices de n - 1 lineas
        //Donde n es igual al ancho/alto del tablero
        //El cual se determina segun el numero de jugadores (size)

        double altura = (getHeight() * .03);
        for (int i = 0; i < this.cantidadDePuntos; i++) {
            for (double j = (getWidth() * .03); j < ((getWidth() * .97) - this.espaciadoDePuntos); j += espaciadoDePuntos) {
                this.lineasVerticales.add(new Linea(false, (int) (espaciadoDePuntos - this.tamanioDePuntos), (int) this.tamanioDePuntos, (int) (j + this.tamanioDePuntos), (int) altura));
            }
            altura += this.espaciadoDePuntos;
        }
    }

    private void creaLineasHorizontales() {
        double anchura = (getWidth() * .03);
        for (int i = 0; i < this.cantidadDePuntos; i++) {
            for (double j = (getHeight() * .03); j < ((getHeight() * .97) - this.espaciadoDePuntos); j += espaciadoDePuntos) {
                this.lineasHorizontales.add(new Linea(false, (int) this.tamanioDePuntos, (int) (espaciadoDePuntos - this.tamanioDePuntos), (int) anchura, (int) (j + this.tamanioDePuntos)));
            }
            anchura += this.espaciadoDePuntos;
        }
    }

    private void buscarLinea(int locateX, int locateY, boolean modal) {

        for (int i = 0; i < (lineasHorizontales.size() + lineasVerticales.size()) / 2; i++) {

            Linea lineaVertical = lineasVerticales.get(i);
            Linea lineaHorizontal = lineasHorizontales.get(i);

            FormaPolygon formaPlVer = new FormaPolygon(Color.YELLOW, lineaVertical);
            FormaPolygon formaPlHor = new FormaPolygon(Color.yellow, lineaHorizontal);
            
//            if(this.mapa.containsKey(lineaVertical) || this.mapa.containsKey(lineaHorizontal)){
//                return;
//            }

            if (estaDentroPoligono(formaPlHor, locateX, locateY)) {
                if (modal) {
                    mapa.put(lineaHorizontal, this.turno);
                } else {
                    formaTemp = new FormaPolygon(Color.decode(jugador.getPreferencia().getColores().get(turno)), new Linea(false,
                            lineaHorizontal.getWidth(),
                            lineaHorizontal.getHeight(),
                            lineaHorizontal.getX(),
                            lineaHorizontal.getY()));
                    return;
                }
            }

            if (estaDentroPoligono(formaPlVer, locateX, locateY)) {
                if (modal) {
                    mapa.put(lineaVertical, this.turno);
                } else {
                    formaTemp = new FormaPolygon(Color.decode(jugador.getPreferencia().getColores().get(turno)), new Linea(false,
                            lineaVertical.getWidth(),
                            lineaVertical.getHeight(),
                            lineaVertical.getX(),
                            lineaVertical.getY()));
                    return;
                }
            }
        }
    }

    private void creaCuadros() {
        //iterar tamano-1^2
    }

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
