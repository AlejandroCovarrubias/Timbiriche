/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sckServer;

import DominioDTO.CuadroDTO;
import DominioDTO.JugadorDTO;
import DominioDTO.LineaDTO;
import DominioDTO.MensajeSockets;
import DominioDTO.MovimientoDTO;
import DominioDTO.RespuestaDTO;
import java.util.List;
import pipesandfilters.AccesoRepo;
import pipesandfilters.IPAF;
import pipesandfilters.IRepo;
import pipesandfilters.commands.InvocadorPln;

/**
 *
 * @author Alejandro Galindo
 */
public class SckServerProtocol {

    private IPAF ipaf;
    private IRepo repo;

    public SckServerProtocol() {
        this.ipaf = new InvocadorPln();
        this.repo = new AccesoRepo();
    }

    public Object procesarEntrada(Object mensajeEntrante) {

        //Si despues de realizada la conexion, el socket del cliente manda los
        //datos del jugador, le avisa al Thread que efectivamente son los datos
        if (mensajeEntrante instanceof JugadorDTO) {
            return MensajeSockets.JUGADOR_NUEVO;

            //Si se reciben los datos de un MovimientoDTO, se manda al componente 
            //PipesAndFilters para realizar la conversion correspondiente, asignar 
            //y obtener respuesta
        } else if (mensajeEntrante instanceof MovimientoDTO) {
            MovimientoDTO movimiento = (MovimientoDTO) mensajeEntrante;
            
            if(movimiento.getLinea() != null){
                ipaf.asignarLinea(movimiento.getLinea());
            }else if(movimiento.getCuadros() != null){
                for (CuadroDTO cuadro : movimiento.getCuadros()) {
                    ipaf.asignarCuadro(cuadro);
                }
            }
            
            RespuestaDTO respuesta = new RespuestaDTO(movimiento, repo.obtenerMarcador());
            return respuesta;
            
            //Si un cliente vota, se verifica y se manda respuesta
        } else if (mensajeEntrante == MensajeSockets.VOTO) {
            return MensajeSockets.VOTO;
        } else if (mensajeEntrante == MensajeSockets.TURNO_TERMINADO) {
            return repo.obtenerTurnoSiguiente();
        } else if (mensajeEntrante == MensajeSockets.MARCADOR) {
            return repo.obtenerMarcador();
        }

        return null;
    }

    public Object empezarPartida(List<JugadorDTO> jugadoresDTO) {
        ipaf.crearSala(jugadoresDTO);
        return repo.obtenerMarcador();
    }
}
