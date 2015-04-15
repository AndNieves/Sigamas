package uy.edu.ort.sigamas.insumos.entidades;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import uy.edu.ort.sigamas.campos.entidades.Campo;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-04-15T00:45:57")
@StaticMetamodel(Valor.class)
public class Valor_ { 

    public static volatile SingularAttribute<Valor, String> valor;
    public static volatile SingularAttribute<Valor, String> unidad;
    public static volatile ListAttribute<Valor, Campo> campoList;
    public static volatile SingularAttribute<Valor, Integer> idValor;
    public static volatile SingularAttribute<Valor, Integer> activo;

}