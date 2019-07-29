

<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'trnsltPackageTypeCode.label', default: 'TrnsltPackageTypeCode')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body><div class="row">
            <div class="col-lg-12">
                <h1 class="page-header">Edit package type translation </h1>


                <g:link class="list" action="index"><input type="button" value="Package type  translation table" class="btn btn-success" /></g:link>
                <g:link class="create" action="create"><input type="button" value="Create package type  translation " class="btn btn-success" /></g:link>


                <br> <br> 
            </div>
            <div class="col-lg-12">
                <div class="panel panel-default">
                    <div class="panel-heading">
                       Edit package type translation
                    </div>
                    <br> 
<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list trnsltPackageTypeCode">
			
				<g:if test="${trnsltPackageTypeCodeInstance?.trnsltPackageTypeCodeId}">
				<li class="fieldcontain">
					<span id="trnsltPackageTypeCodeId-label" class="property-label"><g:message code="trnsltPackageTypeCode.trnsltPackageTypeCodeId.label" default="Trnslt Package Type Code Id" /></span>
					
						<span class="property-value" aria-labelledby="trnsltPackageTypeCodeId-label"><g:fieldValue bean="${trnsltPackageTypeCodeInstance}" field="trnsltPackageTypeCodeId"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${trnsltPackageTypeCodeInstance?.codeList}">
				<li class="fieldcontain">
					<span id="codeList-label" class="property-label"><g:message code="trnsltPackageTypeCode.codeList.label" default="Code List" /></span>
					
						<span class="property-value" aria-labelledby="codeList-label"><g:fieldValue bean="${trnsltPackageTypeCodeInstance}" field="codeList"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${trnsltPackageTypeCodeInstance?.ecsName}">
				<li class="fieldcontain">
					<span id="ecsName-label" class="property-label"><g:message code="trnsltPackageTypeCode.ecsName.label" default="Ecs Name" /></span>
					
						<span class="property-value" aria-labelledby="ecsName-label"><g:fieldValue bean="${trnsltPackageTypeCodeInstance}" field="ecsName"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${trnsltPackageTypeCodeInstance?.code}">
				<li class="fieldcontain">
					<span id="code-label" class="property-label"><g:message code="trnsltPackageTypeCode.code.label" default="Code" /></span>
					
						<span class="property-value" aria-labelledby="code-label"><g:fieldValue bean="${trnsltPackageTypeCodeInstance}" field="code"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${trnsltPackageTypeCodeInstance?.name}">
				<li class="fieldcontain">
					<span id="name-label" class="property-label"><g:message code="trnsltPackageTypeCode.name.label" default="Name" /></span>
					
						<span class="property-value" aria-labelledby="name-label"><g:fieldValue bean="${trnsltPackageTypeCodeInstance}" field="name"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${trnsltPackageTypeCodeInstance?.description}">
				<li class="fieldcontain">
					<span id="description-label" class="property-label"><g:message code="trnsltPackageTypeCode.description.label" default="Description" /></span>
					
						<span class="property-value" aria-labelledby="description-label"><g:fieldValue bean="${trnsltPackageTypeCodeInstance}" field="description"/></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form url="[resource:trnsltPackageTypeCodeInstance, action:'delete']" method="DELETE">
				<fieldset class="buttons">
					 <p align="justify"> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <g:link class="edit" action="edit" resource="${trnsltPackageTypeCodeInstance}"><input type="button" value="Edit" class="btn btn-success" /></g:link>
					<g:actionSubmit class="delete btn btn-success" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
                                         </p>
                                </fieldset>
			</g:form>
		</div>
            </div>
            </div>
	</body>
</html>
