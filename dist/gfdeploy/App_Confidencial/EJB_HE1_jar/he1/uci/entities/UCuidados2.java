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
@Table(name = "U_CUIDADOS_2")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UCuidados2.findAll", query = "SELECT u FROM UCuidados2 u"),
    @NamedQuery(name = "UCuidados2.findByCu2Id", query = "SELECT u FROM UCuidados2 u WHERE u.cu2Id = :cu2Id"),
    @NamedQuery(name = "UCuidados2.findByCu2Fecha", query = "SELECT u FROM UCuidados2 u WHERE u.cu2Fecha = :cu2Fecha"),
    @NamedQuery(name = "UCuidados2.findByCu2Frecuencia", query = "SELECT u FROM UCuidados2 u WHERE u.cu2Frecuencia = :cu2Frecuencia"),
    @NamedQuery(name = "UCuidados2.findByCu2Am", query = "SELECT u FROM UCuidados2 u WHERE u.cu2Am = :cu2Am"),
    @NamedQuery(name = "UCuidados2.findByCu2Pm", query = "SELECT u FROM UCuidados2 u WHERE u.cu2Pm = :cu2Pm"),
    @NamedQuery(name = "UCuidados2.findByCu2Hs", query = "SELECT u FROM UCuidados2 u WHERE u.cu2Hs = :cu2Hs")})
public class UCuidados2 implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "CU2_ID")
    private BigDecimal cu2Id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CU2_FECHA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date cu2Fecha;
    @Size(max = 50)
    @Column(name = "CU2_FRECUENCIA")
    private String cu2Frecuencia;
    @Size(max = 1)
    @Column(name = "CU2_AM")
    private String cu2Am;
    @Size(max = 1)
    @Column(name = "CU2_PM")
    private String cu2Pm;
    @Size(max = 1)
    @Column(name = "CU2_HS")
    private String cu2Hs;
    @JoinColumn(name = "OPP_ID", referencedColumnName = "OPP_ID")
    @ManyToOne(optional = false)
    private UOpcionPaciente uOpcionPaciente;
    @JoinColumn(name = "OPC_ID", referencedColumnName = "OPC_ID")
    @ManyToOne(optional = false)
    private UOpciones uOpciones;

    public UCuidados2() {
    }

    public UCuidados2(BigDecimal cu2Id) {
        this.cu2Id = cu2Id;
    }

    public UCuidados2(BigDecimal cu2Id, Date cu2Fecha) {
        this.cu2Id = cu2Id;
        this.cu2Fecha = cu2Fecha;
    }

    public BigDecimal getCu2Id() {
        return cu2Id;
    }

    public void setCu2Id(BigDecimal cu2Id) {
        this.cu2Id = cu2Id;
    }

    public Date getCu2Fecha() {
        return cu2Fecha;
    }

    public void setCu2Fecha(Date cu2Fecha) {
        this.cu2Fecha = cu2Fecha;
    }

    public String getCu2Frecuencia() {
        return cu2Frecuencia;
    }

    public void setCu2Frecuencia(String cu2Frecuencia) {
        this.cu2Frecuencia = cu2Frecuencia;
    }

    public String getCu2Am() {
        return cu2Am;
    }

    public void setCu2Am(String cu2Am) {
        this.cu2Am = cu2Am;
    }

    public String getCu2Pm() {
        return cu2Pm;
    }

    public void setCu2Pm(String cu2Pm) {
        this.cu2Pm = cu2Pm;
    }

    public String getCu2Hs() {
        return cu2Hs;
    }

    public void setCu2Hs(String cu2Hs) {
        this.cu2Hs = cu2Hs;
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
        hash += (cu2Id != null ? cu2Id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UCuidados2)) {
            return false;
        }
        UCuidados2 other = (UCuidados2) object;
        if ((this.cu2Id == null && other.cu2Id != null) || (this.cu2Id != null && !this.cu2Id.equals(other.cu2Id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "he1.uci.entities.UCuidados2[ cu2Id=" + cu2Id + " ]";
    }
    
}
