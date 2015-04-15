package uy.edu.ort.sigamas.seguimiento.entidades;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import uy.edu.ort.sigamas.cultivos.entidades.Cultivo;
import uy.edu.ort.sigamas.cultivos.entidades.Subfase;
import uy.edu.ort.sigamas.seguimiento.entidades.SubfaseActual;
import uy.edu.ort.sigamas.seguimiento.entidades.TareaPlanificada;
import uy.edu.ort.sigamas.seguimiento.entidades.TareaReal;
import uy.edu.ort.sigamas.seguridad.entidades.Cuenta;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-04-15T00:45:57")
@StaticMetamodel(Proyecto.class)
public class Proyecto_ { 

    public static volatile SingularAttribute<Proyecto, String> nombre;
    public static volatile SingularAttribute<Proyecto, Subfase> idFasePlanificada;
    public static volatile ListAttribute<Proyecto, TareaReal> tareaRealList;
    public static volatile SingularAttribute<Proyecto, SubfaseActual> idFaseActual;
    public static volatile SingularAttribute<Proyecto, Integer> idProyecto;
    public static volatile ListAttribute<Proyecto, TareaPlanificada> tareaPlanificadaList;
    public static volatile SingularAttribute<Proyecto, Cultivo> idCultivo;
    public static volatile SingularAttribute<Proyecto, Date> fechaInicio;
    public static volatile SingularAttribute<Proyecto, Cuenta> idCuenta;

}