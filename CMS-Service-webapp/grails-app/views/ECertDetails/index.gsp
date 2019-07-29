


<!DOCTYPE html>
<html>
	<head><meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'ECertDetails.label', default: 'ECertDetails')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">e-Certificate  </h1>
                </div>
        </div>
	
            <!-- /.row -->
            <div class="row">
                <div class="col-lg-12">
                    <div class="panel panel-default">
                        <div class="panel-heading">
			E - Certificates
<!--<g:message code="default.list.label" args="[entityName]" />-->
                         </div>
			 
			 <div class="panel-body">
                            <div class="table-responsive">
                                <table class="table table-striped table-bordered table-hover" id="dataTables-ecert">
			<thead>
					<tr>
                                            
                                            <tr> 
						<g:sortableColumn property="certStatus" title="${message(code: 'ECertDetails.certStatus.label', default: 'Certificate No')}" />
					
						<g:sortableColumn property="statusDate" title="${message(code: 'ECertDetails.statusDate.label', default: 'Certificate No')}" />
					
						<g:sortableColumn property="destinationCountry" title="${message(code: 'ECertDetails.countryDestination.label', default: 'Certificate Status')}" />
					
						<g:sortableColumn property="certType" title="${message(code: 'ECertDetails.certType.label', default: 'Status date')}" />

						<g:sortableColumn property="certType" title="${message(code: 'ECertDetails.certType.label', default: 'Certificate details')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${ECertDetailsInstanceList}" status="i" var="ECertDetailsInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					 
						
					
						<td>${fieldValue(bean: ECertDetailsInstance, field: "certNo")}</td>
                                                <td>${fieldValue(bean: ECertDetailsInstance, field: "certFile")}</td>
					        <td>${fieldValue(bean: ECertDetailsInstance, field: "certStatus")}</td>
                                                <td> Show details</td>
				 
						 
					
						
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
           