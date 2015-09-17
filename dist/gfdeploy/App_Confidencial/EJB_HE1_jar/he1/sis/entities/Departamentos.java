/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package he1.sis.entities;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
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
@Table(name = "DEPARTAMENTOS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Departamentos.findAll", query = "SELECT d FROM Departamentos d"),
    @NamedQuery(name = "Departamentos.findByAraCodigo", query = "SELECT d FROM Departamentos d WHERE d.departamentosPK.araCodigo = :araCodigo"),
    @NamedQuery(name = "Departamentos.findByCodigo", query = "SELECT d FROM Departamentos d WHERE d.departamentosPK.codigo = :codigo"),
    @NamedQuery(name = "Departamentos.findByNombre", query = "SELECT d FROM Departamentos d WHERE d.nombre = :nombre"),
    @NamedQuery(name = "Departamentos.findByCargable", query = "SELECT d FROM Departamentos d WHERE d.cargable = :cargable"),
    @NamedQuery(name = "Departamentos.findByEstadoDeDisponibilidad", query = "SELECT d FROM Departamentos d WHERE d.estadoDeDisponibilidad = :estadoDeDisponibilidad"),
    @NamedQuery(name = "Departamentos.findByBodega", query = "SELECT d FROM Departamentos d WHERE d.bodega = :bodega"),
    @NamedQuery(name = "Departamentos.findByDiasCalculoStock", query = "SELECT d FROM Departamentos d WHERE d.diasCalculoStock = :diasCalculoStock"),
    @NamedQuery(name = "Departamentos.findByDiasStockMinimo", query = "SELECT d FROM Departamentos d WHERE d.diasStockMinimo = :diasStockMinimo"),
    @NamedQuery(name = "Departamentos.findByDiasStockMaximo", query = "SELECT d FROM Departamentos d WHERE d.diasStockMaximo = :diasStockMaximo"),
    @NamedQuery(name = "Departamentos.findByPrdCodigo", query = "SELECT d FROM Departamentos d WHERE d.prdCodigo = :prdCodigo"),
    @NamedQuery(name = "Departamentos.findByOrigen", query = "SELECT d FROM Departamentos d WHERE d.origen = :origen"),
    @NamedQuery(name = "Departamentos.findByCalcularStockTotal", query = "SELECT d FROM Departamentos d WHERE d.calcularStockTotal = :calcularStockTotal"),
    @NamedQuery(name = "Departamentos.findByMtvCodigo", query = "SELECT d FROM Departamentos d WHERE d.mtvCodigo = :mtvCodigo"),
    @NamedQuery(name = "Departamentos.findBySobrestock", query = "SELECT d FROM Departamentos d WHERE d.sobrestock = :sobrestock"),
    @NamedQuery(name = "Departamentos.findByLocalizacion", query = "SELECT d FROM Departamentos d WHERE d.localizacion = :localizacion"),
    @NamedQuery(name = "Departamentos.findByPrcInicial", query = "SELECT d FROM Departamentos d WHERE d.prcInicial = :prcInicial"),
    @NamedQuery(name = "Departamentos.findByPrcSubsecuente", query = "SELECT d FROM Departamentos d WHERE d.prcSubsecuente = :prcSubsecuente")})
