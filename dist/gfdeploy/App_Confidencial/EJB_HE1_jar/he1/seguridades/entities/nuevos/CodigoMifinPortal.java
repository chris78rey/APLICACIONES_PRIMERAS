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
@Table(name = "CODIGO_MIFIN_PORTAL")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CodigoMifinPortal.findAll", query = "SELECT c FROM CodigoMifinPortal c"),
    @NamedQuery(name = "CodigoMifinPortal.findById", query = "SELECT c FROM CodigoMifinPortal c WHERE c.id = :id"),
    @NamedQuery(name = "CodigoMifinPortal.findByCedula", query = "SELECT c FROM CodigoMifinPortal c WHERE c.cedula = :cedula"),
    @NamedQuery(name = "CodigoMifinPortal.findByCodigo", query = "SELECT c FROM CodigoMifinPortal c WHERE c.codigo = :codigo"),
    @NamedQuery(name = "CodigoMifinPortal.findByMes", query = "SELECT c FROM CodigoMifinPortal c WHERE c.mes = :mes"),
    @NamedQuery(name = "CodigoMifinPortal.findByAnio", query = "SELECT c FROM CodigoMifinPortal c WHERE c.anio = :anio"),
    @NamedQuery(name = "CodigoMifinPortal.findByDescripcion", query = "SELECT c FROM CodigoMifinPortal c WHERE c.descripcion = :descripcion"),
    @NamedQuery(name = "CodigoMifinPortal.findByFecha", query = "SELECT c FROM CodigoMifinPortal c WHERE c.fecha = :fecha"),
    @NamedQuery(name = "CodigoMifinPortal.findByIdPersonal", query = "SELECT c FROM CodigoMifinPortal c WHERE c.idPersonal = :idPersonal")})
public class CodigoMifinPortal implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Size(max = 100)
    @Column(name = "CEDULA")
    private String cedula;
    @Size(max = 1000)
    @Column(name = "CODIGO")
    private String codigo;
    @Size(max = 100)
    @Column(name = "MES")
    private String mes;
    @Size(max = 100)
    @Column(name = "ANIO")
    private String anio;
    @Size(max = 200)
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @Column(name = "FECHA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @Column(name = "ID_PERSONAL")
    private BigInteger idPersonal;

    @Column(name = "MES_NUMERO")
    private BigInteger mesNumero;

    public CodigoMifinPortal() {
    }

    public CodigoMifinPortal(BigDecimal id) {
        this.id = id;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getMes() {
        return mes;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }

    public String getAnio() {
        return anio;
    }

    public void setAnio(String anio) {
        this.anio = anio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public BigInteger getIdPersonal() {
        return idPersonal;
    }

    public void setIdPersonal(BigInteger idPersonal) {
        this.idPersonal = idPersonal;
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
        if (!(object instanceof CodigoMifinPortal)) {
            return false;
        }
        CodigoMifinPortal other = (CodigoMifinPortal) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.CodigoMifinPortal[ id=" + id + " ]";
    }

    /**
     * @return the mesNumero
     */
    public BigInteger getMesNumero() {
        return mesNumero;
    }

    /**
     * @param mesNumero the mesNumero to set
     */
    public void setMesNumero(BigInteger mesNumero) {
        this.mesNumero = mesNumero;
    }

}
