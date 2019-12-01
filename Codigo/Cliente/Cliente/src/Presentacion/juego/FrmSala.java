/**
 * FrmSala.java
 */
package presentacion.juego;

import Dominio.Cuadro;
import Dominio.FormaJuego;
import Dominio.Jugador;
import Dominio.Linea;
import Dominio.Marcador;
import Dominio.Sala;
import Dominio.Tablero;
import presentacion.inicio.IActualizable;
import sckCliente.Cliente;
import sckCliente.ICliente;

/**
 *
 * @author Alejandro Galindo, Francisco Felix
 */
public class FrmSala extends javax.swing.JFrame implements PnlObservador, IActualizable{

    /**
     * Instancia de sala que cambia dentro de un hilo.
     */
    private Sala sala;
    
    private Jugador jugador;
    
    private ICliente sck;

    /**
     * Constructor de FrmSala.
     * @param marcador
     * @param jugador
     */
    public FrmSala(Marcador marcador, Jugador jugador) {
        this.jugador = jugador;
        initComponents();
        this.setTitle("Sala de juego - " + jugador.getNombre());
        this.setLocationRelativeTo(null);
        
        this.sck = new Cliente(this.jugador, this);
        
        //Inicializar Sala
        Tablero tablero = new Tablero(marcador.getJugadores().size());
        this.sala = new Sala(marcador, tablero, marcador.getJugadores().size());
        System.out.println(this.sala.toString());
        
        establecerColores();
        establecerMarcador();
        establecerTablero();
    }
    
    private void establecerColores(){
        int index = this.sala.getMarcador().getJugadores().indexOf(this.jugador);
        this.sala.getMarcador().getJugadores().get(index).setColor(this.jugador.getColor());
        
        int indicador = 0;
        for (int i = 0; i < this.sala.getMarcador().getJugadores().size(); i++) {
            if(!this.sala.getMarcador().getJugadores().get(i).equals(this.jugador)){
                this.sala.getMarcador().getJugadores().get(i).setColor(this.jugador.getPreferencia().getColores().get(indicador));
                indicador++;
            }
        }
    }
    
    private void establecerMarcador(){
        for (int i = 0; i < this.sala.getMarcador().getJugadores().size(); i++) {
            switch (i) {
                case 0:
                    pnlJugador1.add(new PnlJugador(this.sala.getMarcador().getJugadores().get(i)));
                    pnlJugador1.revalidate();
                    break;
                case 1:
                    pnlJugador2.add(new PnlJugador(this.sala.getMarcador().getJugadores().get(i)));
                    pnlJugador2.revalidate();
                    break;
                case 2:
                    pnlJugador3.add(new PnlJugador(this.sala.getMarcador().getJugadores().get(i)));
                    pnlJugador3.revalidate();
                    break;
                case 3:
                    pnlJugador4.add(new PnlJugador(this.sala.getMarcador().getJugadores().get(i)));
                    pnlJugador4.revalidate();
                    break;
                default:
                    break;
            }
            
            this.validate();
            
        }
    }

