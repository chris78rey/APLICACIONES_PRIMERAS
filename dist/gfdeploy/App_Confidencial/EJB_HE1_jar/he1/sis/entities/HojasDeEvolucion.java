/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package he1.sis.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
@Table(name = "HOJAS_DE_EVOLUCION")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HojasDeEvolucion.findAll", query = "SELECT h FROM HojasDeEvolucion h"),
    @NamedQuery(name = "HojasDeEvolucion.findByNumero", query = "SELECT h FROM HojasDeEvolucion h WHERE h.numero = :numero"),
    @NamedQuery(name = "HojasDeEvolucion.findByFecha", query = "SELECT h FROM HojasDeEvolucion h WHERE h.fecha = :fecha"),
    })
public class HojasDeEvolucion implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "NUMERO")
    private BigDecimal numero;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "SERVICIO_CEX")
    private String servicioCex;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4000)
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @Size(max = 4000)
    @Column(name = "RESULTADO_EXAMEN_FISICO")
    private String resultadoExamenFisico;
    @Size(max = 1)
    @Column(name = "DPR_CODIGO")
    private String dprCodigo;
    @Size(max = 1)
    @Column(name = "DPR_ARA_CODIGO")
    private String dprAraCodigo;
    @Size(max = 1)
    @Column(name = "TIPO_EVOLUCION")
    private String tipoEvolucion;
    @Column(name = "INTCNS_NUMERO")
    private Integer intcnsNumero;
    @Column(name = "POOL")
    private Integer pool;
//    @Column(name = "DGNPCN_ID")
//    private Long dgnpcnId;
    @JoinColumn(name = "DGNPCN_ID", referencedColumnName = "DGNPCN_ID")
    @ManyToOne
    private DiagnosticosPaciente diagnosticosPaciente;
    @Column(name = "MINUTOS")
    private Short minutos;
    @Size(max = 3)
    @Column(name = "COMPLEJIDAD")
    private String complejidad;
    @Column(name = "PRMATN_NUMERO")
    private Long prmatnNumero;
    @Column(name = "REVISADO")
    private Character revisado;
    @JoinColumn(name = "PRS_CODIGO_REVISADO", referencedColumnName = "CODIGO")
    @ManyToOne
    private Personal personal;
    @JoinColumn(name = "PRS_CODIGO", referencedColumnName = "CODIGO")
    @ManyToOne(optional = false)
    private Personal personal1;
    @JoinColumn(name = "PCN_NUMERO_HC", referencedColumnName = "NUMERO_HC")
    @ManyToOne(optional = false)
    private Pacientes pacientes;
    @JoinColumn(name = "MOTIVO", referencedColumnName = "CODIGO")
    @ManyToOne(optional = false)
    private Motivos motivos;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "hojasDeEvolucion")
    private List<SignosVitales> signosVitalesList;

    public HojasDeEvolucion() {
    }

    public HojasDeEvolucion(BigDecimal numero) {
        this.numero = numero;
    }

    public HojasDeEvolucion(BigDecimal numero, Date fecha, String servicioCex, String descripcion) {
        this.numero = numero;
        this.fecha = fecha;
        this.servicioCex = servicioCex;
        this.descripcion = descripcion;
    }

    public BigDecimal getNumero() {
        return numero;
    }

    public void setNumero(BigDecimal numero) {
        this.numero = numero;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getServicioCex() {
        return servicioCex;
    }

    public void setServicioCex(String servicioCex) {
        this.servicioCex = servicioCex;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getResultadoExamenFisico() {
        return resultadoExamenFisico;
    }

    public void setResultadoExamenFisico(String resultadoExamenFisico) {
        this.resultadoExamenFisico = resultadoExamenFisico;
    }

    public String getDprCodigo() {
        return dprCodigo;
    }

    public void setDprCodigo(String dprCodigo) {
        this.dprCodigo = dprCodigo;
    }

    public String getDprAraCodigo() {
        return dprAraCodigo;
    }

    public void setDprAraCodigo(String dprAraCodigo) {
        this.dprAraCodigo = dprAraCodigo;
    }

    public String getTipoEvolucion() {
        return tipoEvolucion;
    }

    public void setTipoEvolucion(String tipoEvolucion) {
        this.tipoEvolucion = tipoEvolucion;
    }

    public Integer getIntcnsNumero() {
        return intcnsNumero;
    }

    public void setIntcnsNumero(Integer intcnsNumero) {
        this.intcnsNumero = intcnsNumero;
    }

    public Integer getPool() {
        return pool;
    }

    public void setPool(Integer pool) {
        this.pool = pool;
    }

//    public Long getDgnpcnId() {
//        return dgnpcnId;
//    }
//
//    public void setDgnpcnId(Long dgnpcnId) {
//        this.dgnpcnId = dgnpcnId;
//    }

    public DiagnosticosPaciente getDiagnosticosPaciente() {
        return diagnosticosPaciente;
    }

    public void setDiagnosticosPaciente(DiagnosticosPaciente diagnosticosPaciente) {
        this.diagnosticosPaciente = diagnosticosPaciente;
    }

    
    public Short getMinutos() {
        return minutos;
    }

    public void setMinutos(Short minutos) {
        this.minutos = minutos;
    }

    public String getComplejidad() {
        return complejidad;
    }

    public void setComplejidad(String complejidad) {
        this.complejidad = complejidad;
    }

    public Long getPrmatnNumero() {
        return prmatnNumero;
    }

    public void setPrmatnNumero(Long prmatnNumero) {
        this.prmatnNumero = prmatnNumero;
    }

    public Character getRevisado() {
        return revisado;
    }

    public void setRevisado(Character revisado) {
        this.revisado = revisado;
    }

    public Personal getPersonal() {
        return personal;
    }

    public void setPersonal(Personal personal) {
        this.personal = personal;
    }

    public Personal getPersonal1() {
        return personal1;
    }

    public void setPersonal1(Personal personal1) {
        this.personal1 = personal1;
    }

    public Pacientes getPacientes() {
        return pacientes;
    }

    public void setPacientes(Pacientes pacientes) {
        this.pacientes = pacientes;
    }

    public Motivos getMotivos() {
        return motivos;
    }

    public void setMotivos(Motivos motivos) {
        this.motivos = motivos;
    }

    @XmlTransient
    public List<SignosVitales> getSignosVitalesList() {
        return signosVitalesList;
    }

    public void setSignosVitalesList(List<SignosVitales> signosVitalesList) {
        this.signosVitalesList = signosVitalesList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (numero != null ? numero.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HojasDeEvolucion)) {
            return false;
        }
        HojasDeEvolucion other = (HojasDeEvolucion) object;
        if ((this.numero == null && other.numero != null) || (this.numero != null && !this.numero.equals(other.numero))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "he1.entities.HojasDeEvolucion[ numero=" + numero + " ]";
    }

}
