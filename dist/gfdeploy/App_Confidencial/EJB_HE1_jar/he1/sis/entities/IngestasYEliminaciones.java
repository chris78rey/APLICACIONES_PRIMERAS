/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package he1.sis.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author luis_guanoluiza
 */
@Entity
@Table(name = "INGESTAS_Y_ELIMINACIONES")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "IngestasYEliminaciones.findAll", query = "SELECT i FROM IngestasYEliminaciones i"),
    @NamedQuery(name = "IngestasYEliminaciones.findByPrmatnNumero", query = "SELECT i FROM IngestasYEliminaciones i WHERE i.ingestasYEliminacionesPK.prmatnNumero = :prmatnNumero"),
    @NamedQuery(name = "IngestasYEliminaciones.findByPrmatnPcnNumeroHc", query = "SELECT i FROM IngestasYEliminaciones i WHERE i.ingestasYEliminacionesPK.prmatnPcnNumeroHc = :prmatnPcnNumeroHc"),
    @NamedQuery(name = "IngestasYEliminaciones.findByNumero", query = "SELECT i FROM IngestasYEliminaciones i WHERE i.ingestasYEliminacionesPK.numero = :numero"),
    @NamedQuery(name = "IngestasYEliminaciones.findByFechaDeRegistro", query = "SELECT i FROM IngestasYEliminaciones i WHERE i.fechaDeRegistro = :fechaDeRegistro"),
    @NamedQuery(name = "IngestasYEliminaciones.findByFechaIngesta", query = "SELECT i FROM IngestasYEliminaciones i WHERE i.fechaIngesta = :fechaIngesta"),
    @NamedQuery(name = "IngestasYEliminaciones.findByTipoSolucionIngesta", query = "SELECT i FROM IngestasYEliminaciones i WHERE i.tipoSolucionIngesta = :tipoSolucionIngesta"),
    @NamedQuery(name = "IngestasYEliminaciones.findByCantidadIngesta", query = "SELECT i FROM IngestasYEliminaciones i WHERE i.cantidadIngesta = :cantidadIngesta"),
    @NamedQuery(name = "IngestasYEliminaciones.findByFechaEmpieza", query = "SELECT i FROM IngestasYEliminaciones i WHERE i.fechaEmpieza = :fechaEmpieza"),
    @NamedQuery(name = "IngestasYEliminaciones.findByTipoSolucionLiquidos", query = "SELECT i FROM IngestasYEliminaciones i WHERE i.tipoSolucionLiquidos = :tipoSolucionLiquidos"),
    @NamedQuery(name = "IngestasYEliminaciones.findByFechaDiscontinua", query = "SELECT i FROM IngestasYEliminaciones i WHERE i.fechaDiscontinua = :fechaDiscontinua"),
    @NamedQuery(name = "IngestasYEliminaciones.findByCantidadLiquidos", query = "SELECT i FROM IngestasYEliminaciones i WHERE i.cantidadLiquidos = :cantidadLiquidos"),
    @NamedQuery(name = "IngestasYEliminaciones.findByFechaEliminacion", query = "SELECT i FROM IngestasYEliminaciones i WHERE i.fechaEliminacion = :fechaEliminacion"),
    @NamedQuery(name = "IngestasYEliminaciones.findByCantidadOrinas", query = "SELECT i FROM IngestasYEliminaciones i WHERE i.cantidadOrinas = :cantidadOrinas"),
    @NamedQuery(name = "IngestasYEliminaciones.findByCantidadOtros", query = "SELECT i FROM IngestasYEliminaciones i WHERE i.cantidadOtros = :cantidadOtros"),
    @NamedQuery(name = "IngestasYEliminaciones.findByObservaciones", query = "SELECT i FROM IngestasYEliminaciones i WHERE i.observaciones = :observaciones"),
    @NamedQuery(name = "IngestasYEliminaciones.findByTurno", query = "SELECT i FROM IngestasYEliminaciones i WHERE i.turno = :turno"),
    @NamedQuery(name = "IngestasYEliminaciones.findByDescripcionOtros", query = "SELECT i FROM IngestasYEliminaciones i WHERE i.descripcionOtros = :descripcionOtros"),
    @NamedQuery(name = "IngestasYEliminaciones.findByBanio", query = "SELECT i FROM IngestasYEliminaciones i WHERE i.banio = :banio")})
