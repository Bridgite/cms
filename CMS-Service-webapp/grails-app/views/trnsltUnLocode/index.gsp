

<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'trnsltUnLocode.label', default: 'TrnsltUnLocode')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<div class="row">
                <div class="col-lg-12">
                    <h2 class="page-header">UnLocode Codes</h2>
                    
                                <g:link class="create" action="create"><input type="button" value="Create  UnLocode Code translation" class="btn btn-success" /></g:link>
                             <br>      <br>    
                </div>
        </div>
		       <div class="row">
                <div class="col-lg-12">
                    <div class="panel panel-default">
                        <div class="panel-heading">
			Translation UnLocode Codes
<!--<g:message code="default.list.label" args="[entityName]" />-->
                         </div>
			
			 <div class="panel-body">
                            <div class="table-responsive">
                                <table class="table table-striped table-bordered table-hover" id="dataTablesunlocode">
			<thead>
					<tr>
					
						<g:sortableColumn property="trnsltUnLocodeId" title="${message(code: 'trnsltUnLocode.trnsltUnLocodeId.label', default: 'Trnslt Un Locode Id')}" />
					
						<g:sortableColumn property="codeList" title="${message(code: 'trnsltUnLocode.codeList.label', default: 'Code List')}" />
					
						<g:sortableColumn property="ecsName" title="${message(code: 'trnsltUnLocode.ecsName.label', default: 'Ecs Name')}" />
					
						<g:sortableColumn property="code" title="${message(code: 'trnsltUnLocode.code.label', default: 'Code')}" />
					
						<g:sortableColumn property="iso" title="${message(code: 'trnsltUnLocode.iso.label', default: 'Iso')}" />
					
						<g:sortableColumn property="city" title="${message(code: 'trnsltUnLocode.city.label', default: 'City')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${trnsltUnLocodeInstanceList}" status="i" var="trnsltUnLocodeInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${trnsltUnLocodeInstance.id}">${fieldValue(bean: trnsltUnLocodeInstance, field: "trnsltUnLocodeId")}</g:link></td>
					
						<td>${fieldValue(bean: trnsltUnLocodeInstance, field: "codeList")}</td>
					
						<td>${fieldValue(bean: trnsltUnLocodeInstance, field: "ecsName")}</td>
					
						<td>${fieldValue(bean: trnsltUnLocodeInstance, field: "code")}</td>
					
						<td>${fieldValue(bean: trnsltUnLocodeInstance, field: "iso")}</td>
					
						<td>${fieldValue(bean: trnsltUnLocodeInstance, field: "city")}</td>
					
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
			   <!--<div class="pagination">
				<g:paginate total="${trnsltUnLocodeInstanceCount ?: 0}" />
			</div> -->
		</div>
	</body>
</html>
