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
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
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
@Table(name = "DIURESIS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Diuresis.findAll", query = "SELECT d FROM Diuresis d"),
    @NamedQuery(name = "Diuresis.findByPrmatnNumero", query = "SELECT d FROM Diuresis d WHERE d.diuresisPK.prmatnNumero = :prmatnNumero"),
    @NamedQuery(name = "Diuresis.findByPrmatnPcnNumeroHc", query = "SELECT d FROM Diuresis d WHERE d.diuresisPK.prmatnPcnNumeroHc = :prmatnPcnNumeroHc"),
    @NamedQuery(name = "Diuresis.findByNumero", query = "SELECT d FROM Diuresis d WHERE d.diuresisPK.numero = :numero"),
    @NamedQuery(name = "Diuresis.findByFecha", query = "SELECT d FROM Diuresis d WHERE d.fecha = :fecha"),
    @NamedQuery(name = "Diuresis.findByFechaDeRegistro", query = "SELECT d FROM Diuresis d WHERE d.fechaDeRegistro = :fechaDeRegistro"),
    @NamedQuery(name = "Diuresis.findByTemperatura", query = "SELECT d FROM Diuresis d WHERE d.temperatura = :temperatura"),
    @NamedQuery(name = "Diuresis.findByPulso", query = "SELECT d FROM Diuresis d WHERE d.pulso = :pulso"),
    @NamedQuery(name = "Diuresis.findByRespiracion", query = "SELECT d FROM Diuresis d WHERE d.respiracion = :respiracion"),
    @NamedQuery(name = "Diuresis.findByPresionArterial1", query = "SELECT d FROM Diuresis d WHERE d.presionArterial1 = :presionArterial1"),
    @NamedQuery(name = "Diuresis.findByPresionArterial2", query = "SELECT d FROM Diuresis d WHERE d.presionArterial2 = :presionArterial2"),
    @NamedQuery(name = "Diuresis.findBySaturacionDeAgua", query = "SELECT d FROM Diuresis d WHERE d.saturacionDeAgua = :saturacionDeAgua"),
    @NamedQuery(name = "Diuresis.findByPresionVenosaCentral", query = "SELECT d FROM Diuresis d WHERE d.presionVenosaCentral = :presionVenosaCentral"),
    @NamedQuery(name = "Diuresis.findByGlicemiaCapilar", query = "SELECT d FROM Diuresis d WHERE d.glicemiaCapilar = :glicemiaCapilar"),
    @NamedQuery(name = "Diuresis.findByDiuresisHoraria", query = "SELECT d FROM Diuresis d WHERE d.diuresisHoraria = :diuresisHoraria"),
    @NamedQuery(name = "Diuresis.findByPerdidaInsensible", query = "SELECT d FROM Diuresis d WHERE d.perdidaInsensible = :perdidaInsensible"),
    @NamedQuery(name = "Diuresis.findByPenrose", query = "SELECT d FROM Diuresis d WHERE d.penrose = :penrose"),
    @NamedQuery(name = "Diuresis.findBySondas", query = "SELECT d FROM Diuresis d WHERE d.sondas = :sondas"),
    @NamedQuery(name = "Diuresis.findByHemovac", query = "SELECT d FROM Diuresis d WHERE d.hemovac = :hemovac"),
    @NamedQuery(name = "Diuresis.findByOtros", query = "SELECT d FROM Diuresis d WHERE d.otros = :otros"),
    @NamedQuery(name = "Diuresis.findByObservaciones", query = "SELECT d FROM Diuresis d WHERE d.observaciones = :observaciones"),
    @NamedQuery(name = "Diuresis.findByPresionMedia", query = "SELECT d FROM Diuresis d WHERE d.presionMedia = :presionMedia"),
    @NamedQuery(name = "Diuresis.findByConcentracionOxigeno", query = "SELECT d FROM Diuresis d WHERE d.concentracionOxigeno = :concentracionOxigeno"),
    @NamedQuery(name = "Diuresis.findByEscalaDeGlasgow", query = "SELECT d FROM Diuresis d WHERE d.escalaDeGlasgow = :escalaDeGlasgow"),
    @NamedQuery(name = "Diuresis.findByPerimetroAbdominal", query = "SELECT d FROM Diuresis d WHERE d.perimetroAbdominal = :perimetroAbdominal"),
    @NamedQuery(name = "Diuresis.findBySignosDeTroussean", query = "SELECT d FROM Diuresis d WHERE d.signosDeTroussean = :signosDeTroussean")})
