

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional
 import grails. converters. JSON 
@Transactional(readOnly = true)
class TrnsltUnLocodeController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 1000, 1000)
        respond TrnsltUnLocode.list(params), model:[trnsltUnLocodeInstanceCount: TrnsltUnLocode.count()]
    }

    def show(TrnsltUnLocode trnsltUnLocodeInstance) {
        respond trnsltUnLocodeInstance
    }

    def create() {
        respond new TrnsltUnLocode(params)
    }

    def returnJSON = {
        
        def list = []
        def listData =TrnsltUnLocode.list()

        listData.each{
            list << [
                it.trnsltUnLocodeId,
                it.codeList,
                it.ecsName,
                it.code,
                it.iso,
                it.city
            ]
        }

        def data = ["aaData":list]
        render data as JSON
        
        
    }
    
						 
    @Transactional
    def save(TrnsltUnLocode trnsltUnLocodeInstance) {
        if (trnsltUnLocodeInstance == null) {
            notFound()
            return
        }

        if (trnsltUnLocodeInstance.hasErrors()) {
            respond trnsltUnLocodeInstance.errors, view:'create'
            return
        }

        trnsltUnLocodeInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'trnsltUnLocode.label', default: 'TrnsltUnLocode'), trnsltUnLocodeInstance.id])
                redirect trnsltUnLocodeInstance
            }
            '*' { respond trnsltUnLocodeInstance, [status: CREATED] }
        }
    }

    def edit(TrnsltUnLocode trnsltUnLocodeInstance) {
        respond trnsltUnLocodeInstance
    }

    @Transactional
    def update(TrnsltUnLocode trnsltUnLocodeInstance) {
        if (trnsltUnLocodeInstance == null) {
            notFound()
            return
        }

        if (trnsltUnLocodeInstance.hasErrors()) {
            respond trnsltUnLocodeInstance.errors, view:'edit'
            return
        }

        trnsltUnLocodeInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'TrnsltUnLocode.label', default: 'TrnsltUnLocode'), trnsltUnLocodeInstance.id])
                redirect trnsltUnLocodeInstance
            }
            '*'{ respond trnsltUnLocodeInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(TrnsltUnLocode trnsltUnLocodeInstance) {

        if (trnsltUnLocodeInstance == null) {
            notFound()
            return
        }

        trnsltUnLocodeInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'TrnsltUnLocode.label', default: 'TrnsltUnLocode'), trnsltUnLocodeInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'trnsltUnLocode.label', default: 'TrnsltUnLocode'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
