/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pipesandfilters.Filters;

import Dominio.Linea;
import DominioDTO.LineaDTO;
import pipesandfilters.Pipes.PipeLinea;

/**
 *
 * @author Alejandro Galindo
 */
public class FilterLinea implements Filter<LineaDTO, Linea, PipeLinea>{

    @Override
    public void procesar(LineaDTO objeto) {
    }
    
}
