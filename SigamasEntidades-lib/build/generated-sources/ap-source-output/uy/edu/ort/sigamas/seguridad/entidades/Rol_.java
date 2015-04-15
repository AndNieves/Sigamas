package uy.edu.ort.sigamas.seguridad.entidades;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import uy.edu.ort.sigamas.seguridad.entidades.RelRolPermiso;
import uy.edu.ort.sigamas.seguridad.entidades.RelUsuarioCuentaRol;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-04-15T00:45:57")
@StaticMetamodel(Rol.class)
public class Rol_ { 

    public static volatile SingularAttribute<Rol, String> nombre;
    public static volatile ListAttribute<Rol, RelUsuarioCuentaRol> relUsuarioCuentaRolList;
    public static volatile SingularAttribute<Rol, Integer> idRol;
    public static volatile ListAttribute<Rol, RelRolPermiso> relRolPermisoList;

}