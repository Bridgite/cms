

<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'trnsltPackageTypeCode.label', default: 'TrnsltPackageTypeCode')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<div class="row">
                <div class="col-lg-12">
                    <h2 class="page-header"> Package type codes</h2>
                    
                                <g:link class="create" action="create"><input type="button" value="Create  Package type codes translation" class="btn btn-success" /></g:link>
                             <br>      <br>    
                </div>
        </div>
		       <div class="row">
                <div class="col-lg-12">
                    <div class="panel panel-default">
                        <div class="panel-heading">
			Translation table Package type codes
<!--<g:message code="default.list.label" args="[entityName]" />-->
                         </div>
			
			 <div class="panel-body">
                            <div class="table-responsive">
                                <table class="table table-striped table-bordered table-hover" id="dataTables-example">
			<thead>
					<tr>
						<g:sortableColumn property="trnsltPackageTypeCodeId" title="${message(code: 'trnsltPackageTypeCode.trnsltPackageTypeCodeId.label', default: 'Trnslt Package Type Code Id')}" />
					
						<g:sortableColumn property="codeList" title="${message(code: 'trnsltPackageTypeCode.codeList.label', default: 'Code List')}" />
					
						<g:sortableColumn property="ecsName" title="${message(code: 'trnsltPackageTypeCode.ecsName.label', default: 'Ecs Name')}" />
					
						<g:sortableColumn property="code" title="${message(code: 'trnsltPackageTypeCode.code.label', default: 'Code')}" />
					
						<g:sortableColumn property="name" title="${message(code: 'trnsltPackageTypeCode.name.label', default: 'Name')}" />
					
						<g:sortableColumn property="description" title="${message(code: 'trnsltPackageTypeCode.description.label', default: 'Description')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${trnsltPackageTypeCodeInstanceList}" status="i" var="trnsltPackageTypeCodeInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${trnsltPackageTypeCodeInstance.id}">${fieldValue(bean: trnsltPackageTypeCodeInstance, field: "trnsltPackageTypeCodeId")}</g:link></td>
					
						<td>${fieldValue(bean: trnsltPackageTypeCodeInstance, field: "codeList")}</td>
					
						<td>${fieldValue(bean: trnsltPackageTypeCodeInstance, field: "ecsName")}</td>
					
						<td>${fieldValue(bean: trnsltPackageTypeCodeInstance, field: "code")}</td>
					
						<td>${fieldValue(bean: trnsltPackageTypeCodeInstance, field: "name")}</td>
					
						<td>${fieldValue(bean: trnsltPackageTypeCodeInstance, field: "description")}</td>
					
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
				<g:paginate total="${trnsltPackageTypeCodeInstanceCount ?: 0}" />
			</div>
		</div>
	</body>
</html>
