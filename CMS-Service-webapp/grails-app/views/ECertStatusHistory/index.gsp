

<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'ECertStatusHistory.label', default: 'ECertStatusHistory')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-ECertStatusHistory" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-ECertStatusHistory" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
			<thead>
					<tr>
					
						<g:sortableColumn property="certStatus" title="${message(code: 'ECertStatusHistory.certStatus.label', default: 'Cert Status')}" />
					
						<g:sortableColumn property="statusDate" title="${message(code: 'ECertStatusHistory.statusDate.label', default: 'Status Date')}" />
					
						<g:sortableColumn property="reason" title="${message(code: 'ECertStatusHistory.reason.label', default: 'Reason')}" />
					
						<th><g:message code="ECertStatusHistory.ECertDetails.label" default="EC ert Details" /></th>
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${ECertStatusHistoryInstanceList}" status="i" var="ECertStatusHistoryInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${ECertStatusHistoryInstance.id}">${fieldValue(bean: ECertStatusHistoryInstance, field: "certStatus")}</g:link></td>
					
						<td><g:formatDate date="${ECertStatusHistoryInstance.statusDate}" /></td>
					
						<td>${fieldValue(bean: ECertStatusHistoryInstance, field: "reason")}</td>
					
						<td>${fieldValue(bean: ECertStatusHistoryInstance, field: "ECertDetails")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${ECertStatusHistoryInstanceCount ?: 0}" />
			</div>
		</div>
	</body>
</html>
