class UrlMappings {

    static mappings = {
        "/login/$action?"(controller: "login")
        "/logout/$action?"(controller: "logout")
       //"/"(controller:"main")
        "/$controller/$action?/$id?"{
            constraints {
                // apply constraints here
            }
        } 
 
        "/"(view:"/login/auth")
        "500"(view:'/error') 
    }	
   
}

class IndexController {
    def index() {  // index is the default action for any controller
        //[EcertificateHistoryController] // the model available to the view
        [TrnsltEpptBotanicalNameController]
        [TrnsltUnLocodeController]
        [TrnsltPackageTypeCodeController]
        [TrnsltCountryIsoCodeController]
        [TrnsltCommodityClassCodeController]
        [TrnsltDocumentTypeController]
        [TrnsltMeasurementCommonCodeController]
        [TrnsltRecipientSpsPartyController]
        [TrnsltTransportmodeCode]
        [ECertDetailsController]
        [UserController]
        [ECertStatusHistoryController]
        // [EcertAuthorisationController]
    }
}

