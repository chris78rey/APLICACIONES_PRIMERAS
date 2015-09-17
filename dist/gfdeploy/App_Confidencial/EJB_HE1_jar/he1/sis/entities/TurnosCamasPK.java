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
public class TurnosCamasPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @Basic(optional = false)
    @NotNull
    @Column(name = "OCUPADA")
    private Character ocupada;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CMAHSP_SALA")
    private short cmahspSala;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "CMAHSP_CAMA")
    private String cmahspCama;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PRM_NUMERO")
    private int prmNumero;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PRM_PCN_NUMERO_HC")
    private int prmPcnNumeroHc;

    public TurnosCamasPK() {
    }

    public TurnosCamasPK(Date fecha, Character ocupada, short cmahspSala, String cmahspCama, int prmNumero, int prmPcnNumeroHc) {
        this.fecha = fecha;
        this.ocupada = ocupada;
        this.cmahspSala = cmahspSala;
        this.cmahspCama = cmahspCama;
        this.prmNumero = prmNumero;
        this.prmPcnNumeroHc = prmPcnNumeroHc;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Character getOcupada() {
        return ocupada;
    }

    public void setOcupada(Character ocupada) {
        this.ocupada = ocupada;
    }

    public short getCmahspSala() {
        return cmahspSala;
    }

    public void setCmahspSala(short cmahspSala) {
        this.cmahspSala = cmahspSala;
    }

    public String getCmahspCama() {
        return cmahspCama;
    }

    public void setCmahspCama(String cmahspCama) {
        this.cmahspCama = cmahspCama;
    }

    public int getPrmNumero() {
        return prmNumero;
    }

    public void setPrmNumero(int prmNumero) {
        this.prmNumero = prmNumero;
    }

    public int getPrmPcnNumeroHc() {
        return prmPcnNumeroHc;
    }

    public void setPrmPcnNumeroHc(int prmPcnNumeroHc) {
        this.prmPcnNumeroHc = prmPcnNumeroHc;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (fecha != null ? fecha.hashCode() : 0);
        hash += (ocupada != null ? ocupada.hashCode() : 0);
        hash += (int) cmahspSala;
        hash += (cmahspCama != null ? cmahspCama.hashCode() : 0);
        hash += (int) prmNumero;
        hash += (int) prmPcnNumeroHc;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TurnosCamasPK)) {
            return false;
        }
        TurnosCamasPK other = (TurnosCamasPK) object;
        if ((this.fecha == null && other.fecha != null) || (this.fecha != null && !this.fecha.equals(other.fecha))) {
            return false;
        }
        if ((this.ocupada == null && other.ocupada != null) || (this.ocupada != null && !this.ocupada.equals(other.ocupada))) {
            return false;
        }
        if (this.cmahspSala != other.cmahspSala) {
            return false;
        }
        if ((this.cmahspCama == null && other.cmahspCama != null) || (this.cmahspCama != null && !this.cmahspCama.equals(other.cmahspCama))) {
            return false;
        }
        if (this.prmNumero != other.prmNumero) {
            return false;
        }
        if (this.prmPcnNumeroHc != other.prmPcnNumeroHc) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "he1.sis.entities.TurnosCamasPK[ fecha=" + fecha + ", ocupada=" + ocupada + ", cmahspSala=" + cmahspSala + ", cmahspCama=" + cmahspCama + ", prmNumero=" + prmNumero + ", prmPcnNumeroHc=" + prmPcnNumeroHc + " ]";
    }
    
}
