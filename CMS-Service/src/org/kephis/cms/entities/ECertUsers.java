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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
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
@Table(name = "e_cert_users")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ECertUsers.findAll", query = "SELECT e FROM ECertUsers e"),
    @NamedQuery(name = "ECertUsers.findById", query = "SELECT e FROM ECertUsers e WHERE e.id = :id"),
    @NamedQuery(name = "ECertUsers.findByVersion", query = "SELECT e FROM ECertUsers e WHERE e.version = :version"),
    @NamedQuery(name = "ECertUsers.findByAccountExpired", query = "SELECT e FROM ECertUsers e WHERE e.accountExpired = :accountExpired"),
    @NamedQuery(name = "ECertUsers.findByAccountLocked", query = "SELECT e FROM ECertUsers e WHERE e.accountLocked = :accountLocked"),
    @NamedQuery(name = "ECertUsers.findByCountrycode", query = "SELECT e FROM ECertUsers e WHERE e.countrycode = :countrycode"),
    @NamedQuery(name = "ECertUsers.findByEnabled", query = "SELECT e FROM ECertUsers e WHERE e.enabled = :enabled"),
    @NamedQuery(name = "ECertUsers.findByPassword", query = "SELECT e FROM ECertUsers e WHERE e.password = :password"),
    @NamedQuery(name = "ECertUsers.findByPasswordExpired", query = "SELECT e FROM ECertUsers e WHERE e.passwordExpired = :passwordExpired"),
    @NamedQuery(name = "ECertUsers.findByUsername", query = "SELECT e FROM ECertUsers e WHERE e.username = :username"),
    @NamedQuery(name = "ECertUsers.findByEmail", query = "SELECT e FROM ECertUsers e WHERE e.email = :email")})
public class ECertUsers implements Serializable {

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
    @Column(name = "account_expired")
    private boolean accountExpired;
    @Basic(optional = false)
    @Column(name = "account_locked")
    private boolean accountLocked;
    @Basic(optional = false)
    @Column(name = "countrycode")
    private String countrycode;
    @Basic(optional = false)
    @Column(name = "enabled")
    private boolean enabled;
    @Basic(optional = false)
    @Column(name = "password")
    private String password;
    @Basic(optional = false)
    @Column(name = "password_expired")
    private boolean passwordExpired;
    @Basic(optional = false)
    @Column(name = "username")
    private String username;
    @Basic(optional = false)
    @Column(name = "email")
    private String email;
    @JoinTable(name = "e_cert_user_role", joinColumns = {
        @JoinColumn(name = "user_id", referencedColumnName = "id")}, inverseJoinColumns = {
        @JoinColumn(name = "role_id", referencedColumnName = "id")})
    @ManyToMany
    private Collection<ECertRoles> eCertRoleCollection;

    public ECertUsers() {
    }

    public ECertUsers(Long id) {
        this.id = id;
    }

    public ECertUsers(Long id, long version, boolean accountExpired, boolean accountLocked, String countrycode, boolean enabled, String password, boolean passwordExpired, String username, String email) {
        this.id = id;
        this.version = version;
        this.accountExpired = accountExpired;
        this.accountLocked = accountLocked;
        this.countrycode = countrycode;
        this.enabled = enabled;
        this.password = password;
        this.passwordExpired = passwordExpired;
        this.username = username;
        this.email = email;
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

    public boolean getAccountExpired() {
        return accountExpired;
    }

    public void setAccountExpired(boolean accountExpired) {
        this.accountExpired = accountExpired;
    }

    public boolean getAccountLocked() {
        return accountLocked;
    }

    public void setAccountLocked(boolean accountLocked) {
        this.accountLocked = accountLocked;
    }

    public String getCountrycode() {
        return countrycode;
    }

    public void setCountrycode(String countrycode) {
        this.countrycode = countrycode;
    }

    public boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean getPasswordExpired() {
        return passwordExpired;
    }

    public void setPasswordExpired(boolean passwordExpired) {
        this.passwordExpired = passwordExpired;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @XmlTransient
    public Collection<ECertRoles> getECertRoleCollection() {
        return eCertRoleCollection;
    }

    public void setECertRoleCollection(Collection<ECertRoles> eCertRoleCollection) {
        this.eCertRoleCollection = eCertRoleCollection;
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
        if (!(object instanceof ECertUsers)) {
            return false;
        }
        ECertUsers other = (ECertUsers) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.kephis.cms.entities.ECertUsers[ id=" + id + " ]";
    }
    
}
