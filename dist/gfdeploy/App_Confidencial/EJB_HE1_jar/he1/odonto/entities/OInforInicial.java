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
@Table(name = "O_INFOR_INICIAL")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OInforInicial.findAll", query = "SELECT o FROM OInforInicial o"),
    @NamedQuery(name = "OInforInicial.findByInfId", query = "SELECT o FROM OInforInicial o WHERE o.infId = :infId"),
    @NamedQuery(name = "OInforInicial.findByInfFecha", query = "SELECT o FROM OInforInicial o WHERE o.infFecha = :infFecha"),
    @NamedQuery(name = "OInforInicial.findByInfEmbarazo", query = "SELECT o FROM OInforInicial o WHERE o.infEmbarazo = :infEmbarazo"),
    @NamedQuery(name = "OInforInicial.findByInfMenorA1", query = "SELECT o FROM OInforInicial o WHERE o.infMenorA1 = :infMenorA1"),
    @NamedQuery(name = "OInforInicial.findByInf1A4", query = "SELECT o FROM OInforInicial o WHERE o.inf1A4 = :inf1A4"),
    @NamedQuery(name = "OInforInicial.findByInf5A9Prog", query = "SELECT o FROM OInforInicial o WHERE o.inf5A9Prog = :inf5A9Prog"),
    @NamedQuery(name = "OInforInicial.findByInf5A9NoProg", query = "SELECT o FROM OInforInicial o WHERE o.inf5A9NoProg = :inf5A9NoProg"),
    @NamedQuery(name = "OInforInicial.findByInf10A14Prog", query = "SELECT o FROM OInforInicial o WHERE o.inf10A14Prog = :inf10A14Prog"),
    @NamedQuery(name = "OInforInicial.findByInf15A19", query = "SELECT o FROM OInforInicial o WHERE o.inf15A19 = :inf15A19"),
    @NamedQuery(name = "OInforInicial.findByInfMayorA20", query = "SELECT o FROM OInforInicial o WHERE o.infMayorA20 = :infMayorA20")})
public class OInforInicial implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "INF_ID")
    private BigDecimal infId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "INF_FECHA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date infFecha;
    @Size(max = 1)
    @Column(name = "INF_EMBARAZO")
    private String infEmbarazo;
    @Size(max = 1)
    @Column(name = "INF_MENOR_A_1")
    private String infMenorA1;
    @Size(max = 1)
    @Column(name = "INF_1_A_4")
    private String inf1A4;
    @Size(max = 1)
    @Column(name = "INF_5_A_9_PROG")
    private String inf5A9Prog;
    @Size(max = 1)
    @Column(name = "INF_5_A_9_NO_PROG")
    private String inf5A9NoProg;
    @Size(max = 1)
    @Column(name = "INF_10_A_14_PROG")
    private String inf10A14Prog;
    @Size(max = 1)
    @Column(name = "INF_15_A_19")
    private String inf15A19;
    @Size(max = 1)
    @Column(name = "INF_MAYOR_A_20")
    private String infMayorA20;
    @JoinColumn(name = "PCN_NUMERO_HC", referencedColumnName = "NUMERO_HC")
    @ManyToOne(optional = false)
    private Pacientes pacientes;
    @JoinColumn(name = "HJAEVL_NUMERO", referencedColumnName = "NUMERO")
    @ManyToOne(optional = false)
    private HojasDeEvolucion hojasDeEvolucion;

    public OInforInicial() {
    }

    public OInforInicial(BigDecimal infId) {
        this.infId = infId;
    }

    public OInforInicial(BigDecimal infId, Date infFecha) {
        this.infId = infId;
        this.infFecha = infFecha;
    }

    public BigDecimal getInfId() {
        return infId;
    }

    public void setInfId(BigDecimal infId) {
        this.infId = infId;
    }

    public Date getInfFecha() {
        return infFecha;
    }

    public void setInfFecha(Date infFecha) {
        this.infFecha = infFecha;
    }

    public String getInfEmbarazo() {
        return infEmbarazo;
    }

    public void setInfEmbarazo(String infEmbarazo) {
        this.infEmbarazo = infEmbarazo;
    }

    public String getInfMenorA1() {
        return infMenorA1;
    }

    public void setInfMenorA1(String infMenorA1) {
        this.infMenorA1 = infMenorA1;
    }

    public String getInf1A4() {
        return inf1A4;
    }

    public void setInf1A4(String inf1A4) {
        this.inf1A4 = inf1A4;
    }

    public String getInf5A9Prog() {
        return inf5A9Prog;
    }

    public void setInf5A9Prog(String inf5A9Prog) {
        this.inf5A9Prog = inf5A9Prog;
    }

    public String getInf5A9NoProg() {
        return inf5A9NoProg;
    }

    public void setInf5A9NoProg(String inf5A9NoProg) {
        this.inf5A9NoProg = inf5A9NoProg;
    }

    public String getInf10A14Prog() {
        return inf10A14Prog;
    }

    public void setInf10A14Prog(String inf10A14Prog) {
        this.inf10A14Prog = inf10A14Prog;
    }

    public String getInf15A19() {
        return inf15A19;
    }

    public void setInf15A19(String inf15A19) {
        this.inf15A19 = inf15A19;
    }

    public String getInfMayorA20() {
        return infMayorA20;
    }

    public void setInfMayorA20(String infMayorA20) {
        this.infMayorA20 = infMayorA20;
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
        hash += (infId != null ? infId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OInforInicial)) {
            return false;
        }
        OInforInicial other = (OInforInicial) object;
        if ((this.infId == null && other.infId != null) || (this.infId != null && !this.infId.equals(other.infId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.OInforInicial[ infId=" + infId + " ]";
    }
    
}
