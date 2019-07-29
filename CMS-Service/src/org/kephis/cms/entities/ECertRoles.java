/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.kephis.cms.entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author bobby
 */
@Entity
@Table(name = "e_cert_role")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ECertRoles.findAll", query = "SELECT e FROM ECertRoles e"),
    @NamedQuery(name = "ECertRoles.findById", query = "SELECT e FROM ECertRoles e WHERE e.id = :id"),
    @NamedQuery(name = "ECertRoles.findByVersion", query = "SELECT e FROM ECertRoles e WHERE e.version = :version"),
    @NamedQuery(name = "ECertRoles.findByAuthority", query = "SELECT e FROM ECertRoles e WHERE e.authority = :authority")})
public class ECertRoles implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Basic(optional = false)
    @Column(name = "version")
    private long version;
    @Basic(optional = false)
    @Column(name = "authority")
    private String authority;
    @ManyToMany(mappedBy = "eCertRoleCollection")
    private Collection<ECertUsers> eCertUsersCollection;

    public ECertRoles() {
    }

    public ECertRoles(Long id) {
        this.id = id;
    }

    public ECertRoles(Long id, long version, String authority) {
        this.id = id;
        this.version = version;
        this.authority = authority;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public long getVersion() {
        return version;
    }

    public void setVersion(long version) {
        this.version = version;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    @XmlTransient
    public Collection<ECertUsers> getECertUsersCollection() {
        return eCertUsersCollection;
    }

    public void setECertUsersCollection(Collection<ECertUsers> eCertUsersCollection) {
        this.eCertUsersCollection = eCertUsersCollection;
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
        if (!(object instanceof ECertRoles)) {
            return false;
        }
        ECertRoles other = (ECertRoles) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.kephis.cms.entities.ECertRole[ id=" + id + " ]";
    }
    
}
