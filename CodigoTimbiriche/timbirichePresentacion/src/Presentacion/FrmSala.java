/**
 * FrmSala.java
 */
package Presentacion;

import Dominio.Jugador;
import Dominio.Sala;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;
import timbirichenegocios.ITimbiriche;
import timbirichenegocios.TimbiricheFacade;

/**
 *
 * @author Alejandro Galindo, Francisco Felix, Cesar Acactitla
 */
public class FrmSala extends javax.swing.JFrame implements ComponenteSala, Runnable {

    /**
     * Instancia de la fachada de negocio.
     */
    private ITimbiriche timbiriche = new TimbiricheFacade();

    /**
     * Instancia de si misma.
     */
    private static FrmSala instance;
    
    /**
     * Instancia de sala que cambia dentro de un hilo.
     */
    private volatile Sala sala;
    
    /**
     * Coleccion de los paneles donde son colocados los ComponentesSala.
     */
    private List<JPanel> pnlsDeFondo;
    
    /**
     * Coleccion de ComponentesSala que componen al Compuesto FrmSala.
     */
    private List<ComponenteSala> componentesDeSala;

    /**
     * Constructor de FrmSala.
     */
    private FrmSala(Sala sala) {
        initComponents();
        this.setTitle("Sala de juego");
        this.setLocationRelativeTo(null);
        this.sala = sala;
        this.componentesDeSala = new ArrayList<>();
        this.pnlsDeFondo = new ArrayList<>();
        this.pnlsDeFondo.add(pnlFondoMarcador);
        this.pnlsDeFondo.add(pnlFondoTablero);
        this.pnlsDeFondo.add(pnlFondoOpt);

    }

    /**
     * Metodo estatico que regresa la unica instancia de FrmSala.
     * Si esta instancia no ha sido creada, la crea.
     * @param sala
     * @return 
     */
    public static FrmSala getInstance(Sala sala) {
        if (instance == null) {
            instance = new FrmSala(sala);
        }
        return instance;
    }

    /**
     * Metodo que agrega ComponenteSala hasta que ya no haya paneles de fondo
     * establecidos en FrmSala.
     * @param componente 
     */
    public void agregarComponenteDeSala(ComponenteSala componente) {
        if (this.pnlsDeFondo.size() > this.componentesDeSala.size()) {
            this.componentesDeSala.add(componente);
        }
    }

    /**
     * Establece los ComponenteSala en sus respectivos paneles de fondo.
     */
    private void establecerComponentesDeSala() {
        for (int i = 0; i < this.pnlsDeFondo.size(); i++) {
            JPanel pnlTemp = (JPanel) this.componentesDeSala.get(i);

            pnlTemp.setSize(this.pnlsDeFondo.get(i).getSize());
            pnlTemp.setBorder(this.pnlsDeFondo.get(i).getBorder());
            this.pnlsDeFondo.get(i).add(pnlTemp);

            ((ComponenteSala) pnlTemp).actualizar();
            pnlTemp.setVisible(true);
            pnlTemp.repaint();
        }
    }

    /**
     * Retorna la sala que se esta trabajando.
     * @return 
     */
    public Sala getSala() {
        return sala;
    }

    /**
     * Establece la sala de trabajo.
     * @param sala 
     */
    public void setSala(Sala sala) {
        this.sala = sala;
    }

