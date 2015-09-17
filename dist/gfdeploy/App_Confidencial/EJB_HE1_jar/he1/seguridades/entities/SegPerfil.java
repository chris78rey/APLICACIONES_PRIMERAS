/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package he1.seguridades.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
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
@Table(name = "SEG_PERFIL")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SegPerfil.findAll", query = "SELECT s FROM SegPerfil s"),
    @NamedQuery(name = "SegPerfil.findByPerId", query = "SELECT s FROM SegPerfil s WHERE s.perId = :perId"),
    @NamedQuery(name = "SegPerfil.findByPerDescripcion", query = "SELECT s FROM SegPerfil s WHERE s.perDescripcion = :perDescripcion"),
    @NamedQuery(name = "SegPerfil.findByPerFechaCreacion", query = "SELECT s FROM SegPerfil s WHERE s.perFechaCreacion = :perFechaCreacion"),
    @NamedQuery(name = "SegPerfil.findByPerDefault", query = "SELECT s FROM SegPerfil s WHERE s.perDefault = :perDefault"),
    @NamedQuery(name = "SegPerfil.findByPerOrdenPresentacion", query = "SELECT s FROM SegPerfil s WHERE s.perOrdenPresentacion = :perOrdenPresentacion")})
public class SegPerfil implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @SequenceGenerator(name = "modulos_seg_perfil_rol_seq", sequenceName = "SEGURIDADES.seg_perfil_rol_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "modulos_seg_perfil_rol_seq")
    @Basic(optional = false)
    @NotNull
    @Column(name = "PER_ID")
    private BigDecimal perId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "PER_DESCRIPCION")
    private String perDescripcion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PER_FECHA_CREACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date perFechaCreacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PER_DEFAULT")
    private BigInteger perDefault;
    @Column(name = "PER_ORDEN_PRESENTACION")
    private BigInteger perOrdenPresentacion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "segPerfil")
    private List<SegUsuarioPerfil> segUsuarioPerfilList;
    @JoinColumn(name = "MOD_ID", referencedColumnName = "MOD_ID")
    @ManyToOne(optional = false)
    private SegModulos segModulos;
    @OneToMany(mappedBy = "segPerfil")
    private List<SegMenuHabilita> segMenuHabilitaList;

    public SegPerfil() {
    }

    public SegPerfil(BigDecimal perId) {
        this.perId = perId;
    }

    public SegPerfil(BigDecimal perId, String perDescripcion, Date perFechaCreacion, BigInteger perDefault) {
        this.perId = perId;
        this.perDescripcion = perDescripcion;
        this.perFechaCreacion = perFechaCreacion;
        this.perDefault = perDefault;
    }

    public BigDecimal getPerId() {
        return perId;
    }

    public void setPerId(BigDecimal perId) {
        this.perId = perId;
    }

    public String getPerDescripcion() {
        return perDescripcion;
    }

    public void setPerDescripcion(String perDescripcion) {
        this.perDescripcion = perDescripcion;
    }

    public Date getPerFechaCreacion() {
        return perFechaCreacion;
    }

    public void setPerFechaCreacion(Date perFechaCreacion) {
        this.perFechaCreacion = perFechaCreacion;
    }

    public BigInteger getPerDefault() {
        return perDefault;
    }

    public void setPerDefault(BigInteger perDefault) {
        this.perDefault = perDefault;
    }

    public BigInteger getPerOrdenPresentacion() {
        return perOrdenPresentacion;
    }

    public void setPerOrdenPresentacion(BigInteger perOrdenPresentacion) {
        this.perOrdenPresentacion = perOrdenPresentacion;
    }

    @XmlTransient
    public List<SegUsuarioPerfil> getSegUsuarioPerfilList() {
        return segUsuarioPerfilList;
    }

    public void setSegUsuarioPerfilList(List<SegUsuarioPerfil> segUsuarioPerfilList) {
        this.segUsuarioPerfilList = segUsuarioPerfilList;
    }

    public SegModulos getSegModulos() {
        return segModulos;
    }

    public void setSegModulos(SegModulos segModulos) {
        this.segModulos = segModulos;
    }

    @XmlTransient
    public List<SegMenuHabilita> getSegMenuHabilitaList() {
        return segMenuHabilitaList;
    }

    public void setSegMenuHabilitaList(List<SegMenuHabilita> segMenuHabilitaList) {
        this.segMenuHabilitaList = segMenuHabilitaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (perId != null ? perId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SegPerfil)) {
            return false;
        }
        SegPerfil other = (SegPerfil) object;
        if ((this.perId == null && other.perId != null) || (this.perId != null && !this.perId.equals(other.perId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "he1.seguridades.entities.SegPerfil[ perId=" + perId + " ]";
    }

}
