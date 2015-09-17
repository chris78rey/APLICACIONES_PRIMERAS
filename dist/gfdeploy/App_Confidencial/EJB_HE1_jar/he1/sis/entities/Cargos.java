/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package he1.sis.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author luis_guanoluiza
 */
@Entity
@Table(name = "CARGOS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cargos.findAll", query = "SELECT c FROM Cargos c"),
    @NamedQuery(name = "Cargos.findByTipo", query = "SELECT c FROM Cargos c WHERE c.cargosPK.tipo = :tipo"),
    @NamedQuery(name = "Cargos.findByCodigo", query = "SELECT c FROM Cargos c WHERE c.cargosPK.codigo = :codigo"),
    @NamedQuery(name = "Cargos.findByDescripcion", query = "SELECT c FROM Cargos c WHERE c.descripcion = :descripcion"),
    @NamedQuery(name = "Cargos.findByCosto", query = "SELECT c FROM Cargos c WHERE c.costo = :costo"),
    @NamedQuery(name = "Cargos.findByIva", query = "SELECT c FROM Cargos c WHERE c.iva = :iva"),
    @NamedQuery(name = "Cargos.findByEstadoDeDisponibilidad", query = "SELECT c FROM Cargos c WHERE c.estadoDeDisponibilidad = :estadoDeDisponibilidad"),
    @NamedQuery(name = "Cargos.findByCostoModificable", query = "SELECT c FROM Cargos c WHERE c.costoModificable = :costoModificable"),
    @NamedQuery(name = "Cargos.findByEquipoEspecial", query = "SELECT c FROM Cargos c WHERE c.equipoEspecial = :equipoEspecial"),
    @NamedQuery(name = "Cargos.findByAgrupadorContable", query = "SELECT c FROM Cargos c WHERE c.agrupadorContable = :agrupadorContable"),
    @NamedQuery(name = "Cargos.findByAgrcntCodigo", query = "SELECT c FROM Cargos c WHERE c.agrcntCodigo = :agrcntCodigo"),
    @NamedQuery(name = "Cargos.findByAgrcntTipo", query = "SELECT c FROM Cargos c WHERE c.agrcntTipo = :agrcntTipo"),
    @NamedQuery(name = "Cargos.findByTiempo", query = "SELECT c FROM Cargos c WHERE c.tiempo = :tiempo"),
    @NamedQuery(name = "Cargos.findByFactor", query = "SELECT c FROM Cargos c WHERE c.factor = :factor"),
    @NamedQuery(name = "Cargos.findByRangoMinimo", query = "SELECT c FROM Cargos c WHERE c.rangoMinimo = :rangoMinimo"),
    @NamedQuery(name = "Cargos.findByRangoMaximo", query = "SELECT c FROM Cargos c WHERE c.rangoMaximo = :rangoMaximo"),
    @NamedQuery(name = "Cargos.findByOperador", query = "SELECT c FROM Cargos c WHERE c.operador = :operador"),
    @NamedQuery(name = "Cargos.findByCantidadMinima", query = "SELECT c FROM Cargos c WHERE c.cantidadMinima = :cantidadMinima"),
    @NamedQuery(name = "Cargos.findByEmpCodigo", query = "SELECT c FROM Cargos c WHERE c.empCodigo = :empCodigo"),
    @NamedQuery(name = "Cargos.findByTipoHonorario", query = "SELECT c FROM Cargos c WHERE c.tipoHonorario = :tipoHonorario"),
    @NamedQuery(name = "Cargos.findByMaximoDescuento", query = "SELECT c FROM Cargos c WHERE c.maximoDescuento = :maximoDescuento"),
    @NamedQuery(name = "Cargos.findByNombreIess", query = "SELECT c FROM Cargos c WHERE c.nombreIess = :nombreIess"),
    @NamedQuery(name = "Cargos.findByCodigoIess", query = "SELECT c FROM Cargos c WHERE c.codigoIess = :codigoIess"),
    @NamedQuery(name = "Cargos.findByGobierno", query = "SELECT c FROM Cargos c WHERE c.gobierno = :gobierno"),
    @NamedQuery(name = "Cargos.findByAnestesiaIess", query = "SELECT c FROM Cargos c WHERE c.anestesiaIess = :anestesiaIess"),
    @NamedQuery(name = "Cargos.findByIess", query = "SELECT c FROM Cargos c WHERE c.iess = :iess")})
