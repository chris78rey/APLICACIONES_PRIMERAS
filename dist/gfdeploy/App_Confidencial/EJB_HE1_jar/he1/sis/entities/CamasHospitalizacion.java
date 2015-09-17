/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package he1.sis.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author luis_guanoluiza
 */
@Entity
@Table(name = "CAMAS_HOSPITALIZACION")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CamasHospitalizacion.findAll", query = "SELECT c FROM CamasHospitalizacion c"),
    @NamedQuery(name = "CamasHospitalizacion.findBySala", query = "SELECT c FROM CamasHospitalizacion c WHERE c.camasHospitalizacionPK.sala = :sala"),
    @NamedQuery(name = "CamasHospitalizacion.findByCama", query = "SELECT c FROM CamasHospitalizacion c WHERE c.camasHospitalizacionPK.cama = :cama"),
    @NamedQuery(name = "CamasHospitalizacion.findByServicio", query = "SELECT c FROM CamasHospitalizacion c WHERE c.servicio = :servicio"),
    @NamedQuery(name = "CamasHospitalizacion.findByEstadoDeDisponibilidad", query = "SELECT c FROM CamasHospitalizacion c WHERE c.estadoDeDisponibilidad = :estadoDeDisponibilidad"),
    @NamedQuery(name = "CamasHospitalizacion.findByCrgTipo", query = "SELECT c FROM CamasHospitalizacion c WHERE c.crgTipo = :crgTipo"),
    @NamedQuery(name = "CamasHospitalizacion.findByCaracteristicas", query = "SELECT c FROM CamasHospitalizacion c WHERE c.caracteristicas = :caracteristicas"),
    @NamedQuery(name = "CamasHospitalizacion.findByFechaActualiza", query = "SELECT c FROM CamasHospitalizacion c WHERE c.fechaActualiza = :fechaActualiza")})
public class CamasHospitalizacion implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CamasHospitalizacionPK camasHospitalizacionPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "SERVICIO")
    private String servicio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ESTADO_DE_DISPONIBILIDAD")
    private Character estadoDeDisponibilidad;
    @Column(name = "CRG_TIPO")
    private Character crgTipo;
    @Size(max = 240)
    @Column(name = "CARACTERISTICAS")
    private String caracteristicas;
    @Column(name = "FECHA_ACTUALIZA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaActualiza;
    @JoinColumn(name = "PRS_CODIGO", referencedColumnName = "CODIGO")
    @ManyToOne
    private Personal personal;
    @JoinColumn(name = "CRG_CODIGO", referencedColumnName = "CODIGO")
    @ManyToOne
    private AgrupadoresDeCargos agrupadoresDeCargos;
    @JoinColumn(name = "AGRCRG_CODIGO", referencedColumnName = "CODIGO")
    @ManyToOne
    private AgrupadoresDeCargos agrupadoresDeCargos1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "camasHospitalizacion")
    private List<TurnosCamas> turnosCamasList;

    public CamasHospitalizacion() {
    }

    public CamasHospitalizacion(CamasHospitalizacionPK camasHospitalizacionPK) {
        this.camasHospitalizacionPK = camasHospitalizacionPK;
    }

    public CamasHospitalizacion(CamasHospitalizacionPK camasHospitalizacionPK, String servicio, Character estadoDeDisponibilidad) {
        this.camasHospitalizacionPK = camasHospitalizacionPK;
        this.servicio = servicio;
        this.estadoDeDisponibilidad = estadoDeDisponibilidad;
    }

    public CamasHospitalizacion(short sala, String cama) {
        this.camasHospitalizacionPK = new CamasHospitalizacionPK(sala, cama);
    }

    public CamasHospitalizacionPK getCamasHospitalizacionPK() {
        return camasHospitalizacionPK;
    }

    public void setCamasHospitalizacionPK(CamasHospitalizacionPK camasHospitalizacionPK) {
        this.camasHospitalizacionPK = camasHospitalizacionPK;
    }

    public String getServicio() {
        return servicio;
    }

    public void setServicio(String servicio) {
        this.servicio = servicio;
    }

    public Character getEstadoDeDisponibilidad() {
        return estadoDeDisponibilidad;
    }

    public void setEstadoDeDisponibilidad(Character estadoDeDisponibilidad) {
        this.estadoDeDisponibilidad = estadoDeDisponibilidad;
    }

    public Character getCrgTipo() {
        return crgTipo;
    }

    public void setCrgTipo(Character crgTipo) {
        this.crgTipo = crgTipo;
    }

    public String getCaracteristicas() {
        return caracteristicas;
    }

    public void setCaracteristicas(String caracteristicas) {
        this.caracteristicas = caracteristicas;
    }

    public Date getFechaActualiza() {
        return fechaActualiza;
    }

    public void setFechaActualiza(Date fechaActualiza) {
        this.fechaActualiza = fechaActualiza;
    }

    public Personal getPersonal() {
        return personal;
    }

    public void setPersonal(Personal personal) {
        this.personal = personal;
    }

    public AgrupadoresDeCargos getAgrupadoresDeCargos() {
        return agrupadoresDeCargos;
    }

    public void setAgrupadoresDeCargos(AgrupadoresDeCargos agrupadoresDeCargos) {
        this.agrupadoresDeCargos = agrupadoresDeCargos;
    }

    public AgrupadoresDeCargos getAgrupadoresDeCargos1() {
        return agrupadoresDeCargos1;
    }

    public void setAgrupadoresDeCargos1(AgrupadoresDeCargos agrupadoresDeCargos1) {
        this.agrupadoresDeCargos1 = agrupadoresDeCargos1;
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
        hash += (camasHospitalizacionPK != null ? camasHospitalizacionPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CamasHospitalizacion)) {
            return false;
        }
        CamasHospitalizacion other = (CamasHospitalizacion) object;
        if ((this.camasHospitalizacionPK == null && other.camasHospitalizacionPK != null) || (this.camasHospitalizacionPK != null && !this.camasHospitalizacionPK.equals(other.camasHospitalizacionPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "he1.sis.entities.CamasHospitalizacion[ camasHospitalizacionPK=" + camasHospitalizacionPK + " ]";
    }
    
}
