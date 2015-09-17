/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package he1.sis.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
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
@Table(name = "TURNOS_CE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TurnosCe.findAll", query = "SELECT t FROM TurnosCe t"),
    @NamedQuery(name = "TurnosCe.findByNumeroId", query = "SELECT t FROM TurnosCe t WHERE t.numeroId = :numeroId"),
    @NamedQuery(name = "TurnosCe.findByFecha", query = "SELECT t FROM TurnosCe t WHERE t.fecha = :fecha"),
    @NamedQuery(name = "TurnosCe.findByNumero", query = "SELECT t FROM TurnosCe t WHERE t.numero = :numero"),
    @NamedQuery(name = "TurnosCe.findByTipo", query = "SELECT t FROM TurnosCe t WHERE t.tipo = :tipo"),
    @NamedQuery(name = "TurnosCe.findByEstado", query = "SELECT t FROM TurnosCe t WHERE t.estado = :estado"),
    @NamedQuery(name = "TurnosCe.findByDprAraCodigo", query = "SELECT t FROM TurnosCe t WHERE t.dprAraCodigo = :dprAraCodigo"),
    @NamedQuery(name = "TurnosCe.findByDprCodigo", query = "SELECT t FROM TurnosCe t WHERE t.dprCodigo = :dprCodigo"),
    @NamedQuery(name = "TurnosCe.findByMotivo", query = "SELECT t FROM TurnosCe t WHERE t.motivo = :motivo"),
    @NamedQuery(name = "TurnosCe.findByFechaCreacion", query = "SELECT t FROM TurnosCe t WHERE t.fechaCreacion = :fechaCreacion"),
    @NamedQuery(name = "TurnosCe.findByOrden", query = "SELECT t FROM TurnosCe t WHERE t.orden = :orden"),
    @NamedQuery(name = "TurnosCe.findByFctCaja", query = "SELECT t FROM TurnosCe t WHERE t.fctCaja = :fctCaja"),
    @NamedQuery(name = "TurnosCe.findByFctNumero", query = "SELECT t FROM TurnosCe t WHERE t.fctNumero = :fctNumero"),
    @NamedQuery(name = "TurnosCe.findByDescuento", query = "SELECT t FROM TurnosCe t WHERE t.descuento = :descuento"),
    @NamedQuery(name = "TurnosCe.findByMotivoDescuento", query = "SELECT t FROM TurnosCe t WHERE t.motivoDescuento = :motivoDescuento"),
    @NamedQuery(name = "TurnosCe.findByCreado", query = "SELECT t FROM TurnosCe t WHERE t.creado = :creado"),
    @NamedQuery(name = "TurnosCe.findByFechaAtencion", query = "SELECT t FROM TurnosCe t WHERE t.fechaAtencion = :fechaAtencion"),
    @NamedQuery(name = "TurnosCe.findByFechaPago", query = "SELECT t FROM TurnosCe t WHERE t.fechaPago = :fechaPago"),
    @NamedQuery(name = "TurnosCe.findByObservaciones", query = "SELECT t FROM TurnosCe t WHERE t.observaciones = :observaciones"),
    @NamedQuery(name = "TurnosCe.findByCosto", query = "SELECT t FROM TurnosCe t WHERE t.costo = :costo"),
    @NamedQuery(name = "TurnosCe.findByDgnpcnDgnpcnId", query = "SELECT t FROM TurnosCe t WHERE t.dgnpcnDgnpcnId = :dgnpcnDgnpcnId"),
    @NamedQuery(name = "TurnosCe.findByMorbilidad", query = "SELECT t FROM TurnosCe t WHERE t.morbilidad = :morbilidad"),
    @NamedQuery(name = "TurnosCe.findByHjaevlNumero", query = "SELECT t FROM TurnosCe t WHERE t.hjaevlNumero = :hjaevlNumero"),
    @NamedQuery(name = "TurnosCe.findByPcntmpId", query = "SELECT t FROM TurnosCe t WHERE t.pcntmpId = :pcntmpId"),
    @NamedQuery(name = "TurnosCe.findByHoraInicio", query = "SELECT t FROM TurnosCe t WHERE t.horaInicio = :horaInicio"),
    @NamedQuery(name = "TurnosCe.findByHoraFin", query = "SELECT t FROM TurnosCe t WHERE t.horaFin = :horaFin"),
    @NamedQuery(name = "TurnosCe.findByPrmId", query = "SELECT t FROM TurnosCe t WHERE t.prmId = :prmId"),
    @NamedQuery(name = "TurnosCe.findByPcnFuerza", query = "SELECT t FROM TurnosCe t WHERE t.pcnFuerza = :pcnFuerza"),
    @NamedQuery(name = "TurnosCe.findByPcnGrado", query = "SELECT t FROM TurnosCe t WHERE t.pcnGrado = :pcnGrado"),
    @NamedQuery(name = "TurnosCe.findByPcnSituacion", query = "SELECT t FROM TurnosCe t WHERE t.pcnSituacion = :pcnSituacion"),
    @NamedQuery(name = "TurnosCe.findByCreadoPor", query = "SELECT t FROM TurnosCe t WHERE t.creadoPor = :creadoPor"),
    @NamedQuery(name = "TurnosCe.findByNotaAtencion", query = "SELECT t FROM TurnosCe t WHERE t.notaAtencion = :notaAtencion"),
    @NamedQuery(name = "TurnosCe.findByCpgpcnId", query = "SELECT t FROM TurnosCe t WHERE t.cpgpcnId = :cpgpcnId"),
    @NamedQuery(name = "TurnosCe.findBySobrecarga", query = "SELECT t FROM TurnosCe t WHERE t.sobrecarga = :sobrecarga")})
