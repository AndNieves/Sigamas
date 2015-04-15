package uy.edu.ort.sigamas.seguimiento.entidades;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import uy.edu.ort.sigamas.seguimiento.entidades.Proyecto;
import uy.edu.ort.sigamas.seguimiento.entidades.TareaPlanificada;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-04-15T00:45:57")
@StaticMetamodel(TareaReal.class)
public class TareaReal_ { 

    public static volatile SingularAttribute<TareaReal, String> nombre;
    public static volatile SingularAttribute<TareaReal, Integer> idFase;
    public static volatile SingularAttribute<TareaReal, Date> fecha;
    public static volatile SingularAttribute<TareaReal, Integer> validada;
    public static volatile SingularAttribute<TareaReal, TareaPlanificada> idTareaPlanificada;
    public static volatile SingularAttribute<TareaReal, Proyecto> idProyecto;
    public static volatile SingularAttribute<TareaReal, Integer> idTareaReal;

}