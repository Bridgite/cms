



<div class="fieldcontain ${hasErrors(bean: trnsltDocumentTypeInstance, field: 'codeList', 'error')} ">
	<label for="codeList">
		<g:message code="trnsltDocumentType.codeList.label" default="Code List" />
		
	</label>
	<g:textField name="codeList" maxlength="25" value="${trnsltDocumentTypeInstance?.codeList}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: trnsltDocumentTypeInstance, field: 'ecsName', 'error')} ">
	<label for="ecsName">
		<g:message code="trnsltDocumentType.ecsName.label" default="Ecs Name" />
		
	</label>
	<g:textField name="ecsName" maxlength="25" value="${trnsltDocumentTypeInstance?.ecsName}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: trnsltDocumentTypeInstance, field: 'code', 'error')} ">
	<label for="code">
		<g:message code="trnsltDocumentType.code.label" default="Code" />
		
	</label>
	<g:field name="code" type="number" value="${trnsltDocumentTypeInstance.code}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: trnsltDocumentTypeInstance, field: 'name', 'error')} ">
	<label for="name">
		<g:message code="trnsltDocumentType.name.label" default="Name" />
		
	</label>
	<g:textField name="name" maxlength="45" value="${trnsltDocumentTypeInstance?.name}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: trnsltDocumentTypeInstance, field: 'description', 'error')} ">
	<label for="description">
		<g:message code="trnsltDocumentType.description.label" default="Description" />
		
	</label>
	<g:textField name="description" value="${trnsltDocumentTypeInstance?.description}"/>

</div>

