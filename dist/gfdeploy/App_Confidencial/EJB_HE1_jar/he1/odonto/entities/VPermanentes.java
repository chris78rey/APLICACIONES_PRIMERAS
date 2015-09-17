/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package he1.odonto.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author luis_guanoluiza
 */
@Entity
@Table(name = "V_PERMANENTES")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VPermanentes.findAll", query = "SELECT v FROM VPermanentes v"),
    @NamedQuery(name = "VPermanentes.findByPiezaDental", query = "SELECT v FROM VPermanentes v WHERE v.piezaDental = :piezaDental"),
    @NamedQuery(name = "VPermanentes.findByOdoId", query = "SELECT v FROM VPermanentes v WHERE v.odoId = :odoId"),
    @NamedQuery(name = "VPermanentes.findByTipo", query = "SELECT v FROM VPermanentes v WHERE v.tipo = :tipo")})
public class VPermanentes implements Serializable {
    private static final long serialVersionUID = 1L;
    @Size(max = 50)
    @Column(name = "PIEZA_DENTAL")
    private String piezaDental;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Column(name = "ODO_ID")
    private BigDecimal odoId;
    @Size(max = 9)
    @Column(name = "TIPO")
    private String tipo;

    public VPermanentes() {
    }

    public VPermanentes(BigDecimal odoId) {
        this.odoId = odoId;
    }

    public String getPiezaDental() {
        return piezaDental;
    }

    public void setPiezaDental(String piezaDental) {
        this.piezaDental = piezaDental;
    }

    public BigDecimal getOdoId() {
        return odoId;
    }

    public void setOdoId(BigDecimal odoId) {
        this.odoId = odoId;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (odoId != null ? odoId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof VPermanentes)) {
            return false;
        }
        VPermanentes other = (VPermanentes) object;
        if ((this.odoId == null && other.odoId != null) || (this.odoId != null && !this.odoId.equals(other.odoId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "he1.entities.VPermanentes[ odoId=" + odoId + " ]";
    }
    
}
