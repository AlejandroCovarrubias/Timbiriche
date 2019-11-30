/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sckServer;

import DominioDTO.CuadroDTO;
import DominioDTO.JugadorDTO;
import DominioDTO.LineaDTO;
import DominioDTO.SalaDTO;
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
    
    public SckServerProtocol(){
        this.ipaf = new InvocadorPln();
        this.repo = new AccesoRepo();
    }
    
    public Object procesarEntrada(Object mensajeEntrante, JugadorDTO jugador){
        if(mensajeEntrante instanceof JugadorDTO){
            JugadorDTO jugadorP = jugador;
            return "Jugador";
        }else if(mensajeEntrante instanceof LineaDTO){
            LineaDTO lineaP = (LineaDTO) mensajeEntrante;
            ipaf.asignarLinea(lineaP);
            return repo.obtenerRespuesta();
        }else if(mensajeEntrante instanceof CuadroDTO){
            CuadroDTO cuadroP = (CuadroDTO) mensajeEntrante;
            ipaf.asignarCuadro(cuadroP);
            return repo.obtenerRespuesta();
        }else if(mensajeEntrante instanceof String){
            String mensaje = (String) mensajeEntrante;
            
            if(mensaje.equals("Voto")){
                return "Voto";
            }else if(mensaje.equals("Crear")){
                
            }
            
            return "";
        }
        
        return null;
    }
}