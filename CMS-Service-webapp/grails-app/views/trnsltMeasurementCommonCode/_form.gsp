

<div class="col-lg-6">

<div class="form-group fieldcontain ${hasErrors(bean: trnsltMeasurementCommonCodeInstance, field: 'trnsltMeasurementCommonCodeId', 'error')} required">
	<label for="trnsltMeasurementCommonCodeId">
		<g:message code="trnsltMeasurementCommonCode.trnsltMeasurementCommonCodeId.label" default="Trnslt Measurement Common Code Id" />
		<span class="required-indicator">*</span>
	</label>
        <div class="form-group">
	<g:field name="trnsltMeasurementCommonCodeId" type="number" max="2147483647" value="${trnsltMeasurementCommonCodeInstance.trnsltMeasurementCommonCodeId}" required=""/>
        </div>
</div>

<div class="form-group fieldcontain ${hasErrors(bean: trnsltMeasurementCommonCodeInstance, field: 'codeList', 'error')} required">
	<label for="codeList">
		<g:message code="trnsltMeasurementCommonCode.codeList.label" default="Code List" />
		<span class="required-indicator">*</span>
	</label>
        <div class="form-group">
	<g:textField name="codeList" maxlength="25" required="" value="${trnsltMeasurementCommonCodeInstance?.codeList}"/>
        </div>
</div>

<div class="form-group fieldcontain ${hasErrors(bean: trnsltMeasurementCommonCodeInstance, field: 'ecsName', 'error')} required">
	<label for="ecsName">
		<g:message code="trnsltMeasurementCommonCode.ecsName.label" default="Ecs Name" />
		<span class="required-indicator">*</span>
	</label>
        <div class="form-group">
	<g:textArea name="ecsName" cols="40" rows="5" maxlength="255" required="" value="${trnsltMeasurementCommonCodeInstance?.ecsName}"/>
        </div>
</div>

<div class="form-group fieldcontain ${hasErrors(bean: trnsltMeasurementCommonCodeInstance, field: 'code', 'error')} required">
	<label for="code">
		<g:message code="trnsltMeasurementCommonCode.code.label" default="Code" />
		<span class="required-indicator">*</span>
	</label>
        <div class="form-group">
	<g:textField name="code" maxlength="5" required="" value="${trnsltMeasurementCommonCodeInstance?.code}"/>
        </div>
</div>
</div>
<div class="col-lg-6">

<div class="form-group fieldcontain ${hasErrors(bean: trnsltMeasurementCommonCodeInstance, field: 'name', 'error')} required">
	<label for="name">
		<g:message code="trnsltMeasurementCommonCode.name.label" default="Name" />
		<span class="required-indicator">*</span>
	</label>
        <div class="form-group">
	<g:textArea name="name" cols="40" rows="5" maxlength="255" required="" value="${trnsltMeasurementCommonCodeInstance?.name}"/>
        </div>
</div>

<div class="form-group fieldcontain ${hasErrors(bean: trnsltMeasurementCommonCodeInstance, field: 'description', 'error')} required">
	<label for="description">
		<g:message code="trnsltMeasurementCommonCode.description.label" default="Description" />
		<span class="required-indicator">*</span>
	</label>
        <div class="form-group">
	<g:textArea name="description" cols="40" rows="5" maxlength="500" required="" value="${trnsltMeasurementCommonCodeInstance?.description}"/>
        </div>
</div>
</div>
