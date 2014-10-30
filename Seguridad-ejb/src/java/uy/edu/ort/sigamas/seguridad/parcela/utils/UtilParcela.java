/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uy.edu.ort.sigamas.seguridad.parcela.utils;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.NamedQuery;
import javax.persistence.Query;
import uy.edu.ort.sigamas.seguridad.entidades.Parcela;
import uy.edu.ort.sigamas.seguridad.parcela.excepciones.ParcelaPadronExistenteException;

/**
 *
 * @author Pikachuss
 */
public class UtilParcela {
    
    public static List<Parcela> obtenerParcelas(EntityManager em){
        return null; //Se buscará las parcelas de la cuenta
    }

    public static void crearParcela(EntityManager em, String nombre, String padron, String departamento) throws ParcelaPadronExistenteException{
        Query q = em.createNamedQuery("Parcela.findByPadron").setParameter("padron", padron);
        if (!q.getResultList().isEmpty()){
            throw new ParcelaPadronExistenteException();
        }
        Parcela nuevaParcela = new Parcela();
        nuevaParcela.setNombre(nombre);
        nuevaParcela.setPadron(padron);
        nuevaParcela.setDepartamento(departamento);
        em.persist(nuevaParcela);
    }
    
}
