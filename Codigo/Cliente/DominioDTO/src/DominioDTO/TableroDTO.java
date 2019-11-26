/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DominioDTO;

import java.util.List;
import java.util.Objects;

/**
 *
 * @author Alejandro Galindo
 */
public class TableroDTO {
    private List<LineaDTO> lineasVerticalesDTO;
    private List<LineaDTO> lineasHorizontalesDTO;
    private List<CuadroDTO> listaCuadrosDTO;

    public TableroDTO(List<LineaDTO> lineasVerticalesDTO, List<LineaDTO> lineasHorizontalesDTO, List<CuadroDTO> listaCuadrosDTO) {
        this.lineasVerticalesDTO = lineasVerticalesDTO;
        this.lineasHorizontalesDTO = lineasHorizontalesDTO;
        this.listaCuadrosDTO = listaCuadrosDTO;
    }

    public List<LineaDTO> getLineasVerticalesDTO() {
        return lineasVerticalesDTO;
    }

    public void setLineasVerticalesDTO(List<LineaDTO> lineasVerticalesDTO) {
        this.lineasVerticalesDTO = lineasVerticalesDTO;
    }

    public List<LineaDTO> getLineasHorizontalesDTO() {
        return lineasHorizontalesDTO;
    }

    public void setLineasHorizontalesDTO(List<LineaDTO> lineasHorizontalesDTO) {
        this.lineasHorizontalesDTO = lineasHorizontalesDTO;
    }

    public List<CuadroDTO> getListaCuadrosDTO() {
        return listaCuadrosDTO;
    }

    public void setListaCuadrosDTO(List<CuadroDTO> listaCuadrosDTO) {
        this.listaCuadrosDTO = listaCuadrosDTO;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 23 * hash + Objects.hashCode(this.lineasVerticalesDTO);
        hash = 23 * hash + Objects.hashCode(this.lineasHorizontalesDTO);
        hash = 23 * hash + Objects.hashCode(this.listaCuadrosDTO);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final TableroDTO other = (TableroDTO) obj;
        if (!Objects.equals(this.lineasVerticalesDTO, other.lineasVerticalesDTO)) {
            return false;
        }
        if (!Objects.equals(this.lineasHorizontalesDTO, other.lineasHorizontalesDTO)) {
            return false;
        }
        if (!Objects.equals(this.listaCuadrosDTO, other.listaCuadrosDTO)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "TableroDTO{ verticales" + lineasVerticalesDTO + ", horizontales " + lineasHorizontalesDTO + ", cuadrados " + listaCuadrosDTO + '}';
    }
}