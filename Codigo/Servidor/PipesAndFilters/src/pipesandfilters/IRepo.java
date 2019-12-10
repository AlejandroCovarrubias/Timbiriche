/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pipesandfilters;

import DominioDTO.CuadroDTO;
import DominioDTO.LineaDTO;
import DominioDTO.MarcadorDTO;

/**
 *
 * @author Alejandro Galindo
 */
public interface IRepo {
    MarcadorDTO obtenerMarcador();
    LineaDTO obtenerUltimaLinea();
    CuadroDTO obtenerUltimoCuadro();
    int obtenerTurnoSiguiente();
}
