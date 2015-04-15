package uy.edu.ort.sigamas.notificaciones.entidades;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import uy.edu.ort.sigamas.notificaciones.entidades.Notificacion;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-04-15T00:45:57")
@StaticMetamodel(TipoNotificacion.class)
public class TipoNotificacion_ { 

    public static volatile SingularAttribute<TipoNotificacion, String> nombre;
    public static volatile ListAttribute<TipoNotificacion, Notificacion> notificacionList;
    public static volatile SingularAttribute<TipoNotificacion, String> medio;
    public static volatile SingularAttribute<TipoNotificacion, Integer> idTipoNotificacion;

}