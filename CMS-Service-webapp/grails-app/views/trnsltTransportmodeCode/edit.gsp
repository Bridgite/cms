
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'trnsltTransportmodeCode.label', default: 'TrnsltTransportmodeCode')}" />
		<title><g:message code="default.edit.label" args="[entityName]" /></title>
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
                    <br> 

			<g:hasErrors bean="${trnsltTransportmodeCodeInstance}">
			<ul class="errors" role="alert">
				<g:eachError bean="${trnsltTransportmodeCodeInstance}" var="error">
				<li <g:if test="${error in org.springframework.validation.FieldError}">data-field-id="${error.field}"</g:if>><g:message error="${error}"/></li>
				</g:eachError>
			</ul>
			</g:hasErrors>
			<g:form url="[resource:trnsltTransportmodeCodeInstance, action:'update']" method="PUT" >
				<g:hiddenField name="version" value="${trnsltTransportmodeCodeInstance?.version}" />
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
