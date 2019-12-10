/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DominioDTO;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author Alejandro Galindo
 */
public class MovimientoDTO implements Serializable{

    private LineaDTO linea;
    private List<CuadroDTO> cuadros = new ArrayList<>();

    public LineaDTO getLinea() {
        return linea;
    }

    public void setLinea(LineaDTO linea) {
        this.linea = linea;
    }

    public List<CuadroDTO> getCuadros() {
        return cuadros;
    }

    public void setCuadros(List<CuadroDTO> cuadros) {
        this.cuadros = cuadros;
    }

    public void setCuadro(CuadroDTO cuadro) {
        if(cuadros.size() < 2){
            cuadros.add(cuadro);
        }else{
            cuadros.remove(0);
            cuadros.add(cuadro);
        }
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 37 * hash + Objects.hashCode(this.linea);
        hash = 37 * hash + Objects.hashCode(this.cuadros);
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
        final MovimientoDTO other = (MovimientoDTO) obj;
        if (!Objects.equals(this.linea, other.linea)) {
            return false;
        }
        if (!Objects.equals(this.cuadros, other.cuadros)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "MovimientoDTO{" + "linea=" + linea + ", cuadros=" + cuadros + '}';
    }
}