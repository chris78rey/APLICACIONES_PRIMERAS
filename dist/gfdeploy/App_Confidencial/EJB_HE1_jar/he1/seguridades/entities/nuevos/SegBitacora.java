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
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author christian_ruiz
 */
@Entity
@Table(name = "SEG_BITACORA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SegBitacora.findAll", query = "SELECT s FROM SegBitacora s"),
    @NamedQuery(name = "SegBitacora.findById", query = "SELECT s FROM SegBitacora s WHERE s.id = :id"),
    @NamedQuery(name = "SegBitacora.findByFecha", query = "SELECT s FROM SegBitacora s WHERE s.fecha = :fecha"),
    @NamedQuery(name = "SegBitacora.findByHora", query = "SELECT s FROM SegBitacora s WHERE s.hora = :hora"),
    @NamedQuery(name = "SegBitacora.findByArea", query = "SELECT s FROM SegBitacora s WHERE s.area = :area"),
    @NamedQuery(name = "SegBitacora.findByEvento", query = "SELECT s FROM SegBitacora s WHERE s.evento = :evento"),
    @NamedQuery(name = "SegBitacora.findBySolucion", query = "SELECT s FROM SegBitacora s WHERE s.solucion = :solucion"),
    @NamedQuery(name = "SegBitacora.findByIdUsuario", query = "SELECT s FROM SegBitacora s WHERE s.idUsuario = :idUsuario")})
public class SegBitacora implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Column(name = "FECHA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @Column(name = "HORA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date hora;
    @Size(max = 100)
    @Column(name = "AREA")
    private String area;

    @Column(name = "EVENTO")
    private String evento;

    @Column(name = "SOLUCION")
    private String solucion;
    @Column(name = "ID_USUARIO")
    private BigInteger idUsuario;

    public SegBitacora() {
    }

    public SegBitacora(BigDecimal id) {
        this.id = id;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Date getHora() {
        return hora;
    }

    public void setHora(Date hora) {
        this.hora = hora;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getEvento() {
        return evento;
    }

    public void setEvento(String evento) {
        this.evento = evento;
    }

    public String getSolucion() {
        return solucion;
    }

    public void setSolucion(String solucion) {
        this.solucion = solucion;
    }

    public BigInteger getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(BigInteger idUsuario) {
        this.idUsuario = idUsuario;
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
        if (!(object instanceof SegBitacora)) {
            return false;
        }
        SegBitacora other = (SegBitacora) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.SegBitacora[ id=" + id + " ]";
    }
    
}