public class TurnosCe implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "NUMERO_ID")
    private BigDecimal numeroId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @Basic(optional = false)
    @NotNull
    @Column(name = "NUMERO")
    private short numero;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "TIPO")
    private String tipo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "ESTADO")
    private String estado;
    @Size(max = 1)
    @Column(name = "DPR_ARA_CODIGO")
    private String dprAraCodigo;
    @Size(max = 1)
    @Column(name = "DPR_CODIGO")
    private String dprCodigo;
    @Size(max = 4000)
    @Column(name = "MOTIVO")
    private String motivo;
    @Column(name = "FECHA_CREACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCreacion;
    @Column(name = "ORDEN")
    private Short orden;
    @Size(max = 3)
    @Column(name = "FCT_CAJA")
    private String fctCaja;
    @Column(name = "FCT_NUMERO")
    private Integer fctNumero;
    @Column(name = "DESCUENTO")
    private BigDecimal descuento;
    @Size(max = 256)
    @Column(name = "MOTIVO_DESCUENTO")
    private String motivoDescuento;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CREADO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date creado;
    @Column(name = "FECHA_ATENCION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaAtencion;
    @Column(name = "FECHA_PAGO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaPago;
    @Size(max = 256)
    @Column(name = "OBSERVACIONES")
    private String observaciones;
    @Column(name = "COSTO")
    private BigDecimal costo;
    @Column(name = "DGNPCN_DGNPCN_ID")
    private Long dgnpcnDgnpcnId;
    @Size(max = 1)
    @Column(name = "MORBILIDAD")
    private String morbilidad;
    @Column(name = "HJAEVL_NUMERO")
    private BigInteger hjaevlNumero;
    @Column(name = "PCNTMP_ID")
    private Long pcntmpId;
    @Column(name = "HORA_INICIO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date horaInicio;
    @Column(name = "HORA_FIN")
    @Temporal(TemporalType.TIMESTAMP)
    private Date horaFin;
    @Column(name = "PRM_ID")
    private Long prmId;
    @Size(max = 1)
    @Column(name = "PCN_FUERZA")
    private String pcnFuerza;
    @Size(max = 3)
    @Column(name = "PCN_GRADO")
    private String pcnGrado;
    @Size(max = 1)
    @Column(name = "PCN_SITUACION")
    private String pcnSituacion;
    @Size(max = 32)
    @Column(name = "CREADO_POR")
    private String creadoPor;
    @Size(max = 4000)
    @Column(name = "NOTA_ATENCION")
    private String notaAtencion;
    @Column(name = "CPGPCN_ID")
    private Long cpgpcnId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "SOBRECARGA")
    private Character sobrecarga;
    @JoinColumn(name = "PRS_ATENDIDO", referencedColumnName = "CODIGO")
    @ManyToOne
    private Personal personal;
    @JoinColumn(name = "PRS_CODIGO", referencedColumnName = "CODIGO")
    @ManyToOne(optional = false)
    private Personal personal1;
    @JoinColumn(name = "PCN_NUMERO_HC", referencedColumnName = "NUMERO_HC")
    @ManyToOne(optional = false)
    private Pacientes pacientes;

    public TurnosCe() {
    }

    public TurnosCe(BigDecimal numeroId) {
        this.numeroId = numeroId;
    }

    public TurnosCe(BigDecimal numeroId, Date fecha, short numero, String tipo, String estado, Date creado, Character sobrecarga) {
        this.numeroId = numeroId;
        this.fecha = fecha;
        this.numero = numero;
        this.tipo = tipo;
        this.estado = estado;
        this.creado = creado;
        this.sobrecarga = sobrecarga;
    }

    public BigDecimal getNumeroId() {
        return numeroId;
    }

    public void setNumeroId(BigDecimal numeroId) {
        this.numeroId = numeroId;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public short getNumero() {
        return numero;
    }

    public void setNumero(short numero) {
        this.numero = numero;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getDprAraCodigo() {
        return dprAraCodigo;
    }

    public void setDprAraCodigo(String dprAraCodigo) {
        this.dprAraCodigo = dprAraCodigo;
    }

    public String getDprCodigo() {
        return dprCodigo;
    }

    public void setDprCodigo(String dprCodigo) {
        this.dprCodigo = dprCodigo;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Short getOrden() {
        return orden;
    }

    public void setOrden(Short orden) {
        this.orden = orden;
    }

    public String getFctCaja() {
        return fctCaja;
    }

    public void setFctCaja(String fctCaja) {
        this.fctCaja = fctCaja;
    }

    public Integer getFctNumero() {
        return fctNumero;
    }

    public void setFctNumero(Integer fctNumero) {
        this.fctNumero = fctNumero;
    }

    public BigDecimal getDescuento() {
        return descuento;
    }

    public void setDescuento(BigDecimal descuento) {
        this.descuento = descuento;
    }

    public String getMotivoDescuento() {
        return motivoDescuento;
    }

    public void setMotivoDescuento(String motivoDescuento) {
        this.motivoDescuento = motivoDescuento;
    }

    public Date getCreado() {
        return creado;
    }

    public void setCreado(Date creado) {
        this.creado = creado;
    }

    public Date getFechaAtencion() {
        return fechaAtencion;
    }

    public void setFechaAtencion(Date fechaAtencion) {
        this.fechaAtencion = fechaAtencion;
    }

    public Date getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(Date fechaPago) {
        this.fechaPago = fechaPago;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public BigDecimal getCosto() {
        return costo;
    }

    public void setCosto(BigDecimal costo) {
        this.costo = costo;
    }

    public Long getDgnpcnDgnpcnId() {
        return dgnpcnDgnpcnId;
    }

    public void setDgnpcnDgnpcnId(Long dgnpcnDgnpcnId) {
        this.dgnpcnDgnpcnId = dgnpcnDgnpcnId;
    }

    public String getMorbilidad() {
        return morbilidad;
    }

    public void setMorbilidad(String morbilidad) {
        this.morbilidad = morbilidad;
    }

    public BigInteger getHjaevlNumero() {
        return hjaevlNumero;
    }

    public void setHjaevlNumero(BigInteger hjaevlNumero) {
        this.hjaevlNumero = hjaevlNumero;
    }

    public Long getPcntmpId() {
        return pcntmpId;
    }

    public void setPcntmpId(Long pcntmpId) {
        this.pcntmpId = pcntmpId;
    }

    public Date getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(Date horaInicio) {
        this.horaInicio = horaInicio;
    }

    public Date getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(Date horaFin) {
        this.horaFin = horaFin;
    }

    public Long getPrmId() {
        return prmId;
    }

    public void setPrmId(Long prmId) {
        this.prmId = prmId;
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

    public String getCreadoPor() {
        return creadoPor;
    }

    public void setCreadoPor(String creadoPor) {
        this.creadoPor = creadoPor;
    }

    public String getNotaAtencion() {
        return notaAtencion;
    }

    public void setNotaAtencion(String notaAtencion) {
        this.notaAtencion = notaAtencion;
    }

    public Long getCpgpcnId() {
        return cpgpcnId;
    }

    public void setCpgpcnId(Long cpgpcnId) {
        this.cpgpcnId = cpgpcnId;
    }

    public Character getSobrecarga() {
        return sobrecarga;
    }

    public void setSobrecarga(Character sobrecarga) {
        this.sobrecarga = sobrecarga;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (numeroId != null ? numeroId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TurnosCe)) {
            return false;
        }
        TurnosCe other = (TurnosCe) object;
        if ((this.numeroId == null && other.numeroId != null) || (this.numeroId != null && !this.numeroId.equals(other.numeroId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "he1.entities.TurnosCe[ numeroId=" + numeroId + " ]";
    }
    
}
