

<div class="col-lg-6">
<div class="form-group  fieldcontain ${hasErrors(bean: trnsltRecipientSpsPartyInstance, field: 'trnsltRecipientSpsPartyId', 'error')} required">
	<label for="trnsltRecipientSpsPartyId">
		<g:message code="trnsltRecipientSpsParty.trnsltRecipientSpsPartyId.label" default="Trnslt Recipient Sps Party Id" />
		<span class="required-indicator">*</span>
	</label>
        <div class="form-group">
	<g:field name="trnsltRecipientSpsPartyId" type="number" max="2147483647" value="${trnsltRecipientSpsPartyInstance.trnsltRecipientSpsPartyId}" required=""/>
        </div>
</div>

<div class="form-group  fieldcontain ${hasErrors(bean: trnsltRecipientSpsPartyInstance, field: 'codeList', 'error')} required">
	<label for="codeList">
		<g:message code="trnsltRecipientSpsParty.codeList.label" default="Code List" />
		<span class="required-indicator">*</span>
	</label>
        <div class="form-group">
	<g:textField name="codeList" maxlength="25" required="" value="${trnsltRecipientSpsPartyInstance?.codeList}"/>
        </div>
</div>

<div class="form-group  fieldcontain ${hasErrors(bean: trnsltRecipientSpsPartyInstance, field: 'ecsName', 'error')} required">
	<label for="ecsName">
		<g:message code="trnsltRecipientSpsParty.ecsName.label" default="Ecs Name" />
		<span class="required-indicator">*</span>
	</label>
        <div class="form-group">
	<g:textArea name="ecsName" cols="40" rows="5" maxlength="255" required="" value="${trnsltRecipientSpsPartyInstance?.ecsName}"/>
        </div>
</div>

<div class="form-group  fieldcontain ${hasErrors(bean: trnsltRecipientSpsPartyInstance, field: 'code', 'error')} required">
	<label for="code">
		<g:message code="trnsltRecipientSpsParty.code.label" default="Code" />
		<span class="required-indicator">*</span>
	</label>
        <div class="form-group">
	<g:textField name="code" maxlength="5" required="" value="${trnsltRecipientSpsPartyInstance?.code}"/>
        </div>
</div>
</div>
<div class="col-lg-6">
<div class="form-group  fieldcontain ${hasErrors(bean: trnsltRecipientSpsPartyInstance, field: 'name', 'error')} required">
	<label for="name">
		<g:message code="trnsltRecipientSpsParty.name.label" default="Name" />
		<span class="required-indicator">*</span>
	</label>
        <div class="form-group">
	<g:textArea name="name" cols="40" rows="5" maxlength="255" required="" value="${trnsltRecipientSpsPartyInstance?.name}"/>
        </div>
</div>

<div class="form-group  fieldcontain ${hasErrors(bean: trnsltRecipientSpsPartyInstance, field: 'description', 'error')} required">
	<label for="description">
		<g:message code="trnsltRecipientSpsParty.description.label" default="Description" />
		<span class="required-indicator">*</span>
	</label>
        <div class="form-group">
	<g:textArea name="description" cols="40" rows="5" maxlength="255" required="" value="${trnsltRecipientSpsPartyInstance?.description}"/>
        </div>
</div>
</div>
