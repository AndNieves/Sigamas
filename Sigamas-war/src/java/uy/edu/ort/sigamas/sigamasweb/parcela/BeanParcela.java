/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uy.edu.ort.sigamas.sigamasweb.parcela;

import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import uy.edu.ort.sigamas.seguridad.entidades.Parcela;
import uy.edu.ort.sigamas.seguridad.parcela.ParcelaBeanLocal;

/**
 *
 * @author Pikachuss
 */
@Named(value = "beanParcela")
@ViewScoped
public class BeanParcela {

    @EJB
    private ParcelaBeanLocal parcelaBeanLocal;
    private String nombre;
    private String padron;
    private List<Parcela> parcelas;
    /**
     * Creates a new instance of BeanPredio
     */
    public BeanParcela() {
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the padron
     */
    public String getPadron() {
        return padron;
    }

    /**
     * @param padron the padron to set
     */
    public void setPadron(String padron) {
        this.padron = padron;
    }

    /**
     * @return the parcelas
     */
    public List<Parcela> getParcelas() {
        return parcelas;
    }

    /**
     * @param parcelas the parcelas to set
     */
    public void setParcelas(List<Parcela> parcelas) {
        this.parcelas = parcelas;
    }
    
    @PostConstruct
    public void init() {
        parcelas = parcelaBeanLocal.obtenerParcelas();
    }
}