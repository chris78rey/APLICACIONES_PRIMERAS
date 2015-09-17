/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package he1.seguridades.entities.nuevos;

import java.io.Serializable;
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
 * @author christian_ruiz
 */
@Entity
@Table(name = "V_PROV_CAN_PARR")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VProvCanParr.findAll", query = "SELECT v FROM VProvCanParr v"),
    @NamedQuery(name = "VProvCanParr.findByRid", query = "SELECT v FROM VProvCanParr v WHERE v.rid = :rid"),
    @NamedQuery(name = "VProvCanParr.findByProvinciasCodigo", query = "SELECT v FROM VProvCanParr v WHERE v.provinciasCodigo = :provinciasCodigo"),
    @NamedQuery(name = "VProvCanParr.findByCantonesCodigo", query = "SELECT v FROM VProvCanParr v WHERE v.cantonesCodigo = :cantonesCodigo"),
    @NamedQuery(name = "VProvCanParr.findByParroquiasCodigo", query = "SELECT v FROM VProvCanParr v WHERE v.parroquiasCodigo = :parroquiasCodigo"),
    @NamedQuery(name = "VProvCanParr.findByProvincia", query = "SELECT v FROM VProvCanParr v WHERE v.provincia = :provincia"),
    @NamedQuery(name = "VProvCanParr.findByCanton", query = "SELECT v FROM VProvCanParr v WHERE v.canton = :canton"),
    @NamedQuery(name = "VProvCanParr.findByParroquia", query = "SELECT v FROM VProvCanParr v WHERE v.parroquia = :parroquia")})
public class VProvCanParr implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 18)
    @Column(name = "RID")
    private String rid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "PROVINCIAS_CODIGO")
    private String provinciasCodigo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "CANTONES_CODIGO")
    private String cantonesCodigo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "PARROQUIAS_CODIGO")
    private String parroquiasCodigo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "PROVINCIA")
    private String provincia;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "CANTON")
    private String canton;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "PARROQUIA")
    private String parroquia;

    public VProvCanParr() {
    }

    public VProvCanParr(String rid) {
        this.rid = rid;
    }

    public VProvCanParr(String rid, String provinciasCodigo, String cantonesCodigo, String parroquiasCodigo, String provincia, String canton, String parroquia) {
        this.rid = rid;
        this.provinciasCodigo = provinciasCodigo;
        this.cantonesCodigo = cantonesCodigo;
        this.parroquiasCodigo = parroquiasCodigo;
        this.provincia = provincia;
        this.canton = canton;
        this.parroquia = parroquia;
    }

    public String getRid() {
        return rid;
    }

    public void setRid(String rid) {
        this.rid = rid;
    }

    public String getProvinciasCodigo() {
        return provinciasCodigo;
    }

    public void setProvinciasCodigo(String provinciasCodigo) {
        this.provinciasCodigo = provinciasCodigo;
    }

    public String getCantonesCodigo() {
        return cantonesCodigo;
    }

    public void setCantonesCodigo(String cantonesCodigo) {
        this.cantonesCodigo = cantonesCodigo;
    }

    public String getParroquiasCodigo() {
        return parroquiasCodigo;
    }

    public void setParroquiasCodigo(String parroquiasCodigo) {
        this.parroquiasCodigo = parroquiasCodigo;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getCanton() {
        return canton;
    }

    public void setCanton(String canton) {
        this.canton = canton;
    }

    public String getParroquia() {
        return parroquia;
    }

    public void setParroquia(String parroquia) {
        this.parroquia = parroquia;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (rid != null ? rid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof VProvCanParr)) {
            return false;
        }
        VProvCanParr other = (VProvCanParr) object;
        if ((this.rid == null && other.rid != null) || (this.rid != null && !this.rid.equals(other.rid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.VProvCanParr[ rid=" + rid + " ]";
    }
    
}
