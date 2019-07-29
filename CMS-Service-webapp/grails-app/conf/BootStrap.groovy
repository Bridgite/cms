

class BootStrap {

    def init = { servletContext -> 
        
        User kephisadmin = User.findByUsername('kephisadmin') ?:new User(username:'kephisadmin',countrycode:'KE', password:'admin!@#123',email:'kephisadmin@kephis.org', enabled:true).save(failOnError: true)
        User ukuser = User.findByUsername('ukecscmsuser') ?:new User(username:'ukecscmsuser',countrycode:'GB',  password:'UKcmsWebUser1',email:'ukecscmsuser@kephis.org', enabled:true).save(failOnError: true)
        User nluser = User.findByUsername('cmsuser1') ?:new User(username:'cmsuser1',countrycode:'NL',  password:'cmsuser1',email:'cmsuser1@kephis.org', enabled:true).save(failOnError: true)
        User auuser = User.findByUsername('aucmsuser') ?:new User(username:'aucmsuser',countrycode:'AU',  password:'aucmsuser',email:'aucmsuser@kephis.org', enabled:true).save(failOnError: true)
        Role webserviceuser = Role.findByAuthority('ROLE_WEB_SERVICE_USER') ?: new Role(authority: 'ROLE_WEB_SERVICE_USER').save(failOnError: true)
        Role webuser = Role.findByAuthority('ROLE_WEB_USER') ?:new Role(authority: 'ROLE_WEB_USER').save(failOnError: true)
        Role adminwebuser = Role.findByAuthority('ROLE_ADMIN_WEB_USER') ?:new Role(authority: 'ROLE_ADMIN_WEB_USER').save(failOnError: true)
        Role superuser = Role.findByAuthority('ROLE_SUPER_ADMIN_USER') ?:new Role(authority: 'ROLE_SUPER_ADMIN_USER').save(failOnError: true)
        UserRole.create(kephisadmin, superuser)
        UserRole.create(nluser, webuser)
        UserRole.create(ukuser, webuser)
        UserRole.create(auuser, webuser)
        
        for (String url in [
         '/', '/index', '/index.gsp', '/**/favicon.ico',
         '/assets/**', '/**/js/**', '/**/css/**', '/**/images/**',
         '/login', '/login.*', '/login/*',
         '/logout', '/logout.*', '/logout/*','/register/*']) {
            new Requestmap(url: url, configAttribute: 'permitAll').save()
        }
        
        new Requestmap(url: '/assets/**', configAttribute: 'IS_AUTHENTICATED_ANONYMOUSLY').save()
        new Requestmap(url: '/cms_ui_theme/**', configAttribute: 'IS_AUTHENTICATED_ANONYMOUSLY').save() 
        new Requestmap(url: '/login/**', configAttribute: 'IS_AUTHENTICATED_ANONYMOUSLY').save()
      
       
        
        new Requestmap(url: '/**', configAttribute: 'ROLE_WEB_USER,ROLE_ADMIN_WEB_USER,ROLE_SUPER_ADMIN_USER').save()
        new Requestmap(url: '/main/**', configAttribute: 'ROLE_WEB_USER,ROLE_ADMIN_WEB_USER,ROLE_SUPER_ADMIN_USER').save()
        new Requestmap(url: '/main/home', configAttribute: 'ROLE_WEB_USER,ROLE_ADMIN_WEB_USER,ROLE_SUPER_ADMIN_USER').save()
 
        
        new Requestmap(url: '/loginout/**', configAttribute: 'IS_AUTHENTICATED_FULLY').save() 
        
        new Requestmap(url: '/loginout/**', configAttribute: 'IS_AUTHENTICATED_REMEMBERED').save()
      
    }
    def destroy = {
    }
    
}
