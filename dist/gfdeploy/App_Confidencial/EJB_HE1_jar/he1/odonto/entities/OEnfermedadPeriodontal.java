/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package he1.odonto.entities;

import he1.sis.entities.HojasDeEvolucion;
import he1.sis.entities.Pacientes;
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
@Table(name = "O_ENFERMEDAD_PERIODONTAL")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OEnfermedadPeriodontal.findAll", query = "SELECT o FROM OEnfermedadPeriodontal o"),
    @NamedQuery(name = "OEnfermedadPeriodontal.findByEpeId", query = "SELECT o FROM OEnfermedadPeriodontal o WHERE o.epeId = :epeId"),
    @NamedQuery(name = "OEnfermedadPeriodontal.findByEpeClasificacion", query = "SELECT o FROM OEnfermedadPeriodontal o WHERE o.epeClasificacion = :epeClasificacion"),
    @NamedQuery(name = "OEnfermedadPeriodontal.findByEpeFecha", query = "SELECT o FROM OEnfermedadPeriodontal o WHERE o.epeFecha = :epeFecha")})
public class OEnfermedadPeriodontal implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "EPE_ID")
    private BigDecimal epeId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "EPE_CLASIFICACION")
    private String epeClasificacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "EPE_FECHA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date epeFecha;
    @JoinColumn(name = "PCN_NUMERO_HC", referencedColumnName = "NUMERO_HC")
    @ManyToOne
    private Pacientes pacientes;
    @JoinColumn(name = "HJAEVL_NUMERO", referencedColumnName = "NUMERO")
    @ManyToOne
    private HojasDeEvolucion hojasDeEvolucion;

    public OEnfermedadPeriodontal() {
    }

    public OEnfermedadPeriodontal(BigDecimal epeId) {
        this.epeId = epeId;
    }

    public OEnfermedadPeriodontal(BigDecimal epeId, String epeClasificacion, Date epeFecha) {
        this.epeId = epeId;
        this.epeClasificacion = epeClasificacion;
        this.epeFecha = epeFecha;
    }

    public BigDecimal getEpeId() {
        return epeId;
    }

    public void setEpeId(BigDecimal epeId) {
        this.epeId = epeId;
    }

    public String getEpeClasificacion() {
        return epeClasificacion;
    }

    public void setEpeClasificacion(String epeClasificacion) {
        this.epeClasificacion = epeClasificacion;
    }

    public Date getEpeFecha() {
        return epeFecha;
    }

    public void setEpeFecha(Date epeFecha) {
        this.epeFecha = epeFecha;
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
        hash += (epeId != null ? epeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OEnfermedadPeriodontal)) {
            return false;
        }
        OEnfermedadPeriodontal other = (OEnfermedadPeriodontal) object;
        if ((this.epeId == null && other.epeId != null) || (this.epeId != null && !this.epeId.equals(other.epeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "he1.entities.OEnfermedadPeriodontal[ epeId=" + epeId + " ]";
    }
    
}
