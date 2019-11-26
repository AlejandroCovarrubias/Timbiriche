/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pipesandfilters.Pipes;

import pipesandfilters.Filters.FilterTablero;

/**
 *
 * @author Alejandro Galindo
 */
public class PipeTamanio implements Pipe<Integer, FilterTablero>{

    @Override
    public void pasar(Integer objeto) {
        FilterTablero ft = new FilterTablero();
        ft.procesar(objeto);
    }
    
}
