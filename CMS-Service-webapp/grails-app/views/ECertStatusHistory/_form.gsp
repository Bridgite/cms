



<div class="fieldcontain ${hasErrors(bean: ECertStatusHistoryInstance, field: 'certStatus', 'error')} ">
	<label for="certStatus">
		<g:message code="ECertStatusHistory.certStatus.label" default="Cert Status" />
		
	</label>
	<g:textField name="certStatus" maxlength="45" value="${ECertStatusHistoryInstance?.certStatus}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: ECertStatusHistoryInstance, field: 'statusDate', 'error')} ">
	<label for="statusDate">
		<g:message code="ECertStatusHistory.statusDate.label" default="Status Date" />
		
	</label>
	<g:datePicker name="statusDate" precision="day"  value="${ECertStatusHistoryInstance?.statusDate}" default="none" noSelection="['': '']" />

</div>

<div class="fieldcontain ${hasErrors(bean: ECertStatusHistoryInstance, field: 'reason', 'error')} ">
	<label for="reason">
		<g:message code="ECertStatusHistory.reason.label" default="Reason" />
		
	</label>
	<g:textField name="reason" maxlength="45" value="${ECertStatusHistoryInstance?.reason}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: ECertStatusHistoryInstance, field: 'ECertDetails', 'error')} required">
	<label for="ECertDetails">
		<g:message code="ECertStatusHistory.ECertDetails.label" default="EC ert Details" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="ECertDetails" name="ECertDetails.id" from="${ECertDetails.list()}" optionKey="id" required="" value="${ECertStatusHistoryInstance?.ECertDetails?.id}" class="many-to-one"/>

</div>

