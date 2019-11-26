/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pipesandfilters.Filters;

import Dominio.Cuadro;
import Dominio.Jugador;
import Dominio.Linea;
import DominioDTO.CuadroDTO;
import pipesandfilters.Pipes.PipeCuadro;

/**
 *
 * @author Alejandro Galindo
 */
public class FilterCuadro implements Filter<CuadroDTO, Cuadro, PipeCuadro>{

    @Override
    public void procesar(CuadroDTO objeto) {
        Jugador jugador = new Jugador(objeto.getJugador().getNombreJugador(), objeto.getJugador().getRutaAvatar());
        
        Cuadro cuadro = new Cuadro(jugador, objeto.getIndice());
        PipeCuadro pc = new PipeCuadro();
        pc.pasar(cuadro);
    } 
}
