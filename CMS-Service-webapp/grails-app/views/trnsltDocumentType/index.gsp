

<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'trnsltDocumentType.label', default: 'TrnsltDocumentType')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-trnsltDocumentType" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-trnsltDocumentType" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
			<thead>
					<tr>
					
						<g:sortableColumn property="codeList" title="${message(code: 'trnsltDocumentType.codeList.label', default: 'Code List')}" />
					
						<g:sortableColumn property="ecsName" title="${message(code: 'trnsltDocumentType.ecsName.label', default: 'Ecs Name')}" />
					
						<g:sortableColumn property="code" title="${message(code: 'trnsltDocumentType.code.label', default: 'Code')}" />
					
						<g:sortableColumn property="name" title="${message(code: 'trnsltDocumentType.name.label', default: 'Name')}" />
					
						<g:sortableColumn property="description" title="${message(code: 'trnsltDocumentType.description.label', default: 'Description')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${trnsltDocumentTypeInstanceList}" status="i" var="trnsltDocumentTypeInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${trnsltDocumentTypeInstance.id}">${fieldValue(bean: trnsltDocumentTypeInstance, field: "codeList")}</g:link></td>
					
						<td>${fieldValue(bean: trnsltDocumentTypeInstance, field: "ecsName")}</td>
					
						<td>${fieldValue(bean: trnsltDocumentTypeInstance, field: "code")}</td>
					
						<td>${fieldValue(bean: trnsltDocumentTypeInstance, field: "name")}</td>
					
						<td>${fieldValue(bean: trnsltDocumentTypeInstance, field: "description")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${trnsltDocumentTypeInstanceCount ?: 0}" />
			</div>
		</div>
	</body>
</html>
