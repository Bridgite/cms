import org.springframework.dao.DataIntegrityViolationException
 import grails. converters. JSON  
import groovy.xml.StreamingMarkupBuilder
import java.text.SimpleDateFormat 
import java.util.Date
import grails.plugin.springsecurity.SpringSecurityUtils

class ECertDetailsController {

    static allowedMethods = [create: ['GET', 'POST'], edit: ['GET', 'POST'], delete: 'POST']
    def springSecurityService

    def index(Integer max) {
                params.max = Math.min(max ?: 1000, 10000000)
        respond ECertDetails.list(params), model:[ECertDetailsInstanceCount: ECertDetails.count()]
    }
    
    def viewXmlFileCert(){
    
    def ECertDetailsInstance = ECertDetails.get(params.id)
    //def file = new File(ECertDetailsInstance.xmlCertFilePath)
   def doc = new XmlParser().parse(ECertDetailsInstance.xmlCertFilePath)
    def writer = new StringWriter()
    def nodePrinter = new XmlNodePrinter(new PrintWriter(writer))
    nodePrinter.preserveWhitespace = true
    nodePrinter.print doc
     

render(text:writer.toString(), contentType: "text/xml", encoding: "UTF-8")
       
 
   //def stream = getClass().classLoader.getResourceAsStream((ECertDetailsInstance.xmlCertFilePath))
      // textxml= new XmlSlurper().parse(new File(ECertDetailsInstance.xmlCertFilePath))
        
    }
        def downloadXmlFileCert(){
    def ECertDetailsInstance = ECertDetails.get(params.id)
    def file = new File(ECertDetailsInstance.xmlCertFilePath)

if (file.exists()) {
   response.setContentType("application/octet-stream")
   response.setHeader("Content-disposition", "filename=${file.name}")
   response.outputStream << file.bytes
   return
}
    }
        def downloadSignedXmlFileCert(){
    def ECertDetailsInstance = ECertDetails.get(params.id)
    def file = new File(ECertDetailsInstance.signedXmlCertFilePath)

if (file.exists()) {
   response.setContentType("application/octet-stream")
   response.setHeader("Content-disposition", "filename=${file.name}")
   response.outputStream << file.bytes
   return
}
    }
        def downloadPdfFileCert(){
    def ECertDetailsInstance = ECertDetails.get(params.id)
    def file = new File(ECertDetailsInstance.pdfCertFilePath)

if (file.exists()) {
   response.setContentType("application/octet-stream")
   response.setHeader("Content-Disposition: inline", "filename=${file.name}")
   response.outputStream << file.bytes
   return
}
    }
    def returnJSON = {
        
        def list = []
        def listData = ECertDetails.list()
        def country=User.findById(springSecurityService.principal.id).countrycode
        def roles = springSecurityService.getPrincipal().getAuthorities()
        def listall=false
        for(def role in roles){ 
            if(role.getAuthority() == "ROLE_SUPER_ADMIN_USER"){
                listall=true
            }
           
        }
        listData.each{
               if(it.destinationCountry==country){
                   list << [ 
                it.id, 
                it.certNo, 
                it.certStatus,
                it.statusDate.format("yyyy-MM-dd"), 
                it.certType, 
                it.destinationCountry,
                it.dateOfIssue,
                it.placeOfIssue,
               
               
            ] }
               if( country=='KE' && listall){
                   list << [ 
                it.id, 
                it.certNo,
                it.certStatus, 
                it.statusDate.format("yyyy-MM-dd"),  
                it.certType,
                it.destinationCountry,
                it.dateOfIssue,
                it.placeOfIssue,
               
               
            ] }
        } 
        def data = ["aaData":list]
        render data as JSON
    }
    
