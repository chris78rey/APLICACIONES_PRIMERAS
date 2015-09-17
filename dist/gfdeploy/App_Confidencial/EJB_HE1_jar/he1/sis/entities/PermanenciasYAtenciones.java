/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package he1.sis.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
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
@Table(name = "PERMANENCIAS_Y_ATENCIONES")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PermanenciasYAtenciones.findAll", query = "SELECT p FROM PermanenciasYAtenciones p"),
    @NamedQuery(name = "PermanenciasYAtenciones.findByPcnNumeroHc", query = "SELECT p FROM PermanenciasYAtenciones p WHERE p.permanenciasYAtencionesPK.pcnNumeroHc = :pcnNumeroHc"),
    @NamedQuery(name = "PermanenciasYAtenciones.findByNumero", query = "SELECT p FROM PermanenciasYAtenciones p WHERE p.permanenciasYAtencionesPK.numero = :numero"),
    @NamedQuery(name = "PermanenciasYAtenciones.findByPrsCodigoAdmitidaPor", query = "SELECT p FROM PermanenciasYAtenciones p WHERE p.prsCodigoAdmitidaPor = :prsCodigoAdmitidaPor"),
    @NamedQuery(name = "PermanenciasYAtenciones.findByTipo", query = "SELECT p FROM PermanenciasYAtenciones p WHERE p.tipo = :tipo"),
    @NamedQuery(name = "PermanenciasYAtenciones.findByDgnpcnDgnpcnId", query = "SELECT p FROM PermanenciasYAtenciones p WHERE p.dgnpcnDgnpcnId = :dgnpcnDgnpcnId"),
    @NamedQuery(name = "PermanenciasYAtenciones.findByPrsCodigo", query = "SELECT p FROM PermanenciasYAtenciones p WHERE p.prsCodigo = :prsCodigo"),
    @NamedQuery(name = "PermanenciasYAtenciones.findByFechaIngreso", query = "SELECT p FROM PermanenciasYAtenciones p WHERE p.fechaIngreso = :fechaIngreso"),
    @NamedQuery(name = "PermanenciasYAtenciones.findByPeso", query = "SELECT p FROM PermanenciasYAtenciones p WHERE p.peso = :peso"),
    @NamedQuery(name = "PermanenciasYAtenciones.findByFechaAlta", query = "SELECT p FROM PermanenciasYAtenciones p WHERE p.fechaAlta = :fechaAlta"),
    @NamedQuery(name = "PermanenciasYAtenciones.findByTotalDias", query = "SELECT p FROM PermanenciasYAtenciones p WHERE p.totalDias = :totalDias"),
    @NamedQuery(name = "PermanenciasYAtenciones.findByPcntmpPcntmpId", query = "SELECT p FROM PermanenciasYAtenciones p WHERE p.pcntmpPcntmpId = :pcntmpPcntmpId"),
    @NamedQuery(name = "PermanenciasYAtenciones.findBySeguro", query = "SELECT p FROM PermanenciasYAtenciones p WHERE p.seguro = :seguro"),
    @NamedQuery(name = "PermanenciasYAtenciones.findByTpoprmCodigo", query = "SELECT p FROM PermanenciasYAtenciones p WHERE p.tpoprmCodigo = :tpoprmCodigo"),
    @NamedQuery(name = "PermanenciasYAtenciones.findBySlcintNumero", query = "SELECT p FROM PermanenciasYAtenciones p WHERE p.slcintNumero = :slcintNumero"),
    @NamedQuery(name = "PermanenciasYAtenciones.findByHistoria", query = "SELECT p FROM PermanenciasYAtenciones p WHERE p.historia = :historia"),
    @NamedQuery(name = "PermanenciasYAtenciones.findByPrsCodigoRealizado", query = "SELECT p FROM PermanenciasYAtenciones p WHERE p.prsCodigoRealizado = :prsCodigoRealizado"),
    @NamedQuery(name = "PermanenciasYAtenciones.findByEspecialidad", query = "SELECT p FROM PermanenciasYAtenciones p WHERE p.especialidad = :especialidad"),
    @NamedQuery(name = "PermanenciasYAtenciones.findByFechaTransferencia", query = "SELECT p FROM PermanenciasYAtenciones p WHERE p.fechaTransferencia = :fechaTransferencia"),
    @NamedQuery(name = "PermanenciasYAtenciones.findByTipoTransferencia", query = "SELECT p FROM PermanenciasYAtenciones p WHERE p.tipoTransferencia = :tipoTransferencia"),
    @NamedQuery(name = "PermanenciasYAtenciones.findByPcnFuerza", query = "SELECT p FROM PermanenciasYAtenciones p WHERE p.pcnFuerza = :pcnFuerza"),
    @NamedQuery(name = "PermanenciasYAtenciones.findByPcnGrado", query = "SELECT p FROM PermanenciasYAtenciones p WHERE p.pcnGrado = :pcnGrado"),
    @NamedQuery(name = "PermanenciasYAtenciones.findByPcnSituacion", query = "SELECT p FROM PermanenciasYAtenciones p WHERE p.pcnSituacion = :pcnSituacion"),
    @NamedQuery(name = "PermanenciasYAtenciones.findByPrealta", query = "SELECT p FROM PermanenciasYAtenciones p WHERE p.prealta = :prealta")})