public class Departamentos implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected DepartamentosPK departamentosPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "NOMBRE")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CARGABLE")
    private Character cargable;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ESTADO_DE_DISPONIBILIDAD")
    private Character estadoDeDisponibilidad;
    @Basic(optional = false)
    @NotNull
    @Column(name = "BODEGA")
    private Character bodega;
    @Column(name = "DIAS_CALCULO_STOCK")
    private BigInteger diasCalculoStock;
    @Column(name = "DIAS_STOCK_MINIMO")
    private BigInteger diasStockMinimo;
    @Column(name = "DIAS_STOCK_MAXIMO")
    private BigInteger diasStockMaximo;
    @Column(name = "PRD_CODIGO")
    private BigInteger prdCodigo;
    @Size(max = 1)
    @Column(name = "ORIGEN")
    private String origen;
    @Size(max = 1)
    @Column(name = "CALCULAR_STOCK_TOTAL")
    private String calcularStockTotal;
    @Size(max = 2)
    @Column(name = "MTV_CODIGO")
    private String mtvCodigo;
    @Size(max = 2)
    @Column(name = "SOBRESTOCK")
    private String sobrestock;
    @Size(max = 64)
    @Column(name = "LOCALIZACION")
    private String localizacion;
    @Column(name = "PRC_INICIAL")
    private Short prcInicial;
    @Column(name = "PRC_SUBSECUENTE")
    private Short prcSubsecuente;
    @OneToMany(mappedBy = "departamentos")
    private List<Cargos> cargosList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "departamentos")
    private List<VariablesDeExamenes> variablesDeExamenesList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "departamentos")
    private List<TiposDeExamenes> tiposDeExamenesList;

    public Departamentos() {
    }

    public Departamentos(DepartamentosPK departamentosPK) {
        this.departamentosPK = departamentosPK;
    }

    public Departamentos(DepartamentosPK departamentosPK, String nombre, Character cargable, Character estadoDeDisponibilidad, Character bodega) {
        this.departamentosPK = departamentosPK;
        this.nombre = nombre;
        this.cargable = cargable;
        this.estadoDeDisponibilidad = estadoDeDisponibilidad;
        this.bodega = bodega;
    }

    public Departamentos(String araCodigo, String codigo) {
        this.departamentosPK = new DepartamentosPK(araCodigo, codigo);
    }

    public DepartamentosPK getDepartamentosPK() {
        return departamentosPK;
    }

    public void setDepartamentosPK(DepartamentosPK departamentosPK) {
        this.departamentosPK = departamentosPK;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Character getCargable() {
        return cargable;
    }

    public void setCargable(Character cargable) {
        this.cargable = cargable;
    }

    public Character getEstadoDeDisponibilidad() {
        return estadoDeDisponibilidad;
    }

    public void setEstadoDeDisponibilidad(Character estadoDeDisponibilidad) {
        this.estadoDeDisponibilidad = estadoDeDisponibilidad;
    }

    public Character getBodega() {
        return bodega;
    }

    public void setBodega(Character bodega) {
        this.bodega = bodega;
    }

    public BigInteger getDiasCalculoStock() {
        return diasCalculoStock;
    }

    public void setDiasCalculoStock(BigInteger diasCalculoStock) {
        this.diasCalculoStock = diasCalculoStock;
    }

    public BigInteger getDiasStockMinimo() {
        return diasStockMinimo;
    }

    public void setDiasStockMinimo(BigInteger diasStockMinimo) {
        this.diasStockMinimo = diasStockMinimo;
    }

    public BigInteger getDiasStockMaximo() {
        return diasStockMaximo;
    }

    public void setDiasStockMaximo(BigInteger diasStockMaximo) {
        this.diasStockMaximo = diasStockMaximo;
    }

    public BigInteger getPrdCodigo() {
        return prdCodigo;
    }

    public void setPrdCodigo(BigInteger prdCodigo) {
        this.prdCodigo = prdCodigo;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getCalcularStockTotal() {
        return calcularStockTotal;
    }

    public void setCalcularStockTotal(String calcularStockTotal) {
        this.calcularStockTotal = calcularStockTotal;
    }

    public String getMtvCodigo() {
        return mtvCodigo;
    }

    public void setMtvCodigo(String mtvCodigo) {
        this.mtvCodigo = mtvCodigo;
    }

    public String getSobrestock() {
        return sobrestock;
    }

    public void setSobrestock(String sobrestock) {
        this.sobrestock = sobrestock;
    }

    public String getLocalizacion() {
        return localizacion;
    }

    public void setLocalizacion(String localizacion) {
        this.localizacion = localizacion;
    }

    public Short getPrcInicial() {
        return prcInicial;
    }

    public void setPrcInicial(Short prcInicial) {
        this.prcInicial = prcInicial;
    }

    public Short getPrcSubsecuente() {
        return prcSubsecuente;
    }

    public void setPrcSubsecuente(Short prcSubsecuente) {
        this.prcSubsecuente = prcSubsecuente;
    }

    @XmlTransient
    public List<Cargos> getCargosList() {
        return cargosList;
    }

    public void setCargosList(List<Cargos> cargosList) {
        this.cargosList = cargosList;
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
        hash += (departamentosPK != null ? departamentosPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Departamentos)) {
            return false;
        }
        Departamentos other = (Departamentos) object;
        if ((this.departamentosPK == null && other.departamentosPK != null) || (this.departamentosPK != null && !this.departamentosPK.equals(other.departamentosPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Departamentos[ departamentosPK=" + departamentosPK + " ]";
    }
    
}
