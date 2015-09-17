/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package he1.matriz.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author luis_guanoluiza
 */
@Entity
@Table(name = "MCE_PROVINCIAS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MceProvincias.findAll", query = "SELECT m FROM MceProvincias m"),
    @NamedQuery(name = "MceProvincias.findByCodigo", query = "SELECT m FROM MceProvincias m WHERE m.codigo = :codigo"),
    @NamedQuery(name = "MceProvincias.findByProvincia", query = "SELECT m FROM MceProvincias m WHERE m.provincia = :provincia")})
public class MceProvincias implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "CODIGO")
    private String codigo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "PROVINCIA")
    private String provincia;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "mceProvincias")
    private List<MceCantones> mceCantonesList;

    public MceProvincias() {
    }

    public MceProvincias(String codigo) {
        this.codigo = codigo;
    }

    public MceProvincias(String codigo, String provincia) {
        this.codigo = codigo;
        this.provincia = provincia;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    @XmlTransient
    public List<MceCantones> getMceCantonesList() {
        return mceCantonesList;
    }

    public void setMceCantonesList(List<MceCantones> mceCantonesList) {
        this.mceCantonesList = mceCantonesList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigo != null ? codigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MceProvincias)) {
            return false;
        }
        MceProvincias other = (MceProvincias) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "he1.matriz.entities.MceProvincias[ codigo=" + codigo + " ]";
    }
    
}
