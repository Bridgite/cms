

<div class="col-lg-6">

<div class="form-group fieldcontain ${hasErrors(bean: trnsltCountryIsoCodeInstance, field: 'trnsltCountryIsoCodeId', 'error')} required">
	<label for="trnsltCountryIsoCodeId">
		<g:message code="trnsltCountryIsoCode.trnsltCountryIsoCodeId.label" default="Trnslt Country Iso Code Id" />
		<span class="required-indicator">*</span>
	</label>
             <div class="form-group">
	<g:field name="trnsltCountryIsoCodeId" type="number" max="2147483647" value="${trnsltCountryIsoCodeInstance.trnsltCountryIsoCodeId}" required=""/>
             </div>
</div>

<div class="form-group fieldcontain ${hasErrors(bean: trnsltCountryIsoCodeInstance, field: 'ecsName', 'error')} required">
	<label for="ecsName">
		<g:message code="trnsltCountryIsoCode.ecsName.label" default="Ecs Name" />
		<span class="required-indicator">*</span>
	</label>
             <div class="form-group">
	<g:textField name="ecsName" maxlength="45" required="" size="45" value="${trnsltCountryIsoCodeInstance?.ecsName}"/>
             </div>
</div>

<div class="form-group fieldcontain ${hasErrors(bean: trnsltCountryIsoCodeInstance, field: 'isoCode', 'error')} required">
	<label for="isoCode">
		<g:message code="trnsltCountryIsoCode.isoCode.label" default="Iso Code" />
		<span class="required-indicator">*</span>
	</label>
             <div class="form-group">
	<g:textField name="isoCode" maxlength="5" required="" value="${trnsltCountryIsoCodeInstance?.isoCode}"/>
             </div>
</div>
</div>
<div class="col-lg-6">

<div class="form-group fieldcontain ${hasErrors(bean: trnsltCountryIsoCodeInstance, field: 'description', 'error')} required">
	<label for="description">
		<g:message code="trnsltCountryIsoCode.description.label" default="Description" />
		<span class="required-indicator">*</span>
	</label>
             <div class="form-group">
	<g:textField name="description" maxlength="45" size="45" required="" value="${trnsltCountryIsoCodeInstance?.description}"/>
             </div>
</div>

<div class="form-group fieldcontain ${hasErrors(bean: trnsltCountryIsoCodeInstance, field: 'primaryKeyColumn', 'error')} required">
	<label for="primaryKeyColumn">
		<g:message code="trnsltCountryIsoCode.primaryKeyColumn.label" default="Primary Key Column" />
		<span class="required-indicator">*</span>
	</label>
             <div class="form-group">
	<g:field name="primaryKeyColumn" type="number" max="2147483647" value="${trnsltCountryIsoCodeInstance.primaryKeyColumn}" required=""/>
             </div>
</div>

<div class="form-group fieldcontain ${hasErrors(bean: trnsltCountryIsoCodeInstance, field: 'twoCharIsoCode', 'error')} required">
	<label for="twoCharIsoCode">
		<g:message code="trnsltCountryIsoCode.twoCharIsoCode.label" default="Two Char Iso Code" />
		<span class="required-indicator">*</span>
	</label>
             <div class="form-group">
	<g:textField name="twoCharIsoCode" maxlength="5" required="" value="${trnsltCountryIsoCodeInstance?.twoCharIsoCode}"/>
             </div>
</div>
</div>
