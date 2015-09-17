/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package he1.sis.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
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
@Table(name = "PACIENTES")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pacientes.findAll", query = "SELECT p FROM Pacientes p"),
    @NamedQuery(name = "Pacientes.findByNumeroHc", query = "SELECT p FROM Pacientes p WHERE p.numeroHc = :numeroHc"),
    @NamedQuery(name = "Pacientes.findByApellidoPaterno", query = "SELECT p FROM Pacientes p WHERE p.apellidoPaterno = :apellidoPaterno"),
    @NamedQuery(name = "Pacientes.findByPrimerNombre", query = "SELECT p FROM Pacientes p WHERE p.primerNombre = :primerNombre"),
    @NamedQuery(name = "Pacientes.findBySexo", query = "SELECT p FROM Pacientes p WHERE p.sexo = :sexo"),
    @NamedQuery(name = "Pacientes.findByEstadoCivil", query = "SELECT p FROM Pacientes p WHERE p.estadoCivil = :estadoCivil"),
    @NamedQuery(name = "Pacientes.findByClasificacion", query = "SELECT p FROM Pacientes p WHERE p.clasificacion = :clasificacion"),
    @NamedQuery(name = "Pacientes.findByApellidoMaterno", query = "SELECT p FROM Pacientes p WHERE p.apellidoMaterno = :apellidoMaterno"),
    @NamedQuery(name = "Pacientes.findBySegundoNombre", query = "SELECT p FROM Pacientes p WHERE p.segundoNombre = :segundoNombre"),
    @NamedQuery(name = "Pacientes.findByCedula", query = "SELECT p FROM Pacientes p WHERE p.cedula = :cedula"),
    @NamedQuery(name = "Pacientes.findByGrupoSanguineo", query = "SELECT p FROM Pacientes p WHERE p.grupoSanguineo = :grupoSanguineo"),
    @NamedQuery(name = "Pacientes.findByFechaNacimiento", query = "SELECT p FROM Pacientes p WHERE p.fechaNacimiento = :fechaNacimiento"),
    @NamedQuery(name = "Pacientes.findByNumeroAfiliacionIess", query = "SELECT p FROM Pacientes p WHERE p.numeroAfiliacionIess = :numeroAfiliacionIess"),
    @NamedQuery(name = "Pacientes.findByDireccionDomicilio", query = "SELECT p FROM Pacientes p WHERE p.direccionDomicilio = :direccionDomicilio"),
    @NamedQuery(name = "Pacientes.findByTelefono", query = "SELECT p FROM Pacientes p WHERE p.telefono = :telefono"),
    @NamedQuery(name = "Pacientes.findByFechaAfiliacion", query = "SELECT p FROM Pacientes p WHERE p.fechaAfiliacion = :fechaAfiliacion"),
    @NamedQuery(name = "Pacientes.findByInstruccion", query = "SELECT p FROM Pacientes p WHERE p.instruccion = :instruccion"),
    @NamedQuery(name = "Pacientes.findByOcpCodigo", query = "SELECT p FROM Pacientes p WHERE p.ocpCodigo = :ocpCodigo"),
    @NamedQuery(name = "Pacientes.findByBloqueado", query = "SELECT p FROM Pacientes p WHERE p.bloqueado = :bloqueado"),
    @NamedQuery(name = "Pacientes.findByFechaTermino", query = "SELECT p FROM Pacientes p WHERE p.fechaTermino = :fechaTermino"),
    @NamedQuery(name = "Pacientes.findByMaximoCupo", query = "SELECT p FROM Pacientes p WHERE p.maximoCupo = :maximoCupo"),
    @NamedQuery(name = "Pacientes.findByDiasMaximoPago", query = "SELECT p FROM Pacientes p WHERE p.diasMaximoPago = :diasMaximoPago"),
    @NamedQuery(name = "Pacientes.findByTipoPaciente", query = "SELECT p FROM Pacientes p WHERE p.tipoPaciente = :tipoPaciente"),
    @NamedQuery(name = "Pacientes.findByEmail", query = "SELECT p FROM Pacientes p WHERE p.email = :email"),
    @NamedQuery(name = "Pacientes.findByAsegurado", query = "SELECT p FROM Pacientes p WHERE p.asegurado = :asegurado"),
    @NamedQuery(name = "Pacientes.findByInformacionARecibir", query = "SELECT p FROM Pacientes p WHERE p.informacionARecibir = :informacionARecibir"),
    @NamedQuery(name = "Pacientes.findByTipoIdentificacion", query = "SELECT p FROM Pacientes p WHERE p.tipoIdentificacion = :tipoIdentificacion"),
    @NamedQuery(name = "Pacientes.findBySaldoActual", query = "SELECT p FROM Pacientes p WHERE p.saldoActual = :saldoActual"),
    @NamedQuery(name = "Pacientes.findBySubClasificacion", query = "SELECT p FROM Pacientes p WHERE p.subClasificacion = :subClasificacion"),
    @NamedQuery(name = "Pacientes.findByAlerta", query = "SELECT p FROM Pacientes p WHERE p.alerta = :alerta"),
    @NamedQuery(name = "Pacientes.findByBarrio", query = "SELECT p FROM Pacientes p WHERE p.barrio = :barrio"),
    @NamedQuery(name = "Pacientes.findByZona", query = "SELECT p FROM Pacientes p WHERE p.zona = :zona"),
    @NamedQuery(name = "Pacientes.findByLugarNacimiento", query = "SELECT p FROM Pacientes p WHERE p.lugarNacimiento = :lugarNacimiento"),
    @NamedQuery(name = "Pacientes.findByNacionalidad", query = "SELECT p FROM Pacientes p WHERE p.nacionalidad = :nacionalidad"),
    @NamedQuery(name = "Pacientes.findByGrupoCultural", query = "SELECT p FROM Pacientes p WHERE p.grupoCultural = :grupoCultural"),
    @NamedQuery(name = "Pacientes.findByEmpresaTrabajo", query = "SELECT p FROM Pacientes p WHERE p.empresaTrabajo = :empresaTrabajo"),
    @NamedQuery(name = "Pacientes.findByTipoSeguro", query = "SELECT p FROM Pacientes p WHERE p.tipoSeguro = :tipoSeguro"),
    @NamedQuery(name = "Pacientes.findByDatosVerificados", query = "SELECT p FROM Pacientes p WHERE p.datosVerificados = :datosVerificados"),
    @NamedQuery(name = "Pacientes.findByObservacion", query = "SELECT p FROM Pacientes p WHERE p.observacion = :observacion"),
    @NamedQuery(name = "Pacientes.findByDireccionTrabajo", query = "SELECT p FROM Pacientes p WHERE p.direccionTrabajo = :direccionTrabajo"),
    @NamedQuery(name = "Pacientes.findByTelefonoTrabajo", query = "SELECT p FROM Pacientes p WHERE p.telefonoTrabajo = :telefonoTrabajo"),
    @NamedQuery(name = "Pacientes.findByDirCorrespondencia", query = "SELECT p FROM Pacientes p WHERE p.dirCorrespondencia = :dirCorrespondencia"),
    @NamedQuery(name = "Pacientes.findByInstCodigo", query = "SELECT p FROM Pacientes p WHERE p.instCodigo = :instCodigo"),
    @NamedQuery(name = "Pacientes.findByClasificacionOnc", query = "SELECT p FROM Pacientes p WHERE p.clasificacionOnc = :clasificacionOnc"),
    @NamedQuery(name = "Pacientes.findByNumeroHcAnterior", query = "SELECT p FROM Pacientes p WHERE p.numeroHcAnterior = :numeroHcAnterior"),
    @NamedQuery(name = "Pacientes.findByTipoPacienteAnterior", query = "SELECT p FROM Pacientes p WHERE p.tipoPacienteAnterior = :tipoPacienteAnterior"),
    @NamedQuery(name = "Pacientes.findByInstitucionRep", query = "SELECT p FROM Pacientes p WHERE p.institucionRep = :institucionRep"),
    @NamedQuery(name = "Pacientes.findByPrqCntPrvCodigoNcm", query = "SELECT p FROM Pacientes p WHERE p.prqCntPrvCodigoNcm = :prqCntPrvCodigoNcm"),
    @NamedQuery(name = "Pacientes.findByPrqCntCodigoNcm", query = "SELECT p FROM Pacientes p WHERE p.prqCntCodigoNcm = :prqCntCodigoNcm"),
    @NamedQuery(name = "Pacientes.findByPrqCodigoNcm", query = "SELECT p FROM Pacientes p WHERE p.prqCodigoNcm = :prqCodigoNcm"),
    @NamedQuery(name = "Pacientes.findByDprAraCodigo", query = "SELECT p FROM Pacientes p WHERE p.dprAraCodigo = :dprAraCodigo"),
    @NamedQuery(name = "Pacientes.findByDprCodigo", query = "SELECT p FROM Pacientes p WHERE p.dprCodigo = :dprCodigo"),
    @NamedQuery(name = "Pacientes.findByTratamientoActivo", query = "SELECT p FROM Pacientes p WHERE p.tratamientoActivo = :tratamientoActivo"),
    @NamedQuery(name = "Pacientes.findByFuerza", query = "SELECT p FROM Pacientes p WHERE p.fuerza = :fuerza"),
    @NamedQuery(name = "Pacientes.findByGrado", query = "SELECT p FROM Pacientes p WHERE p.grado = :grado"),
    @NamedQuery(name = "Pacientes.findBySituacion", query = "SELECT p FROM Pacientes p WHERE p.situacion = :situacion"),
    @NamedQuery(name = "Pacientes.findByReligion", query = "SELECT p FROM Pacientes p WHERE p.religion = :religion"),
    @NamedQuery(name = "Pacientes.findByUltimoAnioInstruccion", query = "SELECT p FROM Pacientes p WHERE p.ultimoAnioInstruccion = :ultimoAnioInstruccion"),
    @NamedQuery(name = "Pacientes.findByUndmltCodigo", query = "SELECT p FROM Pacientes p WHERE p.undmltCodigo = :undmltCodigo"),
    @NamedQuery(name = "Pacientes.findByUndsldffaaCodigo", query = "SELECT p FROM Pacientes p WHERE p.undsldffaaCodigo = :undsldffaaCodigo"),
    @NamedQuery(name = "Pacientes.findByFechaCreacion", query = "SELECT p FROM Pacientes p WHERE p.fechaCreacion = :fechaCreacion"),
    @NamedQuery(name = "Pacientes.findByIdIssfa", query = "SELECT p FROM Pacientes p WHERE p.idIssfa = :idIssfa"),
    @NamedQuery(name = "Pacientes.findByDiscriminador", query = "SELECT p FROM Pacientes p WHERE p.discriminador = :discriminador"),
    @NamedQuery(name = "Pacientes.findByIdConadis", query = "SELECT p FROM Pacientes p WHERE p.idConadis = :idConadis"),
    @NamedQuery(name = "Pacientes.findByIdIssfaTitular", query = "SELECT p FROM Pacientes p WHERE p.idIssfaTitular = :idIssfaTitular"),
    @NamedQuery(name = "Pacientes.findByTipoDiscapacidad", query = "SELECT p FROM Pacientes p WHERE p.tipoDiscapacidad = :tipoDiscapacidad"),
    @NamedQuery(name = "Pacientes.findByCelular", query = "SELECT p FROM Pacientes p WHERE p.celular = :celular")})
