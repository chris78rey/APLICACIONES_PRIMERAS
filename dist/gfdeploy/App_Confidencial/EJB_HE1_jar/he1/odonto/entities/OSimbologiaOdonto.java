/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package he1.odonto.entities;

import java.io.Serializable;
import java.math.BigDecimal;
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
 * @author luis_guanoluiza
 */
@Entity
@Table(name = "O_SIMBOLOGIA_ODONTO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OSimbologiaOdonto.findAll", query = "SELECT o FROM OSimbologiaOdonto o"),
    @NamedQuery(name = "OSimbologiaOdonto.findBySodId", query = "SELECT o FROM OSimbologiaOdonto o WHERE o.sodId = :sodId"),
    @NamedQuery(name = "OSimbologiaOdonto.findBySodDescripcion", query = "SELECT o FROM OSimbologiaOdonto o WHERE o.sodDescripcion = :sodDescripcion"),
    @NamedQuery(name = "OSimbologiaOdonto.findBySodColor", query = "SELECT o FROM OSimbologiaOdonto o WHERE o.sodColor = :sodColor"),
    @NamedQuery(name = "OSimbologiaOdonto.findBySodAbreviatura", query = "SELECT o FROM OSimbologiaOdonto o WHERE o.sodAbreviatura = :sodAbreviatura"),
    @NamedQuery(name = "OSimbologiaOdonto.findBySodParametro", query = "SELECT o FROM OSimbologiaOdonto o WHERE o.sodParametro = :sodParametro")})
public class OSimbologiaOdonto implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "SOD_ID")
    private BigDecimal sodId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "SOD_DESCRIPCION")
    private String sodDescripcion;
    @Size(max = 10)
    @Column(name = "SOD_COLOR")
    private String sodColor;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "SOD_ABREVIATURA")
    private String sodAbreviatura;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "SOD_PARAMETRO")
    private String sodParametro;

    public OSimbologiaOdonto() {
    }

    public OSimbologiaOdonto(BigDecimal sodId) {
        this.sodId = sodId;
    }

    public OSimbologiaOdonto(BigDecimal sodId, String sodDescripcion, String sodAbreviatura, String sodParametro) {
        this.sodId = sodId;
        this.sodDescripcion = sodDescripcion;
        this.sodAbreviatura = sodAbreviatura;
        this.sodParametro = sodParametro;
    }

    public BigDecimal getSodId() {
        return sodId;
    }

    public void setSodId(BigDecimal sodId) {
        this.sodId = sodId;
    }

    public String getSodDescripcion() {
        return sodDescripcion;
    }

    public void setSodDescripcion(String sodDescripcion) {
        this.sodDescripcion = sodDescripcion;
    }

    public String getSodColor() {
        return sodColor;
    }

    public void setSodColor(String sodColor) {
        this.sodColor = sodColor;
    }

    public String getSodAbreviatura() {
        return sodAbreviatura;
    }

    public void setSodAbreviatura(String sodAbreviatura) {
        this.sodAbreviatura = sodAbreviatura;
    }

    public String getSodParametro() {
        return sodParametro;
    }

    public void setSodParametro(String sodParametro) {
        this.sodParametro = sodParametro;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (sodId != null ? sodId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OSimbologiaOdonto)) {
            return false;
        }
        OSimbologiaOdonto other = (OSimbologiaOdonto) object;
        if ((this.sodId == null && other.sodId != null) || (this.sodId != null && !this.sodId.equals(other.sodId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "he1.entities.OSimbologiaOdonto[ sodId=" + sodId + " ]";
    }
    
}
