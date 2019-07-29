

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class TrnsltRecipientSpsPartyController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond TrnsltRecipientSpsParty.list(params), model:[trnsltRecipientSpsPartyInstanceCount: TrnsltRecipientSpsParty.count()]
    }

    def show(TrnsltRecipientSpsParty trnsltRecipientSpsPartyInstance) {
        respond trnsltRecipientSpsPartyInstance
    }

    def create() {
        respond new TrnsltRecipientSpsParty(params)
    }

    @Transactional
    def save(TrnsltRecipientSpsParty trnsltRecipientSpsPartyInstance) {
        if (trnsltRecipientSpsPartyInstance == null) {
            notFound()
            return
        }

        if (trnsltRecipientSpsPartyInstance.hasErrors()) {
            respond trnsltRecipientSpsPartyInstance.errors, view:'create'
            return
        }

        trnsltRecipientSpsPartyInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'trnsltRecipientSpsParty.label', default: 'TrnsltRecipientSpsParty'), trnsltRecipientSpsPartyInstance.id])
                redirect trnsltRecipientSpsPartyInstance
            }
            '*' { respond trnsltRecipientSpsPartyInstance, [status: CREATED] }
        }
    }

    def edit(TrnsltRecipientSpsParty trnsltRecipientSpsPartyInstance) {
        respond trnsltRecipientSpsPartyInstance
    }

    @Transactional
    def update(TrnsltRecipientSpsParty trnsltRecipientSpsPartyInstance) {
        if (trnsltRecipientSpsPartyInstance == null) {
            notFound()
            return
        }

        if (trnsltRecipientSpsPartyInstance.hasErrors()) {
            respond trnsltRecipientSpsPartyInstance.errors, view:'edit'
            return
        }

        trnsltRecipientSpsPartyInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'TrnsltRecipientSpsParty.label', default: 'TrnsltRecipientSpsParty'), trnsltRecipientSpsPartyInstance.id])
                redirect trnsltRecipientSpsPartyInstance
            }
            '*'{ respond trnsltRecipientSpsPartyInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(TrnsltRecipientSpsParty trnsltRecipientSpsPartyInstance) {

        if (trnsltRecipientSpsPartyInstance == null) {
            notFound()
            return
        }

        trnsltRecipientSpsPartyInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'TrnsltRecipientSpsParty.label', default: 'TrnsltRecipientSpsParty'), trnsltRecipientSpsPartyInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'trnsltRecipientSpsParty.label', default: 'TrnsltRecipientSpsParty'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
