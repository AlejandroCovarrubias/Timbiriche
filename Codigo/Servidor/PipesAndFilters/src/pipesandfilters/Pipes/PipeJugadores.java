/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pipesandfilters.Pipes;

import Dominio.Jugador;
import java.util.List;
import pipesandfilters.Filters.FilterMarcador;

/**
 *
 * @author Alejandro Galindo
 */
public class PipeJugadores implements Pipe<List<Jugador>, FilterMarcador>{

    @Override
    public void pasar(List<Jugador> objeto) {
        FilterMarcador fm = new FilterMarcador();
        fm.procesar(objeto);
    }
}