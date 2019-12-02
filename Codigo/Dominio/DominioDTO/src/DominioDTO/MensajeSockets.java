/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DominioDTO;

import java.io.Serializable;

/**
 *
 * @author Alejandro Galindo
 */
public enum MensajeSockets implements Serializable {
    VOTO, CREAR_SALA, EMPEZAR_PARTIDA, JUGADOR_NUEVO, TURNO_TERMINADO, MARCADOR
}
