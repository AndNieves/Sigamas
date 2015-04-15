/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uy.edu.ort.sigamas.seguimiento;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import uy.edu.ort.sigamas.cultivos.entidades.CodigueraPlanCultivo;
import uy.edu.ort.sigamas.cultivos.entidades.Subfase;
import uy.edu.ort.sigamas.seguimiento.entidades.Proyecto;
import uy.edu.ort.sigamas.seguimiento.entidades.TareaPlanificada;
import uy.edu.ort.sigamas.seguimiento.entidades.TareaReal;
import uy.edu.ort.sigamas.seguridad.entidades.Cuenta;

/**
 *
 * @author Mattahari
 */
@Stateless
public class SeguimientoBean implements SeguimientoBeanLocal {

    @PersistenceContext(unitName = "Seguimiento-PU")
    private EntityManager em;

    @Override
    public void nuevoProyecto(Date fechaInicio, CodigueraPlanCultivo planCultivo){
        //recibe la fecha de inicio y el el registro de la codiguera de planes de cultivo
        //Debe conseguir las tareas planificadas y pasarlas a tareas reales con fechas previstas        
        //en este proceso solo se instancian las tareas, dado que alguna de ellas debe iniciar el modelo biologico
        Proyecto p = new Proyecto();
        Query queryTareasPlanificadas = em.createNamedQuery("TareaPlanificada.findByCodigoPlanCultivo");
        queryTareasPlanificadas.setParameter("codigoPlanCultivos", planCultivo.getIdCultivo());
        List<TareaPlanificada> tareasPlanificadas = (List<TareaPlanificada>) queryTareasPlanificadas.getResultList();
        List<TareaReal> tareaRealList = new ArrayList<>();
        for(TareaPlanificada t : tareasPlanificadas){
            if(t.getIdTareaPredecesora() == null){
                //ES la primera
            }
        }
        
    }
    
    /**
     * Recibe la tarea inicial y una lista con las tareas sin instanciar, devuelve una lista con todas las tareas reales instanciadas
     * @param tareaActual
     * @param tareasSinInstanciar
     * @return 
     */
    
    private List<TareaReal> generarTareasReales(TareaReal tareaAnterior, List<TareaPlanificada> tareasSinInstanciar){
        for(TareaPlanificada tp : tareasSinInstanciar){
            if(tareaAnterior.getIdTareaPlanificada().equals(tp.getIdTareaPredecesora()))
        }
        
        return null;
    }
       

    @Override
    public Proyecto obtenerProyecto(String label) {
        int out = -1;
        Integer.parseInt(label, out);
        return em.find(Proyecto.class, out);
    }

    @Override
    public List<TareaReal> obtenerTareas(Proyecto proyecto) {
        List<TareaReal> tareas = new ArrayList<TareaReal>();
        return null;
    }

    @Override
    public void pasarProyectoDeFase(Proyecto proyecto) {
        List<Subfase> subfases = em.createNamedQuery("Subfase.findFaseSiguiente").setParameter("idSubfase", proyecto.getIdFaseActual()).getResultList();
        if (!subfases.isEmpty()) {
            proyecto.setIdFasePlanificada(subfases.get(0));
        }
    }

    @Override
    public List<TareaReal> obtenerTareasPendientes(Cuenta cuentaActual) {

        List<Proyecto> proyectos = cuentaActual.getProyectoList();
        List<TareaReal> tareasPendientes = new ArrayList();
        for (Proyecto proyecto : proyectos) {
            tareasPendientes.addAll(em.createNamedQuery("TareaReal.findTareasPendientes").setParameter("idProyecto", proyecto.getIdProyecto()).getResultList());
        }
        return tareasPendientes;
    }

    @Override
    public boolean validarTarea(TareaReal tarea) {
        System.out.println("Se llama a validar tarea EJB");
        Calendar hoy = Calendar.getInstance();
        hoy.clear(Calendar.HOUR);
        hoy.clear(Calendar.MINUTE);
        hoy.clear(Calendar.SECOND);
        Date fechaActual = hoy.getTime();
        TareaPlanificada tareaPlanificada = em.find(TareaPlanificada.class, tarea.getIdTareaPlanificada());
        boolean sePuedeValidar = false;

        //Si la tarea todavia no ha sido validada y su fecha es anterior o igual a la fecha de hoy
        if (tarea.getValidada() == 0 && fechaActual.compareTo(tarea.getFecha()) >= 0) {
            sePuedeValidar = true;
            System.out.println("Por la fecha se puede validar");
            TareaPlanificada tareaPlanificadaPredecesora = em.find(TareaPlanificada.class, tareaPlanificada.getIdTareaPredecesora());
            List<TareaReal> tareasPredecesoras = tareaPlanificadaPredecesora.getTareaRealList();
            //Si hay tareas predecesoras
            if (tareasPredecesoras != null && tareasPredecesoras.size() > 0) {
                for (TareaReal tareasPredecesora : tareasPredecesoras) {
                    //Si la tarea predecesora no ha sido validada no se puede validar la tarea sucesora
                    if (tareasPredecesora.getValidada() == 0) {
                        sePuedeValidar = false;
                        System.out.println("Por las antecesoras no se puede validar");
                        break;
                    }
                }
            }
        }
        if (sePuedeValidar) {
            tarea.setValidada(1);
            long dif = tarea.getFecha().getTime() - tarea.getFecha().getTime();
            long diferenciaFechas = dif / (24 * 60 * 60 * 1000);
            //Si las fechas son distintas
            if (diferenciaFechas != 0) {
                int diasDeDiferencia = new BigDecimal(diferenciaFechas).intValueExact();
                recalcularTareasSucesoras(tarea, tareaPlanificada, fechaActual, diasDeDiferencia);
            }
            System.out.println("Se puede validar, se llama al merge");
            em.merge(tarea);
        }
        return sePuedeValidar;
    }

    @Override
    public void recalcularTareasSucesoras(TareaReal tarea, TareaPlanificada tareaPlanificada, Date fechaActual, int diasDeDiferencia) {

        //Se obtiene la lista de tareas sucesoras
        List<TareaPlanificada> tareasSucesoras = tareaPlanificada.getTareaPlanificadaList();
        for (TareaPlanificada tareasSucesora : tareasSucesoras) {
            //Se obtiene la tarea real correspondiente a la tarea planificada
            List<TareaReal> tareasReales = tareasSucesora.getTareaRealList();
            for (TareaReal tareaReal : tareasReales) {
                Calendar nuevaFecha = Calendar.getInstance();
                nuevaFecha.setTime(tareaReal.getFecha());
                nuevaFecha.add(Calendar.DATE, diasDeDiferencia);
                tareaReal.setFecha(nuevaFecha.getTime());
                em.merge(tareaReal);
                //Se llama recursivamente a las siguientes tareas sucesoras
                recalcularTareasSucesoras(tareaReal, tareasSucesora, fechaActual, diasDeDiferencia);
            }
        }

    }

    @Override
    public List<Proyecto> obtenerProyectosConTareasPendientes(Cuenta cuentaActual) {
        return cuentaActual.getProyectoList();
    }

    @Override
    public Boolean guardarObjeto(Object object) {
        em.merge(object);
        em.flush();
        return Boolean.TRUE;
    }
    
    
}
