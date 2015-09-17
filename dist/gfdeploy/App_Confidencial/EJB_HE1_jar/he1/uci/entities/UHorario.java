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
@Table(name = "U_HORARIO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UHorario.findAll", query = "SELECT u FROM UHorario u"),
    @NamedQuery(name = "UHorario.findByHorId", query = "SELECT u FROM UHorario u WHERE u.horId = :horId"),
    @NamedQuery(name = "UHorario.findByHorFecha", query = "SELECT u FROM UHorario u WHERE u.horFecha = :horFecha"),
    @NamedQuery(name = "UHorario.findByHorUnimed", query = "SELECT u FROM UHorario u WHERE u.horUnimed = :horUnimed"),
    @NamedQuery(name = "UHorario.findByHor8", query = "SELECT u FROM UHorario u WHERE u.hor8 = :hor8"),
    @NamedQuery(name = "UHorario.findByHor9", query = "SELECT u FROM UHorario u WHERE u.hor9 = :hor9"),
    @NamedQuery(name = "UHorario.findByHor10", query = "SELECT u FROM UHorario u WHERE u.hor10 = :hor10"),
    @NamedQuery(name = "UHorario.findByHor11", query = "SELECT u FROM UHorario u WHERE u.hor11 = :hor11"),
    @NamedQuery(name = "UHorario.findByHor12", query = "SELECT u FROM UHorario u WHERE u.hor12 = :hor12"),
    @NamedQuery(name = "UHorario.findByHor13", query = "SELECT u FROM UHorario u WHERE u.hor13 = :hor13"),
    @NamedQuery(name = "UHorario.findByHor14", query = "SELECT u FROM UHorario u WHERE u.hor14 = :hor14"),
    @NamedQuery(name = "UHorario.findByHor15", query = "SELECT u FROM UHorario u WHERE u.hor15 = :hor15"),
    @NamedQuery(name = "UHorario.findByHor16", query = "SELECT u FROM UHorario u WHERE u.hor16 = :hor16"),
    @NamedQuery(name = "UHorario.findByHor17", query = "SELECT u FROM UHorario u WHERE u.hor17 = :hor17"),
    @NamedQuery(name = "UHorario.findByHor18", query = "SELECT u FROM UHorario u WHERE u.hor18 = :hor18"),
    @NamedQuery(name = "UHorario.findByHor19", query = "SELECT u FROM UHorario u WHERE u.hor19 = :hor19"),
    @NamedQuery(name = "UHorario.findByHor20", query = "SELECT u FROM UHorario u WHERE u.hor20 = :hor20"),
    @NamedQuery(name = "UHorario.findByHor21", query = "SELECT u FROM UHorario u WHERE u.hor21 = :hor21"),
    @NamedQuery(name = "UHorario.findByHor22", query = "SELECT u FROM UHorario u WHERE u.hor22 = :hor22"),
    @NamedQuery(name = "UHorario.findByHor23", query = "SELECT u FROM UHorario u WHERE u.hor23 = :hor23"),
    @NamedQuery(name = "UHorario.findByHor24", query = "SELECT u FROM UHorario u WHERE u.hor24 = :hor24"),
    @NamedQuery(name = "UHorario.findByHor1", query = "SELECT u FROM UHorario u WHERE u.hor1 = :hor1"),
    @NamedQuery(name = "UHorario.findByHor2", query = "SELECT u FROM UHorario u WHERE u.hor2 = :hor2"),
    @NamedQuery(name = "UHorario.findByHor3", query = "SELECT u FROM UHorario u WHERE u.hor3 = :hor3"),
    @NamedQuery(name = "UHorario.findByHor4", query = "SELECT u FROM UHorario u WHERE u.hor4 = :hor4"),
    @NamedQuery(name = "UHorario.findByHor5", query = "SELECT u FROM UHorario u WHERE u.hor5 = :hor5"),
    @NamedQuery(name = "UHorario.findByHor6", query = "SELECT u FROM UHorario u WHERE u.hor6 = :hor6"),
    @NamedQuery(name = "UHorario.findByHor7", query = "SELECT u FROM UHorario u WHERE u.hor7 = :hor7")})
