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
@Table(name = "U_PESO_TALLA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UPesoTalla.findAll", query = "SELECT u FROM UPesoTalla u"),
    @NamedQuery(name = "UPesoTalla.findByPetId", query = "SELECT u FROM UPesoTalla u WHERE u.petId = :petId"),
    @NamedQuery(name = "UPesoTalla.findByPetFecha", query = "SELECT u FROM UPesoTalla u WHERE u.petFecha = :petFecha"),
    @NamedQuery(name = "UPesoTalla.findByPetPeso", query = "SELECT u FROM UPesoTalla u WHERE u.petPeso = :petPeso"),
    @NamedQuery(name = "UPesoTalla.findByPetTalla", query = "SELECT u FROM UPesoTalla u WHERE u.petTalla = :petTalla"),
    @NamedQuery(name = "UPesoTalla.findByPetImc", query = "SELECT u FROM UPesoTalla u WHERE u.petImc = :petImc"),
    @NamedQuery(name = "UPesoTalla.findByPetAsc", query = "SELECT u FROM UPesoTalla u WHERE u.petAsc = :petAsc"),
    @NamedQuery(name = "UPesoTalla.findByPetPci", query = "SELECT u FROM UPesoTalla u WHERE u.petPci = :petPci"),
    @NamedQuery(name = "UPesoTalla.findByPetPesoIdeal", query = "SELECT u FROM UPesoTalla u WHERE u.petPesoIdeal = :petPesoIdeal")})
public class UPesoTalla implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "PET_ID")
    private BigDecimal petId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PET_FECHA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date petFecha;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "PET_PESO")
    private String petPeso;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "PET_TALLA")
    private String petTalla;
    @Size(max = 10)
    @Column(name = "PET_IMC")
    private String petImc;
    @Size(max = 10)
    @Column(name = "PET_ASC")
    private String petAsc;
    @Size(max = 10)
    @Column(name = "PET_PCI")
    private String petPci;
    @Size(max = 10)
    @Column(name = "PET_PESO_IDEAL")
    private String petPesoIdeal;
    @JoinColumn(name = "OPP_ID", referencedColumnName = "OPP_ID")
    @ManyToOne(optional = false)
    private UOpcionPaciente uOpcionPaciente;
    @JoinColumn(name = "OPC_ID", referencedColumnName = "OPC_ID")
    @ManyToOne(optional = false)
    private UOpciones uOpciones;

    public UPesoTalla() {
    }

    public UPesoTalla(BigDecimal petId) {
        this.petId = petId;
    }

    public UPesoTalla(BigDecimal petId, Date petFecha, String petPeso, String petTalla) {
        this.petId = petId;
        this.petFecha = petFecha;
        this.petPeso = petPeso;
        this.petTalla = petTalla;
    }

    public BigDecimal getPetId() {
        return petId;
    }

    public void setPetId(BigDecimal petId) {
        this.petId = petId;
    }

    public Date getPetFecha() {
        return petFecha;
    }

    public void setPetFecha(Date petFecha) {
        this.petFecha = petFecha;
    }

    public String getPetPeso() {
        return petPeso;
    }

    public void setPetPeso(String petPeso) {
        this.petPeso = petPeso;
    }

    public String getPetTalla() {
        return petTalla;
    }

    public void setPetTalla(String petTalla) {
        this.petTalla = petTalla;
    }

    public String getPetImc() {
        return petImc;
    }

    public void setPetImc(String petImc) {
        this.petImc = petImc;
    }

    public String getPetAsc() {
        return petAsc;
    }

    public void setPetAsc(String petAsc) {
        this.petAsc = petAsc;
    }

    public String getPetPci() {
        return petPci;
    }

    public void setPetPci(String petPci) {
        this.petPci = petPci;
    }

    public String getPetPesoIdeal() {
        return petPesoIdeal;
    }

    public void setPetPesoIdeal(String petPesoIdeal) {
        this.petPesoIdeal = petPesoIdeal;
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
        hash += (petId != null ? petId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UPesoTalla)) {
            return false;
        }
        UPesoTalla other = (UPesoTalla) object;
        if ((this.petId == null && other.petId != null) || (this.petId != null && !this.petId.equals(other.petId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.UPesoTalla[ petId=" + petId + " ]";
    }
    
}
