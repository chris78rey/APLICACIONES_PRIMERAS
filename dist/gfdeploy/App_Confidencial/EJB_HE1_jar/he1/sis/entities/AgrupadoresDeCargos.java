/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package he1.sis.entities;

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
@Table(name = "AGRUPADORES_DE_CARGOS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AgrupadoresDeCargos.findAll", query = "SELECT a FROM AgrupadoresDeCargos a"),
    @NamedQuery(name = "AgrupadoresDeCargos.findByCodigo", query = "SELECT a FROM AgrupadoresDeCargos a WHERE a.codigo = :codigo"),
    @NamedQuery(name = "AgrupadoresDeCargos.findByDescripcion", query = "SELECT a FROM AgrupadoresDeCargos a WHERE a.descripcion = :descripcion"),
    @NamedQuery(name = "AgrupadoresDeCargos.findByEstadoDeDisponibilidad", query = "SELECT a FROM AgrupadoresDeCargos a WHERE a.estadoDeDisponibilidad = :estadoDeDisponibilidad"),
    @NamedQuery(name = "AgrupadoresDeCargos.findByObservacion", query = "SELECT a FROM AgrupadoresDeCargos a WHERE a.observacion = :observacion"),
    @NamedQuery(name = "AgrupadoresDeCargos.findByValor", query = "SELECT a FROM AgrupadoresDeCargos a WHERE a.valor = :valor"),
    @NamedQuery(name = "AgrupadoresDeCargos.findByTipo", query = "SELECT a FROM AgrupadoresDeCargos a WHERE a.tipo = :tipo")})
public class AgrupadoresDeCargos implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "CODIGO")
    private String codigo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2000)
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ESTADO_DE_DISPONIBILIDAD")
    private Character estadoDeDisponibilidad;
    @Size(max = 255)
    @Column(name = "OBSERVACION")
    private String observacion;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "VALOR")
    private BigDecimal valor;
    @Size(max = 2)
    @Column(name = "TIPO")
    private String tipo;
    @OneToMany(mappedBy = "agrupadoresDeCargos")
    private List<CamasHospitalizacion> camasHospitalizacionList;
    @OneToMany(mappedBy = "agrupadoresDeCargos1")
    private List<CamasHospitalizacion> camasHospitalizacionList1;

    public AgrupadoresDeCargos() {
    }

    public AgrupadoresDeCargos(String codigo) {
        this.codigo = codigo;
    }

    public AgrupadoresDeCargos(String codigo, String descripcion, Character estadoDeDisponibilidad, BigDecimal valor) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.estadoDeDisponibilidad = estadoDeDisponibilidad;
        this.valor = valor;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Character getEstadoDeDisponibilidad() {
        return estadoDeDisponibilidad;
    }

    public void setEstadoDeDisponibilidad(Character estadoDeDisponibilidad) {
        this.estadoDeDisponibilidad = estadoDeDisponibilidad;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @XmlTransient
    public List<CamasHospitalizacion> getCamasHospitalizacionList() {
        return camasHospitalizacionList;
    }

    public void setCamasHospitalizacionList(List<CamasHospitalizacion> camasHospitalizacionList) {
        this.camasHospitalizacionList = camasHospitalizacionList;
    }

    @XmlTransient
    public List<CamasHospitalizacion> getCamasHospitalizacionList1() {
        return camasHospitalizacionList1;
    }

    public void setCamasHospitalizacionList1(List<CamasHospitalizacion> camasHospitalizacionList1) {
        this.camasHospitalizacionList1 = camasHospitalizacionList1;
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
        if (!(object instanceof AgrupadoresDeCargos)) {
            return false;
        }
        AgrupadoresDeCargos other = (AgrupadoresDeCargos) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "he1.sis.entities.AgrupadoresDeCargos[ codigo=" + codigo + " ]";
    }
    
}
