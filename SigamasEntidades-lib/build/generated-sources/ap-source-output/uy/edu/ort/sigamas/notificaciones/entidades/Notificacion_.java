package uy.edu.ort.sigamas.notificaciones.entidades;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import uy.edu.ort.sigamas.notificaciones.entidades.TipoNotificacion;
import uy.edu.ort.sigamas.seguimiento.entidades.TareaReal;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-04-15T00:45:57")
@StaticMetamodel(Notificacion.class)
public class Notificacion_ { 

    public static volatile SingularAttribute<Notificacion, TareaReal> idTarea;
    public static volatile SingularAttribute<Notificacion, Integer> idNotificacion;
    public static volatile SingularAttribute<Notificacion, Integer> tipo;
    public static volatile SingularAttribute<Notificacion, Integer> leida;
    public static volatile SingularAttribute<Notificacion, Integer> anterioridadDias;
    public static volatile SingularAttribute<Notificacion, String> mensaje;
    public static volatile SingularAttribute<Notificacion, TipoNotificacion> idTipoNotificacion;

}