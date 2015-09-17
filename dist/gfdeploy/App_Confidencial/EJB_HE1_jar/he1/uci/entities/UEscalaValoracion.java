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
@Table(name = "U_ESCALA_VALORACION")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UEscalaValoracion.findAll", query = "SELECT u FROM UEscalaValoracion u"),
    @NamedQuery(name = "UEscalaValoracion.findByEscId", query = "SELECT u FROM UEscalaValoracion u WHERE u.escId = :escId"),
    @NamedQuery(name = "UEscalaValoracion.findByEscFecha", query = "SELECT u FROM UEscalaValoracion u WHERE u.escFecha = :escFecha"),
    @NamedQuery(name = "UEscalaValoracion.findByEscApache", query = "SELECT u FROM UEscalaValoracion u WHERE u.escApache = :escApache"),
    @NamedQuery(name = "UEscalaValoracion.findByEscTiss", query = "SELECT u FROM UEscalaValoracion u WHERE u.escTiss = :escTiss"),
    @NamedQuery(name = "UEscalaValoracion.findByEscSofa", query = "SELECT u FROM UEscalaValoracion u WHERE u.escSofa = :escSofa"),
    @NamedQuery(name = "UEscalaValoracion.findByEscNorthon", query = "SELECT u FROM UEscalaValoracion u WHERE u.escNorthon = :escNorthon"),
    @NamedQuery(name = "UEscalaValoracion.findByEscRass", query = "SELECT u FROM UEscalaValoracion u WHERE u.escRass = :escRass")})
public class UEscalaValoracion implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ESC_ID")
    private BigDecimal escId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ESC_FECHA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date escFecha;
    @Size(max = 10)
    @Column(name = "ESC_APACHE")
    private String escApache;
    @Size(max = 10)
    @Column(name = "ESC_TISS")
    private String escTiss;
    @Size(max = 10)
    @Column(name = "ESC_SOFA")
    private String escSofa;
    @Size(max = 10)
    @Column(name = "ESC_NORTHON")
    private String escNorthon;
    @Size(max = 10)
    @Column(name = "ESC_RASS")
    private String escRass;
    @JoinColumn(name = "OPP_ID", referencedColumnName = "OPP_ID")
    @ManyToOne(optional = false)
    private UOpcionPaciente uOpcionPaciente;
    @JoinColumn(name = "OPC_ID", referencedColumnName = "OPC_ID")
    @ManyToOne(optional = false)
    private UOpciones uOpciones;

    public UEscalaValoracion() {
    }

    public UEscalaValoracion(BigDecimal escId) {
        this.escId = escId;
    }

    public UEscalaValoracion(BigDecimal escId, Date escFecha) {
        this.escId = escId;
        this.escFecha = escFecha;
    }

    public BigDecimal getEscId() {
        return escId;
    }

    public void setEscId(BigDecimal escId) {
        this.escId = escId;
    }

    public Date getEscFecha() {
        return escFecha;
    }

    public void setEscFecha(Date escFecha) {
        this.escFecha = escFecha;
    }

    public String getEscApache() {
        return escApache;
    }

    public void setEscApache(String escApache) {
        this.escApache = escApache;
    }

    public String getEscTiss() {
        return escTiss;
    }

    public void setEscTiss(String escTiss) {
        this.escTiss = escTiss;
    }

    public String getEscSofa() {
        return escSofa;
    }

    public void setEscSofa(String escSofa) {
        this.escSofa = escSofa;
    }

    public String getEscNorthon() {
        return escNorthon;
    }

    public void setEscNorthon(String escNorthon) {
        this.escNorthon = escNorthon;
    }

    public String getEscRass() {
        return escRass;
    }

    public void setEscRass(String escRass) {
        this.escRass = escRass;
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
        hash += (escId != null ? escId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UEscalaValoracion)) {
            return false;
        }
        UEscalaValoracion other = (UEscalaValoracion) object;
        if ((this.escId == null && other.escId != null) || (this.escId != null && !this.escId.equals(other.escId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "he1.uci.entidades.UEscalaValoracion[ escId=" + escId + " ]";
    }
    
}
