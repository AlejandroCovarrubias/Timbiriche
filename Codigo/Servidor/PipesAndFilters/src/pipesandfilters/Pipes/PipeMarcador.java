/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pipesandfilters.Pipes;

import Dominio.Marcador;
import pipesandfilters.SinkRepo;

/**
 *
 * @author Alejandro Galindo
 */
public class PipeMarcador implements Pipe<Marcador, SinkRepo> {

    @Override
    public void pasar(Marcador objeto) {
        SinkRepo sr = SinkRepo.getInstance();
        sr.asignarMarcador(objeto);
    }   
}
