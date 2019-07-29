

<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'trnsltCountryIsoCode.label', default: 'TrnsltCountryIsoCode')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<div class="row">
                <div class="col-lg-12">
                    <h2 class="page-header">Country ISO</h2>
                    
                                <g:link class="create" action="create"><input type="button" value="Create country ISO translation" class="btn btn-success" /></g:link>
                             <br>      <br>    
                </div>
        </div>
		       <div class="row">
                <div class="col-lg-12">
                    <div class="panel panel-default">
                        <div class="panel-heading">
			Translation table Country ISO
<!--<g:message code="default.list.label" args="[entityName]" />-->
                         </div>
			
			 <div class="panel-body">
                            <div class="table-responsive">
                                <table class="table table-striped table-bordered table-hover" id="dataTable-country">
			<thead>
					<tr>
					
						<g:sortableColumn property="trnsltCountryIsoCodeId" title="${message(code: 'trnsltCountryIsoCode.trnsltCountryIsoCodeId.label', default: 'Trnslt Country Iso Code Id')}" />
					
						<g:sortableColumn property="ecsName" title="${message(code: 'trnsltCountryIsoCode.ecsName.label', default: 'Ecs Name')}" />
					
						<g:sortableColumn property="isoCode" title="${message(code: 'trnsltCountryIsoCode.isoCode.label', default: 'Iso Code')}" />
					
						<g:sortableColumn property="description" title="${message(code: 'trnsltCountryIsoCode.description.label', default: 'Description')}" />
					
						<g:sortableColumn property="primaryKeyColumn" title="${message(code: 'trnsltCountryIsoCode.primaryKeyColumn.label', default: 'Primary Key Column')}" />
					
						<g:sortableColumn property="twoCharIsoCode" title="${message(code: 'trnsltCountryIsoCode.twoCharIsoCode.label', default: 'Two Char Iso Code')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${trnsltCountryIsoCodeInstanceList}" status="i" var="trnsltCountryIsoCodeInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${trnsltCountryIsoCodeInstance.id}">${fieldValue(bean: trnsltCountryIsoCodeInstance, field: "trnsltCountryIsoCodeId")}</g:link></td>
					
						<td>${fieldValue(bean: trnsltCountryIsoCodeInstance, field: "ecsName")}</td>
					
						<td>${fieldValue(bean: trnsltCountryIsoCodeInstance, field: "isoCode")}</td>
					
						<td>${fieldValue(bean: trnsltCountryIsoCodeInstance, field: "description")}</td>
					
						<td>${fieldValue(bean: trnsltCountryIsoCodeInstance, field: "primaryKeyColumn")}</td>
					
						<td>${fieldValue(bean: trnsltCountryIsoCodeInstance, field: "twoCharIsoCode")}</td>
					
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
				<g:paginate total="${trnsltCountryIsoCodeInstanceCount ?: 0}" />
			</div>
		</div>
        
	</body>
</html>
