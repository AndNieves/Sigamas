/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uy.edu.ort.sigamas.cultivos.entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Mattahari
 */
@Entity
@Table(name = "codiguera_plan_cultivo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CodigueraPlanCultivo.findAll", query = "SELECT c FROM CodigueraPlanCultivo c"),
    @NamedQuery(name = "CodigueraPlanCultivo.findByIdcodigueraPlanCultivo", query = "SELECT c FROM CodigueraPlanCultivo c WHERE c.idcodigueraPlanCultivo = :idcodigueraPlanCultivo"),
    @NamedQuery(name = "CodigueraPlanCultivo.findByNombrePlan", query = "SELECT c FROM CodigueraPlanCultivo c WHERE c.nombrePlan = :nombrePlan"),
    @NamedQuery(name = "CodigueraPlanCultivo.findByCodigueraPlanCultivocol", query = "SELECT c FROM CodigueraPlanCultivo c WHERE c.codigueraPlanCultivocol = :codigueraPlanCultivocol"),
    @NamedQuery(name = "CodigueraPlanCultivo.findByIdCultivo", query = "SELECT c FROM CodigueraPlanCultivo c WHERE c.idCultivo = :idCultivo")})
public class CodigueraPlanCultivo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idcodiguera_plan_cultivo")
    private Integer idcodigueraPlanCultivo;
    @Column(name = "nombre_plan")
    private String nombrePlan;
    @Column(name = "codiguera_plan_cultivocol")
    private String codigueraPlanCultivocol;
    @Column(name = "id_cultivo")
    private Integer idCultivo;

    public CodigueraPlanCultivo() {
    }

    public CodigueraPlanCultivo(Integer idcodigueraPlanCultivo) {
        this.idcodigueraPlanCultivo = idcodigueraPlanCultivo;
    }

    public Integer getIdcodigueraPlanCultivo() {
        return idcodigueraPlanCultivo;
    }

    public void setIdcodigueraPlanCultivo(Integer idcodigueraPlanCultivo) {
        this.idcodigueraPlanCultivo = idcodigueraPlanCultivo;
    }

    public String getNombrePlan() {
        return nombrePlan;
    }

    public void setNombrePlan(String nombrePlan) {
        this.nombrePlan = nombrePlan;
    }

    public String getCodigueraPlanCultivocol() {
        return codigueraPlanCultivocol;
    }

    public void setCodigueraPlanCultivocol(String codigueraPlanCultivocol) {
        this.codigueraPlanCultivocol = codigueraPlanCultivocol;
    }

    public Integer getIdCultivo() {
        return idCultivo;
    }

    public void setIdCultivo(Integer idCultivo) {
        this.idCultivo = idCultivo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idcodigueraPlanCultivo != null ? idcodigueraPlanCultivo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CodigueraPlanCultivo)) {
            return false;
        }
        CodigueraPlanCultivo other = (CodigueraPlanCultivo) object;
        if ((this.idcodigueraPlanCultivo == null && other.idcodigueraPlanCultivo != null) || (this.idcodigueraPlanCultivo != null && !this.idcodigueraPlanCultivo.equals(other.idcodigueraPlanCultivo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "uy.edu.ort.sigamas.cultivos.entidades.CodigueraPlanCultivo[ idcodigueraPlanCultivo=" + idcodigueraPlanCultivo + " ]";
    }
    
}
