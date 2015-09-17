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
@Table(name = "O_HIGIENE_ORAL_SIMPLIFICADA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OHigieneOralSimplificada.findAll", query = "SELECT o FROM OHigieneOralSimplificada o"),
    @NamedQuery(name = "OHigieneOralSimplificada.findByHosDescripcion", query = "SELECT o FROM OHigieneOralSimplificada o WHERE o.hosDescripcion = :hosDescripcion"),
    @NamedQuery(name = "OHigieneOralSimplificada.findByHosFecha", query = "SELECT o FROM OHigieneOralSimplificada o WHERE o.hosFecha = :hosFecha")})
public class OHigieneOralSimplificada implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "HOS_ID")
    private BigDecimal hosId;
    @Size(max = 100)
    @Column(name = "HOS_DESCRIPCION")
    private String hosDescripcion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "HOS_FECHA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date hosFecha;
    @JoinColumn(name = "PCN_NUMERO_HC", referencedColumnName = "NUMERO_HC")
    @ManyToOne
    private Pacientes pacientes;
    @Column(name = "PGI_ID")
    private BigDecimal pgiId;
    @Column(name = "PCA_ID")
    private BigDecimal pcaId;
    @Column(name = "PBA_ID")
    private BigDecimal pbaId;
    @Column(name = "HPD_ID")
   private BigDecimal hpdId;
    @JoinColumn(name = "HJAEVL_NUMERO", referencedColumnName = "NUMERO")
    @ManyToOne
    private HojasDeEvolucion hojasDeEvolucion;

    public OHigieneOralSimplificada() {
    }

    public OHigieneOralSimplificada(BigDecimal hosId) {
        this.hosId = hosId;
    }

    public OHigieneOralSimplificada(BigDecimal hosId, Date hosFecha) {
        this.hosId = hosId;
        this.hosFecha = hosFecha;
    }

    public BigDecimal getHosId() {
        return hosId;
    }

    public void setHosId(BigDecimal hosId) {
        this.hosId = hosId;
    }

    public String getHosDescripcion() {
        return hosDescripcion;
    }

    public void setHosDescripcion(String hosDescripcion) {
        this.hosDescripcion = hosDescripcion;
    }

    public Date getHosFecha() {
        return hosFecha;
    }

    public void setHosFecha(Date hosFecha) {
        this.hosFecha = hosFecha;
    }

    public Pacientes getPacientes() {
        return pacientes;
    }

    public void setPacientes(Pacientes pacientes) {
        this.pacientes = pacientes;
    }

    public BigDecimal getPgiId() {
        return pgiId;
    }

    public void setPgiId(BigDecimal pgiId) {
        this.pgiId = pgiId;
    }

    public BigDecimal getPcaId() {
        return pcaId;
    }

    public void setPcaId(BigDecimal pcaId) {
        this.pcaId = pcaId;
    }

    public BigDecimal getPbaId() {
        return pbaId;
    }

    public void setPbaId(BigDecimal pbaId) {
        this.pbaId = pbaId;
    }

    public BigDecimal getHpdId() {
        return hpdId;
    }

    public void setHpdId(BigDecimal hpdId) {
        this.hpdId = hpdId;
    }

   

   

 

    public void setHojasDeEvolucion(HojasDeEvolucion hojasDeEvolucion) {
        this.hojasDeEvolucion = hojasDeEvolucion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (hosId != null ? hosId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OHigieneOralSimplificada)) {
            return false;
        }
        OHigieneOralSimplificada other = (OHigieneOralSimplificada) object;
        if ((this.hosId == null && other.hosId != null) || (this.hosId != null && !this.hosId.equals(other.hosId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "he1.entities.OHigieneOralSimplificada[ hosId=" + hosId + " ]";
    }

}
