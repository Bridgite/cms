<meta name="layout"  content="login"/>
<div class="col-md-4 col-md-offset-4">
                <div class="login-panel panel panel-default">
                    <div class="panel-heading">
                             
                        <h3 class="panel-title">&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;KEPHIS CMS Create account</h3>
                    </div>
                    <div class="login s2ui_center ui-corner-all control-group" style='text-align:center;'>
                    
                                 
                                          
		<s2ui:formContainer type='register' focus='username'   role="form">
			<s2ui:form beanName='registerCommand'>
				<g:if test='${emailSent}'>
				<br/>
				<g:message code='spring.security.ui.register.sent'/>
				</g:if>
				<g:else>
				<br/>
				 
                                        <div class="form-group">
                                              <label> Username</label>
                                         
					<s2ui:textFieldRow class="form-control" name='username' size='40' />
					</div> 
                                         <div class="form-group">
                                              <label> E-mail</label>
                                         
                                        <s2ui:textFieldRow class="form-control"  name='email' size='40' />
                                        </div>
                                        <div class="form-group">
                                              <label> Password</label>
                                         
					<s2ui:passwordFieldRow class="form-control"  name='password' size='40' />
                                        </div>
                                        <div class="form-group">
                                              <label> Password (again)</label>
                                         
                                        <s2ui:passwordFieldRow class="form-control"  name='password2' size='40' />
                                        </div>
                                        <div class="form-group">
				<g:submitButton  name="submit" value='Create your account' class="btn btn-lg btn-success btn-block"/>
				</div>
                                        </g:else>
			</s2ui:form>
		</s2ui:formContainer>
	 
        </div></div>        </div>   