/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package he1.seguridades.entities.nuevos;

import java.io.Serializable;
import java.math.BigDecimal;
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
 * @author christian_ruiz
 */
@Entity
@Table(name = "REGIMEN_LABORAL")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RegimenLaboral.findAll", query = "SELECT r FROM RegimenLaboral r"),
    @NamedQuery(name = "RegimenLaboral.findByRglIdregimen", query = "SELECT r FROM RegimenLaboral r WHERE r.rglIdregimen = :rglIdregimen"),
    @NamedQuery(name = "RegimenLaboral.findByRglRegimenlaboral", query = "SELECT r FROM RegimenLaboral r WHERE r.rglRegimenlaboral = :rglRegimenlaboral"),
    @NamedQuery(name = "RegimenLaboral.findByRglObservacion", query = "SELECT r FROM RegimenLaboral r WHERE r.rglObservacion = :rglObservacion"),
    @NamedQuery(name = "RegimenLaboral.findByRglUser", query = "SELECT r FROM RegimenLaboral r WHERE r.rglUser = :rglUser")})
public class RegimenLaboral implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "RGL_IDREGIMEN")
    private BigDecimal rglIdregimen;
    @Size(max = 250)
    @Column(name = "RGL_REGIMENLABORAL")
    private String rglRegimenlaboral;
    @Size(max = 250)
    @Column(name = "RGL_OBSERVACION")
    private String rglObservacion;
    @Size(max = 50)
    @Column(name = "RGL_USER")
    private String rglUser;
    @OneToMany(mappedBy = "regimenLaboral")
    private List<TipoRelacionLaboral> tipoRelacionLaboralList;

    public RegimenLaboral() {
    }

    public RegimenLaboral(BigDecimal rglIdregimen) {
        this.rglIdregimen = rglIdregimen;
    }

    public BigDecimal getRglIdregimen() {
        return rglIdregimen;
    }

    public void setRglIdregimen(BigDecimal rglIdregimen) {
        this.rglIdregimen = rglIdregimen;
    }

    public String getRglRegimenlaboral() {
        return rglRegimenlaboral;
    }

    public void setRglRegimenlaboral(String rglRegimenlaboral) {
        this.rglRegimenlaboral = rglRegimenlaboral;
    }

    public String getRglObservacion() {
        return rglObservacion;
    }

    public void setRglObservacion(String rglObservacion) {
        this.rglObservacion = rglObservacion;
    }

    public String getRglUser() {
        return rglUser;
    }

    public void setRglUser(String rglUser) {
        this.rglUser = rglUser;
    }

    @XmlTransient
    public List<TipoRelacionLaboral> getTipoRelacionLaboralList() {
        return tipoRelacionLaboralList;
    }

    public void setTipoRelacionLaboralList(List<TipoRelacionLaboral> tipoRelacionLaboralList) {
        this.tipoRelacionLaboralList = tipoRelacionLaboralList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (rglIdregimen != null ? rglIdregimen.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RegimenLaboral)) {
            return false;
        }
        RegimenLaboral other = (RegimenLaboral) object;
        if ((this.rglIdregimen == null && other.rglIdregimen != null) || (this.rglIdregimen != null && !this.rglIdregimen.equals(other.rglIdregimen))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "he1.seguridades.entities.nuevos.RegimenLaboral[ rglIdregimen=" + rglIdregimen + " ]";
    }
    
}
