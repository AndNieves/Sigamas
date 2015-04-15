/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uy.edu.ort.sigamas.modeloBiologico;

import javax.ejb.Stateless;
import uy.edu.ort.sigamas.cultivos.entidades.Subfase;
import uy.edu.ort.sigamas.seguimiento.entidades.Proyecto;
import uy.edu.ort.sigamas.seguimiento.entidades.SubfaseActual;

/**
 *
 * @author Mattahari
 */
@Stateless
public class MotorBiologicoBean implements MotorBiologicoBeanLocal {

    @Override
    public void actualizarFaseDeProyecto(Proyecto proyecto) {        
        /* se recibe el proyecto
        Segun la fase actual y la informacion de la subfase, se calculan los valores para el dia
        si se llego al ultimo dia y los valores coinciden, entonces se cambia de fase.
        Para simplificar el modelo se va a pasar de fase siempre.        
        */
        
        SubfaseActual subfaseActual = proyecto.getIdFaseActual();
        Subfase subfase =  proyecto.getIdFasePlanificada();
        
        //Se debe calcular desde la ultima actualizacion a la fecha como evoluciono el modelo
        
        
        
        
        
    }
}