    /**
     * Actualiza los componentes de sala.
     */
    @Override
    public void actualizar() {
        establecerComponentesDeSala();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlFondoMarcador = new javax.swing.JPanel();
        pnlFondoTablero = new javax.swing.JPanel();
        pnlFondoOpt = new javax.swing.JPanel();
        lblTimer = new javax.swing.JLabel();
        lblInfo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pnlFondoMarcador.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        pnlFondoMarcador.setPreferredSize(new java.awt.Dimension(300, 500));

        javax.swing.GroupLayout pnlFondoMarcadorLayout = new javax.swing.GroupLayout(pnlFondoMarcador);
        pnlFondoMarcador.setLayout(pnlFondoMarcadorLayout);
        pnlFondoMarcadorLayout.setHorizontalGroup(
            pnlFondoMarcadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 298, Short.MAX_VALUE)
        );
        pnlFondoMarcadorLayout.setVerticalGroup(
            pnlFondoMarcadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 498, Short.MAX_VALUE)
        );

        pnlFondoTablero.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        pnlFondoTablero.setMaximumSize(new java.awt.Dimension(650, 650));
        pnlFondoTablero.setMinimumSize(new java.awt.Dimension(650, 650));
        pnlFondoTablero.setPreferredSize(new java.awt.Dimension(650, 650));

        javax.swing.GroupLayout pnlFondoTableroLayout = new javax.swing.GroupLayout(pnlFondoTablero);
        pnlFondoTablero.setLayout(pnlFondoTableroLayout);
        pnlFondoTableroLayout.setHorizontalGroup(
            pnlFondoTableroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 648, Short.MAX_VALUE)
        );
        pnlFondoTableroLayout.setVerticalGroup(
            pnlFondoTableroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 648, Short.MAX_VALUE)
        );

        pnlFondoOpt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout pnlFondoOptLayout = new javax.swing.GroupLayout(pnlFondoOpt);
        pnlFondoOpt.setLayout(pnlFondoOptLayout);
        pnlFondoOptLayout.setHorizontalGroup(
            pnlFondoOptLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        pnlFondoOptLayout.setVerticalGroup(
            pnlFondoOptLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        lblTimer.setBackground(new java.awt.Color(255, 255, 255));
        lblTimer.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        lblTimer.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTimer.setText("60");
        lblTimer.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lblTimer.setMaximumSize(new java.awt.Dimension(70, 70));
        lblTimer.setMinimumSize(new java.awt.Dimension(70, 70));
        lblTimer.setPreferredSize(new java.awt.Dimension(70, 70));

        lblInfo.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblInfo.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblInfo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblTimer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblInfo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(pnlFondoMarcador, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(pnlFondoOpt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pnlFondoTablero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblTimer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblInfo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pnlFondoTablero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(pnlFondoMarcador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pnlFondoOpt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lblInfo;
    private javax.swing.JLabel lblTimer;
    private javax.swing.JPanel pnlFondoMarcador;
    private javax.swing.JPanel pnlFondoOpt;
    private javax.swing.JPanel pnlFondoTablero;
    // End of variables declaration//GEN-END:variables

    /**
     * Hilo de la Sala, establece un contador de 60 segundos mientas "escucha"
     * a que se unan jugadores.
     */
    @Override
    public void run() {
        this.pnlFondoTablero.getComponent(0).setVisible(false);
        this.lblTimer.setText("60");

        //Esto pasa de momento
        //Pero esto solo debe pasar en el cliente?
        //Supongo que dependera de la arquitectura
        //Pero los otros nodos conectados que no sean lideres no deben escuchar?
        int i = 59;
        while (i >= 0) {
            try {
                Thread.sleep(1000);

                Jugador[] jugs = null;

                //Mientras la sala no este llena
                if (this.sala.getJugadores().size() < this.sala.getTamanio()) {
                    //Vamos a suponer que durante 60 segundos se busca por jugadores
                    //Al segundo 50 se recibio un jugador
                    if (i == 50) {
                        jugs = this.timbiriche.buscarJugadores(this.sala);
                    }

                    //Al 35 un tercero
                    if (i == 35) {
                        jugs = this.timbiriche.buscarJugadores(this.sala);
                    }

                    //Al 22 un cuarto y ultimo
                    if (i == 22) {
                        jugs = this.timbiriche.buscarJugadores(this.sala);
                    }
                } else {
                    //En cuanto la sala se llena, se desordenan los jugadores?
                    //y empieza la partida
                    //Esto lo deberia hacer control

                    //this.sala.getMarcador().turnar();
                    //((PnlMarcador) this.pnlFondoMarcador.getComponent(0)).actualizar();
                    this.lblInfo.setText("¡A jugar!  ");
                    i = 0;
                }

                if (jugs != null) {
                    this.lblInfo.setText(jugs[0].getNombre() + " ha entrado a la partida.  ");
                    this.sala.agregarJugador(jugs[0]);
                    ((PnlMarcador) this.pnlFondoMarcador.getComponent(0)).actualizar();
                }

                this.lblTimer.setText(Integer.toString(i));
                i--;
            } catch (InterruptedException ex) {
                Logger.getLogger(FrmSala.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        this.pnlFondoTablero.getComponent(0).setVisible(true);
        
// Experimiento de partida
//        for (int j = 0; j < this.sala.getMarcador().getJugadores().size(); j++) {
//            if (j == 0) {
//                int lineas = this.sala.getTablero().getLineasHorizontales().size() + this.sala.getTablero().getLineasVerticales().size();
//                int time = 10;
//
//                while (time > 0) {
//                    this.lblTimer.setText(time + "");
//                    
//                    if(lineas < timbiriche.cantidadDeLineasConJugador(this.sala.getTablero())){
//                        break;
//                    }
//                    
//                    time--;
//                }
//            } else {
//                timbiriche.buscarMovimiento(this.sala.getTablero(), this.sala.getMarcador(), i);
//                ((PnlTablero) this.pnlFondoTablero.getComponent(0)).actualizar();
//            }
//            
//            if(j+1 == this.sala.getMarcador().getJugadores().size()){
//                j = 0;
//            }
//        }
    }
}