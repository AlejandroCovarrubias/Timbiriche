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
public class RespuestaDTO implements Serializable{
    private MovimientoDTO movimiento;
    private MarcadorDTO marcador;

    public RespuestaDTO(MovimientoDTO movimiento, MarcadorDTO marcador) {
        this.movimiento = movimiento;
        this.marcador = marcador;
    }

    public MovimientoDTO getMovimiento() {
        return movimiento;
    }

    public void setMovimiento(MovimientoDTO movimiento) {
        this.movimiento = movimiento;
    }

    public MarcadorDTO getMarcador() {
        return marcador;
    }

    public void setMarcador(MarcadorDTO marcador) {
        this.marcador = marcador;
    }
}