/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package he1.seguridades.entities;

import he1.seguridades.entities.nuevos.PersonalNomina;
import he1.sis.entities.Pacientes;
import he1.sis.entities.Parroquias;
import he1.sis.entities.Personal;
import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
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
@Table(name = "SEG_USUARIO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SegUsuario.findAll", query = "SELECT s FROM SegUsuario s"),
    @NamedQuery(name = "SegUsuario.findById", query = "SELECT s FROM SegUsuario s WHERE s.id = :id"),
    @NamedQuery(name = "SegUsuario.findByUsuTipo", query = "SELECT s FROM SegUsuario s WHERE s.usuTipo = :usuTipo"),
    @NamedQuery(name = "SegUsuario.findByUsuClave", query = "SELECT s FROM SegUsuario s WHERE s.usuClave = :usuClave"),
    @NamedQuery(name = "SegUsuario.findByCedulaLogin", query = "SELECT s FROM SegUsuario s WHERE s.cedulaLogin = :cedulaLogin")})
public class SegUsuario implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "USU_TIPO")
    private Character usuTipo;
    @Size(max = 1000)
    @Column(name = "USU_CLAVE")
    private String usuClave;
    @Size(max = 40)
    @Column(name = "CEDULA_LOGIN")
    private String cedulaLogin;
    @JoinColumn(name = "NUMERO_HC", referencedColumnName = "NUMERO_HC")
    @ManyToOne
    private Pacientes pacientes;
    @JoinColumn(name = "PER_CODIGO", referencedColumnName = "CODIGO")
    @ManyToOne
    private Personal personal;
    @JoinColumn(name = "NOM_ID", referencedColumnName = "PRN_IDPERSONAL")
    @ManyToOne
    private PersonalNomina personalNomina;
    @JoinColumn(name = "UEX_ID", referencedColumnName = "ID")
    @ManyToOne
    private SegUsuariosExternos segUsuariosExternos;

    @ManyToOne
    private Parroquias parroquias;
    @JoinColumns({
        @JoinColumn(name = "CNT_PRV_CODIGO", referencedColumnName = "CNT_PRV_CODIGO"),
        @JoinColumn(name = "CNT_CODIGO", referencedColumnName = "CNT_CODIGO"),
        @JoinColumn(name = "CODIGO", referencedColumnName = "CODIGO")})

    @Column(name = "EMAIL")
    private String email;
    @Size(max = 100)
    @Column(name = "TELEFONO")
    private String telefono;
    @Size(max = 11)
    @Column(name = "CELULAR")
    private String celular;
    @Size(max = 4000)
    @Column(name = "DIRECCION_DOMICILIO")
    private String direccionDomicilio;

    public SegUsuario() {
    }

    public SegUsuario(BigDecimal id) {
        this.id = id;
    }

    public SegUsuario(BigDecimal id, Character usuTipo) {
        this.id = id;
        this.usuTipo = usuTipo;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public Character getUsuTipo() {
        return usuTipo;
    }

    public void setUsuTipo(Character usuTipo) {
        this.usuTipo = usuTipo;
    }

    public String getUsuClave() {
        return usuClave;
    }

    public void setUsuClave(String usuClave) {
        this.usuClave = usuClave;
    }

    public String getCedulaLogin() {
        return cedulaLogin;
    }

    public void setCedulaLogin(String cedulaLogin) {
        this.cedulaLogin = cedulaLogin;
    }

    public Pacientes getPacientes() {
        return pacientes;
    }

    public void setPacientes(Pacientes pacientes) {
        this.pacientes = pacientes;
    }

    public Personal getPersonal() {
        return personal;
    }

    public void setPersonal(Personal personal) {
        this.personal = personal;
    }

    public PersonalNomina getPersonalNomina() {
        return personalNomina;
    }

    public void setPersonalNomina(PersonalNomina personalNomina) {
        this.personalNomina = personalNomina;
    }

    public SegUsuariosExternos getSegUsuariosExternos() {
        return segUsuariosExternos;
    }

    public void setSegUsuariosExternos(SegUsuariosExternos segUsuariosExternos) {
        this.segUsuariosExternos = segUsuariosExternos;
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
        if (!(object instanceof SegUsuario)) {
            return false;
        }
        SegUsuario other = (SegUsuario) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.SegUsuario[ id=" + id + " ]";
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the telefono
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * @param telefono the telefono to set
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /**
     * @return the celular
     */
    public String getCelular() {
        return celular;
    }

    /**
     * @param celular the celular to set
     */
    public void setCelular(String celular) {
        this.celular = celular;
    }

    /**
     * @return the direccionDomicilio
     */
    public String getDireccionDomicilio() {
        return direccionDomicilio;
    }

    /**
     * @param direccionDomicilio the direccionDomicilio to set
     */
    public void setDireccionDomicilio(String direccionDomicilio) {
        this.direccionDomicilio = direccionDomicilio;
    }

    /**
     * @return the parroquias
     */
    public Parroquias getParroquias() {
        return parroquias;
    }

    /**
     * @param parroquias the parroquias to set
     */
    public void setParroquias(Parroquias parroquias) {
        this.parroquias = parroquias;
    }

}
