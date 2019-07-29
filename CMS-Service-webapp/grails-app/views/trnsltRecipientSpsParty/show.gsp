

<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'trnsltRecipientSpsParty.label', default: 'TrnsltRecipientSpsParty')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	
		   <div class="row">
            <div class="col-lg-12">
                <h1 class="page-header">Edit Recipient SPS Party translation </h1>


                <g:link class="list" action="index"><input type="button" value=" Recipient SPS Parties translation table" class="btn btn-success" /></g:link>
                <g:link class="create" action="create"><input type="button" value="Create Recipient SPS Party translation " class="btn btn-success" /></g:link>


                <br> <br> 
            </div>
            <div class="col-lg-12">
                <div class="panel panel-default">
                    <div class="panel-heading">
                         SPS Party  
                    </div>
                    <br><g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list trnsltRecipientSpsParty">
			
				<g:if test="${trnsltRecipientSpsPartyInstance?.trnsltRecipientSpsPartyId}">
				<div class="form-group">
					<span id="trnsltRecipientSpsPartyId-label" class="property-label"><g:message code="trnsltRecipientSpsParty.trnsltRecipientSpsPartyId.label" default="Trnslt Recipient Sps Party Id" />: </span>
					
						<span class="property-value" aria-labelledby="trnsltRecipientSpsPartyId-label"><g:fieldValue bean="${trnsltRecipientSpsPartyInstance}" field="trnsltRecipientSpsPartyId"/></span>
					
				</div>
				</g:if>
			
				<g:if test="${trnsltRecipientSpsPartyInstance?.codeList}">
				<div class="form-group">
					<span id="codeList-label" class="property-label"><g:message code="trnsltRecipientSpsParty.codeList.label" default="Code List" /> :</span>
					
						<span class="property-value" aria-labelledby="codeList-label"><g:fieldValue bean="${trnsltRecipientSpsPartyInstance}" field="codeList"/></span>
					
				</div>
				</g:if>
			
				<g:if test="${trnsltRecipientSpsPartyInstance?.ecsName}">
				<div class="form-group">
					<span id="ecsName-label" class="property-label"><g:message code="trnsltRecipientSpsParty.ecsName.label" default="Ecs Name" /> : </span>
					
						<span class="property-value" aria-labelledby="ecsName-label"><g:fieldValue bean="${trnsltRecipientSpsPartyInstance}" field="ecsName"/></span>
					
				</div>
				</g:if>
			
				<g:if test="${trnsltRecipientSpsPartyInstance?.code}">
				<div class="form-group">
					<span id="code-label" class="property-label"><g:message code="trnsltRecipientSpsParty.code.label" default="Code" /> : </span>
					
						<span class="property-value" aria-labelledby="code-label"><g:fieldValue bean="${trnsltRecipientSpsPartyInstance}" field="code"/></span>
					
				</div>
				</g:if>
			
				<g:if test="${trnsltRecipientSpsPartyInstance?.name}">
				<div class="form-group">
					<span id="name-label" class="property-label"><g:message code="trnsltRecipientSpsParty.name.label" default="Name" /></span>
					
						<span class="property-value" aria-labelledby="name-label"><g:fieldValue bean="${trnsltRecipientSpsPartyInstance}" field="name"/> : </span>
					
				</div>
				</g:if>
			
				<g:if test="${trnsltRecipientSpsPartyInstance?.description}">
				<div class="form-group">
					<span id="description-label" class="property-label"><g:message code="trnsltRecipientSpsParty.description.label" default="Description" /> : </span>
					
						<span class="property-value" aria-labelledby="description-label"><g:fieldValue bean="${trnsltRecipientSpsPartyInstance}" field="description"/></span>
					
				</div>
				</g:if>
			
			</ol>
			<g:form url="[resource:trnsltRecipientSpsPartyInstance, action:'delete']" method="DELETE">
				  <fieldset class="buttons">
					 <p align="justify"> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <g:link class="edit" action="edit" resource="${trnsltRecipientSpsPartyInstance}"><input type="button" value="Edit" class="btn btn-success" /></g:link>
					<g:actionSubmit class="delete btn btn-success" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
                                         </p>
                                </fieldset>
			</g:form>
		</div>
	</body>
</html>
