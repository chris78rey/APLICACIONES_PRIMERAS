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
@Table(name = "ESPECIALIDADES")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Especialidades.findAll", query = "SELECT e FROM Especialidades e"),
    @NamedQuery(name = "Especialidades.findByCodigo", query = "SELECT e FROM Especialidades e WHERE e.codigo = :codigo"),
    @NamedQuery(name = "Especialidades.findByEspecialidad", query = "SELECT e FROM Especialidades e WHERE e.especialidad = :especialidad"),
    @NamedQuery(name = "Especialidades.findByEstadoDeDisponibilidad", query = "SELECT e FROM Especialidades e WHERE e.estadoDeDisponibilidad = :estadoDeDisponibilidad"),
    @NamedQuery(name = "Especialidades.findByArea", query = "SELECT e FROM Especialidades e WHERE e.area = :area")})
public class Especialidades implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "CODIGO")
    private String codigo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "ESPECIALIDAD")
    private String especialidad;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ESTADO_DE_DISPONIBILIDAD")
    private Character estadoDeDisponibilidad;
    @Size(max = 40)
    @Column(name = "AREA")
    private String area;
    @OneToMany(mappedBy = "especialidades")
    private List<TurnosCamas> turnosCamasList;

    public Especialidades() {
    }

    public Especialidades(String codigo) {
        this.codigo = codigo;
    }

    public Especialidades(String codigo, String especialidad, Character estadoDeDisponibilidad) {
        this.codigo = codigo;
        this.especialidad = especialidad;
        this.estadoDeDisponibilidad = estadoDeDisponibilidad;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public Character getEstadoDeDisponibilidad() {
        return estadoDeDisponibilidad;
    }

    public void setEstadoDeDisponibilidad(Character estadoDeDisponibilidad) {
        this.estadoDeDisponibilidad = estadoDeDisponibilidad;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    @XmlTransient
    public List<TurnosCamas> getTurnosCamasList() {
        return turnosCamasList;
    }

    public void setTurnosCamasList(List<TurnosCamas> turnosCamasList) {
        this.turnosCamasList = turnosCamasList;
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
        if (!(object instanceof Especialidades)) {
            return false;
        }
        Especialidades other = (Especialidades) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "he1.sis.entities.Especialidades[ codigo=" + codigo + " ]";
    }
    
}
