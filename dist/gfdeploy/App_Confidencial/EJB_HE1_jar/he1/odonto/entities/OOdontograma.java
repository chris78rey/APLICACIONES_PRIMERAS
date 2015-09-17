/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package he1.odonto.entities;

import he1.sis.entities.HojasDeEvolucion;
import he1.sis.entities.Pacientes;
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
@Table(name = "O_ODONTOGRAMA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OOdontograma.findAll", query = "SELECT o FROM OOdontograma o"),
    @NamedQuery(name = "OOdontograma.findByOdoId", query = "SELECT o FROM OOdontograma o WHERE o.odoId = :odoId"),
    @NamedQuery(name = "OOdontograma.findByOdoFecha", query = "SELECT o FROM OOdontograma o WHERE o.odoFecha = :odoFecha"),
    @NamedQuery(name = "OOdontograma.findByOdoPdentalv18", query = "SELECT o FROM OOdontograma o WHERE o.odoPdentalv18 = :odoPdentalv18"),
    @NamedQuery(name = "OOdontograma.findByOdoPdentalv17", query = "SELECT o FROM OOdontograma o WHERE o.odoPdentalv17 = :odoPdentalv17"),
    @NamedQuery(name = "OOdontograma.findByOdoPdentalv16", query = "SELECT o FROM OOdontograma o WHERE o.odoPdentalv16 = :odoPdentalv16"),
    @NamedQuery(name = "OOdontograma.findByOdoPdentalv15", query = "SELECT o FROM OOdontograma o WHERE o.odoPdentalv15 = :odoPdentalv15"),
    @NamedQuery(name = "OOdontograma.findByOdoPdentalv14", query = "SELECT o FROM OOdontograma o WHERE o.odoPdentalv14 = :odoPdentalv14"),
    @NamedQuery(name = "OOdontograma.findByOdoPdentalv13", query = "SELECT o FROM OOdontograma o WHERE o.odoPdentalv13 = :odoPdentalv13"),
    @NamedQuery(name = "OOdontograma.findByOdoPdentalv12", query = "SELECT o FROM OOdontograma o WHERE o.odoPdentalv12 = :odoPdentalv12"),
    @NamedQuery(name = "OOdontograma.findByOdoPdentalv11", query = "SELECT o FROM OOdontograma o WHERE o.odoPdentalv11 = :odoPdentalv11"),
    @NamedQuery(name = "OOdontograma.findByOdoPdentalv21", query = "SELECT o FROM OOdontograma o WHERE o.odoPdentalv21 = :odoPdentalv21"),
    @NamedQuery(name = "OOdontograma.findByOdoPdentalv22", query = "SELECT o FROM OOdontograma o WHERE o.odoPdentalv22 = :odoPdentalv22"),
    @NamedQuery(name = "OOdontograma.findByOdoPdentalv23", query = "SELECT o FROM OOdontograma o WHERE o.odoPdentalv23 = :odoPdentalv23"),
    @NamedQuery(name = "OOdontograma.findByOdoPdentalv24", query = "SELECT o FROM OOdontograma o WHERE o.odoPdentalv24 = :odoPdentalv24"),
    @NamedQuery(name = "OOdontograma.findByOdoPdentalv25", query = "SELECT o FROM OOdontograma o WHERE o.odoPdentalv25 = :odoPdentalv25"),
    @NamedQuery(name = "OOdontograma.findByOdoPdentalv26", query = "SELECT o FROM OOdontograma o WHERE o.odoPdentalv26 = :odoPdentalv26"),
    @NamedQuery(name = "OOdontograma.findByOdoPdentalv27", query = "SELECT o FROM OOdontograma o WHERE o.odoPdentalv27 = :odoPdentalv27"),
    @NamedQuery(name = "OOdontograma.findByOdoPdentalv28", query = "SELECT o FROM OOdontograma o WHERE o.odoPdentalv28 = :odoPdentalv28"),
    @NamedQuery(name = "OOdontograma.findByOdoPdentalv48", query = "SELECT o FROM OOdontograma o WHERE o.odoPdentalv48 = :odoPdentalv48"),
    @NamedQuery(name = "OOdontograma.findByOdoPdentalv47", query = "SELECT o FROM OOdontograma o WHERE o.odoPdentalv47 = :odoPdentalv47"),
    @NamedQuery(name = "OOdontograma.findByOdoPdentalv46", query = "SELECT o FROM OOdontograma o WHERE o.odoPdentalv46 = :odoPdentalv46"),
    @NamedQuery(name = "OOdontograma.findByOdoPdentalv45", query = "SELECT o FROM OOdontograma o WHERE o.odoPdentalv45 = :odoPdentalv45"),
    @NamedQuery(name = "OOdontograma.findByOdoPdentalv44", query = "SELECT o FROM OOdontograma o WHERE o.odoPdentalv44 = :odoPdentalv44"),
    @NamedQuery(name = "OOdontograma.findByOdoPdentalv43", query = "SELECT o FROM OOdontograma o WHERE o.odoPdentalv43 = :odoPdentalv43"),
    @NamedQuery(name = "OOdontograma.findByOdoPdentalv42", query = "SELECT o FROM OOdontograma o WHERE o.odoPdentalv42 = :odoPdentalv42"),
    @NamedQuery(name = "OOdontograma.findByOdoPdentalv41", query = "SELECT o FROM OOdontograma o WHERE o.odoPdentalv41 = :odoPdentalv41"),
    @NamedQuery(name = "OOdontograma.findByOdoPdentalv31", query = "SELECT o FROM OOdontograma o WHERE o.odoPdentalv31 = :odoPdentalv31"),
    @NamedQuery(name = "OOdontograma.findByOdoPdentalv32", query = "SELECT o FROM OOdontograma o WHERE o.odoPdentalv32 = :odoPdentalv32"),
    @NamedQuery(name = "OOdontograma.findByOdoPdentalv33", query = "SELECT o FROM OOdontograma o WHERE o.odoPdentalv33 = :odoPdentalv33"),
    @NamedQuery(name = "OOdontograma.findByOdoPdentalv34", query = "SELECT o FROM OOdontograma o WHERE o.odoPdentalv34 = :odoPdentalv34"),
    @NamedQuery(name = "OOdontograma.findByOdoPdentalv35", query = "SELECT o FROM OOdontograma o WHERE o.odoPdentalv35 = :odoPdentalv35"),
    @NamedQuery(name = "OOdontograma.findByOdoPdentalv36", query = "SELECT o FROM OOdontograma o WHERE o.odoPdentalv36 = :odoPdentalv36"),
    @NamedQuery(name = "OOdontograma.findByOdoPdentalv37", query = "SELECT o FROM OOdontograma o WHERE o.odoPdentalv37 = :odoPdentalv37"),
    @NamedQuery(name = "OOdontograma.findByOdoPdentalv38", query = "SELECT o FROM OOdontograma o WHERE o.odoPdentalv38 = :odoPdentalv38"),
    @NamedQuery(name = "OOdontograma.findByOdoPdentall55", query = "SELECT o FROM OOdontograma o WHERE o.odoPdentall55 = :odoPdentall55"),
    @NamedQuery(name = "OOdontograma.findByOdoPdentall54", query = "SELECT o FROM OOdontograma o WHERE o.odoPdentall54 = :odoPdentall54"),
    @NamedQuery(name = "OOdontograma.findByOdoPdentall53", query = "SELECT o FROM OOdontograma o WHERE o.odoPdentall53 = :odoPdentall53"),
    @NamedQuery(name = "OOdontograma.findByOdoPdentall52", query = "SELECT o FROM OOdontograma o WHERE o.odoPdentall52 = :odoPdentall52"),
    @NamedQuery(name = "OOdontograma.findByOdoPdentall51", query = "SELECT o FROM OOdontograma o WHERE o.odoPdentall51 = :odoPdentall51"),
    @NamedQuery(name = "OOdontograma.findByOdoPdentall61", query = "SELECT o FROM OOdontograma o WHERE o.odoPdentall61 = :odoPdentall61"),
    @NamedQuery(name = "OOdontograma.findByOdoPdentall62", query = "SELECT o FROM OOdontograma o WHERE o.odoPdentall62 = :odoPdentall62"),
    @NamedQuery(name = "OOdontograma.findByOdoPdentall63", query = "SELECT o FROM OOdontograma o WHERE o.odoPdentall63 = :odoPdentall63"),
    @NamedQuery(name = "OOdontograma.findByOdoPdentall64", query = "SELECT o FROM OOdontograma o WHERE o.odoPdentall64 = :odoPdentall64"),
    @NamedQuery(name = "OOdontograma.findByOdoPdentall65", query = "SELECT o FROM OOdontograma o WHERE o.odoPdentall65 = :odoPdentall65"),
    @NamedQuery(name = "OOdontograma.findByOdoPdentall85", query = "SELECT o FROM OOdontograma o WHERE o.odoPdentall85 = :odoPdentall85"),
    @NamedQuery(name = "OOdontograma.findByOdoPdentall84", query = "SELECT o FROM OOdontograma o WHERE o.odoPdentall84 = :odoPdentall84"),
    @NamedQuery(name = "OOdontograma.findByOdoPdentall83", query = "SELECT o FROM OOdontograma o WHERE o.odoPdentall83 = :odoPdentall83"),
    @NamedQuery(name = "OOdontograma.findByOdoPdentall82", query = "SELECT o FROM OOdontograma o WHERE o.odoPdentall82 = :odoPdentall82"),
    @NamedQuery(name = "OOdontograma.findByOdoPdentall81", query = "SELECT o FROM OOdontograma o WHERE o.odoPdentall81 = :odoPdentall81"),
    @NamedQuery(name = "OOdontograma.findByOdoPdentall71", query = "SELECT o FROM OOdontograma o WHERE o.odoPdentall71 = :odoPdentall71"),
    @NamedQuery(name = "OOdontograma.findByOdoPdentall72", query = "SELECT o FROM OOdontograma o WHERE o.odoPdentall72 = :odoPdentall72"),
    @NamedQuery(name = "OOdontograma.findByOdoPdentall73", query = "SELECT o FROM OOdontograma o WHERE o.odoPdentall73 = :odoPdentall73"),
    @NamedQuery(name = "OOdontograma.findByOdoPdentall74", query = "SELECT o FROM OOdontograma o WHERE o.odoPdentall74 = :odoPdentall74"),
    @NamedQuery(name = "OOdontograma.findByOdoPdentall75", query = "SELECT o FROM OOdontograma o WHERE o.odoPdentall75 = :odoPdentall75"),
    @NamedQuery(name = "OOdontograma.findByOdoObservacion", query = "SELECT o FROM OOdontograma o WHERE o.odoObservacion = :odoObservacion")})
