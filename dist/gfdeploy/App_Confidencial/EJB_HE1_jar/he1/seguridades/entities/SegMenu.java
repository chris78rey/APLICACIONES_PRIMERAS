/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package he1.seguridades.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author christian_ruiz
 */
@Entity
@Table(name = "SEG_MENU")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SegMenu.findAll", query = "SELECT s FROM SegMenu s"),
    @NamedQuery(name = "SegMenu.findByMenId", query = "SELECT s FROM SegMenu s WHERE s.menId = :menId"),
    @NamedQuery(name = "SegMenu.findByMenNivel", query = "SELECT s FROM SegMenu s WHERE s.menNivel = :menNivel"),
    @NamedQuery(name = "SegMenu.findByMenOrden", query = "SELECT s FROM SegMenu s WHERE s.menOrden = :menOrden"),
    @NamedQuery(name = "SegMenu.findByMenDisplay", query = "SELECT s FROM SegMenu s WHERE s.menDisplay = :menDisplay"),
    @NamedQuery(name = "SegMenu.findByMenUrl", query = "SELECT s FROM SegMenu s WHERE s.menUrl = :menUrl"),
    @NamedQuery(name = "SegMenu.findByMenHide", query = "SELECT s FROM SegMenu s WHERE s.menHide = :menHide")})
public class SegMenu implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @SequenceGenerator(name = "modulos_SEG_MENU_SEQ", sequenceName = "SEGURIDADES.SEG_MENU_SEQ")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "modulos_SEG_MENU_SEQ")
    @Basic(optional = false)
    @NotNull
    @Column(name = "MEN_ID")
    private BigDecimal menId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "MEN_NIVEL")
    private BigInteger menNivel;
    @Basic(optional = false)
    @NotNull
    @Column(name = "MEN_ORDEN")
    private BigInteger menOrden;
    @Size(max = 100)
    @Column(name = "MEN_DISPLAY")
    private String menDisplay;
    @Size(max = 100)
    @Column(name = "MEN_URL")
    private String menUrl;
    @Size(max = 400)
    @Column(name = "MEN_HIDE")
    private String menHide;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "segMenu")
    private List<SegMenuHabilita> segMenuHabilitaList;
    @OneToMany(mappedBy = "segMenu")
    private List<SegMenu> segMenuList;
    @JoinColumn(name = "MEN_ID_RECURSIVO", referencedColumnName = "MEN_ID")
    @ManyToOne
    private SegMenu segMenu;
    @JoinColumn(name = "MOD_ID", referencedColumnName = "MOD_ID")
    @ManyToOne(optional = false)
    private SegModulos segModulos;

    public SegMenu() {
    }

    public SegMenu(BigDecimal menId) {
        this.menId = menId;
    }

    public SegMenu(BigDecimal menId, BigInteger menNivel, BigInteger menOrden) {
        this.menId = menId;
        this.menNivel = menNivel;
        this.menOrden = menOrden;
    }

    public BigDecimal getMenId() {
        return menId;
    }

    public void setMenId(BigDecimal menId) {
        this.menId = menId;
    }

    public BigInteger getMenNivel() {
        return menNivel;
    }

    public void setMenNivel(BigInteger menNivel) {
        this.menNivel = menNivel;
    }

    public BigInteger getMenOrden() {
        return menOrden;
    }

    public void setMenOrden(BigInteger menOrden) {
        this.menOrden = menOrden;
    }

    public String getMenDisplay() {
        return menDisplay;
    }

    public void setMenDisplay(String menDisplay) {
        this.menDisplay = menDisplay;
    }

    public String getMenUrl() {
        return menUrl;
    }

    public void setMenUrl(String menUrl) {
        this.menUrl = menUrl;
    }

    public String getMenHide() {
        return menHide;
    }

    public void setMenHide(String menHide) {
        this.menHide = menHide;
    }

    @XmlTransient
    public List<SegMenuHabilita> getSegMenuHabilitaList() {
        return segMenuHabilitaList;
    }

    public void setSegMenuHabilitaList(List<SegMenuHabilita> segMenuHabilitaList) {
        this.segMenuHabilitaList = segMenuHabilitaList;
    }

    @XmlTransient
    public List<SegMenu> getSegMenuList() {
        return segMenuList;
    }

    public void setSegMenuList(List<SegMenu> segMenuList) {
        this.segMenuList = segMenuList;
    }

    public SegMenu getSegMenu() {
        return segMenu;
    }

    public void setSegMenu(SegMenu segMenu) {
        this.segMenu = segMenu;
    }

    public SegModulos getSegModulos() {
        return segModulos;
    }

    public void setSegModulos(SegModulos segModulos) {
        this.segModulos = segModulos;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (menId != null ? menId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SegMenu)) {
            return false;
        }
        SegMenu other = (SegMenu) object;
        if ((this.menId == null && other.menId != null) || (this.menId != null && !this.menId.equals(other.menId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "he1.seguridades.entities.SegMenu[ menId=" + menId + " ]";
    }

}
