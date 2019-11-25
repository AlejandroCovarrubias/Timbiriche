/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pipesandfilters.Pipes;

import Dominio.Cuadro;
import pipesandfilters.SinkRepo;

/**
 *
 * @author Alejandro Galindo
 */
public class PipeCuadro implements Pipe<Cuadro, SinkRepo> {

    @Override
    public void pasar(Cuadro objeto) {
        SinkRepo sr = SinkRepo.getInstance();
        sr.asignarCuadro(objeto);
    }   
}