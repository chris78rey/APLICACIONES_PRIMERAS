/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package he1.seguridades.entities.nuevos;


import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
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
 * @author christian_ruiz
 */
@Entity
@Table(name = "ACUMULA_DECIMO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AcumulaDecimo.findAll", query = "SELECT a FROM AcumulaDecimo a"),
    @NamedQuery(name = "AcumulaDecimo.findById", query = "SELECT a FROM AcumulaDecimo a WHERE a.id = :id"),
    @NamedQuery(name = "AcumulaDecimo.findByAccion", query = "SELECT a FROM AcumulaDecimo a WHERE a.accion = :accion"),
    @NamedQuery(name = "AcumulaDecimo.findByFecha", query = "SELECT a FROM AcumulaDecimo a WHERE a.fecha = :fecha"),
    @NamedQuery(name = "AcumulaDecimo.findByPrnIdPersonal", query = "SELECT a FROM AcumulaDecimo a WHERE a.prnIdPersonal = :prnIdPersonal"),
    @NamedQuery(name = "AcumulaDecimo.findByTipo", query = "SELECT a FROM AcumulaDecimo a WHERE a.tipo = :tipo")})
public class AcumulaDecimo implements Serializable {
    @Column(name = "ANIO")
    private BigInteger anio;
    @Column(name = "FECHA_APERTURA_IS")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaAperturaIs;
    @Column(name = "FECHA_FIN_IS")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaFinIs;
    @Column(name = "FECHA_APERTURA_IIS")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaAperturaIis;
    @Column(name = "FECHA_FIN_IIS")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaFinIis;
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Size(max = 2)
    @Column(name = "ACCION")
    private String accion;
    @Column(name = "FECHA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @Column(name = "PRN_ID_PERSONAL")
    private BigInteger prnIdPersonal;
    @Size(max = 1)
    @Column(name = "TIPO")
    private String tipo;

    public AcumulaDecimo() {
    }

    public AcumulaDecimo(BigDecimal id) {
        this.id = id;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getAccion() {
        return accion;
    }

    public void setAccion(String accion) {
        this.accion = accion;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public BigInteger getPrnIdPersonal() {
        return prnIdPersonal;
    }

    public void setPrnIdPersonal(BigInteger prnIdPersonal) {
        this.prnIdPersonal = prnIdPersonal;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AcumulaDecimo)) {
            return false;
        }
        AcumulaDecimo other = (AcumulaDecimo) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.AcumulaDecimo[ id=" + id + " ]";
    }

    public BigInteger getAnio() {
        return anio;
    }

    public void setAnio(BigInteger anio) {
        this.anio = anio;
    }

    public Date getFechaAperturaIs() {
        return fechaAperturaIs;
    }

    public void setFechaAperturaIs(Date fechaAperturaIs) {
        this.fechaAperturaIs = fechaAperturaIs;
    }

    public Date getFechaFinIs() {
        return fechaFinIs;
    }

    public void setFechaFinIs(Date fechaFinIs) {
        this.fechaFinIs = fechaFinIs;
    }

    public Date getFechaAperturaIis() {
        return fechaAperturaIis;
    }

    public void setFechaAperturaIis(Date fechaAperturaIis) {
        this.fechaAperturaIis = fechaAperturaIis;
    }

    public Date getFechaFinIis() {
        return fechaFinIis;
    }

    public void setFechaFinIis(Date fechaFinIis) {
        this.fechaFinIis = fechaFinIis;
    }
    
}
