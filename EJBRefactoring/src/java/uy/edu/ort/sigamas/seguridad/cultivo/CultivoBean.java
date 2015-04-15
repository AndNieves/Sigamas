/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uy.edu.ort.sigamas.seguridad.cultivo;

import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import uy.edu.ort.sigamas.seguridad.cultivo.utils.UtilCultivo;
import uy.edu.ort.sigamas.seguridad.entidades.Cuenta;
import uy.edu.ort.sigamas.cultivos.entidades.Cultivo;
import uy.edu.ort.sigamas.campos.entidades.Parcela;
import uy.edu.ort.sigamas.seguimiento.entidades.Proyecto;


/**
 *
 * @author Pikachuss
 */
@Stateless
public class CultivoBean implements CultivoBeanLocal {

    @PersistenceContext(unitName = "Otros-PU")
    private EntityManager em;
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    @Override
    public void agregarCultivo(String nombre, Parcela parcela, Date fechaInicio, String cultivar){
        UtilCultivo.agregarCultivo(em, nombre, parcela, fechaInicio, cultivar);
    }
    
    @Override
    public void modificarCultivo(String nombre){
        UtilCultivo.modificarCultivo(em, nombre);
    }
    
    @Override
    public List<Cultivo> obtenerCultivos(){
        return UtilCultivo.obtenerCultivos(em);
    }
    
    @Override
    public List<Proyecto> obtenerProyectos(Cuenta cuentaActual){
        return UtilCultivo.obtenerProyectos(em, cuentaActual);
    }
    
    @Override
    public Cultivo obtenerCultivo(int i){
        return em.find(Cultivo.class, i);
    }
}
