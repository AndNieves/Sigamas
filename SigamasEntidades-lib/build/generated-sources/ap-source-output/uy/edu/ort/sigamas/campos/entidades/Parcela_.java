package uy.edu.ort.sigamas.campos.entidades;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import uy.edu.ort.sigamas.seguridad.entidades.Cuenta;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-04-15T00:45:57")
@StaticMetamodel(Parcela.class)
public class Parcela_ { 

    public static volatile SingularAttribute<Parcela, String> nombre;
    public static volatile SingularAttribute<Parcela, Integer> idParcela;
    public static volatile SingularAttribute<Parcela, String> departamento;
    public static volatile SingularAttribute<Parcela, String> padron;
    public static volatile SingularAttribute<Parcela, Cuenta> idCuenta;

}