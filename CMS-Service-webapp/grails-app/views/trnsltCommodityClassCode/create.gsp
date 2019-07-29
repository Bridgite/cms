<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'trnsltCommodityClassCode.label', default: 'TrnsltCommodityClassCode')}" />
		<title><g:message code="default.create.label" args="[entityName]" /></title>
	</head>
	<body>
         
    	<div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">Create commodity class translation </h1>
                    
			 
                                <g:link class="create" action="index"><input type="button" value="Commodity class code translation table" class="btn btn-success" /></g:link>
                                   
                                <br> <br> 
                </div>
            <!-- /.row -->
             <div class="col-lg-12">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            Commodity class translation table
                        </div>
		 <br><br>
		 
			
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<g:hasErrors bean="${trnsltCommodityClassCodeInstance}">
			<ul class="errors" role="alert">
				<g:eachError bean="${trnsltCommodityClassCodeInstance}" var="error">
				<li <g:if test="${error in org.springframework.validation.FieldError}">data-field-id="${error.field}"</g:if>><g:message error="${error}"/></li>
				</g:eachError>
			</ul>
			</g:hasErrors>
                          
                                        
			<g:form url="[resource:trnsltCommodityClassCodeInstance, action:'save']"  role="form" >
                           
				<fieldset class="form">
					<g:render template="form"/>
				</fieldset>
                                	 
                                <div class="form-group" >
				<fieldset class="buttons">
                                    <p align="justify"> &nbsp;&nbsp;&nbsp;<g:submitButton name="create" class="save btn btn-success" value="${message(code: 'default.button.create.label', default: 'Create')}"/>
                                    </p></fieldset>
                                </div>
                                 
                            
			</g:form>
		</div>
                  </div>
            <!-- /.row -->
        </div>
        <!-- /#page-wrapper -->
	</body>
</html>
