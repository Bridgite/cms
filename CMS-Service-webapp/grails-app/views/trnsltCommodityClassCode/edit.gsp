
<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main">
        <g:set var="entityName" value="${message(code: 'trnsltCommodityClassCode.label', default: 'TrnsltCommodityClassCode')}" />
        <title><g:message code="default.edit.label" args="[entityName]" /></title>
    </head>
    <body>
        <div class="row">
            <div class="col-lg-12">
                <h1 class="page-header">Edit commodity class translation </h1>


                <g:link class="list" action="index"><input type="button" value="Commodity class code translation table" class="btn btn-success" /></g:link>
                <g:link class="create" action="create"><input type="button" value="Create commodity class code translation " class="btn btn-success" /></g:link>


                <br> <br> 
            </div>
            <div class="col-lg-12">
                <div class="panel panel-default">
                    <div class="panel-heading">
                       Edit commodity class translation
                    </div>
                    <br> 

                    <g:hasErrors bean="${trnsltCommodityClassCodeInstance}">
                        <ul >
                            <g:eachError bean="${trnsltCommodityClassCodeInstance}" var="error">
                           
<li <g:if test="${error in org.springframework.validation.FieldError}">data-field-id="${error.field}"</g:if>><g:message error="${error}"/></li>
                                </g:eachError>
                        </ul>
                    </g:hasErrors>
                    <br> 
                    <g:form url="[resource:trnsltCommodityClassCodeInstance, action:'update']" method="PUT" >
                        <g:hiddenField name="version" value="${trnsltCommodityClassCodeInstance?.version}" />
                        <fieldset class="form">
                            <g:render template="form"/>
                        </fieldset>
                        
                   
                              <div class="form-group" >
				<fieldset class="buttons">
                                    <p align="justify"> &nbsp;&nbsp;&nbsp; <g:actionSubmit  class="save btn btn-success"  action="update" value="${message(code: 'default.button.update.label', default: 'Update')}" />
                                    </p></fieldset>
                                </div>
                    </g:form>
                </div>
            </div>
        </div>
        
    </body>
</html>
