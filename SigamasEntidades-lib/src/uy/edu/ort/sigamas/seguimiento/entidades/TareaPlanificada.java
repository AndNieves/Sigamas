/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uy.edu.ort.sigamas.seguimiento.entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import uy.edu.ort.sigamas.cultivos.entidades.Subfase;

/**
 *
 * @author Mattahari
 */
@Entity
@Table(name = "tarea_planificada")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TareaPlanificada.findAll", query = "SELECT t FROM TareaPlanificada t"),
    @NamedQuery(name = "TareaPlanificada.findByIdTareaPlanificada", query = "SELECT t FROM TareaPlanificada t WHERE t.idTareaPlanificada = :idTareaPlanificada"),
    @NamedQuery(name = "TareaPlanificada.findByNombre", query = "SELECT t FROM TareaPlanificada t WHERE t.nombre = :nombre"),
    @NamedQuery(name = "TareaPlanificada.findByDias", query = "SELECT t FROM TareaPlanificada t WHERE t.dias = :dias"),
    @NamedQuery(name = "TareaPlanificada.findByDuracionDias", query = "SELECT t FROM TareaPlanificada t WHERE t.duracionDias = :duracionDias"),
    @NamedQuery(name = "TareaPlanificada.findByCodigoPlanCultivo", query = "SELECT t FROM TareaPlanificada t WHERE t.codigoPlanCultivo = :codigoPlanCultivo"),
    @NamedQuery(name = "TareaPlanificada.findByGeneradaPorFasebio", query = "SELECT t FROM TareaPlanificada t WHERE t.generadaPorFasebio = :generadaPorFasebio")})
public class TareaPlanificada implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_tarea_planificada")
    private Integer idTareaPlanificada;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "dias")
    private Integer dias;
    @Column(name = "duracion_dias")
    private Integer duracionDias;
    @Column(name = "codigo_plan_cultivo")
    private Integer codigoPlanCultivo;
    @Column(name = "generada_por_fasebio")
    private Integer generadaPorFasebio;
    @OneToMany(mappedBy = "idTareaPredecesora", fetch = FetchType.EAGER)
    private List<TareaPlanificada> tareaPlanificadaList;
    @JoinColumn(name = "id_tarea_predecesora", referencedColumnName = "id_tarea_planificada")
    @ManyToOne(fetch = FetchType.EAGER)
    private TareaPlanificada idTareaPredecesora;
    @JoinColumn(name = "id_subfase", referencedColumnName = "id_subfase")
    @ManyToOne(fetch = FetchType.EAGER)
    private Subfase idSubfase;

    public TareaPlanificada() {
    }

    public TareaPlanificada(Integer idTareaPlanificada) {
        this.idTareaPlanificada = idTareaPlanificada;
    }

    public Integer getIdTareaPlanificada() {
        return idTareaPlanificada;
    }

    public void setIdTareaPlanificada(Integer idTareaPlanificada) {
        this.idTareaPlanificada = idTareaPlanificada;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getDias() {
        return dias;
    }

    public void setDias(Integer dias) {
        this.dias = dias;
    }

    public Integer getDuracionDias() {
        return duracionDias;
    }

    public void setDuracionDias(Integer duracionDias) {
        this.duracionDias = duracionDias;
    }

    public Integer getCodigoPlanCultivo() {
        return codigoPlanCultivo;
    }

    public void setCodigoPlanCultivo(Integer codigoPlanCultivo) {
        this.codigoPlanCultivo = codigoPlanCultivo;
    }

    public Integer getGeneradaPorFasebio() {
        return generadaPorFasebio;
    }

    public void setGeneradaPorFasebio(Integer generadaPorFasebio) {
        this.generadaPorFasebio = generadaPorFasebio;
    }

    @XmlTransient
    public List<TareaPlanificada> getTareaPlanificadaList() {
        return tareaPlanificadaList;
    }

    public void setTareaPlanificadaList(List<TareaPlanificada> tareaPlanificadaList) {
        this.tareaPlanificadaList = tareaPlanificadaList;
    }

    public TareaPlanificada getIdTareaPredecesora() {
        return idTareaPredecesora;
    }

    public void setIdTareaPredecesora(TareaPlanificada idTareaPredecesora) {
        this.idTareaPredecesora = idTareaPredecesora;
    }

    public Subfase getIdSubfase() {
        return idSubfase;
    }

    public void setIdSubfase(Subfase idSubfase) {
        this.idSubfase = idSubfase;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTareaPlanificada != null ? idTareaPlanificada.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TareaPlanificada)) {
            return false;
        }
        TareaPlanificada other = (TareaPlanificada) object;
        if ((this.idTareaPlanificada == null && other.idTareaPlanificada != null) || (this.idTareaPlanificada != null && !this.idTareaPlanificada.equals(other.idTareaPlanificada))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "uy.edu.ort.sigamas.seguimiento.entidades.TareaPlanificada[ idTareaPlanificada=" + idTareaPlanificada + " ]";
    }
    
}
