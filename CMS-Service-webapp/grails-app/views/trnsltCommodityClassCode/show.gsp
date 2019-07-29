

<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'trnsltCommodityClassCode.label', default: 'TrnsltCommodityClassCode')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body> 
        <div class="row">
            <div class="col-lg-12">
                <h1 class="page-header">View commodity class translation </h1>


                <g:link class="list" action="index"><input type="button" value="Commodity class code translation table" class="btn btn-success" /></g:link>
                <g:link class="create" action="create"><input type="button" value="Create commodity class code translation " class="btn btn-success" /></g:link>


                <br> <br> 
            </div>   <div class="col-lg-12">
                <div class="panel panel-default">
                    <div class="panel-heading">
                       View  Commodity class translation table
                    </div>
                    <br> 
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list trnsltCommodityClassCode">
			
				<g:if test="${trnsltCommodityClassCodeInstance?.trnsltCommodityClassCodeId}">
				 <div class="form-group">
                                     <span id="trnsltCommodityClassCodeId-label" class="property-label"><g:message code="trnsltCommodityClassCode.trnsltCommodityClassCodeId.label" default="Trnslt Commodity Class Code Id" /> :</span>
					
                                     <span class="property-value" aria-labelledby="trnsltCommodityClassCodeId-label"><i><g:fieldValue bean="${trnsltCommodityClassCodeInstance}" field="trnsltCommodityClassCodeId"/></i></span>
					
				</div>
				</g:if>
			
				<g:if test="${trnsltCommodityClassCodeInstance?.codeList}">
				 <div class="form-group">
					<span id="codeList-label" class="property-label"><g:message code="trnsltCommodityClassCode.codeList.label" default="Code List" /> : </span>
					
                                        <span class="property-value" aria-labelledby="codeList-label"><i><g:fieldValue bean="${trnsltCommodityClassCodeInstance}" field="codeList"/></i></span>
					
				</div>
				</g:if>
			
				<g:if test="${trnsltCommodityClassCodeInstance?.ecsName}">
					 <div class="form-group">
					<span id="ecsName-label" class="property-label"><g:message code="trnsltCommodityClassCode.ecsName.label" default="Ecs Name" />:</span>
					
                                        <span class="property-value" aria-labelledby="ecsName-label"><i><g:fieldValue bean="${trnsltCommodityClassCodeInstance}" field="ecsName"/></i></span>
					
				</div>
				</g:if>
			
				<g:if test="${trnsltCommodityClassCodeInstance?.code}">
					 <div class="form-group">
					<span id="code-label" class="property-label"><g:message code="trnsltCommodityClassCode.code.label" default="Code" />:</span>
					
                                        <span class="property-value" aria-labelledby="code-label"><i><g:fieldValue bean="${trnsltCommodityClassCodeInstance}" field="code"/></i></span>
					
				</div>
				</g:if>
			
				<g:if test="${trnsltCommodityClassCodeInstance?.name}">
					 <div class="form-group">
					<span id="name-label" class="property-label"><g:message code="trnsltCommodityClassCode.name.label" default="Name" />:</span>
					
                                        <span class="property-value" aria-labelledby="name-label"><i><g:fieldValue bean="${trnsltCommodityClassCodeInstance}" field="name"/></i></span>
					
				</div>
				</g:if>
			
				<g:if test="${trnsltCommodityClassCodeInstance?.description}">
					 <div class="form-group">
					<span id="description-label" class="property-label"><g:message code="trnsltCommodityClassCode.description.label" default="Description" />:</span>
					
                                        <span class="property-value" aria-labelledby="description-label"><i><g:fieldValue bean="${trnsltCommodityClassCodeInstance}" field="description"/></i></span>
					
				</div>
				</g:if>
			
			</ol>
			<g:form url="[resource:trnsltCommodityClassCodeInstance, action:'delete']" method="DELETE">
				<fieldset class="buttons">
					 <p align="justify"> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <g:link class="edit" action="edit" resource="${trnsltCommodityClassCodeInstance}"><input type="button" value="Edit" class="btn btn-success" /></g:link>
					<g:actionSubmit class="delete btn btn-success" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
                                         </p>
                                </fieldset>
			</g:form>
		</div>
            </div>
        </div>
	</body>
</html>
