package uy.edu.ort.sigamas.seguridad.entidades;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import uy.edu.ort.sigamas.seguridad.entidades.Permiso;
import uy.edu.ort.sigamas.seguridad.entidades.Rol;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-04-15T00:45:57")
@StaticMetamodel(RelRolPermiso.class)
public class RelRolPermiso_ { 

    public static volatile SingularAttribute<RelRolPermiso, Permiso> idPermiso;
    public static volatile SingularAttribute<RelRolPermiso, Integer> idrelRolPermiso;
    public static volatile SingularAttribute<RelRolPermiso, Rol> idRol;

}