package uy.edu.ort.sigamas.cultivos.entidades;

import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import uy.edu.ort.sigamas.cultivos.entidades.Subfase;
import uy.edu.ort.sigamas.seguimiento.entidades.Proyecto;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-04-15T00:45:57")
@StaticMetamodel(Cultivo.class)
public class Cultivo_ { 

    public static volatile SingularAttribute<Cultivo, String> nombre;
    public static volatile SingularAttribute<Cultivo, BigDecimal> coeficiente;
    public static volatile SingularAttribute<Cultivo, Integer> tipo;
    public static volatile ListAttribute<Cultivo, Proyecto> proyectoList;
    public static volatile SingularAttribute<Cultivo, Integer> idCultivo;
    public static volatile ListAttribute<Cultivo, Subfase> subfaseList;

}