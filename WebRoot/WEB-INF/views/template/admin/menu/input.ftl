<div class="pageContent">
	<form method="post" action="${contextPath}/admin/menu/<#if isAddAction>save<#else><#if result??>update<#else>save</#if></#if>.do" class="pageForm required-validate" onsubmit="return validateCallback(this, navTabAjaxDone);">
		<input type="hidden" name="form.id" value="${(result.id)!}" />
		<input type="hidden" name="navTabId" value="${(navTabId)!}" />
		<div class="pageFormContent" layoutH="57">
			<div class="divider"></div>
			<dl class="nowrap">
				<dt>名称：</dt>
				<dd><input type="text" name="form.name" value="${(result.name)!}"  size="30" class="required"/></dd>
			</dl>
			<div class="divider"></div>
			<dl class="nowrap">
				<dt>编码：</dt>
				<dd><input type="text" name="form.code" value="${(result.code)!}"  size="30" class="required"/></dd>
			</dl>
			<div class="divider"></div>
		</div>
		<div class="formBar">
			<ul>
				<li><div class="buttonActive"><div class="buttonContent"><button type="submit">保存</button></div></div></li>
				<li><div class="button"><div class="buttonContent"><button type="reset">重置</button></div></div></li>
				<li><div class="button"><div class="buttonContent"><button type="button" class="close">取消</button></div></div></li>
			</ul>
		</div>
	</form>
</div>
