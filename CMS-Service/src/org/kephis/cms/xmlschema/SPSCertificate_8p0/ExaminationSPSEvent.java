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
import javax.xml.bind.annotation.XmlType;


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
 *         &lt;element ref="{urn:un:unece:uncefact:data:standard:ReusableAggregateBusinessInformationEntity:12}OccurrenceSPSLocation"/>
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
    "occurrenceSPSLocation"
})
@XmlRootElement(name = "ExaminationSPSEvent")
public class ExaminationSPSEvent {

    @XmlElement(name = "OccurrenceSPSLocation", required = true)
    protected OccurrenceSPSLocation occurrenceSPSLocation;

    /**
     * Gets the value of the occurrenceSPSLocation property.
     * 
     * @return
     *     possible object is
     *     {@link OccurrenceSPSLocation }
     *     
     */
    public OccurrenceSPSLocation getOccurrenceSPSLocation() {
        return occurrenceSPSLocation;
    }

    /**
     * Sets the value of the occurrenceSPSLocation property.
     * 
     * @param value
     *     allowed object is
     *     {@link OccurrenceSPSLocation }
     *     
     */
    public void setOccurrenceSPSLocation(OccurrenceSPSLocation value) {
        this.occurrenceSPSLocation = value;
    }

}
