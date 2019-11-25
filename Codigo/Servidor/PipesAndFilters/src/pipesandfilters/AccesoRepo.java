/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pipesandfilters;

import DominioDTO.SalaDTO;

/**
 *
 * @author Alejandro Galindo
 */
public class AccesoRepo implements IRepo{
    private SinkRepo sink = SinkRepo.getInstance();

    @Override
    public SalaDTO obtenerRespuesta() {
        return null;
    }
    
}
