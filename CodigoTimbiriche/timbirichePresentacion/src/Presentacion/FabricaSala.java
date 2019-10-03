/**
 * FabricaSala.java
 */
package Presentacion;

import Dominio.Jugador;
import Dominio.Marcador;
import Dominio.Sala;
import timbirichenegocios.ITimbiriche;
import timbirichenegocios.TimbiricheFacade;

/**
 * Intento de Factory Pattern que se encarga de crear la instancia
 * adecuada de FrmSala.
 * 
 * @author Alejandro Galindo
 */
public class FabricaSala {
    
    /**
     * Instancia de ITimbiriche de Negocios.
     */
    ITimbiriche control = new TimbiricheFacade();
    
    /**
     * Crea una sala nueva.
     * @param lider
     * @param tamanio
     * @return 
     */
    public ComponenteSala creaSala(Jugador lider, int tamanio){
        //Crea un marcador
        Marcador marcador = new Marcador(lider, tamanio);
        
        //Manda crear la sala a negocio (Porque la creacion de mi sala puede 
        //depender de otros factores futuros, como guardar la sala? en algun
        //sitio)
        Sala sala = control.crearSala(marcador, tamanio);
        
        //Crea mi frm de sala
        FrmSala frmSala = FrmSala.getInstance(sala);
        
        //Lo compone
        frmSala.agregarComponenteDeSala(new PnlMarcador(sala));
        frmSala.agregarComponenteDeSala(new PnlTablero(sala, lider));
        frmSala.agregarComponenteDeSala(new PnlOpt());
        
        //Lo manda a actualizar
        frmSala.actualizar();
        
        //Retorna el frmSala
        return frmSala;
    }
}
