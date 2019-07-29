
<div class="col-lg-6">

  <div class="form-group fieldcontain ${hasErrors(bean: trnsltCommodityClassCodeInstance, field: 'trnsltCommodityClassCodeId', 'error')} required">
	<label for="trnsltCommodityClassCodeId">
		<g:message code="trnsltCommodityClassCode.trnsltCommodityClassCodeId.label" default="Commodity class code ID" />
		<span class="required-indicator">*</span>
	</label>
  </div>
                <div class="form-group">
	<g:field name="trnsltCommodityClassCodeId" type="number" max="2147483647" value="${trnsltCommodityClassCodeInstance.trnsltCommodityClassCodeId}" required=""/>

 
</div>
  <div class="form-group">
<div class="fieldcontain ${hasErrors(bean: trnsltCommodityClassCodeInstance, field: 'codeList', 'error')} required">
	<label for="codeList">
		<g:message code="trnsltCommodityClassCode.codeList.label" default="Code List" />
		<span class="required-indicator">*</span>
	</label>
</div></div>
  <div class="form-group">
	<g:textField name="codeList" maxlength="50" size="42"  required="" value="${trnsltCommodityClassCodeInstance?.codeList}"/>
 
</div>
  <div class="form-group">
 <div class="fieldcontain ${hasErrors(bean: trnsltCommodityClassCodeInstance, field: 'ecsName', 'error')} required"> 
	<label for="ecsName">
		<g:message code="trnsltCommodityClassCode.ecsName.label" default="Ecs Name" />
		<span class="required-indicator">*</span>
	</label>
</div></div>
  <div class="form-group">
	<g:textArea name="ecsName" cols="40" rows="5" maxlength="255" required="" value="${trnsltCommodityClassCodeInstance?.ecsName}"/>


</div>
</div>
<div class="col-lg-6">
  <div class="form-group">
<div class="fieldcontain ${hasErrors(bean: trnsltCommodityClassCodeInstance, field: 'code', 'error')} required">
	<label for="code">
		<g:message code="trnsltCommodityClassCode.code.label" default="Code" />
		<span class="required-indicator">*</span>
	</label>
</div></div>
  <div class="form-group">
	<g:textField name="code" maxlength="12" required="" value="${trnsltCommodityClassCodeInstance?.code}"/>


</div>
  <div class="form-group">
<div class="fieldcontain ${hasErrors(bean: trnsltCommodityClassCodeInstance, field: 'name', 'error')} required">
	<label for="name">
		<g:message code="trnsltCommodityClassCode.name.label" default="Name" />
		<span class="required-indicator">*</span>
	</label>
</div>
  <div class="form-group">
	<g:textArea name="name" cols="40" rows="5" maxlength="255" required="" value="${trnsltCommodityClassCodeInstance?.name}"/>

</div>
</div>
  <div class="form-group">
<div class="fieldcontain ${hasErrors(bean: trnsltCommodityClassCodeInstance, field: 'description', 'error')} required">
	<label for="description">
		<g:message code="trnsltCommodityClassCode.description.label" default="Description" />
		<span class="required-indicator">*</span>
	</label>
</div>
  <div class="form-group">
	<g:textArea name="description" cols="40" rows="5" maxlength="255" required="" value="${trnsltCommodityClassCodeInstance?.description}"/>

</div>
</div></div>

