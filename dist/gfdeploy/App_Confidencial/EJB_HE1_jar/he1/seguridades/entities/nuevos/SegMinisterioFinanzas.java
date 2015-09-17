/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package he1.seguridades.entities.nuevos;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
 * @author christian_ruiz
 */
@Entity
@Table(name = "SEG_MINISTERIO_FINANZAS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SegMinisterioFinanzas.findAll", query = "SELECT s FROM SegMinisterioFinanzas s"),
    @NamedQuery(name = "SegMinisterioFinanzas.findById", query = "SELECT s FROM SegMinisterioFinanzas s WHERE s.id = :id"),
    @NamedQuery(name = "SegMinisterioFinanzas.findByMfiAnio", query = "SELECT s FROM SegMinisterioFinanzas s WHERE s.mfiAnio = :mfiAnio"),
    @NamedQuery(name = "SegMinisterioFinanzas.findByMfiMes", query = "SELECT s FROM SegMinisterioFinanzas s WHERE s.mfiMes = :mfiMes"),
    @NamedQuery(name = "SegMinisterioFinanzas.findByMfiCodigo", query = "SELECT s FROM SegMinisterioFinanzas s WHERE s.mfiCodigo = :mfiCodigo"),
    @NamedQuery(name = "SegMinisterioFinanzas.findByMfiDesc", query = "SELECT s FROM SegMinisterioFinanzas s WHERE s.mfiDesc = :mfiDesc"),
    @NamedQuery(name = "SegMinisterioFinanzas.findByActivo", query = "SELECT s FROM SegMinisterioFinanzas s WHERE s.activo = :activo"),
    @NamedQuery(name = "SegMinisterioFinanzas.findByOrden", query = "SELECT s FROM SegMinisterioFinanzas s WHERE s.orden = :orden")})
public class SegMinisterioFinanzas implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Size(max = 20)
    @Column(name = "MFI_ANIO")
    private String mfiAnio;
    @Size(max = 20)
    @Column(name = "MFI_MES")
    private String mfiMes;
    @Size(max = 100)
    @Column(name = "MFI_CODIGO")
    private String mfiCodigo;
    @Size(max = 50)
    @Column(name = "MFI_DESC")
    private String mfiDesc;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ACTIVO")
    private BigInteger activo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ORDEN")
    private BigInteger orden;
    @JoinColumn(name = "TRL_ID", referencedColumnName = "TRL_IDTIPORELACION")
    @ManyToOne
    private TipoRelacionLaboral tipoRelacionLaboral;

    public SegMinisterioFinanzas() {
    }

    public SegMinisterioFinanzas(BigDecimal id) {
        this.id = id;
    }

    public SegMinisterioFinanzas(BigDecimal id, BigInteger activo, BigInteger orden) {
        this.id = id;
        this.activo = activo;
        this.orden = orden;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getMfiAnio() {
        return mfiAnio;
    }

    public void setMfiAnio(String mfiAnio) {
        this.mfiAnio = mfiAnio;
    }

    public String getMfiMes() {
        return mfiMes;
    }

    public void setMfiMes(String mfiMes) {
        this.mfiMes = mfiMes;
    }

    public String getMfiCodigo() {
        return mfiCodigo;
    }

    public void setMfiCodigo(String mfiCodigo) {
        this.mfiCodigo = mfiCodigo;
    }

    public String getMfiDesc() {
        return mfiDesc;
    }

    public void setMfiDesc(String mfiDesc) {
        this.mfiDesc = mfiDesc;
    }

    public BigInteger getActivo() {
        return activo;
    }

    public void setActivo(BigInteger activo) {
        this.activo = activo;
    }

    public BigInteger getOrden() {
        return orden;
    }

    public void setOrden(BigInteger orden) {
        this.orden = orden;
    }

    public TipoRelacionLaboral getTipoRelacionLaboral() {
        return tipoRelacionLaboral;
    }

    public void setTipoRelacionLaboral(TipoRelacionLaboral tipoRelacionLaboral) {
        this.tipoRelacionLaboral = tipoRelacionLaboral;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SegMinisterioFinanzas)) {
            return false;
        }
        SegMinisterioFinanzas other = (SegMinisterioFinanzas) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "he1.seguridades.entities.nuevos.SegMinisterioFinanzas[ id=" + id + " ]";
    }
    
}