public class UHorario implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "HOR_ID")
    private BigDecimal horId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "HOR_FECHA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date horFecha;
    @Size(max = 20)
    @Column(name = "HOR_UNIMED")
    private String horUnimed;
    @Size(max = 20)
    @Column(name = "HOR_8")
    private String hor8;
    @Size(max = 20)
    @Column(name = "HOR_9")
    private String hor9;
    @Size(max = 20)
    @Column(name = "HOR_10")
    private String hor10;
    @Size(max = 20)
    @Column(name = "HOR_11")
    private String hor11;
    @Size(max = 20)
    @Column(name = "HOR_12")
    private String hor12;
    @Size(max = 20)
    @Column(name = "HOR_13")
    private String hor13;
    @Size(max = 20)
    @Column(name = "HOR_14")
    private String hor14;
    @Size(max = 20)
    @Column(name = "HOR_15")
    private String hor15;
    @Size(max = 20)
    @Column(name = "HOR_16")
    private String hor16;
    @Size(max = 20)
    @Column(name = "HOR_17")
    private String hor17;
    @Size(max = 20)
    @Column(name = "HOR_18")
    private String hor18;
    @Size(max = 20)
    @Column(name = "HOR_19")
    private String hor19;
    @Size(max = 20)
    @Column(name = "HOR_20")
    private String hor20;
    @Size(max = 20)
    @Column(name = "HOR_21")
    private String hor21;
    @Size(max = 20)
    @Column(name = "HOR_22")
    private String hor22;
    @Size(max = 20)
    @Column(name = "HOR_23")
    private String hor23;
    @Size(max = 20)
    @Column(name = "HOR_24")
    private String hor24;
    @Size(max = 20)
    @Column(name = "HOR_1")
    private String hor1;
    @Size(max = 20)
    @Column(name = "HOR_2")
    private String hor2;
    @Size(max = 20)
    @Column(name = "HOR_3")
    private String hor3;
    @Size(max = 20)
    @Column(name = "HOR_4")
    private String hor4;
    @Size(max = 20)
    @Column(name = "HOR_5")
    private String hor5;
    @Size(max = 20)
    @Column(name = "HOR_6")
    private String hor6;
    @Size(max = 20)
    @Column(name = "HOR_7")
    private String hor7;
    @Size(max = 10)
    @Column(name = "HOR_TOT_AM")
    private String horTotAm;
    @Size(max = 10)
    @Column(name = "HOR_TOT_PM")
    private String horTotPm;
    @Size(max = 10)
    @Column(name = "HOR_TOT_HS")
    private String horTotHs;
    @Size(max = 10)
    @Column(name = "HOR_TOT_ING")
    private String horTotIng;
    @JoinColumn(name = "OPP_ID", referencedColumnName = "OPP_ID")
    @ManyToOne(optional = false)
    private UOpcionPaciente uOpcionPaciente;
    @JoinColumn(name = "OPC_ID", referencedColumnName = "OPC_ID")
    @ManyToOne(optional = false)
    private UOpciones uOpciones;

    public UHorario() {
    }

    public UHorario(BigDecimal horId) {
        this.horId = horId;
    }

    public UHorario(BigDecimal horId, Date horFecha) {
        this.horId = horId;
        this.horFecha = horFecha;
    }

    public BigDecimal getHorId() {
        return horId;
    }

    public void setHorId(BigDecimal horId) {
        this.horId = horId;
    }

    public Date getHorFecha() {
        return horFecha;
    }

    public void setHorFecha(Date horFecha) {
        this.horFecha = horFecha;
    }

    public String getHorUnimed() {
        return horUnimed;
    }

    public void setHorUnimed(String horUnimed) {
        this.horUnimed = horUnimed;
    }

    public String getHor8() {
        return hor8;
    }

    public void setHor8(String hor8) {
        this.hor8 = hor8;
    }

    public String getHor9() {
        return hor9;
    }

    public void setHor9(String hor9) {
        this.hor9 = hor9;
    }

    public String getHor10() {
        return hor10;
    }

    public void setHor10(String hor10) {
        this.hor10 = hor10;
    }

    public String getHor11() {
        return hor11;
    }

    public void setHor11(String hor11) {
        this.hor11 = hor11;
    }

    public String getHor12() {
        return hor12;
    }

    public void setHor12(String hor12) {
        this.hor12 = hor12;
    }

    public String getHor13() {
        return hor13;
    }

    public void setHor13(String hor13) {
        this.hor13 = hor13;
    }

    public String getHor14() {
        return hor14;
    }

    public void setHor14(String hor14) {
        this.hor14 = hor14;
    }

    public String getHor15() {
        return hor15;
    }

    public void setHor15(String hor15) {
        this.hor15 = hor15;
    }

    public String getHor16() {
        return hor16;
    }

    public void setHor16(String hor16) {
        this.hor16 = hor16;
    }

    public String getHor17() {
        return hor17;
    }

    public void setHor17(String hor17) {
        this.hor17 = hor17;
    }

    public String getHor18() {
        return hor18;
    }

    public void setHor18(String hor18) {
        this.hor18 = hor18;
    }

    public String getHor19() {
        return hor19;
    }

    public void setHor19(String hor19) {
        this.hor19 = hor19;
    }

    public String getHor20() {
        return hor20;
    }

    public void setHor20(String hor20) {
        this.hor20 = hor20;
    }

    public String getHor21() {
        return hor21;
    }

    public void setHor21(String hor21) {
        this.hor21 = hor21;
    }

    public String getHor22() {
        return hor22;
    }

    public void setHor22(String hor22) {
        this.hor22 = hor22;
    }

    public String getHor23() {
        return hor23;
    }

    public void setHor23(String hor23) {
        this.hor23 = hor23;
    }

    public String getHor24() {
        return hor24;
    }

    public void setHor24(String hor24) {
        this.hor24 = hor24;
    }

    public String getHor1() {
        return hor1;
    }

    public void setHor1(String hor1) {
        this.hor1 = hor1;
    }

    public String getHor2() {
        return hor2;
    }

    public void setHor2(String hor2) {
        this.hor2 = hor2;
    }

    public String getHor3() {
        return hor3;
    }

    public void setHor3(String hor3) {
        this.hor3 = hor3;
    }

    public String getHor4() {
        return hor4;
    }

    public void setHor4(String hor4) {
        this.hor4 = hor4;
    }

    public String getHor5() {
        return hor5;
    }

    public void setHor5(String hor5) {
        this.hor5 = hor5;
    }

    public String getHor6() {
        return hor6;
    }

    public void setHor6(String hor6) {
        this.hor6 = hor6;
    }

    public String getHor7() {
        return hor7;
    }

    public void setHor7(String hor7) {
        this.hor7 = hor7;
    }

    public String getHorTotAm() {
        return horTotAm;
    }

    public void setHorTotAm(String horTotAm) {
        this.horTotAm = horTotAm;
    }

    public String getHorTotPm() {
        return horTotPm;
    }

    public void setHorTotPm(String horTotPm) {
        this.horTotPm = horTotPm;
    }

    public String getHorTotHs() {
        return horTotHs;
    }

    public void setHorTotHs(String horTotHs) {
        this.horTotHs = horTotHs;
    }

    public String getHorTotIng() {
        return horTotIng;
    }

    public void setHorTotIng(String horTotIng) {
        this.horTotIng = horTotIng;
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
        hash += (horId != null ? horId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UHorario)) {
            return false;
        }
        UHorario other = (UHorario) object;
        if ((this.horId == null && other.horId != null) || (this.horId != null && !this.horId.equals(other.horId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "he1.uci.entities.UHorario[ horId=" + horId + " ]";
    }

}
