<meta name="layout" content="login" />
    
      
        <div class="row">
            <div class="col-md-4 col-md-offset-4">
                <div class="login-panel panel panel-default">
                    <div class="panel-heading">
                             
                        <h3 class="panel-title">&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;KEPHIS CMS SIGN IN</h3>
                    </div>
                    <table><tr>
    <td>
                     <div class="panel-body">
                    <img src="${resource(dir:'images',file:'kephis_logo.png')}" alt="login" title="login" class="alignleft size-full wp-image-26" height="50" width="50">
                      <br>  <br>  <br>  <br> 
                     </div>  
                    <div class="panel-body">
                       </td><td> 
<!-- END #login -->
    
                    <br>
                        <g:form  controller="Main"action="login">
                    
                           <fieldset>
                                 <g:if test="${flash.message}">
          <div class="message">${flash.message}</div>
      </g:if>
                                <div class="form-group">
                                    <g:textField name="username" class="form-control" placeholder="user name" />
                                </div>
                                <div class="form-group">
                                   <g:passwordField name="password"  class="form-control" placeholder="Password" />
                                </div>
                                <div class="checkbox">
                                    <label>
                                        <input name="remember" type="checkbox" value="Remember Me">Remember Me
                                    </label>
                                </div>
                                <!-- Change this to a button or input when using this as a form -->
                                         <g:submitButton class="btn btn-lg btn-success btn-block" name="submitButton" value="Login" />
                               <br/>
                           
                            </fieldset>
                        </g:form>
                                </div></td></tr>
    </table>
                </div>
            </div>
        </div>
