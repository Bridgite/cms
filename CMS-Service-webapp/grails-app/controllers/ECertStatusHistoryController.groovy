import org.springframework.dao.DataIntegrityViolationException

class ECertStatusHistoryController {

    static allowedMethods = [create: ['GET', 'POST'], edit: ['GET', 'POST'], delete: 'POST']

    def index() {
        redirect action: 'list', params: params
    }

    def list() {
        params.max = Math.min(params.max ? params.int('max') : 10, 100)
        [ECertStatusHistoryInstanceList: ECertStatusHistory.list(params), ECertStatusHistoryInstanceTotal: ECertStatusHistory.count()]
    }

    def create() {
		switch (request.method) {
		case 'GET':
        	[ECertStatusHistoryInstance: new ECertStatusHistory(params)]
              
                //[ECertDetailsInstance: new ECertDetailsInstance(params)]
			break
		case 'POST':
                     // println "The params ${}"
                       def ECertDetailsInstance = ECertDetails.get(params.ECertDetails.id)
                 
	        def ECertStatusHistoryInstance = new ECertStatusHistory(params)
                ECertDetailsInstance.addToECertStatusHistories(ECertStatusHistoryInstance)
                ECertDetailsInstance.save();
	        if (!ECertStatusHistoryInstance.save(flush: true)) {
	            render view: 'create', model: [ECertStatusHistoryInstance: ECertStatusHistoryInstance]
	            return
	        }

		flash.message = message(code: 'default.created.message', args: [message(code: 'ECertStatusHistory.label', default: 'ECertStatusHistory'), ECertStatusHistoryInstance.id])
	        redirect action: 'show', id: ECertStatusHistoryInstance.id
			break
		}
    }

    def show() {
        def ECertStatusHistoryInstance = ECertStatusHistory.get(params.id)
        if (!ECertStatusHistoryInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'ECertStatusHistory.label', default: 'ECertStatusHistory'), params.id])
            redirect action: 'list'
            return
        }

        [ECertStatusHistoryInstance: ECertStatusHistoryInstance]
    }

    def edit() {
		switch (request.method) {
		case 'GET':
	        def ECertStatusHistoryInstance = ECertStatusHistory.get(params.id)
	        if (!ECertStatusHistoryInstance) {
	            flash.message = message(code: 'default.not.found.message', args: [message(code: 'ECertStatusHistory.label', default: 'ECertStatusHistory'), params.id])
	            redirect action: 'list'
	            return
	        }

	        [ECertStatusHistoryInstance: ECertStatusHistoryInstance]
			break
		case 'POST':
	        def ECertStatusHistoryInstance = ECertStatusHistory.get(params.id)
	        if (!ECertStatusHistoryInstance) {
	            flash.message = message(code: 'default.not.found.message', args: [message(code: 'ECertStatusHistory.label', default: 'ECertStatusHistory'), params.id])
	            redirect action: 'list'
	            return
	        }

	        if (params.version) {
	            def version = params.version.toLong()
	            if (ECertStatusHistoryInstance.version > version) {
	                ECertStatusHistoryInstance.errors.rejectValue('version', 'default.optimistic.locking.failure',
	                          [message(code: 'ECertStatusHistory.label', default: 'ECertStatusHistory')] as Object[],
	                          "Another user has updated this ECertStatusHistory while you were editing")
	                render view: 'edit', model: [ECertStatusHistoryInstance: ECertStatusHistoryInstance]
	                return
	            }
	        }

	        ECertStatusHistoryInstance.properties = params

	        if (!ECertStatusHistoryInstance.save(flush: true)) {
	            render view: 'edit', model: [ECertStatusHistoryInstance: ECertStatusHistoryInstance]
	            return
	        }

			flash.message = message(code: 'default.updated.message', args: [message(code: 'ECertStatusHistory.label', default: 'ECertStatusHistory'), ECertStatusHistoryInstance.id])
	        redirect action: 'show', id: ECertStatusHistoryInstance.id
			break
		}
    }

    def delete() {
        def ECertStatusHistoryInstance = ECertStatusHistory.get(params.id)
        if (!ECertStatusHistoryInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'ECertStatusHistory.label', default: 'ECertStatusHistory'), params.id])
            redirect action: 'list'
            return
        }

        try {
            ECertStatusHistoryInstance.delete(flush: true)
			flash.message = message(code: 'default.deleted.message', args: [message(code: 'ECertStatusHistory.label', default: 'ECertStatusHistory'), params.id])
            redirect action: 'list'
        }
        catch (DataIntegrityViolationException e) {
			flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'ECertStatusHistory.label', default: 'ECertStatusHistory'), params.id])
            redirect action: 'show', id: params.id
        }
    }
}
