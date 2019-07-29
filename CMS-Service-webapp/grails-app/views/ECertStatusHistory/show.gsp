

<!doctype html>
<html>
	<head>
		<meta name="layout" content="bootstrap">
		<g:set var="entityName" value="${message(code: 'ECertStatusHistory.label', default: 'ECertStatusHistory')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<div class="row-fluid">
			
			<div class="span3">
				<div class="well">
					<ul class="nav nav-list">
						<li class="nav-header">${entityName}</li>
						<li>
							<g:link class="list" action="list">
								<i class="icon-list"></i>
								<g:message code="default.list.label" args="[entityName]" />
							</g:link>
						</li>
						<li>
							<g:link class="create" action="create">
								<i class="icon-plus"></i>
								<g:message code="default.create.label" args="[entityName]" />
							</g:link>
						</li>
					</ul>
				</div>
			</div>
			
			<div class="span9">

				<div class="page-header">
					<h1><g:message code="default.show.label" args="[entityName]" /></h1>
				</div>

				<g:if test="${flash.message}">
				<bootstrap:alert class="alert-info">${flash.message}</bootstrap:alert>
				</g:if>

				<dl>
				
					<g:if test="${ECertStatusHistoryInstance?.certStatus}">
						<dt><g:message code="ECertStatusHistory.certStatus.label" default="Cert Status" /></dt>
						
							<dd><g:fieldValue bean="${ECertStatusHistoryInstance}" field="certStatus"/></dd>
						
					</g:if>
				
					<g:if test="${ECertStatusHistoryInstance?.statusDate}">
						<dt><g:message code="ECertStatusHistory.statusDate.label" default="Status Date" /></dt>
						
							<dd><g:formatDate date="${ECertStatusHistoryInstance?.statusDate}" /></dd>
						
					</g:if>
				
					<g:if test="${ECertStatusHistoryInstance?.reason}">
						<dt><g:message code="ECertStatusHistory.reason.label" default="Reason" /></dt>
						
							<dd><g:fieldValue bean="${ECertStatusHistoryInstance}" field="reason"/></dd>
						
					</g:if>
				
					<g:if test="${ECertStatusHistoryInstance?.ECertDetails}">
						<dt><g:message code="ECertStatusHistory.ECertDetails.label" default="EC ert Details" /></dt>
						
							<dd><g:link controller="ECertDetails" action="show" id="${ECertStatusHistoryInstance?.ECertDetails?.id}">${ECertStatusHistoryInstance?.ECertDetails?.encodeAsHTML()}</g:link></dd>
						
					</g:if>
				
				</dl>

				<g:form>
					<g:hiddenField name="id" value="${ECertStatusHistoryInstance?.id}" />
					<div class="form-actions">
						<g:link class="btn" action="edit" id="${ECertStatusHistoryInstance?.id}">
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
	</body>
</html>
