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
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author christian_ruiz
 */
@Entity
@Table(name = "SEG_USUARIO_PERFIL")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SegUsuarioPerfil.findAll", query = "SELECT s FROM SegUsuarioPerfil s"),
    @NamedQuery(name = "SegUsuarioPerfil.findByUmoId", query = "SELECT s FROM SegUsuarioPerfil s WHERE s.umoId = :umoId"),
    @NamedQuery(name = "SegUsuarioPerfil.findByCodigoPersonal", query = "SELECT s FROM SegUsuarioPerfil s WHERE s.codigoPersonal = :codigoPersonal"),
    @NamedQuery(name = "SegUsuarioPerfil.findByUmoFechaCreacion", query = "SELECT s FROM SegUsuarioPerfil s WHERE s.umoFechaCreacion = :umoFechaCreacion"),
    @NamedQuery(name = "SegUsuarioPerfil.findByUmoActivo", query = "SELECT s FROM SegUsuarioPerfil s WHERE s.umoActivo = :umoActivo")})
public class SegUsuarioPerfil implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @SequenceGenerator(name = "modulos_SEG_USUARIO_MODULO_SEQ", sequenceName = "SEGURIDADES.SEG_USUARIO_MODULO_SEQ")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "modulos_SEG_USUARIO_MODULO_SEQ")
    @Basic(optional = false)
    @NotNull
    @Column(name = "UMO_ID")
    private BigDecimal umoId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "CODIGO_PERSONAL")
    private String codigoPersonal;
    @Basic(optional = false)
    @NotNull
    @Column(name = "UMO_FECHA_CREACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date umoFechaCreacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "UMO_ACTIVO")
    private BigInteger umoActivo;
    @JoinColumn(name = "PER_ID", referencedColumnName = "PER_ID")
    @ManyToOne(optional = false)
    private SegPerfil segPerfil;
    @JoinColumn(name = "USU_ID", referencedColumnName = "ID")
    @ManyToOne
    private SegUsuario segUsuario;

    public SegUsuarioPerfil() {
    }

    public SegUsuarioPerfil(BigDecimal umoId) {
        this.umoId = umoId;
    }

    public SegUsuarioPerfil(BigDecimal umoId, String codigoPersonal, Date umoFechaCreacion, BigInteger umoActivo) {
        this.umoId = umoId;
        this.codigoPersonal = codigoPersonal;
        this.umoFechaCreacion = umoFechaCreacion;
        this.umoActivo = umoActivo;
    }

    public BigDecimal getUmoId() {
        return umoId;
    }

    public void setUmoId(BigDecimal umoId) {
        this.umoId = umoId;
    }

    public String getCodigoPersonal() {
        return codigoPersonal;
    }

    public void setCodigoPersonal(String codigoPersonal) {
        this.codigoPersonal = codigoPersonal;
    }

    public Date getUmoFechaCreacion() {
        return umoFechaCreacion;
    }

    public void setUmoFechaCreacion(Date umoFechaCreacion) {
        this.umoFechaCreacion = umoFechaCreacion;
    }

    public BigInteger getUmoActivo() {
        return umoActivo;
    }

    public void setUmoActivo(BigInteger umoActivo) {
        this.umoActivo = umoActivo;
    }

    public SegPerfil getSegPerfil() {
        return segPerfil;
    }

    public void setSegPerfil(SegPerfil segPerfil) {
        this.segPerfil = segPerfil;
    }

    public SegUsuario getSegUsuario() {
        return segUsuario;
    }

    public void setSegUsuario(SegUsuario segUsuario) {
        this.segUsuario = segUsuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (umoId != null ? umoId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SegUsuarioPerfil)) {
            return false;
        }
        SegUsuarioPerfil other = (SegUsuarioPerfil) object;
        if ((this.umoId == null && other.umoId != null) || (this.umoId != null && !this.umoId.equals(other.umoId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "he1.seguridades.entities.SegUsuarioPerfil[ umoId=" + umoId + " ]";
    }

}
