/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package he1.seguridades.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author christian_ruiz
 */
@Entity
@Table(name = "SEG_MODULOS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SegModulos.findAll", query = "SELECT s FROM SegModulos s"),
    @NamedQuery(name = "SegModulos.findByModId", query = "SELECT s FROM SegModulos s WHERE s.modId = :modId"),
    @NamedQuery(name = "SegModulos.findByModNombreModulo", query = "SELECT s FROM SegModulos s WHERE s.modNombreModulo = :modNombreModulo"),
    @NamedQuery(name = "SegModulos.findByModFechaCreacion", query = "SELECT s FROM SegModulos s WHERE s.modFechaCreacion = :modFechaCreacion"),
    @NamedQuery(name = "SegModulos.findByModUrl", query = "SELECT s FROM SegModulos s WHERE s.modUrl = :modUrl"),
    @NamedQuery(name = "SegModulos.findByModUrlSiguiente", query = "SELECT s FROM SegModulos s WHERE s.modUrlSiguiente = :modUrlSiguiente")})
public class SegModulos implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @SequenceGenerator(name = "modulos_SEG_MODULOS", sequenceName = "SEGURIDADES.SEG_MODULOS_SEQ")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "modulos_SEG_MODULOS")
    @Basic(optional = false)
    @NotNull
    @Column(name = "MOD_ID")
    private BigDecimal modId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "MOD_NOMBRE_MODULO")
    private String modNombreModulo;
    @Column(name = "MOD_FECHA_CREACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modFechaCreacion;
    @Size(max = 4000)
    @Column(name = "MOD_URL")
    private String modUrl;
    @Size(max = 4000)
    @Column(name = "MOD_URL_SIGUIENTE")
    private String modUrlSiguiente;
    @JoinColumn(name = "ORG_ID", referencedColumnName = "ORG_ID")
    @ManyToOne(optional = false)
    private SegOrganizacion segOrganizacion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "segModulos")
    private List<SegPerfil> segPerfilList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "segModulos")
    private List<SegMenu> segMenuList;

    public SegModulos() {
    }

    public SegModulos(BigDecimal modId) {
        this.modId = modId;
    }

    public SegModulos(BigDecimal modId, String modNombreModulo) {
        this.modId = modId;
        this.modNombreModulo = modNombreModulo;
    }

    public BigDecimal getModId() {
        return modId;
    }

    public void setModId(BigDecimal modId) {
        this.modId = modId;
    }

    public String getModNombreModulo() {
        return modNombreModulo;
    }

    public void setModNombreModulo(String modNombreModulo) {
        this.modNombreModulo = modNombreModulo;
    }

    public Date getModFechaCreacion() {
        return modFechaCreacion;
    }

    public void setModFechaCreacion(Date modFechaCreacion) {
        this.modFechaCreacion = modFechaCreacion;
    }

    public String getModUrl() {
        return modUrl;
    }

    public void setModUrl(String modUrl) {
        this.modUrl = modUrl;
    }

    public String getModUrlSiguiente() {
        return modUrlSiguiente;
    }

    public void setModUrlSiguiente(String modUrlSiguiente) {
        this.modUrlSiguiente = modUrlSiguiente;
    }

    public SegOrganizacion getSegOrganizacion() {
        return segOrganizacion;
    }

    public void setSegOrganizacion(SegOrganizacion segOrganizacion) {
        this.segOrganizacion = segOrganizacion;
    }

    @XmlTransient
    public List<SegPerfil> getSegPerfilList() {
        return segPerfilList;
    }

    public void setSegPerfilList(List<SegPerfil> segPerfilList) {
        this.segPerfilList = segPerfilList;
    }

    @XmlTransient
    public List<SegMenu> getSegMenuList() {
        return segMenuList;
    }

    public void setSegMenuList(List<SegMenu> segMenuList) {
        this.segMenuList = segMenuList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (modId != null ? modId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SegModulos)) {
            return false;
        }
        SegModulos other = (SegModulos) object;
        if ((this.modId == null && other.modId != null) || (this.modId != null && !this.modId.equals(other.modId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "he1.seguridades.entities.SegModulos[ modId=" + modId + " ]";
    }

}
