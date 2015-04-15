package uy.edu.ort.sigamas.insumos.entidades;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import uy.edu.ort.sigamas.campos.entidades.Campo;
import uy.edu.ort.sigamas.insumos.entidades.InsumoTarea;
import uy.edu.ort.sigamas.seguridad.entidades.Cuenta;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-04-15T00:45:57")
@StaticMetamodel(Insumo.class)
public class Insumo_ { 

    public static volatile SingularAttribute<Insumo, Integer> codigo;
    public static volatile SingularAttribute<Insumo, String> nombre;
    public static volatile SingularAttribute<Insumo, String> tipo;
    public static volatile SingularAttribute<Insumo, Integer> idInsumo;
    public static volatile SingularAttribute<Insumo, String> descripcion;
    public static volatile SingularAttribute<Insumo, String> familia;
    public static volatile ListAttribute<Insumo, Campo> campoList;
    public static volatile SingularAttribute<Insumo, Integer> activo;
    public static volatile SingularAttribute<Insumo, Cuenta> idCuenta;
    public static volatile ListAttribute<Insumo, InsumoTarea> insumoTareaList;

}