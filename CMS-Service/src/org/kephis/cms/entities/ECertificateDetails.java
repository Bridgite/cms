/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.kephis.cms.entities;

import java.io.Serializable;
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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import java.util.Collection;
import javax.persistence.CascadeType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.OneToMany;

/**
 *
 * @author bobby
 */
@Entity
@Table(name = "e_cert_details")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ECertificateDetails.findByDatesOfIssue", query = "select e from ECertificateDetails e where e.dateOfIssue BETWEEN ?1 AND ?2 AND e.destinationCountry =?3 order by e.id"),
    @NamedQuery(name = "ECertificateDetails.findByDatesOfIssueCount", query = "SELECT COUNT(e) from ECertificateDetails e where e.dateOfIssue BETWEEN ?1 AND ?2 AND e.destinationCountry =?3 order by e.id"),
    @NamedQuery(name = "ECertificateDetails.findByDatesOfIssueCountAndStatus", query = "SELECT COUNT(e) from ECertificateDetails e where e.certStatus = ?1 AND e.dateOfIssue BETWEEN ?2 AND ?3 AND e.destinationCountry =?4  order by e.id"),
    @NamedQuery(name = "ECertificateDetails.findByDatesOfIssueAndStatus", query = "select e from ECertificateDetails e where  e.certStatus = ?1 AND e.dateOfIssue BETWEEN ?2 AND ?3 AND e.destinationCountry =?4 order by e.id"),

    @NamedQuery(name = "ECertificateDetails.findAll", query = "SELECT e FROM ECertificateDetails e"),
    @NamedQuery(name = "ECertificateDetails.findById", query = "SELECT e FROM ECertificateDetails e WHERE e.id = :id"),
    @NamedQuery(name = "ECertificateDetails.findByCertFile", query = "SELECT e FROM ECertificateDetails e WHERE e.certFile = :certFile"),
    @NamedQuery(name = "ECertificateDetails.findByCertNo", query = "SELECT e FROM ECertificateDetails e WHERE e.certNo = :certNo"),
    @NamedQuery(name = "ECertificateDetails.findByCertStatus", query = "SELECT e FROM ECertificateDetails e WHERE e.certStatus = :certStatus"),
    @NamedQuery(name = "ECertificateDetails.findByStatusDate", query = "SELECT e FROM ECertificateDetails e WHERE e.statusDate = :statusDate"),
    @NamedQuery(name = "ECertificateDetails.findByDestinationCountry", query = "SELECT e FROM ECertificateDetails e WHERE e.destinationCountry = :destinationCountry"),
    @NamedQuery(name = "ECertificateDetails.findByDateOfIssue", query = "SELECT e FROM ECertificateDetails e WHERE e.dateOfIssue = :dateOfIssue"),
    @NamedQuery(name = "ECertificateDetails.findByPlaceOfIssue", query = "SELECT e FROM ECertificateDetails e WHERE e.placeOfIssue = :placeOfIssue"),
    @NamedQuery(name = "ECertificateDetails.findByIssuer", query = "SELECT e FROM ECertificateDetails e WHERE e.issuer = :issuer"),
    @NamedQuery(name = "ECertificateDetails.findByPdfCertFilePath", query = "SELECT e FROM ECertificateDetails e WHERE e.pdfCertFilePath = :pdfCertFilePath"),
    @NamedQuery(name = "ECertificateDetails.findByXmlCertFilePath", query = "SELECT e FROM ECertificateDetails e WHERE e.xmlCertFilePath = :xmlCertFilePath"),
    @NamedQuery(name = "ECertificateDetails.findBySignedXmlCertFilePath", query = "SELECT e FROM ECertificateDetails e WHERE e.signedXmlCertFilePath = :signedXmlCertFilePath")})
