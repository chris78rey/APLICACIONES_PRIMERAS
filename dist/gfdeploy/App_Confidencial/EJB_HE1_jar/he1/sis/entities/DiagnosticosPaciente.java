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
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author luis_guanoluiza
 */
@Entity
@Table(name = "DIAGNOSTICOS_PACIENTE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DiagnosticosPaciente.findAll", query = "SELECT d FROM DiagnosticosPaciente d"),
    @NamedQuery(name = "DiagnosticosPaciente.findByDgnpcnId", query = "SELECT d FROM DiagnosticosPaciente d WHERE d.dgnpcnId = :dgnpcnId"),
    @NamedQuery(name = "DiagnosticosPaciente.findByFechaInicio", query = "SELECT d FROM DiagnosticosPaciente d WHERE d.fechaInicio = :fechaInicio"),
    @NamedQuery(name = "DiagnosticosPaciente.findByTipo", query = "SELECT d FROM DiagnosticosPaciente d WHERE d.tipo = :tipo"),
    @NamedQuery(name = "DiagnosticosPaciente.findByDxGenerico", query = "SELECT d FROM DiagnosticosPaciente d WHERE d.dxGenerico = :dxGenerico"),
    @NamedQuery(name = "DiagnosticosPaciente.findByFechaFin", query = "SELECT d FROM DiagnosticosPaciente d WHERE d.fechaFin = :fechaFin"),
    @NamedQuery(name = "DiagnosticosPaciente.findByEstadoValidez", query = "SELECT d FROM DiagnosticosPaciente d WHERE d.estadoValidez = :estadoValidez"),
    @NamedQuery(name = "DiagnosticosPaciente.findByObservacion", query = "SELECT d FROM DiagnosticosPaciente d WHERE d.observacion = :observacion")})
public class DiagnosticosPaciente implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "DGNPCN_ID")
    private Long dgnpcnId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHA_INICIO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaInicio;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "TIPO")
    private String tipo;
    @Size(max = 255)
    @Column(name = "DX_GENERICO")
    private String dxGenerico;
    @Column(name = "FECHA_FIN")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaFin;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ESTADO_VALIDEZ")
    private Character estadoValidez;
    @Size(max = 240)
    @Column(name = "OBSERVACION")
    private String observacion;
    @JoinColumn(name = "PRS_CODIGO", referencedColumnName = "CODIGO")
    @ManyToOne(optional = false)
    private Personal personal;
    @JoinColumn(name = "PCN_NUMERO_HC", referencedColumnName = "NUMERO_HC")
    @ManyToOne(optional = false)
    private Pacientes pacientes;
    @JoinColumn(name = "MRF_CODIGO", referencedColumnName = "CODIGO")
    @ManyToOne
    private Morfologicos morfologicos;
    @JoinColumn(name = "ENF_CODIGO", referencedColumnName = "CODIGO")
    @ManyToOne(optional = false)
    private Enfermedades enfermedades;

    public DiagnosticosPaciente() {
    }

    public DiagnosticosPaciente(Long dgnpcnId) {
        this.dgnpcnId = dgnpcnId;
    }

    public DiagnosticosPaciente(Long dgnpcnId, Date fechaInicio, String tipo, Character estadoValidez) {
        this.dgnpcnId = dgnpcnId;
        this.fechaInicio = fechaInicio;
        this.tipo = tipo;
        this.estadoValidez = estadoValidez;
    }

    public Long getDgnpcnId() {
        return dgnpcnId;
    }

    public void setDgnpcnId(Long dgnpcnId) {
        this.dgnpcnId = dgnpcnId;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDxGenerico() {
        return dxGenerico;
    }

    public void setDxGenerico(String dxGenerico) {
        this.dxGenerico = dxGenerico;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public Character getEstadoValidez() {
        return estadoValidez;
    }

    public void setEstadoValidez(Character estadoValidez) {
        this.estadoValidez = estadoValidez;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public Personal getPersonal() {
        return personal;
    }

    public void setPersonal(Personal personal) {
        this.personal = personal;
    }

    public Pacientes getPacientes() {
        return pacientes;
    }

    public void setPacientes(Pacientes pacientes) {
        this.pacientes = pacientes;
    }

    public Morfologicos getMorfologicos() {
        return morfologicos;
    }

    public void setMorfologicos(Morfologicos morfologicos) {
        this.morfologicos = morfologicos;
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
        hash += (dgnpcnId != null ? dgnpcnId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DiagnosticosPaciente)) {
            return false;
        }
        DiagnosticosPaciente other = (DiagnosticosPaciente) object;
        if ((this.dgnpcnId == null && other.dgnpcnId != null) || (this.dgnpcnId != null && !this.dgnpcnId.equals(other.dgnpcnId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "he1.entities.DiagnosticosPaciente[ dgnpcnId=" + dgnpcnId + " ]";
    }
    
}
