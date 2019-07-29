

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class TrnsltPackageTypeCodeController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
       params.max = Math.min(max ?: 100000, 1000000)
        respond TrnsltPackageTypeCode.list(params), model:[trnsltPackageTypeCodeInstanceCount: TrnsltPackageTypeCode.count()]
    }

    def show(TrnsltPackageTypeCode trnsltPackageTypeCodeInstance) {
        respond trnsltPackageTypeCodeInstance
    }

    def create() {
        respond new TrnsltPackageTypeCode(params)
    }

    @Transactional
    def save(TrnsltPackageTypeCode trnsltPackageTypeCodeInstance) {
        if (trnsltPackageTypeCodeInstance == null) {
            notFound()
            return
        }

        if (trnsltPackageTypeCodeInstance.hasErrors()) {
            respond trnsltPackageTypeCodeInstance.errors, view:'create'
            return
        }

        trnsltPackageTypeCodeInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'trnsltPackageTypeCode.label', default: 'TrnsltPackageTypeCode'), trnsltPackageTypeCodeInstance.id])
                redirect trnsltPackageTypeCodeInstance
            }
            '*' { respond trnsltPackageTypeCodeInstance, [status: CREATED] }
        }
    }

    def edit(TrnsltPackageTypeCode trnsltPackageTypeCodeInstance) {
        respond trnsltPackageTypeCodeInstance
    }

    @Transactional
    def update(TrnsltPackageTypeCode trnsltPackageTypeCodeInstance) {
        if (trnsltPackageTypeCodeInstance == null) {
            notFound()
            return
        }

        if (trnsltPackageTypeCodeInstance.hasErrors()) {
            respond trnsltPackageTypeCodeInstance.errors, view:'edit'
            return
        }

        trnsltPackageTypeCodeInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'TrnsltPackageTypeCode.label', default: 'TrnsltPackageTypeCode'), trnsltPackageTypeCodeInstance.id])
                redirect trnsltPackageTypeCodeInstance
            }
            '*'{ respond trnsltPackageTypeCodeInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(TrnsltPackageTypeCode trnsltPackageTypeCodeInstance) {

        if (trnsltPackageTypeCodeInstance == null) {
            notFound()
            return
        }

        trnsltPackageTypeCodeInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'TrnsltPackageTypeCode.label', default: 'TrnsltPackageTypeCode'), trnsltPackageTypeCodeInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'trnsltPackageTypeCode.label', default: 'TrnsltPackageTypeCode'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
