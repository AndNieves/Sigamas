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
import uy.edu.ort.sigamas.cultivos.entidades.Subfase;

/**
 *
 * @author Mattahari
 */
@Entity
@Table(name = "subfase_actual", catalog = "sigamas_sigamas", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SubfaseActual.findAll", query = "SELECT s FROM SubfaseActual s"),
    @NamedQuery(name = "SubfaseActual.findByIdsubfaseActual", query = "SELECT s FROM SubfaseActual s WHERE s.idsubfaseActual = :idsubfaseActual"),
    @NamedQuery(name = "SubfaseActual.findByCondiciones", query = "SELECT s FROM SubfaseActual s WHERE s.condiciones = :condiciones"),
    @NamedQuery(name = "SubfaseActual.findByFechaModificado", query = "SELECT s FROM SubfaseActual s WHERE s.fechaModificado = :fechaModificado")})
public class SubfaseActual implements Serializable {
    @JoinColumn(name = "id_subfase", referencedColumnName = "id_subfase")
    @ManyToOne(fetch = FetchType.EAGER)
    private Subfase idSubfase;
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idsubfase_actual", nullable = false)
    private Integer idsubfaseActual;
    @Column(name = "condiciones", length = 200)
    private String condiciones;
    @Column(name = "fecha_modificado")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaModificado;
    @OneToMany(mappedBy = "idFaseActual", fetch = FetchType.EAGER)
    private List<Proyecto> proyectoList;

    public SubfaseActual() {
    }

    public SubfaseActual(Integer idsubfaseActual) {
        this.idsubfaseActual = idsubfaseActual;
    }

    public Integer getIdsubfaseActual() {
        return idsubfaseActual;
    }

    public void setIdsubfaseActual(Integer idsubfaseActual) {
        this.idsubfaseActual = idsubfaseActual;
    }

    public String getCondiciones() {
        return condiciones;
    }

    public void setCondiciones(String condiciones) {
        this.condiciones = condiciones;
    }

    public Date getFechaModificado() {
        return fechaModificado;
    }

    public void setFechaModificado(Date fechaModificado) {
        this.fechaModificado = fechaModificado;
    }

    @XmlTransient
    public List<Proyecto> getProyectoList() {
        return proyectoList;
    }

    public void setProyectoList(List<Proyecto> proyectoList) {
        this.proyectoList = proyectoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idsubfaseActual != null ? idsubfaseActual.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SubfaseActual)) {
            return false;
        }
        SubfaseActual other = (SubfaseActual) object;
        if ((this.idsubfaseActual == null && other.idsubfaseActual != null) || (this.idsubfaseActual != null && !this.idsubfaseActual.equals(other.idsubfaseActual))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "uy.edu.ort.sigamas.seguimiento.entidades.SubfaseActual[ idsubfaseActual=" + idsubfaseActual + " ]";
    }

    public Subfase getIdSubfase() {
        return idSubfase;
    }

    public void setIdSubfase(Subfase idSubfase) {
        this.idSubfase = idSubfase;
    }
    
}
