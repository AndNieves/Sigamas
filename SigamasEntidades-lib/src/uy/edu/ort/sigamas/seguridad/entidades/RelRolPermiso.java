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
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Mattahari
 */
@Entity
@Table(name = "rel_rol_permiso")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RelRolPermiso.findAll", query = "SELECT r FROM RelRolPermiso r"),
    @NamedQuery(name = "RelRolPermiso.findByIdrelRolPermiso", query = "SELECT r FROM RelRolPermiso r WHERE r.idrelRolPermiso = :idrelRolPermiso")})
public class RelRolPermiso implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idrel_rol_permiso")
    private Integer idrelRolPermiso;
    @JoinColumn(name = "id_rol", referencedColumnName = "id_rol")
    @ManyToOne(fetch = FetchType.EAGER)
    private Rol idRol;
    @JoinColumn(name = "id_permiso", referencedColumnName = "id_permiso")
    @ManyToOne(fetch = FetchType.EAGER)
    private Permiso idPermiso;

    public RelRolPermiso() {
    }

    public RelRolPermiso(Integer idrelRolPermiso) {
        this.idrelRolPermiso = idrelRolPermiso;
    }

    public Integer getIdrelRolPermiso() {
        return idrelRolPermiso;
    }

    public void setIdrelRolPermiso(Integer idrelRolPermiso) {
        this.idrelRolPermiso = idrelRolPermiso;
    }

    public Rol getIdRol() {
        return idRol;
    }

    public void setIdRol(Rol idRol) {
        this.idRol = idRol;
    }

    public Permiso getIdPermiso() {
        return idPermiso;
    }

    public void setIdPermiso(Permiso idPermiso) {
        this.idPermiso = idPermiso;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idrelRolPermiso != null ? idrelRolPermiso.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RelRolPermiso)) {
            return false;
        }
        RelRolPermiso other = (RelRolPermiso) object;
        if ((this.idrelRolPermiso == null && other.idrelRolPermiso != null) || (this.idrelRolPermiso != null && !this.idrelRolPermiso.equals(other.idrelRolPermiso))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "uy.edu.ort.sigamas.seguridad.entidades.RelRolPermiso[ idrelRolPermiso=" + idrelRolPermiso + " ]";
    }
    
}
