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
import javax.persistence.JoinColumns;
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
@Table(name = "VARIABLES_DE_EXAMENES")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VariablesDeExamenes.findAll", query = "SELECT v FROM VariablesDeExamenes v"),
    @NamedQuery(name = "VariablesDeExamenes.findByCodigo", query = "SELECT v FROM VariablesDeExamenes v WHERE v.codigo = :codigo"),
    @NamedQuery(name = "VariablesDeExamenes.findByCargarAFactura", query = "SELECT v FROM VariablesDeExamenes v WHERE v.cargarAFactura = :cargarAFactura"),
    @NamedQuery(name = "VariablesDeExamenes.findByEstadoDeActividad", query = "SELECT v FROM VariablesDeExamenes v WHERE v.estadoDeActividad = :estadoDeActividad"),
    @NamedQuery(name = "VariablesDeExamenes.findByFechaInicial", query = "SELECT v FROM VariablesDeExamenes v WHERE v.fechaInicial = :fechaInicial"),
    @NamedQuery(name = "VariablesDeExamenes.findByNombre", query = "SELECT v FROM VariablesDeExamenes v WHERE v.nombre = :nombre"),
    @NamedQuery(name = "VariablesDeExamenes.findByResultado", query = "SELECT v FROM VariablesDeExamenes v WHERE v.resultado = :resultado"),
    @NamedQuery(name = "VariablesDeExamenes.findByDenId", query = "SELECT v FROM VariablesDeExamenes v WHERE v.denId = :denId"),
    @NamedQuery(name = "VariablesDeExamenes.findByFechaFinal", query = "SELECT v FROM VariablesDeExamenes v WHERE v.fechaFinal = :fechaFinal"),
    @NamedQuery(name = "VariablesDeExamenes.findByFormaInvocada", query = "SELECT v FROM VariablesDeExamenes v WHERE v.formaInvocada = :formaInvocada"),
    @NamedQuery(name = "VariablesDeExamenes.findByNecesidadDeValoracion", query = "SELECT v FROM VariablesDeExamenes v WHERE v.necesidadDeValoracion = :necesidadDeValoracion"),
    @NamedQuery(name = "VariablesDeExamenes.findByNombreAbreviado", query = "SELECT v FROM VariablesDeExamenes v WHERE v.nombreAbreviado = :nombreAbreviado"),
    @NamedQuery(name = "VariablesDeExamenes.findByObservaciones", query = "SELECT v FROM VariablesDeExamenes v WHERE v.observaciones = :observaciones"),
    @NamedQuery(name = "VariablesDeExamenes.findByOperacion", query = "SELECT v FROM VariablesDeExamenes v WHERE v.operacion = :operacion"),
    @NamedQuery(name = "VariablesDeExamenes.findByOrdenDeImpresion", query = "SELECT v FROM VariablesDeExamenes v WHERE v.ordenDeImpresion = :ordenDeImpresion"),
    @NamedQuery(name = "VariablesDeExamenes.findByOrdenDePresentacion", query = "SELECT v FROM VariablesDeExamenes v WHERE v.ordenDePresentacion = :ordenDePresentacion"),
    @NamedQuery(name = "VariablesDeExamenes.findByPrioridad", query = "SELECT v FROM VariablesDeExamenes v WHERE v.prioridad = :prioridad"),
    @NamedQuery(name = "VariablesDeExamenes.findByTiempoEstimado", query = "SELECT v FROM VariablesDeExamenes v WHERE v.tiempoEstimado = :tiempoEstimado"),
    @NamedQuery(name = "VariablesDeExamenes.findByTuboRequerido", query = "SELECT v FROM VariablesDeExamenes v WHERE v.tuboRequerido = :tuboRequerido"),
    @NamedQuery(name = "VariablesDeExamenes.findByUnidad", query = "SELECT v FROM VariablesDeExamenes v WHERE v.unidad = :unidad"),
    @NamedQuery(name = "VariablesDeExamenes.findByGraficar", query = "SELECT v FROM VariablesDeExamenes v WHERE v.graficar = :graficar"),
    @NamedQuery(name = "VariablesDeExamenes.findByValorMaximo", query = "SELECT v FROM VariablesDeExamenes v WHERE v.valorMaximo = :valorMaximo"),
    @NamedQuery(name = "VariablesDeExamenes.findByValorMinimo", query = "SELECT v FROM VariablesDeExamenes v WHERE v.valorMinimo = :valorMinimo"),
    @NamedQuery(name = "VariablesDeExamenes.findByToxicidad", query = "SELECT v FROM VariablesDeExamenes v WHERE v.toxicidad = :toxicidad"),
    @NamedQuery(name = "VariablesDeExamenes.findByHojaTrabajo", query = "SELECT v FROM VariablesDeExamenes v WHERE v.hojaTrabajo = :hojaTrabajo"),
    @NamedQuery(name = "VariablesDeExamenes.findByRangoTextual", query = "SELECT v FROM VariablesDeExamenes v WHERE v.rangoTextual = :rangoTextual")})