public class Pacientes implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "NUMERO_HC")
    private Integer numeroHc;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "APELLIDO_PATERNO")
    private String apellidoPaterno;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "PRIMER_NOMBRE")
    private String primerNombre;
    @Basic(optional = false)
    @NotNull
    @Column(name = "SEXO")
    private Character sexo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "ESTADO_CIVIL")
    private String estadoCivil;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "CLASIFICACION")
    private String clasificacion;
    @Size(max = 20)
    @Column(name = "APELLIDO_MATERNO")
    private String apellidoMaterno;
    @Size(max = 20)
    @Column(name = "SEGUNDO_NOMBRE")
    private String segundoNombre;
    @Size(max = 20)
    @Column(name = "CEDULA")
    private String cedula;
    @Size(max = 5)
    @Column(name = "GRUPO_SANGUINEO")
    private String grupoSanguineo;
    @Column(name = "FECHA_NACIMIENTO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaNacimiento;
    @Column(name = "NUMERO_AFILIACION_IESS")
    private Long numeroAfiliacionIess;
    @Size(max = 240)
    @Column(name = "DIRECCION_DOMICILIO")
    private String direccionDomicilio;
    @Size(max = 32)
    @Column(name = "TELEFONO")
    private String telefono;
    @Column(name = "FECHA_AFILIACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaAfiliacion;
    @Size(max = 2)
    @Column(name = "INSTRUCCION")
    private String instruccion;
    @Size(max = 2)
    @Column(name = "OCP_CODIGO")
    private String ocpCodigo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "BLOQUEADO")
    private Character bloqueado;
    @Column(name = "FECHA_TERMINO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaTermino;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "MAXIMO_CUPO")
    private BigDecimal maximoCupo;
    @Column(name = "DIAS_MAXIMO_PAGO")
    private Short diasMaximoPago;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "TIPO_PACIENTE")
    private String tipoPaciente;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 240)
    @Column(name = "EMAIL")
    private String email;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ASEGURADO")
    private Character asegurado;
    @Size(max = 3)
    @Column(name = "INFORMACION_A_RECIBIR")
    private String informacionARecibir;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "TIPO_IDENTIFICACION")
    private String tipoIdentificacion;
    @Column(name = "SALDO_ACTUAL")
    private BigInteger saldoActual;
    @Size(max = 1)
    @Column(name = "SUB_CLASIFICACION")
    private String subClasificacion;
    @Size(max = 500)
    @Column(name = "ALERTA")
    private String alerta;
    @Size(max = 50)
    @Column(name = "BARRIO")
    private String barrio;
    @Size(max = 1)
    @Column(name = "ZONA")
    private String zona;
    @Size(max = 20)
    @Column(name = "LUGAR_NACIMIENTO")
    private String lugarNacimiento;
    @Size(max = 3)
    @Column(name = "NACIONALIDAD")
    private String nacionalidad;
    @Size(max = 3)
    @Column(name = "GRUPO_CULTURAL")
    private String grupoCultural;
    @Size(max = 50)
    @Column(name = "EMPRESA_TRABAJO")
    private String empresaTrabajo;
    @Size(max = 3)
    @Column(name = "TIPO_SEGURO")
    private String tipoSeguro;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DATOS_VERIFICADOS")
    private Character datosVerificados;
    @Size(max = 250)
    @Column(name = "OBSERVACION")
    private String observacion;
    @Size(max = 240)
    @Column(name = "DIRECCION_TRABAJO")
    private String direccionTrabajo;
    @Size(max = 32)
    @Column(name = "TELEFONO_TRABAJO")
    private String telefonoTrabajo;
    @Size(max = 240)
    @Column(name = "DIR_CORRESPONDENCIA")
    private String dirCorrespondencia;
    @Size(max = 1)
    @Column(name = "INST_CODIGO")
    private String instCodigo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "CLASIFICACION_ONC")
    private String clasificacionOnc;
    @Column(name = "NUMERO_HC_ANTERIOR")
    private Long numeroHcAnterior;
    @Column(name = "TIPO_PACIENTE_ANTERIOR")
    private Short tipoPacienteAnterior;
    @Column(name = "INSTITUCION_REP")
    private Integer institucionRep;
    @Size(max = 2)
    @Column(name = "PRQ_CNT_PRV_CODIGO_NCM")
    private String prqCntPrvCodigoNcm;
    @Size(max = 2)
    @Column(name = "PRQ_CNT_CODIGO_NCM")
    private String prqCntCodigoNcm;
    @Size(max = 2)
    @Column(name = "PRQ_CODIGO_NCM")
    private String prqCodigoNcm;
    @Size(max = 1)
    @Column(name = "DPR_ARA_CODIGO")
    private String dprAraCodigo;
    @Size(max = 1)
    @Column(name = "DPR_CODIGO")
    private String dprCodigo;
    @Column(name = "TRATAMIENTO_ACTIVO")
    private Character tratamientoActivo;
    @Size(max = 1)
    @Column(name = "FUERZA")
    private String fuerza;
    @Size(max = 3)
    @Column(name = "GRADO")
    private String grado;
    @Size(max = 1)
    @Column(name = "SITUACION")
    private String situacion;
    @Size(max = 3)
    @Column(name = "RELIGION")
    private String religion;
    @Size(max = 20)
    @Column(name = "ULTIMO_ANIO_INSTRUCCION")
    private String ultimoAnioInstruccion;
    @Size(max = 6)
    @Column(name = "UNDMLT_CODIGO")
    private String undmltCodigo;
    @Column(name = "UNDSLDFFAA_CODIGO")
    private BigInteger undsldffaaCodigo;
    @Column(name = "FECHA_CREACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCreacion;
    @Size(max = 20)
    @Column(name = "ID_ISSFA")
    private String idIssfa;
    @Size(max = 1)
    @Column(name = "DISCRIMINADOR")
    private String discriminador;
    @Size(max = 20)
    @Column(name = "ID_CONADIS")
    private String idConadis;
    @Size(max = 20)
    @Column(name = "ID_ISSFA_TITULAR")
    private String idIssfaTitular;
    @Size(max = 3)
    @Column(name = "TIPO_DISCAPACIDAD")
    private String tipoDiscapacidad;
    @Size(max = 10)
    @Column(name = "CELULAR")
    private String celular;
    @OneToMany(mappedBy = "pacientes")
    private List<Pacientes> pacientesList;
    @JoinColumn(name = "PCN_NUMERO_HC", referencedColumnName = "NUMERO_HC")
    @ManyToOne
    private Pacientes pacientes;
    @JoinColumns({
        @JoinColumn(name = "PRQ_CNT_PRV_CODIGO", referencedColumnName = "CNT_PRV_CODIGO"),
        @JoinColumn(name = "PRQ_CNT_CODIGO", referencedColumnName = "CNT_CODIGO"),
        @JoinColumn(name = "PRQ_CODIGO", referencedColumnName = "CODIGO")})
    @ManyToOne(optional = false)
    private Parroquias parroquias;
    @JoinColumn(name = "PRS_CODIGO", referencedColumnName = "CODIGO")
    @ManyToOne
    private Personal personal;

    public Pacientes() {
    }

    public Pacientes(Integer numeroHc) {
        this.numeroHc = numeroHc;
    }

    public Pacientes(Integer numeroHc, String apellidoPaterno, String primerNombre, Character sexo, String estadoCivil, String clasificacion, Character bloqueado, String tipoPaciente, Character asegurado, String tipoIdentificacion, Character datosVerificados, String clasificacionOnc) {
        this.numeroHc = numeroHc;
        this.apellidoPaterno = apellidoPaterno;
        this.primerNombre = primerNombre;
        this.sexo = sexo;
        this.estadoCivil = estadoCivil;
        this.clasificacion = clasificacion;
        this.bloqueado = bloqueado;
        this.tipoPaciente = tipoPaciente;
        this.asegurado = asegurado;
        this.tipoIdentificacion = tipoIdentificacion;
        this.datosVerificados = datosVerificados;
        this.clasificacionOnc = clasificacionOnc;
    }

    public Integer getNumeroHc() {
        return numeroHc;
    }

    public void setNumeroHc(Integer numeroHc) {
        this.numeroHc = numeroHc;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getPrimerNombre() {
        return primerNombre;
    }

    public void setPrimerNombre(String primerNombre) {
        this.primerNombre = primerNombre;
    }

    public Character getSexo() {
        return sexo;
    }

    public void setSexo(Character sexo) {
        this.sexo = sexo;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public String getClasificacion() {
        return clasificacion;
    }

    public void setClasificacion(String clasificacion) {
        this.clasificacion = clasificacion;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public String getSegundoNombre() {
        return segundoNombre;
    }

    public void setSegundoNombre(String segundoNombre) {
        this.segundoNombre = segundoNombre;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getGrupoSanguineo() {
        return grupoSanguineo;
    }

    public void setGrupoSanguineo(String grupoSanguineo) {
        this.grupoSanguineo = grupoSanguineo;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Long getNumeroAfiliacionIess() {
        return numeroAfiliacionIess;
    }

    public void setNumeroAfiliacionIess(Long numeroAfiliacionIess) {
        this.numeroAfiliacionIess = numeroAfiliacionIess;
    }

    public String getDireccionDomicilio() {
        return direccionDomicilio;
    }

    public void setDireccionDomicilio(String direccionDomicilio) {
        this.direccionDomicilio = direccionDomicilio;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Date getFechaAfiliacion() {
        return fechaAfiliacion;
    }

    public void setFechaAfiliacion(Date fechaAfiliacion) {
        this.fechaAfiliacion = fechaAfiliacion;
    }

    public String getInstruccion() {
        return instruccion;
    }

    public void setInstruccion(String instruccion) {
        this.instruccion = instruccion;
    }

    public String getOcpCodigo() {
        return ocpCodigo;
    }

    public void setOcpCodigo(String ocpCodigo) {
        this.ocpCodigo = ocpCodigo;
    }

    public Character getBloqueado() {
        return bloqueado;
    }

    public void setBloqueado(Character bloqueado) {
        this.bloqueado = bloqueado;
    }

    public Date getFechaTermino() {
        return fechaTermino;
    }

    public void setFechaTermino(Date fechaTermino) {
        this.fechaTermino = fechaTermino;
    }

    public BigDecimal getMaximoCupo() {
        return maximoCupo;
    }

    public void setMaximoCupo(BigDecimal maximoCupo) {
        this.maximoCupo = maximoCupo;
    }

    public Short getDiasMaximoPago() {
        return diasMaximoPago;
    }

    public void setDiasMaximoPago(Short diasMaximoPago) {
        this.diasMaximoPago = diasMaximoPago;
    }

    public String getTipoPaciente() {
        return tipoPaciente;
    }

    public void setTipoPaciente(String tipoPaciente) {
        this.tipoPaciente = tipoPaciente;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Character getAsegurado() {
        return asegurado;
    }

    public void setAsegurado(Character asegurado) {
        this.asegurado = asegurado;
    }

    public String getInformacionARecibir() {
        return informacionARecibir;
    }

    public void setInformacionARecibir(String informacionARecibir) {
        this.informacionARecibir = informacionARecibir;
    }

    public String getTipoIdentificacion() {
        return tipoIdentificacion;
    }

    public void setTipoIdentificacion(String tipoIdentificacion) {
        this.tipoIdentificacion = tipoIdentificacion;
    }

    public BigInteger getSaldoActual() {
        return saldoActual;
    }

    public void setSaldoActual(BigInteger saldoActual) {
        this.saldoActual = saldoActual;
    }

    public String getSubClasificacion() {
        return subClasificacion;
    }

    public void setSubClasificacion(String subClasificacion) {
        this.subClasificacion = subClasificacion;
    }

    public String getAlerta() {
        return alerta;
    }

    public void setAlerta(String alerta) {
        this.alerta = alerta;
    }

    public String getBarrio() {
        return barrio;
    }

    public void setBarrio(String barrio) {
        this.barrio = barrio;
    }

    public String getZona() {
        return zona;
    }

    public void setZona(String zona) {
        this.zona = zona;
    }

    public String getLugarNacimiento() {
        return lugarNacimiento;
    }

    public void setLugarNacimiento(String lugarNacimiento) {
        this.lugarNacimiento = lugarNacimiento;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public String getGrupoCultural() {
        return grupoCultural;
    }

    public void setGrupoCultural(String grupoCultural) {
        this.grupoCultural = grupoCultural;
    }

    public String getEmpresaTrabajo() {
        return empresaTrabajo;
    }

    public void setEmpresaTrabajo(String empresaTrabajo) {
        this.empresaTrabajo = empresaTrabajo;
    }

    public String getTipoSeguro() {
        return tipoSeguro;
    }

    public void setTipoSeguro(String tipoSeguro) {
        this.tipoSeguro = tipoSeguro;
    }

    public Character getDatosVerificados() {
        return datosVerificados;
    }

    public void setDatosVerificados(Character datosVerificados) {
        this.datosVerificados = datosVerificados;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public String getDireccionTrabajo() {
        return direccionTrabajo;
    }

    public void setDireccionTrabajo(String direccionTrabajo) {
        this.direccionTrabajo = direccionTrabajo;
    }

    public String getTelefonoTrabajo() {
        return telefonoTrabajo;
    }

    public void setTelefonoTrabajo(String telefonoTrabajo) {
        this.telefonoTrabajo = telefonoTrabajo;
    }

    public String getDirCorrespondencia() {
        return dirCorrespondencia;
    }

    public void setDirCorrespondencia(String dirCorrespondencia) {
        this.dirCorrespondencia = dirCorrespondencia;
    }

    public String getInstCodigo() {
        return instCodigo;
    }

    public void setInstCodigo(String instCodigo) {
        this.instCodigo = instCodigo;
    }

    public String getClasificacionOnc() {
        return clasificacionOnc;
    }

    public void setClasificacionOnc(String clasificacionOnc) {
        this.clasificacionOnc = clasificacionOnc;
    }

    public Long getNumeroHcAnterior() {
        return numeroHcAnterior;
    }

    public void setNumeroHcAnterior(Long numeroHcAnterior) {
        this.numeroHcAnterior = numeroHcAnterior;
    }

    public Short getTipoPacienteAnterior() {
        return tipoPacienteAnterior;
    }

    public void setTipoPacienteAnterior(Short tipoPacienteAnterior) {
        this.tipoPacienteAnterior = tipoPacienteAnterior;
    }

    public Integer getInstitucionRep() {
        return institucionRep;
    }

    public void setInstitucionRep(Integer institucionRep) {
        this.institucionRep = institucionRep;
    }

    public String getPrqCntPrvCodigoNcm() {
        return prqCntPrvCodigoNcm;
    }

    public void setPrqCntPrvCodigoNcm(String prqCntPrvCodigoNcm) {
        this.prqCntPrvCodigoNcm = prqCntPrvCodigoNcm;
    }

    public String getPrqCntCodigoNcm() {
        return prqCntCodigoNcm;
    }

    public void setPrqCntCodigoNcm(String prqCntCodigoNcm) {
        this.prqCntCodigoNcm = prqCntCodigoNcm;
    }

    public String getPrqCodigoNcm() {
        return prqCodigoNcm;
    }

    public void setPrqCodigoNcm(String prqCodigoNcm) {
        this.prqCodigoNcm = prqCodigoNcm;
    }

    public String getDprAraCodigo() {
        return dprAraCodigo;
    }

    public void setDprAraCodigo(String dprAraCodigo) {
        this.dprAraCodigo = dprAraCodigo;
    }

    public String getDprCodigo() {
        return dprCodigo;
    }

    public void setDprCodigo(String dprCodigo) {
        this.dprCodigo = dprCodigo;
    }

    public Character getTratamientoActivo() {
        return tratamientoActivo;
    }

    public void setTratamientoActivo(Character tratamientoActivo) {
        this.tratamientoActivo = tratamientoActivo;
    }

    public String getFuerza() {
        return fuerza;
    }

    public void setFuerza(String fuerza) {
        this.fuerza = fuerza;
    }

    public String getGrado() {
        return grado;
    }

    public void setGrado(String grado) {
        this.grado = grado;
    }

    public String getSituacion() {
        return situacion;
    }

    public void setSituacion(String situacion) {
        this.situacion = situacion;
    }

    public String getReligion() {
        return religion;
    }

    public void setReligion(String religion) {
        this.religion = religion;
    }

    public String getUltimoAnioInstruccion() {
        return ultimoAnioInstruccion;
    }

    public void setUltimoAnioInstruccion(String ultimoAnioInstruccion) {
        this.ultimoAnioInstruccion = ultimoAnioInstruccion;
    }

    public String getUndmltCodigo() {
        return undmltCodigo;
    }

    public void setUndmltCodigo(String undmltCodigo) {
        this.undmltCodigo = undmltCodigo;
    }

    public BigInteger getUndsldffaaCodigo() {
        return undsldffaaCodigo;
    }

    public void setUndsldffaaCodigo(BigInteger undsldffaaCodigo) {
        this.undsldffaaCodigo = undsldffaaCodigo;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public String getIdIssfa() {
        return idIssfa;
    }

    public void setIdIssfa(String idIssfa) {
        this.idIssfa = idIssfa;
    }

    public String getDiscriminador() {
        return discriminador;
    }

    public void setDiscriminador(String discriminador) {
        this.discriminador = discriminador;
    }

    public String getIdConadis() {
        return idConadis;
    }

    public void setIdConadis(String idConadis) {
        this.idConadis = idConadis;
    }

    public String getIdIssfaTitular() {
        return idIssfaTitular;
    }

    public void setIdIssfaTitular(String idIssfaTitular) {
        this.idIssfaTitular = idIssfaTitular;
    }

    public String getTipoDiscapacidad() {
        return tipoDiscapacidad;
    }

    public void setTipoDiscapacidad(String tipoDiscapacidad) {
        this.tipoDiscapacidad = tipoDiscapacidad;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    @XmlTransient
    public List<Pacientes> getPacientesList() {
        return pacientesList;
    }

    public void setPacientesList(List<Pacientes> pacientesList) {
        this.pacientesList = pacientesList;
    }

    public Pacientes getPacientes() {
        return pacientes;
    }

    public void setPacientes(Pacientes pacientes) {
        this.pacientes = pacientes;
    }

    public Parroquias getParroquias() {
        return parroquias;
    }

    public void setParroquias(Parroquias parroquias) {
        this.parroquias = parroquias;
    }

    public Personal getPersonal() {
        return personal;
    }

    public void setPersonal(Personal personal) {
        this.personal = personal;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (numeroHc != null ? numeroHc.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pacientes)) {
            return false;
        }
        Pacientes other = (Pacientes) object;
        if ((this.numeroHc == null && other.numeroHc != null) || (this.numeroHc != null && !this.numeroHc.equals(other.numeroHc))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Pacientes[ numeroHc=" + numeroHc + " ]";
    }
    
}
