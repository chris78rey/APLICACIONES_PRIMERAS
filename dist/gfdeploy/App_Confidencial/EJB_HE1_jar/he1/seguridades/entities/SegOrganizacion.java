/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package he1.seguridades.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
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
@Table(name = "SEG_ORGANIZACION")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SegOrganizacion.findAll", query = "SELECT s FROM SegOrganizacion s"),
    @NamedQuery(name = "SegOrganizacion.findByOrgId", query = "SELECT s FROM SegOrganizacion s WHERE s.orgId = :orgId"),
    @NamedQuery(name = "SegOrganizacion.findByOrgNombre", query = "SELECT s FROM SegOrganizacion s WHERE s.orgNombre = :orgNombre"),
    @NamedQuery(name = "SegOrganizacion.findByOrgRuc", query = "SELECT s FROM SegOrganizacion s WHERE s.orgRuc = :orgRuc")})
public class SegOrganizacion implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ORG_ID")
    private BigDecimal orgId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "ORG_NOMBRE")
    private String orgNombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "ORG_RUC")
    private String orgRuc;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "segOrganizacion")
    private List<SegModulos> segModulosList;

    public SegOrganizacion() {
    }

    public SegOrganizacion(BigDecimal orgId) {
        this.orgId = orgId;
    }

    public SegOrganizacion(BigDecimal orgId, String orgNombre, String orgRuc) {
        this.orgId = orgId;
        this.orgNombre = orgNombre;
        this.orgRuc = orgRuc;
    }

    public BigDecimal getOrgId() {
        return orgId;
    }

    public void setOrgId(BigDecimal orgId) {
        this.orgId = orgId;
    }

    public String getOrgNombre() {
        return orgNombre;
    }

    public void setOrgNombre(String orgNombre) {
        this.orgNombre = orgNombre;
    }

    public String getOrgRuc() {
        return orgRuc;
    }

    public void setOrgRuc(String orgRuc) {
        this.orgRuc = orgRuc;
    }

    @XmlTransient
    public List<SegModulos> getSegModulosList() {
        return segModulosList;
    }

    public void setSegModulosList(List<SegModulos> segModulosList) {
        this.segModulosList = segModulosList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (orgId != null ? orgId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SegOrganizacion)) {
            return false;
        }
        SegOrganizacion other = (SegOrganizacion) object;
        if ((this.orgId == null && other.orgId != null) || (this.orgId != null && !this.orgId.equals(other.orgId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "he1.seguridades.entities.SegOrganizacion[ orgId=" + orgId + " ]";
    }

}
