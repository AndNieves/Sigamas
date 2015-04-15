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
@Table(name = "rel_usuario_cuenta_rol")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RelUsuarioCuentaRol.findAll", query = "SELECT r FROM RelUsuarioCuentaRol r"),
    @NamedQuery(name = "RelUsuarioCuentaRol.findByIdrelUsuarioCuentaRol", query = "SELECT r FROM RelUsuarioCuentaRol r WHERE r.idrelUsuarioCuentaRol = :idrelUsuarioCuentaRol")})
public class RelUsuarioCuentaRol implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idrel_usuario_cuenta_rol")
    private Integer idrelUsuarioCuentaRol;
    @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario")
    @ManyToOne(fetch = FetchType.EAGER)
    private Usuario idUsuario;
    @JoinColumn(name = "id_rol", referencedColumnName = "id_rol")
    @ManyToOne(fetch = FetchType.EAGER)
    private Rol idRol;
    @JoinColumn(name = "id_cuenta", referencedColumnName = "id_cuenta")
    @ManyToOne(fetch = FetchType.EAGER)
    private Cuenta idCuenta;

    public RelUsuarioCuentaRol() {
    }

    public RelUsuarioCuentaRol(Integer idrelUsuarioCuentaRol) {
        this.idrelUsuarioCuentaRol = idrelUsuarioCuentaRol;
    }

    public Integer getIdrelUsuarioCuentaRol() {
        return idrelUsuarioCuentaRol;
    }

    public void setIdrelUsuarioCuentaRol(Integer idrelUsuarioCuentaRol) {
        this.idrelUsuarioCuentaRol = idrelUsuarioCuentaRol;
    }

    public Usuario getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Usuario idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Rol getIdRol() {
        return idRol;
    }

    public void setIdRol(Rol idRol) {
        this.idRol = idRol;
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
        hash += (idrelUsuarioCuentaRol != null ? idrelUsuarioCuentaRol.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RelUsuarioCuentaRol)) {
            return false;
        }
        RelUsuarioCuentaRol other = (RelUsuarioCuentaRol) object;
        if ((this.idrelUsuarioCuentaRol == null && other.idrelUsuarioCuentaRol != null) || (this.idrelUsuarioCuentaRol != null && !this.idrelUsuarioCuentaRol.equals(other.idrelUsuarioCuentaRol))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "uy.edu.ort.sigamas.seguridad.entidades.RelUsuarioCuentaRol[ idrelUsuarioCuentaRol=" + idrelUsuarioCuentaRol + " ]";
    }
    
}
