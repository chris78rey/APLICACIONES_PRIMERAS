/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package he1.sis.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
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
@Table(name = "PARROQUIAS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Parroquias.findAll", query = "SELECT p FROM Parroquias p"),
    @NamedQuery(name = "Parroquias.findByCntPrvCodigo", query = "SELECT p FROM Parroquias p WHERE p.parroquiasPK.cntPrvCodigo = :cntPrvCodigo"),
    @NamedQuery(name = "Parroquias.findByCntCodigo", query = "SELECT p FROM Parroquias p WHERE p.parroquiasPK.cntCodigo = :cntCodigo"),
    @NamedQuery(name = "Parroquias.findByCodigo", query = "SELECT p FROM Parroquias p WHERE p.parroquiasPK.codigo = :codigo"),
    @NamedQuery(name = "Parroquias.findByParroquia", query = "SELECT p FROM Parroquias p WHERE p.parroquia = :parroquia")})
public class Parroquias implements Serializable {
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "parroquias")
    private List<Pacientes> pacientesList;
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ParroquiasPK parroquiasPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "PARROQUIA")
    private String parroquia;
    @JoinColumns({
        @JoinColumn(name = "CNT_PRV_CODIGO", referencedColumnName = "PRV_CODIGO", insertable = false, updatable = false),
        @JoinColumn(name = "CNT_CODIGO", referencedColumnName = "CODIGO", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Cantones cantones;

    public Parroquias() {
    }

    public Parroquias(ParroquiasPK parroquiasPK) {
        this.parroquiasPK = parroquiasPK;
    }

    public Parroquias(ParroquiasPK parroquiasPK, String parroquia) {
        this.parroquiasPK = parroquiasPK;
        this.parroquia = parroquia;
    }

    public Parroquias(String cntPrvCodigo, String cntCodigo, String codigo) {
        this.parroquiasPK = new ParroquiasPK(cntPrvCodigo, cntCodigo, codigo);
    }

    public ParroquiasPK getParroquiasPK() {
        System.out.println("parroquiasPK = " + parroquiasPK);
        return parroquiasPK;
    }

    public void setParroquiasPK(ParroquiasPK parroquiasPK) {
        this.parroquiasPK = parroquiasPK;
    }

    public String getParroquia() {
        return parroquia;
    }

    public void setParroquia(String parroquia) {
        this.parroquia = parroquia;
    }

    public Cantones getCantones() {
        return cantones;
    }

    public void setCantones(Cantones cantones) {
        this.cantones = cantones;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (parroquiasPK != null ? parroquiasPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Parroquias)) {
            return false;
        }
        Parroquias other = (Parroquias) object;
        if ((this.parroquiasPK == null && other.parroquiasPK != null) || (this.parroquiasPK != null && !this.parroquiasPK.equals(other.parroquiasPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Parroquias[ parroquiasPK=" + parroquiasPK + " ]";
    }

    @XmlTransient
    public List<Pacientes> getPacientesList() {
        return pacientesList;
    }

    public void setPacientesList(List<Pacientes> pacientesList) {
        this.pacientesList = pacientesList;
    }
    
}
