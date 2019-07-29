
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'trnsltPackageTypeCode.label', default: 'TrnsltPackageTypeCode')}" />
		<title><g:message code="default.edit.label" args="[entityName]" /></title>
	</head>
	<body>
		<div class="row">
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

			<g:hasErrors bean="${trnsltPackageTypeCodeInstance}">
			<!-- <ul class="errors" role="alert">
				<g:eachError bean="${trnsltPackageTypeCodeInstance}" var="error">
				<li <g:if test="${error in org.springframework.validation.FieldError}">data-field-id="${error.field}"</g:if>><g:message error="${error}"/></li>
				</g:eachError>
			</ul>  -->
			</g:hasErrors>
			<g:form url="[resource:trnsltPackageTypeCodeInstance, action:'update']" method="PUT" >
				<g:hiddenField name="version" value="${trnsltPackageTypeCodeInstance?.version}" />
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
