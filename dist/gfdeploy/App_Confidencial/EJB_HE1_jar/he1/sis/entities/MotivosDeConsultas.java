/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package he1.sis.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author luis_guanoluiza
 */
@Entity
@Table(name = "MOTIVOS_DE_CONSULTAS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MotivosDeConsultas.findAll", query = "SELECT m FROM MotivosDeConsultas m"),
    @NamedQuery(name = "MotivosDeConsultas.findByPcnNumeroHc", query = "SELECT m FROM MotivosDeConsultas m WHERE m.motivosDeConsultasPK.pcnNumeroHc = :pcnNumeroHc"),
    @NamedQuery(name = "MotivosDeConsultas.findByFecha", query = "SELECT m FROM MotivosDeConsultas m WHERE m.motivosDeConsultasPK.fecha = :fecha"),
    @NamedQuery(name = "MotivosDeConsultas.findByMotivo", query = "SELECT m FROM MotivosDeConsultas m WHERE m.motivo = :motivo"),
    @NamedQuery(name = "MotivosDeConsultas.findByEnfermedad", query = "SELECT m FROM MotivosDeConsultas m WHERE m.enfermedad = :enfermedad"),
    @NamedQuery(name = "MotivosDeConsultas.findByPlanTratamiento", query = "SELECT m FROM MotivosDeConsultas m WHERE m.planTratamiento = :planTratamiento")})
public class MotivosDeConsultas implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected MotivosDeConsultasPK motivosDeConsultasPK;
    @Size(max = 2000)
    @Column(name = "MOTIVO")
    private String motivo;
    @Size(max = 2000)
    @Column(name = "ENFERMEDAD")
    private String enfermedad;
    @Size(max = 2000)
    @Column(name = "PLAN_TRATAMIENTO")
    private String planTratamiento;
    @JoinColumn(name = "PCN_NUMERO_HC", referencedColumnName = "NUMERO_HC", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Pacientes pacientes;
    @JoinColumn(name = "HJAEVL_NUMERO", referencedColumnName = "NUMERO")
    @ManyToOne
    private HojasDeEvolucion hojasDeEvolucion;

    public MotivosDeConsultas() {
    }

    public MotivosDeConsultas(MotivosDeConsultasPK motivosDeConsultasPK) {
        this.motivosDeConsultasPK = motivosDeConsultasPK;
    }

    public MotivosDeConsultas(int pcnNumeroHc, Date fecha) {
        this.motivosDeConsultasPK = new MotivosDeConsultasPK(pcnNumeroHc, fecha);
    }

    public MotivosDeConsultasPK getMotivosDeConsultasPK() {
        return motivosDeConsultasPK;
    }

    public void setMotivosDeConsultasPK(MotivosDeConsultasPK motivosDeConsultasPK) {
        this.motivosDeConsultasPK = motivosDeConsultasPK;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public String getEnfermedad() {
        return enfermedad;
    }

    public void setEnfermedad(String enfermedad) {
        this.enfermedad = enfermedad;
    }

    public String getPlanTratamiento() {
        return planTratamiento;
    }

    public void setPlanTratamiento(String planTratamiento) {
        this.planTratamiento = planTratamiento;
    }

    public Pacientes getPacientes() {
        return pacientes;
    }

    public void setPacientes(Pacientes pacientes) {
        this.pacientes = pacientes;
    }

    public HojasDeEvolucion getHojasDeEvolucion() {
        return hojasDeEvolucion;
    }

    public void setHojasDeEvolucion(HojasDeEvolucion hojasDeEvolucion) {
        this.hojasDeEvolucion = hojasDeEvolucion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (motivosDeConsultasPK != null ? motivosDeConsultasPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MotivosDeConsultas)) {
            return false;
        }
        MotivosDeConsultas other = (MotivosDeConsultas) object;
        if ((this.motivosDeConsultasPK == null && other.motivosDeConsultasPK != null) || (this.motivosDeConsultasPK != null && !this.motivosDeConsultasPK.equals(other.motivosDeConsultasPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "he1.entities.MotivosDeConsultas[ motivosDeConsultasPK=" + motivosDeConsultasPK + " ]";
    }
    
}
