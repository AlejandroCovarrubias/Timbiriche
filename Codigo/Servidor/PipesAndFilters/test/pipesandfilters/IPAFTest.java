/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pipesandfilters;

import pipesandfilters.commands.InvocadorPln;
import DominioDTO.CuadroDTO;
import DominioDTO.JugadorDTO;
import DominioDTO.LineaDTO;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

/**
 *
 * @author Alejandro Galindo
 */
public class IPAFTest {
    
    private List<JugadorDTO> jugadores;
    
    public IPAFTest() {
        jugadores = new ArrayList<>();
        jugadores.add(new JugadorDTO("Jugador1", "laRuta", 0));
        jugadores.add(new JugadorDTO("Jugador2", "laRuta", 0));
        jugadores.add(new JugadorDTO("Jugador3", "laRuta", 0));
        jugadores.add(new JugadorDTO("Jugador4", "laRuta", 0));
    }

    /**
     * Test of crearSala method, of class IPAF.
     */
    @Test
    public void testCrearSala() {
        
        IPAF instance = new InvocadorPln();
        IRepo accesoRepo = new AccesoRepo();
        
        instance.crearSala(jugadores);
        
    }

    /**
     * Test of asignarLinea method, of class IPAF.
     */
    @Test
    public void testAsignarLinea() {
        IPAF instance = new InvocadorPln();
        IRepo accesoRepo = new AccesoRepo();
        
        LineaDTO linea = new LineaDTO("VERTICAL", 2, jugadores.get(0));
        
        instance.crearSala(jugadores);
        instance.asignarLinea(linea);
        
    }

    /**
     * Test of asignarCuadro method, of class IPAF.
     */
    @Test
    public void testAsignarCuadro() {
        IPAF instance = new InvocadorPln();
        IRepo accesoRepo = new AccesoRepo();
        
        CuadroDTO cuadro = new CuadroDTO(4, jugadores.get(1));
        
        //Crea la sala denuevo por si se ejecuta antes que testCrearSala()
        instance.crearSala(jugadores);
        instance.asignarCuadro(cuadro);
        
    }

    /**
     * Test of retirarJugador method, of class IPAF.
     */
    @Test
    public void testRetirarJugador() {
        IPAF instance = new InvocadorPln();
        IRepo accesoRepo = new AccesoRepo();
        
        CuadroDTO cuadro = new CuadroDTO(0, jugadores.get(1));
        CuadroDTO cuadro1 = new CuadroDTO(1, jugadores.get(1));
        CuadroDTO cuadro2 = new CuadroDTO(2, jugadores.get(1));
        
        //Crea la sala denuevo por si se ejecuta antes que testCrearSala()
        instance.crearSala(jugadores);
        instance.asignarCuadro(cuadro);
        instance.asignarCuadro(cuadro1);
        instance.asignarCuadro(cuadro2);
        
    }    
}