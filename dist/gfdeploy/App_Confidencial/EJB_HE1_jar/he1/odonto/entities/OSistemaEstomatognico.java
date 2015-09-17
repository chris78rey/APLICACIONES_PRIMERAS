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
@Table(name = "O_SISTEMA_ESTOMATOGNICO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OSistemaEstomatognico.findAll", query = "SELECT o FROM OSistemaEstomatognico o"),
    @NamedQuery(name = "OSistemaEstomatognico.findBySieId", query = "SELECT o FROM OSistemaEstomatognico o WHERE o.sieId = :sieId"),
    @NamedQuery(name = "OSistemaEstomatognico.findBySieFecha", query = "SELECT o FROM OSistemaEstomatognico o WHERE o.sieFecha = :sieFecha"),
    @NamedQuery(name = "OSistemaEstomatognico.findBySieDescripcion", query = "SELECT o FROM OSistemaEstomatognico o WHERE o.sieDescripcion = :sieDescripcion")})
public class OSistemaEstomatognico implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "SIE_ID")
    private BigDecimal sieId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "SIE_FECHA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date sieFecha;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 240)
    @Column(name = "SIE_DESCRIPCION")
    private String sieDescripcion;
    @JoinColumn(name = "PCN_NUMERO_HC", referencedColumnName = "NUMERO_HC")
    @ManyToOne
    private Pacientes pacientes;
    @JoinColumn(name = "PAT_ID", referencedColumnName = "PAT_ID")
    @ManyToOne
    private OPatologias oPatologias;
    @JoinColumn(name = "HJAEVL_NUMERO", referencedColumnName = "NUMERO")
    @ManyToOne
    private HojasDeEvolucion hojasDeEvolucion;

    public OSistemaEstomatognico() {
    }

    public OSistemaEstomatognico(BigDecimal sieId) {
        this.sieId = sieId;
    }

    public OSistemaEstomatognico(BigDecimal sieId, Date sieFecha, String sieDescripcion) {
        this.sieId = sieId;
        this.sieFecha = sieFecha;
        this.sieDescripcion = sieDescripcion;
    }

    public BigDecimal getSieId() {
        return sieId;
    }

    public void setSieId(BigDecimal sieId) {
        this.sieId = sieId;
    }

    public Date getSieFecha() {
        return sieFecha;
    }

    public void setSieFecha(Date sieFecha) {
        this.sieFecha = sieFecha;
    }

    public String getSieDescripcion() {
        return sieDescripcion;
    }

    public void setSieDescripcion(String sieDescripcion) {
        this.sieDescripcion = sieDescripcion;
    }

    public Pacientes getPacientes() {
        return pacientes;
    }

    public void setPacientes(Pacientes pacientes) {
        this.pacientes = pacientes;
    }

    public OPatologias getOPatologias() {
        return oPatologias;
    }

    public void setOPatologias(OPatologias oPatologias) {
        this.oPatologias = oPatologias;
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
        hash += (sieId != null ? sieId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OSistemaEstomatognico)) {
            return false;
        }
        OSistemaEstomatognico other = (OSistemaEstomatognico) object;
        if ((this.sieId == null && other.sieId != null) || (this.sieId != null && !this.sieId.equals(other.sieId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "he1.entities.OSistemaEstomatognico[ sieId=" + sieId + " ]";
    }

}
