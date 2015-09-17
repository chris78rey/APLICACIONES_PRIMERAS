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
import javax.validation.constraints.Size;

/**
 *
 * @author luis_guanoluiza
 */
@Embeddable
public class DepartamentosPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "ARA_CODIGO")
    private String araCodigo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "CODIGO")
    private String codigo;

    public DepartamentosPK() {
    }

    public DepartamentosPK(String araCodigo, String codigo) {
        this.araCodigo = araCodigo;
        this.codigo = codigo;
    }

    public String getAraCodigo() {
        return araCodigo;
    }

    public void setAraCodigo(String araCodigo) {
        this.araCodigo = araCodigo;
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
        hash += (araCodigo != null ? araCodigo.hashCode() : 0);
        hash += (codigo != null ? codigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DepartamentosPK)) {
            return false;
        }
        DepartamentosPK other = (DepartamentosPK) object;
        if ((this.araCodigo == null && other.araCodigo != null) || (this.araCodigo != null && !this.araCodigo.equals(other.araCodigo))) {
            return false;
        }
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.DepartamentosPK[ araCodigo=" + araCodigo + ", codigo=" + codigo + " ]";
    }
    
}
