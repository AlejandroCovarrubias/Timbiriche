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
        Linea superior = new Linea(objeto.getSuperior().getPosicion(), jugador, objeto.getSuperior().getIndice());
        Linea inferior = new Linea(objeto.getInferior().getPosicion(), jugador, objeto.getInferior().getIndice());
        Linea izquierda = new Linea(objeto.getIzquierda().getPosicion(), jugador, objeto.getIzquierda().getIndice());
        Linea derecha = new Linea(objeto.getDerecha().getPosicion(), jugador, objeto.getDerecha().getIndice());
        
        Cuadro cuadro = new Cuadro(superior, inferior, izquierda, derecha, jugador, objeto.getIndice(), 0, 0, 0, 0);
        PipeCuadro pc = new PipeCuadro();
        pc.pasar(cuadro);
    } 
}
