/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package he1.uci.entities;

import he1.sis.entities.Pacientes;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author luis_guanoluiza
 */
@Entity
@Table(name = "U_OPCION_PACIENTE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UOpcionPaciente.findAll", query = "SELECT u FROM UOpcionPaciente u"),
    @NamedQuery(name = "UOpcionPaciente.findByOppId", query = "SELECT u FROM UOpcionPaciente u WHERE u.oppId = :oppId"),
    @NamedQuery(name = "UOpcionPaciente.findByHjaevlNumero", query = "SELECT u FROM UOpcionPaciente u WHERE u.hjaevlNumero = :hjaevlNumero"),
    @NamedQuery(name = "UOpcionPaciente.findByOppFecha", query = "SELECT u FROM UOpcionPaciente u WHERE u.oppFecha = :oppFecha"),
    @NamedQuery(name = "UOpcionPaciente.findByOppHora", query = "SELECT u FROM UOpcionPaciente u WHERE u.oppHora = :oppHora")})
public class UOpcionPaciente implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "OPP_ID")
    private BigDecimal oppId;
//    @Basic(optional = false)
//    @NotNull
//    @Column(name = "PCN_NUMERO_HC")
//    private BigInteger pcnNumeroHc;
    @JoinColumn(name = "PCN_NUMERO_HC", referencedColumnName = "NUMERO_HC")
    @ManyToOne
    private Pacientes pacientes;
    @Basic(optional = false)
    @NotNull
    @Column(name = "HJAEVL_NUMERO")
    private BigInteger hjaevlNumero;
    @Basic(optional = false)
    @NotNull
    @Column(name = "OPP_FECHA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date oppFecha;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "OPP_HORA")
    private String oppHora;
    @Size(max = 20)
    @Column(name = "OPP_BALANCE_DIARIO")
    private String oppBalanceDiario;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "uOpcionPaciente")
    private List<UCuidados2> uCuidados2List;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "uOpcionPaciente")
    private List<UCuidados1> uCuidados1List;
    @JoinColumn(name = "UCI_ID", referencedColumnName = "UCI_ID")
    @ManyToOne
    private UUciMenu uUciMenu;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "uOpcionPaciente")
    private List<UHorario> uHorarioList;

    public UOpcionPaciente() {
    }

    public UOpcionPaciente(BigDecimal oppId) {
        this.oppId = oppId;
    }

    public UOpcionPaciente(BigDecimal oppId, BigInteger pcnNumeroHc, BigInteger hjaevlNumero, Date oppFecha, String oppHora) {
        this.oppId = oppId;
        //this.pcnNumeroHc = pcnNumeroHc;
        this.pacientes = pacientes;
        this.hjaevlNumero = hjaevlNumero;
        this.oppFecha = oppFecha;
        this.oppHora = oppHora;
    }

    public BigDecimal getOppId() {
        return oppId;
    }

    public void setOppId(BigDecimal oppId) {
        this.oppId = oppId;
    }

    public Pacientes getPacientes() {
        return pacientes;
    }

//    public BigInteger getPcnNumeroHc() {
//        return pcnNumeroHc;
//    }
//
//    public void setPcnNumeroHc(BigInteger pcnNumeroHc) {
//        this.pcnNumeroHc = pcnNumeroHc;
//    }
    public void setPacientes(Pacientes pacientes) {
        this.pacientes = pacientes;
    }

    public BigInteger getHjaevlNumero() {
        return hjaevlNumero;
    }

    public void setHjaevlNumero(BigInteger hjaevlNumero) {
        this.hjaevlNumero = hjaevlNumero;
    }

    public Date getOppFecha() {
        return oppFecha;
    }

    public void setOppFecha(Date oppFecha) {
        this.oppFecha = oppFecha;
    }

    public String getOppHora() {
        return oppHora;
    }

    public void setOppHora(String oppHora) {
        this.oppHora = oppHora;
    }

    public String getOppBalanceDiario() {
        return oppBalanceDiario;
    }

    public void setOppBalanceDiario(String oppBalanceDiario) {
        this.oppBalanceDiario = oppBalanceDiario;
    }

    @XmlTransient
    public List<UCuidados2> getUCuidados2List() {
        return uCuidados2List;
    }

    public void setUCuidados2List(List<UCuidados2> uCuidados2List) {
        this.uCuidados2List = uCuidados2List;
    }

    @XmlTransient
    public List<UCuidados1> getUCuidados1List() {
        return uCuidados1List;
    }

    public void setUCuidados1List(List<UCuidados1> uCuidados1List) {
        this.uCuidados1List = uCuidados1List;
    }

    public UUciMenu getUUciMenu() {
        return uUciMenu;
    }

    public void setUUciMenu(UUciMenu uUciMenu) {
        this.uUciMenu = uUciMenu;
    }

    @XmlTransient
    public List<UHorario> getUHorarioList() {
        return uHorarioList;
    }

    public void setUHorarioList(List<UHorario> uHorarioList) {
        this.uHorarioList = uHorarioList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (oppId != null ? oppId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UOpcionPaciente)) {
            return false;
        }
        UOpcionPaciente other = (UOpcionPaciente) object;
        if ((this.oppId == null && other.oppId != null) || (this.oppId != null && !this.oppId.equals(other.oppId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "he1.uci.entities.UOpcionPaciente[ oppId=" + oppId + " ]";
    }

}
