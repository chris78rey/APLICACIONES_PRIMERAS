/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package he1.sis.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

/**
 *
 * @author luis_guanoluiza
 */
@Embeddable
public class AntecedentesPersonalesPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "PCN_NUMERO_HC")
    private int pcnNumeroHc;
    @Basic(optional = false)
    @NotNull
    @Column(name = "TPOANTPRS_ID")
    private int tpoantprsId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;

    public AntecedentesPersonalesPK() {
    }

    public AntecedentesPersonalesPK(int pcnNumeroHc, int tpoantprsId, Date fecha) {
        this.pcnNumeroHc = pcnNumeroHc;
        this.tpoantprsId = tpoantprsId;
        this.fecha = fecha;
    }

    public int getPcnNumeroHc() {
        return pcnNumeroHc;
    }

    public void setPcnNumeroHc(int pcnNumeroHc) {
        this.pcnNumeroHc = pcnNumeroHc;
    }

    public int getTpoantprsId() {
        return tpoantprsId;
    }

    public void setTpoantprsId(int tpoantprsId) {
        this.tpoantprsId = tpoantprsId;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) pcnNumeroHc;
        hash += (int) tpoantprsId;
        hash += (fecha != null ? fecha.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AntecedentesPersonalesPK)) {
            return false;
        }
        AntecedentesPersonalesPK other = (AntecedentesPersonalesPK) object;
        if (this.pcnNumeroHc != other.pcnNumeroHc) {
            return false;
        }
        if (this.tpoantprsId != other.tpoantprsId) {
            return false;
        }
        if ((this.fecha == null && other.fecha != null) || (this.fecha != null && !this.fecha.equals(other.fecha))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "he1.entities.AntecedentesPersonalesPK[ pcnNumeroHc=" + pcnNumeroHc + ", tpoantprsId=" + tpoantprsId + ", fecha=" + fecha + " ]";
    }
    
}
