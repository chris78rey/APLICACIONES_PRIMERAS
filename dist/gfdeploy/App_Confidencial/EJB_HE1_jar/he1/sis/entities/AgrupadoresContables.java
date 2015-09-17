/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package he1.sis.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author luis_guanoluiza
 */
@Entity
@Table(name = "AGRUPADORES_CONTABLES")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AgrupadoresContables.findAll", query = "SELECT a FROM AgrupadoresContables a"),
    @NamedQuery(name = "AgrupadoresContables.findByTipo", query = "SELECT a FROM AgrupadoresContables a WHERE a.agrupadoresContablesPK.tipo = :tipo"),
    @NamedQuery(name = "AgrupadoresContables.findByCodigo", query = "SELECT a FROM AgrupadoresContables a WHERE a.agrupadoresContablesPK.codigo = :codigo"),
    @NamedQuery(name = "AgrupadoresContables.findByDescripcion", query = "SELECT a FROM AgrupadoresContables a WHERE a.descripcion = :descripcion"),
    @NamedQuery(name = "AgrupadoresContables.findByCuentaContableMayor", query = "SELECT a FROM AgrupadoresContables a WHERE a.cuentaContableMayor = :cuentaContableMayor"),
    @NamedQuery(name = "AgrupadoresContables.findByEmpCodigo", query = "SELECT a FROM AgrupadoresContables a WHERE a.agrupadoresContablesPK.empCodigo = :empCodigo"),
    @NamedQuery(name = "AgrupadoresContables.findByContraCuentaContableMayor", query = "SELECT a FROM AgrupadoresContables a WHERE a.contraCuentaContableMayor = :contraCuentaContableMayor")})
public class AgrupadoresContables implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected AgrupadoresContablesPK agrupadoresContablesPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 240)
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "CUENTA_CONTABLE_MAYOR")
    private String cuentaContableMayor;
    @Size(max = 40)
    @Column(name = "CONTRA_CUENTA_CONTABLE_MAYOR")
    private String contraCuentaContableMayor;

    public AgrupadoresContables() {
    }

    public AgrupadoresContables(AgrupadoresContablesPK agrupadoresContablesPK) {
        this.agrupadoresContablesPK = agrupadoresContablesPK;
    }

    public AgrupadoresContables(AgrupadoresContablesPK agrupadoresContablesPK, String descripcion, String cuentaContableMayor) {
        this.agrupadoresContablesPK = agrupadoresContablesPK;
        this.descripcion = descripcion;
        this.cuentaContableMayor = cuentaContableMayor;
    }

    public AgrupadoresContables(String tipo, String codigo, String empCodigo) {
        this.agrupadoresContablesPK = new AgrupadoresContablesPK(tipo, codigo, empCodigo);
    }

    public AgrupadoresContablesPK getAgrupadoresContablesPK() {
        return agrupadoresContablesPK;
    }

    public void setAgrupadoresContablesPK(AgrupadoresContablesPK agrupadoresContablesPK) {
        this.agrupadoresContablesPK = agrupadoresContablesPK;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getCuentaContableMayor() {
        return cuentaContableMayor;
    }

    public void setCuentaContableMayor(String cuentaContableMayor) {
        this.cuentaContableMayor = cuentaContableMayor;
    }

    public String getContraCuentaContableMayor() {
        return contraCuentaContableMayor;
    }

    public void setContraCuentaContableMayor(String contraCuentaContableMayor) {
        this.contraCuentaContableMayor = contraCuentaContableMayor;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (agrupadoresContablesPK != null ? agrupadoresContablesPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AgrupadoresContables)) {
            return false;
        }
        AgrupadoresContables other = (AgrupadoresContables) object;
        if ((this.agrupadoresContablesPK == null && other.agrupadoresContablesPK != null) || (this.agrupadoresContablesPK != null && !this.agrupadoresContablesPK.equals(other.agrupadoresContablesPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.AgrupadoresContables[ agrupadoresContablesPK=" + agrupadoresContablesPK + " ]";
    }
    
}
