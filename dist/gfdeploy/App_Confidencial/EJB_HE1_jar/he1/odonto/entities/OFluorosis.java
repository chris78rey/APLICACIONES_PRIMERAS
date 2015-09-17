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
@Table(name = "O_FLUOROSIS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OFluorosis.findAll", query = "SELECT o FROM OFluorosis o"),
    @NamedQuery(name = "OFluorosis.findByFluId", query = "SELECT o FROM OFluorosis o WHERE o.fluId = :fluId"),
    @NamedQuery(name = "OFluorosis.findByFluClasificacion", query = "SELECT o FROM OFluorosis o WHERE o.fluClasificacion = :fluClasificacion"),
    @NamedQuery(name = "OFluorosis.findByFluFecha", query = "SELECT o FROM OFluorosis o WHERE o.fluFecha = :fluFecha")})
public class OFluorosis implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "FLU_ID")
    private BigDecimal fluId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "FLU_CLASIFICACION")
    private String fluClasificacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FLU_FECHA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fluFecha;
    @JoinColumn(name = "PCN_NUMERO_HC", referencedColumnName = "NUMERO_HC")
    @ManyToOne
    private Pacientes pacientes;
    @JoinColumn(name = "HJAEVL_NUMERO", referencedColumnName = "NUMERO")
    @ManyToOne
    private HojasDeEvolucion hojasDeEvolucion;

    public OFluorosis() {
    }

    public OFluorosis(BigDecimal fluId) {
        this.fluId = fluId;
    }

    public OFluorosis(BigDecimal fluId, String fluClasificacion, Date fluFecha) {
        this.fluId = fluId;
        this.fluClasificacion = fluClasificacion;
        this.fluFecha = fluFecha;
    }

    public BigDecimal getFluId() {
        return fluId;
    }

    public void setFluId(BigDecimal fluId) {
        this.fluId = fluId;
    }

    public String getFluClasificacion() {
        return fluClasificacion;
    }

    public void setFluClasificacion(String fluClasificacion) {
        this.fluClasificacion = fluClasificacion;
    }

    public Date getFluFecha() {
        return fluFecha;
    }

    public void setFluFecha(Date fluFecha) {
        this.fluFecha = fluFecha;
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
        hash += (fluId != null ? fluId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OFluorosis)) {
            return false;
        }
        OFluorosis other = (OFluorosis) object;
        if ((this.fluId == null && other.fluId != null) || (this.fluId != null && !this.fluId.equals(other.fluId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "he1.entities.OFluorosis[ fluId=" + fluId + " ]";
    }

}
