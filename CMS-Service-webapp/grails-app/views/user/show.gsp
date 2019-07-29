
 
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'user.label', default: 'User')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<div class="row">
			<div class="col-lg-12">  
					<h3 class="page-header">
						 User details </h3>
						 
						 

							<g:link class="create" action="create">
							 <input type="button" value="Create user " class="btn btn-success" /></g:link>
                                                                <g:link class="list" action="index"><input type="button" value="User listing" class="btn btn-success" /></g:link>
                       <br> <br>  </div>
                        <div class="col-lg-12"> 
                                                                <div class="panel panel-default">
                 <div class="panel-heading">
                        Username: [<i> <g:fieldValue bean="${userInstance}" field="username"/> </i>]  profile
                    </div>
                 <g:if test="${flash.message}">
				<bootstrap:alert class="alert-info">${flash.message}</bootstrap:alert>
				</g:if>

				<dl>
				
					<g:if test="${userInstance?.username}">
						<dt><g:message code="user.username.label" default="Username" /></dt>
						
							<dd><g:fieldValue bean="${userInstance}" field="username"/></dd>
						
					</g:if>
				
					<g:if test="${userInstance?.password}">
						<dt><g:message code="user.password.label" default="Password" /></dt>
						
							<dd><g:fieldValue bean="${userInstance}" field="password"/></dd>
						
					</g:if>
				
					<g:if test="${userInstance?.accountExpired}">
						<dt><g:message code="user.accountExpired.label" default="Account Expired" /></dt>
						
							<dd><g:formatBoolean boolean="${userInstance?.accountExpired}" /></dd>
						
					</g:if>
				
					<g:if test="${userInstance?.accountLocked}">
						<dt><g:message code="user.accountLocked.label" default="Account Locked" /></dt>
						
							<dd><g:formatBoolean boolean="${userInstance?.accountLocked}" /></dd>
						
					</g:if>
				
					<g:if test="${userInstance?.enabled}">
						<dt><g:message code="user.enabled.label" default="Enabled" /></dt>
						
							<dd><g:formatBoolean boolean="${userInstance?.enabled}" /></dd>
						
					</g:if>
				
					<g:if test="${userInstance?.passwordExpired}">
						<dt><g:message code="user.passwordExpired.label" default="Password Expired" /></dt>
						
							<dd><g:formatBoolean boolean="${userInstance?.passwordExpired}" /></dd>
						
					</g:if>
				
				</dl>

				<g:form>
					<g:hiddenField name="id" value="${userInstance?.id}" />
					<div class="form-actions">
						<g:link class="btn" action="edit" id="${userInstance?.id}">
							<i class="icon-pencil"></i>
							<g:message code="default.button.edit.label" default="Edit" />
						</g:link>
						<button class="btn btn-danger" type="submit" name="_action_delete">
							<i class="icon-trash icon-white"></i>
							<g:message code="default.button.delete.label" default="Delete" />
						</button>
					</div>
				</g:form>

			</div>
</div>
		</div>
	</body>
</html>
