/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pipesandfilters;

import Dominio.Cuadro;
import Dominio.Jugador;
import Dominio.Linea;
import Dominio.Marcador;
import DominioDTO.CuadroDTO;
import DominioDTO.JugadorDTO;
import DominioDTO.LineaDTO;
import DominioDTO.MarcadorDTO;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Alejandro Galindo
 */
public class AccesoRepo implements IRepo {

    private SinkRepo sr = SinkRepo.getInstance();

    @Override
    public MarcadorDTO obtenerMarcador() {
        Marcador marcador = sr.obtenerMarcador();

        List<JugadorDTO> jugadoresDTO = new ArrayList<>();
        for (Jugador jugador : marcador.getJugadores()) {
            jugadoresDTO.add(new JugadorDTO(jugador.getNombre(), jugador.getRutaAvatar(), jugador.getPuntaje()));
        }
        MarcadorDTO marcadorDTO = new MarcadorDTO(jugadoresDTO);

        return marcadorDTO;
    }

    @Override
    public LineaDTO obtenerUltimaLinea() {
        Linea linea = sr.obtenerUltimaLinea();
        if (linea != null) {
            LineaDTO lineaDTO
                    = new LineaDTO(
                            linea.getPosicion().toString(),
                            linea.getIndice(),
                            new JugadorDTO(
                                    linea.getJugador().getNombre(),
                                    linea.getJugador().getRutaAvatar(),
                                    linea.getJugador().getPuntaje()));
            return lineaDTO;
        }else{
            return null;
        }
    }

    @Override
    public CuadroDTO obtenerUltimoCuadro() {
        Cuadro cuadro = sr.obtenerUltimoCuadro();
        CuadroDTO cuadroDTO
                = new CuadroDTO(cuadro.getIndice(),
                        new JugadorDTO(cuadro.getJugador().getNombre(),
                                cuadro.getJugador().getRutaAvatar(),
                                cuadro.getJugador().getPuntaje()));

        return cuadroDTO;
    }

    @Override
    public int obtenerTurnoSiguiente() {
        return sr.obtenerTurnoSiguiente();
    }
}
