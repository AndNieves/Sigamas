/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uy.edu.ort.sigamas.sigamasweb.usuario;

import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import uy.edu.ort.sigamas.seguridad.usuario.UsuarioBeanLocal;
import uy.edu.ort.sigamas.sigamasweb.login.BeanSesionUsuario;
import uy.edu.ort.sigamas.sigamasweb.utils.UtilsMensajes;

/**
 *
 * @author Mattahari
 */
@ManagedBean(name = "beanInvitacionUsuario")
@RequestScoped
public class BeanInvitacionUsuario {

    @EJB
    private UsuarioBeanLocal usuarioBeanLocal;
    
    @ManagedProperty(value = "#{beanSesionUsuario}")
    private BeanSesionUsuario beanSesionUsuario;

    public void setBeanSesionUsuario(BeanSesionUsuario beanSesionUsuario) {
        this.beanSesionUsuario = beanSesionUsuario;
    }

    /**
     * Creates a new instance of BeanInvitacionUsuario
     */
    public BeanInvitacionUsuario() {
    }

    private String mailInvitacion;

    public String getMailInvitacion() {
        return mailInvitacion;
    }

    public void setMailInvitacion(String mailInvitacion) {
        this.mailInvitacion = mailInvitacion;
    }

    public String enviarInvitacion() {
        usuarioBeanLocal.invitarUsuario(mailInvitacion, beanSesionUsuario.getUsuarioLoggeado(), beanSesionUsuario.getCuentaActual());
        UtilsMensajes.mostrarMensajeInformacion(null, "Exito", "Invitación enviada");
        return "gestionCuenta";
    }

}
