/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package he1.seguridades.entities.nuevos;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "V_USUARIOS_CLASIF")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VUsuariosClasif.findAll", query = "SELECT v FROM VUsuariosClasif v"),
    @NamedQuery(name = "VUsuariosClasif.findById", query = "SELECT v FROM VUsuariosClasif v WHERE v.id = :id"),
    @NamedQuery(name = "VUsuariosClasif.findByTipoUser", query = "SELECT v FROM VUsuariosClasif v WHERE v.tipoUser = :tipoUser"),
    @NamedQuery(name = "VUsuariosClasif.findByCedulaLogin", query = "SELECT v FROM VUsuariosClasif v WHERE v.cedulaLogin = :cedulaLogin"),
    @NamedQuery(name = "VUsuariosClasif.findByApellidos", query = "SELECT v FROM VUsuariosClasif v WHERE v.apellidos = :apellidos"),
    @NamedQuery(name = "VUsuariosClasif.findByNombres", query = "SELECT v FROM VUsuariosClasif v WHERE v.nombres = :nombres"),
    @NamedQuery(name = "VUsuariosClasif.findByCelular", query = "SELECT v FROM VUsuariosClasif v WHERE v.celular = :celular"),
    @NamedQuery(name = "VUsuariosClasif.findByIdIssfa", query = "SELECT v FROM VUsuariosClasif v WHERE v.idIssfa = :idIssfa"),
    @NamedQuery(name = "VUsuariosClasif.findByNumeroHc", query = "SELECT v FROM VUsuariosClasif v WHERE v.numeroHc = :numeroHc"),
    @NamedQuery(name = "VUsuariosClasif.findByEmail", query = "SELECT v FROM VUsuariosClasif v WHERE v.email = :email"),
    @NamedQuery(name = "VUsuariosClasif.findByPerCodigo", query = "SELECT v FROM VUsuariosClasif v WHERE v.perCodigo = :perCodigo"),
    @NamedQuery(name = "VUsuariosClasif.findByNomId", query = "SELECT v FROM VUsuariosClasif v WHERE v.nomId = :nomId"),
    @NamedQuery(name = "VUsuariosClasif.findByUsuExt", query = "SELECT v FROM VUsuariosClasif v WHERE v.usuExt = :usuExt")})
public class VUsuariosClasif implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Size(max = 11)
    @Column(name = "TIPO_USER")
    private String tipoUser;
    @Size(max = 40)
    @Column(name = "CEDULA_LOGIN")
    private String cedulaLogin;
    @Size(max = 250)
    @Column(name = "APELLIDOS")
    private String apellidos;
    @Size(max = 250)
    @Column(name = "NOMBRES")
    private String nombres;
    @Size(max = 100)
    @Column(name = "CELULAR")
    private String celular;
    @Size(max = 50)
    @Column(name = "ID_ISSFA")
    private String idIssfa;
    @Column(name = "NUMERO_HC")
    private BigInteger numeroHc;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 240)
    @Column(name = "EMAIL")
    private String email;
    @Size(max = 20)
    @Column(name = "PER_CODIGO")
    private String perCodigo;
    @Column(name = "NOM_ID")
    private BigInteger nomId;
    @Column(name = "USU_EXT")
    private BigInteger usuExt;

    public VUsuariosClasif() {
    }

    public VUsuariosClasif(BigDecimal id) {
        this.id = id;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getTipoUser() {
        return tipoUser;
    }

    public void setTipoUser(String tipoUser) {
        this.tipoUser = tipoUser;
    }

    public String getCedulaLogin() {
        return cedulaLogin;
    }

    public void setCedulaLogin(String cedulaLogin) {
        this.cedulaLogin = cedulaLogin;
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

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getIdIssfa() {
        return idIssfa;
    }

    public void setIdIssfa(String idIssfa) {
        this.idIssfa = idIssfa;
    }

    public BigInteger getNumeroHc() {
        return numeroHc;
    }

    public void setNumeroHc(BigInteger numeroHc) {
        this.numeroHc = numeroHc;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPerCodigo() {
        return perCodigo;
    }

    public void setPerCodigo(String perCodigo) {
        this.perCodigo = perCodigo;
    }

    public BigInteger getNomId() {
        return nomId;
    }

    public void setNomId(BigInteger nomId) {
        this.nomId = nomId;
    }

    public BigInteger getUsuExt() {
        return usuExt;
    }

    public void setUsuExt(BigInteger usuExt) {
        this.usuExt = usuExt;
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
        if (!(object instanceof VUsuariosClasif)) {
            return false;
        }
        VUsuariosClasif other = (VUsuariosClasif) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "he1.seguridades.entities.nuevos.VUsuariosClasif[ id=" + id + " ]";
    }
    
}
