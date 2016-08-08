
<div class="pageContent">
	
	<form method="post" action="${contextPath}/admin/user/password.do" class="pageForm required-validate" onsubmit="return validateCallback(this, dialogAjaxDone)">
		 <input type="hidden" name="id" value="${(admin.id)!}" />
		<div class="pageFormContent" layoutH="58">

			<div class="unit">
				<label>旧密码：</label>
				<input type="password" name="password" size="30" minlength="6" maxlength="20" class="required" />
			</div>
			<div class="unit">
				<label>新密码：</label>
				<input type="password" id="newPassword" name="newPassword" size="30" minlength="6" maxlength="20" class="required alphanumeric"  alt="字母、数字、下划线 6-20位"/>
			</div>
			<div class="unit">
				<label>重复新密码：</label>
				<input type="password" name="repassword" size="30" equalTo="#newPassword" class="required alphanumeric"/>
			</div>
			
		</div>
		<div class="formBar">
			<ul>
				<li><div class="buttonActive"><div class="buttonContent"><button type="submit">提交</button></div></div></li>
				<li><div class="button"><div class="buttonContent"><button type="button" class="close">取消</button></div></div></li>
			</ul>
		</div>
	</form>
	
</div>
