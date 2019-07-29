

<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'trnsltMeasurementCommonCode.label', default: 'TrnsltMeasurementCommonCode')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-trnsltMeasurementCommonCode" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
	       <div class="row">
                <div class="col-lg-12">
                    <div class="panel panel-default">
                        <div class="panel-heading">
			Translation table Mesurements Common Codes
<!--<g:message code="default.list.label" args="[entityName]" />-->
                         </div>
			
			 <div class="panel-body">
                            <div class="table-responsive">
                                <table class="table table-striped table-bordered table-hover" id="dataTables-example">
			<thead>
					<tr>
						<g:sortableColumn property="trnsltMeasurementCommonCodeId" title="${message(code: 'trnsltMeasurementCommonCode.trnsltMeasurementCommonCodeId.label', default: 'Trnslt Measurement Common Code Id')}" />
					
						<g:sortableColumn property="codeList" title="${message(code: 'trnsltMeasurementCommonCode.codeList.label', default: 'Code List')}" />
					
						<g:sortableColumn property="ecsName" title="${message(code: 'trnsltMeasurementCommonCode.ecsName.label', default: 'Ecs Name')}" />
					
						<g:sortableColumn property="code" title="${message(code: 'trnsltMeasurementCommonCode.code.label', default: 'Code')}" />
					
						<g:sortableColumn property="name" title="${message(code: 'trnsltMeasurementCommonCode.name.label', default: 'Name')}" />
					
						<g:sortableColumn property="description" title="${message(code: 'trnsltMeasurementCommonCode.description.label', default: 'Description')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${trnsltMeasurementCommonCodeInstanceList}" status="i" var="trnsltMeasurementCommonCodeInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${trnsltMeasurementCommonCodeInstance.id}">${fieldValue(bean: trnsltMeasurementCommonCodeInstance, field: "trnsltMeasurementCommonCodeId")}</g:link></td>
					
						<td>${fieldValue(bean: trnsltMeasurementCommonCodeInstance, field: "codeList")}</td>
					
						<td>${fieldValue(bean: trnsltMeasurementCommonCodeInstance, field: "ecsName")}</td>
					
						<td>${fieldValue(bean: trnsltMeasurementCommonCodeInstance, field: "code")}</td>
					
						<td>${fieldValue(bean: trnsltMeasurementCommonCodeInstance, field: "name")}</td>
					
						<td>${fieldValue(bean: trnsltMeasurementCommonCodeInstance, field: "description")}</td>
					
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
				<g:paginate total="${trnsltMeasurementCommonCodeInstanceCount ?: 0}" />
			</div>
		</div>
	</body>
</html>
