/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package he1.sis.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
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
 * @author luis_guanoluiza
 */
@Entity
@Table(name = "HOJAS_EVOLUCIONES_ENFERMERIA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HojasEvolucionesEnfermeria.findAll", query = "SELECT h FROM HojasEvolucionesEnfermeria h"),
    @NamedQuery(name = "HojasEvolucionesEnfermeria.findByPrmatnPcnNumeroHc", query = "SELECT h FROM HojasEvolucionesEnfermeria h WHERE h.hojasEvolucionesEnfermeriaPK.prmatnPcnNumeroHc = :prmatnPcnNumeroHc"),
    @NamedQuery(name = "HojasEvolucionesEnfermeria.findByPrmatnNumero", query = "SELECT h FROM HojasEvolucionesEnfermeria h WHERE h.hojasEvolucionesEnfermeriaPK.prmatnNumero = :prmatnNumero"),
    @NamedQuery(name = "HojasEvolucionesEnfermeria.findByTurno", query = "SELECT h FROM HojasEvolucionesEnfermeria h WHERE h.hojasEvolucionesEnfermeriaPK.turno = :turno"),
    @NamedQuery(name = "HojasEvolucionesEnfermeria.findByDescripcion", query = "SELECT h FROM HojasEvolucionesEnfermeria h WHERE h.descripcion = :descripcion"),
    @NamedQuery(name = "HojasEvolucionesEnfermeria.findByFecha", query = "SELECT h FROM HojasEvolucionesEnfermeria h WHERE h.hojasEvolucionesEnfermeriaPK.fecha = :fecha")})
public class HojasEvolucionesEnfermeria implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected HojasEvolucionesEnfermeriaPK hojasEvolucionesEnfermeriaPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2000)
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @JoinColumn(name = "PRS_CODIGO", referencedColumnName = "CODIGO")
    @ManyToOne(optional = false)
    private Personal personal;
    @JoinColumns({
        @JoinColumn(name = "PRMATN_NUMERO", referencedColumnName = "NUMERO", insertable = false, updatable = false),
        @JoinColumn(name = "PRMATN_PCN_NUMERO_HC", referencedColumnName = "PCN_NUMERO_HC", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private PermanenciasYAtenciones permanenciasYAtenciones;

    public HojasEvolucionesEnfermeria() {
    }

    public HojasEvolucionesEnfermeria(HojasEvolucionesEnfermeriaPK hojasEvolucionesEnfermeriaPK) {
        this.hojasEvolucionesEnfermeriaPK = hojasEvolucionesEnfermeriaPK;
    }

    public HojasEvolucionesEnfermeria(HojasEvolucionesEnfermeriaPK hojasEvolucionesEnfermeriaPK, String descripcion) {
        this.hojasEvolucionesEnfermeriaPK = hojasEvolucionesEnfermeriaPK;
        this.descripcion = descripcion;
    }

    public HojasEvolucionesEnfermeria(int prmatnPcnNumeroHc, int prmatnNumero, String turno, Date fecha) {
        this.hojasEvolucionesEnfermeriaPK = new HojasEvolucionesEnfermeriaPK(prmatnPcnNumeroHc, prmatnNumero, turno, fecha);
    }

    public HojasEvolucionesEnfermeriaPK getHojasEvolucionesEnfermeriaPK() {
        return hojasEvolucionesEnfermeriaPK;
    }

    public void setHojasEvolucionesEnfermeriaPK(HojasEvolucionesEnfermeriaPK hojasEvolucionesEnfermeriaPK) {
        this.hojasEvolucionesEnfermeriaPK = hojasEvolucionesEnfermeriaPK;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (hojasEvolucionesEnfermeriaPK != null ? hojasEvolucionesEnfermeriaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HojasEvolucionesEnfermeria)) {
            return false;
        }
        HojasEvolucionesEnfermeria other = (HojasEvolucionesEnfermeria) object;
        if ((this.hojasEvolucionesEnfermeriaPK == null && other.hojasEvolucionesEnfermeriaPK != null) || (this.hojasEvolucionesEnfermeriaPK != null && !this.hojasEvolucionesEnfermeriaPK.equals(other.hojasEvolucionesEnfermeriaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "he1.sis.entities.HojasEvolucionesEnfermeria[ hojasEvolucionesEnfermeriaPK=" + hojasEvolucionesEnfermeriaPK + " ]";
    }
    
}
