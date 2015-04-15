package uy.edu.ort.sigamas.seguimiento.entidades;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import uy.edu.ort.sigamas.cultivos.entidades.Subfase;
import uy.edu.ort.sigamas.insumos.entidades.InsumoTarea;
import uy.edu.ort.sigamas.seguimiento.entidades.Proyecto;
import uy.edu.ort.sigamas.seguimiento.entidades.TareaPlanificada;
import uy.edu.ort.sigamas.seguimiento.entidades.TareaReal;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-04-15T00:45:57")
@StaticMetamodel(TareaPlanificada.class)
public class TareaPlanificada_ { 

    public static volatile SingularAttribute<TareaPlanificada, String> nombre;
    public static volatile SingularAttribute<TareaPlanificada, TareaPlanificada> idTareaPredecesora;
    public static volatile SingularAttribute<TareaPlanificada, Subfase> idSubfase;
    public static volatile ListAttribute<TareaPlanificada, TareaReal> tareaRealList;
    public static volatile SingularAttribute<TareaPlanificada, Integer> idTareaPlanificada;
    public static volatile SingularAttribute<TareaPlanificada, Integer> validada;
    public static volatile ListAttribute<TareaPlanificada, TareaPlanificada> tareaPlanificadaList;
    public static volatile SingularAttribute<TareaPlanificada, Proyecto> idProyecto;
    public static volatile SingularAttribute<TareaPlanificada, Integer> duracionDias;
    public static volatile SingularAttribute<TareaPlanificada, Integer> dias;
    public static volatile ListAttribute<TareaPlanificada, InsumoTarea> insumoTareaList;

}