/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package he1.uci.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
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
@Table(name = "U_OPCIONES")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UOpciones.findAll", query = "SELECT u FROM UOpciones u"),
    @NamedQuery(name = "UOpciones.findByOpcId", query = "SELECT u FROM UOpciones u WHERE u.opcId = :opcId"),
    @NamedQuery(name = "UOpciones.findByOpcDescripcion", query = "SELECT u FROM UOpciones u WHERE u.opcDescripcion = :opcDescripcion"),
    @NamedQuery(name = "UOpciones.findByOpcOrdinal", query = "SELECT u FROM UOpciones u WHERE u.opcOrdinal = :opcOrdinal")})
public class UOpciones implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "OPC_ID")
    private BigDecimal opcId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "OPC_DESCRIPCION")
    private String opcDescripcion;
    @Column(name = "OPC_ORDINAL")
    private BigInteger opcOrdinal;
        @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "OPC_ESTADO")
    private String opcEstado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "uOpciones")
    private List<UCuidados2> uCuidados2List;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "uOpciones")
    private List<UCuidados1> uCuidados1List;
    @JoinColumn(name = "UCI_ID", referencedColumnName = "UCI_ID")
    @ManyToOne(optional = false)
    private UUciMenu uUciMenu;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "uOpciones1")
    private UOpciones uOpciones;
    @JoinColumn(name = "OPC_ID", referencedColumnName = "OPC_ID", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private UOpciones uOpciones1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "uOpciones")
    private List<UHorario> uHorarioList;

    public UOpciones() {
    }

    public UOpciones(BigDecimal opcId) {
        this.opcId = opcId;
    }

    public UOpciones(BigDecimal opcId, String opcDescripcion) {
        this.opcId = opcId;
        this.opcDescripcion = opcDescripcion;
    }

    public BigDecimal getOpcId() {
        return opcId;
    }

    public void setOpcId(BigDecimal opcId) {
        this.opcId = opcId;
    }

    public String getOpcDescripcion() {
        return opcDescripcion;
    }

    public void setOpcDescripcion(String opcDescripcion) {
        this.opcDescripcion = opcDescripcion;
    }

    public BigInteger getOpcOrdinal() {
        return opcOrdinal;
    }

    public void setOpcOrdinal(BigInteger opcOrdinal) {
        this.opcOrdinal = opcOrdinal;
    }

    public String getOpcEstado() {
        return opcEstado;
    }

    public void setOpcEstado(String opcEstado) {
        this.opcEstado = opcEstado;
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

    public UOpciones getUOpciones() {
        return uOpciones;
    }

    public void setUOpciones(UOpciones uOpciones) {
        this.uOpciones = uOpciones;
    }

    public UOpciones getUOpciones1() {
        return uOpciones1;
    }

    public void setUOpciones1(UOpciones uOpciones1) {
        this.uOpciones1 = uOpciones1;
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
        hash += (opcId != null ? opcId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UOpciones)) {
            return false;
        }
        UOpciones other = (UOpciones) object;
        if ((this.opcId == null && other.opcId != null) || (this.opcId != null && !this.opcId.equals(other.opcId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "he1.uci.entities.UOpciones[ opcId=" + opcId + " ]";
    }
    
}
