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
@Table(name = "U_ULCERAS_X_PRESION")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UUlcerasXPresion.findAll", query = "SELECT u FROM UUlcerasXPresion u"),
    @NamedQuery(name = "UUlcerasXPresion.findByUppId", query = "SELECT u FROM UUlcerasXPresion u WHERE u.uppId = :uppId"),
    @NamedQuery(name = "UUlcerasXPresion.findByUppFecha", query = "SELECT u FROM UUlcerasXPresion u WHERE u.uppFecha = :uppFecha"),
    @NamedQuery(name = "UUlcerasXPresion.findByUppDdTalones", query = "SELECT u FROM UUlcerasXPresion u WHERE u.uppDdTalones = :uppDdTalones"),
    @NamedQuery(name = "UUlcerasXPresion.findByUppDdSacro", query = "SELECT u FROM UUlcerasXPresion u WHERE u.uppDdSacro = :uppDdSacro"),
    @NamedQuery(name = "UUlcerasXPresion.findByUppDdCodos", query = "SELECT u FROM UUlcerasXPresion u WHERE u.uppDdCodos = :uppDdCodos"),
    @NamedQuery(name = "UUlcerasXPresion.findByUppDdOmoplato", query = "SELECT u FROM UUlcerasXPresion u WHERE u.uppDdOmoplato = :uppDdOmoplato"),
    @NamedQuery(name = "UUlcerasXPresion.findByUppDdCabeza", query = "SELECT u FROM UUlcerasXPresion u WHERE u.uppDdCabeza = :uppDdCabeza"),
    @NamedQuery(name = "UUlcerasXPresion.findByUppDlMalcolo", query = "SELECT u FROM UUlcerasXPresion u WHERE u.uppDlMalcolo = :uppDlMalcolo"),
    @NamedQuery(name = "UUlcerasXPresion.findByUppDlCondilos", query = "SELECT u FROM UUlcerasXPresion u WHERE u.uppDlCondilos = :uppDlCondilos"),
    @NamedQuery(name = "UUlcerasXPresion.findByUppDlTroncater", query = "SELECT u FROM UUlcerasXPresion u WHERE u.uppDlTroncater = :uppDlTroncater"),
    @NamedQuery(name = "UUlcerasXPresion.findByUppDlCostillas", query = "SELECT u FROM UUlcerasXPresion u WHERE u.uppDlCostillas = :uppDlCostillas"),
    @NamedQuery(name = "UUlcerasXPresion.findByUppDlAcromion", query = "SELECT u FROM UUlcerasXPresion u WHERE u.uppDlAcromion = :uppDlAcromion"),
    @NamedQuery(name = "UUlcerasXPresion.findByUppDlOreja", query = "SELECT u FROM UUlcerasXPresion u WHERE u.uppDlOreja = :uppDlOreja"),
    @NamedQuery(name = "UUlcerasXPresion.findByUppDpDedos", query = "SELECT u FROM UUlcerasXPresion u WHERE u.uppDpDedos = :uppDpDedos"),
    @NamedQuery(name = "UUlcerasXPresion.findByUppDpRodillas", query = "SELECT u FROM UUlcerasXPresion u WHERE u.uppDpRodillas = :uppDpRodillas"),
    @NamedQuery(name = "UUlcerasXPresion.findByUppDpGenitales", query = "SELECT u FROM UUlcerasXPresion u WHERE u.uppDpGenitales = :uppDpGenitales"),
    @NamedQuery(name = "UUlcerasXPresion.findByUppDpMamas", query = "SELECT u FROM UUlcerasXPresion u WHERE u.uppDpMamas = :uppDpMamas"),
    @NamedQuery(name = "UUlcerasXPresion.findByUppDpAcromion", query = "SELECT u FROM UUlcerasXPresion u WHERE u.uppDpAcromion = :uppDpAcromion"),
    @NamedQuery(name = "UUlcerasXPresion.findByUppDpMejilla", query = "SELECT u FROM UUlcerasXPresion u WHERE u.uppDpMejilla = :uppDpMejilla")})
