

<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'ECertStatusHistory.label', default: 'ECertStatusHistory')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<div class="row-fluid">
			
			<div class="span3">
				<div class="well">
					<ul class="nav nav-list">
						<li class="nav-header">${entityName}</li>
						<li class="active">
							<g:link class="list" action="list">
								<i class="icon-list icon-white"></i>
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
					<h1><g:message code="default.list.label" args="[entityName]" /></h1>
				</div>

				<g:if test="${flash.message}">
				<bootstrap:alert class="alert-info">${flash.message}</bootstrap:alert>
				</g:if>
				
				<table class="table table-striped">
					<thead>
						<tr>
						
							<g:sortableColumn property="certStatus" title="${message(code: 'ECertStatusHistory.certStatus.label', default: 'Cert Status')}" />
						
							<g:sortableColumn property="statusDate" title="${message(code: 'ECertStatusHistory.statusDate.label', default: 'Status Date')}" />
						
							<g:sortableColumn property="reason" title="${message(code: 'ECertStatusHistory.reason.label', default: 'Reason')}" />
						
							<th class="header"><g:message code="ECertStatusHistory.ECertDetails.label" default="EC ert Details" /></th>
						
							<th></th>
						</tr>
					</thead>
					<tbody>
					<g:each in="${ECertStatusHistoryInstanceList}" var="ECertStatusHistoryInstance">
						<tr>
						
							<td>${fieldValue(bean: ECertStatusHistoryInstance, field: "certStatus")}</td>
						
							<td><g:formatDate date="${ECertStatusHistoryInstance.statusDate}" /></td>
						
							<td>${fieldValue(bean: ECertStatusHistoryInstance, field: "reason")}</td>
						
							<td>${fieldValue(bean: ECertStatusHistoryInstance, field: "ECertDetails.certNo")}</td>
						
							<td class="link">
								<g:link action="show" id="${ECertStatusHistoryInstance.id}" class="btn btn-small">Show &raquo;</g:link>
							</td>
						</tr>
					</g:each>
					</tbody>
				</table>
				<div class="pagination">
					<bootstrap:paginate total="${ECertStatusHistoryInstanceTotal}" />
				</div>
			</div>

		</div>
	</body>
</html>
