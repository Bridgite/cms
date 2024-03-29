//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2014.09.18 at 07:36:19 PM EAT 
//


package org.kephis.cms.xmlschema.SPSCertificate_8p0;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{urn:un:unece:uncefact:data:standard:ReusableAggregateBusinessInformationEntity:12}ActualDateTime"/>
 *         &lt;element ref="{urn:un:unece:uncefact:data:standard:ReusableAggregateBusinessInformationEntity:12}IssueSPSLocation"/>
 *         &lt;element ref="{urn:un:unece:uncefact:data:standard:ReusableAggregateBusinessInformationEntity:12}ProviderSPSParty"/>
 *         &lt;element ref="{urn:un:unece:uncefact:data:standard:ReusableAggregateBusinessInformationEntity:12}IncludedSPSClause"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "actualDateTime",
    "issueSPSLocation",
    "providerSPSParty",
    "includedSPSClause"
})
@XmlRootElement(name = "SignatorySPSAuthentication")
public class SignatorySPSAuthentication {

    @XmlElement(name = "ActualDateTime", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar actualDateTime;
    @XmlElement(name = "IssueSPSLocation", required = true)
    protected IssueSPSLocation issueSPSLocation;
    @XmlElement(name = "ProviderSPSParty", required = true)
    protected ProviderSPSParty providerSPSParty;
    @XmlElement(name = "IncludedSPSClause", required = true)
    protected IncludedSPSClause includedSPSClause;

    /**
     * Gets the value of the actualDateTime property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getActualDateTime() {
        return actualDateTime;
    }

    /**
     * Sets the value of the actualDateTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setActualDateTime(XMLGregorianCalendar value) {
        this.actualDateTime = value;
    }

    /**
     * Gets the value of the issueSPSLocation property.
     * 
     * @return
     *     possible object is
     *     {@link IssueSPSLocation }
     *     
     */
    public IssueSPSLocation getIssueSPSLocation() {
        return issueSPSLocation;
    }

    /**
     * Sets the value of the issueSPSLocation property.
     * 
     * @param value
     *     allowed object is
     *     {@link IssueSPSLocation }
     *     
     */
    public void setIssueSPSLocation(IssueSPSLocation value) {
        this.issueSPSLocation = value;
    }

    /**
     * Gets the value of the providerSPSParty property.
     * 
     * @return
     *     possible object is
     *     {@link ProviderSPSParty }
     *     
     */
    public ProviderSPSParty getProviderSPSParty() {
        return providerSPSParty;
    }

    /**
     * Sets the value of the providerSPSParty property.
     * 
     * @param value
     *     allowed object is
     *     {@link ProviderSPSParty }
     *     
     */
    public void setProviderSPSParty(ProviderSPSParty value) {
        this.providerSPSParty = value;
    }

    /**
     * Gets the value of the includedSPSClause property.
     * 
     * @return
     *     possible object is
     *     {@link IncludedSPSClause }
     *     
     */
    public IncludedSPSClause getIncludedSPSClause() {
        return includedSPSClause;
    }

    /**
     * Sets the value of the includedSPSClause property.
     * 
     * @param value
     *     allowed object is
     *     {@link IncludedSPSClause }
     *     
     */
    public void setIncludedSPSClause(IncludedSPSClause value) {
        this.includedSPSClause = value;
    }

}
