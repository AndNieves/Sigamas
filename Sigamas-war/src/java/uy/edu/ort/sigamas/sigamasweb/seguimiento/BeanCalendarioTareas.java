/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uy.edu.ort.sigamas.sigamasweb.seguimiento;

import java.io.Serializable;
import java.util.Date;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.view.ViewScoped;
import org.primefaces.model.DefaultScheduleEvent;
import org.primefaces.model.DefaultScheduleModel;
import org.primefaces.model.ScheduleModel;
import uy.edu.ort.sigamas.seguimiento.entidades.Proyecto;
import uy.edu.ort.sigamas.seguimiento.entidades.TareaReal;
import uy.edu.ort.sigamas.sigamasweb.login.BeanSesionUsuario;

/**
 *
 * @author Mattahari
 */
@ManagedBean(name = "beanCalendarioTareas")
@ViewScoped
public class BeanCalendarioTareas implements Serializable {

    @ManagedProperty(value = "#{beanSesionUsuario}")
    private BeanSesionUsuario beanSesionUsuario;

    public void setBeanSesionUsuario(BeanSesionUsuario beanSesionUsuario) {
        this.beanSesionUsuario = beanSesionUsuario;
    }

    /**
     * Creates a new instance of BeanCalendarioTareas
     */
    public BeanCalendarioTareas() {
    }

    private ScheduleModel eventModel;

    @PostConstruct
    public void init() {
        initCalendario();
    }

    /**
     * Inicializa el calendario
     */
    private void initCalendario() {
        eventModel = new DefaultScheduleModel();
        for (Proyecto p : beanSesionUsuario.getCuentaActual().getProyectoList()) {
            for (TareaReal tarea : p.getTareaRealList()) {
                eventModel.addEvent(new DefaultScheduleEvent(tarea.getNombre(), tarea.getFecha(), tarea.getFecha()));
            }
        }

    }

    public ScheduleModel getEventModel() {
        return eventModel;
    }

    public void setEventModel(ScheduleModel eventModel) {
        this.eventModel = eventModel;
    }

}
