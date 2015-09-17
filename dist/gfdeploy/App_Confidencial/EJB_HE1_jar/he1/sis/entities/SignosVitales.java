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
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author luis_guanoluiza
 */
@Entity
@Table(name = "SIGNOS_VITALES")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SignosVitales.findAll", query = "SELECT s FROM SignosVitales s"),
    @NamedQuery(name = "SignosVitales.findByHjaevlNumero", query = "SELECT s FROM SignosVitales s WHERE s.signosVitalesPK.hjaevlNumero = :hjaevlNumero"),
    @NamedQuery(name = "SignosVitales.findByFecha", query = "SELECT s FROM SignosVitales s WHERE s.signosVitalesPK.fecha = :fecha"),
    @NamedQuery(name = "SignosVitales.findByPresionArterialSistolica", query = "SELECT s FROM SignosVitales s WHERE s.presionArterialSistolica = :presionArterialSistolica"),
    @NamedQuery(name = "SignosVitales.findByPresionArterialDiastolica", query = "SELECT s FROM SignosVitales s WHERE s.presionArterialDiastolica = :presionArterialDiastolica"),
    @NamedQuery(name = "SignosVitales.findByPulso", query = "SELECT s FROM SignosVitales s WHERE s.pulso = :pulso"),
    @NamedQuery(name = "SignosVitales.findByFrecuenciaCardiaca", query = "SELECT s FROM SignosVitales s WHERE s.frecuenciaCardiaca = :frecuenciaCardiaca"),
    @NamedQuery(name = "SignosVitales.findByFrecuenciaRespiratoria", query = "SELECT s FROM SignosVitales s WHERE s.frecuenciaRespiratoria = :frecuenciaRespiratoria"),
    @NamedQuery(name = "SignosVitales.findByTemperaturaBucal", query = "SELECT s FROM SignosVitales s WHERE s.temperaturaBucal = :temperaturaBucal"),
    @NamedQuery(name = "SignosVitales.findByTemperaturaAxilar", query = "SELECT s FROM SignosVitales s WHERE s.temperaturaAxilar = :temperaturaAxilar"),
    @NamedQuery(name = "SignosVitales.findByPeso", query = "SELECT s FROM SignosVitales s WHERE s.peso = :peso"),
    @NamedQuery(name = "SignosVitales.findByTalla", query = "SELECT s FROM SignosVitales s WHERE s.talla = :talla"),
    @NamedQuery(name = "SignosVitales.findByPerimetroCefalico", query = "SELECT s FROM SignosVitales s WHERE s.perimetroCefalico = :perimetroCefalico"),
    @NamedQuery(name = "SignosVitales.findByImc", query = "SELECT s FROM SignosVitales s WHERE s.imc = :imc"),
    @NamedQuery(name = "SignosVitales.findByCinturaAbdominal", query = "SELECT s FROM SignosVitales s WHERE s.cinturaAbdominal = :cinturaAbdominal"),
    @NamedQuery(name = "SignosVitales.findByOcular", query = "SELECT s FROM SignosVitales s WHERE s.ocular = :ocular"),
    @NamedQuery(name = "SignosVitales.findByVerbal", query = "SELECT s FROM SignosVitales s WHERE s.verbal = :verbal"),
    @NamedQuery(name = "SignosVitales.findByMotora", query = "SELECT s FROM SignosVitales s WHERE s.motora = :motora"),
    @NamedQuery(name = "SignosVitales.findByReaccionPupilaDerecha", query = "SELECT s FROM SignosVitales s WHERE s.reaccionPupilaDerecha = :reaccionPupilaDerecha"),
    @NamedQuery(name = "SignosVitales.findByReaccionPupilaIzquierda", query = "SELECT s FROM SignosVitales s WHERE s.reaccionPupilaIzquierda = :reaccionPupilaIzquierda"),
    @NamedQuery(name = "SignosVitales.findByTiempoLlenadoCapilar", query = "SELECT s FROM SignosVitales s WHERE s.tiempoLlenadoCapilar = :tiempoLlenadoCapilar"),
    @NamedQuery(name = "SignosVitales.findBySaturacionOxigeno", query = "SELECT s FROM SignosVitales s WHERE s.saturacionOxigeno = :saturacionOxigeno"),
    @NamedQuery(name = "SignosVitales.findByObservaciones", query = "SELECT s FROM SignosVitales s WHERE s.observaciones = :observaciones")})
