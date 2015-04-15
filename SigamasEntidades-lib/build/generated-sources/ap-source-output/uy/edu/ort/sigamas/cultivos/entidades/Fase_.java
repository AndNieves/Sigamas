package uy.edu.ort.sigamas.cultivos.entidades;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import uy.edu.ort.sigamas.cultivos.entidades.Subfase;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-04-15T00:45:57")
@StaticMetamodel(Fase.class)
public class Fase_ { 

    public static volatile SingularAttribute<Fase, Integer> idFase;
    public static volatile SingularAttribute<Fase, String> nombre;
    public static volatile ListAttribute<Fase, Subfase> subfaseList;
    public static volatile SingularAttribute<Fase, String> nombreCorto;

}