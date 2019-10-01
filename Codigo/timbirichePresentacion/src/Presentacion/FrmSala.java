/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;

import Dominio.Jugador;
import Dominio.Sala;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;

/**
 *
 * @author Alejandro Galindo
 */
public class FrmSala extends javax.swing.JFrame implements ComponenteSala, Runnable {

    private static FrmSala instance;
    private Sala sala;
    private List<JPanel> pnlsDeFondo;
    private List<ComponenteSala> componentesDeSala;
    
    /**
     * Creates new form FrmSala
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
    
    public static FrmSala getInstance(Sala sala){
        if(instance == null){
            instance = new FrmSala(sala);
        }
        return instance;
    }
    
    public void agregarComponenteDeSala(ComponenteSala componente){
        if(this.pnlsDeFondo.size() > this.componentesDeSala.size()){
            this.componentesDeSala.add(componente);
        }
    }
    
    private void establecerComponentesDeSala(){
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

    public Sala getSala() {
        return sala;
    }

    public void setSala(Sala sala) {
        this.sala = sala;
    }
    
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
        jLabel1 = new javax.swing.JLabel();

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

        jLabel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

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
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lblTimer;
    private javax.swing.JPanel pnlFondoMarcador;
    private javax.swing.JPanel pnlFondoOpt;
    private javax.swing.JPanel pnlFondoTablero;
    // End of variables declaration//GEN-END:variables

    @Override
    public void run() {
        this.pnlFondoTablero.getComponent(0).setVisible(false);
        this.lblTimer.setText("60");
        Thread frmMarcador = new Thread(((PnlMarcador) this.pnlFondoMarcador.getComponent(0)));
        
        
        int i = 59;
        while(i > 0){
            try {
                Thread.sleep(1000);
                this.lblTimer.setText(Integer.toString(i));
                i--;
                
                if(i <= 45){
                    this.sala.getMarcador().agregarJugador(new Jugador("Jugador2", "pollitoEnojado.png"));
                    ((PnlMarcador) this.pnlFondoMarcador.getComponent(0)).setMarcador(this.sala.getMarcador());
                    
                }
                
            } catch (InterruptedException ex) {
                Logger.getLogger(FrmSala.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        this.pnlFondoTablero.getComponent(0).setVisible(true);
    }
}