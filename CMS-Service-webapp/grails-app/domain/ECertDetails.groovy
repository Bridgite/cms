
class ECertDetails {

	String certFile
	String certNo
	String certStatus
	Date statusDate
	String destinationCountry
	Date dateOfIssue
	String placeOfIssue
	String issuer
	String pdfCertFilePath
	String xmlCertFilePath
	String signedXmlCertFilePath
	String certType

	static hasMany = [ECertStatusHistories: ECertStatusHistory]

	static mapping = {
             table 'e_cert_details'
	     id generator: "assigned"
	     version false
	}

	static constraints = {
		certFile unique: true
		certNo unique: true
		certStatus maxSize: 20
		statusDate nullable: true
		destinationCountry maxSize: 5
		dateOfIssue nullable: true
                unique: ["STATUS_DATE", "CERT_STATUS", "CERT_NO"]
		certType nullable: true
	}
}
