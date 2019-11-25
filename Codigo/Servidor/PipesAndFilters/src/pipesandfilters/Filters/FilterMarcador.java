/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pipesandfilters.Filters;

import Dominio.Jugador;
import Dominio.Marcador;
import java.util.List;
import pipesandfilters.Pipes.PipeMarcador;

/**
 *
 * @author Alejandro Galindo
 */
public class FilterMarcador implements Filter<List<Jugador>, Marcador, PipeMarcador>{

    @Override
    public void procesar(List<Jugador> objeto) {
        Marcador marcador = new Marcador(objeto);
        PipeMarcador pm = new PipeMarcador();
        pm.pasar(marcador);
    }   
}