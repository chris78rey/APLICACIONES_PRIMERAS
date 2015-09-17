/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package he1.seguridades.entities.nuevos;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author christian_ruiz
 */
@Entity
@Table(name = "PORTAL_SERVICIOS_DOC")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PortalServiciosDoc.findAll", query = "SELECT p FROM PortalServiciosDoc p"),
    @NamedQuery(name = "PortalServiciosDoc.findById", query = "SELECT p FROM PortalServiciosDoc p WHERE p.id = :id"),
    @NamedQuery(name = "PortalServiciosDoc.findByProyecto", query = "SELECT p FROM PortalServiciosDoc p WHERE p.proyecto = :proyecto"),
    @NamedQuery(name = "PortalServiciosDoc.findByCompletado", query = "SELECT p FROM PortalServiciosDoc p WHERE p.completado = :completado"),
    @NamedQuery(name = "PortalServiciosDoc.findByReutilizable", query = "SELECT p FROM PortalServiciosDoc p WHERE p.reutilizable = :reutilizable"),
    @NamedQuery(name = "PortalServiciosDoc.findByPalabrasClave", query = "SELECT p FROM PortalServiciosDoc p WHERE p.palabrasClave = :palabrasClave"),
    @NamedQuery(name = "PortalServiciosDoc.findByEstado", query = "SELECT p FROM PortalServiciosDoc p WHERE p.estado = :estado"),
    @NamedQuery(name = "PortalServiciosDoc.findByOrden", query = "SELECT p FROM PortalServiciosDoc p WHERE p.orden = :orden"),
    @NamedQuery(name = "PortalServiciosDoc.findByPrioridad", query = "SELECT p FROM PortalServiciosDoc p WHERE p.prioridad = :prioridad"),
    @NamedQuery(name = "PortalServiciosDoc.findByDato", query = "SELECT p FROM PortalServiciosDoc p WHERE p.dato = :dato"),
    @NamedQuery(name = "PortalServiciosDoc.findByDistractor", query = "SELECT p FROM PortalServiciosDoc p WHERE p.distractor = :distractor")})
