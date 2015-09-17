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
@Table(name = "TIPOS_DE_DATOS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TiposDeDatos.findAll", query = "SELECT t FROM TiposDeDatos t"),
    @NamedQuery(name = "TiposDeDatos.findBySecuencial", query = "SELECT t FROM TiposDeDatos t WHERE t.secuencial = :secuencial"),
    @NamedQuery(name = "TiposDeDatos.findByLongitud", query = "SELECT t FROM TiposDeDatos t WHERE t.longitud = :longitud"),
    @NamedQuery(name = "TiposDeDatos.findByMascara", query = "SELECT t FROM TiposDeDatos t WHERE t.mascara = :mascara"),
    @NamedQuery(name = "TiposDeDatos.findByRango", query = "SELECT t FROM TiposDeDatos t WHERE t.rango = :rango"),
    @NamedQuery(name = "TiposDeDatos.findByTipo", query = "SELECT t FROM TiposDeDatos t WHERE t.tipo = :tipo"),
    @NamedQuery(name = "TiposDeDatos.findByValorPorDefecto", query = "SELECT t FROM TiposDeDatos t WHERE t.valorPorDefecto = :valorPorDefecto"),
    @NamedQuery(name = "TiposDeDatos.findByTpodtoDecimal", query = "SELECT t FROM TiposDeDatos t WHERE t.tpodtoDecimal = :tpodtoDecimal")})
public class TiposDeDatos implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "SECUENCIAL")
    private Short secuencial;
    @Basic(optional = false)
    @NotNull
    @Column(name = "LONGITUD")
    private short longitud;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "MASCARA")
    private String mascara;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "RANGO")
    private String rango;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "TIPO")
    private String tipo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "VALOR_POR_DEFECTO")
    private String valorPorDefecto;
    @Column(name = "TPODTO_DECIMAL")
    private Short tpodtoDecimal;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tiposDeDatos")
    private List<VariablesDeExamenes> variablesDeExamenesList;

    public TiposDeDatos() {
    }

    public TiposDeDatos(Short secuencial) {
        this.secuencial = secuencial;
    }

    public TiposDeDatos(Short secuencial, short longitud, String mascara, String rango, String tipo, String valorPorDefecto) {
        this.secuencial = secuencial;
        this.longitud = longitud;
        this.mascara = mascara;
        this.rango = rango;
        this.tipo = tipo;
        this.valorPorDefecto = valorPorDefecto;
    }

    public Short getSecuencial() {
        return secuencial;
    }

    public void setSecuencial(Short secuencial) {
        this.secuencial = secuencial;
    }

    public short getLongitud() {
        return longitud;
    }

    public void setLongitud(short longitud) {
        this.longitud = longitud;
    }

    public String getMascara() {
        return mascara;
    }

    public void setMascara(String mascara) {
        this.mascara = mascara;
    }

    public String getRango() {
        return rango;
    }

    public void setRango(String rango) {
        this.rango = rango;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getValorPorDefecto() {
        return valorPorDefecto;
    }

    public void setValorPorDefecto(String valorPorDefecto) {
        this.valorPorDefecto = valorPorDefecto;
    }

    public Short getTpodtoDecimal() {
        return tpodtoDecimal;
    }

    public void setTpodtoDecimal(Short tpodtoDecimal) {
        this.tpodtoDecimal = tpodtoDecimal;
    }

    @XmlTransient
    public List<VariablesDeExamenes> getVariablesDeExamenesList() {
        return variablesDeExamenesList;
    }

    public void setVariablesDeExamenesList(List<VariablesDeExamenes> variablesDeExamenesList) {
        this.variablesDeExamenesList = variablesDeExamenesList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (secuencial != null ? secuencial.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TiposDeDatos)) {
            return false;
        }
        TiposDeDatos other = (TiposDeDatos) object;
        if ((this.secuencial == null && other.secuencial != null) || (this.secuencial != null && !this.secuencial.equals(other.secuencial))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.TiposDeDatos[ secuencial=" + secuencial + " ]";
    }
    
}
