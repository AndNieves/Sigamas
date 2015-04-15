package uy.edu.ort.sigamas.seguridad.entidades;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import uy.edu.ort.sigamas.seguimiento.entidades.Proyecto;
import uy.edu.ort.sigamas.seguridad.entidades.Login;
import uy.edu.ort.sigamas.seguridad.entidades.RelUsuarioCuentaRol;
import uy.edu.ort.sigamas.seguridad.entidades.Usuario;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-04-15T00:45:57")
@StaticMetamodel(Cuenta.class)
public class Cuenta_ { 

    public static volatile SingularAttribute<Cuenta, String> nombre;
    public static volatile ListAttribute<Cuenta, Login> loginList;
    public static volatile ListAttribute<Cuenta, RelUsuarioCuentaRol> relUsuarioCuentaRolList;
    public static volatile SingularAttribute<Cuenta, String> rut;
    public static volatile ListAttribute<Cuenta, Usuario> usuarioList;
    public static volatile ListAttribute<Cuenta, Proyecto> proyectoList;
    public static volatile SingularAttribute<Cuenta, String> empresa;
    public static volatile SingularAttribute<Cuenta, Integer> idCuenta;

}