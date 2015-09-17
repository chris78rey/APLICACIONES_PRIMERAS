/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package he1.sis.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "CANTONES")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cantones.findAll", query = "SELECT c FROM Cantones c"),
    @NamedQuery(name = "Cantones.findByPrvCodigo", query = "SELECT c FROM Cantones c WHERE c.cantonesPK.prvCodigo = :prvCodigo"),
    @NamedQuery(name = "Cantones.findByCodigo", query = "SELECT c FROM Cantones c WHERE c.cantonesPK.codigo = :codigo"),
    @NamedQuery(name = "Cantones.findByCanton", query = "SELECT c FROM Cantones c WHERE c.canton = :canton")})
public class Cantones implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CantonesPK cantonesPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "CANTON")
    private String canton;
    @JoinColumn(name = "PRV_CODIGO", referencedColumnName = "CODIGO", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Provincias provincias;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cantones")
    private List<Parroquias> parroquiasList;

    public Cantones() {
    }

    public Cantones(CantonesPK cantonesPK) {
        this.cantonesPK = cantonesPK;
    }

    public Cantones(CantonesPK cantonesPK, String canton) {
        this.cantonesPK = cantonesPK;
        this.canton = canton;
    }

    public Cantones(String prvCodigo, String codigo) {
        this.cantonesPK = new CantonesPK(prvCodigo, codigo);
    }

    public CantonesPK getCantonesPK() {
        return cantonesPK;
    }

    public void setCantonesPK(CantonesPK cantonesPK) {
        this.cantonesPK = cantonesPK;
    }

    public String getCanton() {
        return canton;
    }

    public void setCanton(String canton) {
        this.canton = canton;
    }

    public Provincias getProvincias() {
        return provincias;
    }

    public void setProvincias(Provincias provincias) {
        this.provincias = provincias;
    }

    @XmlTransient
    public List<Parroquias> getParroquiasList() {
        return parroquiasList;
    }

    public void setParroquiasList(List<Parroquias> parroquiasList) {
        this.parroquiasList = parroquiasList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cantonesPK != null ? cantonesPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cantones)) {
            return false;
        }
        Cantones other = (Cantones) object;
        if ((this.cantonesPK == null && other.cantonesPK != null) || (this.cantonesPK != null && !this.cantonesPK.equals(other.cantonesPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Cantones[ cantonesPK=" + cantonesPK + " ]";
    }
    
}
