/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package he1.odonto.entities;

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
@Table(name = "O_REC_MOVILIDAD")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ORecMovilidad.findAll", query = "SELECT o FROM ORecMovilidad o"),
    @NamedQuery(name = "ORecMovilidad.findByRmoId", query = "SELECT o FROM ORecMovilidad o WHERE o.rmoId = :rmoId"),
    @NamedQuery(name = "ORecMovilidad.findByRmoFecha", query = "SELECT o FROM ORecMovilidad o WHERE o.rmoFecha = :rmoFecha"),
    @NamedQuery(name = "ORecMovilidad.findByRmoPdentalR11", query = "SELECT o FROM ORecMovilidad o WHERE o.rmoPdentalR11 = :rmoPdentalR11"),
    @NamedQuery(name = "ORecMovilidad.findByRmoPdentalR12", query = "SELECT o FROM ORecMovilidad o WHERE o.rmoPdentalR12 = :rmoPdentalR12"),
    @NamedQuery(name = "ORecMovilidad.findByRmoPdentalR13", query = "SELECT o FROM ORecMovilidad o WHERE o.rmoPdentalR13 = :rmoPdentalR13"),
    @NamedQuery(name = "ORecMovilidad.findByRmoPdentalR14", query = "SELECT o FROM ORecMovilidad o WHERE o.rmoPdentalR14 = :rmoPdentalR14"),
    @NamedQuery(name = "ORecMovilidad.findByRmoPdentalR15", query = "SELECT o FROM ORecMovilidad o WHERE o.rmoPdentalR15 = :rmoPdentalR15"),
    @NamedQuery(name = "ORecMovilidad.findByRmoPdentalR16", query = "SELECT o FROM ORecMovilidad o WHERE o.rmoPdentalR16 = :rmoPdentalR16"),
    @NamedQuery(name = "ORecMovilidad.findByRmoPdentalR17", query = "SELECT o FROM ORecMovilidad o WHERE o.rmoPdentalR17 = :rmoPdentalR17"),
    @NamedQuery(name = "ORecMovilidad.findByRmoPdentalR18", query = "SELECT o FROM ORecMovilidad o WHERE o.rmoPdentalR18 = :rmoPdentalR18"),
    @NamedQuery(name = "ORecMovilidad.findByRmoPdentalR21", query = "SELECT o FROM ORecMovilidad o WHERE o.rmoPdentalR21 = :rmoPdentalR21"),
    @NamedQuery(name = "ORecMovilidad.findByRmoPdentalR22", query = "SELECT o FROM ORecMovilidad o WHERE o.rmoPdentalR22 = :rmoPdentalR22"),
    @NamedQuery(name = "ORecMovilidad.findByRmoPdentalR23", query = "SELECT o FROM ORecMovilidad o WHERE o.rmoPdentalR23 = :rmoPdentalR23"),
    @NamedQuery(name = "ORecMovilidad.findByRmoPdentalR24", query = "SELECT o FROM ORecMovilidad o WHERE o.rmoPdentalR24 = :rmoPdentalR24"),
    @NamedQuery(name = "ORecMovilidad.findByRmoPdentalR25", query = "SELECT o FROM ORecMovilidad o WHERE o.rmoPdentalR25 = :rmoPdentalR25"),
    @NamedQuery(name = "ORecMovilidad.findByRmoPdentalR26", query = "SELECT o FROM ORecMovilidad o WHERE o.rmoPdentalR26 = :rmoPdentalR26"),
    @NamedQuery(name = "ORecMovilidad.findByRmoPdentalR27", query = "SELECT o FROM ORecMovilidad o WHERE o.rmoPdentalR27 = :rmoPdentalR27"),
    @NamedQuery(name = "ORecMovilidad.findByRmoPdentalR28", query = "SELECT o FROM ORecMovilidad o WHERE o.rmoPdentalR28 = :rmoPdentalR28"),
    @NamedQuery(name = "ORecMovilidad.findByRmoPdentalR41", query = "SELECT o FROM ORecMovilidad o WHERE o.rmoPdentalR41 = :rmoPdentalR41"),
    @NamedQuery(name = "ORecMovilidad.findByRmoPdentalR42", query = "SELECT o FROM ORecMovilidad o WHERE o.rmoPdentalR42 = :rmoPdentalR42"),
    @NamedQuery(name = "ORecMovilidad.findByRmoPdentalR43", query = "SELECT o FROM ORecMovilidad o WHERE o.rmoPdentalR43 = :rmoPdentalR43"),
    @NamedQuery(name = "ORecMovilidad.findByRmoPdentalR44", query = "SELECT o FROM ORecMovilidad o WHERE o.rmoPdentalR44 = :rmoPdentalR44"),
    @NamedQuery(name = "ORecMovilidad.findByRmoPdentalR45", query = "SELECT o FROM ORecMovilidad o WHERE o.rmoPdentalR45 = :rmoPdentalR45"),
    @NamedQuery(name = "ORecMovilidad.findByRmoPdentalR46", query = "SELECT o FROM ORecMovilidad o WHERE o.rmoPdentalR46 = :rmoPdentalR46"),
    @NamedQuery(name = "ORecMovilidad.findByRmoPdentalR47", query = "SELECT o FROM ORecMovilidad o WHERE o.rmoPdentalR47 = :rmoPdentalR47"),
    @NamedQuery(name = "ORecMovilidad.findByRmoPdentalR48", query = "SELECT o FROM ORecMovilidad o WHERE o.rmoPdentalR48 = :rmoPdentalR48"),
    @NamedQuery(name = "ORecMovilidad.findByRmoPdentalR31", query = "SELECT o FROM ORecMovilidad o WHERE o.rmoPdentalR31 = :rmoPdentalR31"),
    @NamedQuery(name = "ORecMovilidad.findByRmoPdentalR32", query = "SELECT o FROM ORecMovilidad o WHERE o.rmoPdentalR32 = :rmoPdentalR32"),
    @NamedQuery(name = "ORecMovilidad.findByRmoPdentalR33", query = "SELECT o FROM ORecMovilidad o WHERE o.rmoPdentalR33 = :rmoPdentalR33"),
    @NamedQuery(name = "ORecMovilidad.findByRmoPdentalR34", query = "SELECT o FROM ORecMovilidad o WHERE o.rmoPdentalR34 = :rmoPdentalR34"),
    @NamedQuery(name = "ORecMovilidad.findByRmoPdentalR35", query = "SELECT o FROM ORecMovilidad o WHERE o.rmoPdentalR35 = :rmoPdentalR35"),
    @NamedQuery(name = "ORecMovilidad.findByRmoPdentalR36", query = "SELECT o FROM ORecMovilidad o WHERE o.rmoPdentalR36 = :rmoPdentalR36"),
    @NamedQuery(name = "ORecMovilidad.findByRmoPdentalR37", query = "SELECT o FROM ORecMovilidad o WHERE o.rmoPdentalR37 = :rmoPdentalR37"),
    @NamedQuery(name = "ORecMovilidad.findByRmoPdentalR38", query = "SELECT o FROM ORecMovilidad o WHERE o.rmoPdentalR38 = :rmoPdentalR38"),
    @NamedQuery(name = "ORecMovilidad.findByRmoPdentalM11", query = "SELECT o FROM ORecMovilidad o WHERE o.rmoPdentalM11 = :rmoPdentalM11"),
    @NamedQuery(name = "ORecMovilidad.findByRmoPdentalM12", query = "SELECT o FROM ORecMovilidad o WHERE o.rmoPdentalM12 = :rmoPdentalM12"),
    @NamedQuery(name = "ORecMovilidad.findByRmoPdentalM13", query = "SELECT o FROM ORecMovilidad o WHERE o.rmoPdentalM13 = :rmoPdentalM13"),
    @NamedQuery(name = "ORecMovilidad.findByRmoPdentalM14", query = "SELECT o FROM ORecMovilidad o WHERE o.rmoPdentalM14 = :rmoPdentalM14"),
    @NamedQuery(name = "ORecMovilidad.findByRmoPdentalM15", query = "SELECT o FROM ORecMovilidad o WHERE o.rmoPdentalM15 = :rmoPdentalM15"),
    @NamedQuery(name = "ORecMovilidad.findByRmoPdentalM16", query = "SELECT o FROM ORecMovilidad o WHERE o.rmoPdentalM16 = :rmoPdentalM16"),
    @NamedQuery(name = "ORecMovilidad.findByRmoPdentalM17", query = "SELECT o FROM ORecMovilidad o WHERE o.rmoPdentalM17 = :rmoPdentalM17"),
    @NamedQuery(name = "ORecMovilidad.findByRmoPdentalM18", query = "SELECT o FROM ORecMovilidad o WHERE o.rmoPdentalM18 = :rmoPdentalM18"),
    @NamedQuery(name = "ORecMovilidad.findByRmoPdentalM21", query = "SELECT o FROM ORecMovilidad o WHERE o.rmoPdentalM21 = :rmoPdentalM21"),
    @NamedQuery(name = "ORecMovilidad.findByRmoPdentalM22", query = "SELECT o FROM ORecMovilidad o WHERE o.rmoPdentalM22 = :rmoPdentalM22"),
    @NamedQuery(name = "ORecMovilidad.findByRmoPdentalM23", query = "SELECT o FROM ORecMovilidad o WHERE o.rmoPdentalM23 = :rmoPdentalM23"),
    @NamedQuery(name = "ORecMovilidad.findByRmoPdentalM24", query = "SELECT o FROM ORecMovilidad o WHERE o.rmoPdentalM24 = :rmoPdentalM24"),
    @NamedQuery(name = "ORecMovilidad.findByRmoPdentalM25", query = "SELECT o FROM ORecMovilidad o WHERE o.rmoPdentalM25 = :rmoPdentalM25"),
    @NamedQuery(name = "ORecMovilidad.findByRmoPdentalM26", query = "SELECT o FROM ORecMovilidad o WHERE o.rmoPdentalM26 = :rmoPdentalM26"),
    @NamedQuery(name = "ORecMovilidad.findByRmoPdentalM27", query = "SELECT o FROM ORecMovilidad o WHERE o.rmoPdentalM27 = :rmoPdentalM27"),
    @NamedQuery(name = "ORecMovilidad.findByRmoPdentalM28", query = "SELECT o FROM ORecMovilidad o WHERE o.rmoPdentalM28 = :rmoPdentalM28"),
    @NamedQuery(name = "ORecMovilidad.findByRmoPdentalM41", query = "SELECT o FROM ORecMovilidad o WHERE o.rmoPdentalM41 = :rmoPdentalM41"),
    @NamedQuery(name = "ORecMovilidad.findByRmoPdentalM42", query = "SELECT o FROM ORecMovilidad o WHERE o.rmoPdentalM42 = :rmoPdentalM42"),
    @NamedQuery(name = "ORecMovilidad.findByRmoPdentalM43", query = "SELECT o FROM ORecMovilidad o WHERE o.rmoPdentalM43 = :rmoPdentalM43"),
    @NamedQuery(name = "ORecMovilidad.findByRmoPdentalM44", query = "SELECT o FROM ORecMovilidad o WHERE o.rmoPdentalM44 = :rmoPdentalM44"),
    @NamedQuery(name = "ORecMovilidad.findByRmoPdentalM45", query = "SELECT o FROM ORecMovilidad o WHERE o.rmoPdentalM45 = :rmoPdentalM45"),
    @NamedQuery(name = "ORecMovilidad.findByRmoPdentalM46", query = "SELECT o FROM ORecMovilidad o WHERE o.rmoPdentalM46 = :rmoPdentalM46"),
    @NamedQuery(name = "ORecMovilidad.findByRmoPdentalM47", query = "SELECT o FROM ORecMovilidad o WHERE o.rmoPdentalM47 = :rmoPdentalM47"),
    @NamedQuery(name = "ORecMovilidad.findByRmoPdentalM48", query = "SELECT o FROM ORecMovilidad o WHERE o.rmoPdentalM48 = :rmoPdentalM48"),
    @NamedQuery(name = "ORecMovilidad.findByRmoPdentalM31", query = "SELECT o FROM ORecMovilidad o WHERE o.rmoPdentalM31 = :rmoPdentalM31"),
    @NamedQuery(name = "ORecMovilidad.findByRmoPdentalM32", query = "SELECT o FROM ORecMovilidad o WHERE o.rmoPdentalM32 = :rmoPdentalM32"),
    @NamedQuery(name = "ORecMovilidad.findByRmoPdentalM33", query = "SELECT o FROM ORecMovilidad o WHERE o.rmoPdentalM33 = :rmoPdentalM33"),
    @NamedQuery(name = "ORecMovilidad.findByRmoPdentalM34", query = "SELECT o FROM ORecMovilidad o WHERE o.rmoPdentalM34 = :rmoPdentalM34"),
    @NamedQuery(name = "ORecMovilidad.findByRmoPdentalM35", query = "SELECT o FROM ORecMovilidad o WHERE o.rmoPdentalM35 = :rmoPdentalM35"),
    @NamedQuery(name = "ORecMovilidad.findByRmoPdentalM36", query = "SELECT o FROM ORecMovilidad o WHERE o.rmoPdentalM36 = :rmoPdentalM36"),
    @NamedQuery(name = "ORecMovilidad.findByRmoPdentalM37", query = "SELECT o FROM ORecMovilidad o WHERE o.rmoPdentalM37 = :rmoPdentalM37"),
    @NamedQuery(name = "ORecMovilidad.findByRmoPdentalM38", query = "SELECT o FROM ORecMovilidad o WHERE o.rmoPdentalM38 = :rmoPdentalM38")})
