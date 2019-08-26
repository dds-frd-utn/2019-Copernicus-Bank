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
@Table(name = "transferencia")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Transferencia.findAll", query = "SELECT t FROM Transferencia t")
    , @NamedQuery(name = "Transferencia.findByIdTransaccion", query = "SELECT t FROM Transferencia t WHERE t.idTransaccion = :idTransaccion")
    , @NamedQuery(name = "Transferencia.findByIdMovimiento", query = "SELECT t FROM Transferencia t WHERE t.idMovimiento = :idMovimiento")
    , @NamedQuery(name = "Transferencia.findByIdDestino", query = "SELECT t FROM Transferencia t WHERE t.idDestino = :idDestino")
    , @NamedQuery(name = "Transferencia.findByFechaInicio", query = "SELECT t FROM Transferencia t WHERE t.fechaInicio = :fechaInicio")
    , @NamedQuery(name = "Transferencia.findByFechaFin", query = "SELECT t FROM Transferencia t WHERE t.fechaFin = :fechaFin")
    , @NamedQuery(name = "Transferencia.findByImporte", query = "SELECT t FROM Transferencia t WHERE t.importe = :importe")
    , @NamedQuery(name = "Transferencia.findByImpuesto", query = "SELECT t FROM Transferencia t WHERE t.impuesto = :impuesto")})
public class Transferencia implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idTransaccion")
    private Long idTransaccion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idMovimiento")
    private long idMovimiento;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "idDestino")
    private String idDestino;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechaInicio")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaInicio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechaFin")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaFin;
    @Basic(optional = false)
    @NotNull
    @Column(name = "importe")
    private double importe;
    @Basic(optional = false)
    @NotNull
    @Column(name = "impuesto")
    private double impuesto;

    public Transferencia() {
    }

    public Transferencia(Long idTransaccion) {
        this.idTransaccion = idTransaccion;
    }

    public Transferencia(Long idTransaccion, long idMovimiento, String idDestino, Date fechaInicio, Date fechaFin, double importe, double impuesto) {
        this.idTransaccion = idTransaccion;
        this.idMovimiento = idMovimiento;
        this.idDestino = idDestino;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.importe = importe;
        this.impuesto = impuesto;
    }

    public Long getIdTransaccion() {
        return idTransaccion;
    }

    public void setIdTransaccion(Long idTransaccion) {
        this.idTransaccion = idTransaccion;
    }

    public long getIdMovimiento() {
        return idMovimiento;
    }

    public void setIdMovimiento(long idMovimiento) {
        this.idMovimiento = idMovimiento;
    }

    public String getIdDestino() {
        return idDestino;
    }

    public void setIdDestino(String idDestino) {
        this.idDestino = idDestino;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public double getImporte() {
        return importe;
    }

    public void setImporte(double importe) {
        this.importe = importe;
    }

    public double getImpuesto() {
        return impuesto;
    }

    public void setImpuesto(double impuesto) {
        this.impuesto = impuesto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTransaccion != null ? idTransaccion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Transferencia)) {
            return false;
        }
        Transferencia other = (Transferencia) object;
        if ((this.idTransaccion == null && other.idTransaccion != null) || (this.idTransaccion != null && !this.idTransaccion.equals(other.idTransaccion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "utn.frd.copernicus.entity.Transferencia[ idTransaccion=" + idTransaccion + " ]";
    }
    
}
