/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uy.edu.ort.sigamas.modeloBiologico;

import javax.ejb.Local;
import uy.edu.ort.sigamas.seguimiento.entidades.Proyecto;

/**
 *
 * @author Mattahari
 */
@Local
public interface MotorBiologicoBeanLocal {

    void actualizarFaseDeProyecto(Proyecto proyecto);
    
}