public class ORecMovilidad implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "RMO_ID")
    private BigDecimal rmoId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "RMO_FECHA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date rmoFecha;
    @Size(max = 1)
    @Column(name = "RMO_PDENTAL_R_11")
    private String rmoPdentalR11;
    @Size(max = 1)
    @Column(name = "RMO_PDENTAL_R_12")
    private String rmoPdentalR12;
    @Size(max = 1)
    @Column(name = "RMO_PDENTAL_R_13")
    private String rmoPdentalR13;
    @Size(max = 1)
    @Column(name = "RMO_PDENTAL_R_14")
    private String rmoPdentalR14;
    @Size(max = 1)
    @Column(name = "RMO_PDENTAL_R_15")
    private String rmoPdentalR15;
    @Size(max = 1)
    @Column(name = "RMO_PDENTAL_R_16")
    private String rmoPdentalR16;
    @Size(max = 1)
    @Column(name = "RMO_PDENTAL_R_17")
    private String rmoPdentalR17;
    @Size(max = 1)
    @Column(name = "RMO_PDENTAL_R_18")
    private String rmoPdentalR18;
    @Size(max = 1)
    @Column(name = "RMO_PDENTAL_R_21")
    private String rmoPdentalR21;
    @Size(max = 1)
    @Column(name = "RMO_PDENTAL_R_22")
    private String rmoPdentalR22;
    @Size(max = 1)
    @Column(name = "RMO_PDENTAL_R_23")
    private String rmoPdentalR23;
    @Size(max = 1)
    @Column(name = "RMO_PDENTAL_R_24")
    private String rmoPdentalR24;
    @Size(max = 1)
    @Column(name = "RMO_PDENTAL_R_25")
    private String rmoPdentalR25;
    @Size(max = 1)
    @Column(name = "RMO_PDENTAL_R_26")
    private String rmoPdentalR26;
    @Size(max = 1)
    @Column(name = "RMO_PDENTAL_R_27")
    private String rmoPdentalR27;
    @Size(max = 1)
    @Column(name = "RMO_PDENTAL_R_28")
    private String rmoPdentalR28;
    @Size(max = 1)
    @Column(name = "RMO_PDENTAL_R_41")
    private String rmoPdentalR41;
    @Size(max = 1)
    @Column(name = "RMO_PDENTAL_R_42")
    private String rmoPdentalR42;
    @Size(max = 1)
    @Column(name = "RMO_PDENTAL_R_43")
    private String rmoPdentalR43;
    @Size(max = 1)
    @Column(name = "RMO_PDENTAL_R_44")
    private String rmoPdentalR44;
    @Size(max = 1)
    @Column(name = "RMO_PDENTAL_R_45")
    private String rmoPdentalR45;
    @Size(max = 1)
    @Column(name = "RMO_PDENTAL_R_46")
    private String rmoPdentalR46;
    @Size(max = 1)
    @Column(name = "RMO_PDENTAL_R_47")
    private String rmoPdentalR47;
    @Size(max = 1)
    @Column(name = "RMO_PDENTAL_R_48")
    private String rmoPdentalR48;
    @Size(max = 1)
    @Column(name = "RMO_PDENTAL_R_31")
    private String rmoPdentalR31;
    @Size(max = 1)
    @Column(name = "RMO_PDENTAL_R_32")
    private String rmoPdentalR32;
    @Size(max = 1)
    @Column(name = "RMO_PDENTAL_R_33")
    private String rmoPdentalR33;
    @Size(max = 1)
    @Column(name = "RMO_PDENTAL_R_34")
    private String rmoPdentalR34;
    @Size(max = 1)
    @Column(name = "RMO_PDENTAL_R_35")
    private String rmoPdentalR35;
    @Size(max = 1)
    @Column(name = "RMO_PDENTAL_R_36")
    private String rmoPdentalR36;
    @Size(max = 1)
    @Column(name = "RMO_PDENTAL_R_37")
    private String rmoPdentalR37;
    @Size(max = 1)
    @Column(name = "RMO_PDENTAL_R_38")
    private String rmoPdentalR38;
    @Size(max = 1)
    @Column(name = "RMO_PDENTAL_M_11")
    private String rmoPdentalM11;
    @Size(max = 1)
    @Column(name = "RMO_PDENTAL_M_12")
    private String rmoPdentalM12;
    @Size(max = 1)
    @Column(name = "RMO_PDENTAL_M_13")
    private String rmoPdentalM13;
    @Size(max = 1)
    @Column(name = "RMO_PDENTAL_M_14")
    private String rmoPdentalM14;
    @Size(max = 1)
    @Column(name = "RMO_PDENTAL_M_15")
    private String rmoPdentalM15;
    @Size(max = 1)
    @Column(name = "RMO_PDENTAL_M_16")
    private String rmoPdentalM16;
    @Size(max = 1)
    @Column(name = "RMO_PDENTAL_M_17")
    private String rmoPdentalM17;
    @Size(max = 1)
    @Column(name = "RMO_PDENTAL_M_18")
    private String rmoPdentalM18;
    @Size(max = 1)
    @Column(name = "RMO_PDENTAL_M_21")
    private String rmoPdentalM21;
    @Size(max = 1)
    @Column(name = "RMO_PDENTAL_M_22")
    private String rmoPdentalM22;
    @Size(max = 1)
    @Column(name = "RMO_PDENTAL_M_23")
    private String rmoPdentalM23;
    @Size(max = 1)
    @Column(name = "RMO_PDENTAL_M_24")
    private String rmoPdentalM24;
    @Size(max = 1)
    @Column(name = "RMO_PDENTAL_M_25")
    private String rmoPdentalM25;
    @Size(max = 1)
    @Column(name = "RMO_PDENTAL_M_26")
    private String rmoPdentalM26;
    @Size(max = 1)
    @Column(name = "RMO_PDENTAL_M_27")
    private String rmoPdentalM27;
    @Size(max = 1)
    @Column(name = "RMO_PDENTAL_M_28")
    private String rmoPdentalM28;
    @Size(max = 1)
    @Column(name = "RMO_PDENTAL_M_41")
    private String rmoPdentalM41;
    @Size(max = 1)
    @Column(name = "RMO_PDENTAL_M_42")
    private String rmoPdentalM42;
    @Size(max = 1)
    @Column(name = "RMO_PDENTAL_M_43")
    private String rmoPdentalM43;
    @Size(max = 1)
    @Column(name = "RMO_PDENTAL_M_44")
    private String rmoPdentalM44;
    @Size(max = 1)
    @Column(name = "RMO_PDENTAL_M_45")
    private String rmoPdentalM45;
    @Size(max = 1)
    @Column(name = "RMO_PDENTAL_M_46")
    private String rmoPdentalM46;
    @Size(max = 1)
    @Column(name = "RMO_PDENTAL_M_47")
    private String rmoPdentalM47;
    @Size(max = 1)
    @Column(name = "RMO_PDENTAL_M_48")
    private String rmoPdentalM48;
    @Size(max = 1)
    @Column(name = "RMO_PDENTAL_M_31")
    private String rmoPdentalM31;
    @Size(max = 1)
    @Column(name = "RMO_PDENTAL_M_32")
    private String rmoPdentalM32;
    @Size(max = 1)
    @Column(name = "RMO_PDENTAL_M_33")
    private String rmoPdentalM33;
    @Size(max = 1)
    @Column(name = "RMO_PDENTAL_M_34")
    private String rmoPdentalM34;
    @Size(max = 1)
    @Column(name = "RMO_PDENTAL_M_35")
    private String rmoPdentalM35;
    @Size(max = 1)
    @Column(name = "RMO_PDENTAL_M_36")
    private String rmoPdentalM36;
    @Size(max = 1)
    @Column(name = "RMO_PDENTAL_M_37")
    private String rmoPdentalM37;
    @Size(max = 1)
    @Column(name = "RMO_PDENTAL_M_38")
    private String rmoPdentalM38;
    @JoinColumn(name = "ODO_ID", referencedColumnName = "ODO_ID")
    @ManyToOne(optional = false)
    private OOdontograma oOdontograma;

    public ORecMovilidad() {
    }

    public ORecMovilidad(BigDecimal rmoId) {
        this.rmoId = rmoId;
    }

    public ORecMovilidad(BigDecimal rmoId, Date rmoFecha) {
        this.rmoId = rmoId;
        this.rmoFecha = rmoFecha;
    }

    public BigDecimal getRmoId() {
        return rmoId;
    }

    public void setRmoId(BigDecimal rmoId) {
        this.rmoId = rmoId;
    }

    public Date getRmoFecha() {
        return rmoFecha;
    }

    public void setRmoFecha(Date rmoFecha) {
        this.rmoFecha = rmoFecha;
    }

    public String getRmoPdentalR11() {
        return rmoPdentalR11;
    }

    public void setRmoPdentalR11(String rmoPdentalR11) {
        this.rmoPdentalR11 = rmoPdentalR11;
    }

    public String getRmoPdentalR12() {
        return rmoPdentalR12;
    }

    public void setRmoPdentalR12(String rmoPdentalR12) {
        this.rmoPdentalR12 = rmoPdentalR12;
    }

    public String getRmoPdentalR13() {
        return rmoPdentalR13;
    }

    public void setRmoPdentalR13(String rmoPdentalR13) {
        this.rmoPdentalR13 = rmoPdentalR13;
    }

    public String getRmoPdentalR14() {
        return rmoPdentalR14;
    }

    public void setRmoPdentalR14(String rmoPdentalR14) {
        this.rmoPdentalR14 = rmoPdentalR14;
    }

    public String getRmoPdentalR15() {
        return rmoPdentalR15;
    }

    public void setRmoPdentalR15(String rmoPdentalR15) {
        this.rmoPdentalR15 = rmoPdentalR15;
    }

    public String getRmoPdentalR16() {
        return rmoPdentalR16;
    }

    public void setRmoPdentalR16(String rmoPdentalR16) {
        this.rmoPdentalR16 = rmoPdentalR16;
    }

    public String getRmoPdentalR17() {
        return rmoPdentalR17;
    }

    public void setRmoPdentalR17(String rmoPdentalR17) {
        this.rmoPdentalR17 = rmoPdentalR17;
    }

    public String getRmoPdentalR18() {
        return rmoPdentalR18;
    }

    public void setRmoPdentalR18(String rmoPdentalR18) {
        this.rmoPdentalR18 = rmoPdentalR18;
    }

    public String getRmoPdentalR21() {
        return rmoPdentalR21;
    }

    public void setRmoPdentalR21(String rmoPdentalR21) {
        this.rmoPdentalR21 = rmoPdentalR21;
    }

    public String getRmoPdentalR22() {
        return rmoPdentalR22;
    }

    public void setRmoPdentalR22(String rmoPdentalR22) {
        this.rmoPdentalR22 = rmoPdentalR22;
    }

    public String getRmoPdentalR23() {
        return rmoPdentalR23;
    }

    public void setRmoPdentalR23(String rmoPdentalR23) {
        this.rmoPdentalR23 = rmoPdentalR23;
    }

    public String getRmoPdentalR24() {
        return rmoPdentalR24;
    }

    public void setRmoPdentalR24(String rmoPdentalR24) {
        this.rmoPdentalR24 = rmoPdentalR24;
    }

    public String getRmoPdentalR25() {
        return rmoPdentalR25;
    }

    public void setRmoPdentalR25(String rmoPdentalR25) {
        this.rmoPdentalR25 = rmoPdentalR25;
    }

    public String getRmoPdentalR26() {
        return rmoPdentalR26;
    }

    public void setRmoPdentalR26(String rmoPdentalR26) {
        this.rmoPdentalR26 = rmoPdentalR26;
    }

    public String getRmoPdentalR27() {
        return rmoPdentalR27;
    }

    public void setRmoPdentalR27(String rmoPdentalR27) {
        this.rmoPdentalR27 = rmoPdentalR27;
    }

    public String getRmoPdentalR28() {
        return rmoPdentalR28;
    }

    public void setRmoPdentalR28(String rmoPdentalR28) {
        this.rmoPdentalR28 = rmoPdentalR28;
    }

    public String getRmoPdentalR41() {
        return rmoPdentalR41;
    }

    public void setRmoPdentalR41(String rmoPdentalR41) {
        this.rmoPdentalR41 = rmoPdentalR41;
    }

    public String getRmoPdentalR42() {
        return rmoPdentalR42;
    }

    public void setRmoPdentalR42(String rmoPdentalR42) {
        this.rmoPdentalR42 = rmoPdentalR42;
    }

    public String getRmoPdentalR43() {
        return rmoPdentalR43;
    }

    public void setRmoPdentalR43(String rmoPdentalR43) {
        this.rmoPdentalR43 = rmoPdentalR43;
    }

    public String getRmoPdentalR44() {
        return rmoPdentalR44;
    }

    public void setRmoPdentalR44(String rmoPdentalR44) {
        this.rmoPdentalR44 = rmoPdentalR44;
    }

    public String getRmoPdentalR45() {
        return rmoPdentalR45;
    }

    public void setRmoPdentalR45(String rmoPdentalR45) {
        this.rmoPdentalR45 = rmoPdentalR45;
    }

    public String getRmoPdentalR46() {
        return rmoPdentalR46;
    }

    public void setRmoPdentalR46(String rmoPdentalR46) {
        this.rmoPdentalR46 = rmoPdentalR46;
    }

    public String getRmoPdentalR47() {
        return rmoPdentalR47;
    }

    public void setRmoPdentalR47(String rmoPdentalR47) {
        this.rmoPdentalR47 = rmoPdentalR47;
    }

    public String getRmoPdentalR48() {
        return rmoPdentalR48;
    }

    public void setRmoPdentalR48(String rmoPdentalR48) {
        this.rmoPdentalR48 = rmoPdentalR48;
    }

    public String getRmoPdentalR31() {
        return rmoPdentalR31;
    }

    public void setRmoPdentalR31(String rmoPdentalR31) {
        this.rmoPdentalR31 = rmoPdentalR31;
    }

    public String getRmoPdentalR32() {
        return rmoPdentalR32;
    }

    public void setRmoPdentalR32(String rmoPdentalR32) {
        this.rmoPdentalR32 = rmoPdentalR32;
    }

    public String getRmoPdentalR33() {
        return rmoPdentalR33;
    }

    public void setRmoPdentalR33(String rmoPdentalR33) {
        this.rmoPdentalR33 = rmoPdentalR33;
    }

    public String getRmoPdentalR34() {
        return rmoPdentalR34;
    }

    public void setRmoPdentalR34(String rmoPdentalR34) {
        this.rmoPdentalR34 = rmoPdentalR34;
    }

    public String getRmoPdentalR35() {
        return rmoPdentalR35;
    }

    public void setRmoPdentalR35(String rmoPdentalR35) {
        this.rmoPdentalR35 = rmoPdentalR35;
    }

    public String getRmoPdentalR36() {
        return rmoPdentalR36;
    }

    public void setRmoPdentalR36(String rmoPdentalR36) {
        this.rmoPdentalR36 = rmoPdentalR36;
    }

    public String getRmoPdentalR37() {
        return rmoPdentalR37;
    }

    public void setRmoPdentalR37(String rmoPdentalR37) {
        this.rmoPdentalR37 = rmoPdentalR37;
    }

    public String getRmoPdentalR38() {
        return rmoPdentalR38;
    }

    public void setRmoPdentalR38(String rmoPdentalR38) {
        this.rmoPdentalR38 = rmoPdentalR38;
    }

    public String getRmoPdentalM11() {
        return rmoPdentalM11;
    }

    public void setRmoPdentalM11(String rmoPdentalM11) {
        this.rmoPdentalM11 = rmoPdentalM11;
    }

    public String getRmoPdentalM12() {
        return rmoPdentalM12;
    }

    public void setRmoPdentalM12(String rmoPdentalM12) {
        this.rmoPdentalM12 = rmoPdentalM12;
    }

    public String getRmoPdentalM13() {
        return rmoPdentalM13;
    }

    public void setRmoPdentalM13(String rmoPdentalM13) {
        this.rmoPdentalM13 = rmoPdentalM13;
    }

    public String getRmoPdentalM14() {
        return rmoPdentalM14;
    }

    public void setRmoPdentalM14(String rmoPdentalM14) {
        this.rmoPdentalM14 = rmoPdentalM14;
    }

    public String getRmoPdentalM15() {
        return rmoPdentalM15;
    }

    public void setRmoPdentalM15(String rmoPdentalM15) {
        this.rmoPdentalM15 = rmoPdentalM15;
    }

    public String getRmoPdentalM16() {
        return rmoPdentalM16;
    }

    public void setRmoPdentalM16(String rmoPdentalM16) {
        this.rmoPdentalM16 = rmoPdentalM16;
    }

    public String getRmoPdentalM17() {
        return rmoPdentalM17;
    }

    public void setRmoPdentalM17(String rmoPdentalM17) {
        this.rmoPdentalM17 = rmoPdentalM17;
    }

    public String getRmoPdentalM18() {
        return rmoPdentalM18;
    }

    public void setRmoPdentalM18(String rmoPdentalM18) {
        this.rmoPdentalM18 = rmoPdentalM18;
    }

    public String getRmoPdentalM21() {
        return rmoPdentalM21;
    }

    public void setRmoPdentalM21(String rmoPdentalM21) {
        this.rmoPdentalM21 = rmoPdentalM21;
    }

    public String getRmoPdentalM22() {
        return rmoPdentalM22;
    }

    public void setRmoPdentalM22(String rmoPdentalM22) {
        this.rmoPdentalM22 = rmoPdentalM22;
    }

    public String getRmoPdentalM23() {
        return rmoPdentalM23;
    }

    public void setRmoPdentalM23(String rmoPdentalM23) {
        this.rmoPdentalM23 = rmoPdentalM23;
    }

    public String getRmoPdentalM24() {
        return rmoPdentalM24;
    }

    public void setRmoPdentalM24(String rmoPdentalM24) {
        this.rmoPdentalM24 = rmoPdentalM24;
    }

    public String getRmoPdentalM25() {
        return rmoPdentalM25;
    }

    public void setRmoPdentalM25(String rmoPdentalM25) {
        this.rmoPdentalM25 = rmoPdentalM25;
    }

    public String getRmoPdentalM26() {
        return rmoPdentalM26;
    }

    public void setRmoPdentalM26(String rmoPdentalM26) {
        this.rmoPdentalM26 = rmoPdentalM26;
    }

    public String getRmoPdentalM27() {
        return rmoPdentalM27;
    }

    public void setRmoPdentalM27(String rmoPdentalM27) {
        this.rmoPdentalM27 = rmoPdentalM27;
    }

    public String getRmoPdentalM28() {
        return rmoPdentalM28;
    }

    public void setRmoPdentalM28(String rmoPdentalM28) {
        this.rmoPdentalM28 = rmoPdentalM28;
    }

    public String getRmoPdentalM41() {
        return rmoPdentalM41;
    }

    public void setRmoPdentalM41(String rmoPdentalM41) {
        this.rmoPdentalM41 = rmoPdentalM41;
    }

    public String getRmoPdentalM42() {
        return rmoPdentalM42;
    }

    public void setRmoPdentalM42(String rmoPdentalM42) {
        this.rmoPdentalM42 = rmoPdentalM42;
    }

    public String getRmoPdentalM43() {
        return rmoPdentalM43;
    }

    public void setRmoPdentalM43(String rmoPdentalM43) {
        this.rmoPdentalM43 = rmoPdentalM43;
    }

    public String getRmoPdentalM44() {
        return rmoPdentalM44;
    }

    public void setRmoPdentalM44(String rmoPdentalM44) {
        this.rmoPdentalM44 = rmoPdentalM44;
    }

    public String getRmoPdentalM45() {
        return rmoPdentalM45;
    }

    public void setRmoPdentalM45(String rmoPdentalM45) {
        this.rmoPdentalM45 = rmoPdentalM45;
    }

    public String getRmoPdentalM46() {
        return rmoPdentalM46;
    }

    public void setRmoPdentalM46(String rmoPdentalM46) {
        this.rmoPdentalM46 = rmoPdentalM46;
    }

    public String getRmoPdentalM47() {
        return rmoPdentalM47;
    }

    public void setRmoPdentalM47(String rmoPdentalM47) {
        this.rmoPdentalM47 = rmoPdentalM47;
    }

    public String getRmoPdentalM48() {
        return rmoPdentalM48;
    }

    public void setRmoPdentalM48(String rmoPdentalM48) {
        this.rmoPdentalM48 = rmoPdentalM48;
    }

    public String getRmoPdentalM31() {
        return rmoPdentalM31;
    }

    public void setRmoPdentalM31(String rmoPdentalM31) {
        this.rmoPdentalM31 = rmoPdentalM31;
    }

    public String getRmoPdentalM32() {
        return rmoPdentalM32;
    }

    public void setRmoPdentalM32(String rmoPdentalM32) {
        this.rmoPdentalM32 = rmoPdentalM32;
    }

    public String getRmoPdentalM33() {
        return rmoPdentalM33;
    }

    public void setRmoPdentalM33(String rmoPdentalM33) {
        this.rmoPdentalM33 = rmoPdentalM33;
    }

    public String getRmoPdentalM34() {
        return rmoPdentalM34;
    }

    public void setRmoPdentalM34(String rmoPdentalM34) {
        this.rmoPdentalM34 = rmoPdentalM34;
    }

    public String getRmoPdentalM35() {
        return rmoPdentalM35;
    }

    public void setRmoPdentalM35(String rmoPdentalM35) {
        this.rmoPdentalM35 = rmoPdentalM35;
    }

    public String getRmoPdentalM36() {
        return rmoPdentalM36;
    }

    public void setRmoPdentalM36(String rmoPdentalM36) {
        this.rmoPdentalM36 = rmoPdentalM36;
    }

    public String getRmoPdentalM37() {
        return rmoPdentalM37;
    }

    public void setRmoPdentalM37(String rmoPdentalM37) {
        this.rmoPdentalM37 = rmoPdentalM37;
    }

    public String getRmoPdentalM38() {
        return rmoPdentalM38;
    }

    public void setRmoPdentalM38(String rmoPdentalM38) {
        this.rmoPdentalM38 = rmoPdentalM38;
    }

    public OOdontograma getOOdontograma() {
        return oOdontograma;
    }

    public void setOOdontograma(OOdontograma oOdontograma) {
        this.oOdontograma = oOdontograma;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (rmoId != null ? rmoId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ORecMovilidad)) {
            return false;
        }
        ORecMovilidad other = (ORecMovilidad) object;
        if ((this.rmoId == null && other.rmoId != null) || (this.rmoId != null && !this.rmoId.equals(other.rmoId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.ORecMovilidad[ rmoId=" + rmoId + " ]";
    }
    
}
