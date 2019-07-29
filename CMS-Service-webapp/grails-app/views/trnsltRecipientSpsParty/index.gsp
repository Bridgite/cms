

<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'trnsltRecipientSpsParty.label', default: 'TrnsltRecipientSpsParty')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<div class="row">
                <div class="col-lg-12">
                    <h2 class="page-header">Recipient SPS Parties</h2>
                    
                                <g:link class="create" action="create"><input type="button" value="Create SPS Party translation" class="btn btn-success" /></g:link>
                             <br>      <br>    
                </div>
        </div>
		       <div class="row">
                <div class="col-lg-12">
                    <div class="panel panel-default">
                        <div class="panel-heading">
			Translation table recipient SPS Parties
<!--<g:message code="default.list.label" args="[entityName]" />-->
                         </div>
			
			 <div class="panel-body">
                            <div class="table-responsive">
                                <table class="table table-striped table-bordered table-hover" id="dataTables-example">
			<thead>
					<tr>
					
						<g:sortableColumn property="trnsltRecipientSpsPartyId" title="${message(code: 'trnsltRecipientSpsParty.trnsltRecipientSpsPartyId.label', default: 'Trnslt Recipient Sps Party Id')}" />
					
						<g:sortableColumn property="codeList" title="${message(code: 'trnsltRecipientSpsParty.codeList.label', default: 'Code List')}" />
					
						<g:sortableColumn property="ecsName" title="${message(code: 'trnsltRecipientSpsParty.ecsName.label', default: 'Ecs Name')}" />
					
						<g:sortableColumn property="code" title="${message(code: 'trnsltRecipientSpsParty.code.label', default: 'Code')}" />
					
						<g:sortableColumn property="name" title="${message(code: 'trnsltRecipientSpsParty.name.label', default: 'Name')}" />
					
						<g:sortableColumn property="description" title="${message(code: 'trnsltRecipientSpsParty.description.label', default: 'Description')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${trnsltRecipientSpsPartyInstanceList}" status="i" var="trnsltRecipientSpsPartyInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${trnsltRecipientSpsPartyInstance.id}">${fieldValue(bean: trnsltRecipientSpsPartyInstance, field: "trnsltRecipientSpsPartyId")}</g:link></td>
					
						<td>${fieldValue(bean: trnsltRecipientSpsPartyInstance, field: "codeList")}</td>
					
						<td>${fieldValue(bean: trnsltRecipientSpsPartyInstance, field: "ecsName")}</td>
					
						<td>${fieldValue(bean: trnsltRecipientSpsPartyInstance, field: "code")}</td>
					
						<td>${fieldValue(bean: trnsltRecipientSpsPartyInstance, field: "name")}</td>
					
						<td>${fieldValue(bean: trnsltRecipientSpsPartyInstance, field: "description")}</td>
					
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
				<g:paginate total="${trnsltRecipientSpsPartyInstanceCount ?: 0}" />
			</div>
		</div>
     
	</body>
</html>
