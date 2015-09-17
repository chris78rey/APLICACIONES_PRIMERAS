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
@Table(name = "PERSONAL")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Personal.findAll", query = "SELECT p FROM Personal p"),
    @NamedQuery(name = "Personal.findByCodigo", query = "SELECT p FROM Personal p WHERE p.codigo = :codigo"),
    @NamedQuery(name = "Personal.findByEspprsCodigo", query = "SELECT p FROM Personal p WHERE p.espprsCodigo = :espprsCodigo"),
    @NamedQuery(name = "Personal.findByApellidos", query = "SELECT p FROM Personal p WHERE p.apellidos = :apellidos"),
    @NamedQuery(name = "Personal.findByNombres", query = "SELECT p FROM Personal p WHERE p.nombres = :nombres"),
    @NamedQuery(name = "Personal.findByEstadoDeDisponibilidad", query = "SELECT p FROM Personal p WHERE p.estadoDeDisponibilidad = :estadoDeDisponibilidad"),
    @NamedQuery(name = "Personal.findByCedula", query = "SELECT p FROM Personal p WHERE p.cedula = :cedula"),
    @NamedQuery(name = "Personal.findByCargo", query = "SELECT p FROM Personal p WHERE p.cargo = :cargo"),
    @NamedQuery(name = "Personal.findByTelefono", query = "SELECT p FROM Personal p WHERE p.telefono = :telefono"),
    @NamedQuery(name = "Personal.findByDireccion", query = "SELECT p FROM Personal p WHERE p.direccion = :direccion"),
    @NamedQuery(name = "Personal.findByNumeroCma", query = "SELECT p FROM Personal p WHERE p.numeroCma = :numeroCma"),
    @NamedQuery(name = "Personal.findByUsuario", query = "SELECT p FROM Personal p WHERE p.usuario = :usuario"),
    @NamedQuery(name = "Personal.findByPermitirTurno", query = "SELECT p FROM Personal p WHERE p.permitirTurno = :permitirTurno"),
    @NamedQuery(name = "Personal.findByPersonalCirugia", query = "SELECT p FROM Personal p WHERE p.personalCirugia = :personalCirugia"),
    @NamedQuery(name = "Personal.findByBeneficiario", query = "SELECT p FROM Personal p WHERE p.beneficiario = :beneficiario"),
    @NamedQuery(name = "Personal.findByCodigoCm", query = "SELECT p FROM Personal p WHERE p.codigoCm = :codigoCm"),
    @NamedQuery(name = "Personal.findByLibroMsp", query = "SELECT p FROM Personal p WHERE p.libroMsp = :libroMsp"),
    @NamedQuery(name = "Personal.findByFolioMsp", query = "SELECT p FROM Personal p WHERE p.folioMsp = :folioMsp"),
    @NamedQuery(name = "Personal.findByNumeroMsp", query = "SELECT p FROM Personal p WHERE p.numeroMsp = :numeroMsp")})
