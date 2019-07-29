

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class TrnsltCountryIsoCodeController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 1000, 1000)
        respond TrnsltCountryIsoCode.list(params), model:[trnsltCountryIsoCodeInstanceCount: TrnsltCountryIsoCode.count()]
    }

    def show(TrnsltCountryIsoCode trnsltCountryIsoCodeInstance) {
        respond trnsltCountryIsoCodeInstance
    }

    def create() {
        respond new TrnsltCountryIsoCode(params)
    }

    @Transactional
    def save(TrnsltCountryIsoCode trnsltCountryIsoCodeInstance) {
        if (trnsltCountryIsoCodeInstance == null) {
            notFound()
            return
        }

        if (trnsltCountryIsoCodeInstance.hasErrors()) {
            respond trnsltCountryIsoCodeInstance.errors, view:'create'
            return
        }

        trnsltCountryIsoCodeInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'trnsltCountryIsoCode.label', default: 'TrnsltCountryIsoCode'), trnsltCountryIsoCodeInstance.id])
                redirect trnsltCountryIsoCodeInstance
            }
            '*' { respond trnsltCountryIsoCodeInstance, [status: CREATED] }
        }
    }

    def edit(TrnsltCountryIsoCode trnsltCountryIsoCodeInstance) {
        respond trnsltCountryIsoCodeInstance
    }

    @Transactional
    def update(TrnsltCountryIsoCode trnsltCountryIsoCodeInstance) {
        if (trnsltCountryIsoCodeInstance == null) {
            notFound()
            return
        }

        if (trnsltCountryIsoCodeInstance.hasErrors()) {
            respond trnsltCountryIsoCodeInstance.errors, view:'edit'
            return
        }

        trnsltCountryIsoCodeInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'TrnsltCountryIsoCode.label', default: 'TrnsltCountryIsoCode'), trnsltCountryIsoCodeInstance.id])
                redirect trnsltCountryIsoCodeInstance
            }
            '*'{ respond trnsltCountryIsoCodeInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(TrnsltCountryIsoCode trnsltCountryIsoCodeInstance) {

        if (trnsltCountryIsoCodeInstance == null) {
            notFound()
            return
        }

        trnsltCountryIsoCodeInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'TrnsltCountryIsoCode.label', default: 'TrnsltCountryIsoCode'), trnsltCountryIsoCodeInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'trnsltCountryIsoCode.label', default: 'TrnsltCountryIsoCode'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
