/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package he1.uci.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author luis_guanoluiza
 */
@Entity
@Table(name = "U_UCI_MENU")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UUciMenu.findAll", query = "SELECT u FROM UUciMenu u"),
    @NamedQuery(name = "UUciMenu.findByUciId", query = "SELECT u FROM UUciMenu u WHERE u.uciId = :uciId"),
    @NamedQuery(name = "UUciMenu.findByUciDescripcion", query = "SELECT u FROM UUciMenu u WHERE u.uciDescripcion = :uciDescripcion")})
public class UUciMenu implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "UCI_ID")
    private BigDecimal uciId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "UCI_DESCRIPCION")
    private String uciDescripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "uUciMenu")
    private List<UOpciones> uOpcionesList;
    @OneToMany(mappedBy = "uUciMenu")
    private List<UOpcionPaciente> uOpcionPacienteList;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "uUciMenu1")
    private UUciMenu uUciMenu;
    @JoinColumn(name = "UCI_ID", referencedColumnName = "UCI_ID", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private UUciMenu uUciMenu1;

    public UUciMenu() {
    }

    public UUciMenu(BigDecimal uciId) {
        this.uciId = uciId;
    }

    public UUciMenu(BigDecimal uciId, String uciDescripcion) {
        this.uciId = uciId;
        this.uciDescripcion = uciDescripcion;
    }

    public BigDecimal getUciId() {
        return uciId;
    }

    public void setUciId(BigDecimal uciId) {
        this.uciId = uciId;
    }

    public String getUciDescripcion() {
        return uciDescripcion;
    }

    public void setUciDescripcion(String uciDescripcion) {
        this.uciDescripcion = uciDescripcion;
    }

    @XmlTransient
    public List<UOpciones> getUOpcionesList() {
        return uOpcionesList;
    }

    public void setUOpcionesList(List<UOpciones> uOpcionesList) {
        this.uOpcionesList = uOpcionesList;
    }

    @XmlTransient
    public List<UOpcionPaciente> getUOpcionPacienteList() {
        return uOpcionPacienteList;
    }

    public void setUOpcionPacienteList(List<UOpcionPaciente> uOpcionPacienteList) {
        this.uOpcionPacienteList = uOpcionPacienteList;
    }

    public UUciMenu getUUciMenu() {
        return uUciMenu;
    }

    public void setUUciMenu(UUciMenu uUciMenu) {
        this.uUciMenu = uUciMenu;
    }

    public UUciMenu getUUciMenu1() {
        return uUciMenu1;
    }

    public void setUUciMenu1(UUciMenu uUciMenu1) {
        this.uUciMenu1 = uUciMenu1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (uciId != null ? uciId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UUciMenu)) {
            return false;
        }
        UUciMenu other = (UUciMenu) object;
        if ((this.uciId == null && other.uciId != null) || (this.uciId != null && !this.uciId.equals(other.uciId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "he1.uci.entities.UUciMenu[ uciId=" + uciId + " ]";
    }
    
}
