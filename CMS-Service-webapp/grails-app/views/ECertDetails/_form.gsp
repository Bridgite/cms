



<div class="fieldcontain ${hasErrors(bean: ECertDetailsInstance, field: 'certFile', 'error')} required">
	<label for="certFile">
		<g:message code="ECertDetails.certFile.label" default="Cert File" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="certFile" required="" value="${ECertDetailsInstance?.certFile}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: ECertDetailsInstance, field: 'certNo', 'error')} required">
	<label for="certNo">
		<g:message code="ECertDetails.certNo.label" default="Cert No" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="certNo" required="" value="${ECertDetailsInstance?.certNo}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: ECertDetailsInstance, field: 'certStatus', 'error')} required">
	<label for="certStatus">
		<g:message code="ECertDetails.certStatus.label" default="Cert Status" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="certStatus" maxlength="20" required="" value="${ECertDetailsInstance?.certStatus}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: ECertDetailsInstance, field: 'statusDate', 'error')} ">
	<label for="statusDate">
		<g:message code="ECertDetails.statusDate.label" default="Status Date" />
		
	</label>
	<g:datePicker name="statusDate" precision="day"  value="${ECertDetailsInstance?.statusDate}" default="none" noSelection="['': '']" />

</div>

<div class="fieldcontain ${hasErrors(bean: ECertDetailsInstance, field: 'destinationCountry', 'error')} required">
	<label for="destinationCountry">
		<g:message code="ECertDetails.destinationCountry.label" default="Destination Country" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="destinationCountry" maxlength="5" required="" value="${ECertDetailsInstance?.destinationCountry}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: ECertDetailsInstance, field: 'dateOfIssue', 'error')} ">
	<label for="dateOfIssue">
		<g:message code="ECertDetails.dateOfIssue.label" default="Date Of Issue" />
		
	</label>
	<g:datePicker name="dateOfIssue" precision="day"  value="${ECertDetailsInstance?.dateOfIssue}" default="none" noSelection="['': '']" />

</div>

<div class="fieldcontain ${hasErrors(bean: ECertDetailsInstance, field: 'certType', 'error')} ">
	<label for="certType">
		<g:message code="ECertDetails.certType.label" default="Cert Type" />
		
	</label>
	<g:textField name="certType" value="${ECertDetailsInstance?.certType}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: ECertDetailsInstance, field: 'ECertStatusHistories', 'error')} ">
	<label for="ECertStatusHistories">
		<g:message code="ECertDetails.ECertStatusHistories.label" default="EC ert Status Histories" />
		
	</label>
	
<ul class="one-to-many">
<g:each in="${ECertDetailsInstance?.ECertStatusHistories?}" var="E">
    <li><g:link controller="ECertStatusHistory" action="show" id="${E.id}">${E?.encodeAsHTML()}</g:link></li>
</g:each>
<li class="add">
<g:link controller="ECertStatusHistory" action="create" params="['ECertDetails.id': ECertDetailsInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'ECertStatusHistory.label', default: 'ECertStatusHistory')])}</g:link>
</li>
</ul>


</div>

<div class="fieldcontain ${hasErrors(bean: ECertDetailsInstance, field: 'issuer', 'error')} required">
	<label for="issuer">
		<g:message code="ECertDetails.issuer.label" default="Issuer" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="issuer" required="" value="${ECertDetailsInstance?.issuer}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: ECertDetailsInstance, field: 'pdfCertFilePath', 'error')} required">
	<label for="pdfCertFilePath">
		<g:message code="ECertDetails.pdfCertFilePath.label" default="Pdf Cert File Path" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="pdfCertFilePath" required="" value="${ECertDetailsInstance?.pdfCertFilePath}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: ECertDetailsInstance, field: 'placeOfIssue', 'error')} required">
	<label for="placeOfIssue">
		<g:message code="ECertDetails.placeOfIssue.label" default="Place Of Issue" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="placeOfIssue" required="" value="${ECertDetailsInstance?.placeOfIssue}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: ECertDetailsInstance, field: 'signedXmlCertFilePath', 'error')} required">
	<label for="signedXmlCertFilePath">
		<g:message code="ECertDetails.signedXmlCertFilePath.label" default="Signed Xml Cert File Path" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="signedXmlCertFilePath" required="" value="${ECertDetailsInstance?.signedXmlCertFilePath}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: ECertDetailsInstance, field: 'xmlCertFilePath', 'error')} required">
	<label for="xmlCertFilePath">
		<g:message code="ECertDetails.xmlCertFilePath.label" default="Xml Cert File Path" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="xmlCertFilePath" required="" value="${ECertDetailsInstance?.xmlCertFilePath}"/>

</div>

