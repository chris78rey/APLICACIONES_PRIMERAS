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
@Table(name = "U_CUIDADOS_1")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UCuidados1.findAll", query = "SELECT u FROM UCuidados1 u"),
    @NamedQuery(name = "UCuidados1.findByCu1Id", query = "SELECT u FROM UCuidados1 u WHERE u.cu1Id = :cu1Id"),
    @NamedQuery(name = "UCuidados1.findByCu1Fecha", query = "SELECT u FROM UCuidados1 u WHERE u.cu1Fecha = :cu1Fecha"),
    @NamedQuery(name = "UCuidados1.findByCu1Tipo", query = "SELECT u FROM UCuidados1 u WHERE u.cu1Tipo = :cu1Tipo"),
    @NamedQuery(name = "UCuidados1.findByCu1Inicio", query = "SELECT u FROM UCuidados1 u WHERE u.cu1Inicio = :cu1Inicio"),
    @NamedQuery(name = "UCuidados1.findByCu1Retiro", query = "SELECT u FROM UCuidados1 u WHERE u.cu1Retiro = :cu1Retiro"),
    @NamedQuery(name = "UCuidados1.findByCu1Cambio", query = "SELECT u FROM UCuidados1 u WHERE u.cu1Cambio = :cu1Cambio"),
    @NamedQuery(name = "UCuidados1.findByCu1Curacion", query = "SELECT u FROM UCuidados1 u WHERE u.cu1Curacion = :cu1Curacion"),
    @NamedQuery(name = "UCuidados1.findByCu1Responsable", query = "SELECT u FROM UCuidados1 u WHERE u.cu1Responsable = :cu1Responsable")})
public class UCuidados1 implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "CU1_ID")
    private BigDecimal cu1Id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CU1_FECHA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date cu1Fecha;
    @Size(max = 50)
    @Column(name = "CU1_TIPO")
    private String cu1Tipo;
    @Size(max = 50)
    @Column(name = "CU1_INICIO")
    private String cu1Inicio;
    @Size(max = 50)
    @Column(name = "CU1_RETIRO")
    private String cu1Retiro;
    @Size(max = 50)
    @Column(name = "CU1_CAMBIO")
    private String cu1Cambio;
    @Size(max = 50)
    @Column(name = "CU1_CURACION")
    private String cu1Curacion;
    @Size(max = 100)
    @Column(name = "CU1_RESPONSABLE")
    private String cu1Responsable;
    @JoinColumn(name = "OPP_ID", referencedColumnName = "OPP_ID")
    @ManyToOne(optional = false)
    private UOpcionPaciente uOpcionPaciente;
    @JoinColumn(name = "OPC_ID", referencedColumnName = "OPC_ID")
    @ManyToOne(optional = false)
    private UOpciones uOpciones;

    public UCuidados1() {
    }

    public UCuidados1(BigDecimal cu1Id) {
        this.cu1Id = cu1Id;
    }

    public UCuidados1(BigDecimal cu1Id, Date cu1Fecha) {
        this.cu1Id = cu1Id;
        this.cu1Fecha = cu1Fecha;
    }

    public BigDecimal getCu1Id() {
        return cu1Id;
    }

    public void setCu1Id(BigDecimal cu1Id) {
        this.cu1Id = cu1Id;
    }

    public Date getCu1Fecha() {
        return cu1Fecha;
    }

    public void setCu1Fecha(Date cu1Fecha) {
        this.cu1Fecha = cu1Fecha;
    }

    public String getCu1Tipo() {
        return cu1Tipo;
    }

    public void setCu1Tipo(String cu1Tipo) {
        this.cu1Tipo = cu1Tipo;
    }

    public String getCu1Inicio() {
        return cu1Inicio;
    }

    public void setCu1Inicio(String cu1Inicio) {
        this.cu1Inicio = cu1Inicio;
    }

    public String getCu1Retiro() {
        return cu1Retiro;
    }

    public void setCu1Retiro(String cu1Retiro) {
        this.cu1Retiro = cu1Retiro;
    }

    public String getCu1Cambio() {
        return cu1Cambio;
    }

    public void setCu1Cambio(String cu1Cambio) {
        this.cu1Cambio = cu1Cambio;
    }

    public String getCu1Curacion() {
        return cu1Curacion;
    }

    public void setCu1Curacion(String cu1Curacion) {
        this.cu1Curacion = cu1Curacion;
    }

    public String getCu1Responsable() {
        return cu1Responsable;
    }

    public void setCu1Responsable(String cu1Responsable) {
        this.cu1Responsable = cu1Responsable;
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
        hash += (cu1Id != null ? cu1Id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UCuidados1)) {
            return false;
        }
        UCuidados1 other = (UCuidados1) object;
        if ((this.cu1Id == null && other.cu1Id != null) || (this.cu1Id != null && !this.cu1Id.equals(other.cu1Id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "he1.uci.entities.UCuidados1[ cu1Id=" + cu1Id + " ]";
    }
    
}
