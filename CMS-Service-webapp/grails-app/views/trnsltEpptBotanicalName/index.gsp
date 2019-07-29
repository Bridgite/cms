

<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'trnsltEpptBotanicalName.label', default: 'TrnsltEpptBotanicalName')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	
  
        </head>
	<body>
		 	<div class="row">
                <div class="col-lg-12">
                    <h2 class="page-header">EPPT botanical name </h2>
                    
                                <g:link class="create" action="create"><input type="button" value="Create EPPT botanical translation" class="btn btn-success" /></g:link>
                             <br>      <br>    
                </div>
        </div>
		       <div class="row">
                <div class="col-lg-12">
                    <div class="panel panel-default">
 
                        <div class="panel-heading">
			Translation table EPPT Botanical name
<!--<g:message code="default.list.label" args="[entityName]" />-->
                         </div>
			
			 <div class="panel-body">
                            <div class="table-responsive">
                                  
                                
                                
                                <table class="table table-striped table-bordered table-hover" id="dataTables-eppt">
			<thead>
					<tr>
					
						<g:sortableColumn property="trnsltEpptBotanicalNameId" title="${message(code: 'trnsltEpptBotanicalName.trnsltEpptBotanicalNameId.label', default: 'Trnslt Eppt Botanical Name Id')}" />
					
						<g:sortableColumn property="codeList" title="${message(code: 'trnsltEpptBotanicalName.codeList.label', default: 'Code List')}" />
					
						<g:sortableColumn property="ecsName" title="${message(code: 'trnsltEpptBotanicalName.ecsName.label', default: 'Ecs Name')}" />
					
						<g:sortableColumn property="code" title="${message(code: 'trnsltEpptBotanicalName.code.label', default: 'Code')}" />
					
						<g:sortableColumn property="fullName" title="${message(code: 'trnsltEpptBotanicalName.fullName.label', default: 'Full Name')}" />
					
						<g:sortableColumn property="authority" title="${message(code: 'trnsltEpptBotanicalName.authority.label', default: 'Authority')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${trnsltEpptBotanicalNameInstanceList}" status="i" var="trnsltEpptBotanicalNameInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${trnsltEpptBotanicalNameInstance.id}">${fieldValue(bean: trnsltEpptBotanicalNameInstance, field: "trnsltEpptBotanicalNameId")}</g:link></td>
					
						<td>${fieldValue(bean: trnsltEpptBotanicalNameInstance, field: "codeList")}</td>
					
						<td>${fieldValue(bean: trnsltEpptBotanicalNameInstance, field: "ecsName")}</td>
					
						<td>${fieldValue(bean: trnsltEpptBotanicalNameInstance, field: "code")}</td>
					
						<td>${fieldValue(bean: trnsltEpptBotanicalNameInstance, field: "fullName")}</td>
					
						<td>${fieldValue(bean: trnsltEpptBotanicalNameInstance, field: "authority")}</td>
					
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
			 
		</div>
	</body>
</html>
