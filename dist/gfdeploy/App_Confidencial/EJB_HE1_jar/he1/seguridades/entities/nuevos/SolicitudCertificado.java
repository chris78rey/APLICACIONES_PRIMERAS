/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package he1.seguridades.entities.nuevos;

import java.io.Serializable;
import java.math.BigDecimal;
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
 * @author christian_ruiz
 */
@Entity
@Table(name = "SOLICITUD_CERTIFICADO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SolicitudCertificado.findAll", query = "SELECT s FROM SolicitudCertificado s"),
    @NamedQuery(name = "SolicitudCertificado.findById", query = "SELECT s FROM SolicitudCertificado s WHERE s.id = :id"),
    @NamedQuery(name = "SolicitudCertificado.findBySlcFechaSolicitud", query = "SELECT s FROM SolicitudCertificado s WHERE s.slcFechaSolicitud = :slcFechaSolicitud"),
    @NamedQuery(name = "SolicitudCertificado.findBySlcObservacion", query = "SELECT s FROM SolicitudCertificado s WHERE s.slcObservacion = :slcObservacion")})
public class SolicitudCertificado implements Serializable {

    @Column(name = "SLC_PENDIENTE")
    private Character slcPendiente;
    @JoinColumn(name = "TSO_ID", referencedColumnName = "ID")
    @ManyToOne
    private TipoSolicitud tipoSolicitud;
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Column(name = "SLC_FECHA_SOLICITUD")
    @Temporal(TemporalType.TIMESTAMP)
    private Date slcFechaSolicitud;
    @Size(max = 4000)
    @Column(name = "SLC_OBSERVACION")
    private String slcObservacion;
    @JoinColumn(name = "PRN_ID_PERSONAL", referencedColumnName = "PRN_IDPERSONAL")
    @ManyToOne
    private PersonalNomina personalNomina;

    @Size(max = 25)
    @Column(name = "CEDULA")
    private String cedula;

    public SolicitudCertificado() {
    }

    public SolicitudCertificado(BigDecimal id) {
        this.id = id;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public Date getSlcFechaSolicitud() {
        return slcFechaSolicitud;
    }

    public void setSlcFechaSolicitud(Date slcFechaSolicitud) {
        this.slcFechaSolicitud = slcFechaSolicitud;
    }

    public String getSlcObservacion() {
        return slcObservacion;
    }

    public void setSlcObservacion(String slcObservacion) {
        this.slcObservacion = slcObservacion;
    }

    public PersonalNomina getPersonalNomina() {
        return personalNomina;
    }

    public void setPersonalNomina(PersonalNomina personalNomina) {
        this.personalNomina = personalNomina;
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
        if (!(object instanceof SolicitudCertificado)) {
            return false;
        }
        SolicitudCertificado other = (SolicitudCertificado) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.SolicitudCertificado[ id=" + id + " ]";
    }

    public TipoSolicitud getTipoSolicitud() {
        return tipoSolicitud;
    }

    public void setTipoSolicitud(TipoSolicitud tipoSolicitud) {
        this.tipoSolicitud = tipoSolicitud;
    }

    /**
     * @return the slcPendiente
     */
    public Character getSlcPendiente() {
        return slcPendiente;
    }

    /**
     * @param slcPendiente the slcPendiente to set
     */
    public void setSlcPendiente(Character slcPendiente) {
        this.slcPendiente = slcPendiente;
    }

    /**
     * @return the cedula
     */
    public String getCedula() {
        return cedula;
    }

    /**
     * @param cedula the cedula to set
     */
    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

}
