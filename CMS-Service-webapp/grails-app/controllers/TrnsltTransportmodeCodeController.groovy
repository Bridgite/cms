

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class TrnsltTransportmodeCodeController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10000, 100000)
        respond TrnsltTransportmodeCode.list(params), model:[trnsltTransportmodeCodeInstanceCount: TrnsltTransportmodeCode.count()]
    }

    def show(TrnsltTransportmodeCode trnsltTransportmodeCodeInstance) {
        respond trnsltTransportmodeCodeInstance
    }

    def create() {
        respond new TrnsltTransportmodeCode(params)
    }

    @Transactional
    def save(TrnsltTransportmodeCode trnsltTransportmodeCodeInstance) {
        if (trnsltTransportmodeCodeInstance == null) {
            notFound()
            return
        }

        if (trnsltTransportmodeCodeInstance.hasErrors()) {
            respond trnsltTransportmodeCodeInstance.errors, view:'create'
            return
        }

        trnsltTransportmodeCodeInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'trnsltTransportmodeCode.label', default: 'TrnsltTransportmodeCode'), trnsltTransportmodeCodeInstance.id])
                redirect trnsltTransportmodeCodeInstance
            }
            '*' { respond trnsltTransportmodeCodeInstance, [status: CREATED] }
        }
    }

    def edit(TrnsltTransportmodeCode trnsltTransportmodeCodeInstance) {
        respond trnsltTransportmodeCodeInstance
    }

    @Transactional
    def update(TrnsltTransportmodeCode trnsltTransportmodeCodeInstance) {
        if (trnsltTransportmodeCodeInstance == null) {
            notFound()
            return
        }

        if (trnsltTransportmodeCodeInstance.hasErrors()) {
            respond trnsltTransportmodeCodeInstance.errors, view:'edit'
            return
        }

        trnsltTransportmodeCodeInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'TrnsltTransportmodeCode.label', default: 'TrnsltTransportmodeCode'), trnsltTransportmodeCodeInstance.id])
                redirect trnsltTransportmodeCodeInstance
            }
            '*'{ respond trnsltTransportmodeCodeInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(TrnsltTransportmodeCode trnsltTransportmodeCodeInstance) {

        if (trnsltTransportmodeCodeInstance == null) {
            notFound()
            return
        }

        trnsltTransportmodeCodeInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'TrnsltTransportmodeCode.label', default: 'TrnsltTransportmodeCode'), trnsltTransportmodeCodeInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'trnsltTransportmodeCode.label', default: 'TrnsltTransportmodeCode'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
