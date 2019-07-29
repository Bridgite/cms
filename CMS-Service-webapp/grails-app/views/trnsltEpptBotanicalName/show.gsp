

<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'trnsltEpptBotanicalName.label', default: 'TrnsltEpptBotanicalName')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		 <div class="row">
            <div class="col-lg-12">
                <h1 class="page-header">View  EPPT Botanical Name translation </h1>


                <g:link class="list" action="index"><input type="button" value="Commodity class code translation table" class="btn btn-success" /></g:link>
                <g:link class="create" action="create"><input type="button" value="Create commodity class code translation " class="btn btn-success" /></g:link>


                <br> <br> 
            </div> 
		<div class="col-lg-12">
                <div class="panel panel-default">
                    <div class="panel-heading">
                       View  EPPT Botanical Name  
                    </div>
                    <br> <g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list trnsltEpptBotanicalName">
			
				<g:if test="${trnsltEpptBotanicalNameInstance?.trnsltEpptBotanicalNameId}">
				<div class="form-group">
					<span id="trnsltEpptBotanicalNameId-label" class="property-label"><g:message code="trnsltEpptBotanicalName.trnsltEpptBotanicalNameId.label" default="Trnslt Eppt Botanical Name Id" />: </span>
					
						<span class="property-value" aria-labelledby="trnsltEpptBotanicalNameId-label"><g:fieldValue bean="${trnsltEpptBotanicalNameInstance}" field="trnsltEpptBotanicalNameId"/></span>
					
				</div>
				</g:if>
			
				<g:if test="${trnsltEpptBotanicalNameInstance?.codeList}">
				<div class="form-group">
					<span id="codeList-label" class="property-label"><g:message code="trnsltEpptBotanicalName.codeList.label" default="Code List" /> : </span>
					
						<span class="property-value" aria-labelledby="codeList-label"><g:fieldValue bean="${trnsltEpptBotanicalNameInstance}" field="codeList"/></span>
					
				</div>
				</g:if>
			
				<g:if test="${trnsltEpptBotanicalNameInstance?.ecsName}">
				<div class="form-group">
					<span id="ecsName-label" class="property-label"><g:message code="trnsltEpptBotanicalName.ecsName.label" default="Ecs Name" /> :</span>
					
						<span class="property-value" aria-labelledby="ecsName-label"><g:fieldValue bean="${trnsltEpptBotanicalNameInstance}" field="ecsName"/></span>
					
				</div>
				</g:if>
			
				<g:if test="${trnsltEpptBotanicalNameInstance?.code}">
				<div class="form-group">
					<span id="code-label" class="property-label"><g:message code="trnsltEpptBotanicalName.code.label" default="Code" /> : </span>
					
						<span class="property-value" aria-labelledby="code-label"><g:fieldValue bean="${trnsltEpptBotanicalNameInstance}" field="code"/></span>
					
				</div>
				</g:if>
			
				<g:if test="${trnsltEpptBotanicalNameInstance?.fullName}">
				<div class="form-group">
					<span id="fullName-label" class="property-label"><g:message code="trnsltEpptBotanicalName.fullName.label" default="Full Name" /> : </span>
					
						<span class="property-value" aria-labelledby="fullName-label"><g:fieldValue bean="${trnsltEpptBotanicalNameInstance}" field="fullName"/></span>
					
				</div>
				</g:if>
			
				<g:if test="${trnsltEpptBotanicalNameInstance?.authority}">
				<div class="form-group">
					<span id="authority-label" class="property-label"><g:message code="trnsltEpptBotanicalName.authority.label" default="Authority" /> : </span>
					
						<span class="property-value" aria-labelledby="authority-label"><g:fieldValue bean="${trnsltEpptBotanicalNameInstance}" field="authority"/></span>
					
				</div>
				</g:if>
			
				<g:if test="${trnsltEpptBotanicalNameInstance?.identifier}">
				<div class="form-group">
					<span id="identifier-label" class="property-label"><g:message code="trnsltEpptBotanicalName.identifier.label" default="Identifier" /> : </span>
					
						<span class="property-value" aria-labelledby="identifier-label"><g:fieldValue bean="${trnsltEpptBotanicalNameInstance}" field="identifier"/></span>
					
				</div>
				</g:if>
			
				<g:if test="${trnsltEpptBotanicalNameInstance?.datatype}">
				<div class="form-group">
					<span id="datatype-label" class="property-label"><g:message code="trnsltEpptBotanicalName.datatype.label" default="Datatype" /> : </span>
					
						<span class="property-value" aria-labelledby="datatype-label"><g:fieldValue bean="${trnsltEpptBotanicalNameInstance}" field="datatype"/></span>
					
				</div>
				</g:if>
			
				<g:if test="${trnsltEpptBotanicalNameInstance?.lang}">
				<div class="form-group">
					<span id="lang-label" class="property-label"><g:message code="trnsltEpptBotanicalName.lang.label" default="Lang" /></span>
					
						<span class="property-value" aria-labelledby="lang-label"><g:fieldValue bean="${trnsltEpptBotanicalNameInstance}" field="lang"/> : </span>
					
				</div>
				</g:if>
			
				<g:if test="${trnsltEpptBotanicalNameInstance?.langno}">
				<div class="form-group">
					<span id="langno-label" class="property-label"><g:message code="trnsltEpptBotanicalName.langno.label" default="Langno" /> : </span>
					
						<span class="property-value" aria-labelledby="langno-label"><g:fieldValue bean="${trnsltEpptBotanicalNameInstance}" field="langno"/></span>
					
				</div>
				</g:if>
			
				<g:if test="${trnsltEpptBotanicalNameInstance?.preferred}">
				<div class="form-group">
					<span id="preferred-label" class="property-label"><g:message code="trnsltEpptBotanicalName.preferred.label" default="Preferred" /> : </span>
					
						<span class="property-value" aria-labelledby="preferred-label"><g:fieldValue bean="${trnsltEpptBotanicalNameInstance}" field="preferred"/></span>
					
				</div>
				</g:if>
			
				<g:if test="${trnsltEpptBotanicalNameInstance?.status}">
				<div class="form-group">
					<span id="status-label" class="property-label"><g:message code="trnsltEpptBotanicalName.status.label" default="Status" /> : </span>
					
						<span class="property-value" aria-labelledby="status-label"><g:fieldValue bean="${trnsltEpptBotanicalNameInstance}" field="status"/></span>
					
				</div>
				</g:if>
			
				<g:if test="${trnsltEpptBotanicalNameInstance?.creation}">
				<div class="form-group">
					<span id="creation-label" class="property-label"><g:message code="trnsltEpptBotanicalName.creation.label" default="Creation" /> : </span>
					
						<span class="property-value" aria-labelledby="creation-label"><g:formatDate date="${trnsltEpptBotanicalNameInstance?.creation}" /></span>
					
				</div>
				</g:if>
			
				<g:if test="${trnsltEpptBotanicalNameInstance?.modification}">
				<div class="form-group">
					<span id="modification-label" class="property-label"><g:message code="trnsltEpptBotanicalName.modification.label" default="Modification" /> : </span>
					
						<span class="property-value" aria-labelledby="modification-label"><g:formatDate date="${trnsltEpptBotanicalNameInstance?.modification}" /></span>
					
				</div>
				</g:if>
			
				<g:if test="${trnsltEpptBotanicalNameInstance?.country}">
				<div class="form-group">
					<span id="country-label" class="property-label"><g:message code="trnsltEpptBotanicalName.country.label" default="Country" /> : </span>
					
						<span class="property-value" aria-labelledby="country-label"><g:fieldValue bean="${trnsltEpptBotanicalNameInstance}" field="country"/></span>
					
				</div>
				</g:if>
			
			</ol>
			<g:form url="[resource:trnsltEpptBotanicalNameInstance, action:'delete']" method="DELETE">
	<fieldset class="buttons">
					 <p align="justify"> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <g:link class="edit" action="edit" resource="${trnsltEpptBotanicalNameInstance}"><input type="button" value="Edit" class="btn btn-success" /></g:link>
					<g:actionSubmit class="delete btn btn-success" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
                                         </p>
                                </fieldset>
			</g:form>
		</div>
                </div>
	</body>
</html>