public class IngestasYEliminaciones implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected IngestasYEliminacionesPK ingestasYEliminacionesPK;
    @Column(name = "FECHA_DE_REGISTRO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaDeRegistro;
    @Column(name = "FECHA_INGESTA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaIngesta;
    @Size(max = 3)
    @Column(name = "TIPO_SOLUCION_INGESTA")
    private String tipoSolucionIngesta;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "CANTIDAD_INGESTA")
    private BigDecimal cantidadIngesta;
    @Column(name = "FECHA_EMPIEZA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaEmpieza;
    @Size(max = 60)
    @Column(name = "TIPO_SOLUCION_LIQUIDOS")
    private String tipoSolucionLiquidos;
    @Column(name = "FECHA_DISCONTINUA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaDiscontinua;
    @Column(name = "CANTIDAD_LIQUIDOS")
    private BigDecimal cantidadLiquidos;
    @Column(name = "FECHA_ELIMINACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaEliminacion;
    @Column(name = "CANTIDAD_ORINAS")
    private BigDecimal cantidadOrinas;
    @Column(name = "CANTIDAD_OTROS")
    private BigDecimal cantidadOtros;
    @Size(max = 500)
    @Column(name = "OBSERVACIONES")
    private String observaciones;
    @Size(max = 2)
    @Column(name = "TURNO")
    private String turno;
    @Size(max = 20)
    @Column(name = "DESCRIPCION_OTROS")
    private String descripcionOtros;
    @Column(name = "BANIO")
    private Character banio;
    @JoinColumn(name = "PRS_CODIGO", referencedColumnName = "CODIGO")
    @ManyToOne(optional = false)
    private Personal personal;
    @JoinColumns({
        @JoinColumn(name = "PRMATN_NUMERO", referencedColumnName = "NUMERO", insertable = false, updatable = false),
        @JoinColumn(name = "PRMATN_PCN_NUMERO_HC", referencedColumnName = "PCN_NUMERO_HC", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private PermanenciasYAtenciones permanenciasYAtenciones;
    @JoinColumns({
        @JoinColumn(name = "DPR_ARA_CODIGO", referencedColumnName = "ARA_CODIGO"),
        @JoinColumn(name = "DPR_CODIGO", referencedColumnName = "CODIGO")})
    @ManyToOne(optional = false)
    private Departamentos departamentos;

    public IngestasYEliminaciones() {
    }

    public IngestasYEliminaciones(IngestasYEliminacionesPK ingestasYEliminacionesPK) {
        this.ingestasYEliminacionesPK = ingestasYEliminacionesPK;
    }

    public IngestasYEliminaciones(int prmatnNumero, int prmatnPcnNumeroHc, int numero) {
        this.ingestasYEliminacionesPK = new IngestasYEliminacionesPK(prmatnNumero, prmatnPcnNumeroHc, numero);
    }

    public IngestasYEliminacionesPK getIngestasYEliminacionesPK() {
        return ingestasYEliminacionesPK;
    }

    public void setIngestasYEliminacionesPK(IngestasYEliminacionesPK ingestasYEliminacionesPK) {
        this.ingestasYEliminacionesPK = ingestasYEliminacionesPK;
    }

    public Date getFechaDeRegistro() {
        return fechaDeRegistro;
    }

    public void setFechaDeRegistro(Date fechaDeRegistro) {
        this.fechaDeRegistro = fechaDeRegistro;
    }

    public Date getFechaIngesta() {
        return fechaIngesta;
    }

    public void setFechaIngesta(Date fechaIngesta) {
        this.fechaIngesta = fechaIngesta;
    }

    public String getTipoSolucionIngesta() {
        return tipoSolucionIngesta;
    }

    public void setTipoSolucionIngesta(String tipoSolucionIngesta) {
        this.tipoSolucionIngesta = tipoSolucionIngesta;
    }

    public BigDecimal getCantidadIngesta() {
        return cantidadIngesta;
    }

    public void setCantidadIngesta(BigDecimal cantidadIngesta) {
        this.cantidadIngesta = cantidadIngesta;
    }

    public Date getFechaEmpieza() {
        return fechaEmpieza;
    }

    public void setFechaEmpieza(Date fechaEmpieza) {
        this.fechaEmpieza = fechaEmpieza;
    }

    public String getTipoSolucionLiquidos() {
        return tipoSolucionLiquidos;
    }

    public void setTipoSolucionLiquidos(String tipoSolucionLiquidos) {
        this.tipoSolucionLiquidos = tipoSolucionLiquidos;
    }

    public Date getFechaDiscontinua() {
        return fechaDiscontinua;
    }

    public void setFechaDiscontinua(Date fechaDiscontinua) {
        this.fechaDiscontinua = fechaDiscontinua;
    }

    public BigDecimal getCantidadLiquidos() {
        return cantidadLiquidos;
    }

    public void setCantidadLiquidos(BigDecimal cantidadLiquidos) {
        this.cantidadLiquidos = cantidadLiquidos;
    }

    public Date getFechaEliminacion() {
        return fechaEliminacion;
    }

    public void setFechaEliminacion(Date fechaEliminacion) {
        this.fechaEliminacion = fechaEliminacion;
    }

    public BigDecimal getCantidadOrinas() {
        return cantidadOrinas;
    }

    public void setCantidadOrinas(BigDecimal cantidadOrinas) {
        this.cantidadOrinas = cantidadOrinas;
    }

    public BigDecimal getCantidadOtros() {
        return cantidadOtros;
    }

    public void setCantidadOtros(BigDecimal cantidadOtros) {
        this.cantidadOtros = cantidadOtros;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    public String getDescripcionOtros() {
        return descripcionOtros;
    }

    public void setDescripcionOtros(String descripcionOtros) {
        this.descripcionOtros = descripcionOtros;
    }

    public Character getBanio() {
        return banio;
    }

    public void setBanio(Character banio) {
        this.banio = banio;
    }

    public Personal getPersonal() {
        return personal;
    }

    public void setPersonal(Personal personal) {
        this.personal = personal;
    }

    public PermanenciasYAtenciones getPermanenciasYAtenciones() {
        return permanenciasYAtenciones;
    }

    public void setPermanenciasYAtenciones(PermanenciasYAtenciones permanenciasYAtenciones) {
        this.permanenciasYAtenciones = permanenciasYAtenciones;
    }

    public Departamentos getDepartamentos() {
        return departamentos;
    }

    public void setDepartamentos(Departamentos departamentos) {
        this.departamentos = departamentos;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ingestasYEliminacionesPK != null ? ingestasYEliminacionesPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof IngestasYEliminaciones)) {
            return false;
        }
        IngestasYEliminaciones other = (IngestasYEliminaciones) object;
        if ((this.ingestasYEliminacionesPK == null && other.ingestasYEliminacionesPK != null) || (this.ingestasYEliminacionesPK != null && !this.ingestasYEliminacionesPK.equals(other.ingestasYEliminacionesPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "he1.sis.entities.IngestasYEliminaciones[ ingestasYEliminacionesPK=" + ingestasYEliminacionesPK + " ]";
    }
    
}
