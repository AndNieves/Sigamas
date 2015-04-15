/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uy.edu.ort.sigamas.sigamasweb.seguimiento;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.view.ViewScoped;
import uy.edu.ort.sigamas.seguimiento.entidades.Proyecto;
import uy.edu.ort.sigamas.seguimiento.entidades.TareaReal;
import uy.edu.ort.sigamas.sigamasweb.login.BeanSesionUsuario;

/**
 *
 * @author Mattahari
 */
@ManagedBean(name = "beanTareasPendientes")
@ViewScoped
public class BeanTareasPendientes implements Serializable {

    @ManagedProperty(value = "#{beanSesionUsuario}")
    private BeanSesionUsuario beanSesionUsuario;

    public void setBeanSesionUsuario(BeanSesionUsuario beanSesionUsuario) {
        this.beanSesionUsuario = beanSesionUsuario;
    }

    /**
     * Creates a new instance of BeanTareasPendientes
     */
    public BeanTareasPendientes() {
    }

    @PostConstruct
    public void init() {
        initProyectosConTareasPendientes();
    }

    /**
     * Inicializa la lista con los proyectos que tienen alguna tarea pendiente
     */
    private void initProyectosConTareasPendientes() {
        tareasPendientesList = new ArrayList<>();
        for (Proyecto p : beanSesionUsuario.getCuentaActual().getProyectoList()) {
            for (TareaReal tareaCandidata : p.getTareaRealList()) {
                if (tareaCandidata.getValidada() != 1) {
                    tareasPendientesList.add(tareaCandidata);                    
                }
            }
        }
    }

    private List<TareaReal> tareasPendientesList;

    public List<TareaReal> getTareasPendientesList() {
        return tareasPendientesList;
    }

    public void setTareasPendientesList(List<TareaReal> tareasPendientesList) {
        this.tareasPendientesList = tareasPendientesList;
    }

 

}
