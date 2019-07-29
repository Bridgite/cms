

<div class="col-lg-6">

<div class="form-group fieldcontain ${hasErrors(bean: trnsltUnLocodeInstance, field: 'trnsltUnLocodeId', 'error')} required">
	<label for="trnsltUnLocodeId">
		<g:message code="trnsltUnLocode.trnsltUnLocodeId.label" default="Trnslt Un Locode Id" />
		<span class="required-indicator">*</span>
	</label>
        <div class="form-group">
	<g:field name="trnsltUnLocodeId" type="number" max="2147483647" value="${trnsltUnLocodeInstance.trnsltUnLocodeId}" required=""/>
        </div>
</div>

<div class="form-group fieldcontain ${hasErrors(bean: trnsltUnLocodeInstance, field: 'codeList', 'error')} required">
	<label for="codeList">
		<g:message code="trnsltUnLocode.codeList.label" default="Code List" />
		<span class="required-indicator">*</span>
	</label>
        <div class="form-group">
	<g:textField name="codeList" maxlength="12" required="" value="${trnsltUnLocodeInstance?.codeList}"/>
        </div>
</div>

<div class="form-group fieldcontain ${hasErrors(bean: trnsltUnLocodeInstance, field: 'ecsName', 'error')} required">
	<label for="ecsName">
		<g:message code="trnsltUnLocode.ecsName.label" default="Ecs Name" />
		<span class="required-indicator">*</span>
	</label>
        <div class="form-group">
	<g:textArea name="ecsName" cols="40" rows="5" maxlength="255" required="" value="${trnsltUnLocodeInstance?.ecsName}"/>
        </div>
</div>
</div>
<div class="col-lg-6">
<div class="form-group fieldcontain ${hasErrors(bean: trnsltUnLocodeInstance, field: 'code', 'error')} required">
	<label for="code">
		<g:message code="trnsltUnLocode.code.label" default="Code" />
		<span class="required-indicator">*</span>
	</label>
        <div class="form-group">
	<g:textField name="code" maxlength="5" required="" value="${trnsltUnLocodeInstance?.code}"/>
        </div>
</div>

<div class="form-group fieldcontain ${hasErrors(bean: trnsltUnLocodeInstance, field: 'iso', 'error')} required">
	<label for="iso">
		<g:message code="trnsltUnLocode.iso.label" default="Iso" />
		<span class="required-indicator">*</span>
	</label>
        <div class="form-group">
	<g:textField name="iso" maxlength="5" required="" value="${trnsltUnLocodeInstance?.iso}"/>
        </div>
</div>

<div class="form-group fieldcontain ${hasErrors(bean: trnsltUnLocodeInstance, field: 'city', 'error')} required">
	<label for="city">
		<g:message code="trnsltUnLocode.city.label" default="City" />
		<span class="required-indicator">*</span>
	</label>
        <div class="form-group">
	<g:textField name="city" maxlength="5" required="" value="${trnsltUnLocodeInstance?.city}"/>
        </div>
</div>

<div class="form-group fieldcontain ${hasErrors(bean: trnsltUnLocodeInstance, field: 'nameDiacritic', 'error')} required">
	<label for="nameDiacritic">
		<g:message code="trnsltUnLocode.nameDiacritic.label" default="Name Diacritic" />
		<span class="required-indicator">*</span>
	</label>
        <div class="form-group">
	<g:textArea name="nameDiacritic" cols="40" rows="5" maxlength="255" required="" value="${trnsltUnLocodeInstance?.nameDiacritic}"/>
        </div>
</div>
</div>

