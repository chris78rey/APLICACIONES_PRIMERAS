/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package he1.matriz.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author luis_guanoluiza
 */
@Embeddable
public class MceCantonesPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "PRV_CODIGO")
    private String prvCodigo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "CODIGO")
    private String codigo;

    public MceCantonesPK() {
    }

    public MceCantonesPK(String prvCodigo, String codigo) {
        this.prvCodigo = prvCodigo;
        this.codigo = codigo;
    }

    public String getPrvCodigo() {
        return prvCodigo;
    }

    public void setPrvCodigo(String prvCodigo) {
        this.prvCodigo = prvCodigo;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (prvCodigo != null ? prvCodigo.hashCode() : 0);
        hash += (codigo != null ? codigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MceCantonesPK)) {
            return false;
        }
        MceCantonesPK other = (MceCantonesPK) object;
        if ((this.prvCodigo == null && other.prvCodigo != null) || (this.prvCodigo != null && !this.prvCodigo.equals(other.prvCodigo))) {
            return false;
        }
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "he1.matriz.entities.MceCantonesPK[ prvCodigo=" + prvCodigo + ", codigo=" + codigo + " ]";
    }
    
}
