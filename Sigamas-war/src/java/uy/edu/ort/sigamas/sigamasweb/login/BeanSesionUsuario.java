/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uy.edu.ort.sigamas.sigamasweb.login;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import uy.edu.ort.sigamas.seguimiento.entidades.Proyecto;
import uy.edu.ort.sigamas.seguridad.entidades.Cuenta;
import uy.edu.ort.sigamas.seguridad.entidades.Usuario;

/**
 *
 * @author anieves
 */
@ManagedBean(name = "beanSesionUsuario")
@SessionScoped
public class BeanSesionUsuario implements Serializable {

    /**
     * Creates a new instance of BeanSesionUsuario
     */
    public BeanSesionUsuario() {
    }

    private Usuario usuarioLoggeado;
    private Cuenta cuentaActual;
    private int tabSelected;
    private Proyecto proyectoSeleccionado;

// <editor-fold defaultstate="collapsed" desc="Gets y Sets">
    public Usuario getUsuarioLoggeado() {
        return usuarioLoggeado;
    }

    /**
     * Establece el usuario loggeado en la sesion. Si tiene cuentas, utiliza la
     * primera de la lista como la cuenta por defecto
     *
     * @param usuarioLoggeado
     */
    public void setUsuarioLoggeado(Usuario usuarioLoggeado) {
        this.usuarioLoggeado = usuarioLoggeado;
        if (usuarioLoggeado.getCuentaList() != null && !usuarioLoggeado.getCuentaList().isEmpty()) {
            this.cuentaActual = usuarioLoggeado.getCuentaList().get(0);
        }
    }

    public Cuenta getCuentaActual() {
        return cuentaActual;
    }

    public void setCuentaActual(Cuenta cuentaActual) {
        this.cuentaActual = cuentaActual;
    }

    public String logout() {
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        return "login";
    }

    /**
     * @return the tabSelected
     */
    public int getTabSelected() {
        return tabSelected;
    }

    /**
     * @param tabSelected the tabSelected to set
     */
    public void setTabSelected(int tabSelected) {
        this.tabSelected = tabSelected;
    }
    
    


    public Proyecto getProyectoSeleccionado() {
        return proyectoSeleccionado;
    }

    public void setProyectoSeleccionado(Proyecto proyectoSeleccionado) {
        this.proyectoSeleccionado = proyectoSeleccionado;
    }
// </editor-fold>
}
