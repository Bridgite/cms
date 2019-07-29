/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.kephis.cms.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
//import javax.validation.constraints.NotNull;
//import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author bkimutai
 */
@Entity
@Table(name = "e_cert_status_history", catalog = "ecert_cms_db", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ECertificateHistory.findAll", query = "SELECT e FROM ECertificateHistory e"),
    @NamedQuery(name = "ECertificateHistory.findByCertHisId", query = "SELECT e FROM ECertificateHistory e WHERE e.certHisId = :certHisId"),
    @NamedQuery(name = "ECertificateHistory.findByIdCertificateHistory", query = "SELECT e FROM ECertificateHistory e WHERE e.ecertDetailsId = :idCertificateHistory"),
    @NamedQuery(name = "ECertificateHistory.findByCertStatus", query = "SELECT e FROM ECertificateHistory e WHERE e.certStatus = :certStatus"),
    @NamedQuery(name = "ECertificateHistory.findByStatusDate", query = "SELECT e FROM ECertificateHistory e WHERE e.statusDate = :statusDate"),
    @NamedQuery(name = "ECertificateHistory.findByReason", query = "SELECT e FROM ECertificateHistory e WHERE e.reason = :reason")})
public class ECertificateHistory implements Serializable {
     
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "CERT_HIS_ID")
    private Long certHisId;
    @Column(name = "CERT_STATUS")
    private String certStatus;
    @Column(name = "STATUS_DATE")
    @Temporal(TemporalType.DATE)
    private Date statusDate;
    @Column(name = "REASON")
    private String reason;
    @JoinColumn(name = "ECERT_DETAILS_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private ECertificateDetails ecertDetailsId;

    public ECertificateHistory() {
    }

    public ECertificateHistory(Long certHisId) {
        this.certHisId = certHisId;
    }

    public Long getCertHisId() {
        return certHisId;
    }

    public void setCertHisId(Long certHisId) {
        this.certHisId = certHisId;
    }

    public String getCertStatus() {
        return certStatus;
    }

    public void setCertStatus(String certStatus) {
        this.certStatus = certStatus;
    }

    public Date getStatusDate() {
        return statusDate;
    }

    public void setStatusDate(Date statusDate) {
        this.statusDate = statusDate;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public ECertificateDetails getEcertDetailsId() {
        return ecertDetailsId;
    }

    public void setEcertDetailsId(ECertificateDetails ecertDetailsId) {
        this.ecertDetailsId = ecertDetailsId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (certHisId != null ? certHisId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ECertificateHistory)) {
            return false;
        }
        ECertificateHistory other = (ECertificateHistory) object;
        if ((this.certHisId == null && other.certHisId != null) || (this.certHisId != null && !this.certHisId.equals(other.certHisId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.kephis.cms.entities.ECertificateHistory[ certHisId=" + certHisId + " ]";
    }
    
}
