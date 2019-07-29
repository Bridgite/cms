

<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'trnsltTransportmodeCode.label', default: 'TrnsltTransportmodeCode')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<div class="row">
                <div class="col-lg-12">
                    <h2 class="page-header"> Transport mode Codes</h2>
                    
                                <g:link class="create" action="create"><input type="button" value="Create Transport mode code translation" class="btn btn-success" /></g:link>
                             <br>      <br>    
                </div>
        </div>
		       <div class="row">
                <div class="col-lg-12">
                    <div class="panel panel-default">
                        <div class="panel-heading">
			Translation table Transport mode Codes
<!--<g:message code="default.list.label" args="[entityName]" />-->
                         </div>
			
			 <div class="panel-body">
                            <div class="table-responsive">
                                <table class="table table-striped table-bordered table-hover" id="dataTables-example">
			<thead>
					<tr>
					
						<g:sortableColumn property="trnsltTransportmodeCodeId" title="${message(code: 'trnsltTransportmodeCode.trnsltTransportmodeCodeId.label', default: 'Trnslt Transportmode Code Id')}" />
					
						<g:sortableColumn property="codeList" title="${message(code: 'trnsltTransportmodeCode.codeList.label', default: 'Code List')}" />
					
						<g:sortableColumn property="ecsName" title="${message(code: 'trnsltTransportmodeCode.ecsName.label', default: 'Ecs Name')}" />
					
						<g:sortableColumn property="code" title="${message(code: 'trnsltTransportmodeCode.code.label', default: 'Code')}" />
					
						<g:sortableColumn property="name" title="${message(code: 'trnsltTransportmodeCode.name.label', default: 'Name')}" />
					
						<g:sortableColumn property="description" title="${message(code: 'trnsltTransportmodeCode.description.label', default: 'Description')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${trnsltTransportmodeCodeInstanceList}" status="i" var="trnsltTransportmodeCodeInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${trnsltTransportmodeCodeInstance.id}">${fieldValue(bean: trnsltTransportmodeCodeInstance, field: "trnsltTransportmodeCodeId")}</g:link></td>
					
						<td>${fieldValue(bean: trnsltTransportmodeCodeInstance, field: "codeList")}</td>
					
						<td>${fieldValue(bean: trnsltTransportmodeCodeInstance, field: "ecsName")}</td>
					
						<td>${fieldValue(bean: trnsltTransportmodeCodeInstance, field: "code")}</td>
					
						<td>${fieldValue(bean: trnsltTransportmodeCodeInstance, field: "name")}</td>
					
						<td>${fieldValue(bean: trnsltTransportmodeCodeInstance, field: "description")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
                                </div>
                             <!-- /.panel-body -->
                    </div>
                    <!-- /.panel -->
                </div>
                <!-- /.col-lg-12 -->
            </div>
			<div class="pagination">
				<g:paginate total="${trnsltTransportmodeCodeInstanceCount ?: 0}" />
			</div>
		</div>
	</body>
</html>
