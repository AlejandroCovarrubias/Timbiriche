/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pipesandfilters;

import Dominio.Cuadro;
import Dominio.Jugador;
import Dominio.Linea;
import Dominio.Sala;
import DominioDTO.CuadroDTO;
import DominioDTO.JugadorDTO;
import DominioDTO.LineaDTO;
import DominioDTO.MarcadorDTO;
import DominioDTO.SalaDTO;
import DominioDTO.TableroDTO;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Alejandro Galindo
 */
public class AccesoRepo implements IRepo {

    private SinkRepo sr = SinkRepo.getInstance();

    @Override
    public SalaDTO obtenerRespuesta() {
        //Obteniendo la sala
        Sala sala = sr.getSala();

        //----- MARCADORDTO -----//
        //Obteniedo la lista de jugadores de la sala
        List<Jugador> jugadores = sala.getMarcador().getJugadores();
        //Lista de JugadorDTO
        List<JugadorDTO> jugadoresDTO = new ArrayList<>();

        //Pasando de una lista de Jugador a JugadorDTO
        for (Jugador jugador : jugadores) {
            jugadoresDTO.add(new JugadorDTO(jugador.getNombre(), jugador.getRutaAvatar(), jugador.getPuntaje()));
        }

        //Instanciando un marcador con la lista y el siguiente en turno
        MarcadorDTO marcadorDTO = new MarcadorDTO(jugadoresDTO, sala.getMarcador().getSiguiente());
        
        
        //----- TABLERODTO -----//
        //Obteniendo las listas de Linea y Cuadro
        List<Linea> lineasHor = sala.getTablero().getLineasHorizontales();
        List<Linea> lineasVer = sala.getTablero().getLineasVerticales();
        List<Cuadro> cuadros = sala.getTablero().getCuadros();

        //Listas de LineaDTO
        List<LineaDTO> horizontalesDTO = new ArrayList<>();
        List<LineaDTO> verticalesDTO = new ArrayList<>();
        List<CuadroDTO> cuadrosDTO = new ArrayList<>();

        for (Linea linea : lineasHor) {
            Jugador jugadorTemp = linea.getJugador();
            if(jugadorTemp != null){
                horizontalesDTO.add(new LineaDTO(linea.getPosicion(), 
                        linea.getIndice(), 
                        new JugadorDTO(jugadorTemp.getNombre(), 
                                jugadorTemp.getRutaAvatar(), 
                                jugadorTemp.getPuntaje())));
            }else{
                horizontalesDTO.add(new LineaDTO(linea.getPosicion(), linea.getIndice()));
            }
        }
        
        for (Linea linea : lineasVer) {
            Jugador jugadorTemp = linea.getJugador();
            if(jugadorTemp != null){
                verticalesDTO.add(new LineaDTO(linea.getPosicion(), 
                        linea.getIndice(), 
                        new JugadorDTO(jugadorTemp.getNombre(), 
                                jugadorTemp.getRutaAvatar(), 
                                jugadorTemp.getPuntaje())));
            }else{
                verticalesDTO.add(new LineaDTO(linea.getPosicion(), linea.getIndice()));
            }
        }
        
        for (Cuadro cuadro : cuadros) {
            Jugador jugadorTemp = cuadro.getJugador();
            if(jugadorTemp != null){
                cuadrosDTO.add(new CuadroDTO(cuadro.getIndice(), 
                        new JugadorDTO(jugadorTemp.getNombre(), 
                                jugadorTemp.getRutaAvatar(), 
                                jugadorTemp.getPuntaje())));
            }else{
                cuadrosDTO.add(new CuadroDTO(cuadro.getIndice(), null));
            }
        }
        
        //----- TABLERODTO -----//
        TableroDTO tableroDTO = new TableroDTO(verticalesDTO, horizontalesDTO, cuadrosDTO);
        
        return new SalaDTO(tableroDTO, marcadorDTO);
    }
}