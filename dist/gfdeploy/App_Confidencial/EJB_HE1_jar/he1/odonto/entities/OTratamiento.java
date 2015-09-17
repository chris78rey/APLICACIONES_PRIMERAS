/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package he1.odonto.entities;

import he1.sis.entities.HojasDeEvolucion;
import he1.sis.entities.Pacientes;
import he1.sis.entities.Personal;
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
@Table(name = "O_TRATAMIENTO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OTratamiento.findAll", query = "SELECT o FROM OTratamiento o"),
    @NamedQuery(name = "OTratamiento.findByTrtId", query = "SELECT o FROM OTratamiento o WHERE o.trtId = :trtId"),
    @NamedQuery(name = "OTratamiento.findByTrtFecha", query = "SELECT o FROM OTratamiento o WHERE o.trtFecha = :trtFecha"),
    @NamedQuery(name = "OTratamiento.findByTrtDiagnosCompl", query = "SELECT o FROM OTratamiento o WHERE o.trtDiagnosCompl = :trtDiagnosCompl"),
    @NamedQuery(name = "OTratamiento.findByTrtProcedimientos", query = "SELECT o FROM OTratamiento o WHERE o.trtProcedimientos = :trtProcedimientos"),
    @NamedQuery(name = "OTratamiento.findByTrtPrescripciones", query = "SELECT o FROM OTratamiento o WHERE o.trtPrescripciones = :trtPrescripciones")})
public class OTratamiento implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "TRT_ID")
    private BigDecimal trtId;
    @Column(name = "TRT_FECHA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date trtFecha;
    @Size(max = 240)
    @Column(name = "TRT_DIAGNOS_COMPL")
    private String trtDiagnosCompl;
    @Size(max = 240)
    @Column(name = "TRT_PROCEDIMIENTOS")
    private String trtProcedimientos;
    @Size(max = 240)
    @Column(name = "TRT_PRESCRIPCIONES")
    private String trtPrescripciones;
    @JoinColumn(name = "PRS_CODIGO", referencedColumnName = "CODIGO")
    @ManyToOne
    private Personal personal;
    @JoinColumn(name = "PCN_NUMERO_HC", referencedColumnName = "NUMERO_HC")
    @ManyToOne
    private Pacientes pacientes;
    @JoinColumn(name = "HJAEVL_NUMERO", referencedColumnName = "NUMERO")
    @ManyToOne
    private HojasDeEvolucion hojasDeEvolucion;

    public OTratamiento() {
    }

    public OTratamiento(BigDecimal trtId) {
        this.trtId = trtId;
    }

    public BigDecimal getTrtId() {
        return trtId;
    }

    public void setTrtId(BigDecimal trtId) {
        this.trtId = trtId;
    }

    public Date getTrtFecha() {
        return trtFecha;
    }

    public void setTrtFecha(Date trtFecha) {
        this.trtFecha = trtFecha;
    }

    public String getTrtDiagnosCompl() {
        return trtDiagnosCompl;
    }

    public void setTrtDiagnosCompl(String trtDiagnosCompl) {
        this.trtDiagnosCompl = trtDiagnosCompl;
    }

    public String getTrtProcedimientos() {
        return trtProcedimientos;
    }

    public void setTrtProcedimientos(String trtProcedimientos) {
        this.trtProcedimientos = trtProcedimientos;
    }

    public String getTrtPrescripciones() {
        return trtPrescripciones;
    }

    public void setTrtPrescripciones(String trtPrescripciones) {
        this.trtPrescripciones = trtPrescripciones;
    }

    public Personal getPersonal() {
        return personal;
    }

    public void setPersonal(Personal personal) {
        this.personal = personal;
    }

    public Pacientes getPacientes() {
        return pacientes;
    }

    public void setPacientes(Pacientes pacientes) {
        this.pacientes = pacientes;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (trtId != null ? trtId.hashCode() : 0);
        return hash;
    }

    public HojasDeEvolucion getHojasDeEvolucion() {
        return hojasDeEvolucion;
    }

    public void setHojasDeEvolucion(HojasDeEvolucion hojasDeEvolucion) {
        this.hojasDeEvolucion = hojasDeEvolucion;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OTratamiento)) {
            return false;
        }
        OTratamiento other = (OTratamiento) object;
        if ((this.trtId == null && other.trtId != null) || (this.trtId != null && !this.trtId.equals(other.trtId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "he1.entities.OTratamiento[ trtId=" + trtId + " ]";
    }

}
