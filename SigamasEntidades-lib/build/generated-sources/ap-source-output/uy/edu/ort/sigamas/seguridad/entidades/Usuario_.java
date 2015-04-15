package uy.edu.ort.sigamas.seguridad.entidades;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import uy.edu.ort.sigamas.seguridad.entidades.Cuenta;
import uy.edu.ort.sigamas.seguridad.entidades.Login;
import uy.edu.ort.sigamas.seguridad.entidades.RelUsuarioCuentaRol;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-04-15T00:45:57")
@StaticMetamodel(Usuario.class)
public class Usuario_ { 

    public static volatile SingularAttribute<Usuario, String> apellidos;
    public static volatile SingularAttribute<Usuario, String> claveUsuario;
    public static volatile SingularAttribute<Usuario, String> telefono;
    public static volatile SingularAttribute<Usuario, String> sexo;
    public static volatile SingularAttribute<Usuario, Date> fechaNacimiento;
    public static volatile SingularAttribute<Usuario, String> nombre;
    public static volatile ListAttribute<Usuario, Login> loginList;
    public static volatile ListAttribute<Usuario, RelUsuarioCuentaRol> relUsuarioCuentaRolList;
    public static volatile SingularAttribute<Usuario, Integer> idUsuario;
    public static volatile SingularAttribute<Usuario, String> emailUsuario;
    public static volatile SingularAttribute<Usuario, String> profesion;
    public static volatile ListAttribute<Usuario, Cuenta> cuentaList;
    public static volatile SingularAttribute<Usuario, Integer> idRol;
    public static volatile SingularAttribute<Usuario, String> nombreUsuario;

}