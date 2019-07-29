

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class TrnsltMeasurementCommonCodeController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
         params.max = Math.min(max ?: 10000, 100000)
        respond TrnsltMeasurementCommonCode.list(params), model:[trnsltMeasurementCommonCodeInstanceCount: TrnsltMeasurementCommonCode.count()]
    }

    def show(TrnsltMeasurementCommonCode trnsltMeasurementCommonCodeInstance) {
        respond trnsltMeasurementCommonCodeInstance
    }

    def create() {
        respond new TrnsltMeasurementCommonCode(params)
    }

    @Transactional
    def save(TrnsltMeasurementCommonCode trnsltMeasurementCommonCodeInstance) {
        if (trnsltMeasurementCommonCodeInstance == null) {
            notFound()
            return
        }

        if (trnsltMeasurementCommonCodeInstance.hasErrors()) {
            respond trnsltMeasurementCommonCodeInstance.errors, view:'create'
            return
        }

        trnsltMeasurementCommonCodeInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'trnsltMeasurementCommonCode.label', default: 'TrnsltMeasurementCommonCode'), trnsltMeasurementCommonCodeInstance.id])
                redirect trnsltMeasurementCommonCodeInstance
            }
            '*' { respond trnsltMeasurementCommonCodeInstance, [status: CREATED] }
        }
    }

    def edit(TrnsltMeasurementCommonCode trnsltMeasurementCommonCodeInstance) {
        respond trnsltMeasurementCommonCodeInstance
    }

    @Transactional
    def update(TrnsltMeasurementCommonCode trnsltMeasurementCommonCodeInstance) {
        if (trnsltMeasurementCommonCodeInstance == null) {
            notFound()
            return
        }

        if (trnsltMeasurementCommonCodeInstance.hasErrors()) {
            respond trnsltMeasurementCommonCodeInstance.errors, view:'edit'
            return
        }

        trnsltMeasurementCommonCodeInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'TrnsltMeasurementCommonCode.label', default: 'TrnsltMeasurementCommonCode'), trnsltMeasurementCommonCodeInstance.id])
                redirect trnsltMeasurementCommonCodeInstance
            }
            '*'{ respond trnsltMeasurementCommonCodeInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(TrnsltMeasurementCommonCode trnsltMeasurementCommonCodeInstance) {

        if (trnsltMeasurementCommonCodeInstance == null) {
            notFound()
            return
        }

        trnsltMeasurementCommonCodeInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'TrnsltMeasurementCommonCode.label', default: 'TrnsltMeasurementCommonCode'), trnsltMeasurementCommonCodeInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'trnsltMeasurementCommonCode.label', default: 'TrnsltMeasurementCommonCode'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
