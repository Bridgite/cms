<meta name="layout" content="login" />
  <div class="row">
            <div class="col-md-4 col-md-offset-4">
                <div class="login-panel panel panel-default">
                    <div class="panel-heading">
                             
                        <h3 class="panel-title">&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;KEPHIS CMS Reset password</h3>
                    </div>
                    <div class="login s2ui_center ui-corner-all control-group" style='text-align:center;'>
		
		<s2ui:formContainer type='forgotPassword' focus='username' role="form">
			<s2ui:form beanName='forgotPasswordCommand'>
				<g:if test='${emailSent}'>
				
				<g:message code='spring.security.ui.forgotPassword.sent'/>
				</g:if>
				<g:else>
				<br/> 
                                  <div class="form-group">
				  <p class="help-block"> <g:message code='spring.security.ui.forgotPassword.description'/></p>
				  	<s2ui:textFieldRow name='username' size='25' class="form-control" placeholder="User name" />
				</div>
				 
				<div class="form-group">	
                                        <g:submitButton name="submit" value='Reset password' class="btn btn-lg btn-success btn-block"/>
                                            </div>
                                </g:else>
                                
			</s2ui:form>
                </s2ui:formContainer></div>
</div>
</div>
</div>