
import grails.plugin.springsecurity.annotation.Secured

class MainController { 
    def index() { }
    
   def home ={ 
      render(view: '/index')
    }
     def ephytolp() { } 
     
     def springSecurityService
 /**   
  def login ={
    if (params.username == "kephis" && params.password == "kephis"){
     
    session.user = "grailslover"
    }else{
    flash.message = "Login failed"
    redirect(action: 'index')
    }
      render(view: '/index')
    }
  
    def logout ={
        session.user = null
        redirect(action: 'index')
    }
   
  
   def logout ={
        session.user = null
        redirect(action: 'logout')
    }
    **/
}
