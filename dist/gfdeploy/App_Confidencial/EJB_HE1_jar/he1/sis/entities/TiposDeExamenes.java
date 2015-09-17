/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package he1.sis.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
 * @author luis_guanoluiza
 */
@Entity
@Table(name = "TIPOS_DE_EXAMENES")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TiposDeExamenes.findAll", query = "SELECT t FROM TiposDeExamenes t"),
    @NamedQuery(name = "TiposDeExamenes.findById", query = "SELECT t FROM TiposDeExamenes t WHERE t.id = :id"),
    @NamedQuery(name = "TiposDeExamenes.findByCargarAFactura", query = "SELECT t FROM TiposDeExamenes t WHERE t.cargarAFactura = :cargarAFactura"),
    @NamedQuery(name = "TiposDeExamenes.findByEstadoDeActividad", query = "SELECT t FROM TiposDeExamenes t WHERE t.estadoDeActividad = :estadoDeActividad"),
    @NamedQuery(name = "TiposDeExamenes.findByFechaDeCreacion", query = "SELECT t FROM TiposDeExamenes t WHERE t.fechaDeCreacion = :fechaDeCreacion"),
    @NamedQuery(name = "TiposDeExamenes.findByNombre", query = "SELECT t FROM TiposDeExamenes t WHERE t.nombre = :nombre"),
    @NamedQuery(name = "TiposDeExamenes.findByRequerimientoDeDiagnostico", query = "SELECT t FROM TiposDeExamenes t WHERE t.requerimientoDeDiagnostico = :requerimientoDeDiagnostico"),
    @NamedQuery(name = "TiposDeExamenes.findByTablaDeDetalle", query = "SELECT t FROM TiposDeExamenes t WHERE t.tablaDeDetalle = :tablaDeDetalle"),
    @NamedQuery(name = "TiposDeExamenes.findByTurno", query = "SELECT t FROM TiposDeExamenes t WHERE t.turno = :turno"),
    @NamedQuery(name = "TiposDeExamenes.findByTiempoEstimado", query = "SELECT t FROM TiposDeExamenes t WHERE t.tiempoEstimado = :tiempoEstimado"),
    @NamedQuery(name = "TiposDeExamenes.findByFormaInvocada", query = "SELECT t FROM TiposDeExamenes t WHERE t.formaInvocada = :formaInvocada"),
    @NamedQuery(name = "TiposDeExamenes.findByPrioridadDeTurno", query = "SELECT t FROM TiposDeExamenes t WHERE t.prioridadDeTurno = :prioridadDeTurno"),
    @NamedQuery(name = "TiposDeExamenes.findByReporteSolicitud", query = "SELECT t FROM TiposDeExamenes t WHERE t.reporteSolicitud = :reporteSolicitud"),
    @NamedQuery(name = "TiposDeExamenes.findByReporteResultado", query = "SELECT t FROM TiposDeExamenes t WHERE t.reporteResultado = :reporteResultado"),
    @NamedQuery(name = "TiposDeExamenes.findByLaboratorioFisico", query = "SELECT t FROM TiposDeExamenes t WHERE t.laboratorioFisico = :laboratorioFisico")})