public class VariablesDeExamenes implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "CODIGO")
    private Integer codigo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CARGAR_A_FACTURA")
    private Character cargarAFactura;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "ESTADO_DE_ACTIVIDAD")
    private String estadoDeActividad;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHA_INICIAL")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaInicial;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4000)
    @Column(name = "NOMBRE")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Column(name = "RESULTADO")
    private Character resultado;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DEN_ID")
    private BigInteger denId;
    @Column(name = "FECHA_FINAL")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaFinal;
    @Size(max = 30)
    @Column(name = "FORMA_INVOCADA")
    private String formaInvocada;
    @Size(max = 1)
    @Column(name = "NECESIDAD_DE_VALORACION")
    private String necesidadDeValoracion;
    @Size(max = 5)
    @Column(name = "NOMBRE_ABREVIADO")
    private String nombreAbreviado;
    @Size(max = 127)
    @Column(name = "OBSERVACIONES")
    private String observaciones;
    @Size(max = 1)
    @Column(name = "OPERACION")
    private String operacion;
    @Column(name = "ORDEN_DE_IMPRESION")
    private Short ordenDeImpresion;
    @Column(name = "ORDEN_DE_PRESENTACION")
    private Short ordenDePresentacion;
    @Column(name = "PRIORIDAD")
    private Short prioridad;
    @Size(max = 4)
    @Column(name = "TIEMPO_ESTIMADO")
    private String tiempoEstimado;
    @Size(max = 1)
    @Column(name = "TUBO_REQUERIDO")
    private String tuboRequerido;
    @Size(max = 7)
    @Column(name = "UNIDAD")
    private String unidad;
    @Column(name = "GRAFICAR")
    private Character graficar;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "VALOR_MAXIMO")
    private BigDecimal valorMaximo;
    @Column(name = "VALOR_MINIMO")
    private BigDecimal valorMinimo;
    @Size(max = 30)
    @Column(name = "TOXICIDAD")
    private String toxicidad;
    @Column(name = "HOJA_TRABAJO")
    private Short hojaTrabajo;
    @Size(max = 4000)
    @Column(name = "RANGO_TEXTUAL")
    private String rangoTextual;
    @JoinColumn(name = "TPOEXM_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private TiposDeExamenes tiposDeExamenes;
    @JoinColumn(name = "TPODTO_SECUENCIAL", referencedColumnName = "SECUENCIAL")
    @ManyToOne(optional = false)
    private TiposDeDatos tiposDeDatos;
    @JoinColumn(name = "GRPEST_CODIGO", referencedColumnName = "CODIGO")
    @ManyToOne
    private GruposEstadisticos gruposEstadisticos;
    @JoinColumns({
        @JoinColumn(name = "DPR_ARA_CODIGO", referencedColumnName = "ARA_CODIGO"),
        @JoinColumn(name = "DPR_CODIGO", referencedColumnName = "CODIGO")})
    @ManyToOne(optional = false)
    private Departamentos departamentos;
    @JoinColumns({
        @JoinColumn(name = "CRG_TIPO", referencedColumnName = "TIPO"),
        @JoinColumn(name = "CRG_CODIGO", referencedColumnName = "CODIGO")})
    @ManyToOne(optional = false)
    private Cargos cargos;

    public VariablesDeExamenes() {
    }

    public VariablesDeExamenes(Integer codigo) {
        this.codigo = codigo;
    }

    public VariablesDeExamenes(Integer codigo, Character cargarAFactura, String estadoDeActividad, Date fechaInicial, String nombre, Character resultado, BigInteger denId) {
        this.codigo = codigo;
        this.cargarAFactura = cargarAFactura;
        this.estadoDeActividad = estadoDeActividad;
        this.fechaInicial = fechaInicial;
        this.nombre = nombre;
        this.resultado = resultado;
        this.denId = denId;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public Character getCargarAFactura() {
        return cargarAFactura;
    }

    public void setCargarAFactura(Character cargarAFactura) {
        this.cargarAFactura = cargarAFactura;
    }

    public String getEstadoDeActividad() {
        return estadoDeActividad;
    }

    public void setEstadoDeActividad(String estadoDeActividad) {
        this.estadoDeActividad = estadoDeActividad;
    }

    public Date getFechaInicial() {
        return fechaInicial;
    }

    public void setFechaInicial(Date fechaInicial) {
        this.fechaInicial = fechaInicial;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Character getResultado() {
        return resultado;
    }

    public void setResultado(Character resultado) {
        this.resultado = resultado;
    }

    public BigInteger getDenId() {
        return denId;
    }

    public void setDenId(BigInteger denId) {
        this.denId = denId;
    }

    public Date getFechaFinal() {
        return fechaFinal;
    }

    public void setFechaFinal(Date fechaFinal) {
        this.fechaFinal = fechaFinal;
    }

    public String getFormaInvocada() {
        return formaInvocada;
    }

    public void setFormaInvocada(String formaInvocada) {
        this.formaInvocada = formaInvocada;
    }

    public String getNecesidadDeValoracion() {
        return necesidadDeValoracion;
    }

    public void setNecesidadDeValoracion(String necesidadDeValoracion) {
        this.necesidadDeValoracion = necesidadDeValoracion;
    }

    public String getNombreAbreviado() {
        return nombreAbreviado;
    }

    public void setNombreAbreviado(String nombreAbreviado) {
        this.nombreAbreviado = nombreAbreviado;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public String getOperacion() {
        return operacion;
    }

    public void setOperacion(String operacion) {
        this.operacion = operacion;
    }

    public Short getOrdenDeImpresion() {
        return ordenDeImpresion;
    }

    public void setOrdenDeImpresion(Short ordenDeImpresion) {
        this.ordenDeImpresion = ordenDeImpresion;
    }

    public Short getOrdenDePresentacion() {
        return ordenDePresentacion;
    }

    public void setOrdenDePresentacion(Short ordenDePresentacion) {
        this.ordenDePresentacion = ordenDePresentacion;
    }

    public Short getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(Short prioridad) {
        this.prioridad = prioridad;
    }

    public String getTiempoEstimado() {
        return tiempoEstimado;
    }

    public void setTiempoEstimado(String tiempoEstimado) {
        this.tiempoEstimado = tiempoEstimado;
    }

    public String getTuboRequerido() {
        return tuboRequerido;
    }

    public void setTuboRequerido(String tuboRequerido) {
        this.tuboRequerido = tuboRequerido;
    }

    public String getUnidad() {
        return unidad;
    }

    public void setUnidad(String unidad) {
        this.unidad = unidad;
    }

    public Character getGraficar() {
        return graficar;
    }

    public void setGraficar(Character graficar) {
        this.graficar = graficar;
    }

    public BigDecimal getValorMaximo() {
        return valorMaximo;
    }

    public void setValorMaximo(BigDecimal valorMaximo) {
        this.valorMaximo = valorMaximo;
    }

    public BigDecimal getValorMinimo() {
        return valorMinimo;
    }

    public void setValorMinimo(BigDecimal valorMinimo) {
        this.valorMinimo = valorMinimo;
    }

    public String getToxicidad() {
        return toxicidad;
    }

    public void setToxicidad(String toxicidad) {
        this.toxicidad = toxicidad;
    }

    public Short getHojaTrabajo() {
        return hojaTrabajo;
    }

    public void setHojaTrabajo(Short hojaTrabajo) {
        this.hojaTrabajo = hojaTrabajo;
    }

    public String getRangoTextual() {
        return rangoTextual;
    }

    public void setRangoTextual(String rangoTextual) {
        this.rangoTextual = rangoTextual;
    }

    public TiposDeExamenes getTiposDeExamenes() {
        return tiposDeExamenes;
    }

    public void setTiposDeExamenes(TiposDeExamenes tiposDeExamenes) {
        this.tiposDeExamenes = tiposDeExamenes;
    }

    public TiposDeDatos getTiposDeDatos() {
        return tiposDeDatos;
    }

    public void setTiposDeDatos(TiposDeDatos tiposDeDatos) {
        this.tiposDeDatos = tiposDeDatos;
    }

    public GruposEstadisticos getGruposEstadisticos() {
        return gruposEstadisticos;
    }

    public void setGruposEstadisticos(GruposEstadisticos gruposEstadisticos) {
        this.gruposEstadisticos = gruposEstadisticos;
    }

    public Departamentos getDepartamentos() {
        return departamentos;
    }

    public void setDepartamentos(Departamentos departamentos) {
        this.departamentos = departamentos;
    }

    public Cargos getCargos() {
        return cargos;
    }

    public void setCargos(Cargos cargos) {
        this.cargos = cargos;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigo != null ? codigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof VariablesDeExamenes)) {
            return false;
        }
        VariablesDeExamenes other = (VariablesDeExamenes) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.VariablesDeExamenes[ codigo=" + codigo + " ]";
    }
    
}
