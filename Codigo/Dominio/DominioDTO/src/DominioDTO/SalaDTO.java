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
public class SalaDTO implements Serializable{
    private TableroDTO tableroDTO;
    private MarcadorDTO marcadorDTO;

    public SalaDTO(TableroDTO tableroDTO, MarcadorDTO marcadorDTO) {
        this.tableroDTO = tableroDTO;
        this.marcadorDTO = marcadorDTO;
    }

    public TableroDTO getTableroDTO() {
        return tableroDTO;
    }

    public void setTableroDTO(TableroDTO tableroDTO) {
        this.tableroDTO = tableroDTO;
    }

    public MarcadorDTO getMarcadorDTO() {
        return marcadorDTO;
    }

    public void setMarcadorDTO(MarcadorDTO marcadorDTO) {
        this.marcadorDTO = marcadorDTO;
    }

    @Override
    public String toString() {
        return "SalaDTO{" + "tableroDTO=" + tableroDTO + ", marcadorDTO=" + marcadorDTO + '}';
    }
}