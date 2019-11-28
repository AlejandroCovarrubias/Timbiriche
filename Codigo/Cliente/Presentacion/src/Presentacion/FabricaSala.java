/**
 * FabricaSala.java
 */
package Presentacion;

import Dominio.Jugador;
import Dominio.Marcador;
import Dominio.Sala;

/**
 * Intento de Factory Pattern que se encarga de crear la instancia
 * adecuada de FrmSala.
 * 
 * @author Alejandro Galindo, Francisco Félix
 */
public class FabricaSala {
    
    /**
     * Crea una sala nueva.
     * @param lider
     * @param tamanio
     * @return 
     */
    public ComponenteSala creaSala(Jugador lider, int tamanio){
        //Crea un marcador
        Marcador marcador = null;
//        Marcador marcador = new Marcador(lider, tamanio);
        
        //Manda crear la sala a negocio (Porque la creacion de mi sala puede 
        //depender de otros factores futuros, como guardar la sala? en algun
        //sitio)
        Sala sala = null;
        
        //Crea mi frm de sala
        FrmSala frmSala = new FrmSala(sala);
        
        //Lo compone
        frmSala.agregarComponenteDeSala(new PnlMarcador(sala));
        frmSala.agregarComponenteDeSala(new PnlTablero(sala, lider));
        frmSala.agregarComponenteDeSala(new PnlOpt(lider, frmSala));
        
        //Lo manda a actualizar
        //frmSala.actualizar();
        
        //Retorna el frmSala
        //return frmSala;
        return null;
    }
}
