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
 *         &lt;element ref="{urn:un:unece:uncefact:data:standard:ReusableAggregateBusinessInformationEntity:12}IncludedSPSTradeLineItem"/>
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
    "includedSPSTradeLineItem"
})
@XmlRootElement(name = "IncludedSPSConsignmentItem")
public class IncludedSPSConsignmentItem {

    @XmlElement(name = "IncludedSPSTradeLineItem", required = true)
    protected IncludedSPSTradeLineItem includedSPSTradeLineItem;

    /**
     * Gets the value of the includedSPSTradeLineItem property.
     * 
     * @return
     *     possible object is
     *     {@link IncludedSPSTradeLineItem }
     *     
     */
    public IncludedSPSTradeLineItem getIncludedSPSTradeLineItem() {
        return includedSPSTradeLineItem;
    }

    /**
     * Sets the value of the includedSPSTradeLineItem property.
     * 
     * @param value
     *     allowed object is
     *     {@link IncludedSPSTradeLineItem }
     *     
     */
    public void setIncludedSPSTradeLineItem(IncludedSPSTradeLineItem value) {
        this.includedSPSTradeLineItem = value;
    }

}
