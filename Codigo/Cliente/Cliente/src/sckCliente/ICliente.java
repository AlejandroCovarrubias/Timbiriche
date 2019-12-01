/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sckCliente;

import presentacion.inicio.IActualizable;

/**
 *
 * @author Alejandro Galindo
 */
public interface ICliente { 
    boolean conectarAlServidor(String address, int port);
    boolean enviarAlServidor(Object mensaje);
    void escucharAlServidor();
}
