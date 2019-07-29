

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional
 import grails. converters. JSON 
 
@Transactional(readOnly = true)
class TrnsltEpptBotanicalNameController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE" , returnJSON:"GET"]

    def index(Integer max) {
         params.max = Math.min(max ?: 1000, 100000000)
        respond TrnsltEpptBotanicalName.list(params), model:[trnsltEpptBotanicalNameInstanceCount: TrnsltEpptBotanicalName.count()]
    }

    def show(TrnsltEpptBotanicalName trnsltEpptBotanicalNameInstance) {
        respond trnsltEpptBotanicalNameInstance
    }

    def create() {
        respond new TrnsltEpptBotanicalName(params)
    }
 
    def returnJSON = {
        
        def list = []
        def listData =TrnsltEpptBotanicalName.list()

        listData.each{
            list << [
                it.trnsltEpptBotanicalNameId,
                it.codeList,
                it.ecsName,
                it.code,
                it.fullName,
                it.authority
            ]
        }

        def data = ["aaData":list]
        render data as JSON
        
        
    }
    @Transactional
    def save(TrnsltEpptBotanicalName trnsltEpptBotanicalNameInstance) {
        if (trnsltEpptBotanicalNameInstance == null) {
            notFound()
            return
        }

        if (trnsltEpptBotanicalNameInstance.hasErrors()) {
            respond trnsltEpptBotanicalNameInstance.errors, view:'create'
            return
        }

        trnsltEpptBotanicalNameInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'trnsltEpptBotanicalName.label', default: 'TrnsltEpptBotanicalName'), trnsltEpptBotanicalNameInstance.id])
                redirect trnsltEpptBotanicalNameInstance
            }
            '*' { respond trnsltEpptBotanicalNameInstance, [status: CREATED] }
        }
    }

    def edit(TrnsltEpptBotanicalName trnsltEpptBotanicalNameInstance) {
        respond trnsltEpptBotanicalNameInstance
    }

    @Transactional
    def update(TrnsltEpptBotanicalName trnsltEpptBotanicalNameInstance) {
        if (trnsltEpptBotanicalNameInstance == null) {
            notFound()
            return
        }

        if (trnsltEpptBotanicalNameInstance.hasErrors()) {
            respond trnsltEpptBotanicalNameInstance.errors, view:'edit'
            return
        }

        trnsltEpptBotanicalNameInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'TrnsltEpptBotanicalName.label', default: 'TrnsltEpptBotanicalName'), trnsltEpptBotanicalNameInstance.id])
                redirect trnsltEpptBotanicalNameInstance
            }
            '*'{ respond trnsltEpptBotanicalNameInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(TrnsltEpptBotanicalName trnsltEpptBotanicalNameInstance) {

        if (trnsltEpptBotanicalNameInstance == null) {
            notFound()
            return
        }

        trnsltEpptBotanicalNameInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'TrnsltEpptBotanicalName.label', default: 'TrnsltEpptBotanicalName'), trnsltEpptBotanicalNameInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'trnsltEpptBotanicalName.label', default: 'TrnsltEpptBotanicalName'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
   
 
}
