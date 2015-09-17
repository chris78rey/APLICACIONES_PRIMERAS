/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package he1.odonto.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author luis_guanoluiza
 */
@Entity
@Table(name = "O_PATOLOGIAS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OPatologias.findAll", query = "SELECT o FROM OPatologias o"),
    @NamedQuery(name = "OPatologias.findByPatId", query = "SELECT o FROM OPatologias o WHERE o.patId = :patId"),
    @NamedQuery(name = "OPatologias.findByPatDescripcion", query = "SELECT o FROM OPatologias o WHERE o.patDescripcion = :patDescripcion"),
    @NamedQuery(name = "OPatologias.findByPatNumero", query = "SELECT o FROM OPatologias o WHERE o.patNumero = :patNumero")})
public class OPatologias implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "PAT_ID")
    private BigDecimal patId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "PAT_DESCRIPCION")
    private String patDescripcion;
    @Column(name = "PAT_NUMERO")
    private BigInteger patNumero;
    @OneToMany(mappedBy = "oPatologias")
    private List<OSistemaEstomatognico> oSistemaEstomatognicoList;

    public OPatologias() {
    }

    public OPatologias(BigDecimal patId) {
        this.patId = patId;
    }

    public OPatologias(BigDecimal patId, String patDescripcion) {
        this.patId = patId;
        this.patDescripcion = patDescripcion;
    }

    public BigDecimal getPatId() {
        return patId;
    }

    public void setPatId(BigDecimal patId) {
        this.patId = patId;
    }

    public String getPatDescripcion() {
        return patDescripcion;
    }

    public void setPatDescripcion(String patDescripcion) {
        this.patDescripcion = patDescripcion;
    }

    public BigInteger getPatNumero() {
        return patNumero;
    }

    public void setPatNumero(BigInteger patNumero) {
        this.patNumero = patNumero;
    }

    @XmlTransient
    public List<OSistemaEstomatognico> getOSistemaEstomatognicoList() {
        return oSistemaEstomatognicoList;
    }

    public void setOSistemaEstomatognicoList(List<OSistemaEstomatognico> oSistemaEstomatognicoList) {
        this.oSistemaEstomatognicoList = oSistemaEstomatognicoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (patId != null ? patId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OPatologias)) {
            return false;
        }
        OPatologias other = (OPatologias) object;
        if ((this.patId == null && other.patId != null) || (this.patId != null && !this.patId.equals(other.patId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "he1.entities.OPatologias[ patId=" + patId + " ]";
    }
    
}
