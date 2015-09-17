/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package he1.matriz.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
 * @author luis_guanoluiza
 */
@Entity
@Table(name = "MCE_PERSONAL")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "McePersonal.findAll", query = "SELECT m FROM McePersonal m"),
    @NamedQuery(name = "McePersonal.findById", query = "SELECT m FROM McePersonal m WHERE m.id = :id"),
    @NamedQuery(name = "McePersonal.findByCedula", query = "SELECT m FROM McePersonal m WHERE m.cedula = :cedula"),
    @NamedQuery(name = "McePersonal.findByApellidos", query = "SELECT m FROM McePersonal m WHERE m.apellidos = :apellidos"),
    @NamedQuery(name = "McePersonal.findByNombres", query = "SELECT m FROM McePersonal m WHERE m.nombres = :nombres"),
    @NamedQuery(name = "McePersonal.findByGrado", query = "SELECT m FROM McePersonal m WHERE m.grado = :grado"),
    @NamedQuery(name = "McePersonal.findByFuerza", query = "SELECT m FROM McePersonal m WHERE m.fuerza = :fuerza"),
    @NamedQuery(name = "McePersonal.findByUnidadmili", query = "SELECT m FROM McePersonal m WHERE m.unidadmili = :unidadmili"),
    @NamedQuery(name = "McePersonal.findByPrvCod", query = "SELECT m FROM McePersonal m WHERE m.prvCod = :prvCod"),
    @NamedQuery(name = "McePersonal.findByCodCanton", query = "SELECT m FROM McePersonal m WHERE m.codCanton = :codCanton")})
public class McePersonal implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Size(max = 100)
    @Column(name = "CEDULA")
    private String cedula;
    @Size(max = 50)
    @Column(name = "APELLIDOS")
    private String apellidos;
    @Size(max = 50)
    @Column(name = "NOMBRES")
    private String nombres;
    @Size(max = 50)
    @Column(name = "GRADO")
    private String grado;
    @Size(max = 50)
    @Column(name = "FUERZA")
    private String fuerza;
    @Size(max = 50)
    @Column(name = "UNIDADMILI")
    private String unidadmili;
    @Size(max = 40)
    @Column(name = "PRV_COD")
    private String prvCod;
    @Size(max = 40)
    @Column(name = "COD_CANTON")
    private String codCanton;
    @OneToMany(mappedBy = "mcePersonal")
    private List<McePerdetalle> mcePerdetalleList;

    public McePersonal() {
    }

    public McePersonal(BigDecimal id) {
        this.id = id;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getGrado() {
        return grado;
    }

    public void setGrado(String grado) {
        this.grado = grado;
    }

    public String getFuerza() {
        return fuerza;
    }

    public void setFuerza(String fuerza) {
        this.fuerza = fuerza;
    }

    public String getUnidadmili() {
        return unidadmili;
    }

    public void setUnidadmili(String unidadmili) {
        this.unidadmili = unidadmili;
    }

    public String getPrvCod() {
        return prvCod;
    }

    public void setPrvCod(String prvCod) {
        this.prvCod = prvCod;
    }

    public String getCodCanton() {
        return codCanton;
    }

    public void setCodCanton(String codCanton) {
        this.codCanton = codCanton;
    }

    @XmlTransient
    public List<McePerdetalle> getMcePerdetalleList() {
        return mcePerdetalleList;
    }

    public void setMcePerdetalleList(List<McePerdetalle> mcePerdetalleList) {
        this.mcePerdetalleList = mcePerdetalleList;
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
        if (!(object instanceof McePersonal)) {
            return false;
        }
        McePersonal other = (McePersonal) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "he1.matriz.entities.McePersonal[ id=" + id + " ]";
    }
    
}
