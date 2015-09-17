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
@Table(name = "U_HORARIO_INGESTA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UHorarioIngesta.findAll", query = "SELECT u FROM UHorarioIngesta u"),
    @NamedQuery(name = "UHorarioIngesta.findByHriId", query = "SELECT u FROM UHorarioIngesta u WHERE u.hriId = :hriId"),
    @NamedQuery(name = "UHorarioIngesta.findByHriFecha", query = "SELECT u FROM UHorarioIngesta u WHERE u.hriFecha = :hriFecha"),
    @NamedQuery(name = "UHorarioIngesta.findByHriUnimed", query = "SELECT u FROM UHorarioIngesta u WHERE u.hriUnimed = :hriUnimed"),
    @NamedQuery(name = "UHorarioIngesta.findByHriTotAm", query = "SELECT u FROM UHorarioIngesta u WHERE u.hriTotAm = :hriTotAm"),
    @NamedQuery(name = "UHorarioIngesta.findByHriTotPm", query = "SELECT u FROM UHorarioIngesta u WHERE u.hriTotPm = :hriTotPm"),
    @NamedQuery(name = "UHorarioIngesta.findByHriTotHs", query = "SELECT u FROM UHorarioIngesta u WHERE u.hriTotHs = :hriTotHs"),
    @NamedQuery(name = "UHorarioIngesta.findByHriTotIng", query = "SELECT u FROM UHorarioIngesta u WHERE u.hriTotIng = :hriTotIng")})
