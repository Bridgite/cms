

class ECertStatusHistory {
        String certStatus
	Date statusDate
	String reason
	ECertDetails ECertDetails

	static belongsTo = [ECertDetails]

	static mapping = {
                table "e_cert_status_history" 
		id column: "CERT_HIS_ID"
		version false
	}

	static constraints = {
		certStatus nullable: true, maxSize: 45
		statusDate nullable: true
		reason nullable: true, maxSize: 45
	}
 
}
