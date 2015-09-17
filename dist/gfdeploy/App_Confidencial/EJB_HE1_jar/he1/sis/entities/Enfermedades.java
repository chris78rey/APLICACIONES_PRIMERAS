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
@Table(name = "ENFERMEDADES")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Enfermedades.findAll", query = "SELECT e FROM Enfermedades e"),
    @NamedQuery(name = "Enfermedades.findByCodigo", query = "SELECT e FROM Enfermedades e WHERE e.codigo = :codigo"),
    @NamedQuery(name = "Enfermedades.findByEnfermedad", query = "SELECT e FROM Enfermedades e WHERE e.enfermedad = :enfermedad"),
    @NamedQuery(name = "Enfermedades.findBySintomas", query = "SELECT e FROM Enfermedades e WHERE e.sintomas = :sintomas"),
    @NamedQuery(name = "Enfermedades.findByCodigoOms", query = "SELECT e FROM Enfermedades e WHERE e.codigoOms = :codigoOms")})
public class Enfermedades implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 7)
    @Column(name = "CODIGO")
    private String codigo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "ENFERMEDAD")
    private String enfermedad;
    @Size(max = 255)
    @Column(name = "SINTOMAS")
    private String sintomas;
    @Size(max = 10)
    @Column(name = "CODIGO_OMS")
    private String codigoOms;
    @OneToMany(mappedBy = "enfermedades")
    private List<AntecedentesFamiliares> antecedentesFamiliaresList;
    @OneToMany(mappedBy = "enfermedades")
    private List<AntecedentesPersonales> antecedentesPersonalesList;

    public Enfermedades() {
    }

    public Enfermedades(String codigo) {
        this.codigo = codigo;
    }

    public Enfermedades(String codigo, String enfermedad) {
        this.codigo = codigo;
        this.enfermedad = enfermedad;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getEnfermedad() {
        return enfermedad;
    }

    public void setEnfermedad(String enfermedad) {
        this.enfermedad = enfermedad;
    }

    public String getSintomas() {
        return sintomas;
    }

    public void setSintomas(String sintomas) {
        this.sintomas = sintomas;
    }

    public String getCodigoOms() {
        return codigoOms;
    }

    public void setCodigoOms(String codigoOms) {
        this.codigoOms = codigoOms;
    }

    @XmlTransient
    public List<AntecedentesFamiliares> getAntecedentesFamiliaresList() {
        return antecedentesFamiliaresList;
    }

    public void setAntecedentesFamiliaresList(List<AntecedentesFamiliares> antecedentesFamiliaresList) {
        this.antecedentesFamiliaresList = antecedentesFamiliaresList;
    }

    @XmlTransient
    public List<AntecedentesPersonales> getAntecedentesPersonalesList() {
        return antecedentesPersonalesList;
    }

    public void setAntecedentesPersonalesList(List<AntecedentesPersonales> antecedentesPersonalesList) {
        this.antecedentesPersonalesList = antecedentesPersonalesList;
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
        if (!(object instanceof Enfermedades)) {
            return false;
        }
        Enfermedades other = (Enfermedades) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "he1.entities.Enfermedades[ codigo=" + codigo + " ]";
    }
    
}
