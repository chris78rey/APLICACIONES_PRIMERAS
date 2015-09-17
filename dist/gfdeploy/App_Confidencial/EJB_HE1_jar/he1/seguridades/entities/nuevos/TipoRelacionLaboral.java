/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package he1.seguridades.entities.nuevos;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
@Table(name = "TIPO_RELACION_LABORAL")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoRelacionLaboral.findAll", query = "SELECT t FROM TipoRelacionLaboral t"),
    @NamedQuery(name = "TipoRelacionLaboral.findByTrlIdtiporelacion", query = "SELECT t FROM TipoRelacionLaboral t WHERE t.trlIdtiporelacion = :trlIdtiporelacion"),
    @NamedQuery(name = "TipoRelacionLaboral.findByTrlTiporelacion", query = "SELECT t FROM TipoRelacionLaboral t WHERE t.trlTiporelacion = :trlTiporelacion"),
    @NamedQuery(name = "TipoRelacionLaboral.findByTrlUser", query = "SELECT t FROM TipoRelacionLaboral t WHERE t.trlUser = :trlUser"),
    @NamedQuery(name = "TipoRelacionLaboral.findByTrlEstado", query = "SELECT t FROM TipoRelacionLaboral t WHERE t.trlEstado = :trlEstado")})
public class TipoRelacionLaboral implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "TRL_IDTIPORELACION")
    private BigDecimal trlIdtiporelacion;
    @Size(max = 100)
    @Column(name = "TRL_TIPORELACION")
    private String trlTiporelacion;
    @Size(max = 50)
    @Column(name = "TRL_USER")
    private String trlUser;
    @Column(name = "TRL_ESTADO")
    private Character trlEstado;
    @JoinColumn(name = "RGL_IDREGIMEN", referencedColumnName = "RGL_IDREGIMEN")
    @ManyToOne
    private RegimenLaboral regimenLaboral;
    @OneToMany(mappedBy = "tipoRelacionLaboral")
    private List<SegMinisterioFinanzas> segMinisterioFinanzasList;

    public TipoRelacionLaboral() {
    }

    public TipoRelacionLaboral(BigDecimal trlIdtiporelacion) {
        this.trlIdtiporelacion = trlIdtiporelacion;
    }

    public BigDecimal getTrlIdtiporelacion() {
        return trlIdtiporelacion;
    }

    public void setTrlIdtiporelacion(BigDecimal trlIdtiporelacion) {
        this.trlIdtiporelacion = trlIdtiporelacion;
    }

    public String getTrlTiporelacion() {
        return trlTiporelacion;
    }

    public void setTrlTiporelacion(String trlTiporelacion) {
        this.trlTiporelacion = trlTiporelacion;
    }

    public String getTrlUser() {
        return trlUser;
    }

    public void setTrlUser(String trlUser) {
        this.trlUser = trlUser;
    }

    public Character getTrlEstado() {
        return trlEstado;
    }

    public void setTrlEstado(Character trlEstado) {
        this.trlEstado = trlEstado;
    }

    public RegimenLaboral getRegimenLaboral() {
        return regimenLaboral;
    }

    public void setRegimenLaboral(RegimenLaboral regimenLaboral) {
        this.regimenLaboral = regimenLaboral;
    }

    @XmlTransient
    public List<SegMinisterioFinanzas> getSegMinisterioFinanzasList() {
        return segMinisterioFinanzasList;
    }

    public void setSegMinisterioFinanzasList(List<SegMinisterioFinanzas> segMinisterioFinanzasList) {
        this.segMinisterioFinanzasList = segMinisterioFinanzasList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (trlIdtiporelacion != null ? trlIdtiporelacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoRelacionLaboral)) {
            return false;
        }
        TipoRelacionLaboral other = (TipoRelacionLaboral) object;
        if ((this.trlIdtiporelacion == null && other.trlIdtiporelacion != null) || (this.trlIdtiporelacion != null && !this.trlIdtiporelacion.equals(other.trlIdtiporelacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "he1.seguridades.entities.nuevos.TipoRelacionLaboral[ trlIdtiporelacion=" + trlIdtiporelacion + " ]";
    }
    
}
