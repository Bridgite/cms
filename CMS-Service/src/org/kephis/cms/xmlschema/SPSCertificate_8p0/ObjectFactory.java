//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2014.09.18 at 07:36:19 PM EAT 
//


package org.kephis.cms.xmlschema.SPSCertificate_8p0;

import java.math.BigInteger;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the org.kephis.cms.schema.SPSCertificate_8p0 package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _LineThree_QNAME = new QName("urn:un:unece:uncefact:data:standard:ReusableAggregateBusinessInformationEntity:12", "LineThree");
    private final static QName _ClassCode_QNAME = new QName("urn:un:unece:uncefact:data:standard:ReusableAggregateBusinessInformationEntity:12", "ClassCode");
    private final static QName _Name_QNAME = new QName("urn:un:unece:uncefact:data:standard:ReusableAggregateBusinessInformationEntity:12", "Name");
    private final static QName _ScientificName_QNAME = new QName("urn:un:unece:uncefact:data:standard:ReusableAggregateBusinessInformationEntity:12", "ScientificName");
    private final static QName _IssueDateTime_QNAME = new QName("urn:un:unece:uncefact:data:standard:ReusableAggregateBusinessInformationEntity:12", "IssueDateTime");
    private final static QName _LevelCode_QNAME = new QName("urn:un:unece:uncefact:data:standard:ReusableAggregateBusinessInformationEntity:12", "LevelCode");
    private final static QName _ModeCode_QNAME = new QName("urn:un:unece:uncefact:data:standard:ReusableAggregateBusinessInformationEntity:12", "ModeCode");
    private final static QName _Description_QNAME = new QName("urn:un:unece:uncefact:data:standard:ReusableAggregateBusinessInformationEntity:12", "Description");
    private final static QName _SequenceNumeric_QNAME = new QName("urn:un:unece:uncefact:data:standard:ReusableAggregateBusinessInformationEntity:12", "SequenceNumeric");
    private final static QName _CommonName_QNAME = new QName("urn:un:unece:uncefact:data:standard:ReusableAggregateBusinessInformationEntity:12", "CommonName");
    private final static QName _SystemName_QNAME = new QName("urn:un:unece:uncefact:data:standard:ReusableAggregateBusinessInformationEntity:12", "SystemName");
    private final static QName _Subject_QNAME = new QName("urn:un:unece:uncefact:data:standard:ReusableAggregateBusinessInformationEntity:12", "Subject");
    private final static QName _CountryID_QNAME = new QName("urn:un:unece:uncefact:data:standard:ReusableAggregateBusinessInformationEntity:12", "CountryID");
    private final static QName _ID_QNAME = new QName("urn:un:unece:uncefact:data:standard:ReusableAggregateBusinessInformationEntity:12", "ID");
    private final static QName _Marking_QNAME = new QName("urn:un:unece:uncefact:data:standard:ReusableAggregateBusinessInformationEntity:12", "Marking");
    private final static QName _Content_QNAME = new QName("urn:un:unece:uncefact:data:standard:ReusableAggregateBusinessInformationEntity:12", "Content");
    private final static QName _ActualDateTime_QNAME = new QName("urn:un:unece:uncefact:data:standard:ReusableAggregateBusinessInformationEntity:12", "ActualDateTime");
    private final static QName _ClassName_QNAME = new QName("urn:un:unece:uncefact:data:standard:ReusableAggregateBusinessInformationEntity:12", "ClassName");
    private final static QName _PostcodeCode_QNAME = new QName("urn:un:unece:uncefact:data:standard:ReusableAggregateBusinessInformationEntity:12", "PostcodeCode");
    private final static QName _AbbreviatedName_QNAME = new QName("urn:un:unece:uncefact:data:standard:ReusableAggregateBusinessInformationEntity:12", "AbbreviatedName");
    private final static QName _TypeCode_QNAME = new QName("urn:un:unece:uncefact:data:standard:ReusableAggregateBusinessInformationEntity:12", "TypeCode");
    private final static QName _SubjectCode_QNAME = new QName("urn:un:unece:uncefact:data:standard:ReusableAggregateBusinessInformationEntity:12", "SubjectCode");
    private final static QName _CountryName_QNAME = new QName("urn:un:unece:uncefact:data:standard:ReusableAggregateBusinessInformationEntity:12", "CountryName");
    private final static QName _RoleCode_QNAME = new QName("urn:un:unece:uncefact:data:standard:ReusableAggregateBusinessInformationEntity:12", "RoleCode");
    private final static QName _StatusCode_QNAME = new QName("urn:un:unece:uncefact:data:standard:ReusableAggregateBusinessInformationEntity:12", "StatusCode");
    private final static QName _LineTwo_QNAME = new QName("urn:un:unece:uncefact:data:standard:ReusableAggregateBusinessInformationEntity:12", "LineTwo");
    private final static QName _CityName_QNAME = new QName("urn:un:unece:uncefact:data:standard:ReusableAggregateBusinessInformationEntity:12", "CityName");
    private final static QName _LineOne_QNAME = new QName("urn:un:unece:uncefact:data:standard:ReusableAggregateBusinessInformationEntity:12", "LineOne");
    private final static QName _SystemID_QNAME = new QName("urn:un:unece:uncefact:data:standard:ReusableAggregateBusinessInformationEntity:12", "SystemID");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.kephis.cms.schema.SPSCertificate_8p0
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link AttainedSPSQualification }
     * 
     */
    public AttainedSPSQualification createAttainedSPSQualification() {
        return new AttainedSPSQualification();
    }

    /**
     * Create an instance of {@link RecipientSPSParty }
     * 
     */
    public RecipientSPSParty createRecipientSPSParty() {
        return new RecipientSPSParty();
    }

    /**
     * Create an instance of {@link SignatorySPSAuthentication }
     * 
     */
    public SignatorySPSAuthentication createSignatorySPSAuthentication() {
        return new SignatorySPSAuthentication();
    }

    /**
     * Create an instance of {@link IssueSPSLocation }
     * 
     */
    public IssueSPSLocation createIssueSPSLocation() {
        return new IssueSPSLocation();
    }

    /**
     * Create an instance of {@link ProviderSPSParty }
     * 
     */
    public ProviderSPSParty createProviderSPSParty() {
        return new ProviderSPSParty();
    }

    /**
     * Create an instance of {@link SpecifiedSPSPerson }
     * 
     */
    public SpecifiedSPSPerson createSpecifiedSPSPerson() {
        return new SpecifiedSPSPerson();
    }

    /**
     * Create an instance of {@link IncludedSPSClause }
     * 
     */
    public IncludedSPSClause createIncludedSPSClause() {
        return new IncludedSPSClause();
    }

    /**
     * Create an instance of {@link ExportSPSCountry }
     * 
     */
    public ExportSPSCountry createExportSPSCountry() {
        return new ExportSPSCountry();
    }

    /**
     * Create an instance of {@link IncludedSPSNote }
     * 
     */
    public IncludedSPSNote createIncludedSPSNote() {
        return new IncludedSPSNote();
    }

    /**
     * Create an instance of {@link ContentCode }
     * 
     */
    public ContentCode createContentCode() {
        return new ContentCode();
    }

    /**
     * Create an instance of {@link ItemQuantity }
     * 
     */
    public ItemQuantity createItemQuantity() {
        return new ItemQuantity();
    }

    /**
     * Create an instance of {@link CityID }
     * 
     */
    public CityID createCityID() {
        return new CityID();
    }

    /**
     * Create an instance of {@link OccurrenceSPSLocation }
     * 
     */
    public OccurrenceSPSLocation createOccurrenceSPSLocation() {
        return new OccurrenceSPSLocation();
    }

    /**
     * Create an instance of {@link ImportSPSCountry }
     * 
     */
    public ImportSPSCountry createImportSPSCountry() {
        return new ImportSPSCountry();
    }

    /**
     * Create an instance of {@link LineFive }
     * 
     */
    public LineFive createLineFive() {
        return new LineFive();
    }

    /**
     * Create an instance of {@link PhysicalSPSShippingMarks }
     * 
     */
    public PhysicalSPSShippingMarks createPhysicalSPSShippingMarks() {
        return new PhysicalSPSShippingMarks();
    }

    /**
     * Create an instance of {@link ApplicableSPSClassification }
     * 
     */
    public ApplicableSPSClassification createApplicableSPSClassification() {
        return new ApplicableSPSClassification();
    }

    /**
     * Create an instance of {@link UsedSPSTransportMeans }
     * 
     */
    public UsedSPSTransportMeans createUsedSPSTransportMeans() {
        return new UsedSPSTransportMeans();
    }

    /**
     * Create an instance of {@link UnloadingBaseportSPSLocation }
     * 
     */
    public UnloadingBaseportSPSLocation createUnloadingBaseportSPSLocation() {
        return new UnloadingBaseportSPSLocation();
    }

    /**
     * Create an instance of {@link NominalGrossWeightMeasure }
     * 
     */
    public NominalGrossWeightMeasure createNominalGrossWeightMeasure() {
        return new NominalGrossWeightMeasure();
    }

    /**
     * Create an instance of {@link ExaminationSPSEvent }
     * 
     */
    public ExaminationSPSEvent createExaminationSPSEvent() {
        return new ExaminationSPSEvent();
    }

    /**
     * Create an instance of {@link IncludedSPSConsignmentItem }
     * 
     */
    public IncludedSPSConsignmentItem createIncludedSPSConsignmentItem() {
        return new IncludedSPSConsignmentItem();
    }

    /**
     * Create an instance of {@link IncludedSPSTradeLineItem }
     * 
     */
    public IncludedSPSTradeLineItem createIncludedSPSTradeLineItem() {
        return new IncludedSPSTradeLineItem();
    }

    /**
     * Create an instance of {@link NetWeightMeasure }
     * 
     */
    public NetWeightMeasure createGrossWeightMeasure() {
        return new NetWeightMeasure();
    }

    /**
     * Create an instance of {@link AdditionalInformationSPSNote }
     * 
     */
    public AdditionalInformationSPSNote createAdditionalInformationSPSNote() {
        return new AdditionalInformationSPSNote();
    }

    /**
     * Create an instance of {@link PhysicalSPSPackage }
     * 
     */
    public PhysicalSPSPackage createPhysicalSPSPackage() {
        return new PhysicalSPSPackage();
    }

    /**
     * Create an instance of {@link OriginSPSCountry }
     * 
     */
    public OriginSPSCountry createOriginSPSCountry() {
        return new OriginSPSCountry();
    }

    /**
     * Create an instance of {@link ConsignorSPSParty }
     * 
     */
    public ConsignorSPSParty createConsignorSPSParty() {
        return new ConsignorSPSParty();
    }

    /**
     * Create an instance of {@link SpecifiedSPSAddress }
     * 
     */
    public SpecifiedSPSAddress createSpecifiedSPSAddress() {
        return new SpecifiedSPSAddress();
    }

    /**
     * Create an instance of {@link LineFour }
     * 
     */
    public LineFour createLineFour() {
        return new LineFour();
    }

    /**
     * Create an instance of {@link ConsigneeSPSParty }
     * 
     */
    public ConsigneeSPSParty createConsigneeSPSParty() {
        return new ConsigneeSPSParty();
    }

    /**
     * Create an instance of {@link MainCarriageSPSTransportMovement }
     * 
     */
    public MainCarriageSPSTransportMovement createMainCarriageSPSTransportMovement() {
        return new MainCarriageSPSTransportMovement();
    }

    /**
     * Create an instance of {@link IssuerSPSParty }
     * 
     */
    public IssuerSPSParty createIssuerSPSParty() {
        return new IssuerSPSParty();
    }

    /**
     * Create an instance of {@link SPSCertificate }
     * 
     */
    public SPSCertificate createSPSCertificate() {
        return new SPSCertificate();
    }

    /**
     * Create an instance of {@link SPSExchangedDocument }
     * 
     */
    public SPSExchangedDocument createSPSExchangedDocument() {
        return new SPSExchangedDocument();
    }

    /**
     * Create an instance of {@link SPSConsignment }
     * 
     */
    public SPSConsignment createSPSConsignment() {
        return new SPSConsignment();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:un:unece:uncefact:data:standard:ReusableAggregateBusinessInformationEntity:12", name = "LineThree")
    public JAXBElement<String> createLineThree(String value) {
        return new JAXBElement<String>(_LineThree_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:un:unece:uncefact:data:standard:ReusableAggregateBusinessInformationEntity:12", name = "ClassCode")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    public JAXBElement<String> createClassCode(String value) {
        return new JAXBElement<String>(_ClassCode_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:un:unece:uncefact:data:standard:ReusableAggregateBusinessInformationEntity:12", name = "Name")
    public JAXBElement<String> createName(String value) {
        return new JAXBElement<String>(_Name_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:un:unece:uncefact:data:standard:ReusableAggregateBusinessInformationEntity:12", name = "ScientificName")
    public JAXBElement<String> createScientificName(String value) {
        return new JAXBElement<String>(_ScientificName_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:un:unece:uncefact:data:standard:ReusableAggregateBusinessInformationEntity:12", name = "IssueDateTime")
    public JAXBElement<XMLGregorianCalendar> createIssueDateTime(XMLGregorianCalendar value) {
        return new JAXBElement<XMLGregorianCalendar>(_IssueDateTime_QNAME, XMLGregorianCalendar.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigInteger }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:un:unece:uncefact:data:standard:ReusableAggregateBusinessInformationEntity:12", name = "LevelCode")
    public JAXBElement<BigInteger> createLevelCode(BigInteger value) {
        return new JAXBElement<BigInteger>(_LevelCode_QNAME, BigInteger.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigInteger }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:un:unece:uncefact:data:standard:ReusableAggregateBusinessInformationEntity:12", name = "ModeCode")
    public JAXBElement<BigInteger> createModeCode(BigInteger value) {
        return new JAXBElement<BigInteger>(_ModeCode_QNAME, BigInteger.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:un:unece:uncefact:data:standard:ReusableAggregateBusinessInformationEntity:12", name = "Description")
    public JAXBElement<String> createDescription(String value) {
        return new JAXBElement<String>(_Description_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigInteger }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:un:unece:uncefact:data:standard:ReusableAggregateBusinessInformationEntity:12", name = "SequenceNumeric")
    public JAXBElement<BigInteger> createSequenceNumeric(BigInteger value) {
        return new JAXBElement<BigInteger>(_SequenceNumeric_QNAME, BigInteger.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:un:unece:uncefact:data:standard:ReusableAggregateBusinessInformationEntity:12", name = "CommonName")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    public JAXBElement<String> createCommonName(String value) {
        return new JAXBElement<String>(_CommonName_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:un:unece:uncefact:data:standard:ReusableAggregateBusinessInformationEntity:12", name = "SystemName")
    public JAXBElement<String> createSystemName(String value) {
        return new JAXBElement<String>(_SystemName_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:un:unece:uncefact:data:standard:ReusableAggregateBusinessInformationEntity:12", name = "Subject")
    public JAXBElement<String> createSubject(String value) {
        return new JAXBElement<String>(_Subject_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:un:unece:uncefact:data:standard:ReusableAggregateBusinessInformationEntity:12", name = "CountryID")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    public JAXBElement<String> createCountryID(String value) {
        return new JAXBElement<String>(_CountryID_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:un:unece:uncefact:data:standard:ReusableAggregateBusinessInformationEntity:12", name = "ID")
    public JAXBElement<String> createID(String value) {
        return new JAXBElement<String>(_ID_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:un:unece:uncefact:data:standard:ReusableAggregateBusinessInformationEntity:12", name = "Marking")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    public JAXBElement<String> createMarking(String value) {
        return new JAXBElement<String>(_Marking_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:un:unece:uncefact:data:standard:ReusableAggregateBusinessInformationEntity:12", name = "Content")
    public JAXBElement<String> createContent(String value) {
        return new JAXBElement<String>(_Content_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:un:unece:uncefact:data:standard:ReusableAggregateBusinessInformationEntity:12", name = "ActualDateTime")
    public JAXBElement<XMLGregorianCalendar> createActualDateTime(XMLGregorianCalendar value) {
        return new JAXBElement<XMLGregorianCalendar>(_ActualDateTime_QNAME, XMLGregorianCalendar.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:un:unece:uncefact:data:standard:ReusableAggregateBusinessInformationEntity:12", name = "ClassName")
    public JAXBElement<String> createClassName(String value) {
        return new JAXBElement<String>(_ClassName_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:un:unece:uncefact:data:standard:ReusableAggregateBusinessInformationEntity:12", name = "PostcodeCode")
    public JAXBElement<String> createPostcodeCode(String value) {
        return new JAXBElement<String>(_PostcodeCode_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:un:unece:uncefact:data:standard:ReusableAggregateBusinessInformationEntity:12", name = "AbbreviatedName")
    public JAXBElement<String> createAbbreviatedName(String value) {
        return new JAXBElement<String>(_AbbreviatedName_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:un:unece:uncefact:data:standard:ReusableAggregateBusinessInformationEntity:12", name = "TypeCode")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    public JAXBElement<String> createTypeCode(String value) {
        return new JAXBElement<String>(_TypeCode_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:un:unece:uncefact:data:standard:ReusableAggregateBusinessInformationEntity:12", name = "SubjectCode")
    public JAXBElement<String> createSubjectCode(String value) {
        return new JAXBElement<String>(_SubjectCode_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:un:unece:uncefact:data:standard:ReusableAggregateBusinessInformationEntity:12", name = "CountryName")
    public JAXBElement<String> createCountryName(String value) {
        return new JAXBElement<String>(_CountryName_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:un:unece:uncefact:data:standard:ReusableAggregateBusinessInformationEntity:12", name = "RoleCode")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    public JAXBElement<String> createRoleCode(String value) {
        return new JAXBElement<String>(_RoleCode_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigInteger }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:un:unece:uncefact:data:standard:ReusableAggregateBusinessInformationEntity:12", name = "StatusCode")
    public JAXBElement<BigInteger> createStatusCode(BigInteger value) {
        return new JAXBElement<BigInteger>(_StatusCode_QNAME, BigInteger.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:un:unece:uncefact:data:standard:ReusableAggregateBusinessInformationEntity:12", name = "LineTwo")
    public JAXBElement<String> createLineTwo(String value) {
        return new JAXBElement<String>(_LineTwo_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:un:unece:uncefact:data:standard:ReusableAggregateBusinessInformationEntity:12", name = "CityName")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    public JAXBElement<String> createCityName(String value) {
        return new JAXBElement<String>(_CityName_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:un:unece:uncefact:data:standard:ReusableAggregateBusinessInformationEntity:12", name = "LineOne")
    public JAXBElement<String> createLineOne(String value) {
        return new JAXBElement<String>(_LineOne_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:un:unece:uncefact:data:standard:ReusableAggregateBusinessInformationEntity:12", name = "SystemID")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    public JAXBElement<String> createSystemID(String value) {
        return new JAXBElement<String>(_SystemID_QNAME, String.class, null, value);
    }

}
