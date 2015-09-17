/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package he1.odonto.entities;

import he1.sis.entities.HojasDeEvolucion;
import he1.sis.entities.Pacientes;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
 * @author luis_guanoluiza
 */
@Entity
@Table(name = "O_MAL_OCLUSION")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OMalOclusion.findAll", query = "SELECT o FROM OMalOclusion o"),
    @NamedQuery(name = "OMalOclusion.findByMocId", query = "SELECT o FROM OMalOclusion o WHERE o.mocId = :mocId"),
    @NamedQuery(name = "OMalOclusion.findByMocClasificacion", query = "SELECT o FROM OMalOclusion o WHERE o.mocClasificacion = :mocClasificacion"),
    @NamedQuery(name = "OMalOclusion.findByMocFecha", query = "SELECT o FROM OMalOclusion o WHERE o.mocFecha = :mocFecha")})
public class OMalOclusion implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "MOC_ID")
    private BigDecimal mocId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "MOC_CLASIFICACION")
    private String mocClasificacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "MOC_FECHA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date mocFecha;
    @JoinColumn(name = "PCN_NUMERO_HC", referencedColumnName = "NUMERO_HC")
    @ManyToOne
    private Pacientes pacientes;
    @JoinColumn(name = "HJAEVL_NUMERO", referencedColumnName = "NUMERO")
    @ManyToOne
    private HojasDeEvolucion hojasDeEvolucion;

    public OMalOclusion() {
    }

    public OMalOclusion(BigDecimal mocId) {
        this.mocId = mocId;
    }

    public OMalOclusion(BigDecimal mocId, String mocClasificacion, Date mocFecha) {
        this.mocId = mocId;
        this.mocClasificacion = mocClasificacion;
        this.mocFecha = mocFecha;
    }

    public BigDecimal getMocId() {
        return mocId;
    }

    public void setMocId(BigDecimal mocId) {
        this.mocId = mocId;
    }

    public String getMocClasificacion() {
        return mocClasificacion;
    }

    public void setMocClasificacion(String mocClasificacion) {
        this.mocClasificacion = mocClasificacion;
    }

    public Date getMocFecha() {
        return mocFecha;
    }

    public void setMocFecha(Date mocFecha) {
        this.mocFecha = mocFecha;
    }

    public Pacientes getPacientes() {
        return pacientes;
    }

    public void setPacientes(Pacientes pacientes) {
        this.pacientes = pacientes;
    }

    public HojasDeEvolucion getHojasDeEvolucion() {
        return hojasDeEvolucion;
    }

    public void setHojasDeEvolucion(HojasDeEvolucion hojasDeEvolucion) {
        this.hojasDeEvolucion = hojasDeEvolucion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (mocId != null ? mocId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OMalOclusion)) {
            return false;
        }
        OMalOclusion other = (OMalOclusion) object;
        if ((this.mocId == null && other.mocId != null) || (this.mocId != null && !this.mocId.equals(other.mocId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "he1.entities.OMalOclusion[ mocId=" + mocId + " ]";
    }

}
