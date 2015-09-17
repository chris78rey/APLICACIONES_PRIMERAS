/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package he1.odonto.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author luis_guanoluiza
 */
@Entity
@Table(name = "O_INDICES_CPO_CEO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OIndicesCpoCeo.findAll", query = "SELECT o FROM OIndicesCpoCeo o"),
    @NamedQuery(name = "OIndicesCpoCeo.findByIccId", query = "SELECT o FROM OIndicesCpoCeo o WHERE o.iccId = :iccId"),
    @NamedQuery(name = "OIndicesCpoCeo.findByIccFecha", query = "SELECT o FROM OIndicesCpoCeo o WHERE o.iccFecha = :iccFecha"),
    @NamedQuery(name = "OIndicesCpoCeo.findByIccCpoC", query = "SELECT o FROM OIndicesCpoCeo o WHERE o.iccCpoC = :iccCpoC"),
    @NamedQuery(name = "OIndicesCpoCeo.findByIccCpoP", query = "SELECT o FROM OIndicesCpoCeo o WHERE o.iccCpoP = :iccCpoP"),
    @NamedQuery(name = "OIndicesCpoCeo.findByIccCpoO", query = "SELECT o FROM OIndicesCpoCeo o WHERE o.iccCpoO = :iccCpoO"),
    @NamedQuery(name = "OIndicesCpoCeo.findByIccCeoC", query = "SELECT o FROM OIndicesCpoCeo o WHERE o.iccCeoC = :iccCeoC"),
    @NamedQuery(name = "OIndicesCpoCeo.findByIccCeoE", query = "SELECT o FROM OIndicesCpoCeo o WHERE o.iccCeoE = :iccCeoE"),
    @NamedQuery(name = "OIndicesCpoCeo.findByIccCeoO", query = "SELECT o FROM OIndicesCpoCeo o WHERE o.iccCeoO = :iccCeoO")})
public class OIndicesCpoCeo implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ICC_ID")
    private BigDecimal iccId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ICC_FECHA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date iccFecha;
    @Column(name = "ICC_CPO_C")
    private BigInteger iccCpoC;
    @Column(name = "ICC_CPO_P")
    private BigInteger iccCpoP;
    @Column(name = "ICC_CPO_O")
    private BigInteger iccCpoO;
    @Column(name = "ICC_CEO_C")
    private BigInteger iccCeoC;
    @Column(name = "ICC_CEO_E")
    private BigInteger iccCeoE;
    @Column(name = "ICC_CEO_O")
    private BigInteger iccCeoO;
    @JoinColumn(name = "ODO_ID", referencedColumnName = "ODO_ID")
    @ManyToOne(optional = false)
    private OOdontograma oOdontograma;

    public OIndicesCpoCeo() {
    }

    public OIndicesCpoCeo(BigDecimal iccId) {
        this.iccId = iccId;
    }

    public OIndicesCpoCeo(BigDecimal iccId, Date iccFecha) {
        this.iccId = iccId;
        this.iccFecha = iccFecha;
    }

    public BigDecimal getIccId() {
        return iccId;
    }

    public void setIccId(BigDecimal iccId) {
        this.iccId = iccId;
    }

    public Date getIccFecha() {
        return iccFecha;
    }

    public void setIccFecha(Date iccFecha) {
        this.iccFecha = iccFecha;
    }

    public BigInteger getIccCpoC() {
        return iccCpoC;
    }

    public void setIccCpoC(BigInteger iccCpoC) {
        this.iccCpoC = iccCpoC;
    }

    public BigInteger getIccCpoP() {
        return iccCpoP;
    }

    public void setIccCpoP(BigInteger iccCpoP) {
        this.iccCpoP = iccCpoP;
    }

    public BigInteger getIccCpoO() {
        return iccCpoO;
    }

    public void setIccCpoO(BigInteger iccCpoO) {
        this.iccCpoO = iccCpoO;
    }

    public BigInteger getIccCeoC() {
        return iccCeoC;
    }

    public void setIccCeoC(BigInteger iccCeoC) {
        this.iccCeoC = iccCeoC;
    }

    public BigInteger getIccCeoE() {
        return iccCeoE;
    }

    public void setIccCeoE(BigInteger iccCeoE) {
        this.iccCeoE = iccCeoE;
    }

    public BigInteger getIccCeoO() {
        return iccCeoO;
    }

    public void setIccCeoO(BigInteger iccCeoO) {
        this.iccCeoO = iccCeoO;
    }

    public OOdontograma getOOdontograma() {
        return oOdontograma;
    }

    public void setOOdontograma(OOdontograma oOdontograma) {
        this.oOdontograma = oOdontograma;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iccId != null ? iccId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OIndicesCpoCeo)) {
            return false;
        }
        OIndicesCpoCeo other = (OIndicesCpoCeo) object;
        if ((this.iccId == null && other.iccId != null) || (this.iccId != null && !this.iccId.equals(other.iccId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.OIndicesCpoCeo[ iccId=" + iccId + " ]";
    }
    
}
