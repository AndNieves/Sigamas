package uy.edu.ort.sigamas.cultivos.entidades;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import uy.edu.ort.sigamas.cultivos.entidades.Cultivo;
import uy.edu.ort.sigamas.cultivos.entidades.Fase;
import uy.edu.ort.sigamas.seguimiento.entidades.Proyecto;
import uy.edu.ort.sigamas.seguimiento.entidades.TareaPlanificada;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-04-15T00:45:57")
@StaticMetamodel(Subfase.class)
public class Subfase_ { 

    public static volatile SingularAttribute<Subfase, String> nombre;
    public static volatile SingularAttribute<Subfase, Fase> idFase;
    public static volatile CollectionAttribute<Subfase, TareaPlanificada> tareaPlanificadaCollection;
    public static volatile SingularAttribute<Subfase, Integer> idSubfase;
    public static volatile SingularAttribute<Subfase, String> etapa;
    public static volatile SingularAttribute<Subfase, String> descripcion;
    public static volatile SingularAttribute<Subfase, String> condiciones;
    public static volatile SingularAttribute<Subfase, Cultivo> idCultivo;
    public static volatile CollectionAttribute<Subfase, Proyecto> proyectoCollection;
    public static volatile SingularAttribute<Subfase, Integer> dias;

}