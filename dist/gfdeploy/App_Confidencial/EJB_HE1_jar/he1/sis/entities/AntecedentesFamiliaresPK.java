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
public class AntecedentesFamiliaresPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "TPOANTFML_ID")
    private int tpoantfmlId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PCN_NUMERO_HC")
    private int pcnNumeroHc;

    public AntecedentesFamiliaresPK() {
    }

    public AntecedentesFamiliaresPK(int tpoantfmlId, Date fecha, int pcnNumeroHc) {
        this.tpoantfmlId = tpoantfmlId;
        this.fecha = fecha;
        this.pcnNumeroHc = pcnNumeroHc;
    }

    public int getTpoantfmlId() {
        return tpoantfmlId;
    }

    public void setTpoantfmlId(int tpoantfmlId) {
        this.tpoantfmlId = tpoantfmlId;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getPcnNumeroHc() {
        return pcnNumeroHc;
    }

    public void setPcnNumeroHc(int pcnNumeroHc) {
        this.pcnNumeroHc = pcnNumeroHc;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) tpoantfmlId;
        hash += (fecha != null ? fecha.hashCode() : 0);
        hash += (int) pcnNumeroHc;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AntecedentesFamiliaresPK)) {
            return false;
        }
        AntecedentesFamiliaresPK other = (AntecedentesFamiliaresPK) object;
        if (this.tpoantfmlId != other.tpoantfmlId) {
            return false;
        }
        if ((this.fecha == null && other.fecha != null) || (this.fecha != null && !this.fecha.equals(other.fecha))) {
            return false;
        }
        if (this.pcnNumeroHc != other.pcnNumeroHc) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "he1.entities.AntecedentesFamiliaresPK[ tpoantfmlId=" + tpoantfmlId + ", fecha=" + fecha + ", pcnNumeroHc=" + pcnNumeroHc + " ]";
    }
    
}
