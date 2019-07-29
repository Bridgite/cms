import org.springframework.dao.DataIntegrityViolationException

class TrnsltDocumentTypeController {

    static allowedMethods = [create: ['GET', 'POST'], edit: ['GET', 'POST'], delete: 'POST']

    def index() {
        redirect action: 'list', params: params
    }

    def list() {
        params.max = Math.min(params.max ? params.int('max') : 10, 100)
        [trnsltDocumentTypeInstanceList: TrnsltDocumentType.list(params), trnsltDocumentTypeInstanceTotal: TrnsltDocumentType.count()]
    }

    def create() {
		switch (request.method) {
		case 'GET':
        	[trnsltDocumentTypeInstance: new TrnsltDocumentType(params)]
			break
		case 'POST':
	        def trnsltDocumentTypeInstance = new TrnsltDocumentType(params)
	        if (!trnsltDocumentTypeInstance.save(flush: true)) {
	            render view: 'create', model: [trnsltDocumentTypeInstance: trnsltDocumentTypeInstance]
	            return
	        }

			flash.message = message(code: 'default.created.message', args: [message(code: 'trnsltDocumentType.label', default: 'TrnsltDocumentType'), trnsltDocumentTypeInstance.id])
	        redirect action: 'show', id: trnsltDocumentTypeInstance.id
			break
		}
    }

    def show() {
        def trnsltDocumentTypeInstance = TrnsltDocumentType.get(params.id)
        if (!trnsltDocumentTypeInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'trnsltDocumentType.label', default: 'TrnsltDocumentType'), params.id])
            redirect action: 'list'
            return
        }

        [trnsltDocumentTypeInstance: trnsltDocumentTypeInstance]
    }

    def edit() {
		switch (request.method) {
		case 'GET':
	        def trnsltDocumentTypeInstance = TrnsltDocumentType.get(params.id)
	        if (!trnsltDocumentTypeInstance) {
	            flash.message = message(code: 'default.not.found.message', args: [message(code: 'trnsltDocumentType.label', default: 'TrnsltDocumentType'), params.id])
	            redirect action: 'list'
	            return
	        }

	        [trnsltDocumentTypeInstance: trnsltDocumentTypeInstance]
			break
		case 'POST':
	        def trnsltDocumentTypeInstance = TrnsltDocumentType.get(params.id)
	        if (!trnsltDocumentTypeInstance) {
	            flash.message = message(code: 'default.not.found.message', args: [message(code: 'trnsltDocumentType.label', default: 'TrnsltDocumentType'), params.id])
	            redirect action: 'list'
	            return
	        }

	        if (params.version) {
	            def version = params.version.toLong()
	            if (trnsltDocumentTypeInstance.version > version) {
	                trnsltDocumentTypeInstance.errors.rejectValue('version', 'default.optimistic.locking.failure',
	                          [message(code: 'trnsltDocumentType.label', default: 'TrnsltDocumentType')] as Object[],
	                          "Another user has updated this TrnsltDocumentType while you were editing")
	                render view: 'edit', model: [trnsltDocumentTypeInstance: trnsltDocumentTypeInstance]
	                return
	            }
	        }

	        trnsltDocumentTypeInstance.properties = params

	        if (!trnsltDocumentTypeInstance.save(flush: true)) {
	            render view: 'edit', model: [trnsltDocumentTypeInstance: trnsltDocumentTypeInstance]
	            return
	        }

			flash.message = message(code: 'default.updated.message', args: [message(code: 'trnsltDocumentType.label', default: 'TrnsltDocumentType'), trnsltDocumentTypeInstance.id])
	        redirect action: 'show', id: trnsltDocumentTypeInstance.id
			break
		}
    }

    def delete() {
        def trnsltDocumentTypeInstance = TrnsltDocumentType.get(params.id)
        if (!trnsltDocumentTypeInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'trnsltDocumentType.label', default: 'TrnsltDocumentType'), params.id])
            redirect action: 'list'
            return
        }

        try {
            trnsltDocumentTypeInstance.delete(flush: true)
			flash.message = message(code: 'default.deleted.message', args: [message(code: 'trnsltDocumentType.label', default: 'TrnsltDocumentType'), params.id])
            redirect action: 'list'
        }
        catch (DataIntegrityViolationException e) {
			flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'trnsltDocumentType.label', default: 'TrnsltDocumentType'), params.id])
            redirect action: 'show', id: params.id
        }
    }
}
