/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uy.edu.ort.sigamas.seguimiento.entidades;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import uy.edu.ort.sigamas.cultivos.entidades.Cultivo;
import uy.edu.ort.sigamas.cultivos.entidades.Subfase;
import uy.edu.ort.sigamas.seguridad.entidades.Cuenta;

/**
 *
 * @author Mattahari
 */
@Entity
@Table(name = "proyecto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Proyecto.findAll", query = "SELECT p FROM Proyecto p"),
    @NamedQuery(name = "Proyecto.findByIdProyecto", query = "SELECT p FROM Proyecto p WHERE p.idProyecto = :idProyecto"),
    @NamedQuery(name = "Proyecto.findByNombre", query = "SELECT p FROM Proyecto p WHERE p.nombre = :nombre"),
    @NamedQuery(name = "Proyecto.findByFechaInicio", query = "SELECT p FROM Proyecto p WHERE p.fechaInicio = :fechaInicio")})
public class Proyecto implements Serializable {
    @Column(name = "fecha_fin_prevista")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaFinPrevista;
    @OneToMany(mappedBy = "idProyecto", fetch = FetchType.EAGER)
    private List<TareaReal> tareaRealList;
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_proyecto")
    private Integer idProyecto;
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "fecha_inicio")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaInicio;
    @JoinColumn(name = "id_fase_planificada", referencedColumnName = "id_subfase")
    @ManyToOne(fetch = FetchType.EAGER)
    private Subfase idFasePlanificada;
    @JoinColumn(name = "id_fase_actual", referencedColumnName = "idsubfase_actual")
    @ManyToOne(fetch = FetchType.EAGER)
    private SubfaseActual idFaseActual;
    @JoinColumn(name = "id_cultivo", referencedColumnName = "id_cultivo")
    @ManyToOne(fetch = FetchType.EAGER)
    private Cultivo idCultivo;
    @JoinColumn(name = "id_cuenta", referencedColumnName = "id_cuenta")
    @ManyToOne(fetch = FetchType.EAGER)
    private Cuenta idCuenta;

    public Proyecto() {
    }

    public Proyecto(Integer idProyecto) {
        this.idProyecto = idProyecto;
    }

    public Proyecto(Integer idProyecto, String nombre) {
        this.idProyecto = idProyecto;
        this.nombre = nombre;
    }

    public Integer getIdProyecto() {
        return idProyecto;
    }

    public void setIdProyecto(Integer idProyecto) {
        this.idProyecto = idProyecto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Subfase getIdFasePlanificada() {
        return idFasePlanificada;
    }

    public void setIdFasePlanificada(Subfase idFasePlanificada) {
        this.idFasePlanificada = idFasePlanificada;
    }

    public SubfaseActual getIdFaseActual() {
        return idFaseActual;
    }

    public void setIdFaseActual(SubfaseActual idFaseActual) {
        this.idFaseActual = idFaseActual;
    }

    public Cultivo getIdCultivo() {
        return idCultivo;
    }

    public void setIdCultivo(Cultivo idCultivo) {
        this.idCultivo = idCultivo;
    }

    public Cuenta getIdCuenta() {
        return idCuenta;
    }

    public void setIdCuenta(Cuenta idCuenta) {
        this.idCuenta = idCuenta;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idProyecto != null ? idProyecto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Proyecto)) {
            return false;
        }
        Proyecto other = (Proyecto) object;
        if ((this.idProyecto == null && other.idProyecto != null) || (this.idProyecto != null && !this.idProyecto.equals(other.idProyecto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "uy.edu.ort.sigamas.seguimiento.entidades.Proyecto[ idProyecto=" + idProyecto + " ]";
    }

    @XmlTransient
    public List<TareaReal> getTareaRealList() {
        return tareaRealList;
    }

    public void setTareaRealList(List<TareaReal> tareaRealList) {
        this.tareaRealList = tareaRealList;
    }

    public Date getFechaFinPrevista() {
        return fechaFinPrevista;
    }

    public void setFechaFinPrevista(Date fechaFinPrevista) {
        this.fechaFinPrevista = fechaFinPrevista;
    }
    
}
