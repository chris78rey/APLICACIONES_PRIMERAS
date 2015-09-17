/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package he1.sis.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author luis_guanoluiza
 */
@Embeddable
public class PermanenciasYAtencionesPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "PCN_NUMERO_HC")
    private int pcnNumeroHc;
    @Basic(optional = false)
    @NotNull
    @Column(name = "NUMERO")
    private int numero;

    public PermanenciasYAtencionesPK() {
    }

    public PermanenciasYAtencionesPK(int pcnNumeroHc, int numero) {
        this.pcnNumeroHc = pcnNumeroHc;
        this.numero = numero;
    }

    public int getPcnNumeroHc() {
        return pcnNumeroHc;
    }

    public void setPcnNumeroHc(int pcnNumeroHc) {
        this.pcnNumeroHc = pcnNumeroHc;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) pcnNumeroHc;
        hash += (int) numero;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PermanenciasYAtencionesPK)) {
            return false;
        }
        PermanenciasYAtencionesPK other = (PermanenciasYAtencionesPK) object;
        if (this.pcnNumeroHc != other.pcnNumeroHc) {
            return false;
        }
        if (this.numero != other.numero) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "he1.sis.entities.PermanenciasYAtencionesPK[ pcnNumeroHc=" + pcnNumeroHc + ", numero=" + numero + " ]";
    }
    
}