    private void establecerTablero(){
        PnlTablero pnlTablero = new PnlTablero(this.sala.getTablero(), jugador);
        
        pnlTablero.setSize(this.pnlFondoTablero.getSize());
        pnlTablero.setBorder(this.pnlFondoTablero.getBorder());
        this.pnlFondoTablero.add(pnlTablero);
        pnlTablero.estableceTablero();
        pnlTablero.setVisible(true);
        pnlTablero.repaint();
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
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        pnlFondoMarcador = new javax.swing.JPanel();
        pnlJugador1 = new javax.swing.JPanel();
        pnlJugador2 = new javax.swing.JPanel();
        pnlJugador3 = new javax.swing.JPanel();
        pnlJugador4 = new javax.swing.JPanel();
        pnlFondoTablero = new javax.swing.JPanel();
        pnlFondoOpt = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        pnlFondoMarcador.setBackground(new java.awt.Color(255, 175, 77));
        pnlFondoMarcador.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        pnlFondoMarcador.setPreferredSize(new java.awt.Dimension(300, 500));

        pnlJugador1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        pnlJugador1.setMaximumSize(new java.awt.Dimension(278, 80));
        pnlJugador1.setMinimumSize(new java.awt.Dimension(278, 80));

        javax.swing.GroupLayout pnlJugador1Layout = new javax.swing.GroupLayout(pnlJugador1);
        pnlJugador1.setLayout(pnlJugador1Layout);
        pnlJugador1Layout.setHorizontalGroup(
            pnlJugador1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        pnlJugador1Layout.setVerticalGroup(
            pnlJugador1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 80, Short.MAX_VALUE)
        );

        pnlJugador2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        pnlJugador2.setMaximumSize(new java.awt.Dimension(278, 80));
        pnlJugador2.setMinimumSize(new java.awt.Dimension(278, 80));

        javax.swing.GroupLayout pnlJugador2Layout = new javax.swing.GroupLayout(pnlJugador2);
        pnlJugador2.setLayout(pnlJugador2Layout);
        pnlJugador2Layout.setHorizontalGroup(
            pnlJugador2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        pnlJugador2Layout.setVerticalGroup(
            pnlJugador2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 80, Short.MAX_VALUE)
        );

        pnlJugador3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        pnlJugador3.setMaximumSize(new java.awt.Dimension(278, 80));
        pnlJugador3.setMinimumSize(new java.awt.Dimension(278, 80));

        javax.swing.GroupLayout pnlJugador3Layout = new javax.swing.GroupLayout(pnlJugador3);
        pnlJugador3.setLayout(pnlJugador3Layout);
        pnlJugador3Layout.setHorizontalGroup(
            pnlJugador3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        pnlJugador3Layout.setVerticalGroup(
            pnlJugador3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 80, Short.MAX_VALUE)
        );

        pnlJugador4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        pnlJugador4.setMaximumSize(new java.awt.Dimension(278, 80));
        pnlJugador4.setMinimumSize(new java.awt.Dimension(278, 80));

        javax.swing.GroupLayout pnlJugador4Layout = new javax.swing.GroupLayout(pnlJugador4);
        pnlJugador4.setLayout(pnlJugador4Layout);
        pnlJugador4Layout.setHorizontalGroup(
            pnlJugador4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        pnlJugador4Layout.setVerticalGroup(
            pnlJugador4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 80, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout pnlFondoMarcadorLayout = new javax.swing.GroupLayout(pnlFondoMarcador);
        pnlFondoMarcador.setLayout(pnlFondoMarcadorLayout);
        pnlFondoMarcadorLayout.setHorizontalGroup(
            pnlFondoMarcadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFondoMarcadorLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlFondoMarcadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlJugador1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlJugador2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlJugador3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlJugador4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        pnlFondoMarcadorLayout.setVerticalGroup(
            pnlFondoMarcadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFondoMarcadorLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlJugador1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pnlJugador2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pnlJugador3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pnlJugador4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(126, Short.MAX_VALUE))
        );

        pnlFondoTablero.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        pnlFondoTablero.setMaximumSize(new java.awt.Dimension(650, 650));
        pnlFondoTablero.setMinimumSize(new java.awt.Dimension(650, 650));

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

        pnlFondoOpt.setBackground(new java.awt.Color(255, 175, 77));
        pnlFondoOpt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout pnlFondoOptLayout = new javax.swing.GroupLayout(pnlFondoOpt);
        pnlFondoOpt.setLayout(pnlFondoOptLayout);
        pnlFondoOptLayout.setHorizontalGroup(
            pnlFondoOptLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 298, Short.MAX_VALUE)
        );
        pnlFondoOptLayout.setVerticalGroup(
            pnlFondoOptLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 142, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pnlFondoMarcador, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlFondoOpt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlFondoTablero, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pnlFondoTablero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(pnlFondoMarcador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pnlFondoOpt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel pnlFondoMarcador;
    private javax.swing.JPanel pnlFondoOpt;
    private javax.swing.JPanel pnlFondoTablero;
    private javax.swing.JPanel pnlJugador1;
    private javax.swing.JPanel pnlJugador2;
    private javax.swing.JPanel pnlJugador3;
    private javax.swing.JPanel pnlJugador4;
    // End of variables declaration//GEN-END:variables

    @Override
    public void actualiza(FormaJuego forma) {
        if(forma instanceof Linea){
            sck.enviarAlServidor((Linea) forma);
        }else if(forma instanceof Cuadro){
            sck.enviarAlServidor((Cuadro) forma);
        }
    }

    @Override
    public void actualizaDeSocket(Object mensaje) {
        
    }
}