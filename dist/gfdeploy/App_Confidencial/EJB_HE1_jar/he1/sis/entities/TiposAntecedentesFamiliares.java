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
@Table(name = "TIPOS_ANTECEDENTES_FAMILIARES")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TiposAntecedentesFamiliares.findAll", query = "SELECT t FROM TiposAntecedentesFamiliares t"),
    @NamedQuery(name = "TiposAntecedentesFamiliares.findById", query = "SELECT t FROM TiposAntecedentesFamiliares t WHERE t.id = :id"),
    @NamedQuery(name = "TiposAntecedentesFamiliares.findByDescripcion", query = "SELECT t FROM TiposAntecedentesFamiliares t WHERE t.descripcion = :descripcion"),
    @NamedQuery(name = "TiposAntecedentesFamiliares.findByEstadoDeDisponibilidad", query = "SELECT t FROM TiposAntecedentesFamiliares t WHERE t.estadoDeDisponibilidad = :estadoDeDisponibilidad")})
public class TiposAntecedentesFamiliares implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ESTADO_DE_DISPONIBILIDAD")
    private Character estadoDeDisponibilidad;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tiposAntecedentesFamiliares")
    private List<AntecedentesFamiliares> antecedentesFamiliaresList;

    public TiposAntecedentesFamiliares() {
    }

    public TiposAntecedentesFamiliares(Integer id) {
        this.id = id;
    }

    public TiposAntecedentesFamiliares(Integer id, String descripcion, Character estadoDeDisponibilidad) {
        this.id = id;
        this.descripcion = descripcion;
        this.estadoDeDisponibilidad = estadoDeDisponibilidad;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Character getEstadoDeDisponibilidad() {
        return estadoDeDisponibilidad;
    }

    public void setEstadoDeDisponibilidad(Character estadoDeDisponibilidad) {
        this.estadoDeDisponibilidad = estadoDeDisponibilidad;
    }

    @XmlTransient
    public List<AntecedentesFamiliares> getAntecedentesFamiliaresList() {
        return antecedentesFamiliaresList;
    }

    public void setAntecedentesFamiliaresList(List<AntecedentesFamiliares> antecedentesFamiliaresList) {
        this.antecedentesFamiliaresList = antecedentesFamiliaresList;
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
        if (!(object instanceof TiposAntecedentesFamiliares)) {
            return false;
        }
        TiposAntecedentesFamiliares other = (TiposAntecedentesFamiliares) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "he1.entities.TiposAntecedentesFamiliares[ id=" + id + " ]";
    }
    
}