public class Cargos implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CargosPK cargosPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2000)
    @Column(name = "DESCRIPCION")
    private String descripcion;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "COSTO")
    private BigDecimal costo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "IVA")
    private BigDecimal iva;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ESTADO_DE_DISPONIBILIDAD")
    private Character estadoDeDisponibilidad;
    @Basic(optional = false)
    @NotNull
    @Column(name = "COSTO_MODIFICABLE")
    private Character costoModificable;
    @Basic(optional = false)
    @NotNull
    @Column(name = "EQUIPO_ESPECIAL")
    private Character equipoEspecial;
    @Size(max = 3)
    @Column(name = "AGRUPADOR_CONTABLE")
    private String agrupadorContable;
    @Size(max = 3)
    @Column(name = "AGRCNT_CODIGO")
    private String agrcntCodigo;
    @Size(max = 3)
    @Column(name = "AGRCNT_TIPO")
    private String agrcntTipo;
    @Column(name = "TIEMPO")
    private Character tiempo;
    @Column(name = "FACTOR")
    private BigDecimal factor;
    @Column(name = "RANGO_MINIMO")
    private BigDecimal rangoMinimo;
    @Column(name = "RANGO_MAXIMO")
    private BigDecimal rangoMaximo;
    @Size(max = 1)
    @Column(name = "OPERADOR")
    private String operador;
    @Column(name = "CANTIDAD_MINIMA")
    private BigDecimal cantidadMinima;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "EMP_CODIGO")
    private String empCodigo;
    @Size(max = 3)
    @Column(name = "TIPO_HONORARIO")
    private String tipoHonorario;
    @Column(name = "MAXIMO_DESCUENTO")
    private BigDecimal maximoDescuento;
    @Size(max = 250)
    @Column(name = "NOMBRE_IESS")
    private String nombreIess;
    @Size(max = 50)
    @Column(name = "CODIGO_IESS")
    private String codigoIess;
    @Size(max = 1)
    @Column(name = "GOBIERNO")
    private String gobierno;
    @Size(max = 1)
    @Column(name = "ANESTESIA_IESS")
    private String anestesiaIess;
    @Size(max = 1)
    @Column(name = "IESS")
    private String iess;
    @JoinColumns({
        @JoinColumn(name = "DPR_ARA_CODIGO", referencedColumnName = "ARA_CODIGO"),
        @JoinColumn(name = "DPR_CODIGO", referencedColumnName = "CODIGO")})
    @ManyToOne
    private Departamentos departamentos;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cargos")
    private List<VariablesDeExamenes> variablesDeExamenesList;
    @OneToMany(mappedBy = "cargos")
    private List<TiposDeExamenes> tiposDeExamenesList;

    public Cargos() {
    }

    public Cargos(CargosPK cargosPK) {
        this.cargosPK = cargosPK;
    }

    public Cargos(CargosPK cargosPK, String descripcion, BigDecimal costo, BigDecimal iva, Character estadoDeDisponibilidad, Character costoModificable, Character equipoEspecial, String empCodigo) {
        this.cargosPK = cargosPK;
        this.descripcion = descripcion;
        this.costo = costo;
        this.iva = iva;
        this.estadoDeDisponibilidad = estadoDeDisponibilidad;
        this.costoModificable = costoModificable;
        this.equipoEspecial = equipoEspecial;
        this.empCodigo = empCodigo;
    }

    public Cargos(Character tipo, String codigo) {
        this.cargosPK = new CargosPK(tipo, codigo);
    }

    public CargosPK getCargosPK() {
        return cargosPK;
    }

    public void setCargosPK(CargosPK cargosPK) {
        this.cargosPK = cargosPK;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public BigDecimal getCosto() {
        return costo;
    }

    public void setCosto(BigDecimal costo) {
        this.costo = costo;
    }

    public BigDecimal getIva() {
        return iva;
    }

    public void setIva(BigDecimal iva) {
        this.iva = iva;
    }

    public Character getEstadoDeDisponibilidad() {
        return estadoDeDisponibilidad;
    }

    public void setEstadoDeDisponibilidad(Character estadoDeDisponibilidad) {
        this.estadoDeDisponibilidad = estadoDeDisponibilidad;
    }

    public Character getCostoModificable() {
        return costoModificable;
    }

    public void setCostoModificable(Character costoModificable) {
        this.costoModificable = costoModificable;
    }

    public Character getEquipoEspecial() {
        return equipoEspecial;
    }

    public void setEquipoEspecial(Character equipoEspecial) {
        this.equipoEspecial = equipoEspecial;
    }

    public String getAgrupadorContable() {
        return agrupadorContable;
    }

    public void setAgrupadorContable(String agrupadorContable) {
        this.agrupadorContable = agrupadorContable;
    }

    public String getAgrcntCodigo() {
        return agrcntCodigo;
    }

    public void setAgrcntCodigo(String agrcntCodigo) {
        this.agrcntCodigo = agrcntCodigo;
    }

    public String getAgrcntTipo() {
        return agrcntTipo;
    }

    public void setAgrcntTipo(String agrcntTipo) {
        this.agrcntTipo = agrcntTipo;
    }

    public Character getTiempo() {
        return tiempo;
    }

    public void setTiempo(Character tiempo) {
        this.tiempo = tiempo;
    }

    public BigDecimal getFactor() {
        return factor;
    }

    public void setFactor(BigDecimal factor) {
        this.factor = factor;
    }

    public BigDecimal getRangoMinimo() {
        return rangoMinimo;
    }

    public void setRangoMinimo(BigDecimal rangoMinimo) {
        this.rangoMinimo = rangoMinimo;
    }

    public BigDecimal getRangoMaximo() {
        return rangoMaximo;
    }

    public void setRangoMaximo(BigDecimal rangoMaximo) {
        this.rangoMaximo = rangoMaximo;
    }

    public String getOperador() {
        return operador;
    }

    public void setOperador(String operador) {
        this.operador = operador;
    }

    public BigDecimal getCantidadMinima() {
        return cantidadMinima;
    }

    public void setCantidadMinima(BigDecimal cantidadMinima) {
        this.cantidadMinima = cantidadMinima;
    }

    public String getEmpCodigo() {
        return empCodigo;
    }

    public void setEmpCodigo(String empCodigo) {
        this.empCodigo = empCodigo;
    }

    public String getTipoHonorario() {
        return tipoHonorario;
    }

    public void setTipoHonorario(String tipoHonorario) {
        this.tipoHonorario = tipoHonorario;
    }

    public BigDecimal getMaximoDescuento() {
        return maximoDescuento;
    }

    public void setMaximoDescuento(BigDecimal maximoDescuento) {
        this.maximoDescuento = maximoDescuento;
    }

    public String getNombreIess() {
        return nombreIess;
    }

    public void setNombreIess(String nombreIess) {
        this.nombreIess = nombreIess;
    }

    public String getCodigoIess() {
        return codigoIess;
    }

    public void setCodigoIess(String codigoIess) {
        this.codigoIess = codigoIess;
    }

    public String getGobierno() {
        return gobierno;
    }

    public void setGobierno(String gobierno) {
        this.gobierno = gobierno;
    }

    public String getAnestesiaIess() {
        return anestesiaIess;
    }

    public void setAnestesiaIess(String anestesiaIess) {
        this.anestesiaIess = anestesiaIess;
    }

    public String getIess() {
        return iess;
    }

    public void setIess(String iess) {
        this.iess = iess;
    }

    public Departamentos getDepartamentos() {
        return departamentos;
    }

    public void setDepartamentos(Departamentos departamentos) {
        this.departamentos = departamentos;
    }

    @XmlTransient
    public List<VariablesDeExamenes> getVariablesDeExamenesList() {
        return variablesDeExamenesList;
    }

    public void setVariablesDeExamenesList(List<VariablesDeExamenes> variablesDeExamenesList) {
        this.variablesDeExamenesList = variablesDeExamenesList;
    }

    @XmlTransient
    public List<TiposDeExamenes> getTiposDeExamenesList() {
        return tiposDeExamenesList;
    }

    public void setTiposDeExamenesList(List<TiposDeExamenes> tiposDeExamenesList) {
        this.tiposDeExamenesList = tiposDeExamenesList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cargosPK != null ? cargosPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cargos)) {
            return false;
        }
        Cargos other = (Cargos) object;
        if ((this.cargosPK == null && other.cargosPK != null) || (this.cargosPK != null && !this.cargosPK.equals(other.cargosPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Cargos[ cargosPK=" + cargosPK + " ]";
    }
    
}
