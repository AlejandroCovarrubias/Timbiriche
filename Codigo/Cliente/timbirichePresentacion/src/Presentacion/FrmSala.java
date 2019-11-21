/**
 * FrmSala.java
 */
package Presentacion;

import Dominio.Jugador;
import Dominio.Linea;
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
 * @author Alejandro Galindo, Francisco Felix
 */
public class FrmSala extends javax.swing.JFrame implements Runnable, PnlObr{

    /**
     * Instancia de la fachada de negocio.
     */
    private ITimbiriche timbiriche = new TimbiricheFacade();

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
     * @param sala
     */
    public FrmSala(Sala sala) {
        initComponents();
        this.setTitle("Sala de juego");
        this.setLocationRelativeTo(null);
        this.sala = sala;
        this.componentesDeSala = new ArrayList<>();
        this.pnlsDeFondo = new ArrayList<>();
        this.pnlsDeFondo.add(pnlFondoMarcador);
        this.pnlsDeFondo.add(pnlFondoTablero);
        this.pnlsDeFondo.add(pnlFondoOpt);
        iniciarSala(sala);
    }

    /**
     * Metodo que agrega ComponenteSala hasta que ya no haya paneles de fondo
     * establecidos en FrmSala.
     *
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
     *
     * @return
     */
    public Sala getSala() {
        return sala;
    }

    /**
     * Establece la sala de trabajo.
     *
     * @param sala
     */
    public void setSala(Sala sala) {
        this.sala = sala;
    }
    
    @Override
    public void actualizar(Linea linea) {
        
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
     * Hilo de la Sala. Simula la entrada de jugadores a la sala
     */
    @Override
    public void run() {
        this.pnlFondoTablero.getComponent(0).setVisible(false);
        //Label de tiempo? aun no implementado
        this.lblTimer.setText("NT");
        //Mientras la sala no este llena
        Jugador[] jugs = null;
        while (this.sala.getJugadores().size() < this.sala.getTamanio()) {
            //Busca jugadores?
            jugs = this.timbiriche.buscarJugadores(this.sala);
            
            //Si los encuentra, los agrega.
            if (jugs != null) {
                this.lblInfo.setText(jugs[0].getNombre() + " ha entrado a la partida.  ");
                this.sala.agregarJugador(jugs[0]);
                ((PnlMarcador) this.pnlFondoMarcador.getComponent(0)).actualizar();
            }
            try {
                //nomas pa animar
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(FrmSala.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        this.lblInfo.setText("¡A jugar!  ");
        
        this.pnlFondoTablero.getComponent(0).setVisible(true);

        timbiriche.turnarJugadores(this.sala.getMarcador());
        ((PnlMarcador) this.pnlFondoMarcador.getComponent(0)).establecerColoresPreferenciales();
        ((PnlMarcador) this.pnlFondoMarcador.getComponent(0)).actualizar();
    }

    /**
     * Establece la sala por primera vez
     * 
     * @param sala 
     */
    public void iniciarSala(Sala sala){
        agregarComponenteDeSala(new PnlMarcador(sala));
        agregarComponenteDeSala(new PnlTablero(sala, sala.getJugadores().get(0)));
        agregarComponenteDeSala(new PnlOpt(sala.getJugadores().get(0), this));
        
        establecerComponentesDeSala();
    }
}