public class TiposDeExamenes implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "ID")
    private String id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CARGAR_A_FACTURA")
    private Character cargarAFactura;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "ESTADO_DE_ACTIVIDAD")
    private String estadoDeActividad;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHA_DE_CREACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaDeCreacion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "NOMBRE")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Column(name = "REQUERIMIENTO_DE_DIAGNOSTICO")
    private Character requerimientoDeDiagnostico;
    @Size(max = 30)
    @Column(name = "TABLA_DE_DETALLE")
    private String tablaDeDetalle;
    @Column(name = "TURNO")
    private Character turno;
    @Size(max = 4)
    @Column(name = "TIEMPO_ESTIMADO")
    private String tiempoEstimado;
    @Size(max = 35)
    @Column(name = "FORMA_INVOCADA")
    private String formaInvocada;
    @Column(name = "PRIORIDAD_DE_TURNO")
    private Short prioridadDeTurno;
    @Size(max = 20)
    @Column(name = "REPORTE_SOLICITUD")
    private String reporteSolicitud;
    @Size(max = 20)
    @Column(name = "REPORTE_RESULTADO")
    private String reporteResultado;
    @Size(max = 20)
    @Column(name = "LABORATORIO_FISICO")
    private String laboratorioFisico;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tiposDeExamenes")
    private List<VariablesDeExamenes> variablesDeExamenesList;
    @JoinColumns({
        @JoinColumn(name = "DPR_ARA_CODIGO", referencedColumnName = "ARA_CODIGO"),
        @JoinColumn(name = "DPR_CODIGO", referencedColumnName = "CODIGO")})
    @ManyToOne(optional = false)
    private Departamentos departamentos;
    @JoinColumns({
        @JoinColumn(name = "CRG_TIPO", referencedColumnName = "TIPO"),
        @JoinColumn(name = "CRG_CODIGO", referencedColumnName = "CODIGO")})
    @ManyToOne
    private Cargos cargos;

    public TiposDeExamenes() {
    }

    public TiposDeExamenes(String id) {
        this.id = id;
    }

    public TiposDeExamenes(String id, Character cargarAFactura, String estadoDeActividad, Date fechaDeCreacion, String nombre, Character requerimientoDeDiagnostico) {
        this.id = id;
        this.cargarAFactura = cargarAFactura;
        this.estadoDeActividad = estadoDeActividad;
        this.fechaDeCreacion = fechaDeCreacion;
        this.nombre = nombre;
        this.requerimientoDeDiagnostico = requerimientoDeDiagnostico;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Character getCargarAFactura() {
        return cargarAFactura;
    }

    public void setCargarAFactura(Character cargarAFactura) {
        this.cargarAFactura = cargarAFactura;
    }

    public String getEstadoDeActividad() {
        return estadoDeActividad;
    }

    public void setEstadoDeActividad(String estadoDeActividad) {
        this.estadoDeActividad = estadoDeActividad;
    }

    public Date getFechaDeCreacion() {
        return fechaDeCreacion;
    }

    public void setFechaDeCreacion(Date fechaDeCreacion) {
        this.fechaDeCreacion = fechaDeCreacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Character getRequerimientoDeDiagnostico() {
        return requerimientoDeDiagnostico;
    }

    public void setRequerimientoDeDiagnostico(Character requerimientoDeDiagnostico) {
        this.requerimientoDeDiagnostico = requerimientoDeDiagnostico;
    }

    public String getTablaDeDetalle() {
        return tablaDeDetalle;
    }

    public void setTablaDeDetalle(String tablaDeDetalle) {
        this.tablaDeDetalle = tablaDeDetalle;
    }

    public Character getTurno() {
        return turno;
    }

    public void setTurno(Character turno) {
        this.turno = turno;
    }

    public String getTiempoEstimado() {
        return tiempoEstimado;
    }

    public void setTiempoEstimado(String tiempoEstimado) {
        this.tiempoEstimado = tiempoEstimado;
    }

    public String getFormaInvocada() {
        return formaInvocada;
    }

    public void setFormaInvocada(String formaInvocada) {
        this.formaInvocada = formaInvocada;
    }

    public Short getPrioridadDeTurno() {
        return prioridadDeTurno;
    }

    public void setPrioridadDeTurno(Short prioridadDeTurno) {
        this.prioridadDeTurno = prioridadDeTurno;
    }

    public String getReporteSolicitud() {
        return reporteSolicitud;
    }

    public void setReporteSolicitud(String reporteSolicitud) {
        this.reporteSolicitud = reporteSolicitud;
    }

    public String getReporteResultado() {
        return reporteResultado;
    }

    public void setReporteResultado(String reporteResultado) {
        this.reporteResultado = reporteResultado;
    }

    public String getLaboratorioFisico() {
        return laboratorioFisico;
    }

    public void setLaboratorioFisico(String laboratorioFisico) {
        this.laboratorioFisico = laboratorioFisico;
    }

    @XmlTransient
    public List<VariablesDeExamenes> getVariablesDeExamenesList() {
        return variablesDeExamenesList;
    }

    public void setVariablesDeExamenesList(List<VariablesDeExamenes> variablesDeExamenesList) {
        this.variablesDeExamenesList = variablesDeExamenesList;
    }

    public Departamentos getDepartamentos() {
        return departamentos;
    }

    public void setDepartamentos(Departamentos departamentos) {
        this.departamentos = departamentos;
    }

    public Cargos getCargos() {
        return cargos;
    }

    public void setCargos(Cargos cargos) {
        this.cargos = cargos;
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
        if (!(object instanceof TiposDeExamenes)) {
            return false;
        }
        TiposDeExamenes other = (TiposDeExamenes) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.TiposDeExamenes[ id=" + id + " ]";
    }
    
}
