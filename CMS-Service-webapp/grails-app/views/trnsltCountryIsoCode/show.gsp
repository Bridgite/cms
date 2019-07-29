

<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'trnsltCountryIsoCode.label', default: 'TrnsltCountryIsoCode')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body><div class="row">
            <div class="col-lg-12">
                <h1 class="page-header">Edit Country ISO translation </h1>


                <g:link class="list" action="index"><input type="button" value=" Country ISO code translation table" class="btn btn-success" /></g:link>
                <g:link class="create" action="create"><input type="button" value="Create country ISO code translation " class="btn btn-success" /></g:link>


                <br> <br> 
            </div>
            <div class="col-lg-12">
                <div class="panel panel-default">
                    <div class="panel-heading">
                       Edit country ISO code translation
                    </div>
                    <br> 
<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list trnsltCountryIsoCode">
			
				<g:if test="${trnsltCountryIsoCodeInstance?.trnsltCountryIsoCodeId}">
				<li class="fieldcontain">
					<span id="trnsltCountryIsoCodeId-label" class="property-label"><g:message code="trnsltCountryIsoCode.trnsltCountryIsoCodeId.label" default="Trnslt Country Iso Code Id" /></span>
					
						<span class="property-value" aria-labelledby="trnsltCountryIsoCodeId-label"><g:fieldValue bean="${trnsltCountryIsoCodeInstance}" field="trnsltCountryIsoCodeId"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${trnsltCountryIsoCodeInstance?.ecsName}">
				<li class="fieldcontain">
					<span id="ecsName-label" class="property-label"><g:message code="trnsltCountryIsoCode.ecsName.label" default="Ecs Name" /></span>
					
						<span class="property-value" aria-labelledby="ecsName-label"><g:fieldValue bean="${trnsltCountryIsoCodeInstance}" field="ecsName"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${trnsltCountryIsoCodeInstance?.isoCode}">
				<li class="fieldcontain">
					<span id="isoCode-label" class="property-label"><g:message code="trnsltCountryIsoCode.isoCode.label" default="Iso Code" /></span>
					
						<span class="property-value" aria-labelledby="isoCode-label"><g:fieldValue bean="${trnsltCountryIsoCodeInstance}" field="isoCode"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${trnsltCountryIsoCodeInstance?.description}">
				<li class="fieldcontain">
					<span id="description-label" class="property-label"><g:message code="trnsltCountryIsoCode.description.label" default="Description" /></span>
					
						<span class="property-value" aria-labelledby="description-label"><g:fieldValue bean="${trnsltCountryIsoCodeInstance}" field="description"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${trnsltCountryIsoCodeInstance?.primaryKeyColumn}">
				<li class="fieldcontain">
					<span id="primaryKeyColumn-label" class="property-label"><g:message code="trnsltCountryIsoCode.primaryKeyColumn.label" default="Primary Key Column" /></span>
					
						<span class="property-value" aria-labelledby="primaryKeyColumn-label"><g:fieldValue bean="${trnsltCountryIsoCodeInstance}" field="primaryKeyColumn"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${trnsltCountryIsoCodeInstance?.twoCharIsoCode}">
				<li class="fieldcontain">
					<span id="twoCharIsoCode-label" class="property-label"><g:message code="trnsltCountryIsoCode.twoCharIsoCode.label" default="Two Char Iso Code" /></span>
					
						<span class="property-value" aria-labelledby="twoCharIsoCode-label"><g:fieldValue bean="${trnsltCountryIsoCodeInstance}" field="twoCharIsoCode"/></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form url="[resource:trnsltCountryIsoCodeInstance, action:'delete']" method="DELETE">
				<fieldset class="buttons">
					 <p align="justify"> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <g:link class="edit" action="edit" resource="${trnsltCountryIsoCodeInstance}"><input type="button" value="Edit" class="btn btn-success" /></g:link>
					<g:actionSubmit class="delete btn btn-success" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
                                         </p>
                                </fieldset>
			</g:form>
		</div>
            </div>
            </div>
	</body>
</html>
