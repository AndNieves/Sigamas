/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uy.edu.ort.sigamas.seguridad.entidades;

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

/**
 *
 * @author Pikachuss
 */
@Entity
@Table(name = "subfase", catalog = "sigamas_sigamas", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Subfase.findAll", query = "SELECT s FROM Subfase s"),
    @NamedQuery(name = "Subfase.findByIdSubfase", query = "SELECT s FROM Subfase s WHERE s.idSubfase = :idSubfase"),
    @NamedQuery(name = "Subfase.findByNombre", query = "SELECT s FROM Subfase s WHERE s.nombre = :nombre"),
    @NamedQuery(name = "Subfase.findByDias", query = "SELECT s FROM Subfase s WHERE s.dias = :dias"),
    @NamedQuery(name = "Subfase.findByDescripcion", query = "SELECT s FROM Subfase s WHERE s.descripcion = :descripcion")})
public class Subfase implements Serializable {
    @OneToMany(mappedBy = "idSubfase", fetch = FetchType.EAGER)
    private List<TareaPlanificada> tareaPlanificadaList;
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_subfase", nullable = false)
    private Integer idSubfase;
    @Column(name = "nombre", length = 45)
    private String nombre;
    @Column(name = "dias")
    private Integer dias;
    @Column(name = "descripcion", length = 45)
    private String descripcion;
    @JoinColumn(name = "id_cultivo", referencedColumnName = "id_cultivo")
    @ManyToOne(fetch = FetchType.EAGER)
    private Cultivo idCultivo;
    @JoinColumn(name = "id_fase", referencedColumnName = "id_fase")
    @ManyToOne(fetch = FetchType.EAGER)
    private Fase idFase;

    public Subfase() {
    }

    public Subfase(Integer idSubfase) {
        this.idSubfase = idSubfase;
    }

    public Integer getIdSubfase() {
        return idSubfase;
    }

    public void setIdSubfase(Integer idSubfase) {
        this.idSubfase = idSubfase;
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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Cultivo getIdCultivo() {
        return idCultivo;
    }

    public void setIdCultivo(Cultivo idCultivo) {
        this.idCultivo = idCultivo;
    }

    public Fase getIdFase() {
        return idFase;
    }

    public void setIdFase(Fase idFase) {
        this.idFase = idFase;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSubfase != null ? idSubfase.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Subfase)) {
            return false;
        }
        Subfase other = (Subfase) object;
        if ((this.idSubfase == null && other.idSubfase != null) || (this.idSubfase != null && !this.idSubfase.equals(other.idSubfase))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "uy.edu.ort.sigamas.seguridad.entidades.Subfase[ idSubfase=" + idSubfase + " ]";
    }

    @XmlTransient
    public List<TareaPlanificada> getTareaPlanificadaList() {
        return tareaPlanificadaList;
    }

    public void setTareaPlanificadaList(List<TareaPlanificada> tareaPlanificadaList) {
        this.tareaPlanificadaList = tareaPlanificadaList;
    }
    
}