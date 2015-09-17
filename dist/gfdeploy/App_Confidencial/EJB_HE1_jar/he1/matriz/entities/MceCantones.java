/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package he1.matriz.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "MCE_CANTONES")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MceCantones.findAll", query = "SELECT m FROM MceCantones m"),
    @NamedQuery(name = "MceCantones.findByPrvCodigo", query = "SELECT m FROM MceCantones m WHERE m.mceCantonesPK.prvCodigo = :prvCodigo"),
    @NamedQuery(name = "MceCantones.findByCodigo", query = "SELECT m FROM MceCantones m WHERE m.mceCantonesPK.codigo = :codigo"),
    @NamedQuery(name = "MceCantones.findByCanton", query = "SELECT m FROM MceCantones m WHERE m.canton = :canton")})
public class MceCantones implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected MceCantonesPK mceCantonesPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "CANTON")
    private String canton;
    @JoinColumn(name = "PRV_CODIGO", referencedColumnName = "CODIGO", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private MceProvincias mceProvincias;

    public MceCantones() {
    }

    public MceCantones(MceCantonesPK mceCantonesPK) {
        this.mceCantonesPK = mceCantonesPK;
    }

    public MceCantones(MceCantonesPK mceCantonesPK, String canton) {
        this.mceCantonesPK = mceCantonesPK;
        this.canton = canton;
    }

    public MceCantones(String prvCodigo, String codigo) {
        this.mceCantonesPK = new MceCantonesPK(prvCodigo, codigo);
    }

    public MceCantonesPK getMceCantonesPK() {
        return mceCantonesPK;
    }

    public void setMceCantonesPK(MceCantonesPK mceCantonesPK) {
        this.mceCantonesPK = mceCantonesPK;
    }

    public String getCanton() {
        return canton;
    }

    public void setCanton(String canton) {
        this.canton = canton;
    }

    public MceProvincias getMceProvincias() {
        return mceProvincias;
    }

    public void setMceProvincias(MceProvincias mceProvincias) {
        this.mceProvincias = mceProvincias;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (mceCantonesPK != null ? mceCantonesPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MceCantones)) {
            return false;
        }
        MceCantones other = (MceCantones) object;
        if ((this.mceCantonesPK == null && other.mceCantonesPK != null) || (this.mceCantonesPK != null && !this.mceCantonesPK.equals(other.mceCantonesPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "he1.matriz.entities.MceCantones[ mceCantonesPK=" + mceCantonesPK + " ]";
    }
    
}
