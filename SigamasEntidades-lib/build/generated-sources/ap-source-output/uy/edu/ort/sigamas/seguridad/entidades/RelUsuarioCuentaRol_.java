package uy.edu.ort.sigamas.seguridad.entidades;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import uy.edu.ort.sigamas.seguridad.entidades.Cuenta;
import uy.edu.ort.sigamas.seguridad.entidades.Rol;
import uy.edu.ort.sigamas.seguridad.entidades.Usuario;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-04-15T00:45:57")
@StaticMetamodel(RelUsuarioCuentaRol.class)
public class RelUsuarioCuentaRol_ { 

    public static volatile SingularAttribute<RelUsuarioCuentaRol, Usuario> idUsuario;
    public static volatile SingularAttribute<RelUsuarioCuentaRol, Integer> idrelUsuarioCuentaRol;
    public static volatile SingularAttribute<RelUsuarioCuentaRol, Rol> idRol;
    public static volatile SingularAttribute<RelUsuarioCuentaRol, Cuenta> idCuenta;

}