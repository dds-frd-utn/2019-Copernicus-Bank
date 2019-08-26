/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utn.frd.copernicus.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Evelyn
 */
@Entity
@Table(name = "informacion_personal")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "InformacionPersonal.findAll", query = "SELECT i FROM InformacionPersonal i")
    , @NamedQuery(name = "InformacionPersonal.findByIdIP", query = "SELECT i FROM InformacionPersonal i WHERE i.idIP = :idIP")
    , @NamedQuery(name = "InformacionPersonal.findByIdCliente", query = "SELECT i FROM InformacionPersonal i WHERE i.idCliente = :idCliente")
    , @NamedQuery(name = "InformacionPersonal.findByCuil", query = "SELECT i FROM InformacionPersonal i WHERE i.cuil = :cuil")
    , @NamedQuery(name = "InformacionPersonal.findByDomicilio", query = "SELECT i FROM InformacionPersonal i WHERE i.domicilio = :domicilio")
    , @NamedQuery(name = "InformacionPersonal.findByTelefono", query = "SELECT i FROM InformacionPersonal i WHERE i.telefono = :telefono")
    , @NamedQuery(name = "InformacionPersonal.findByEmail", query = "SELECT i FROM InformacionPersonal i WHERE i.email = :email")
    , @NamedQuery(name = "InformacionPersonal.findBySexo", query = "SELECT i FROM InformacionPersonal i WHERE i.sexo = :sexo")
    , @NamedQuery(name = "InformacionPersonal.findByActualizado", query = "SELECT i FROM InformacionPersonal i WHERE i.actualizado = :actualizado")})
public class InformacionPersonal implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idIP")
    private Long idIP;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idCliente")
    private long idCliente;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cuil")
    private long cuil;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "domicilio")
    private String domicilio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "telefono")
    private int telefono;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "email")
    private String email;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "sexo")
    private String sexo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "actualizado")
    @Temporal(TemporalType.TIMESTAMP)
    private Date actualizado;

    public InformacionPersonal() {
    }

    public InformacionPersonal(Long idIP) {
        this.idIP = idIP;
    }

    public InformacionPersonal(Long idIP, long idCliente, long cuil, String domicilio, int telefono, String email, String sexo, Date actualizado) {
        this.idIP = idIP;
        this.idCliente = idCliente;
        this.cuil = cuil;
        this.domicilio = domicilio;
        this.telefono = telefono;
        this.email = email;
        this.sexo = sexo;
        this.actualizado = actualizado;
    }

    public Long getIdIP() {
        return idIP;
    }

    public void setIdIP(Long idIP) {
        this.idIP = idIP;
    }

    public long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(long idCliente) {
        this.idCliente = idCliente;
    }

    public long getCuil() {
        return cuil;
    }

    public void setCuil(long cuil) {
        this.cuil = cuil;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public Date getActualizado() {
        return actualizado;
    }

    public void setActualizado(Date actualizado) {
        this.actualizado = actualizado;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idIP != null ? idIP.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof InformacionPersonal)) {
            return false;
        }
        InformacionPersonal other = (InformacionPersonal) object;
        if ((this.idIP == null && other.idIP != null) || (this.idIP != null && !this.idIP.equals(other.idIP))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "utn.frd.copernicus.entity.InformacionPersonal[ idIP=" + idIP + " ]";
    }
    
}
