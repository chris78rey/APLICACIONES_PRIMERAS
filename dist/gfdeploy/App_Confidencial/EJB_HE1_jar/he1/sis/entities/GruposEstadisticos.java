/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package he1.sis.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
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
@Table(name = "GRUPOS_ESTADISTICOS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GruposEstadisticos.findAll", query = "SELECT g FROM GruposEstadisticos g"),
    @NamedQuery(name = "GruposEstadisticos.findByCodigo", query = "SELECT g FROM GruposEstadisticos g WHERE g.codigo = :codigo"),
    @NamedQuery(name = "GruposEstadisticos.findByConteo", query = "SELECT g FROM GruposEstadisticos g WHERE g.conteo = :conteo"),
    @NamedQuery(name = "GruposEstadisticos.findByDescripcion", query = "SELECT g FROM GruposEstadisticos g WHERE g.descripcion = :descripcion"),
    @NamedQuery(name = "GruposEstadisticos.findByOrden", query = "SELECT g FROM GruposEstadisticos g WHERE g.orden = :orden")})
public class GruposEstadisticos implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "CODIGO")
    private String codigo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "CONTEO")
    private String conteo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @Column(name = "ORDEN")
    private Short orden;
    @OneToMany(mappedBy = "gruposEstadisticos")
    private List<VariablesDeExamenes> variablesDeExamenesList;

    public GruposEstadisticos() {
    }

    public GruposEstadisticos(String codigo) {
        this.codigo = codigo;
    }

    public GruposEstadisticos(String codigo, String conteo, String descripcion) {
        this.codigo = codigo;
        this.conteo = conteo;
        this.descripcion = descripcion;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getConteo() {
        return conteo;
    }

    public void setConteo(String conteo) {
        this.conteo = conteo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Short getOrden() {
        return orden;
    }

    public void setOrden(Short orden) {
        this.orden = orden;
    }

    @XmlTransient
    public List<VariablesDeExamenes> getVariablesDeExamenesList() {
        return variablesDeExamenesList;
    }

    public void setVariablesDeExamenesList(List<VariablesDeExamenes> variablesDeExamenesList) {
        this.variablesDeExamenesList = variablesDeExamenesList;
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
        if (!(object instanceof GruposEstadisticos)) {
            return false;
        }
        GruposEstadisticos other = (GruposEstadisticos) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.GruposEstadisticos[ codigo=" + codigo + " ]";
    }
    
}
