/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package he1.seguridades.entities.nuevos;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author christian_ruiz
 */
@Entity
@Table(name = "SEG_SOFTWARE_BITACORA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SegSoftwareBitacora.findAll", query = "SELECT s FROM SegSoftwareBitacora s"),
    @NamedQuery(name = "SegSoftwareBitacora.findByModulo", query = "SELECT s FROM SegSoftwareBitacora s WHERE s.modulo = :modulo")})
public class SegSoftwareBitacora implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "MODULO")
    private String modulo;

    public SegSoftwareBitacora() {
    }

    public SegSoftwareBitacora(String modulo) {
        this.modulo = modulo;
    }

    public String getModulo() {
        return modulo;
    }

    public void setModulo(String modulo) {
        this.modulo = modulo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (modulo != null ? modulo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SegSoftwareBitacora)) {
            return false;
        }
        SegSoftwareBitacora other = (SegSoftwareBitacora) object;
        if ((this.modulo == null && other.modulo != null) || (this.modulo != null && !this.modulo.equals(other.modulo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.SegSoftwareBitacora[ modulo=" + modulo + " ]";
    }
    
}