public class ECertificateDetails implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID") 
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    @Basic(optional = false)
    @Column(name = "CERT_FILE")
    private String certFile;
    @Basic(optional = false)
    @Column(name = "CERT_NO")
    private String certNo;
    @Basic(optional = false)
    @Column(name = "CERT_STATUS")
    private String certStatus;
    @Column(name = "STATUS_DATE")
    @Temporal(TemporalType.DATE)
    private Date statusDate;
    @Basic(optional = false)
    @Column(name = "DESTINATION_COUNTRY")
    private String destinationCountry;
    @Column(name = "DATE_OF_ISSUE")
    @Temporal(TemporalType.DATE)
    private Date dateOfIssue;
    @Basic(optional = false)
    @Column(name = "PLACE_OF_ISSUE")
    private String placeOfIssue;
    @Basic(optional = false)
    @Column(name = "ISSUER")
    private String issuer;
    @Basic(optional = false)
    @Column(name = "PDF_CERT_FILE_PATH")
    private String pdfCertFilePath;
    @Basic(optional = false)
    @Column(name = "XML_CERT_FILE_PATH")
    private String xmlCertFilePath;
    @Basic(optional = false)
    @Column(name = "SIGNED_XML_CERT_FILE_PATH")
    private String signedXmlCertFilePath;
    @Column(name = "CERT_TYPE")
    private String certType;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ecertDetailsId")
    private Collection<ECertificateHistory> eCertStatusHistoryCollection;

    public ECertificateDetails() {
    }

    public ECertificateDetails(Long id) {
        this.id = id;
    }

    public ECertificateDetails(Long id, String certFile, String certNo, String certStatus, String destinationCountry, String placeOfIssue, String issuer, String pdfCertFilePath, String xmlCertFilePath, String signedXmlCertFilePath) {
        this.id = id;
        this.certFile = certFile;
        this.certNo = certNo;
        this.certStatus = certStatus;
        this.destinationCountry = destinationCountry;
        this.placeOfIssue = placeOfIssue;
        this.issuer = issuer;
        this.pdfCertFilePath = pdfCertFilePath;
        this.xmlCertFilePath = xmlCertFilePath;
        this.signedXmlCertFilePath = signedXmlCertFilePath;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCertFile() {
        return certFile;
    }

    public void setCertFile(String certFile) {
        this.certFile = certFile;
    }

    public String getCertNo() {
        return certNo;
    }

    public void setCertNo(String certNo) {
        this.certNo = certNo;
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

    public String getDestinationCountry() {
        return destinationCountry;
    }

    public void setDestinationCountry(String destinationCountry) {
        this.destinationCountry = destinationCountry;
    }

    public Date getDateOfIssue() {
        return dateOfIssue;
    }

    public void setDateOfIssue(Date dateOfIssue) {
        this.dateOfIssue = dateOfIssue;
    }

    public String getPlaceOfIssue() {
        return placeOfIssue;
    }

    public void setPlaceOfIssue(String placeOfIssue) {
        this.placeOfIssue = placeOfIssue;
    }

    public String getIssuer() {
        return issuer;
    }

    public void setIssuer(String issuer) {
        this.issuer = issuer;
    }

    public String getPdfCertFilePath() {
        return pdfCertFilePath;
    }

    public void setPdfCertFilePath(String pdfCertFilePath) {
        this.pdfCertFilePath = pdfCertFilePath;
    }

    public String getXmlCertFilePath() {
        return xmlCertFilePath;
    }

    public void setXmlCertFilePath(String xmlCertFilePath) {
        this.xmlCertFilePath = xmlCertFilePath;
    }

    public String getSignedXmlCertFilePath() {
        return signedXmlCertFilePath;
    }

    public void setSignedXmlCertFilePath(String signedXmlCertFilePath) {
        this.signedXmlCertFilePath = signedXmlCertFilePath;
    }

    public String getCertType() {
        return certType;
    }

    public void setCertType(String certType) {
        this.certType = certType;
    }

    @XmlTransient
    public Collection<ECertificateHistory> getECertStatusHistoryCollection() {
        return eCertStatusHistoryCollection;
    }

    public void setECertStatusHistoryCollection(Collection<ECertificateHistory> eCertStatusHistoryCollection) {
        this.eCertStatusHistoryCollection = eCertStatusHistoryCollection;
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
        if (!(object instanceof ECertificateDetails)) {
            return false;
        }
        ECertificateDetails other = (ECertificateDetails) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.kephis.cms.entities.ECertificateDetails[ certFile=" + certFile + " ]";
    }

}
