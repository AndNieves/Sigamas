/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uy.edu.ort.sigamas.sigamasweb.cuenta;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.view.ViewScoped;
import uy.edu.ort.sigamas.seguridad.entidades.InvitacionCuenta;
import uy.edu.ort.sigamas.sigamasweb.login.BeanSesionUsuario;

/**
 *
 * @author Mattahari
 */
@ManagedBean(name = "beanGestionCuenta")
@ViewScoped
public class BeanGestionCuenta implements Serializable{

    @ManagedProperty(value = "#{beanSesionUsuario}")
    private BeanSesionUsuario beanSesionUsuario;

    public void setBeanSesionUsuario(BeanSesionUsuario beanSesionUsuario) {
        this.beanSesionUsuario = beanSesionUsuario;
    }

    /**
     * Creates a new instance of BeanGestionCuenta
     */
    public BeanGestionCuenta() {
    }

    @PostConstruct
    public void init() {

    }

    private List<InvitacionCuenta> invitacionesPendientes;

    public List<InvitacionCuenta> getInvitacionesPendientes() {
        return invitacionesPendientes;
    }

    public void setInvitacionesPendientes(List<InvitacionCuenta> invitacionesPendientes) {
        this.invitacionesPendientes = invitacionesPendientes;
    }

}
