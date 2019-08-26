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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Evelyn
 */
@Entity
@Table(name = "movimiento")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Movimiento.findAll", query = "SELECT m FROM Movimiento m")
    , @NamedQuery(name = "Movimiento.findByIdMovimiento", query = "SELECT m FROM Movimiento m WHERE m.idMovimiento = :idMovimiento")
    , @NamedQuery(name = "Movimiento.findByTipo", query = "SELECT m FROM Movimiento m WHERE m.tipo = :tipo")
    , @NamedQuery(name = "Movimiento.findByEstado", query = "SELECT m FROM Movimiento m WHERE m.estado = :estado")
    , @NamedQuery(name = "Movimiento.findByFechaMovimiento", query = "SELECT m FROM Movimiento m WHERE m.fechaMovimiento = :fechaMovimiento")
    , @NamedQuery(name = "Movimiento.findByIdCuenta", query = "SELECT m FROM Movimiento m WHERE m.idCuenta = :idCuenta")
    , @NamedQuery(name = "Movimiento.findByIdCuentaTyE", query = "SELECT m FROM Movimiento m WHERE m.idCuenta = :idCuenta and m.tipo = :tipo and m.estado = :estado")
    , @NamedQuery(name = "Movimiento.findByTyE", query = "SELECT m FROM Movimiento m WHERE m.tipo = :tipo and m.estado = :estado")
    , @NamedQuery(name = "Movimienot.findImporte", query = "SELECT m.importe FROM Movimiento m WHERE m.idMovimiento = :idMovimiento")
    , @NamedQuery(name = "Movimiento.findByImporte", query = "SELECT m FROM Movimiento m WHERE m.importe = :importe")})
public class Movimiento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idMovimiento")
    private Long idMovimiento;
    @Basic(optional = false)
    @NotNull
    @Column(name = "tipo")
    private int tipo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "estado")
    private int estado;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechaMovimiento")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaMovimiento;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idCuenta")
    private long idCuenta;
    @Basic(optional = false)
    @NotNull
    @Column(name = "importe")
    private double importe;

    public Movimiento() {
    }

    public Movimiento(Long idMovimiento) {
        this.idMovimiento = idMovimiento;
    }

    public Movimiento(Long idMovimiento, int tipo, int estado, Date fechaMovimiento, long idCuenta, double importe) {
        this.idMovimiento = idMovimiento;
        this.tipo = tipo;
        this.estado = estado;
        this.fechaMovimiento = fechaMovimiento;
        this.idCuenta = idCuenta;
        this.importe = importe;
    }

    public Long getIdMovimiento() {
        return idMovimiento;
    }

    public void setIdMovimiento(Long idMovimiento) {
        this.idMovimiento = idMovimiento;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public Date getFechaMovimiento() {
        return fechaMovimiento;
    }

    public void setFechaMovimiento(Date fechaMovimiento) {
        this.fechaMovimiento = fechaMovimiento;
    }

    public long getIdCuenta() {
        return idCuenta;
    }

    public void setIdCuenta(long idCuenta) {
        this.idCuenta = idCuenta;
    }

    public double getImporte() {
        return importe;
    }

    public void setImporte(double importe) {
        this.importe = importe;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMovimiento != null ? idMovimiento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Movimiento)) {
            return false;
        }
        Movimiento other = (Movimiento) object;
        if ((this.idMovimiento == null && other.idMovimiento != null) || (this.idMovimiento != null && !this.idMovimiento.equals(other.idMovimiento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "utn.frd.copernicus.entity.Movimiento[ idMovimiento=" + idMovimiento + " ]";
    }
    
}
