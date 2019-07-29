

<div class="col-lg-6">

<div class="form-group fieldcontain ${hasErrors(bean: trnsltTransportmodeCodeInstance, field: 'trnsltTransportmodeCodeId', 'error')} required">
	<label for="trnsltTransportmodeCodeId">
		<g:message code="trnsltTransportmodeCode.trnsltTransportmodeCodeId.label" default="Trnslt Transportmode Code Id" />
		<span class="required-indicator">*</span>
	</label>
        <div class="form-group">
	<g:field name="trnsltTransportmodeCodeId" type="number" max="2147483647" value="${trnsltTransportmodeCodeInstance.trnsltTransportmodeCodeId}" required=""/>
        </div>
</div>

<div class="form-group fieldcontain ${hasErrors(bean: trnsltTransportmodeCodeInstance, field: 'codeList', 'error')} required">
	<label for="codeList">
		<g:message code="trnsltTransportmodeCode.codeList.label" default="Code List" />
		<span class="required-indicator">*</span>
	</label>
        <div class="form-group">
	<g:textField name="codeList" maxlength="25" required="" value="${trnsltTransportmodeCodeInstance?.codeList}"/>
        </div>
</div>

<div class="form-group fieldcontain ${hasErrors(bean: trnsltTransportmodeCodeInstance, field: 'ecsName', 'error')} ">
	<label for="ecsName">
		<g:message code="trnsltTransportmodeCode.ecsName.label" default="Ecs Name" />
		
	</label>
        <div class="form-group">
	<g:field name="ecsName" type="number" max="2147483647" value="${trnsltTransportmodeCodeInstance.ecsName}"/>
        </div>
</div>

<div class="form-group fieldcontain ${hasErrors(bean: trnsltTransportmodeCodeInstance, field: 'code', 'error')} ">
	<label for="code">
		<g:message code="trnsltTransportmodeCode.code.label" default="Code" />
		
	</label>
        <div class="form-group">
	<g:field name="code" type="number" max="2147483647" value="${trnsltTransportmodeCodeInstance.code}"/>
        </div>
</div>
</div>
<div class="col-lg-6">
<div class="form-group fieldcontain ${hasErrors(bean: trnsltTransportmodeCodeInstance, field: 'name', 'error')} required">
	<label for="name">
		<g:message code="trnsltTransportmodeCode.name.label" default="Name" />
		<span class="required-indicator">*</span>
	</label>
        <div class="form-group">
	<g:textField name="name" maxlength="45" required="" value="${trnsltTransportmodeCodeInstance?.name}"/>
</div>
</div>

<div class="form-group fieldcontain ${hasErrors(bean: trnsltTransportmodeCodeInstance, field: 'description', 'error')} required">
	<label for="description">
		<g:message code="trnsltTransportmodeCode.description.label" default="Description" />
		<span class="required-indicator">*</span>
	</label>
        <div class="form-group">
	<g:textArea name="description" cols="40" rows="5" maxlength="255" required="" value="${trnsltTransportmodeCodeInstance?.description}"/>
        </div>
</div>
</div>

