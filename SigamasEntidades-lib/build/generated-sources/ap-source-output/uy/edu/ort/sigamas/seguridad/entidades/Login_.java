package uy.edu.ort.sigamas.seguridad.entidades;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import uy.edu.ort.sigamas.seguridad.entidades.Cuenta;
import uy.edu.ort.sigamas.seguridad.entidades.Usuario;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-04-15T00:45:57")
@StaticMetamodel(Login.class)
public class Login_ { 

    public static volatile SingularAttribute<Login, Usuario> idUsuario;
    public static volatile SingularAttribute<Login, Date> fecha;
    public static volatile SingularAttribute<Login, Integer> idLogin;
    public static volatile SingularAttribute<Login, Cuenta> idCuenta;
    public static volatile SingularAttribute<Login, String> ip;

}