   def returnReportsData ={ 
    
        def country=User.findById(springSecurityService.principal.id).countrycode
        def listData =  ECertDetails.executeQuery("SELECT new map(sum(case when CERT_STATUS = :approved then 1 else 0 end)  as approved_status_count, sum(case when CERT_STATUS =:acknowledged  then 1 else 0 end) as acknowledged_status_count,count(DATE_OF_ISSUE) as total_certificates,dateOfIssue as dateOfIssue)  FROM ECertDetails where destinationCountry=:destinationCountry group by dateOfIssue ORDER BY dateOfIssue",
        [approved: 'APPROVED',acknowledged: 'ACKNOWLEDGED',destinationCountry:country])
        def data =  listData
        render data as JSON
   }
 
    
    
    def create() {
		switch (request.method) {
		case 'GET':
        	[ECertDetailsInstance: new ECertDetails(params)]
			break
		case 'POST':
	        def ECertDetailsInstance = new ECertDetails(params)
	        if (!ECertDetailsInstance.save(flush: true)) {
	            render view: 'create', model: [ECertDetailsInstance: ECertDetailsInstance]
	            return
	        }

			flash.message = message(code: 'default.created.message', args: [message(code: 'ECertDetails.label', default: 'ECertDetails'), ECertDetailsInstance.id])
	        redirect action: 'show', id: ECertDetailsInstance.id
			break
		}
    }

    def show() {
        def ECertDetailsInstance = ECertDetails.get(params.id)
        if (!ECertDetailsInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'ECertDetails.label', default: 'ECertDetails'), params.id])
            redirect action: 'list'
            return
        }

        [ECertDetailsInstance: ECertDetailsInstance]
    }

    def edit() {
		switch (request.method) {
		case 'GET':
	        def ECertDetailsInstance = ECertDetails.get(params.id)
	        if (!ECertDetailsInstance) {
	            flash.message = message(code: 'default.not.found.message', args: [message(code: 'ECertDetails.label', default: 'ECertDetails'), params.id])
	            redirect action: 'list'
	            return
	        }

	        [ECertDetailsInstance: ECertDetailsInstance]
			break
		case 'POST':
	        def ECertDetailsInstance = ECertDetails.get(params.id)
	        if (!ECertDetailsInstance) {
	            flash.message = message(code: 'default.not.found.message', args: [message(code: 'ECertDetails.label', default: 'ECertDetails'), params.id])
	            redirect action: 'list'
	            return
	        }

	        if (params.version) {
	            def version = params.version.toLong()
	            if (ECertDetailsInstance.version > version) {
	                ECertDetailsInstance.errors.rejectValue('version', 'default.optimistic.locking.failure',
	                          [message(code: 'ECertDetails.label', default: 'ECertDetails')] as Object[],
	                          "Another user has updated this ECertDetails while you were editing")
	                render view: 'edit', model: [ECertDetailsInstance: ECertDetailsInstance]
	                return
	            }
	        }

	        ECertDetailsInstance.properties = params

	        if (!ECertDetailsInstance.save(flush: true)) {
	            render view: 'edit', model: [ECertDetailsInstance: ECertDetailsInstance]
	            return
	        }

			flash.message = message(code: 'default.updated.message', args: [message(code: 'ECertDetails.label', default: 'ECertDetails'), ECertDetailsInstance.id])
	        redirect action: 'show', id: ECertDetailsInstance.id
			break
		}
    }

    def delete() {
        def ECertDetailsInstance = ECertDetails.get(params.id)
        if (!ECertDetailsInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'ECertDetails.label', default: 'ECertDetails'), params.id])
            redirect action: 'list'
            return
        }

        try {
            ECertDetailsInstance.delete(flush: true)
			flash.message = message(code: 'default.deleted.message', args: [message(code: 'ECertDetails.label', default: 'ECertDetails'), params.id])
            redirect action: 'list'
        }
        catch (DataIntegrityViolationException e) {
			flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'ECertDetails.label', default: 'ECertDetails'), params.id])
            redirect action: 'show', id: params.id
        }
    }
}