public class OOdontograma implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ODO_ID")
    private BigDecimal odoId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ODO_FECHA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date odoFecha;
    @Size(max = 50)
    @Column(name = "ODO_PDENTALV_18")
    private String odoPdentalv18;
    @Size(max = 50)
    @Column(name = "ODO_PDENTALV_17")
    private String odoPdentalv17;
    @Size(max = 50)
    @Column(name = "ODO_PDENTALV_16")
    private String odoPdentalv16;
    @Size(max = 50)
    @Column(name = "ODO_PDENTALV_15")
    private String odoPdentalv15;
    @Size(max = 50)
    @Column(name = "ODO_PDENTALV_14")
    private String odoPdentalv14;
    @Size(max = 50)
    @Column(name = "ODO_PDENTALV_13")
    private String odoPdentalv13;
    @Size(max = 50)
    @Column(name = "ODO_PDENTALV_12")
    private String odoPdentalv12;
    @Size(max = 50)
    @Column(name = "ODO_PDENTALV_11")
    private String odoPdentalv11;
    @Size(max = 50)
    @Column(name = "ODO_PDENTALV_21")
    private String odoPdentalv21;
    @Size(max = 50)
    @Column(name = "ODO_PDENTALV_22")
    private String odoPdentalv22;
    @Size(max = 50)
    @Column(name = "ODO_PDENTALV_23")
    private String odoPdentalv23;
    @Size(max = 50)
    @Column(name = "ODO_PDENTALV_24")
    private String odoPdentalv24;
    @Size(max = 50)
    @Column(name = "ODO_PDENTALV_25")
    private String odoPdentalv25;
    @Size(max = 50)
    @Column(name = "ODO_PDENTALV_26")
    private String odoPdentalv26;
    @Size(max = 50)
    @Column(name = "ODO_PDENTALV_27")
    private String odoPdentalv27;
    @Size(max = 50)
    @Column(name = "ODO_PDENTALV_28")
    private String odoPdentalv28;
    @Size(max = 50)
    @Column(name = "ODO_PDENTALV_48")
    private String odoPdentalv48;
    @Size(max = 50)
    @Column(name = "ODO_PDENTALV_47")
    private String odoPdentalv47;
    @Size(max = 50)
    @Column(name = "ODO_PDENTALV_46")
    private String odoPdentalv46;
    @Size(max = 50)
    @Column(name = "ODO_PDENTALV_45")
    private String odoPdentalv45;
    @Size(max = 50)
    @Column(name = "ODO_PDENTALV_44")
    private String odoPdentalv44;
    @Size(max = 50)
    @Column(name = "ODO_PDENTALV_43")
    private String odoPdentalv43;
    @Size(max = 50)
    @Column(name = "ODO_PDENTALV_42")
    private String odoPdentalv42;
    @Size(max = 50)
    @Column(name = "ODO_PDENTALV_41")
    private String odoPdentalv41;
    @Size(max = 50)
    @Column(name = "ODO_PDENTALV_31")
    private String odoPdentalv31;
    @Size(max = 50)
    @Column(name = "ODO_PDENTALV_32")
    private String odoPdentalv32;
    @Size(max = 50)
    @Column(name = "ODO_PDENTALV_33")
    private String odoPdentalv33;
    @Size(max = 50)
    @Column(name = "ODO_PDENTALV_34")
    private String odoPdentalv34;
    @Size(max = 50)
    @Column(name = "ODO_PDENTALV_35")
    private String odoPdentalv35;
    @Size(max = 50)
    @Column(name = "ODO_PDENTALV_36")
    private String odoPdentalv36;
    @Size(max = 50)
    @Column(name = "ODO_PDENTALV_37")
    private String odoPdentalv37;
    @Size(max = 50)
    @Column(name = "ODO_PDENTALV_38")
    private String odoPdentalv38;
    @Size(max = 50)
    @Column(name = "ODO_PDENTALL_55")
    private String odoPdentall55;
    @Size(max = 50)
    @Column(name = "ODO_PDENTALL_54")
    private String odoPdentall54;
    @Size(max = 50)
    @Column(name = "ODO_PDENTALL_53")
    private String odoPdentall53;
    @Size(max = 50)
    @Column(name = "ODO_PDENTALL_52")
    private String odoPdentall52;
    @Size(max = 50)
    @Column(name = "ODO_PDENTALL_51")
    private String odoPdentall51;
    @Size(max = 50)
    @Column(name = "ODO_PDENTALL_61")
    private String odoPdentall61;
    @Size(max = 50)
    @Column(name = "ODO_PDENTALL_62")
    private String odoPdentall62;
    @Size(max = 50)
    @Column(name = "ODO_PDENTALL_63")
    private String odoPdentall63;
    @Size(max = 50)
    @Column(name = "ODO_PDENTALL_64")
    private String odoPdentall64;
    @Size(max = 50)
    @Column(name = "ODO_PDENTALL_65")
    private String odoPdentall65;
    @Size(max = 50)
    @Column(name = "ODO_PDENTALL_85")
    private String odoPdentall85;
    @Size(max = 50)
    @Column(name = "ODO_PDENTALL_84")
    private String odoPdentall84;
    @Size(max = 50)
    @Column(name = "ODO_PDENTALL_83")
    private String odoPdentall83;
    @Size(max = 50)
    @Column(name = "ODO_PDENTALL_82")
    private String odoPdentall82;
    @Size(max = 50)
    @Column(name = "ODO_PDENTALL_81")
    private String odoPdentall81;
    @Size(max = 50)
    @Column(name = "ODO_PDENTALL_71")
    private String odoPdentall71;
    @Size(max = 50)
    @Column(name = "ODO_PDENTALL_72")
    private String odoPdentall72;
    @Size(max = 50)
    @Column(name = "ODO_PDENTALL_73")
    private String odoPdentall73;
    @Size(max = 50)
    @Column(name = "ODO_PDENTALL_74")
    private String odoPdentall74;
    @Size(max = 50)
    @Column(name = "ODO_PDENTALL_75")
    private String odoPdentall75;
    @Size(max = 240)
    @Column(name = "ODO_OBSERVACION")
    private String odoObservacion;
    @JoinColumn(name = "PCN_NUMERO_HC", referencedColumnName = "NUMERO_HC")
    @ManyToOne
    private Pacientes pacientes;
    @JoinColumn(name = "HJAEVL_NUMERO", referencedColumnName = "NUMERO")
    @ManyToOne
    private HojasDeEvolucion hojasDeEvolucion;

    public OOdontograma() {
    }

    public OOdontograma(BigDecimal odoId) {
        this.odoId = odoId;
    }

    public OOdontograma(BigDecimal odoId, Date odoFecha) {
        this.odoId = odoId;
        this.odoFecha = odoFecha;
    }

    public BigDecimal getOdoId() {
        return odoId;
    }

    public void setOdoId(BigDecimal odoId) {
        this.odoId = odoId;
    }

    public Date getOdoFecha() {
        return odoFecha;
    }

    public void setOdoFecha(Date odoFecha) {
        this.odoFecha = odoFecha;
    }

    public String getOdoPdentalv18() {
        return odoPdentalv18;
    }

    public void setOdoPdentalv18(String odoPdentalv18) {
        this.odoPdentalv18 = odoPdentalv18;
    }

    public String getOdoPdentalv17() {
        return odoPdentalv17;
    }

    public void setOdoPdentalv17(String odoPdentalv17) {
        this.odoPdentalv17 = odoPdentalv17;
    }

    public String getOdoPdentalv16() {
        return odoPdentalv16;
    }

    public void setOdoPdentalv16(String odoPdentalv16) {
        this.odoPdentalv16 = odoPdentalv16;
    }

    public String getOdoPdentalv15() {
        return odoPdentalv15;
    }

    public void setOdoPdentalv15(String odoPdentalv15) {
        this.odoPdentalv15 = odoPdentalv15;
    }

    public String getOdoPdentalv14() {
        return odoPdentalv14;
    }

    public void setOdoPdentalv14(String odoPdentalv14) {
        this.odoPdentalv14 = odoPdentalv14;
    }

    public String getOdoPdentalv13() {
        return odoPdentalv13;
    }

    public void setOdoPdentalv13(String odoPdentalv13) {
        this.odoPdentalv13 = odoPdentalv13;
    }

    public String getOdoPdentalv12() {
        return odoPdentalv12;
    }

    public void setOdoPdentalv12(String odoPdentalv12) {
        this.odoPdentalv12 = odoPdentalv12;
    }

    public String getOdoPdentalv11() {
        return odoPdentalv11;
    }

    public void setOdoPdentalv11(String odoPdentalv11) {
        this.odoPdentalv11 = odoPdentalv11;
    }

    public String getOdoPdentalv21() {
        return odoPdentalv21;
    }

    public void setOdoPdentalv21(String odoPdentalv21) {
        this.odoPdentalv21 = odoPdentalv21;
    }

    public String getOdoPdentalv22() {
        return odoPdentalv22;
    }

    public void setOdoPdentalv22(String odoPdentalv22) {
        this.odoPdentalv22 = odoPdentalv22;
    }

    public String getOdoPdentalv23() {
        return odoPdentalv23;
    }

    public void setOdoPdentalv23(String odoPdentalv23) {
        this.odoPdentalv23 = odoPdentalv23;
    }

    public String getOdoPdentalv24() {
        return odoPdentalv24;
    }

    public void setOdoPdentalv24(String odoPdentalv24) {
        this.odoPdentalv24 = odoPdentalv24;
    }

    public String getOdoPdentalv25() {
        return odoPdentalv25;
    }

    public void setOdoPdentalv25(String odoPdentalv25) {
        this.odoPdentalv25 = odoPdentalv25;
    }

    public String getOdoPdentalv26() {
        return odoPdentalv26;
    }

    public void setOdoPdentalv26(String odoPdentalv26) {
        this.odoPdentalv26 = odoPdentalv26;
    }

    public String getOdoPdentalv27() {
        return odoPdentalv27;
    }

    public void setOdoPdentalv27(String odoPdentalv27) {
        this.odoPdentalv27 = odoPdentalv27;
    }

    public String getOdoPdentalv28() {
        return odoPdentalv28;
    }

    public void setOdoPdentalv28(String odoPdentalv28) {
        this.odoPdentalv28 = odoPdentalv28;
    }

    public String getOdoPdentalv48() {
        return odoPdentalv48;
    }

    public void setOdoPdentalv48(String odoPdentalv48) {
        this.odoPdentalv48 = odoPdentalv48;
    }

    public String getOdoPdentalv47() {
        return odoPdentalv47;
    }

    public void setOdoPdentalv47(String odoPdentalv47) {
        this.odoPdentalv47 = odoPdentalv47;
    }

    public String getOdoPdentalv46() {
        return odoPdentalv46;
    }

    public void setOdoPdentalv46(String odoPdentalv46) {
        this.odoPdentalv46 = odoPdentalv46;
    }

    public String getOdoPdentalv45() {
        return odoPdentalv45;
    }

    public void setOdoPdentalv45(String odoPdentalv45) {
        this.odoPdentalv45 = odoPdentalv45;
    }

    public String getOdoPdentalv44() {
        return odoPdentalv44;
    }

    public void setOdoPdentalv44(String odoPdentalv44) {
        this.odoPdentalv44 = odoPdentalv44;
    }

    public String getOdoPdentalv43() {
        return odoPdentalv43;
    }

    public void setOdoPdentalv43(String odoPdentalv43) {
        this.odoPdentalv43 = odoPdentalv43;
    }

    public String getOdoPdentalv42() {
        return odoPdentalv42;
    }

    public void setOdoPdentalv42(String odoPdentalv42) {
        this.odoPdentalv42 = odoPdentalv42;
    }

    public String getOdoPdentalv41() {
        return odoPdentalv41;
    }

    public void setOdoPdentalv41(String odoPdentalv41) {
        this.odoPdentalv41 = odoPdentalv41;
    }

    public String getOdoPdentalv31() {
        return odoPdentalv31;
    }

    public void setOdoPdentalv31(String odoPdentalv31) {
        this.odoPdentalv31 = odoPdentalv31;
    }

    public String getOdoPdentalv32() {
        return odoPdentalv32;
    }

    public void setOdoPdentalv32(String odoPdentalv32) {
        this.odoPdentalv32 = odoPdentalv32;
    }

    public String getOdoPdentalv33() {
        return odoPdentalv33;
    }

    public void setOdoPdentalv33(String odoPdentalv33) {
        this.odoPdentalv33 = odoPdentalv33;
    }

    public String getOdoPdentalv34() {
        return odoPdentalv34;
    }

    public void setOdoPdentalv34(String odoPdentalv34) {
        this.odoPdentalv34 = odoPdentalv34;
    }

    public String getOdoPdentalv35() {
        return odoPdentalv35;
    }

    public void setOdoPdentalv35(String odoPdentalv35) {
        this.odoPdentalv35 = odoPdentalv35;
    }

    public String getOdoPdentalv36() {
        return odoPdentalv36;
    }

    public void setOdoPdentalv36(String odoPdentalv36) {
        this.odoPdentalv36 = odoPdentalv36;
    }

    public String getOdoPdentalv37() {
        return odoPdentalv37;
    }

    public void setOdoPdentalv37(String odoPdentalv37) {
        this.odoPdentalv37 = odoPdentalv37;
    }

    public String getOdoPdentalv38() {
        return odoPdentalv38;
    }

    public void setOdoPdentalv38(String odoPdentalv38) {
        this.odoPdentalv38 = odoPdentalv38;
    }

    public String getOdoPdentall55() {
        return odoPdentall55;
    }

    public void setOdoPdentall55(String odoPdentall55) {
        this.odoPdentall55 = odoPdentall55;
    }

    public String getOdoPdentall54() {
        return odoPdentall54;
    }

    public void setOdoPdentall54(String odoPdentall54) {
        this.odoPdentall54 = odoPdentall54;
    }

    public String getOdoPdentall53() {
        return odoPdentall53;
    }

    public void setOdoPdentall53(String odoPdentall53) {
        this.odoPdentall53 = odoPdentall53;
    }

    public String getOdoPdentall52() {
        return odoPdentall52;
    }

    public void setOdoPdentall52(String odoPdentall52) {
        this.odoPdentall52 = odoPdentall52;
    }

    public String getOdoPdentall51() {
        return odoPdentall51;
    }

    public void setOdoPdentall51(String odoPdentall51) {
        this.odoPdentall51 = odoPdentall51;
    }

    public String getOdoPdentall61() {
        return odoPdentall61;
    }

    public void setOdoPdentall61(String odoPdentall61) {
        this.odoPdentall61 = odoPdentall61;
    }

    public String getOdoPdentall62() {
        return odoPdentall62;
    }

    public void setOdoPdentall62(String odoPdentall62) {
        this.odoPdentall62 = odoPdentall62;
    }

    public String getOdoPdentall63() {
        return odoPdentall63;
    }

    public void setOdoPdentall63(String odoPdentall63) {
        this.odoPdentall63 = odoPdentall63;
    }

    public String getOdoPdentall64() {
        return odoPdentall64;
    }

    public void setOdoPdentall64(String odoPdentall64) {
        this.odoPdentall64 = odoPdentall64;
    }

    public String getOdoPdentall65() {
        return odoPdentall65;
    }

    public void setOdoPdentall65(String odoPdentall65) {
        this.odoPdentall65 = odoPdentall65;
    }

    public String getOdoPdentall85() {
        return odoPdentall85;
    }

    public void setOdoPdentall85(String odoPdentall85) {
        this.odoPdentall85 = odoPdentall85;
    }

    public String getOdoPdentall84() {
        return odoPdentall84;
    }

    public void setOdoPdentall84(String odoPdentall84) {
        this.odoPdentall84 = odoPdentall84;
    }

    public String getOdoPdentall83() {
        return odoPdentall83;
    }

    public void setOdoPdentall83(String odoPdentall83) {
        this.odoPdentall83 = odoPdentall83;
    }

    public String getOdoPdentall82() {
        return odoPdentall82;
    }

    public void setOdoPdentall82(String odoPdentall82) {
        this.odoPdentall82 = odoPdentall82;
    }

    public String getOdoPdentall81() {
        return odoPdentall81;
    }

    public void setOdoPdentall81(String odoPdentall81) {
        this.odoPdentall81 = odoPdentall81;
    }

    public String getOdoPdentall71() {
        return odoPdentall71;
    }

    public void setOdoPdentall71(String odoPdentall71) {
        this.odoPdentall71 = odoPdentall71;
    }

    public String getOdoPdentall72() {
        return odoPdentall72;
    }

    public void setOdoPdentall72(String odoPdentall72) {
        this.odoPdentall72 = odoPdentall72;
    }

    public String getOdoPdentall73() {
        return odoPdentall73;
    }

    public void setOdoPdentall73(String odoPdentall73) {
        this.odoPdentall73 = odoPdentall73;
    }

    public String getOdoPdentall74() {
        return odoPdentall74;
    }

    public void setOdoPdentall74(String odoPdentall74) {
        this.odoPdentall74 = odoPdentall74;
    }

    public String getOdoPdentall75() {
        return odoPdentall75;
    }

    public void setOdoPdentall75(String odoPdentall75) {
        this.odoPdentall75 = odoPdentall75;
    }

    public String getOdoObservacion() {
        return odoObservacion;
    }

    public void setOdoObservacion(String odoObservacion) {
        this.odoObservacion = odoObservacion;
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
        hash += (odoId != null ? odoId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OOdontograma)) {
            return false;
        }
        OOdontograma other = (OOdontograma) object;
        if ((this.odoId == null && other.odoId != null) || (this.odoId != null && !this.odoId.equals(other.odoId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "he1.entities.OOdontograma[ odoId=" + odoId + " ]";
    }

}
