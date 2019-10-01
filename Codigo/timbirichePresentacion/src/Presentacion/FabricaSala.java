/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;

import Dominio.Jugador;
import Dominio.Marcador;
import Dominio.Sala;
import Dominio.Tablero;

/**
 *
 * @author Alejandro Galindo
 */
public class FabricaSala {
    public static ComponenteSala creaSala(Jugador lider, int tamanio){
        Marcador marcador = new Marcador(lider, tamanio);
        Sala sala = new Sala(marcador, tamanio);
        
        FrmSala frmSala = FrmSala.getInstance(sala);
        
        frmSala.agregarComponenteDeSala(new PnlMarcador(sala.getMarcador()));
        frmSala.agregarComponenteDeSala(new PnlTablero(sala.getTablero(), lider));
        frmSala.agregarComponenteDeSala(new PnlOpt());
        
        frmSala.actualizar();
        
        return frmSala;
    }
}
