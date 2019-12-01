/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pipesandfilters.Filters;

import Dominio.Tablero;
import pipesandfilters.Pipes.PipeTablero;

/**
 *
 * @author Alejandro Galindo
 */
public class FilterTablero implements Filter<Integer, Tablero, PipeTablero>{

    @Override
    public void procesar(Integer objeto) {
        //
        Tablero tablero = new Tablero(objeto);
        tablero.generaInstanciasDeFormaJuego();
        PipeTablero pt = new PipeTablero();
        pt.pasar(tablero);
    } 
}
