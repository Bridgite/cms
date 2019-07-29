

<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'trnsltUnLocode.label', default: 'TrnsltUnLocode')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body> <div class="row">
            <div class="col-lg-12">
                <h1 class="page-header"> UnLocode  </h1>


                <g:link class="list" action="index"><input type="button" value="UnLocode translation table" class="btn btn-success" /></g:link>
                <g:link class="create" action="create"><input type="button" value="Create UnLocode translation " class="btn btn-success" /></g:link>


                <br> <br> 
            </div>
            <div class="col-lg-12">
                <div class="panel panel-default">
                    <div class="panel-heading">
                     Edit UnLocode translation
                    </div>
                    <br> 
<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list trnsltUnLocode">
			
				<g:if test="${trnsltUnLocodeInstance?.trnsltUnLocodeId}">
				<li class="fieldcontain">
					<span id="trnsltUnLocodeId-label" class="property-label"><g:message code="trnsltUnLocode.trnsltUnLocodeId.label" default="Trnslt Un Locode Id" /></span>
					
						<span class="property-value" aria-labelledby="trnsltUnLocodeId-label"><g:fieldValue bean="${trnsltUnLocodeInstance}" field="trnsltUnLocodeId"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${trnsltUnLocodeInstance?.codeList}">
				<li class="fieldcontain">
					<span id="codeList-label" class="property-label"><g:message code="trnsltUnLocode.codeList.label" default="Code List" /></span>
					
						<span class="property-value" aria-labelledby="codeList-label"><g:fieldValue bean="${trnsltUnLocodeInstance}" field="codeList"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${trnsltUnLocodeInstance?.ecsName}">
				<li class="fieldcontain">
					<span id="ecsName-label" class="property-label"><g:message code="trnsltUnLocode.ecsName.label" default="Ecs Name" /></span>
					
						<span class="property-value" aria-labelledby="ecsName-label"><g:fieldValue bean="${trnsltUnLocodeInstance}" field="ecsName"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${trnsltUnLocodeInstance?.code}">
				<li class="fieldcontain">
					<span id="code-label" class="property-label"><g:message code="trnsltUnLocode.code.label" default="Code" /></span>
					
						<span class="property-value" aria-labelledby="code-label"><g:fieldValue bean="${trnsltUnLocodeInstance}" field="code"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${trnsltUnLocodeInstance?.iso}">
				<li class="fieldcontain">
					<span id="iso-label" class="property-label"><g:message code="trnsltUnLocode.iso.label" default="Iso" /></span>
					
						<span class="property-value" aria-labelledby="iso-label"><g:fieldValue bean="${trnsltUnLocodeInstance}" field="iso"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${trnsltUnLocodeInstance?.city}">
				<li class="fieldcontain">
					<span id="city-label" class="property-label"><g:message code="trnsltUnLocode.city.label" default="City" /></span>
					
						<span class="property-value" aria-labelledby="city-label"><g:fieldValue bean="${trnsltUnLocodeInstance}" field="city"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${trnsltUnLocodeInstance?.nameDiacritic}">
				<li class="fieldcontain">
					<span id="nameDiacritic-label" class="property-label"><g:message code="trnsltUnLocode.nameDiacritic.label" default="Name Diacritic" /></span>
					
						<span class="property-value" aria-labelledby="nameDiacritic-label"><g:fieldValue bean="${trnsltUnLocodeInstance}" field="nameDiacritic"/></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form url="[resource:trnsltUnLocodeInstance, action:'delete']" method="DELETE">
				<fieldset class="buttons">
					 <p align="justify"> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <g:link class="edit" action="edit" resource="${trnsltUnLocodeInstance}"><input type="button" value="Edit" class="btn btn-success" /></g:link>
					<g:actionSubmit class="delete btn btn-success" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
                                         </p>
                                </fieldset>
			</g:form>
		</div>
            </div>
            </div>
	</body>
</html>
