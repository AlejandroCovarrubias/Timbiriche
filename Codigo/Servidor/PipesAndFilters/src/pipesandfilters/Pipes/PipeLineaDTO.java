/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pipesandfilters.Pipes;

import DominioDTO.LineaDTO;
import pipesandfilters.Filters.FilterLinea;

/**
 *
 * @author Alejandro Galindo
 */
public class PipeLineaDTO implements Pipe<LineaDTO, FilterLinea>{

    @Override
    public void pasar(LineaDTO objeto) {
        FilterLinea fl = new FilterLinea();
        fl.procesar(objeto);
    }   
}