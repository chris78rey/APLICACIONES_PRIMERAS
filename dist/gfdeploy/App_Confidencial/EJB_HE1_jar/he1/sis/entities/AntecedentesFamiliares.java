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
@Table(name = "ANTECEDENTES_FAMILIARES")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AntecedentesFamiliares.findAll", query = "SELECT a FROM AntecedentesFamiliares a"),
    @NamedQuery(name = "AntecedentesFamiliares.findByTpoantfmlId", query = "SELECT a FROM AntecedentesFamiliares a WHERE a.antecedentesFamiliaresPK.tpoantfmlId = :tpoantfmlId"),
    @NamedQuery(name = "AntecedentesFamiliares.findByParentezco", query = "SELECT a FROM AntecedentesFamiliares a WHERE a.parentezco = :parentezco"),
    @NamedQuery(name = "AntecedentesFamiliares.findByEstado", query = "SELECT a FROM AntecedentesFamiliares a WHERE a.estado = :estado"),
    @NamedQuery(name = "AntecedentesFamiliares.findByFecha", query = "SELECT a FROM AntecedentesFamiliares a WHERE a.antecedentesFamiliaresPK.fecha = :fecha"),
    @NamedQuery(name = "AntecedentesFamiliares.findByEdad", query = "SELECT a FROM AntecedentesFamiliares a WHERE a.edad = :edad"),
    @NamedQuery(name = "AntecedentesFamiliares.findByObservaciones", query = "SELECT a FROM AntecedentesFamiliares a WHERE a.observaciones = :observaciones"),
    @NamedQuery(name = "AntecedentesFamiliares.findByPcnNumeroHc", query = "SELECT a FROM AntecedentesFamiliares a WHERE a.antecedentesFamiliaresPK.pcnNumeroHc = :pcnNumeroHc")})
public class AntecedentesFamiliares implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected AntecedentesFamiliaresPK antecedentesFamiliaresPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "PARENTEZCO")
    private String parentezco;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "ESTADO")
    private String estado;
    @Column(name = "EDAD")
    private Short edad;
    @Size(max = 240)
    @Column(name = "OBSERVACIONES")
    private String observaciones;
    @JoinColumn(name = "TPOANTFML_ID", referencedColumnName = "ID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private TiposAntecedentesFamiliares tiposAntecedentesFamiliares;
    @JoinColumn(name = "PCN_NUMERO_HC", referencedColumnName = "NUMERO_HC", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Pacientes pacientes;
    @JoinColumn(name = "ENF_CODIGO", referencedColumnName = "CODIGO")
    @ManyToOne
    private Enfermedades enfermedades;

    public AntecedentesFamiliares() {
    }

    public AntecedentesFamiliares(AntecedentesFamiliaresPK antecedentesFamiliaresPK) {
        this.antecedentesFamiliaresPK = antecedentesFamiliaresPK;
    }

    public AntecedentesFamiliares(AntecedentesFamiliaresPK antecedentesFamiliaresPK, String parentezco, String estado) {
        this.antecedentesFamiliaresPK = antecedentesFamiliaresPK;
        this.parentezco = parentezco;
        this.estado = estado;
    }

    public AntecedentesFamiliares(int tpoantfmlId, Date fecha, int pcnNumeroHc) {
        this.antecedentesFamiliaresPK = new AntecedentesFamiliaresPK(tpoantfmlId, fecha, pcnNumeroHc);
    }

    public AntecedentesFamiliaresPK getAntecedentesFamiliaresPK() {
        return antecedentesFamiliaresPK;
    }

    public void setAntecedentesFamiliaresPK(AntecedentesFamiliaresPK antecedentesFamiliaresPK) {
        this.antecedentesFamiliaresPK = antecedentesFamiliaresPK;
    }

    public String getParentezco() {
        return parentezco;
    }

    public void setParentezco(String parentezco) {
        this.parentezco = parentezco;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
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

    public TiposAntecedentesFamiliares getTiposAntecedentesFamiliares() {
        return tiposAntecedentesFamiliares;
    }

    public void setTiposAntecedentesFamiliares(TiposAntecedentesFamiliares tiposAntecedentesFamiliares) {
        this.tiposAntecedentesFamiliares = tiposAntecedentesFamiliares;
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
        hash += (antecedentesFamiliaresPK != null ? antecedentesFamiliaresPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AntecedentesFamiliares)) {
            return false;
        }
        AntecedentesFamiliares other = (AntecedentesFamiliares) object;
        if ((this.antecedentesFamiliaresPK == null && other.antecedentesFamiliaresPK != null) || (this.antecedentesFamiliaresPK != null && !this.antecedentesFamiliaresPK.equals(other.antecedentesFamiliaresPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "he1.entities.AntecedentesFamiliares[ antecedentesFamiliaresPK=" + antecedentesFamiliaresPK + " ]";
    }
    
}
