

<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'trnsltCommodityClassCode.label', default: 'TrnsltCommodityClassCode')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		 
	 	<div class="row">
                <div class="col-lg-12">
                    <h2 class="page-header">Commodity class code </h2>
                    
                                <g:link class="create" action="create"><input type="button" value="Create Commodity class translation" class="btn btn-success" /></g:link>
                             <br>      <br>    
                </div>
        </div>
	            <div class="row">
                <div class="col-lg-12">
                    <div class="panel panel-default">
                        <div class="panel-heading">
			<h4> Commodity class code translation table</h4>
<!--<g:message code="default.list.label" args="[entityName]" />-->
                         </div>
			
			 <div class="panel-body">
                             
                             
                            <div class="table-responsive">
                                <table class="table table-striped table-bordered table-hover" id="dataTables-example">
			<thead>
					<tr>
					
					
						<g:sortableColumn property="trnsltCommodityClassCodeId" title="${message(code: 'trnsltCommodityClassCode.trnsltCommodityClassCodeId.label', default: 'Trnslt Commodity Class Code Id')}" />
					
						<g:sortableColumn property="codeList" title="${message(code: 'trnsltCommodityClassCode.codeList.label', default: 'Code List')}" />
					
						<g:sortableColumn property="ecsName" title="${message(code: 'trnsltCommodityClassCode.ecsName.label', default: 'Ecs Name')}" />
					
						<g:sortableColumn property="code" title="${message(code: 'trnsltCommodityClassCode.code.label', default: 'Code')}" />
					
						<g:sortableColumn property="name" title="${message(code: 'trnsltCommodityClassCode.name.label', default: 'Name')}" />
					
						<g:sortableColumn property="description" title="${message(code: 'trnsltCommodityClassCode.description.label', default: 'Description')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${trnsltCommodityClassCodeInstanceList}" status="i" var="trnsltCommodityClassCodeInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${trnsltCommodityClassCodeInstance.id}">${fieldValue(bean: trnsltCommodityClassCodeInstance, field: "trnsltCommodityClassCodeId")}</g:link></td>
					
						<td>${fieldValue(bean: trnsltCommodityClassCodeInstance, field: "codeList")}</td>
					
						<td>${fieldValue(bean: trnsltCommodityClassCodeInstance, field: "ecsName")}</td>
					
						<td>${fieldValue(bean: trnsltCommodityClassCodeInstance, field: "code")}</td>
					
						<td>${fieldValue(bean: trnsltCommodityClassCodeInstance, field: "name")}</td>
					
						<td>${fieldValue(bean: trnsltCommodityClassCodeInstance, field: "description")}</td>
					
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
				<g:paginate total="${trnsltCommodityClassCodeInstanceCount ?: 0}" />
			</div>
		</div>
                   
	</body>
</html>
