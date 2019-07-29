

<div class="col-lg-6">

<div class="form-group fieldcontain ${hasErrors(bean: trnsltPackageTypeCodeInstance, field: 'trnsltPackageTypeCodeId', 'error')} required">
	<label for="trnsltPackageTypeCodeId">
		<g:message code="trnsltPackageTypeCode.trnsltPackageTypeCodeId.label" default="Trnslt Package Type Code Id" />
		<span class="required-indicator">*</span>
	</label>
        <div class="form-group">
	<g:field name="trnsltPackageTypeCodeId" type="number" max="2147483647" value="${trnsltPackageTypeCodeInstance.trnsltPackageTypeCodeId}" required=""/>
        </div>
</div>

<div class="form-group fieldcontain ${hasErrors(bean: trnsltPackageTypeCodeInstance, field: 'codeList', 'error')} required">
	<label for="codeList">
		<g:message code="trnsltPackageTypeCode.codeList.label" default="Code List" />
		<span class="required-indicator">*</span>
	</label>
        <div class="form-group">
	<g:textField name="codeList" maxlength="25" required="" value="${trnsltPackageTypeCodeInstance?.codeList}"/>
        </div>
</div>

<div class="form-group fieldcontain ${hasErrors(bean: trnsltPackageTypeCodeInstance, field: 'ecsName', 'error')} required">
	<label for="ecsName">
		<g:message code="trnsltPackageTypeCode.ecsName.label" default="Ecs Name" />
		<span class="required-indicator">*</span>
	</label>
        <div class="form-group">
	<g:textArea name="ecsName" cols="40" rows="5" maxlength="255" required="" value="${trnsltPackageTypeCodeInstance?.ecsName}"/>
        </div>
</div>
</div>
<div class="col-lg-6">
<div class="form-group fieldcontain ${hasErrors(bean: trnsltPackageTypeCodeInstance, field: 'code', 'error')} required">
	<label for="code">
		<g:message code="trnsltPackageTypeCode.code.label" default="Code" />
		<span class="required-indicator">*</span>
	</label>
        <div class="form-group">
	<g:textField name="code" maxlength="5" required="" value="${trnsltPackageTypeCodeInstance?.code}"/>
        </div>
</div>

<div class="form-group fieldcontain ${hasErrors(bean: trnsltPackageTypeCodeInstance, field: 'name', 'error')} required">
	<label for="name">
		<g:message code="trnsltPackageTypeCode.name.label" default="Name" />
		<span class="required-indicator">*</span>
	</label>
        <div class="form-group">
	<g:textArea name="name" cols="40" rows="5" maxlength="255" required="" value="${trnsltPackageTypeCodeInstance?.name}"/>
        </div>
</div>

<div class="form-group fieldcontain ${hasErrors(bean: trnsltPackageTypeCodeInstance, field: 'description', 'error')} required">
	<label for="description">
		<g:message code="trnsltPackageTypeCode.description.label" default="Description" />
		<span class="required-indicator">*</span>
	</label>
        <div class="form-group">
	<g:textArea name="description" cols="40" rows="5" maxlength="255" required="" value="${trnsltPackageTypeCodeInstance?.description}"/>
        </div>
</div>
</div>

