/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uy.edu.ort.sigamas.sigamasweb.proyecto;

import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.view.ViewScoped;
import uy.edu.ort.sigamas.seguimiento.SeguimientoBeanLocal;
import uy.edu.ort.sigamas.seguimiento.entidades.TareaReal;
import uy.edu.ort.sigamas.sigamasweb.utils.UtilsMensajes;

/**
 *
 * @author Mattahari
 */
@ManagedBean(name = "beanVistaProyecto")
@ViewScoped
public class BeanVistaProyecto implements Serializable {

    /**
     * Creates a new instance of BeanVistaProyecto
     */
    @EJB
    private SeguimientoBeanLocal seguimientoBeanLocal;

    public void setSeguimientoBeanLocal(SeguimientoBeanLocal seguimientoBeanLocal) {
        this.seguimientoBeanLocal = seguimientoBeanLocal;
    }

    public BeanVistaProyecto() {
    }

    private TareaReal tareaSeleccionada;

    public TareaReal getTareaSeleccionada() {
        return tareaSeleccionada;
    }

    public void setTareaSeleccionada(TareaReal tareaSeleccionada) {
        this.tareaSeleccionada = tareaSeleccionada;
    }

    public void guardarTareaReal() {
        
        if (tareaSeleccionada != null){
            tareaSeleccionada.setValidada(1);
            System.out.println(seguimientoBeanLocal.guardarObjeto(tareaSeleccionada));
            UtilsMensajes.mostrarMensajeInformacion("Cambios Guardados", "Cambios Guardados", "");
        } else {
            UtilsMensajes.mostrarMensajeError("Error Guardando", "Error Guardando", "");
        }
    }

}
