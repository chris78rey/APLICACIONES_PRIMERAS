/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package groupidmaven.common.ejb;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author christian_ruiz
 */
@Entity
@Table(name = "TIPO_EQUIPO")
@NamedQueries({
    @NamedQuery(name = "TipoEquipo.findAll", query = "SELECT t FROM TipoEquipo t"),
    @NamedQuery(name = "TipoEquipo.findByTeqId", query = "SELECT t FROM TipoEquipo t WHERE t.teqId = :teqId"),
    @NamedQuery(name = "TipoEquipo.findByTeqDescripcion", query = "SELECT t FROM TipoEquipo t WHERE t.teqDescripcion = :teqDescripcion")})
public class TipoEquipo implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "TEQ_ID")
    private BigDecimal teqId;
    @Size(max = 255)
    @Column(name = "TEQ_DESCRIPCION")
    private String teqDescripcion;

    public TipoEquipo() {
    }

    public TipoEquipo(BigDecimal teqId) {
        this.teqId = teqId;
    }

    public BigDecimal getTeqId() {
        return teqId;
    }

    public void setTeqId(BigDecimal teqId) {
        this.teqId = teqId;
    }

    public String getTeqDescripcion() {
        return teqDescripcion;
    }

    public void setTeqDescripcion(String teqDescripcion) {
        this.teqDescripcion = teqDescripcion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (teqId != null ? teqId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoEquipo)) {
            return false;
        }
        TipoEquipo other = (TipoEquipo) object;
        if ((this.teqId == null && other.teqId != null) || (this.teqId != null && !this.teqId.equals(other.teqId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "groupidmaven.common.ejb.TipoEquipo[ teqId=" + teqId + " ]";
    }
    
}
