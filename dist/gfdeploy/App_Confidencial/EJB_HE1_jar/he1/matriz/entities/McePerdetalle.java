/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package he1.matriz.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "MCE_PERDETALLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "McePerdetalle.findAll", query = "SELECT m FROM McePerdetalle m"),
    @NamedQuery(name = "McePerdetalle.findById", query = "SELECT m FROM McePerdetalle m WHERE m.id = :id"),
    @NamedQuery(name = "McePerdetalle.findByCantidad", query = "SELECT m FROM McePerdetalle m WHERE m.cantidad = :cantidad"),
    @NamedQuery(name = "McePerdetalle.findByCodProv", query = "SELECT m FROM McePerdetalle m WHERE m.codProv = :codProv"),
    @NamedQuery(name = "McePerdetalle.findByCaodCanton", query = "SELECT m FROM McePerdetalle m WHERE m.caodCanton = :caodCanton"),
    @NamedQuery(name = "McePerdetalle.findByFueraPlaza", query = "SELECT m FROM McePerdetalle m WHERE m.fueraPlaza = :fueraPlaza")})
public class McePerdetalle implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Column(name = "CANTIDAD")
    private BigInteger cantidad;
    @Size(max = 40)
    @Column(name = "COD_PROV")
    private String codProv;
    @Size(max = 40)
    @Column(name = "CAOD_CANTON")
    private String caodCanton;
    @Column(name = "FUERA_PLAZA")
    private BigInteger fueraPlaza;
    @JoinColumn(name = "ID_CENSO", referencedColumnName = "ID")
    @ManyToOne
    private McePersonal mcePersonal;

    public McePerdetalle() {
    }

    public McePerdetalle(BigDecimal id) {
        this.id = id;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public BigInteger getCantidad() {
        return cantidad;
    }

    public void setCantidad(BigInteger cantidad) {
        this.cantidad = cantidad;
    }

    public String getCodProv() {
        return codProv;
    }

    public void setCodProv(String codProv) {
        this.codProv = codProv;
    }

    public String getCaodCanton() {
        return caodCanton;
    }

    public void setCaodCanton(String caodCanton) {
        this.caodCanton = caodCanton;
    }

    public BigInteger getFueraPlaza() {
        return fueraPlaza;
    }

    public void setFueraPlaza(BigInteger fueraPlaza) {
        this.fueraPlaza = fueraPlaza;
    }

    public McePersonal getMcePersonal() {
        return mcePersonal;
    }

    public void setMcePersonal(McePersonal mcePersonal) {
        this.mcePersonal = mcePersonal;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof McePerdetalle)) {
            return false;
        }
        McePerdetalle other = (McePerdetalle) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "he1.matriz.entities.McePerdetalle[ id=" + id + " ]";
    }
    
}