public class UHorarioIngesta implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "HRI_ID")
    private BigDecimal hriId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "HRI_FECHA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date hriFecha;
    @Size(max = 20)
    @Column(name = "HRI_UNIMED")
    private String hriUnimed;
    @Size(max = 20)
    @Column(name = "HRI_8")
    private String hri8;
    @Size(max = 20)
    @Column(name = "HRI_9")
    private String hri9;
    @Size(max = 20)
    @Column(name = "HRI_10")
    private String hri10;
    @Size(max = 20)
    @Column(name = "HRI_11")
    private String hri11;
    @Size(max = 20)
    @Column(name = "HRI_12")
    private String hri12;
    @Size(max = 20)
    @Column(name = "HRI_13")
    private String hri13;
    @Size(max = 20)
    @Column(name = "HRI_14")
    private String hri14;
    @Size(max = 20)
    @Column(name = "HRI_15")
    private String hri15;
    @Size(max = 20)
    @Column(name = "HRI_16")
    private String hri16;
    @Size(max = 20)
    @Column(name = "HRI_17")
    private String hri17;
    @Size(max = 20)
    @Column(name = "HRI_18")
    private String hri18;
    @Size(max = 20)
    @Column(name = "HRI_19")
    private String hri19;
    @Size(max = 20)
    @Column(name = "HRI_20")
    private String hri20;
    @Size(max = 20)
    @Column(name = "HRI_21")
    private String hri21;
    @Size(max = 20)
    @Column(name = "HRI_22")
    private String hri22;
    @Size(max = 20)
    @Column(name = "HRI_23")
    private String hri23;
    @Size(max = 20)
    @Column(name = "HRI_24")
    private String hri24;
    @Size(max = 20)
    @Column(name = "HRI_1")
    private String hri1;
    @Size(max = 20)
    @Column(name = "HRI_2")
    private String hri2;
    @Size(max = 20)
    @Column(name = "HRI_3")
    private String hri3;
    @Size(max = 20)
    @Column(name = "HRI_4")
    private String hri4;
    @Size(max = 20)
    @Column(name = "HRI_5")
    private String hri5;
    @Size(max = 20)
    @Column(name = "HRI_6")
    private String hri6;
    @Size(max = 20)
    @Column(name = "HRI_7")
    private String hri7;
    @Size(max = 10)
    @Column(name = "HRI_TOT_AM")
    private String hriTotAm;
    @Size(max = 10)
    @Column(name = "HRI_TOT_PM")
    private String hriTotPm;
    @Size(max = 10)
    @Column(name = "HRI_TOT_HS")
    private String hriTotHs;
    @Size(max = 10)
    @Column(name = "HRI_TOT_ING")
    private String hriTotIng;
    @JoinColumn(name = "OPP_ID", referencedColumnName = "OPP_ID")
    @ManyToOne(optional = false)
    private UOpcionPaciente uOpcionPaciente;
    @JoinColumn(name = "OPC_ID", referencedColumnName = "OPC_ID")
    @ManyToOne(optional = false)
    private UOpciones uOpciones;

    public UHorarioIngesta() {
    }

    public UHorarioIngesta(BigDecimal hriId) {
        this.hriId = hriId;
    }

    public UHorarioIngesta(BigDecimal hriId, Date hriFecha) {
        this.hriId = hriId;
        this.hriFecha = hriFecha;
    }

    public BigDecimal getHriId() {
        return hriId;
    }

    public void setHriId(BigDecimal hriId) {
        this.hriId = hriId;
    }

    public Date getHriFecha() {
        return hriFecha;
    }

    public void setHriFecha(Date hriFecha) {
        this.hriFecha = hriFecha;
    }

    public String getHriUnimed() {
        return hriUnimed;
    }

    public void setHriUnimed(String hriUnimed) {
        this.hriUnimed = hriUnimed;
    }

    public String getHri8() {
        return hri8;
    }

    public void setHri8(String hri8) {
        this.hri8 = hri8;
    }

    public String getHri9() {
        return hri9;
    }

    public void setHri9(String hri9) {
        this.hri9 = hri9;
    }

    public String getHri10() {
        return hri10;
    }

    public void setHri10(String hri10) {
        this.hri10 = hri10;
    }

    public String getHri11() {
        return hri11;
    }

    public void setHri11(String hri11) {
        this.hri11 = hri11;
    }

    public String getHri12() {
        return hri12;
    }

    public void setHri12(String hri12) {
        this.hri12 = hri12;
    }

    public String getHri13() {
        return hri13;
    }

    public void setHri13(String hri13) {
        this.hri13 = hri13;
    }

    public String getHri14() {
        return hri14;
    }

    public void setHri14(String hri14) {
        this.hri14 = hri14;
    }

  

    public String getHri15() {
        return hri15;
    }

    public void setHri15(String hri15) {
        this.hri15 = hri15;
    }

    public String getHri16() {
        return hri16;
    }

    public void setHri16(String hri16) {
        this.hri16 = hri16;
    }

    public String getHri17() {
        return hri17;
    }

    public void setHri17(String hri17) {
        this.hri17 = hri17;
    }

    public String getHri18() {
        return hri18;
    }

    public void setHri18(String hri18) {
        this.hri18 = hri18;
    }

    public String getHri19() {
        return hri19;
    }

    public void setHri19(String hri19) {
        this.hri19 = hri19;
    }

    public String getHri20() {
        return hri20;
    }

    public void setHri20(String hri20) {
        this.hri20 = hri20;
    }

    public String getHri21() {
        return hri21;
    }

    public void setHri21(String hri21) {
        this.hri21 = hri21;
    }

    public String getHri22() {
        return hri22;
    }

    public void setHri22(String hri22) {
        this.hri22 = hri22;
    }

    public String getHri23() {
        return hri23;
    }

    public void setHri23(String hri23) {
        this.hri23 = hri23;
    }

    public String getHri24() {
        return hri24;
    }

    public void setHri24(String hri24) {
        this.hri24 = hri24;
    }

    public String getHri1() {
        return hri1;
    }

    public void setHri1(String hri1) {
        this.hri1 = hri1;
    }

    public String getHri2() {
        return hri2;
    }

    public void setHri2(String hri2) {
        this.hri2 = hri2;
    }

    public String getHri3() {
        return hri3;
    }

    public void setHri3(String hri3) {
        this.hri3 = hri3;
    }

    public String getHri4() {
        return hri4;
    }

    public void setHri4(String hri4) {
        this.hri4 = hri4;
    }

    public String getHri5() {
        return hri5;
    }

    public void setHri5(String hri5) {
        this.hri5 = hri5;
    }

    public String getHri6() {
        return hri6;
    }

    public void setHri6(String hri6) {
        this.hri6 = hri6;
    }

    public String getHri7() {
        return hri7;
    }

    public void setHri7(String hri7) {
        this.hri7 = hri7;
    }

    public String getHriTotAm() {
        return hriTotAm;
    }

    public void setHriTotAm(String hriTotAm) {
        this.hriTotAm = hriTotAm;
    }

    public String getHriTotPm() {
        return hriTotPm;
    }

    public void setHriTotPm(String hriTotPm) {
        this.hriTotPm = hriTotPm;
    }

    public String getHriTotHs() {
        return hriTotHs;
    }

    public void setHriTotHs(String hriTotHs) {
        this.hriTotHs = hriTotHs;
    }

    public String getHriTotIng() {
        return hriTotIng;
    }

    public void setHriTotIng(String hriTotIng) {
        this.hriTotIng = hriTotIng;
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
        hash += (hriId != null ? hriId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UHorarioIngesta)) {
            return false;
        }
        UHorarioIngesta other = (UHorarioIngesta) object;
        if ((this.hriId == null && other.hriId != null) || (this.hriId != null && !this.hriId.equals(other.hriId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.UHorarioIngesta[ hriId=" + hriId + " ]";
    }
    
}
