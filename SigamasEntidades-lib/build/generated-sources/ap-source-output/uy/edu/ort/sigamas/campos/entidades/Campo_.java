package uy.edu.ort.sigamas.campos.entidades;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import uy.edu.ort.sigamas.insumos.entidades.Insumo;
import uy.edu.ort.sigamas.insumos.entidades.Valor;
import uy.edu.ort.sigamas.seguridad.entidades.Cuenta;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-04-15T00:45:57")
@StaticMetamodel(Campo.class)
public class Campo_ { 

    public static volatile SingularAttribute<Campo, String> nombre;
    public static volatile ListAttribute<Campo, Insumo> insumoList;
    public static volatile ListAttribute<Campo, Valor> valorList;
    public static volatile SingularAttribute<Campo, String> descripcion;
    public static volatile SingularAttribute<Campo, Integer> idCampo;
    public static volatile SingularAttribute<Campo, Integer> activo;
    public static volatile SingularAttribute<Campo, Cuenta> idCuenta;

}