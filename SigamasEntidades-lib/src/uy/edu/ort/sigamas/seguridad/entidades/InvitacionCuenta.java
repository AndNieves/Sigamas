/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uy.edu.ort.sigamas.seguridad.entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import uy.edu.ort.sigamas.enums.EstadosInvitacion;

/**
 *
 * @author Mattahari
 */
@Entity
@Table(name = "invitacion_cuenta")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "InvitacionCuenta.findAll", query = "SELECT i FROM InvitacionCuenta i"),
    @NamedQuery(name = "InvitacionCuenta.findByIdinvitacionCuenta", query = "SELECT i FROM InvitacionCuenta i WHERE i.idinvitacionCuenta = :idinvitacionCuenta"),
    @NamedQuery(name = "InvitacionCuenta.findByEmisor", query = "SELECT i FROM InvitacionCuenta i WHERE i.emisor = :emisor"),
    @NamedQuery(name = "InvitacionCuenta.findByReceptor", query = "SELECT i FROM InvitacionCuenta i WHERE i.receptor = :receptor"),
    @NamedQuery(name = "InvitacionCuenta.findByEstado", query = "SELECT i FROM InvitacionCuenta i WHERE i.estado = :estado"),
    @NamedQuery(name = "InvitacionCuenta.findByIdCuenta", query = "SELECT i FROM InvitacionCuenta i WHERE i.idCuenta = :idCuenta")})
public class InvitacionCuenta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idinvitacion_cuenta")
    private Integer idinvitacionCuenta;
    @Column(name = "emisor")
    private String emisor;
    @Column(name = "receptor")
    private String receptor;
    @Column(name = "estado")
    @Enumerated(EnumType.STRING)
    private EstadosInvitacion estado;
    @Column(name = "id_cuenta")
    private Integer idCuenta;

    public InvitacionCuenta() {
    }

    public InvitacionCuenta(Integer idinvitacionCuenta) {
        this.idinvitacionCuenta = idinvitacionCuenta;
    }

    public Integer getIdinvitacionCuenta() {
        return idinvitacionCuenta;
    }

    public void setIdinvitacionCuenta(Integer idinvitacionCuenta) {
        this.idinvitacionCuenta = idinvitacionCuenta;
    }

    public String getEmisor() {
        return emisor;
    }

    public void setEmisor(String emisor) {
        this.emisor = emisor;
    }

    public String getReceptor() {
        return receptor;
    }

    public void setReceptor(String receptor) {
        this.receptor = receptor;
    }

    public EstadosInvitacion getEstado() {
        return estado;
    }

    public void setEstado(EstadosInvitacion estado) {
        this.estado = estado;
    }

    public Integer getIdCuenta() {
        return idCuenta;
    }

    public void setIdCuenta(Integer idCuenta) {
        this.idCuenta = idCuenta;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idinvitacionCuenta != null ? idinvitacionCuenta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof InvitacionCuenta)) {
            return false;
        }
        InvitacionCuenta other = (InvitacionCuenta) object;
        if ((this.idinvitacionCuenta == null && other.idinvitacionCuenta != null) || (this.idinvitacionCuenta != null && !this.idinvitacionCuenta.equals(other.idinvitacionCuenta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "uy.edu.ort.sigamas.seguridad.entidades.InvitacionCuenta[ idinvitacionCuenta=" + idinvitacionCuenta + " ]";
    }

}