public class PortalServiciosDoc implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name = "ID")
    private BigInteger id;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Column(name = "PROYECTO")
    private BigDecimal proyecto;
    @Column(name = "COMPLETADO")
    private BigInteger completado;
    @Column(name = "REUTILIZABLE")
    private BigInteger reutilizable;
    @Size(max = 20)
    @Column(name = "PALABRAS_CLAVE")
    private String palabrasClave;
    @Column(name = "ESTADO")
    private BigInteger estado;
    @Column(name = "ORDEN")
    private BigInteger orden;
    @Column(name = "PRIORIDAD")
    private BigInteger prioridad;
    @Lob
    @Column(name = "DOCUMENTACION")
    private String documentacion;
    @Lob
    @Column(name = "JSF")
    private String jsf;
    @Lob
    @Column(name = "MBEAN")
    private String mbean;
    @Lob
    @Column(name = "J2EE")
    private String j2ee;
    @Lob
    @Column(name = "EZCOMP")
    private String ezcomp;
    @Lob
    @Column(name = "ARCHIVO")
    private Serializable archivo;
    @Column(name = "DATO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dato;
    @Lob
    @Column(name = "BORRADORES")
    private String borradores;
    @Size(max = 4000)
    @Column(name = "DISTRACTOR")
    private String distractor;
    @Lob
    @Column(name = "UTIL_001")
    private String util001;
    @Lob
    @Column(name = "UTIL_002")
    private String util002;
    @Lob
    @Column(name = "UTIL_003")
    private String util003;
    @Lob
    @Column(name = "UTIL_004")
    private String util004;
    @Lob
    @Column(name = "UTIL_005")
    private String util005;
    @Lob
    @Column(name = "UTIL_006")
    private String util006;
    @Lob
    @Column(name = "UTIL_007")
    private String util007;
    @Lob
    @Column(name = "UTIL_008")
    private String util008;
    @Lob
    @Column(name = "UTIL_009")
    private String util009;
    @Lob
    @Column(name = "UTIL_010")
    private String util010;
    @Lob
    @Column(name = "UTIL_011")
    private String util011;
    @Lob
    @Column(name = "UTIL_012")
    private String util012;
    @Lob
    @Column(name = "UTIL_013")
    private String util013;
    @Lob
    @Column(name = "UTIL_014")
    private String util014;
    @Lob
    @Column(name = "UTIL_015")
    private String util015;
    @Lob
    @Column(name = "UTIL_016")
    private String util016;
    @Lob
    @Column(name = "UTIL_017")
    private String util017;
    @Lob
    @Column(name = "UTIL_018")
    private String util018;
    @Lob
    @Column(name = "UTIL_019")
    private String util019;
    @Lob
    @Column(name = "UTIL_020")
    private String util020;

    public PortalServiciosDoc() {
    }

    public PortalServiciosDoc(BigDecimal proyecto) {
        this.proyecto = proyecto;
    }

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public BigDecimal getProyecto() {
        return proyecto;
    }

    public void setProyecto(BigDecimal proyecto) {
        this.proyecto = proyecto;
    }

    public BigInteger getCompletado() {
        return completado;
    }

    public void setCompletado(BigInteger completado) {
        this.completado = completado;
    }

    public BigInteger getReutilizable() {
        return reutilizable;
    }

    public void setReutilizable(BigInteger reutilizable) {
        this.reutilizable = reutilizable;
    }

    public String getPalabrasClave() {
        return palabrasClave;
    }

    public void setPalabrasClave(String palabrasClave) {
        this.palabrasClave = palabrasClave;
    }

    public BigInteger getEstado() {
        return estado;
    }

    public void setEstado(BigInteger estado) {
        this.estado = estado;
    }

    public BigInteger getOrden() {
        return orden;
    }

    public void setOrden(BigInteger orden) {
        this.orden = orden;
    }

    public BigInteger getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(BigInteger prioridad) {
        this.prioridad = prioridad;
    }

    public String getDocumentacion() {
        return documentacion;
    }

    public void setDocumentacion(String documentacion) {
        this.documentacion = documentacion;
    }

    public String getJsf() {
        return jsf;
    }

    public void setJsf(String jsf) {
        this.jsf = jsf;
    }

    public String getMbean() {
        return mbean;
    }

    public void setMbean(String mbean) {
        this.mbean = mbean;
    }

    public String getJ2ee() {
        return j2ee;
    }

    public void setJ2ee(String j2ee) {
        this.j2ee = j2ee;
    }

    public String getEzcomp() {
        return ezcomp;
    }

    public void setEzcomp(String ezcomp) {
        this.ezcomp = ezcomp;
    }

    public Serializable getArchivo() {
        return archivo;
    }

    public void setArchivo(Serializable archivo) {
        this.archivo = archivo;
    }

    public Date getDato() {
        return dato;
    }

    public void setDato(Date dato) {
        this.dato = dato;
    }

    public String getBorradores() {
        return borradores;
    }

    public void setBorradores(String borradores) {
        this.borradores = borradores;
    }

    public String getDistractor() {
        return distractor;
    }

    public void setDistractor(String distractor) {
        this.distractor = distractor;
    }

    public String getUtil001() {
        return util001;
    }

    public void setUtil001(String util001) {
        this.util001 = util001;
    }

    public String getUtil002() {
        return util002;
    }

    public void setUtil002(String util002) {
        this.util002 = util002;
    }

    public String getUtil003() {
        return util003;
    }

    public void setUtil003(String util003) {
        this.util003 = util003;
    }

    public String getUtil004() {
        return util004;
    }

    public void setUtil004(String util004) {
        this.util004 = util004;
    }

    public String getUtil005() {
        return util005;
    }

    public void setUtil005(String util005) {
        this.util005 = util005;
    }

    public String getUtil006() {
        return util006;
    }

    public void setUtil006(String util006) {
        this.util006 = util006;
    }

    public String getUtil007() {
        return util007;
    }

    public void setUtil007(String util007) {
        this.util007 = util007;
    }

    public String getUtil008() {
        return util008;
    }

    public void setUtil008(String util008) {
        this.util008 = util008;
    }

    public String getUtil009() {
        return util009;
    }

    public void setUtil009(String util009) {
        this.util009 = util009;
    }

    public String getUtil010() {
        return util010;
    }

    public void setUtil010(String util010) {
        this.util010 = util010;
    }

    public String getUtil011() {
        return util011;
    }

    public void setUtil011(String util011) {
        this.util011 = util011;
    }

    public String getUtil012() {
        return util012;
    }

    public void setUtil012(String util012) {
        this.util012 = util012;
    }

    public String getUtil013() {
        return util013;
    }

    public void setUtil013(String util013) {
        this.util013 = util013;
    }

    public String getUtil014() {
        return util014;
    }

    public void setUtil014(String util014) {
        this.util014 = util014;
    }

    public String getUtil015() {
        return util015;
    }

    public void setUtil015(String util015) {
        this.util015 = util015;
    }

    public String getUtil016() {
        return util016;
    }

    public void setUtil016(String util016) {
        this.util016 = util016;
    }

    public String getUtil017() {
        return util017;
    }

    public void setUtil017(String util017) {
        this.util017 = util017;
    }

    public String getUtil018() {
        return util018;
    }

    public void setUtil018(String util018) {
        this.util018 = util018;
    }

    public String getUtil019() {
        return util019;
    }

    public void setUtil019(String util019) {
        this.util019 = util019;
    }

    public String getUtil020() {
        return util020;
    }

    public void setUtil020(String util020) {
        this.util020 = util020;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (proyecto != null ? proyecto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PortalServiciosDoc)) {
            return false;
        }
        PortalServiciosDoc other = (PortalServiciosDoc) object;
        if ((this.proyecto == null && other.proyecto != null) || (this.proyecto != null && !this.proyecto.equals(other.proyecto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.PortalServiciosDoc[ proyecto=" + proyecto + " ]";
    }
    
}
