

<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'trnsltTransportmodeCode.label', default: 'TrnsltTransportmodeCode')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
				<div class="row">
            <div class="col-lg-12">
                <h1 class="page-header">Edit transport mode code translation </h1>


                <g:link class="list" action="index"><input type="button" value="Transport mode code translation table" class="btn btn-success" /></g:link>
                <g:link class="create" action="create"><input type="button" value="Create transport mode code translation " class="btn btn-success" /></g:link>


                <br> <br> 
            </div>
            <div class="col-lg-12">
                <div class="panel panel-default">
                    <div class="panel-heading">
                       Edit transport mode code translation
                    </div>
                    <br> <g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list trnsltTransportmodeCode">
			
				<g:if test="${trnsltTransportmodeCodeInstance?.trnsltTransportmodeCodeId}">
				<li class="fieldcontain">
					<span id="trnsltTransportmodeCodeId-label" class="property-label"><g:message code="trnsltTransportmodeCode.trnsltTransportmodeCodeId.label" default="Trnslt Transportmode Code Id" /></span>
					
						<span class="property-value" aria-labelledby="trnsltTransportmodeCodeId-label"><g:fieldValue bean="${trnsltTransportmodeCodeInstance}" field="trnsltTransportmodeCodeId"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${trnsltTransportmodeCodeInstance?.codeList}">
				<li class="fieldcontain">
					<span id="codeList-label" class="property-label"><g:message code="trnsltTransportmodeCode.codeList.label" default="Code List" /></span>
					
						<span class="property-value" aria-labelledby="codeList-label"><g:fieldValue bean="${trnsltTransportmodeCodeInstance}" field="codeList"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${trnsltTransportmodeCodeInstance?.ecsName}">
				<li class="fieldcontain">
					<span id="ecsName-label" class="property-label"><g:message code="trnsltTransportmodeCode.ecsName.label" default="Ecs Name" /></span>
					
						<span class="property-value" aria-labelledby="ecsName-label"><g:fieldValue bean="${trnsltTransportmodeCodeInstance}" field="ecsName"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${trnsltTransportmodeCodeInstance?.code}">
				<li class="fieldcontain">
					<span id="code-label" class="property-label"><g:message code="trnsltTransportmodeCode.code.label" default="Code" /></span>
					
						<span class="property-value" aria-labelledby="code-label"><g:fieldValue bean="${trnsltTransportmodeCodeInstance}" field="code"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${trnsltTransportmodeCodeInstance?.name}">
				<li class="fieldcontain">
					<span id="name-label" class="property-label"><g:message code="trnsltTransportmodeCode.name.label" default="Name" /></span>
					
						<span class="property-value" aria-labelledby="name-label"><g:fieldValue bean="${trnsltTransportmodeCodeInstance}" field="name"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${trnsltTransportmodeCodeInstance?.description}">
				<li class="fieldcontain">
					<span id="description-label" class="property-label"><g:message code="trnsltTransportmodeCode.description.label" default="Description" /></span>
					
						<span class="property-value" aria-labelledby="description-label"><g:fieldValue bean="${trnsltTransportmodeCodeInstance}" field="description"/></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form url="[resource:trnsltTransportmodeCodeInstance, action:'delete']" method="DELETE">
				 	<fieldset class="buttons">
					 <p align="justify"> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <g:link class="edit" action="edit" resource="${trnsltTransportmodeCodeInstance}"><input type="button" value="Edit" class="btn btn-success" /></g:link>
					<g:actionSubmit class="delete btn btn-success" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
                                         </p>
                                </fieldset>
			</g:form>
		</div>
            </div></div>
	</body>
</html>
