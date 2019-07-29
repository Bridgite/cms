<div class="col-lg-6">

  <div class="form-group fieldcontain ${hasErrors(bean: trnsltEpptBotanicalNameInstance, field: 'trnsltEpptBotanicalNameId', 'error')} required">
	<label for="trnsltEpptBotanicalNameId">
		<g:message code="trnsltEpptBotanicalName.trnsltEpptBotanicalNameId.label" default="Trnslt Eppt Botanical Name Id" />
		<span class="required-indicator">*</span>
	</label>
        </div>
                <div class="form-group">
	<g:field name="trnsltEpptBotanicalNameId" type="number" max="2147483647" value="${trnsltEpptBotanicalNameInstance.trnsltEpptBotanicalNameId}" required=""/>

</div>

<div class="fieldcontain ${hasErrors(bean: trnsltEpptBotanicalNameInstance, field: 'codeList', 'error')} required">
	<label for="codeList">
		<g:message code="trnsltEpptBotanicalName.codeList.label" default="Code List" />
		<span class="required-indicator">*</span>
	</label>
        </div>
                <div class="form-group">
	<g:textField name="codeList" maxlength="25" required="" value="${trnsltEpptBotanicalNameInstance?.codeList}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: trnsltEpptBotanicalNameInstance, field: 'ecsName', 'error')} required">
	<label for="ecsName">
		<g:message code="trnsltEpptBotanicalName.ecsName.label" default="Ecs Name" />
		<span class="required-indicator">*</span>
	</label>
        </div>
                <div class="form-group">
	<g:textField name="ecsName" maxlength="45" required="" value="${trnsltEpptBotanicalNameInstance?.ecsName}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: trnsltEpptBotanicalNameInstance, field: 'code', 'error')} required">
	<label for="code">
		<g:message code="trnsltEpptBotanicalName.code.label" default="Code" />
		<span class="required-indicator">*</span>
	</label>
        </div>
                <div class="form-group">
	<g:textField name="code" maxlength="20" required="" value="${trnsltEpptBotanicalNameInstance?.code}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: trnsltEpptBotanicalNameInstance, field: 'fullName', 'error')} required">
	<label for="fullName">
		<g:message code="trnsltEpptBotanicalName.fullName.label" default="Full Name" />
		<span class="required-indicator">*</span>
	</label>
        </div>
                <div class="form-group">
	<g:textArea name="fullName" cols="40" rows="5" maxlength="255" required="" value="${trnsltEpptBotanicalNameInstance?.fullName}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: trnsltEpptBotanicalNameInstance, field: 'authority', 'error')} required">
	<label for="authority">
		<g:message code="trnsltEpptBotanicalName.authority.label" default="Authority" />
		<span class="required-indicator">*</span>
	</label>
        </div>
                <div class="form-group">
	<g:textArea name="authority" cols="40" rows="5" maxlength="255" required="" value="${trnsltEpptBotanicalNameInstance?.authority}"/>

</div>
</div>
<div class="col-lg-6">
<div class="fieldcontain ${hasErrors(bean: trnsltEpptBotanicalNameInstance, field: 'identifier', 'error')} required">
	<label for="identifier">
		<g:message code="trnsltEpptBotanicalName.identifier.label" default="Identifier" />
		<span class="required-indicator">*</span>
	</label>
        </div>
                <div class="form-group">
	<g:textField name="identifier" maxlength="12" required="" value="${trnsltEpptBotanicalNameInstance?.identifier}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: trnsltEpptBotanicalNameInstance, field: 'datatype', 'error')} required">
	<label for="datatype">
		<g:message code="trnsltEpptBotanicalName.datatype.label" default="Datatype" />
		<span class="required-indicator">*</span>
	</label>
                     </div>  
                <div class="form-group">

	<g:textField name="datatype" maxlength="5" required="" value="${trnsltEpptBotanicalNameInstance?.datatype}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: trnsltEpptBotanicalNameInstance, field: 'lang', 'error')} required">
	<label for="lang">
		<g:message code="trnsltEpptBotanicalName.lang.label" default="Lang" />
		<span class="required-indicator">*</span>
        </label></div>
                        <div class="form-group">

	<g:textField name="lang" maxlength="5" required="" value="${trnsltEpptBotanicalNameInstance?.lang}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: trnsltEpptBotanicalNameInstance, field: 'langno', 'error')} ">
	<label for="langno">
		<g:message code="trnsltEpptBotanicalName.langno.label" default="Langno" />
		
        </label></div>
                        <div class="form-group">

	<g:field name="langno" type="number" max="2147483647" value="${trnsltEpptBotanicalNameInstance.langno}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: trnsltEpptBotanicalNameInstance, field: 'preferred', 'error')} ">
	<label for="preferred">
		<g:message code="trnsltEpptBotanicalName.preferred.label" default="Preferred" />
		
        </label></div>
                        <div class="form-group">

	<g:field name="preferred" type="number" max="2147483647" value="${trnsltEpptBotanicalNameInstance.preferred}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: trnsltEpptBotanicalNameInstance, field: 'status', 'error')} required">
	<label for="status">
		<g:message code="trnsltEpptBotanicalName.status.label" default="Status" />
		<span class="required-indicator">*</span>
        </label></div>
                        <div class="form-group">

	<g:textField name="status" maxlength="5" required="" value="${trnsltEpptBotanicalNameInstance?.status}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: trnsltEpptBotanicalNameInstance, field: 'creation', 'error')} ">
	<label for="creation">
		<g:message code="trnsltEpptBotanicalName.creation.label" default="Creation" />
		
        </label></div>
                        <div class="form-group">

	<g:datePicker name="creation" precision="day"  value="${trnsltEpptBotanicalNameInstance?.creation}" default="none" noSelection="['': '']" />

</div>

<div class="fieldcontain ${hasErrors(bean: trnsltEpptBotanicalNameInstance, field: 'modification', 'error')} ">
	<label for="modification">
		<g:message code="trnsltEpptBotanicalName.modification.label" default="Modification" />
		
        </label></div>
                        <div class="form-group">

	<g:datePicker name="modification" precision="day"  value="${trnsltEpptBotanicalNameInstance?.modification}" default="none" noSelection="['': '']" />

</div>

<div class="fieldcontain ${hasErrors(bean: trnsltEpptBotanicalNameInstance, field: 'country', 'error')} required">
	<label for="country">
		<g:message code="trnsltEpptBotanicalName.country.label" default="Country" />
		<span class="required-indicator">*</span>
        </label></div>
                        <div class="form-group">

	<g:textArea name="country" cols="40" rows="5" maxlength="255" required="" value="${trnsltEpptBotanicalNameInstance?.country}"/>

</div>
</div>
