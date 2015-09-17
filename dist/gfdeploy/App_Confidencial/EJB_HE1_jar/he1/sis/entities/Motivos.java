/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package he1.sis.entities;

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
@Table(name = "MOTIVOS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Motivos.findAll", query = "SELECT m FROM Motivos m"),
    @NamedQuery(name = "Motivos.findByCodigo", query = "SELECT m FROM Motivos m WHERE m.codigo = :codigo"),
    @NamedQuery(name = "Motivos.findByDescripcion", query = "SELECT m FROM Motivos m WHERE m.descripcion = :descripcion")})
public class Motivos implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "CODIGO")
    private String codigo;
    @Size(max = 240)
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "motivos")
    private List<HojasDeEvolucion> hojasDeEvolucionList;

    public Motivos() {
    }

    public Motivos(String codigo) {
        this.codigo = codigo;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @XmlTransient
    public List<HojasDeEvolucion> getHojasDeEvolucionList() {
        return hojasDeEvolucionList;
    }

    public void setHojasDeEvolucionList(List<HojasDeEvolucion> hojasDeEvolucionList) {
        this.hojasDeEvolucionList = hojasDeEvolucionList;
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
        if (!(object instanceof Motivos)) {
            return false;
        }
        Motivos other = (Motivos) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "he1.entities.Motivos[ codigo=" + codigo + " ]";
    }
    
}
