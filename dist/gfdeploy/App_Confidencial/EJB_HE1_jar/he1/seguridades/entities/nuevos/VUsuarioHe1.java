/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package he1.seguridades.entities.nuevos;

import java.io.Serializable;
import java.math.BigInteger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author christian_ruiz
 */
@Entity
@Table(name = "V_USUARIO_HE1")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VUsuarioHe1.findAll", query = "SELECT v FROM VUsuarioHe1 v"),
    @NamedQuery(name = "VUsuarioHe1.findByTipoUser", query = "SELECT v FROM VUsuarioHe1 v WHERE v.tipoUser = :tipoUser"),
    @NamedQuery(name = "VUsuarioHe1.findById", query = "SELECT v FROM VUsuarioHe1 v WHERE v.id = :id"),
    @NamedQuery(name = "VUsuarioHe1.findByUsuTipo", query = "SELECT v FROM VUsuarioHe1 v WHERE v.usuTipo = :usuTipo"),
    @NamedQuery(name = "VUsuarioHe1.findByNumeroHc", query = "SELECT v FROM VUsuarioHe1 v WHERE v.numeroHc = :numeroHc"),
    @NamedQuery(name = "VUsuarioHe1.findByUexId", query = "SELECT v FROM VUsuarioHe1 v WHERE v.uexId = :uexId"),
    @NamedQuery(name = "VUsuarioHe1.findByPerCodigo", query = "SELECT v FROM VUsuarioHe1 v WHERE v.perCodigo = :perCodigo"),
    @NamedQuery(name = "VUsuarioHe1.findByUsuClave", query = "SELECT v FROM VUsuarioHe1 v WHERE v.usuClave = :usuClave"),
    @NamedQuery(name = "VUsuarioHe1.findByNomId", query = "SELECT v FROM VUsuarioHe1 v WHERE v.nomId = :nomId"),
    @NamedQuery(name = "VUsuarioHe1.findByCedulaLogin", query = "SELECT v FROM VUsuarioHe1 v WHERE v.cedulaLogin = :cedulaLogin"),
    @NamedQuery(name = "VUsuarioHe1.findByHc", query = "SELECT v FROM VUsuarioHe1 v WHERE v.hc = :hc"),
    @NamedQuery(name = "VUsuarioHe1.findByUsuExt", query = "SELECT v FROM VUsuarioHe1 v WHERE v.usuExt = :usuExt"),
    @NamedQuery(name = "VUsuarioHe1.findByPersonal", query = "SELECT v FROM VUsuarioHe1 v WHERE v.personal = :personal"),
    @NamedQuery(name = "VUsuarioHe1.findByNomina", query = "SELECT v FROM VUsuarioHe1 v WHERE v.nomina = :nomina")})
public class VUsuarioHe1 implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 11)
    @Column(name = "TIPO_USER")
    private String tipoUser;
    @Column(name = "ID")
    private BigInteger id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "USU_TIPO")
    private Character usuTipo;
    @Column(name = "NUMERO_HC")
    private BigInteger numeroHc;
    @Column(name = "UEX_ID")
    private BigInteger uexId;
    @Size(max = 20)
    @Column(name = "PER_CODIGO")
    private String perCodigo;
    @Size(max = 1000)
    @Column(name = "USU_CLAVE")
    private String usuClave;
    @Column(name = "NOM_ID")
    private BigInteger nomId;
    @Size(max = 40)
    @Column(name = "CEDULA_LOGIN")
    private String cedulaLogin;
    @Column(name = "HC")
    private BigInteger hc;
    @Column(name = "USU_EXT")
    private BigInteger usuExt;
    @Size(max = 20)
    @Column(name = "PERSONAL")
    private String personal;
    @Column(name = "NOMINA")
    private BigInteger nomina;

    public VUsuarioHe1() {
    }

    public VUsuarioHe1(String tipoUser) {
        this.tipoUser = tipoUser;
    }

    public VUsuarioHe1(String tipoUser, Character usuTipo) {
        this.tipoUser = tipoUser;
        this.usuTipo = usuTipo;
    }

    public String getTipoUser() {
        return tipoUser;
    }

    public void setTipoUser(String tipoUser) {
        this.tipoUser = tipoUser;
    }

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public Character getUsuTipo() {
        return usuTipo;
    }

    public void setUsuTipo(Character usuTipo) {
        this.usuTipo = usuTipo;
    }

    public BigInteger getNumeroHc() {
        return numeroHc;
    }

    public void setNumeroHc(BigInteger numeroHc) {
        this.numeroHc = numeroHc;
    }

    public BigInteger getUexId() {
        return uexId;
    }

    public void setUexId(BigInteger uexId) {
        this.uexId = uexId;
    }

    public String getPerCodigo() {
        return perCodigo;
    }

    public void setPerCodigo(String perCodigo) {
        this.perCodigo = perCodigo;
    }

    public String getUsuClave() {
        return usuClave;
    }

    public void setUsuClave(String usuClave) {
        this.usuClave = usuClave;
    }

    public BigInteger getNomId() {
        return nomId;
    }

    public void setNomId(BigInteger nomId) {
        this.nomId = nomId;
    }

    public String getCedulaLogin() {
        return cedulaLogin;
    }

    public void setCedulaLogin(String cedulaLogin) {
        this.cedulaLogin = cedulaLogin;
    }

    public BigInteger getHc() {
        return hc;
    }

    public void setHc(BigInteger hc) {
        this.hc = hc;
    }

    public BigInteger getUsuExt() {
        return usuExt;
    }

    public void setUsuExt(BigInteger usuExt) {
        this.usuExt = usuExt;
    }

    public String getPersonal() {
        return personal;
    }

    public void setPersonal(String personal) {
        this.personal = personal;
    }

    public BigInteger getNomina() {
        return nomina;
    }

    public void setNomina(BigInteger nomina) {
        this.nomina = nomina;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tipoUser != null ? tipoUser.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof VUsuarioHe1)) {
            return false;
        }
        VUsuarioHe1 other = (VUsuarioHe1) object;
        if ((this.tipoUser == null && other.tipoUser != null) || (this.tipoUser != null && !this.tipoUser.equals(other.tipoUser))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "he1.seguridades.entities.nuevos.VUsuarioHe1[ tipoUser=" + tipoUser + " ]";
    }
    
}
