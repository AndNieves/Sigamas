package uy.edu.ort.sigamas.seguridad.entidades;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import uy.edu.ort.sigamas.enums.EstadosInvitacion;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-04-15T00:45:57")
@StaticMetamodel(InvitacionCuenta.class)
public class InvitacionCuenta_ { 

    public static volatile SingularAttribute<InvitacionCuenta, EstadosInvitacion> estado;
    public static volatile SingularAttribute<InvitacionCuenta, Integer> idinvitacionCuenta;
    public static volatile SingularAttribute<InvitacionCuenta, String> receptor;
    public static volatile SingularAttribute<InvitacionCuenta, String> emisor;
    public static volatile SingularAttribute<InvitacionCuenta, Integer> idCuenta;

}