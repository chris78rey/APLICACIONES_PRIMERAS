/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package he1.seguridades.entities.nuevos;

import he1.seguridades.entities.SegUsuario;
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
@Table(name = "PERSONAL", schema = "NOMINA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PersonalNomina.findAll", query = "SELECT p FROM PersonalNomina p"),
    @NamedQuery(name = "PersonalNomina.findByPrnIdpersonal", query = "SELECT p FROM PersonalNomina p WHERE p.prnIdpersonal = :prnIdpersonal"),
    @NamedQuery(name = "PersonalNomina.findByPasIdpais", query = "SELECT p FROM PersonalNomina p WHERE p.pasIdpais = :pasIdpais"),
    @NamedQuery(name = "PersonalNomina.findByCcgIdcategoriacargo", query = "SELECT p FROM PersonalNomina p WHERE p.ccgIdcategoriacargo = :ccgIdcategoriacargo"),
    @NamedQuery(name = "PersonalNomina.findByPrqIdparroquia", query = "SELECT p FROM PersonalNomina p WHERE p.prqIdparroquia = :prqIdparroquia"),
    @NamedQuery(name = "PersonalNomina.findByRlgIdreligion", query = "SELECT p FROM PersonalNomina p WHERE p.rlgIdreligion = :rlgIdreligion"),
    @NamedQuery(name = "PersonalNomina.findByRglIdregimen", query = "SELECT p FROM PersonalNomina p WHERE p.rglIdregimen = :rglIdregimen"),
    @NamedQuery(name = "PersonalNomina.findByNedIdniveleducacion", query = "SELECT p FROM PersonalNomina p WHERE p.nedIdniveleducacion = :nedIdniveleducacion"),
    @NamedQuery(name = "PersonalNomina.findByCctIdcentrocosto", query = "SELECT p FROM PersonalNomina p WHERE p.cctIdcentrocosto = :cctIdcentrocosto"),
    @NamedQuery(name = "PersonalNomina.findByBanIdbanco", query = "SELECT p FROM PersonalNomina p WHERE p.banIdbanco = :banIdbanco"),
    @NamedQuery(name = "PersonalNomina.findByTpeIdtipoempleado", query = "SELECT p FROM PersonalNomina p WHERE p.tpeIdtipoempleado = :tpeIdtipoempleado"),
    @NamedQuery(name = "PersonalNomina.findByPrnIdissfa", query = "SELECT p FROM PersonalNomina p WHERE p.prnIdissfa = :prnIdissfa"),
    @NamedQuery(name = "PersonalNomina.findByPrnFechaelaboracion", query = "SELECT p FROM PersonalNomina p WHERE p.prnFechaelaboracion = :prnFechaelaboracion"),
    @NamedQuery(name = "PersonalNomina.findByPrnTipodocumento", query = "SELECT p FROM PersonalNomina p WHERE p.prnTipodocumento = :prnTipodocumento"),
    @NamedQuery(name = "PersonalNomina.findByPrnNumdocumento", query = "SELECT p FROM PersonalNomina p WHERE p.prnNumdocumento = :prnNumdocumento"),
    @NamedQuery(name = "PersonalNomina.findByPrnApellidos", query = "SELECT p FROM PersonalNomina p WHERE p.prnApellidos = :prnApellidos"),
    @NamedQuery(name = "PersonalNomina.findByPrnNombres", query = "SELECT p FROM PersonalNomina p WHERE p.prnNombres = :prnNombres"),
    @NamedQuery(name = "PersonalNomina.findByPrnFechanacimiento", query = "SELECT p FROM PersonalNomina p WHERE p.prnFechanacimiento = :prnFechanacimiento"),
    @NamedQuery(name = "PersonalNomina.findByPrnLugarnacimiento", query = "SELECT p FROM PersonalNomina p WHERE p.prnLugarnacimiento = :prnLugarnacimiento"),
    @NamedQuery(name = "PersonalNomina.findByPrnSexo", query = "SELECT p FROM PersonalNomina p WHERE p.prnSexo = :prnSexo"),
    @NamedQuery(name = "PersonalNomina.findByPrnEstadocivil", query = "SELECT p FROM PersonalNomina p WHERE p.prnEstadocivil = :prnEstadocivil"),
    @NamedQuery(name = "PersonalNomina.findByPrnDireccion", query = "SELECT p FROM PersonalNomina p WHERE p.prnDireccion = :prnDireccion"),
    @NamedQuery(name = "PersonalNomina.findByPrnTelefonocasa", query = "SELECT p FROM PersonalNomina p WHERE p.prnTelefonocasa = :prnTelefonocasa"),
    @NamedQuery(name = "PersonalNomina.findByPrnTelefonomovil", query = "SELECT p FROM PersonalNomina p WHERE p.prnTelefonomovil = :prnTelefonomovil"),
    @NamedQuery(name = "PersonalNomina.findByPrnTiposangre", query = "SELECT p FROM PersonalNomina p WHERE p.prnTiposangre = :prnTiposangre"),
    @NamedQuery(name = "PersonalNomina.findByPrnFechaingreso", query = "SELECT p FROM PersonalNomina p WHERE p.prnFechaingreso = :prnFechaingreso"),
    @NamedQuery(name = "PersonalNomina.findByPrnFechasalida", query = "SELECT p FROM PersonalNomina p WHERE p.prnFechasalida = :prnFechasalida"),
    @NamedQuery(name = "PersonalNomina.findByPrnCorreoelectronico", query = "SELECT p FROM PersonalNomina p WHERE p.prnCorreoelectronico = :prnCorreoelectronico"),
    @NamedQuery(name = "PersonalNomina.findByPrnTallauniforme", query = "SELECT p FROM PersonalNomina p WHERE p.prnTallauniforme = :prnTallauniforme"),
    @NamedQuery(name = "PersonalNomina.findByPrnTallapantalon", query = "SELECT p FROM PersonalNomina p WHERE p.prnTallapantalon = :prnTallapantalon"),
    @NamedQuery(name = "PersonalNomina.findByPrnTallacamisa", query = "SELECT p FROM PersonalNomina p WHERE p.prnTallacamisa = :prnTallacamisa"),
    @NamedQuery(name = "PersonalNomina.findByPrnTallacalzado", query = "SELECT p FROM PersonalNomina p WHERE p.prnTallacalzado = :prnTallacalzado"),
    @NamedQuery(name = "PersonalNomina.findByPrnFormapago", query = "SELECT p FROM PersonalNomina p WHERE p.prnFormapago = :prnFormapago"),
    @NamedQuery(name = "PersonalNomina.findByPrnCuentabancaria", query = "SELECT p FROM PersonalNomina p WHERE p.prnCuentabancaria = :prnCuentabancaria"),
    @NamedQuery(name = "PersonalNomina.findByPrnEstado", query = "SELECT p FROM PersonalNomina p WHERE p.prnEstado = :prnEstado"),
    @NamedQuery(name = "PersonalNomina.findByPrnPagofondosreserva", query = "SELECT p FROM PersonalNomina p WHERE p.prnPagofondosreserva = :prnPagofondosreserva"),
    @NamedQuery(name = "PersonalNomina.findByPrnSueldo", query = "SELECT p FROM PersonalNomina p WHERE p.prnSueldo = :prnSueldo"),
    @NamedQuery(name = "PersonalNomina.findByPrnTipopagosueldo", query = "SELECT p FROM PersonalNomina p WHERE p.prnTipopagosueldo = :prnTipopagosueldo"),
    @NamedQuery(name = "PersonalNomina.findByPrnNumeroafiliacioniess", query = "SELECT p FROM PersonalNomina p WHERE p.prnNumeroafiliacioniess = :prnNumeroafiliacioniess"),
    @NamedQuery(name = "PersonalNomina.findByPrnNumerolibretamilitar", query = "SELECT p FROM PersonalNomina p WHERE p.prnNumerolibretamilitar = :prnNumerolibretamilitar"),
    @NamedQuery(name = "PersonalNomina.findByPrnTransporte", query = "SELECT p FROM PersonalNomina p WHERE p.prnTransporte = :prnTransporte"),
    @NamedQuery(name = "PersonalNomina.findByPrnDescuentoalimentacion", query = "SELECT p FROM PersonalNomina p WHERE p.prnDescuentoalimentacion = :prnDescuentoalimentacion"),
    @NamedQuery(name = "PersonalNomina.findByPrnDescuentoahorro", query = "SELECT p FROM PersonalNomina p WHERE p.prnDescuentoahorro = :prnDescuentoahorro"),
    @NamedQuery(name = "PersonalNomina.findByPrnReingreso", query = "SELECT p FROM PersonalNomina p WHERE p.prnReingreso = :prnReingreso"),
    @NamedQuery(name = "PersonalNomina.findByPrnControldecimos", query = "SELECT p FROM PersonalNomina p WHERE p.prnControldecimos = :prnControldecimos"),
    @NamedQuery(name = "PersonalNomina.findByPrnAniossectorpublico", query = "SELECT p FROM PersonalNomina p WHERE p.prnAniossectorpublico = :prnAniossectorpublico"),
    @NamedQuery(name = "PersonalNomina.findByPrnContactoemergencia", query = "SELECT p FROM PersonalNomina p WHERE p.prnContactoemergencia = :prnContactoemergencia"),
    @NamedQuery(name = "PersonalNomina.findByPrnTelefonocontactoemr", query = "SELECT p FROM PersonalNomina p WHERE p.prnTelefonocontactoemr = :prnTelefonocontactoemr"),
    @NamedQuery(name = "PersonalNomina.findByPrnUser", query = "SELECT p FROM PersonalNomina p WHERE p.prnUser = :prnUser"),
    @NamedQuery(name = "PersonalNomina.findByPrnCondiciontrabajador", query = "SELECT p FROM PersonalNomina p WHERE p.prnCondiciontrabajador = :prnCondiciontrabajador"),
    @NamedQuery(name = "PersonalNomina.findByPrnResidenciatrabajador", query = "SELECT p FROM PersonalNomina p WHERE p.prnResidenciatrabajador = :prnResidenciatrabajador"),
    @NamedQuery(name = "PersonalNomina.findByPrnCnvdblimposicion", query = "SELECT p FROM PersonalNomina p WHERE p.prnCnvdblimposicion = :prnCnvdblimposicion"),
    @NamedQuery(name = "PersonalNomina.findByPrnTiposalarioneto", query = "SELECT p FROM PersonalNomina p WHERE p.prnTiposalarioneto = :prnTiposalarioneto"),
    @NamedQuery(name = "PersonalNomina.findByPrnNmrprnrpldsc", query = "SELECT p FROM PersonalNomina p WHERE p.prnNmrprnrpldsc = :prnNmrprnrpldsc"),
    @NamedQuery(name = "PersonalNomina.findByGctIdgrupocultural", query = "SELECT p FROM PersonalNomina p WHERE p.gctIdgrupocultural = :gctIdgrupocultural"),
    @NamedQuery(name = "PersonalNomina.findByPrnInstitucion", query = "SELECT p FROM PersonalNomina p WHERE p.prnInstitucion = :prnInstitucion"),
    @NamedQuery(name = "PersonalNomina.findByPrnSubfamiliar", query = "SELECT p FROM PersonalNomina p WHERE p.prnSubfamiliar = :prnSubfamiliar"),
    @NamedQuery(name = "PersonalNomina.findByPrnSubalimentacion", query = "SELECT p FROM PersonalNomina p WHERE p.prnSubalimentacion = :prnSubalimentacion"),
    @NamedQuery(name = "PersonalNomina.findByPrnSubtransporte", query = "SELECT p FROM PersonalNomina p WHERE p.prnSubtransporte = :prnSubtransporte"),
    @NamedQuery(name = "PersonalNomina.findByPrnSubantiguedad", query = "SELECT p FROM PersonalNomina p WHERE p.prnSubantiguedad = :prnSubantiguedad"),
    @NamedQuery(name = "PersonalNomina.findByPrnFecharealingreso", query = "SELECT p FROM PersonalNomina p WHERE p.prnFecharealingreso = :prnFecharealingreso"),
    @NamedQuery(name = "PersonalNomina.findByPrnPorcentajedc", query = "SELECT p FROM PersonalNomina p WHERE p.prnPorcentajedc = :prnPorcentajedc")})
