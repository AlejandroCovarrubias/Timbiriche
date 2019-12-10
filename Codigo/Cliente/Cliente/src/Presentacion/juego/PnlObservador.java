/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentacion.juego;

import Dominio.FormaJuego;
import java.util.List;

/**
 *
 * @author Alejandro Galindo
 */
public interface PnlObservador {
    void actualiza(List<FormaJuego> movimiento);
}