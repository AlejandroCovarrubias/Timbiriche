/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pipesandfilters.commands;

import DominioDTO.CuadroDTO;
import DominioDTO.JugadorDTO;
import DominioDTO.LineaDTO;
import java.util.List;
import pipesandfilters.IPAF;

/**
 *
 * @author Alejandro Galindo
 */
public class InvocadorPln implements IPAF{
    
    IPAFPipeline comando;

    @Override
    public void crearSala(List<JugadorDTO> jugadores) {
        comando = new CrearSalaPln(jugadores);
        comando.ejecutar();
    }

    @Override
    public void asignarLinea(LineaDTO linea) {
        comando = new AsignarLineaPln(linea);
        comando.ejecutar();
    }

    @Override
    public void asignarCuadro(CuadroDTO cuadro) {
        comando = new AsignarCuadroPln(cuadro);
        comando.ejecutar();
    }

    @Override
    public void retirarJugador(JugadorDTO jugador) {
        comando = new RetirarJugadorPln(jugador);
        comando.ejecutar();
    }   
}