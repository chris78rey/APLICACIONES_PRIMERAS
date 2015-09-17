/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package he1.seguridades.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
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
@Table(name = "SEG_LOGS_SISTEMA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SegLogsSistema.findAll", query = "SELECT s FROM SegLogsSistema s"),
    @NamedQuery(name = "SegLogsSistema.findByLsiId", query = "SELECT s FROM SegLogsSistema s WHERE s.lsiId = :lsiId"),
    @NamedQuery(name = "SegLogsSistema.findByLsiMensaje", query = "SELECT s FROM SegLogsSistema s WHERE s.lsiMensaje = :lsiMensaje"),
    @NamedQuery(name = "SegLogsSistema.findByLsiFechaEvento", query = "SELECT s FROM SegLogsSistema s WHERE s.lsiFechaEvento = :lsiFechaEvento"),
    @NamedQuery(name = "SegLogsSistema.findByModulo", query = "SELECT s FROM SegLogsSistema s WHERE s.modulo = :modulo")})
public class SegLogsSistema implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "LSI_ID")
    private BigDecimal lsiId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4000)
    @Column(name = "LSI_MENSAJE")
    private String lsiMensaje;
    @Basic(optional = false)
    @NotNull
    @Column(name = "LSI_FECHA_EVENTO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lsiFechaEvento;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "MODULO")
    private String modulo;

    public SegLogsSistema() {
    }

    public SegLogsSistema(BigDecimal lsiId) {
        this.lsiId = lsiId;
    }

    public SegLogsSistema(BigDecimal lsiId, String lsiMensaje, Date lsiFechaEvento, String modulo) {
        this.lsiId = lsiId;
        this.lsiMensaje = lsiMensaje;
        this.lsiFechaEvento = lsiFechaEvento;
        this.modulo = modulo;
    }

    public BigDecimal getLsiId() {
        return lsiId;
    }

    public void setLsiId(BigDecimal lsiId) {
        this.lsiId = lsiId;
    }

    public String getLsiMensaje() {
        return lsiMensaje;
    }

    public void setLsiMensaje(String lsiMensaje) {
        this.lsiMensaje = lsiMensaje;
    }

    public Date getLsiFechaEvento() {
        return lsiFechaEvento;
    }

    public void setLsiFechaEvento(Date lsiFechaEvento) {
        this.lsiFechaEvento = lsiFechaEvento;
    }

    public String getModulo() {
        return modulo;
    }

    public void setModulo(String modulo) {
        this.modulo = modulo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (lsiId != null ? lsiId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SegLogsSistema)) {
            return false;
        }
        SegLogsSistema other = (SegLogsSistema) object;
        if ((this.lsiId == null && other.lsiId != null) || (this.lsiId != null && !this.lsiId.equals(other.lsiId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "he1.seguridades.entities.SegLogsSistema[ lsiId=" + lsiId + " ]";
    }
    
}
