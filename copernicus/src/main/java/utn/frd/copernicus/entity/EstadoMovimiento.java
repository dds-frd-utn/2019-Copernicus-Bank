/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utn.frd.copernicus.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Evelyn
 */
@Entity
@Table(name = "estado_movimiento")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EstadoMovimiento.findAll", query = "SELECT e FROM EstadoMovimiento e")
    , @NamedQuery(name = "EstadoMovimiento.findByIdET", query = "SELECT e FROM EstadoMovimiento e WHERE e.idET = :idET")
    , @NamedQuery(name = "EstadoMovimiento.findByDescripcion", query = "SELECT e FROM EstadoMovimiento e WHERE e.descripcion = :descripcion")})
public class EstadoMovimiento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idET")
    private Long idET;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "descripcion")
    private String descripcion;

    public EstadoMovimiento() {
    }

    public EstadoMovimiento(Long idET) {
        this.idET = idET;
    }

    public EstadoMovimiento(Long idET, String descripcion) {
        this.idET = idET;
        this.descripcion = descripcion;
    }

    public Long getIdET() {
        return idET;
    }

    public void setIdET(Long idET) {
        this.idET = idET;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idET != null ? idET.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EstadoMovimiento)) {
            return false;
        }
        EstadoMovimiento other = (EstadoMovimiento) object;
        if ((this.idET == null && other.idET != null) || (this.idET != null && !this.idET.equals(other.idET))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "utn.frd.copernicus.entity.EstadoMovimiento[ idET=" + idET + " ]";
    }
    
}
