/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package he1.seguridades.entities;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "SEG_URLS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SegUrls.findAll", query = "SELECT s FROM SegUrls s"),
    @NamedQuery(name = "SegUrls.findById", query = "SELECT s FROM SegUrls s WHERE s.id = :id"),
    @NamedQuery(name = "SegUrls.findByUrlDescrip", query = "SELECT s FROM SegUrls s WHERE s.urlDescrip = :urlDescrip"),
    @NamedQuery(name = "SegUrls.findByUrl", query = "SELECT s FROM SegUrls s WHERE s.url = :url")})
public class SegUrls implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Size(max = 100)
    @Column(name = "URL_DESCRIP")
    private String urlDescrip;
    @Size(max = 4000)
    @Column(name = "URL")
    private String url;

    public SegUrls() {
    }

    public SegUrls(BigDecimal id) {
        this.id = id;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getUrlDescrip() {
        return urlDescrip;
    }

    public void setUrlDescrip(String urlDescrip) {
        this.urlDescrip = urlDescrip;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
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
        if (!(object instanceof SegUrls)) {
            return false;
        }
        SegUrls other = (SegUrls) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "he1.seguridades.entities.SegUrls[ id=" + id + " ]";
    }
    
}
