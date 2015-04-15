package uy.edu.ort.sigamas.seguridad.entidades;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import uy.edu.ort.sigamas.seguridad.entidades.RelRolPermiso;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-04-15T00:45:57")
@StaticMetamodel(Permiso.class)
public class Permiso_ { 

    public static volatile SingularAttribute<Permiso, Integer> idPermiso;
    public static volatile SingularAttribute<Permiso, String> nombre;
    public static volatile SingularAttribute<Permiso, String> valor;
    public static volatile ListAttribute<Permiso, RelRolPermiso> relRolPermisoList;

}