public class Diuresis implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected DiuresisPK diuresisPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @Column(name = "FECHA_DE_REGISTRO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaDeRegistro;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "TEMPERATURA")
    private BigDecimal temperatura;
    @Column(name = "PULSO")
    private Short pulso;
    @Column(name = "RESPIRACION")
    private Short respiracion;
    @Column(name = "PRESION_ARTERIAL1")
    private Short presionArterial1;
    @Column(name = "PRESION_ARTERIAL2")
    private Short presionArterial2;
    @Column(name = "SATURACION_DE_AGUA")
    private BigDecimal saturacionDeAgua;
    @Column(name = "PRESION_VENOSA_CENTRAL")
    private Short presionVenosaCentral;
    @Column(name = "GLICEMIA_CAPILAR")
    private Short glicemiaCapilar;
    @Column(name = "DIURESIS_HORARIA")
    private Short diuresisHoraria;
    @Column(name = "PERDIDA_INSENSIBLE")
    private Short perdidaInsensible;
    @Column(name = "PENROSE")
    private Short penrose;
    @Column(name = "SONDAS")
    private Short sondas;
    @Column(name = "HEMOVAC")
    private Short hemovac;
    @Column(name = "OTROS")
    private Short otros;
    @Size(max = 500)
    @Column(name = "OBSERVACIONES")
    private String observaciones;
    @Column(name = "PRESION_MEDIA")
    private BigDecimal presionMedia;
    @Column(name = "CONCENTRACION_OXIGENO")
    private Short concentracionOxigeno;
    @Size(max = 8)
    @Column(name = "ESCALA_DE_GLASGOW")
    private String escalaDeGlasgow;
    @Column(name = "PERIMETRO_ABDOMINAL")
    private BigInteger perimetroAbdominal;
    @Size(max = 1)
    @Column(name = "SIGNOS_DE_TROUSSEAN")
    private String signosDeTroussean;
    @JoinColumn(name = "PRS_CODIGO", referencedColumnName = "CODIGO")
    @ManyToOne(optional = false)
    private Personal personal;
    @JoinColumns({
        @JoinColumn(name = "PRMATN_NUMERO", referencedColumnName = "NUMERO", insertable = false, updatable = false),
        @JoinColumn(name = "PRMATN_PCN_NUMERO_HC", referencedColumnName = "PCN_NUMERO_HC", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private PermanenciasYAtenciones permanenciasYAtenciones;
    @JoinColumns({
        @JoinColumn(name = "DPR_ARA_CODIGO", referencedColumnName = "ARA_CODIGO"),
        @JoinColumn(name = "DPR_CODIGO", referencedColumnName = "CODIGO")})
    @ManyToOne(optional = false)
    private Departamentos departamentos;

    public Diuresis() {
    }

    public Diuresis(DiuresisPK diuresisPK) {
        this.diuresisPK = diuresisPK;
    }

    public Diuresis(DiuresisPK diuresisPK, Date fecha) {
        this.diuresisPK = diuresisPK;
        this.fecha = fecha;
    }

    public Diuresis(int prmatnNumero, int prmatnPcnNumeroHc, short numero) {
        this.diuresisPK = new DiuresisPK(prmatnNumero, prmatnPcnNumeroHc, numero);
    }

    public DiuresisPK getDiuresisPK() {
        return diuresisPK;
    }

    public void setDiuresisPK(DiuresisPK diuresisPK) {
        this.diuresisPK = diuresisPK;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Date getFechaDeRegistro() {
        return fechaDeRegistro;
    }

    public void setFechaDeRegistro(Date fechaDeRegistro) {
        this.fechaDeRegistro = fechaDeRegistro;
    }

    public BigDecimal getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(BigDecimal temperatura) {
        this.temperatura = temperatura;
    }

    public Short getPulso() {
        return pulso;
    }

    public void setPulso(Short pulso) {
        this.pulso = pulso;
    }

    public Short getRespiracion() {
        return respiracion;
    }

    public void setRespiracion(Short respiracion) {
        this.respiracion = respiracion;
    }

    public Short getPresionArterial1() {
        return presionArterial1;
    }

    public void setPresionArterial1(Short presionArterial1) {
        this.presionArterial1 = presionArterial1;
    }

    public Short getPresionArterial2() {
        return presionArterial2;
    }

    public void setPresionArterial2(Short presionArterial2) {
        this.presionArterial2 = presionArterial2;
    }

    public BigDecimal getSaturacionDeAgua() {
        return saturacionDeAgua;
    }

    public void setSaturacionDeAgua(BigDecimal saturacionDeAgua) {
        this.saturacionDeAgua = saturacionDeAgua;
    }

    public Short getPresionVenosaCentral() {
        return presionVenosaCentral;
    }

    public void setPresionVenosaCentral(Short presionVenosaCentral) {
        this.presionVenosaCentral = presionVenosaCentral;
    }

    public Short getGlicemiaCapilar() {
        return glicemiaCapilar;
    }

    public void setGlicemiaCapilar(Short glicemiaCapilar) {
        this.glicemiaCapilar = glicemiaCapilar;
    }

    public Short getDiuresisHoraria() {
        return diuresisHoraria;
    }

    public void setDiuresisHoraria(Short diuresisHoraria) {
        this.diuresisHoraria = diuresisHoraria;
    }

    public Short getPerdidaInsensible() {
        return perdidaInsensible;
    }

    public void setPerdidaInsensible(Short perdidaInsensible) {
        this.perdidaInsensible = perdidaInsensible;
    }

    public Short getPenrose() {
        return penrose;
    }

    public void setPenrose(Short penrose) {
        this.penrose = penrose;
    }

    public Short getSondas() {
        return sondas;
    }

    public void setSondas(Short sondas) {
        this.sondas = sondas;
    }

    public Short getHemovac() {
        return hemovac;
    }

    public void setHemovac(Short hemovac) {
        this.hemovac = hemovac;
    }

    public Short getOtros() {
        return otros;
    }

    public void setOtros(Short otros) {
        this.otros = otros;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public BigDecimal getPresionMedia() {
        return presionMedia;
    }

    public void setPresionMedia(BigDecimal presionMedia) {
        this.presionMedia = presionMedia;
    }

    public Short getConcentracionOxigeno() {
        return concentracionOxigeno;
    }

    public void setConcentracionOxigeno(Short concentracionOxigeno) {
        this.concentracionOxigeno = concentracionOxigeno;
    }

    public String getEscalaDeGlasgow() {
        return escalaDeGlasgow;
    }

    public void setEscalaDeGlasgow(String escalaDeGlasgow) {
        this.escalaDeGlasgow = escalaDeGlasgow;
    }

    public BigInteger getPerimetroAbdominal() {
        return perimetroAbdominal;
    }

    public void setPerimetroAbdominal(BigInteger perimetroAbdominal) {
        this.perimetroAbdominal = perimetroAbdominal;
    }

    public String getSignosDeTroussean() {
        return signosDeTroussean;
    }

    public void setSignosDeTroussean(String signosDeTroussean) {
        this.signosDeTroussean = signosDeTroussean;
    }

    public Personal getPersonal() {
        return personal;
    }

    public void setPersonal(Personal personal) {
        this.personal = personal;
    }

    public PermanenciasYAtenciones getPermanenciasYAtenciones() {
        return permanenciasYAtenciones;
    }

    public void setPermanenciasYAtenciones(PermanenciasYAtenciones permanenciasYAtenciones) {
        this.permanenciasYAtenciones = permanenciasYAtenciones;
    }

    public Departamentos getDepartamentos() {
        return departamentos;
    }

    public void setDepartamentos(Departamentos departamentos) {
        this.departamentos = departamentos;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (diuresisPK != null ? diuresisPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Diuresis)) {
            return false;
        }
        Diuresis other = (Diuresis) object;
        if ((this.diuresisPK == null && other.diuresisPK != null) || (this.diuresisPK != null && !this.diuresisPK.equals(other.diuresisPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "he1.sis.entities.Diuresis[ diuresisPK=" + diuresisPK + " ]";
    }
    
}
