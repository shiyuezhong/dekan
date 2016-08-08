<div class="pageContent">
	<form method="post" action="${contextPath}/admin/user/<#if isAddAction>save<#else><#if result??>update<#else>save</#if></#if>.do" class="pageForm required-validate" onsubmit="return validateCallback(this, navTabAjaxDone);">
		<input type="hidden" name="form.id" value="${(result.id)!}" />
		<input type="hidden" name="navTabId" value="${(navTabId)!}" />
		<div class="pageFormContent" layoutH="57">
		    <#if (roleList)??>
			    <div class="divider"></div>
			    <dl class="nowrap">
					<dt>所属角色：</dt>
					<dd> 
					   <select class="combox required" name="form.userRoleProp.roleId" ref="w_combox_city">
							<option value="">请选择角色</option>
							<#list roleList as role>
							 <option value="${role.id}" <#if (result.userRoleProp.roleId)??><#if role.id == result.userRoleProp.roleId>selected</#if></#if>>${role.name}</option>
							</#list>
					   </select>
					</dd>
				</dl>
	        </#if>
			<div class="divider"></div>
			<dl class="nowrap">
				<dt>${action.getText("user.userName")}：</dt>
				<dd><input type="text" name="form.userName" value="${(result.userName)!}"  size="30" class="required"  remote="${contextPath}/admin/user/findByUn.do?id=${(id)!}"/></dd>
			</dl>
			<div class="divider"></div>
			<dl class="nowrap">
				<dt>${action.getText("user.name")}：</dt>
				<dd><input type="text" name="form.name" value="${(result.name)!}"  size="30" class="required"/></dd>
			</dl>
			<#if isAddAction>
				<div class="divider"></div>
				<dl class="nowrap">
					<dt>${action.getText("user.password")}：</dt>
					<dd><input type="password" name="form.password" id="password" value="${(result.password)!}"  size="30"  class="required alphanumeric" minlength="6" maxlength="20" alt="字母、数字、下划线 6-20位"/></dd>
				</dl>
				<div class="divider"></div>
				<dl class="nowrap">
					<dt>确认密码：</dt>
					<dd><input  type="password" name="repassword" class="required" equalto="#password" size="30" /></dd>
				</dl>
			</#if>
			<div class="divider"></div>
			<dl class="nowrap">
				<dt>${action.getText("user.email")}：</dt>
				<dd><input type="text" name="form.email" value="${(result.email)!}"  size="30" class="required email"/></dd>
			</dl>
			<div class="divider"></div>
			<dl class="nowrap">
				<dt>${action.getText("user.mobile")}：</dt>
				<dd><input type="text" name="form.mobile" value="${(result.mobile)!}"  size="30" class="required phone"/></dd>
			</dl>
			<div class="divider"></div>
			<dl class="nowrap">
				<dt>状态：</dt>
				<dd>
				<label><input type="radio" value="1" name="form.accountEnabled" <#if result?exists&&(result.isAccountEnabled)?exists&&(result.isAccountEnabled)??&&result.isAccountEnabled.value==1>checked="checked"</#if>/>启用</label>
				<label><input type="radio" value="0" name="form.accountEnabled" <#if result?exists&&(result.isAccountEnabled)?exists&&(result.isAccountEnabled)??&&result.isAccountEnabled.value==0>checked="checked"</#if>/>禁用</label>
				</dd>
			</dl>
			<div class="divider"></div>
			<div class="divider"></div>
			<dl class="nowrap">
				<dt>最新修改时间：</dt>
				<dd>
				<input type="text" name="date12" class="date" value="${(result.modifyDate?string("yyyy-MM-dd HH:mm:ss"))!}" dateFmt="yyyy-MM-dd HH:mm:ss" readonly="true"/>
				<a class="inputDateButton" href="javascript:;">选择</a></dd>
			</dl>
			<div class="divider"></div>
			<dl class="nowrap">
				<dt>最新修改人员：</dt>
				<dd><input readonly="readonly" type="text" size="30" value="${(admin.userName)!}" /></dd>
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