public class PersonalNomina implements Serializable {

    @OneToMany(mappedBy = "personalNomina")
    private List<SolicitudCertificado> solicitudCertificadoList;
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "PRN_IDPERSONAL")
    private Long prnIdpersonal;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "PAS_IDPAIS")
    private String pasIdpais;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "CCG_IDCATEGORIACARGO")
    private String ccgIdcategoriacargo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 6)
    @Column(name = "PRQ_IDPARROQUIA")
    private String prqIdparroquia;
    @Basic(optional = false)
    @NotNull
    @Column(name = "RLG_IDRELIGION")
    private long rlgIdreligion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "RGL_IDREGIMEN")
    private BigInteger rglIdregimen;
    @Basic(optional = false)
    @NotNull
    @Column(name = "NED_IDNIVELEDUCACION")
    private long nedIdniveleducacion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "CCT_IDCENTROCOSTO")
    private String cctIdcentrocosto;
    @Basic(optional = false)
    @NotNull
    @Column(name = "BAN_IDBANCO")
    private long banIdbanco;
    @Basic(optional = false)
    @NotNull
    @Column(name = "TPE_IDTIPOEMPLEADO")
    private long tpeIdtipoempleado;
    @Size(max = 50)
    @Column(name = "PRN_IDISSFA")
    private String prnIdissfa;
    @Column(name = "PRN_FECHAELABORACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date prnFechaelaboracion;
    @Size(max = 5)
    @Column(name = "PRN_TIPODOCUMENTO")
    private String prnTipodocumento;
    @Size(max = 15)
    @Column(name = "PRN_NUMDOCUMENTO")
    private String prnNumdocumento;
    @Size(max = 250)
    @Column(name = "PRN_APELLIDOS")
    private String prnApellidos;
    @Size(max = 250)
    @Column(name = "PRN_NOMBRES")
    private String prnNombres;
    @Column(name = "PRN_FECHANACIMIENTO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date prnFechanacimiento;
    @Size(max = 50)
    @Column(name = "PRN_LUGARNACIMIENTO")
    private String prnLugarnacimiento;
    @Column(name = "PRN_SEXO")
    private Character prnSexo;
    @Column(name = "PRN_ESTADOCIVIL")
    private Character prnEstadocivil;
    @Size(max = 250)
    @Column(name = "PRN_DIRECCION")
    private String prnDireccion;
    @Size(max = 100)
    @Column(name = "PRN_TELEFONOCASA")
    private String prnTelefonocasa;
    @Size(max = 100)
    @Column(name = "PRN_TELEFONOMOVIL")
    private String prnTelefonomovil;
    @Size(max = 50)
    @Column(name = "PRN_TIPOSANGRE")
    private String prnTiposangre;
    @Column(name = "PRN_FECHAINGRESO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date prnFechaingreso;
    @Column(name = "PRN_FECHASALIDA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date prnFechasalida;
    @Size(max = 50)
    @Column(name = "PRN_CORREOELECTRONICO")
    private String prnCorreoelectronico;
    @Column(name = "PRN_TALLAUNIFORME")
    private Long prnTallauniforme;
    @Column(name = "PRN_TALLAPANTALON")
    private Long prnTallapantalon;
    @Column(name = "PRN_TALLACAMISA")
    private Long prnTallacamisa;
    @Size(max = 10)
    @Column(name = "PRN_TALLACALZADO")
    private String prnTallacalzado;
    @Column(name = "PRN_FORMAPAGO")
    private Character prnFormapago;
    @Size(max = 50)
    @Column(name = "PRN_CUENTABANCARIA")
    private String prnCuentabancaria;
    @Column(name = "PRN_ESTADO")
    private Character prnEstado;
    @Column(name = "PRN_PAGOFONDOSRESERVA")
    private Character prnPagofondosreserva;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "PRN_SUELDO")
    private BigDecimal prnSueldo;
    @Size(max = 50)
    @Column(name = "PRN_TIPOPAGOSUELDO")
    private String prnTipopagosueldo;
    @Size(max = 50)
    @Column(name = "PRN_NUMEROAFILIACIONIESS")
    private String prnNumeroafiliacioniess;
    @Size(max = 50)
    @Column(name = "PRN_NUMEROLIBRETAMILITAR")
    private String prnNumerolibretamilitar;
    @Column(name = "PRN_TRANSPORTE")
    private Character prnTransporte;
    @Column(name = "PRN_DESCUENTOALIMENTACION")
    private Character prnDescuentoalimentacion;
    @Column(name = "PRN_DESCUENTOAHORRO")
    private Character prnDescuentoahorro;
    @Column(name = "PRN_REINGRESO")
    private Character prnReingreso;
    @Size(max = 5)
    @Column(name = "PRN_CONTROLDECIMOS")
    private String prnControldecimos;
    @Column(name = "PRN_ANIOSSECTORPUBLICO")
    private BigInteger prnAniossectorpublico;
    @Size(max = 250)
    @Column(name = "PRN_CONTACTOEMERGENCIA")
    private String prnContactoemergencia;
    @Size(max = 50)
    @Column(name = "PRN_TELEFONOCONTACTOEMR")
    private String prnTelefonocontactoemr;
    @Size(max = 50)
    @Column(name = "PRN_USER")
    private String prnUser;
    @Size(max = 4)
    @Column(name = "PRN_CONDICIONTRABAJADOR")
    private String prnCondiciontrabajador;
    @Size(max = 4)
    @Column(name = "PRN_RESIDENCIATRABAJADOR")
    private String prnResidenciatrabajador;
    @Size(max = 4)
    @Column(name = "PRN_CNVDBLIMPOSICION")
    private String prnCnvdblimposicion;
    @Size(max = 4)
    @Column(name = "PRN_TIPOSALARIONETO")
    private String prnTiposalarioneto;
    @Size(max = 50)
    @Column(name = "PRN_NMRPRNRPLDSC")
    private String prnNmrprnrpldsc;
    @Column(name = "GCT_IDGRUPOCULTURAL")
    private Long gctIdgrupocultural;
    @Size(max = 250)
    @Column(name = "PRN_INSTITUCION")
    private String prnInstitucion;
    @Column(name = "PRN_SUBFAMILIAR")
    private Character prnSubfamiliar;
    @Column(name = "PRN_SUBALIMENTACION")
    private Character prnSubalimentacion;
    @Column(name = "PRN_SUBTRANSPORTE")
    private Character prnSubtransporte;
    @Column(name = "PRN_SUBANTIGUEDAD")
    private Character prnSubantiguedad;
    @Column(name = "PRN_FECHAREALINGRESO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date prnFecharealingreso;
    @Column(name = "PRN_PORCENTAJEDC")
    private BigDecimal prnPorcentajedc;
    @JoinColumn(name = "TRL_IDTIPORELACION", referencedColumnName = "TRL_IDTIPORELACION")
    @ManyToOne(optional = false)
    private TipoRelacionLaboral tipoRelacionLaboral;
    @OneToMany(mappedBy = "personalNomina")
    private List<SegUsuario> segUsuarioList;

    public PersonalNomina() {
    }

    public PersonalNomina(Long prnIdpersonal) {
        this.prnIdpersonal = prnIdpersonal;
    }

    public PersonalNomina(Long prnIdpersonal, String pasIdpais, String ccgIdcategoriacargo, String prqIdparroquia, long rlgIdreligion, BigInteger rglIdregimen, long nedIdniveleducacion, String cctIdcentrocosto, long banIdbanco, long tpeIdtipoempleado) {
        this.prnIdpersonal = prnIdpersonal;
        this.pasIdpais = pasIdpais;
        this.ccgIdcategoriacargo = ccgIdcategoriacargo;
        this.prqIdparroquia = prqIdparroquia;
        this.rlgIdreligion = rlgIdreligion;
        this.rglIdregimen = rglIdregimen;
        this.nedIdniveleducacion = nedIdniveleducacion;
        this.cctIdcentrocosto = cctIdcentrocosto;
        this.banIdbanco = banIdbanco;
        this.tpeIdtipoempleado = tpeIdtipoempleado;
    }

    public Long getPrnIdpersonal() {
        return prnIdpersonal;
    }

    public void setPrnIdpersonal(Long prnIdpersonal) {
        this.prnIdpersonal = prnIdpersonal;
    }

    public String getPasIdpais() {
        return pasIdpais;
    }

    public void setPasIdpais(String pasIdpais) {
        this.pasIdpais = pasIdpais;
    }

    public String getCcgIdcategoriacargo() {
        return ccgIdcategoriacargo;
    }

    public void setCcgIdcategoriacargo(String ccgIdcategoriacargo) {
        this.ccgIdcategoriacargo = ccgIdcategoriacargo;
    }

    public String getPrqIdparroquia() {
        return prqIdparroquia;
    }

    public void setPrqIdparroquia(String prqIdparroquia) {
        this.prqIdparroquia = prqIdparroquia;
    }

    public long getRlgIdreligion() {
        return rlgIdreligion;
    }

    public void setRlgIdreligion(long rlgIdreligion) {
        this.rlgIdreligion = rlgIdreligion;
    }

    public BigInteger getRglIdregimen() {
        return rglIdregimen;
    }

    public void setRglIdregimen(BigInteger rglIdregimen) {
        this.rglIdregimen = rglIdregimen;
    }

    public long getNedIdniveleducacion() {
        return nedIdniveleducacion;
    }

    public void setNedIdniveleducacion(long nedIdniveleducacion) {
        this.nedIdniveleducacion = nedIdniveleducacion;
    }

    public String getCctIdcentrocosto() {
        return cctIdcentrocosto;
    }

    public void setCctIdcentrocosto(String cctIdcentrocosto) {
        this.cctIdcentrocosto = cctIdcentrocosto;
    }

    public long getBanIdbanco() {
        return banIdbanco;
    }

    public void setBanIdbanco(long banIdbanco) {
        this.banIdbanco = banIdbanco;
    }

    public long getTpeIdtipoempleado() {
        return tpeIdtipoempleado;
    }

    public void setTpeIdtipoempleado(long tpeIdtipoempleado) {
        this.tpeIdtipoempleado = tpeIdtipoempleado;
    }

    public String getPrnIdissfa() {
        return prnIdissfa;
    }

    public void setPrnIdissfa(String prnIdissfa) {
        this.prnIdissfa = prnIdissfa;
    }

    public Date getPrnFechaelaboracion() {
        return prnFechaelaboracion;
    }

    public void setPrnFechaelaboracion(Date prnFechaelaboracion) {
        this.prnFechaelaboracion = prnFechaelaboracion;
    }

    public String getPrnTipodocumento() {
        return prnTipodocumento;
    }

    public void setPrnTipodocumento(String prnTipodocumento) {
        this.prnTipodocumento = prnTipodocumento;
    }

    public String getPrnNumdocumento() {
        return prnNumdocumento;
    }

    public void setPrnNumdocumento(String prnNumdocumento) {
        this.prnNumdocumento = prnNumdocumento;
    }

    public String getPrnApellidos() {
        return prnApellidos;
    }

    public void setPrnApellidos(String prnApellidos) {
        this.prnApellidos = prnApellidos;
    }

    public String getPrnNombres() {
        return prnNombres;
    }

    public void setPrnNombres(String prnNombres) {
        this.prnNombres = prnNombres;
    }

    public Date getPrnFechanacimiento() {
        return prnFechanacimiento;
    }

    public void setPrnFechanacimiento(Date prnFechanacimiento) {
        this.prnFechanacimiento = prnFechanacimiento;
    }

    public String getPrnLugarnacimiento() {
        return prnLugarnacimiento;
    }

    public void setPrnLugarnacimiento(String prnLugarnacimiento) {
        this.prnLugarnacimiento = prnLugarnacimiento;
    }

    public Character getPrnSexo() {
        return prnSexo;
    }

    public void setPrnSexo(Character prnSexo) {
        this.prnSexo = prnSexo;
    }

    public Character getPrnEstadocivil() {
        return prnEstadocivil;
    }

    public void setPrnEstadocivil(Character prnEstadocivil) {
        this.prnEstadocivil = prnEstadocivil;
    }

    public String getPrnDireccion() {
        return prnDireccion;
    }

    public void setPrnDireccion(String prnDireccion) {
        this.prnDireccion = prnDireccion;
    }

    public String getPrnTelefonocasa() {
        return prnTelefonocasa;
    }

    public void setPrnTelefonocasa(String prnTelefonocasa) {
        this.prnTelefonocasa = prnTelefonocasa;
    }

    public String getPrnTelefonomovil() {
        return prnTelefonomovil;
    }

    public void setPrnTelefonomovil(String prnTelefonomovil) {
        this.prnTelefonomovil = prnTelefonomovil;
    }

    public String getPrnTiposangre() {
        return prnTiposangre;
    }

    public void setPrnTiposangre(String prnTiposangre) {
        this.prnTiposangre = prnTiposangre;
    }

    public Date getPrnFechaingreso() {
        return prnFechaingreso;
    }

    public void setPrnFechaingreso(Date prnFechaingreso) {
        this.prnFechaingreso = prnFechaingreso;
    }

    public Date getPrnFechasalida() {
        return prnFechasalida;
    }

    public void setPrnFechasalida(Date prnFechasalida) {
        this.prnFechasalida = prnFechasalida;
    }

    public String getPrnCorreoelectronico() {
        return prnCorreoelectronico;
    }

    public void setPrnCorreoelectronico(String prnCorreoelectronico) {
        this.prnCorreoelectronico = prnCorreoelectronico;
    }

    public Long getPrnTallauniforme() {
        return prnTallauniforme;
    }

    public void setPrnTallauniforme(Long prnTallauniforme) {
        this.prnTallauniforme = prnTallauniforme;
    }

    public Long getPrnTallapantalon() {
        return prnTallapantalon;
    }

    public void setPrnTallapantalon(Long prnTallapantalon) {
        this.prnTallapantalon = prnTallapantalon;
    }

    public Long getPrnTallacamisa() {
        return prnTallacamisa;
    }

    public void setPrnTallacamisa(Long prnTallacamisa) {
        this.prnTallacamisa = prnTallacamisa;
    }

    public String getPrnTallacalzado() {
        return prnTallacalzado;
    }

    public void setPrnTallacalzado(String prnTallacalzado) {
        this.prnTallacalzado = prnTallacalzado;
    }

    public Character getPrnFormapago() {
        return prnFormapago;
    }

    public void setPrnFormapago(Character prnFormapago) {
        this.prnFormapago = prnFormapago;
    }

    public String getPrnCuentabancaria() {
        return prnCuentabancaria;
    }

    public void setPrnCuentabancaria(String prnCuentabancaria) {
        this.prnCuentabancaria = prnCuentabancaria;
    }

    public Character getPrnEstado() {
        return prnEstado;
    }

    public void setPrnEstado(Character prnEstado) {
        this.prnEstado = prnEstado;
    }

    public Character getPrnPagofondosreserva() {
        return prnPagofondosreserva;
    }

    public void setPrnPagofondosreserva(Character prnPagofondosreserva) {
        this.prnPagofondosreserva = prnPagofondosreserva;
    }

    public BigDecimal getPrnSueldo() {
        return prnSueldo;
    }

    public void setPrnSueldo(BigDecimal prnSueldo) {
        this.prnSueldo = prnSueldo;
    }

    public String getPrnTipopagosueldo() {
        return prnTipopagosueldo;
    }

    public void setPrnTipopagosueldo(String prnTipopagosueldo) {
        this.prnTipopagosueldo = prnTipopagosueldo;
    }

    public String getPrnNumeroafiliacioniess() {
        return prnNumeroafiliacioniess;
    }

    public void setPrnNumeroafiliacioniess(String prnNumeroafiliacioniess) {
        this.prnNumeroafiliacioniess = prnNumeroafiliacioniess;
    }

    public String getPrnNumerolibretamilitar() {
        return prnNumerolibretamilitar;
    }

    public void setPrnNumerolibretamilitar(String prnNumerolibretamilitar) {
        this.prnNumerolibretamilitar = prnNumerolibretamilitar;
    }

    public Character getPrnTransporte() {
        return prnTransporte;
    }

    public void setPrnTransporte(Character prnTransporte) {
        this.prnTransporte = prnTransporte;
    }

    public Character getPrnDescuentoalimentacion() {
        return prnDescuentoalimentacion;
    }

    public void setPrnDescuentoalimentacion(Character prnDescuentoalimentacion) {
        this.prnDescuentoalimentacion = prnDescuentoalimentacion;
    }

    public Character getPrnDescuentoahorro() {
        return prnDescuentoahorro;
    }

    public void setPrnDescuentoahorro(Character prnDescuentoahorro) {
        this.prnDescuentoahorro = prnDescuentoahorro;
    }

    public Character getPrnReingreso() {
        return prnReingreso;
    }

    public void setPrnReingreso(Character prnReingreso) {
        this.prnReingreso = prnReingreso;
    }

    public String getPrnControldecimos() {
        return prnControldecimos;
    }

    public void setPrnControldecimos(String prnControldecimos) {
        this.prnControldecimos = prnControldecimos;
    }

    public BigInteger getPrnAniossectorpublico() {
        return prnAniossectorpublico;
    }

    public void setPrnAniossectorpublico(BigInteger prnAniossectorpublico) {
        this.prnAniossectorpublico = prnAniossectorpublico;
    }

    public String getPrnContactoemergencia() {
        return prnContactoemergencia;
    }

    public void setPrnContactoemergencia(String prnContactoemergencia) {
        this.prnContactoemergencia = prnContactoemergencia;
    }

    public String getPrnTelefonocontactoemr() {
        return prnTelefonocontactoemr;
    }

    public void setPrnTelefonocontactoemr(String prnTelefonocontactoemr) {
        this.prnTelefonocontactoemr = prnTelefonocontactoemr;
    }

    public String getPrnUser() {
        return prnUser;
    }

    public void setPrnUser(String prnUser) {
        this.prnUser = prnUser;
    }

    public String getPrnCondiciontrabajador() {
        return prnCondiciontrabajador;
    }

    public void setPrnCondiciontrabajador(String prnCondiciontrabajador) {
        this.prnCondiciontrabajador = prnCondiciontrabajador;
    }

    public String getPrnResidenciatrabajador() {
        return prnResidenciatrabajador;
    }

    public void setPrnResidenciatrabajador(String prnResidenciatrabajador) {
        this.prnResidenciatrabajador = prnResidenciatrabajador;
    }

    public String getPrnCnvdblimposicion() {
        return prnCnvdblimposicion;
    }

    public void setPrnCnvdblimposicion(String prnCnvdblimposicion) {
        this.prnCnvdblimposicion = prnCnvdblimposicion;
    }

    public String getPrnTiposalarioneto() {
        return prnTiposalarioneto;
    }

    public void setPrnTiposalarioneto(String prnTiposalarioneto) {
        this.prnTiposalarioneto = prnTiposalarioneto;
    }

    public String getPrnNmrprnrpldsc() {
        return prnNmrprnrpldsc;
    }

    public void setPrnNmrprnrpldsc(String prnNmrprnrpldsc) {
        this.prnNmrprnrpldsc = prnNmrprnrpldsc;
    }

    public Long getGctIdgrupocultural() {
        return gctIdgrupocultural;
    }

    public void setGctIdgrupocultural(Long gctIdgrupocultural) {
        this.gctIdgrupocultural = gctIdgrupocultural;
    }

    public String getPrnInstitucion() {
        return prnInstitucion;
    }

    public void setPrnInstitucion(String prnInstitucion) {
        this.prnInstitucion = prnInstitucion;
    }

    public Character getPrnSubfamiliar() {
        return prnSubfamiliar;
    }

    public void setPrnSubfamiliar(Character prnSubfamiliar) {
        this.prnSubfamiliar = prnSubfamiliar;
    }

    public Character getPrnSubalimentacion() {
        return prnSubalimentacion;
    }

    public void setPrnSubalimentacion(Character prnSubalimentacion) {
        this.prnSubalimentacion = prnSubalimentacion;
    }

    public Character getPrnSubtransporte() {
        return prnSubtransporte;
    }

    public void setPrnSubtransporte(Character prnSubtransporte) {
        this.prnSubtransporte = prnSubtransporte;
    }

    public Character getPrnSubantiguedad() {
        return prnSubantiguedad;
    }

    public void setPrnSubantiguedad(Character prnSubantiguedad) {
        this.prnSubantiguedad = prnSubantiguedad;
    }

    public Date getPrnFecharealingreso() {
        return prnFecharealingreso;
    }

    public void setPrnFecharealingreso(Date prnFecharealingreso) {
        this.prnFecharealingreso = prnFecharealingreso;
    }

    public BigDecimal getPrnPorcentajedc() {
        return prnPorcentajedc;
    }

    public void setPrnPorcentajedc(BigDecimal prnPorcentajedc) {
        this.prnPorcentajedc = prnPorcentajedc;
    }

    public TipoRelacionLaboral getTipoRelacionLaboral() {
        return tipoRelacionLaboral;
    }

    public void setTipoRelacionLaboral(TipoRelacionLaboral tipoRelacionLaboral) {
        this.tipoRelacionLaboral = tipoRelacionLaboral;
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
        hash += (prnIdpersonal != null ? prnIdpersonal.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PersonalNomina)) {
            return false;
        }
        PersonalNomina other = (PersonalNomina) object;
        if ((this.prnIdpersonal == null && other.prnIdpersonal != null) || (this.prnIdpersonal != null && !this.prnIdpersonal.equals(other.prnIdpersonal))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.PersonalNomina[ prnIdpersonal=" + prnIdpersonal + " ]";
    }

    /**
     * @return the solicitudCertificadoList
     */
    public List<SolicitudCertificado> getSolicitudCertificadoList() {
        return solicitudCertificadoList;
    }

    /**
     * @param solicitudCertificadoList the solicitudCertificadoList to set
     */
    public void setSolicitudCertificadoList(List<SolicitudCertificado> solicitudCertificadoList) {
        this.solicitudCertificadoList = solicitudCertificadoList;
    }

}
