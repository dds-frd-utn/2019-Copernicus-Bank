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
@Table(name = "bono")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Bono.findAll", query = "SELECT b FROM Bono b")
    , @NamedQuery(name = "Bono.findByIdBono", query = "SELECT b FROM Bono b WHERE b.idBono = :idBono")
    , @NamedQuery(name = "Bono.findByIdMovimiento", query = "SELECT b FROM Bono b WHERE b.idMovimiento = :idMovimiento")
    , @NamedQuery(name = "Bono.findByMontoInvertido", query = "SELECT b FROM Bono b WHERE b.montoInvertido = :montoInvertido")
    , @NamedQuery(name = "Bono.findByDescripcion", query = "SELECT b FROM Bono b WHERE b.descripcion = :descripcion")
    , @NamedQuery(name = "Bono.findByFechaPago", query = "SELECT b FROM Bono b WHERE b.fechaPago = :fechaPago")
    , @NamedQuery(name = "Bono.findByInteres", query = "SELECT b FROM Bono b WHERE b.interes = :interes")
    , @NamedQuery(name = "Bono.findByImpuesto", query = "SELECT b FROM Bono b WHERE b.impuesto = :impuesto")})
public class Bono implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idBono")
    private Long idBono;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idMovimiento")
    private long idMovimiento;
    @Basic(optional = false)
    @NotNull
    @Column(name = "montoInvertido")
    private double montoInvertido;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "descripcion")
    private String descripcion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechaPago")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaPago;
    @Basic(optional = false)
    @NotNull
    @Column(name = "interes")
    private int interes;
    @Basic(optional = false)
    @NotNull
    @Column(name = "impuesto")
    private double impuesto;

    public Bono() {
    }

    public Bono(Long idBono) {
        this.idBono = idBono;
    }

    public Bono(Long idBono, long idMovimiento, double montoInvertido, String descripcion, Date fechaPago, int interes, double impuesto) {
        this.idBono = idBono;
        this.idMovimiento = idMovimiento;
        this.montoInvertido = montoInvertido;
        this.descripcion = descripcion;
        this.fechaPago = fechaPago;
        this.interes = interes;
        this.impuesto = impuesto;
    }

    public Long getIdBono() {
        return idBono;
    }

    public void setIdBono(Long idBono) {
        this.idBono = idBono;
    }

    public long getIdMovimiento() {
        return idMovimiento;
    }

    public void setIdMovimiento(long idMovimiento) {
        this.idMovimiento = idMovimiento;
    }

    public double getMontoInvertido() {
        return montoInvertido;
    }

    public void setMontoInvertido(double montoInvertido) {
        this.montoInvertido = montoInvertido;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(Date fechaPago) {
        this.fechaPago = fechaPago;
    }

    public int getInteres() {
        return interes;
    }

    public void setInteres(int interes) {
        this.interes = interes;
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
        hash += (idBono != null ? idBono.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Bono)) {
            return false;
        }
        Bono other = (Bono) object;
        if ((this.idBono == null && other.idBono != null) || (this.idBono != null && !this.idBono.equals(other.idBono))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "utn.frd.copernicus.entity.Bono[ idBono=" + idBono + " ]";
    }
    
}
