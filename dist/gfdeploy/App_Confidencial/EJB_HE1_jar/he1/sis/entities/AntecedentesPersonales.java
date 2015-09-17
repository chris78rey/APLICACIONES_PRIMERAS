/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package he1.sis.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
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
@Table(name = "ANTECEDENTES_PERSONALES")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AntecedentesPersonales.findAll", query = "SELECT a FROM AntecedentesPersonales a"),
    @NamedQuery(name = "AntecedentesPersonales.findByPcnNumeroHc", query = "SELECT a FROM AntecedentesPersonales a WHERE a.antecedentesPersonalesPK.pcnNumeroHc = :pcnNumeroHc"),
    @NamedQuery(name = "AntecedentesPersonales.findByTpoantprsId", query = "SELECT a FROM AntecedentesPersonales a WHERE a.antecedentesPersonalesPK.tpoantprsId = :tpoantprsId"),
    @NamedQuery(name = "AntecedentesPersonales.findByCondicion", query = "SELECT a FROM AntecedentesPersonales a WHERE a.condicion = :condicion"),
    @NamedQuery(name = "AntecedentesPersonales.findByFecha", query = "SELECT a FROM AntecedentesPersonales a WHERE a.antecedentesPersonalesPK.fecha = :fecha"),
    @NamedQuery(name = "AntecedentesPersonales.findByEdad", query = "SELECT a FROM AntecedentesPersonales a WHERE a.edad = :edad"),
    @NamedQuery(name = "AntecedentesPersonales.findByObservaciones", query = "SELECT a FROM AntecedentesPersonales a WHERE a.observaciones = :observaciones")})
public class AntecedentesPersonales implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected AntecedentesPersonalesPK antecedentesPersonalesPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "CONDICION")
    private String condicion;
    @Column(name = "EDAD")
    private Short edad;
    @Size(max = 240)
    @Column(name = "OBSERVACIONES")
    private String observaciones;
    @JoinColumn(name = "TPOANTPRS_ID", referencedColumnName = "ID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private TiposAntecedentesPersonales tiposAntecedentesPersonales;
    @JoinColumn(name = "PCN_NUMERO_HC", referencedColumnName = "NUMERO_HC", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Pacientes pacientes;
    @JoinColumn(name = "ENF_CODIGO", referencedColumnName = "CODIGO")
    @ManyToOne
    private Enfermedades enfermedades;

    public AntecedentesPersonales() {
    }

    public AntecedentesPersonales(AntecedentesPersonalesPK antecedentesPersonalesPK) {
        this.antecedentesPersonalesPK = antecedentesPersonalesPK;
    }

    public AntecedentesPersonales(AntecedentesPersonalesPK antecedentesPersonalesPK, String condicion) {
        this.antecedentesPersonalesPK = antecedentesPersonalesPK;
        this.condicion = condicion;
    }

    public AntecedentesPersonales(int pcnNumeroHc, int tpoantprsId, Date fecha) {
        this.antecedentesPersonalesPK = new AntecedentesPersonalesPK(pcnNumeroHc, tpoantprsId, fecha);
    }

    public AntecedentesPersonalesPK getAntecedentesPersonalesPK() {
        return antecedentesPersonalesPK;
    }

    public void setAntecedentesPersonalesPK(AntecedentesPersonalesPK antecedentesPersonalesPK) {
        this.antecedentesPersonalesPK = antecedentesPersonalesPK;
    }

    public String getCondicion() {
        return condicion;
    }

    public void setCondicion(String condicion) {
        this.condicion = condicion;
    }

    public Short getEdad() {
        return edad;
    }

    public void setEdad(Short edad) {
        this.edad = edad;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public TiposAntecedentesPersonales getTiposAntecedentesPersonales() {
        return tiposAntecedentesPersonales;
    }

    public void setTiposAntecedentesPersonales(TiposAntecedentesPersonales tiposAntecedentesPersonales) {
        this.tiposAntecedentesPersonales = tiposAntecedentesPersonales;
    }

    public Pacientes getPacientes() {
        return pacientes;
    }

    public void setPacientes(Pacientes pacientes) {
        this.pacientes = pacientes;
    }

    public Enfermedades getEnfermedades() {
        return enfermedades;
    }

    public void setEnfermedades(Enfermedades enfermedades) {
        this.enfermedades = enfermedades;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (antecedentesPersonalesPK != null ? antecedentesPersonalesPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AntecedentesPersonales)) {
            return false;
        }
        AntecedentesPersonales other = (AntecedentesPersonales) object;
        if ((this.antecedentesPersonalesPK == null && other.antecedentesPersonalesPK != null) || (this.antecedentesPersonalesPK != null && !this.antecedentesPersonalesPK.equals(other.antecedentesPersonalesPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "he1.entities.AntecedentesPersonales[ antecedentesPersonalesPK=" + antecedentesPersonalesPK + " ]";
    }
    
}
