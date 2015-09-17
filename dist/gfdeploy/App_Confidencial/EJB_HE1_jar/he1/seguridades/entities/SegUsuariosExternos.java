/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package he1.seguridades.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
 * @author christian_ruiz
 */
@Entity
@Table(name = "SEG_USUARIOS_EXTERNOS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SegUsuariosExternos.findAll", query = "SELECT s FROM SegUsuariosExternos s"),
    @NamedQuery(name = "SegUsuariosExternos.findById", query = "SELECT s FROM SegUsuariosExternos s WHERE s.id = :id"),
    @NamedQuery(name = "SegUsuariosExternos.findByUseUsuario", query = "SELECT s FROM SegUsuariosExternos s WHERE s.useUsuario = :useUsuario"),
    @NamedQuery(name = "SegUsuariosExternos.findByUseDependenciaUnidad", query = "SELECT s FROM SegUsuariosExternos s WHERE s.useDependenciaUnidad = :useDependenciaUnidad"),
    @NamedQuery(name = "SegUsuariosExternos.findByUseFechaCreacion", query = "SELECT s FROM SegUsuariosExternos s WHERE s.useFechaCreacion = :useFechaCreacion")})
public class SegUsuariosExternos implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Size(max = 30)
    @Column(name = "USE_USUARIO")
    private String useUsuario;
    @Size(max = 100)
    @Column(name = "USE_DEPENDENCIA_UNIDAD")
    private String useDependenciaUnidad;
    @Basic(optional = false)
    @NotNull
    @Column(name = "USE_FECHA_CREACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date useFechaCreacion;
    @OneToMany(mappedBy = "segUsuariosExternos")
    private List<SegUsuario> segUsuarioList;

    public SegUsuariosExternos() {
    }

    public SegUsuariosExternos(BigDecimal id) {
        this.id = id;
    }

    public SegUsuariosExternos(BigDecimal id, Date useFechaCreacion) {
        this.id = id;
        this.useFechaCreacion = useFechaCreacion;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getUseUsuario() {
        return useUsuario;
    }

    public void setUseUsuario(String useUsuario) {
        this.useUsuario = useUsuario;
    }

    public String getUseDependenciaUnidad() {
        return useDependenciaUnidad;
    }

    public void setUseDependenciaUnidad(String useDependenciaUnidad) {
        this.useDependenciaUnidad = useDependenciaUnidad;
    }

    public Date getUseFechaCreacion() {
        return useFechaCreacion;
    }

    public void setUseFechaCreacion(Date useFechaCreacion) {
        this.useFechaCreacion = useFechaCreacion;
    }

    @XmlTransient
    public List<SegUsuario> getSegUsuarioList() {
        return segUsuarioList;
    }

    public void setSegUsuarioList(List<SegUsuario> segUsuarioList) {
        this.segUsuarioList = segUsuarioList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SegUsuariosExternos)) {
            return false;
        }
        SegUsuariosExternos other = (SegUsuariosExternos) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "he1.seguridades.entities.SegUsuariosExternos[ id=" + id + " ]";
    }
    
}
