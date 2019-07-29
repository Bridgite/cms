
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'trnsltRecipientSpsParty.label', default: 'TrnsltRecipientSpsParty')}" />
		<title><g:message code="default.edit.label" args="[entityName]" /></title>
	</head>
	<body>
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
                    <br> 
			<g:hasErrors bean="${trnsltRecipientSpsPartyInstance}">
		 
			</g:hasErrors>
			<g:form url="[resource:trnsltRecipientSpsPartyInstance, action:'update']" method="PUT" >
				<g:hiddenField name="version" value="${trnsltRecipientSpsPartyInstance?.version}" />
				<fieldset class="form">
					<g:render template="form"/>
				</fieldset>
				<fieldset class="buttons">
                                    <p align="justify"> &nbsp;&nbsp;&nbsp; <g:actionSubmit  class="save btn btn-success"  action="update" value="${message(code: 'default.button.update.label', default: 'Update')}" />
                                    </p></fieldset>
			</g:form>
		</div>
            </div>
            </div>
	</body>
</html>