public class PermanenciasYAtenciones implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PermanenciasYAtencionesPK permanenciasYAtencionesPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "PRS_CODIGO_ADMITIDA_POR")
    private String prsCodigoAdmitidaPor;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "TIPO")
    private String tipo;
    @Column(name = "DGNPCN_DGNPCN_ID")
    private Long dgnpcnDgnpcnId;
    @Size(max = 4)
    @Column(name = "PRS_CODIGO")
    private String prsCodigo;
    @Column(name = "FECHA_INGRESO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaIngreso;
    @Column(name = "PESO")
    private Short peso;
    @Column(name = "FECHA_ALTA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaAlta;
    @Column(name = "TOTAL_DIAS")
    private Integer totalDias;
    @Column(name = "PCNTMP_PCNTMP_ID")
    private Long pcntmpPcntmpId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "SEGURO")
    private Character seguro;
    @Column(name = "TPOPRM_CODIGO")
    private Short tpoprmCodigo;
    @Column(name = "SLCINT_NUMERO")
    private Integer slcintNumero;
    @Size(max = 4000)
    @Column(name = "HISTORIA")
    private String historia;
    @Size(max = 4)
    @Column(name = "PRS_CODIGO_REALIZADO")
    private String prsCodigoRealizado;
    @Size(max = 3)
    @Column(name = "ESPECIALIDAD")
    private String especialidad;
    @Column(name = "FECHA_TRANSFERENCIA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaTransferencia;
    @Size(max = 3)
    @Column(name = "TIPO_TRANSFERENCIA")
    private String tipoTransferencia;
    @Size(max = 1)
    @Column(name = "PCN_FUERZA")
    private String pcnFuerza;
    @Size(max = 3)
    @Column(name = "PCN_GRADO")
    private String pcnGrado;
    @Size(max = 1)
    @Column(name = "PCN_SITUACION")
    private String pcnSituacion;
    @Column(name = "PREALTA")
    private Character prealta;
    @JoinColumn(name = "PCN_NUMERO_HC", referencedColumnName = "NUMERO_HC", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Pacientes pacientes;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "permanenciasYAtenciones")
    private List<TurnosCamas> turnosCamasList;

    public PermanenciasYAtenciones() {
    }

    public PermanenciasYAtenciones(PermanenciasYAtencionesPK permanenciasYAtencionesPK) {
        this.permanenciasYAtencionesPK = permanenciasYAtencionesPK;
    }

    public PermanenciasYAtenciones(PermanenciasYAtencionesPK permanenciasYAtencionesPK, String prsCodigoAdmitidaPor, String tipo, Character seguro) {
        this.permanenciasYAtencionesPK = permanenciasYAtencionesPK;
        this.prsCodigoAdmitidaPor = prsCodigoAdmitidaPor;
        this.tipo = tipo;
        this.seguro = seguro;
    }

    public PermanenciasYAtenciones(int pcnNumeroHc, int numero) {
        this.permanenciasYAtencionesPK = new PermanenciasYAtencionesPK(pcnNumeroHc, numero);
    }

    public PermanenciasYAtencionesPK getPermanenciasYAtencionesPK() {
        return permanenciasYAtencionesPK;
    }

    public void setPermanenciasYAtencionesPK(PermanenciasYAtencionesPK permanenciasYAtencionesPK) {
        this.permanenciasYAtencionesPK = permanenciasYAtencionesPK;
    }

    public String getPrsCodigoAdmitidaPor() {
        return prsCodigoAdmitidaPor;
    }

    public void setPrsCodigoAdmitidaPor(String prsCodigoAdmitidaPor) {
        this.prsCodigoAdmitidaPor = prsCodigoAdmitidaPor;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Long getDgnpcnDgnpcnId() {
        return dgnpcnDgnpcnId;
    }

    public void setDgnpcnDgnpcnId(Long dgnpcnDgnpcnId) {
        this.dgnpcnDgnpcnId = dgnpcnDgnpcnId;
    }

    public String getPrsCodigo() {
        return prsCodigo;
    }

    public void setPrsCodigo(String prsCodigo) {
        this.prsCodigo = prsCodigo;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public Short getPeso() {
        return peso;
    }

    public void setPeso(Short peso) {
        this.peso = peso;
    }

    public Date getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(Date fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    public Integer getTotalDias() {
        return totalDias;
    }

    public void setTotalDias(Integer totalDias) {
        this.totalDias = totalDias;
    }

    public Long getPcntmpPcntmpId() {
        return pcntmpPcntmpId;
    }

    public void setPcntmpPcntmpId(Long pcntmpPcntmpId) {
        this.pcntmpPcntmpId = pcntmpPcntmpId;
    }

    public Character getSeguro() {
        return seguro;
    }

    public void setSeguro(Character seguro) {
        this.seguro = seguro;
    }

    public Short getTpoprmCodigo() {
        return tpoprmCodigo;
    }

    public void setTpoprmCodigo(Short tpoprmCodigo) {
        this.tpoprmCodigo = tpoprmCodigo;
    }

    public Integer getSlcintNumero() {
        return slcintNumero;
    }

    public void setSlcintNumero(Integer slcintNumero) {
        this.slcintNumero = slcintNumero;
    }

    public String getHistoria() {
        return historia;
    }

    public void setHistoria(String historia) {
        this.historia = historia;
    }

    public String getPrsCodigoRealizado() {
        return prsCodigoRealizado;
    }

    public void setPrsCodigoRealizado(String prsCodigoRealizado) {
        this.prsCodigoRealizado = prsCodigoRealizado;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public Date getFechaTransferencia() {
        return fechaTransferencia;
    }

    public void setFechaTransferencia(Date fechaTransferencia) {
        this.fechaTransferencia = fechaTransferencia;
    }

    public String getTipoTransferencia() {
        return tipoTransferencia;
    }

    public void setTipoTransferencia(String tipoTransferencia) {
        this.tipoTransferencia = tipoTransferencia;
    }

    public String getPcnFuerza() {
        return pcnFuerza;
    }

    public void setPcnFuerza(String pcnFuerza) {
        this.pcnFuerza = pcnFuerza;
    }

    public String getPcnGrado() {
        return pcnGrado;
    }

    public void setPcnGrado(String pcnGrado) {
        this.pcnGrado = pcnGrado;
    }

    public String getPcnSituacion() {
        return pcnSituacion;
    }

    public void setPcnSituacion(String pcnSituacion) {
        this.pcnSituacion = pcnSituacion;
    }

    public Character getPrealta() {
        return prealta;
    }

    public void setPrealta(Character prealta) {
        this.prealta = prealta;
    }

    public Pacientes getPacientes() {
        return pacientes;
    }

    public void setPacientes(Pacientes pacientes) {
        this.pacientes = pacientes;
    }

    @XmlTransient
    public List<TurnosCamas> getTurnosCamasList() {
        return turnosCamasList;
    }

    public void setTurnosCamasList(List<TurnosCamas> turnosCamasList) {
        this.turnosCamasList = turnosCamasList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (permanenciasYAtencionesPK != null ? permanenciasYAtencionesPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PermanenciasYAtenciones)) {
            return false;
        }
        PermanenciasYAtenciones other = (PermanenciasYAtenciones) object;
        if ((this.permanenciasYAtencionesPK == null && other.permanenciasYAtencionesPK != null) || (this.permanenciasYAtencionesPK != null && !this.permanenciasYAtencionesPK.equals(other.permanenciasYAtencionesPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "he1.sis.entities.PermanenciasYAtenciones[ permanenciasYAtencionesPK=" + permanenciasYAtencionesPK + " ]";
    }
    
}
