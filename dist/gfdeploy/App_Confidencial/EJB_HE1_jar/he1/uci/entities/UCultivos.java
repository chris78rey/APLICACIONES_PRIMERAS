/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package he1.uci.entities;

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
 * @author luis_guanoluiza
 */
@Entity
@Table(name = "U_CULTIVOS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UCultivos.findAll", query = "SELECT u FROM UCultivos u"),
    @NamedQuery(name = "UCultivos.findByCulId", query = "SELECT u FROM UCultivos u WHERE u.culId = :culId"),
    @NamedQuery(name = "UCultivos.findByCulFecha", query = "SELECT u FROM UCultivos u WHERE u.culFecha = :culFecha"),
    @NamedQuery(name = "UCultivos.findByCulAm", query = "SELECT u FROM UCultivos u WHERE u.culAm = :culAm"),
    @NamedQuery(name = "UCultivos.findByCulPm", query = "SELECT u FROM UCultivos u WHERE u.culPm = :culPm"),
    @NamedQuery(name = "UCultivos.findByCulHs", query = "SELECT u FROM UCultivos u WHERE u.culHs = :culHs"),
    @NamedQuery(name = "UCultivos.findByCulGermen", query = "SELECT u FROM UCultivos u WHERE u.culGermen = :culGermen"),
    @NamedQuery(name = "UCultivos.findByCulSensibilidad", query = "SELECT u FROM UCultivos u WHERE u.culSensibilidad = :culSensibilidad")})
public class UCultivos implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "CUL_ID")
    private BigDecimal culId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CUL_FECHA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date culFecha;
    @Size(max = 50)
    @Column(name = "CUL_AM")
    private String culAm;
    @Size(max = 50)
    @Column(name = "CUL_PM")
    private String culPm;
    @Size(max = 50)
    @Column(name = "CUL_HS")
    private String culHs;
    @Size(max = 200)
    @Column(name = "CUL_GERMEN")
    private String culGermen;
    @Size(max = 200)
    @Column(name = "CUL_SENSIBILIDAD")
    private String culSensibilidad;
    @JoinColumn(name = "OPP_ID", referencedColumnName = "OPP_ID")
    @ManyToOne(optional = false)
    private UOpcionPaciente uOpcionPaciente;
    @JoinColumn(name = "OPC_ID", referencedColumnName = "OPC_ID")
    @ManyToOne(optional = false)
    private UOpciones uOpciones;

    public UCultivos() {
    }

    public UCultivos(BigDecimal culId) {
        this.culId = culId;
    }

    public UCultivos(BigDecimal culId, Date culFecha) {
        this.culId = culId;
        this.culFecha = culFecha;
    }

    public BigDecimal getCulId() {
        return culId;
    }

    public void setCulId(BigDecimal culId) {
        this.culId = culId;
    }

    public Date getCulFecha() {
        return culFecha;
    }

    public void setCulFecha(Date culFecha) {
        this.culFecha = culFecha;
    }

    public String getCulAm() {
        return culAm;
    }

    public void setCulAm(String culAm) {
        this.culAm = culAm;
    }

    public String getCulPm() {
        return culPm;
    }

    public void setCulPm(String culPm) {
        this.culPm = culPm;
    }

    public String getCulHs() {
        return culHs;
    }

    public void setCulHs(String culHs) {
        this.culHs = culHs;
    }

    public String getCulGermen() {
        return culGermen;
    }

    public void setCulGermen(String culGermen) {
        this.culGermen = culGermen;
    }

    public String getCulSensibilidad() {
        return culSensibilidad;
    }

    public void setCulSensibilidad(String culSensibilidad) {
        this.culSensibilidad = culSensibilidad;
    }

    public UOpcionPaciente getUOpcionPaciente() {
        return uOpcionPaciente;
    }

    public void setUOpcionPaciente(UOpcionPaciente uOpcionPaciente) {
        this.uOpcionPaciente = uOpcionPaciente;
    }

    public UOpciones getUOpciones() {
        return uOpciones;
    }

    public void setUOpciones(UOpciones uOpciones) {
        this.uOpciones = uOpciones;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (culId != null ? culId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UCultivos)) {
            return false;
        }
        UCultivos other = (UCultivos) object;
        if ((this.culId == null && other.culId != null) || (this.culId != null && !this.culId.equals(other.culId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "he1.uci.entidades.UCultivos[ culId=" + culId + " ]";
    }
    
}
