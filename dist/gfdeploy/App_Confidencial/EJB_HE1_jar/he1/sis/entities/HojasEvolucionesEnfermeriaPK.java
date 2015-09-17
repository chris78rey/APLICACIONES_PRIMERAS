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
import javax.validation.constraints.Size;

/**
 *
 * @author luis_guanoluiza
 */
@Embeddable
public class HojasEvolucionesEnfermeriaPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "PRMATN_PCN_NUMERO_HC")
    private int prmatnPcnNumeroHc;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PRMATN_NUMERO")
    private int prmatnNumero;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "TURNO")
    private String turno;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;

    public HojasEvolucionesEnfermeriaPK() {
    }

    public HojasEvolucionesEnfermeriaPK(int prmatnPcnNumeroHc, int prmatnNumero, String turno, Date fecha) {
        this.prmatnPcnNumeroHc = prmatnPcnNumeroHc;
        this.prmatnNumero = prmatnNumero;
        this.turno = turno;
        this.fecha = fecha;
    }

    public int getPrmatnPcnNumeroHc() {
        return prmatnPcnNumeroHc;
    }

    public void setPrmatnPcnNumeroHc(int prmatnPcnNumeroHc) {
        this.prmatnPcnNumeroHc = prmatnPcnNumeroHc;
    }

    public int getPrmatnNumero() {
        return prmatnNumero;
    }

    public void setPrmatnNumero(int prmatnNumero) {
        this.prmatnNumero = prmatnNumero;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
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
        hash += (int) prmatnPcnNumeroHc;
        hash += (int) prmatnNumero;
        hash += (turno != null ? turno.hashCode() : 0);
        hash += (fecha != null ? fecha.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HojasEvolucionesEnfermeriaPK)) {
            return false;
        }
        HojasEvolucionesEnfermeriaPK other = (HojasEvolucionesEnfermeriaPK) object;
        if (this.prmatnPcnNumeroHc != other.prmatnPcnNumeroHc) {
            return false;
        }
        if (this.prmatnNumero != other.prmatnNumero) {
            return false;
        }
        if ((this.turno == null && other.turno != null) || (this.turno != null && !this.turno.equals(other.turno))) {
            return false;
        }
        if ((this.fecha == null && other.fecha != null) || (this.fecha != null && !this.fecha.equals(other.fecha))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "he1.sis.entities.HojasEvolucionesEnfermeriaPK[ prmatnPcnNumeroHc=" + prmatnPcnNumeroHc + ", prmatnNumero=" + prmatnNumero + ", turno=" + turno + ", fecha=" + fecha + " ]";
    }
    
}
