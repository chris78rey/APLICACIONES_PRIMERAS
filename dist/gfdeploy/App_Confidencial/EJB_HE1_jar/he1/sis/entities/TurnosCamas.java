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
import javax.persistence.JoinColumns;
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
@Table(name = "TURNOS_CAMAS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TurnosCamas.findAll", query = "SELECT t FROM TurnosCamas t"),
    @NamedQuery(name = "TurnosCamas.findByFecha", query = "SELECT t FROM TurnosCamas t WHERE t.turnosCamasPK.fecha = :fecha"),
    @NamedQuery(name = "TurnosCamas.findByOcupada", query = "SELECT t FROM TurnosCamas t WHERE t.turnosCamasPK.ocupada = :ocupada"),
    @NamedQuery(name = "TurnosCamas.findByCmahspSala", query = "SELECT t FROM TurnosCamas t WHERE t.turnosCamasPK.cmahspSala = :cmahspSala"),
    @NamedQuery(name = "TurnosCamas.findByCmahspCama", query = "SELECT t FROM TurnosCamas t WHERE t.turnosCamasPK.cmahspCama = :cmahspCama"),
    @NamedQuery(name = "TurnosCamas.findByPrmNumero", query = "SELECT t FROM TurnosCamas t WHERE t.turnosCamasPK.prmNumero = :prmNumero"),
    @NamedQuery(name = "TurnosCamas.findByPrmPcnNumeroHc", query = "SELECT t FROM TurnosCamas t WHERE t.turnosCamasPK.prmPcnNumeroHc = :prmPcnNumeroHc"),
    @NamedQuery(name = "TurnosCamas.findByEncargado", query = "SELECT t FROM TurnosCamas t WHERE t.encargado = :encargado"),
    @NamedQuery(name = "TurnosCamas.findByCondicion", query = "SELECT t FROM TurnosCamas t WHERE t.condicion = :condicion"),
    @NamedQuery(name = "TurnosCamas.findByNumeroAlta", query = "SELECT t FROM TurnosCamas t WHERE t.numeroAlta = :numeroAlta"),
    @NamedQuery(name = "TurnosCamas.findByPrealta", query = "SELECT t FROM TurnosCamas t WHERE t.prealta = :prealta")})
public class TurnosCamas implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected TurnosCamasPK turnosCamasPK;
    @Size(max = 3)
    @Column(name = "ENCARGADO")
    private String encargado;
    @Size(max = 3)
    @Column(name = "CONDICION")
    private String condicion;
    @Column(name = "NUMERO_ALTA")
    private Short numeroAlta;
    @Column(name = "PREALTA")
    private Character prealta;
    @JoinColumns({
        @JoinColumn(name = "PRM_NUMERO", referencedColumnName = "NUMERO", insertable = false, updatable = false),
        @JoinColumn(name = "PRM_PCN_NUMERO_HC", referencedColumnName = "PCN_NUMERO_HC", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private PermanenciasYAtenciones permanenciasYAtenciones;
    @JoinColumn(name = "ESPECIALIDAD", referencedColumnName = "CODIGO")
    @ManyToOne
    private Especialidades especialidades;
    @JoinColumns({
        @JoinColumn(name = "CMAHSP_SALA", referencedColumnName = "SALA", insertable = false, updatable = false),
        @JoinColumn(name = "CMAHSP_CAMA", referencedColumnName = "CAMA", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private CamasHospitalizacion camasHospitalizacion;

    public TurnosCamas() {
    }

    public TurnosCamas(TurnosCamasPK turnosCamasPK) {
        this.turnosCamasPK = turnosCamasPK;
    }

    public TurnosCamas(Date fecha, Character ocupada, short cmahspSala, String cmahspCama, int prmNumero, int prmPcnNumeroHc) {
        this.turnosCamasPK = new TurnosCamasPK(fecha, ocupada, cmahspSala, cmahspCama, prmNumero, prmPcnNumeroHc);
    }

    public TurnosCamasPK getTurnosCamasPK() {
        return turnosCamasPK;
    }

    public void setTurnosCamasPK(TurnosCamasPK turnosCamasPK) {
        this.turnosCamasPK = turnosCamasPK;
    }

    public String getEncargado() {
        return encargado;
    }

    public void setEncargado(String encargado) {
        this.encargado = encargado;
    }

    public String getCondicion() {
        return condicion;
    }

    public void setCondicion(String condicion) {
        this.condicion = condicion;
    }

    public Short getNumeroAlta() {
        return numeroAlta;
    }

    public void setNumeroAlta(Short numeroAlta) {
        this.numeroAlta = numeroAlta;
    }

    public Character getPrealta() {
        return prealta;
    }

    public void setPrealta(Character prealta) {
        this.prealta = prealta;
    }

    public PermanenciasYAtenciones getPermanenciasYAtenciones() {
        return permanenciasYAtenciones;
    }

    public void setPermanenciasYAtenciones(PermanenciasYAtenciones permanenciasYAtenciones) {
        this.permanenciasYAtenciones = permanenciasYAtenciones;
    }

    public Especialidades getEspecialidades() {
        return especialidades;
    }

    public void setEspecialidades(Especialidades especialidades) {
        this.especialidades = especialidades;
    }

    public CamasHospitalizacion getCamasHospitalizacion() {
        return camasHospitalizacion;
    }

    public void setCamasHospitalizacion(CamasHospitalizacion camasHospitalizacion) {
        this.camasHospitalizacion = camasHospitalizacion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (turnosCamasPK != null ? turnosCamasPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TurnosCamas)) {
            return false;
        }
        TurnosCamas other = (TurnosCamas) object;
        if ((this.turnosCamasPK == null && other.turnosCamasPK != null) || (this.turnosCamasPK != null && !this.turnosCamasPK.equals(other.turnosCamasPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "he1.sis.entities.TurnosCamas[ turnosCamasPK=" + turnosCamasPK + " ]";
    }
    
}
