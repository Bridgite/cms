

<!doctype html>
<html>
	<head>
		<meta name="layout" content="bootstrap">
		<g:set var="entityName" value="${message(code: 'trnsltDocumentType.label', default: 'TrnsltDocumentType')}" />
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
						
							<g:sortableColumn property="codeList" title="${message(code: 'trnsltDocumentType.codeList.label', default: 'Code List')}" />
						
							<g:sortableColumn property="ecsName" title="${message(code: 'trnsltDocumentType.ecsName.label', default: 'Ecs Name')}" />
						
							<g:sortableColumn property="code" title="${message(code: 'trnsltDocumentType.code.label', default: 'Code')}" />
						
							<g:sortableColumn property="name" title="${message(code: 'trnsltDocumentType.name.label', default: 'Name')}" />
						
							<g:sortableColumn property="description" title="${message(code: 'trnsltDocumentType.description.label', default: 'Description')}" />
						
							<th></th>
						</tr>
					</thead>
					<tbody>
					<g:each in="${trnsltDocumentTypeInstanceList}" var="trnsltDocumentTypeInstance">
						<tr>
						
							<td>${fieldValue(bean: trnsltDocumentTypeInstance, field: "codeList")}</td>
						
							<td>${fieldValue(bean: trnsltDocumentTypeInstance, field: "ecsName")}</td>
						
							<td>${fieldValue(bean: trnsltDocumentTypeInstance, field: "code")}</td>
						
							<td>${fieldValue(bean: trnsltDocumentTypeInstance, field: "name")}</td>
						
							<td>${fieldValue(bean: trnsltDocumentTypeInstance, field: "description")}</td>
						
							<td class="link">
								<g:link action="show" id="${trnsltDocumentTypeInstance.id}" class="btn btn-small">Show &raquo;</g:link>
							</td>
						</tr>
					</g:each>
					</tbody>
				</table>
				<div class="pagination">
					<bootstrap:paginate total="${trnsltDocumentTypeInstanceTotal}" />
				</div>
			</div>

		</div>
	</body>
</html>
