/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pipesandfilters.Filters;

import Dominio.Cuadro;
import DominioDTO.CuadroDTO;
import pipesandfilters.Pipes.PipeCuadro;

/**
 *
 * @author Alejandro Galindo
 */
class FilterCuadro implements Filter<CuadroDTO, Cuadro, PipeCuadro>{

    @Override
    public void procesar(CuadroDTO objeto) {
    } 
}
