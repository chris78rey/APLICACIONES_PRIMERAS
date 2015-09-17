/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package he1.odonto.entities;

import he1.sis.entities.HojasDeEvolucion;
import he1.sis.entities.Pacientes;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
 * @author luis_guanoluiza
 */
@Entity
@Table(name = "O_RAYOS_X")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ORayosX.findAll", query = "SELECT o FROM ORayosX o"),
    @NamedQuery(name = "ORayosX.findByRayId", query = "SELECT o FROM ORayosX o WHERE o.rayId = :rayId"),
    @NamedQuery(name = "ORayosX.findByRayFecha", query = "SELECT o FROM ORayosX o WHERE o.rayFecha = :rayFecha"),
    @NamedQuery(name = "ORayosX.findByRayTexto", query = "SELECT o FROM ORayosX o WHERE o.rayTexto = :rayTexto")})
public class ORayosX implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "RAY_ID")
    private BigDecimal rayId;
    @Column(name = "RAY_FECHA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date rayFecha;
    @Size(max = 240)
    @Column(name = "RAY_TEXTO")
    private String rayTexto;
    @Column(name = "CODIGO")
    private BigDecimal codigo;
    @JoinColumn(name = "PCN_NUMERO_HC", referencedColumnName = "NUMERO_HC")
    @ManyToOne
    private Pacientes pacientes;
    @JoinColumn(name = "HJAEVL_NUMERO", referencedColumnName = "NUMERO")
    @ManyToOne
    private HojasDeEvolucion hojasDeEvolucion;

    public ORayosX() {
    }

    public ORayosX(BigDecimal rayId) {
        this.rayId = rayId;
    }

    public BigDecimal getRayId() {
        return rayId;
    }

    public void setRayId(BigDecimal rayId) {
        this.rayId = rayId;
    }

    public Date getRayFecha() {
        return rayFecha;
    }

    public void setRayFecha(Date rayFecha) {
        this.rayFecha = rayFecha;
    }

    public String getRayTexto() {
        return rayTexto;
    }

    public void setRayTexto(String rayTexto) {
        this.rayTexto = rayTexto;
    }

    public BigDecimal getCodigo() {
        return codigo;
    }

    public void setCodigo(BigDecimal codigo) {
        this.codigo = codigo;
    }

  

    public Pacientes getPacientes() {
        return pacientes;
    }

    public void setPacientes(Pacientes pacientes) {
        this.pacientes = pacientes;
    }

    public HojasDeEvolucion getHojasDeEvolucion() {
        return hojasDeEvolucion;
    }

    public void setHojasDeEvolucion(HojasDeEvolucion hojasDeEvolucion) {
        this.hojasDeEvolucion = hojasDeEvolucion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (rayId != null ? rayId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ORayosX)) {
            return false;
        }
        ORayosX other = (ORayosX) object;
        if ((this.rayId == null && other.rayId != null) || (this.rayId != null && !this.rayId.equals(other.rayId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.ORayosX[ rayId=" + rayId + " ]";
    }

}
