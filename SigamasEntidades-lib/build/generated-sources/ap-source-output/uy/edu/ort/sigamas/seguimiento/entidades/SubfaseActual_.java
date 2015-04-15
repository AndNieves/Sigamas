package uy.edu.ort.sigamas.seguimiento.entidades;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import uy.edu.ort.sigamas.seguimiento.entidades.Proyecto;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-04-15T00:45:57")
@StaticMetamodel(SubfaseActual.class)
public class SubfaseActual_ { 

    public static volatile SingularAttribute<SubfaseActual, Integer> idsubfaseActual;
    public static volatile SingularAttribute<SubfaseActual, Date> fechaModificado;
    public static volatile SingularAttribute<SubfaseActual, String> condiciones;
    public static volatile ListAttribute<SubfaseActual, Proyecto> proyectoList;

}