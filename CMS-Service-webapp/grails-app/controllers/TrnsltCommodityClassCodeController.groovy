

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class TrnsltCommodityClassCodeController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
       params.max = Math.min(max ?: 100000, 100000)
        respond TrnsltCommodityClassCode.list(params), model:[trnsltCommodityClassCodeInstanceCount: TrnsltCommodityClassCode.count()]
    }

    def show(TrnsltCommodityClassCode trnsltCommodityClassCodeInstance) {
        respond trnsltCommodityClassCodeInstance
    }

    def create() {
        respond new TrnsltCommodityClassCode(params)
    }

    @Transactional
    def save(TrnsltCommodityClassCode trnsltCommodityClassCodeInstance) {
        if (trnsltCommodityClassCodeInstance == null) {
            notFound()
            return
        }

        if (trnsltCommodityClassCodeInstance.hasErrors()) {
            respond trnsltCommodityClassCodeInstance.errors, view:'create'
            return
        }

        trnsltCommodityClassCodeInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'trnsltCommodityClassCode.label', default: 'TrnsltCommodityClassCode'), trnsltCommodityClassCodeInstance.id])
                redirect trnsltCommodityClassCodeInstance
            }
            '*' { respond trnsltCommodityClassCodeInstance, [status: CREATED] }
        }
    }

    def edit(TrnsltCommodityClassCode trnsltCommodityClassCodeInstance) {
        respond trnsltCommodityClassCodeInstance
    }

    @Transactional
    def update(TrnsltCommodityClassCode trnsltCommodityClassCodeInstance) {
        if (trnsltCommodityClassCodeInstance == null) {
            notFound()
            return
        }

        if (trnsltCommodityClassCodeInstance.hasErrors()) {
            respond trnsltCommodityClassCodeInstance.errors, view:'edit'
            return
        }

        trnsltCommodityClassCodeInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'TrnsltCommodityClassCode.label', default: 'TrnsltCommodityClassCode'), trnsltCommodityClassCodeInstance.id])
                redirect trnsltCommodityClassCodeInstance
            }
            '*'{ respond trnsltCommodityClassCodeInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(TrnsltCommodityClassCode trnsltCommodityClassCodeInstance) {

        if (trnsltCommodityClassCodeInstance == null) {
            notFound()
            return
        }

        trnsltCommodityClassCodeInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'TrnsltCommodityClassCode.label', default: 'TrnsltCommodityClassCode'), trnsltCommodityClassCodeInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'trnsltCommodityClassCode.label', default: 'TrnsltCommodityClassCode'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
   int Count(){
        return TrnsltEpptBotanicalName.Count();
    }
}
