package uy.edu.ort.sigamas.insumos.entidades;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import uy.edu.ort.sigamas.insumos.entidades.Insumo;
import uy.edu.ort.sigamas.seguimiento.entidades.TareaPlanificada;
import uy.edu.ort.sigamas.seguimiento.entidades.TareaReal;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-04-15T00:45:57")
@StaticMetamodel(InsumoTarea.class)
public class InsumoTarea_ { 

    public static volatile SingularAttribute<InsumoTarea, TareaPlanificada> idTareaPlanificada;
    public static volatile SingularAttribute<InsumoTarea, Insumo> idInsumo;
    public static volatile SingularAttribute<InsumoTarea, Integer> idInsumoTarea;
    public static volatile SingularAttribute<InsumoTarea, TareaReal> idTareaReal;

}