public class UUlcerasXPresion implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "UPP_ID")
    private BigDecimal uppId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "UPP_FECHA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date uppFecha;
    @Size(max = 1)
    @Column(name = "UPP_DD_TALONES")
    private String uppDdTalones;
    @Size(max = 1)
    @Column(name = "UPP_DD_SACRO")
    private String uppDdSacro;
    @Size(max = 1)
    @Column(name = "UPP_DD_CODOS")
    private String uppDdCodos;
    @Size(max = 1)
    @Column(name = "UPP_DD_OMOPLATO")
    private String uppDdOmoplato;
    @Size(max = 1)
    @Column(name = "UPP_DD_CABEZA")
    private String uppDdCabeza;
    @Size(max = 1)
    @Column(name = "UPP_DL_MALCOLO")
    private String uppDlMalcolo;
    @Size(max = 1)
    @Column(name = "UPP_DL_CONDILOS")
    private String uppDlCondilos;
    @Size(max = 1)
    @Column(name = "UPP_DL_TRONCATER")
    private String uppDlTroncater;
    @Size(max = 1)
    @Column(name = "UPP_DL_COSTILLAS")
    private String uppDlCostillas;
    @Size(max = 1)
    @Column(name = "UPP_DL_ACROMION")
    private String uppDlAcromion;
    @Size(max = 1)
    @Column(name = "UPP_DL_OREJA")
    private String uppDlOreja;
    @Size(max = 1)
    @Column(name = "UPP_DP_DEDOS")
    private String uppDpDedos;
    @Size(max = 1)
    @Column(name = "UPP_DP_RODILLAS")
    private String uppDpRodillas;
    @Size(max = 1)
    @Column(name = "UPP_DP_GENITALES")
    private String uppDpGenitales;
    @Size(max = 1)
    @Column(name = "UPP_DP_MAMAS")
    private String uppDpMamas;
    @Size(max = 1)
    @Column(name = "UPP_DP_ACROMION")
    private String uppDpAcromion;
    @Size(max = 1)
    @Column(name = "UPP_DP_MEJILLA")
    private String uppDpMejilla;
    @Size(max = 240)
    @Column(name = "UPP_OBSERVACION")
    private String uppObservacion;
    @JoinColumn(name = "OPP_ID", referencedColumnName = "OPP_ID")
    @ManyToOne(optional = false)
    private UOpcionPaciente uOpcionPaciente;
    @JoinColumn(name = "OPC_ID", referencedColumnName = "OPC_ID")
    @ManyToOne(optional = false)
    private UOpciones uOpciones;

    public UUlcerasXPresion() {
    }

    public UUlcerasXPresion(BigDecimal uppId) {
        this.uppId = uppId;
    }

    public UUlcerasXPresion(BigDecimal uppId, Date uppFecha) {
        this.uppId = uppId;
        this.uppFecha = uppFecha;
    }

    public BigDecimal getUppId() {
        return uppId;
    }

    public void setUppId(BigDecimal uppId) {
        this.uppId = uppId;
    }

    public Date getUppFecha() {
        return uppFecha;
    }

    public void setUppFecha(Date uppFecha) {
        this.uppFecha = uppFecha;
    }

    public String getUppDdTalones() {
        return uppDdTalones;
    }

    public void setUppDdTalones(String uppDdTalones) {
        this.uppDdTalones = uppDdTalones;
    }

    public String getUppDdSacro() {
        return uppDdSacro;
    }

    public void setUppDdSacro(String uppDdSacro) {
        this.uppDdSacro = uppDdSacro;
    }

    public String getUppDdCodos() {
        return uppDdCodos;
    }

    public void setUppDdCodos(String uppDdCodos) {
        this.uppDdCodos = uppDdCodos;
    }

    public String getUppDdOmoplato() {
        return uppDdOmoplato;
    }

    public void setUppDdOmoplato(String uppDdOmoplato) {
        this.uppDdOmoplato = uppDdOmoplato;
    }

    public String getUppDdCabeza() {
        return uppDdCabeza;
    }

    public void setUppDdCabeza(String uppDdCabeza) {
        this.uppDdCabeza = uppDdCabeza;
    }

    public String getUppDlMalcolo() {
        return uppDlMalcolo;
    }

    public void setUppDlMalcolo(String uppDlMalcolo) {
        this.uppDlMalcolo = uppDlMalcolo;
    }

    public String getUppDlCondilos() {
        return uppDlCondilos;
    }

    public void setUppDlCondilos(String uppDlCondilos) {
        this.uppDlCondilos = uppDlCondilos;
    }

    public String getUppDlTroncater() {
        return uppDlTroncater;
    }

    public void setUppDlTroncater(String uppDlTroncater) {
        this.uppDlTroncater = uppDlTroncater;
    }

    public String getUppDlCostillas() {
        return uppDlCostillas;
    }

    public void setUppDlCostillas(String uppDlCostillas) {
        this.uppDlCostillas = uppDlCostillas;
    }

    public String getUppDlAcromion() {
        return uppDlAcromion;
    }

    public void setUppDlAcromion(String uppDlAcromion) {
        this.uppDlAcromion = uppDlAcromion;
    }

    public String getUppDlOreja() {
        return uppDlOreja;
    }

    public void setUppDlOreja(String uppDlOreja) {
        this.uppDlOreja = uppDlOreja;
    }

    public String getUppDpDedos() {
        return uppDpDedos;
    }

    public void setUppDpDedos(String uppDpDedos) {
        this.uppDpDedos = uppDpDedos;
    }

    public String getUppDpRodillas() {
        return uppDpRodillas;
    }

    public void setUppDpRodillas(String uppDpRodillas) {
        this.uppDpRodillas = uppDpRodillas;
    }

    public String getUppDpGenitales() {
        return uppDpGenitales;
    }

    public void setUppDpGenitales(String uppDpGenitales) {
        this.uppDpGenitales = uppDpGenitales;
    }

    public String getUppDpMamas() {
        return uppDpMamas;
    }

    public void setUppDpMamas(String uppDpMamas) {
        this.uppDpMamas = uppDpMamas;
    }

    public String getUppDpAcromion() {
        return uppDpAcromion;
    }

    public void setUppDpAcromion(String uppDpAcromion) {
        this.uppDpAcromion = uppDpAcromion;
    }

    public String getUppDpMejilla() {
        return uppDpMejilla;
    }

    public void setUppDpMejilla(String uppDpMejilla) {
        this.uppDpMejilla = uppDpMejilla;
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

    public String getUppObservacion() {
        return uppObservacion;
    }

    public void setUppObservacion(String uppObservacion) {
        this.uppObservacion = uppObservacion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (uppId != null ? uppId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UUlcerasXPresion)) {
            return false;
        }
        UUlcerasXPresion other = (UUlcerasXPresion) object;
        if ((this.uppId == null && other.uppId != null) || (this.uppId != null && !this.uppId.equals(other.uppId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "he1.uci.entidades.UUlcerasXPresion[ uppId=" + uppId + " ]";
    }

}