public class SignosVitales implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected SignosVitalesPK signosVitalesPK;
    @Column(name = "PRESION_ARTERIAL_SISTOLICA")
    private Short presionArterialSistolica;
    @Column(name = "PRESION_ARTERIAL_DIASTOLICA")
    private Short presionArterialDiastolica;
    @Column(name = "PULSO")
    private Short pulso;
    @Column(name = "FRECUENCIA_CARDIACA")
    private Short frecuenciaCardiaca;
    @Column(name = "FRECUENCIA_RESPIRATORIA")
    private Short frecuenciaRespiratoria;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "TEMPERATURA_BUCAL")
    private BigDecimal temperaturaBucal;
    @Column(name = "TEMPERATURA_AXILAR")
    private BigDecimal temperaturaAxilar;
    @Column(name = "PESO")
    private BigDecimal peso;
    @Column(name = "TALLA")
    private Short talla;
    @Column(name = "PERIMETRO_CEFALICO")
    private Short perimetroCefalico;
    @Column(name = "IMC")
    private Short imc;
    @Column(name = "CINTURA_ABDOMINAL")
    private Integer cinturaAbdominal;
    @Column(name = "OCULAR")
    private Short ocular;
    @Column(name = "VERBAL")
    private Short verbal;
    @Column(name = "MOTORA")
    private Short motora;
    @Column(name = "REACCION_PUPILA_DERECHA")
    private Character reaccionPupilaDerecha;
    @Column(name = "REACCION_PUPILA_IZQUIERDA")
    private Character reaccionPupilaIzquierda;
    @Column(name = "TIEMPO_LLENADO_CAPILAR")
    private Short tiempoLlenadoCapilar;
    @Column(name = "SATURACION_OXIGENO")
    private Short saturacionOxigeno;
    @Size(max = 100)
    @Column(name = "OBSERVACIONES")
    private String observaciones;
    @JoinColumn(name = "PCN_NUMERO_HC", referencedColumnName = "NUMERO_HC")
    @ManyToOne(optional = false)
    private Pacientes pacientes;
    @JoinColumn(name = "HJAEVL_NUMERO", referencedColumnName = "NUMERO", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private HojasDeEvolucion hojasDeEvolucion;

    public SignosVitales() {
    }

    public SignosVitales(SignosVitalesPK signosVitalesPK) {
        this.signosVitalesPK = signosVitalesPK;
    }

    public SignosVitales(BigInteger hjaevlNumero, Date fecha) {
        this.signosVitalesPK = new SignosVitalesPK(hjaevlNumero, fecha);
    }

    public SignosVitalesPK getSignosVitalesPK() {
        return signosVitalesPK;
    }

    public void setSignosVitalesPK(SignosVitalesPK signosVitalesPK) {
        this.signosVitalesPK = signosVitalesPK;
    }

    public Short getPresionArterialSistolica() {
        return presionArterialSistolica;
    }

    public void setPresionArterialSistolica(Short presionArterialSistolica) {
        this.presionArterialSistolica = presionArterialSistolica;
    }

    public Short getPresionArterialDiastolica() {
        return presionArterialDiastolica;
    }

    public void setPresionArterialDiastolica(Short presionArterialDiastolica) {
        this.presionArterialDiastolica = presionArterialDiastolica;
    }

    public Short getPulso() {
        return pulso;
    }

    public void setPulso(Short pulso) {
        this.pulso = pulso;
    }

    public Short getFrecuenciaCardiaca() {
        return frecuenciaCardiaca;
    }

    public void setFrecuenciaCardiaca(Short frecuenciaCardiaca) {
        this.frecuenciaCardiaca = frecuenciaCardiaca;
    }

    public Short getFrecuenciaRespiratoria() {
        return frecuenciaRespiratoria;
    }

    public void setFrecuenciaRespiratoria(Short frecuenciaRespiratoria) {
        this.frecuenciaRespiratoria = frecuenciaRespiratoria;
    }

    public BigDecimal getTemperaturaBucal() {
        return temperaturaBucal;
    }

    public void setTemperaturaBucal(BigDecimal temperaturaBucal) {
        this.temperaturaBucal = temperaturaBucal;
    }

    public BigDecimal getTemperaturaAxilar() {
        return temperaturaAxilar;
    }

    public void setTemperaturaAxilar(BigDecimal temperaturaAxilar) {
        this.temperaturaAxilar = temperaturaAxilar;
    }

    public BigDecimal getPeso() {
        return peso;
    }

    public void setPeso(BigDecimal peso) {
        this.peso = peso;
    }

    public Short getTalla() {
        return talla;
    }

    public void setTalla(Short talla) {
        this.talla = talla;
    }

    public Short getPerimetroCefalico() {
        return perimetroCefalico;
    }

    public void setPerimetroCefalico(Short perimetroCefalico) {
        this.perimetroCefalico = perimetroCefalico;
    }

    public Short getImc() {
        return imc;
    }

    public void setImc(Short imc) {
        this.imc = imc;
    }

    public Integer getCinturaAbdominal() {
        return cinturaAbdominal;
    }

    public void setCinturaAbdominal(Integer cinturaAbdominal) {
        this.cinturaAbdominal = cinturaAbdominal;
    }

    public Short getOcular() {
        return ocular;
    }

    public void setOcular(Short ocular) {
        this.ocular = ocular;
    }

    public Short getVerbal() {
        return verbal;
    }

    public void setVerbal(Short verbal) {
        this.verbal = verbal;
    }

    public Short getMotora() {
        return motora;
    }

    public void setMotora(Short motora) {
        this.motora = motora;
    }

    public Character getReaccionPupilaDerecha() {
        return reaccionPupilaDerecha;
    }

    public void setReaccionPupilaDerecha(Character reaccionPupilaDerecha) {
        this.reaccionPupilaDerecha = reaccionPupilaDerecha;
    }

    public Character getReaccionPupilaIzquierda() {
        return reaccionPupilaIzquierda;
    }

    public void setReaccionPupilaIzquierda(Character reaccionPupilaIzquierda) {
        this.reaccionPupilaIzquierda = reaccionPupilaIzquierda;
    }

    public Short getTiempoLlenadoCapilar() {
        return tiempoLlenadoCapilar;
    }

    public void setTiempoLlenadoCapilar(Short tiempoLlenadoCapilar) {
        this.tiempoLlenadoCapilar = tiempoLlenadoCapilar;
    }

    public Short getSaturacionOxigeno() {
        return saturacionOxigeno;
    }

    public void setSaturacionOxigeno(Short saturacionOxigeno) {
        this.saturacionOxigeno = saturacionOxigeno;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public Pacientes getPacientes() {
        return pacientes;
    }

    public void setPacientes(Pacientes pacientes) {
        this.pacientes = pacientes;
    }

    public HojasDeEvolucion getHojasDeEvolucion() {
        return hojasDeEvolucion;
    }

    public void setHojasDeEvolucion(HojasDeEvolucion hojasDeEvolucion) {
        this.hojasDeEvolucion = hojasDeEvolucion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (signosVitalesPK != null ? signosVitalesPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SignosVitales)) {
            return false;
        }
        SignosVitales other = (SignosVitales) object;
        if ((this.signosVitalesPK == null && other.signosVitalesPK != null) || (this.signosVitalesPK != null && !this.signosVitalesPK.equals(other.signosVitalesPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "he1.entities.SignosVitales[ signosVitalesPK=" + signosVitalesPK + " ]";
    }
    
}
