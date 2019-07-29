/**
 * The TrnsltDocumentType entity.
 *
 * @author  Bobby Kimutai 
 *
 *
 */
class TrnsltDocumentType {

	String codeList
	String ecsName
	Integer code
	String name
	String description

	static mapping = {
		id column: "trnslt_document_type_id"
		version false
	}

	static constraints = {
		codeList nullable: true, maxSize: 25
		ecsName nullable: true, maxSize: 25
		code nullable: true
		name nullable: true, maxSize: 45
		description nullable: true
	}
}