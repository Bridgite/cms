<meta name="layout" content="login" />
      <div class="row">
            <div class="col-md-4 col-md-offset-4">
                <div class="login-panel panel panel-default">
                    <div class="panel-heading">
                             
                        <h3 class="panel-title">&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;KEPHIS CMS Sign In</h3>
                    </div>
                         <table><tr>
    <td><p><img src="${resource(dir:'images',file:'kephis_logo.png')}" alt="login" title="login" class="alignleft size-full wp-image-26" height="50" width="50"></p>
           
                      
                   
                    <div class="panel-body">
                       </td><td><br>  
                        <g:set var='securityConfig' value='${applicationContext.springSecurityService.securityConfig}'/>
 
		  <fieldset> 
		<div class="login s2ui_center ui-corner-all control-group" style='text-align:center;'>
			 
			<s2ui:form type='login' focus='username'>
			  
						 <div class="form-group"><input type="text" name="${securityConfig.apf.usernameParameter}" id="username"  placeholder="Username"  class="form-control" size="12"/>
					</div>
					<div class="form-group">
						 <input type="password" name="${securityConfig.apf.passwordParameter}" id="password" placeholder="Password"  class="form-control" size="12"/>
					</div>
				 
						<div class="checkbox">
                                                    <label for='remember_me'> 
                                                    <input type="checkbox" class="checkbox" name="${securityConfig.rememberMe.parameter}" id="remember_me" checked="checked"/>
						<g:message code='spring.security.ui.login.rememberme' /></label> </div>
                                                 <div class="form-group">	
                                        <g:submitButton name="loginButton" value="Login" class="btn btn-lg btn-success btn-block"/>
                                            </div>
                                                <div class="form-group">
                                                 <span class="forgot-link">
								<g:link controller='register' action='forgotPassword'><g:message code='spring.security.ui.login.forgotPassword'/></g:link>
							</span>
						</div>
					<div class="form-group"> 
							<s2ui:linkButton elementId='register' controller='register' messageCode='spring.security.ui.login.register'/>
                                        </div>
                                           
				 
				 
			</s2ui:form>
			 
		</div>
                  </fieldset> </td>
                   </div>
                   </tr>
    </table>
                </div>
            </div>
        </div>
   