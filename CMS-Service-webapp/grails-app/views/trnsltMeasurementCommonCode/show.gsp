

<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'trnsltMeasurementCommonCode.label', default: 'TrnsltMeasurementCommonCode')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<div class="row">
            <div class="col-lg-12">
                <h1 class="page-header">Edit measurement common code translation </h1>


                <g:link class="list" action="index"><input type="button" value=" Measurement common code translation table" class="btn btn-success" /></g:link>
                <g:link class="create" action="create"><input type="button" value="Create  measurement common code translation " class="btn btn-success" /></g:link>


                <br> <br> 
            </div>
            <div class="col-lg-12">
                <div class="panel panel-default">
                    <div class="panel-heading">
                       Edit measurement common code translation
                    </div>
                    <br> 
<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list trnsltMeasurementCommonCode">
			
				<g:if test="${trnsltMeasurementCommonCodeInstance?.trnsltMeasurementCommonCodeId}">
				<li class="fieldcontain">
					<span id="trnsltMeasurementCommonCodeId-label" class="property-label"><g:message code="trnsltMeasurementCommonCode.trnsltMeasurementCommonCodeId.label" default="Trnslt Measurement Common Code Id" /></span>
					
						<span class="property-value" aria-labelledby="trnsltMeasurementCommonCodeId-label"><g:fieldValue bean="${trnsltMeasurementCommonCodeInstance}" field="trnsltMeasurementCommonCodeId"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${trnsltMeasurementCommonCodeInstance?.codeList}">
				<li class="fieldcontain">
					<span id="codeList-label" class="property-label"><g:message code="trnsltMeasurementCommonCode.codeList.label" default="Code List" /></span>
					
						<span class="property-value" aria-labelledby="codeList-label"><g:fieldValue bean="${trnsltMeasurementCommonCodeInstance}" field="codeList"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${trnsltMeasurementCommonCodeInstance?.ecsName}">
				<li class="fieldcontain">
					<span id="ecsName-label" class="property-label"><g:message code="trnsltMeasurementCommonCode.ecsName.label" default="Ecs Name" /></span>
					
						<span class="property-value" aria-labelledby="ecsName-label"><g:fieldValue bean="${trnsltMeasurementCommonCodeInstance}" field="ecsName"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${trnsltMeasurementCommonCodeInstance?.code}">
				<li class="fieldcontain">
					<span id="code-label" class="property-label"><g:message code="trnsltMeasurementCommonCode.code.label" default="Code" /></span>
					
						<span class="property-value" aria-labelledby="code-label"><g:fieldValue bean="${trnsltMeasurementCommonCodeInstance}" field="code"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${trnsltMeasurementCommonCodeInstance?.name}">
				<li class="fieldcontain">
					<span id="name-label" class="property-label"><g:message code="trnsltMeasurementCommonCode.name.label" default="Name" /></span>
					
						<span class="property-value" aria-labelledby="name-label"><g:fieldValue bean="${trnsltMeasurementCommonCodeInstance}" field="name"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${trnsltMeasurementCommonCodeInstance?.description}">
				<li class="fieldcontain">
					<span id="description-label" class="property-label"><g:message code="trnsltMeasurementCommonCode.description.label" default="Description" /></span>
					
						<span class="property-value" aria-labelledby="description-label"><g:fieldValue bean="${trnsltMeasurementCommonCodeInstance}" field="description"/></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form url="[resource:trnsltMeasurementCommonCodeInstance, action:'delete']" method="DELETE">
			<fieldset class="buttons">
					 <p align="justify"> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <g:link class="edit" action="edit" resource="${trnsltMeasurementCommonCodeInstance}"><input type="button" value="Edit" class="btn btn-success" /></g:link>
					<g:actionSubmit class="delete btn btn-success" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
                                         </p>
                                </fieldset>
			</g:form>
		</div>
            </div>
                </div>
	</body>
</html>