public class Personal implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "CODIGO")
    private String codigo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "ESPPRS_CODIGO")
    private String espprsCodigo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "APELLIDOS")
    private String apellidos;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "NOMBRES")
    private String nombres;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ESTADO_DE_DISPONIBILIDAD")
    private Character estadoDeDisponibilidad;
    @Size(max = 10)
    @Column(name = "CEDULA")
    private String cedula;
    @Size(max = 3)
    @Column(name = "CARGO")
    private String cargo;
    @Size(max = 24)
    @Column(name = "TELEFONO")
    private String telefono;
    @Size(max = 50)
    @Column(name = "DIRECCION")
    private String direccion;
    @Size(max = 5)
    @Column(name = "NUMERO_CMA")
    private String numeroCma;
    @Size(max = 30)
    @Column(name = "USUARIO")
    private String usuario;
    @Size(max = 1)
    @Column(name = "PERMITIR_TURNO")
    private String permitirTurno;
    @Column(name = "PERSONAL_CIRUGIA")
    private Character personalCirugia;
    @Basic(optional = false)
    @NotNull
    @Column(name = "BENEFICIARIO")
    private Character beneficiario;
    @Size(max = 20)
    @Column(name = "CODIGO_CM")
    private String codigoCm;
    @Size(max = 20)
    @Column(name = "LIBRO_MSP")
    private String libroMsp;
    @Size(max = 20)
    @Column(name = "FOLIO_MSP")
    private String folioMsp;
    @Size(max = 20)
    @Column(name = "NUMERO_MSP")
    private String numeroMsp;
    @OneToMany(mappedBy = "personal")
    private List<Pacientes> pacientesList;
    @OneToMany(mappedBy = "personal")
    private List<HojasDeEvolucion> hojasDeEvolucionList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "personal1")
    private List<HojasDeEvolucion> hojasDeEvolucionList1;
    @OneToMany(mappedBy = "personal")
    private List<TurnosCe> turnosCeList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "personal1")
    private List<TurnosCe> turnosCeList1;

    public Personal() {
    }

    public Personal(String codigo) {
        this.codigo = codigo;
    }

    public Personal(String codigo, String espprsCodigo, String apellidos, String nombres, Character estadoDeDisponibilidad, Character beneficiario) {
        this.codigo = codigo;
        this.espprsCodigo = espprsCodigo;
        this.apellidos = apellidos;
        this.nombres = nombres;
        this.estadoDeDisponibilidad = estadoDeDisponibilidad;
        this.beneficiario = beneficiario;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getEspprsCodigo() {
        return espprsCodigo;
    }

    public void setEspprsCodigo(String espprsCodigo) {
        this.espprsCodigo = espprsCodigo;
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

    public Character getEstadoDeDisponibilidad() {
        return estadoDeDisponibilidad;
    }

    public void setEstadoDeDisponibilidad(Character estadoDeDisponibilidad) {
        this.estadoDeDisponibilidad = estadoDeDisponibilidad;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getNumeroCma() {
        return numeroCma;
    }

    public void setNumeroCma(String numeroCma) {
        this.numeroCma = numeroCma;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPermitirTurno() {
        return permitirTurno;
    }

    public void setPermitirTurno(String permitirTurno) {
        this.permitirTurno = permitirTurno;
    }

    public Character getPersonalCirugia() {
        return personalCirugia;
    }

    public void setPersonalCirugia(Character personalCirugia) {
        this.personalCirugia = personalCirugia;
    }

    public Character getBeneficiario() {
        return beneficiario;
    }

    public void setBeneficiario(Character beneficiario) {
        this.beneficiario = beneficiario;
    }

    public String getCodigoCm() {
        return codigoCm;
    }

    public void setCodigoCm(String codigoCm) {
        this.codigoCm = codigoCm;
    }

    public String getLibroMsp() {
        return libroMsp;
    }

    public void setLibroMsp(String libroMsp) {
        this.libroMsp = libroMsp;
    }

    public String getFolioMsp() {
        return folioMsp;
    }

    public void setFolioMsp(String folioMsp) {
        this.folioMsp = folioMsp;
    }

    public String getNumeroMsp() {
        return numeroMsp;
    }

    public void setNumeroMsp(String numeroMsp) {
        this.numeroMsp = numeroMsp;
    }

    @XmlTransient
    public List<Pacientes> getPacientesList() {
        return pacientesList;
    }

    public void setPacientesList(List<Pacientes> pacientesList) {
        this.pacientesList = pacientesList;
    }

    @XmlTransient
    public List<HojasDeEvolucion> getHojasDeEvolucionList() {
        return hojasDeEvolucionList;
    }

    public void setHojasDeEvolucionList(List<HojasDeEvolucion> hojasDeEvolucionList) {
        this.hojasDeEvolucionList = hojasDeEvolucionList;
    }

    @XmlTransient
    public List<HojasDeEvolucion> getHojasDeEvolucionList1() {
        return hojasDeEvolucionList1;
    }

    public void setHojasDeEvolucionList1(List<HojasDeEvolucion> hojasDeEvolucionList1) {
        this.hojasDeEvolucionList1 = hojasDeEvolucionList1;
    }

    @XmlTransient
    public List<TurnosCe> getTurnosCeList() {
        return turnosCeList;
    }

    public void setTurnosCeList(List<TurnosCe> turnosCeList) {
        this.turnosCeList = turnosCeList;
    }

    @XmlTransient
    public List<TurnosCe> getTurnosCeList1() {
        return turnosCeList1;
    }

    public void setTurnosCeList1(List<TurnosCe> turnosCeList1) {
        this.turnosCeList1 = turnosCeList1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigo != null ? codigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Personal)) {
            return false;
        }
        Personal other = (Personal) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "he1.entities.Personal[ codigo=" + codigo + " ]";
    }
    
}
