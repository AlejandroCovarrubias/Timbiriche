/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DominioDTO;

/**
 *
 * @author Alejandro Galindo
 */
public abstract class CreadorDeMovimientos {
    protected MovimientoDTO movimiento;
    
    public MovimientoDTO getMovimientoDTO(){
        return movimiento;
    }
    
    public void creaMovimientoDTO(){
        movimiento = new MovimientoDTO();
    }
    
    public void agregarLinea(LineaDTO linea){};
    
    public void agregarCuadro(CuadroDTO cuadro){};
}
