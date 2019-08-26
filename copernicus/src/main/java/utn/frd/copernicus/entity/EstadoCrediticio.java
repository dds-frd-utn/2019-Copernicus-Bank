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
@Table(name = "estado_crediticio")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EstadoCrediticio.findAll", query = "SELECT e FROM EstadoCrediticio e")
    , @NamedQuery(name = "EstadoCrediticio.findByIdEC", query = "SELECT e FROM EstadoCrediticio e WHERE e.idEC = :idEC")
    , @NamedQuery(name = "EstadoCrediticio.findByDescripcion", query = "SELECT e FROM EstadoCrediticio e WHERE e.descripcion = :descripcion")})
public class EstadoCrediticio implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idEC")
    private Long idEC;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "descripcion")
    private String descripcion;

    public EstadoCrediticio() {
    }

    public EstadoCrediticio(Long idEC) {
        this.idEC = idEC;
    }

    public EstadoCrediticio(Long idEC, String descripcion) {
        this.idEC = idEC;
        this.descripcion = descripcion;
    }

    public Long getIdEC() {
        return idEC;
    }

    public void setIdEC(Long idEC) {
        this.idEC = idEC;
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
        hash += (idEC != null ? idEC.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EstadoCrediticio)) {
            return false;
        }
        EstadoCrediticio other = (EstadoCrediticio) object;
        if ((this.idEC == null && other.idEC != null) || (this.idEC != null && !this.idEC.equals(other.idEC))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "utn.frd.copernicus.entity.EstadoCrediticio[ idEC=" + idEC + " ]";
    }
    
}
