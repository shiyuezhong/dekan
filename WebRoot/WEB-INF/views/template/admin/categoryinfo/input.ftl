<div class="pageContent">
	<form method="post" action="${contextPath}/admin/categoryinfo/saveDepart.do" class="pageForm required-validate" onsubmit="return validateCallback(this, navTabAjaxDone);">
		<input type="hidden" name="form.id" value="${(result.id)!}" />
		<input type="hidden" name="navTabId" value="${(navTabId)!}" />
		<div class="pageFormContent" layoutH="57">
			<div class="divider"></div>
			<dl class="nowrap">
				<dt>部门名称：</dt>
				<dd><input type="text" name="form.name" value="${(result.name)!}"  size="30" class="required"/></dd>
			</dl>
			<div class="divider"></div>
			<dl class="nowrap">
				<dt>部门编码：</dt>
				<dd><input type="text" name="form.code" value="${(result.code)!}"  size="30" class="required"/></dd>
			</dl>
			<div class="divider"></div>
			<input type="hidden" name="form.parent.id" id="parentId" value=""/>
			<dl class="nowrap">
				<dt>所属上级：</dt>
				<dd>
					  <#if (selectList)??>
							   <select class="combox required" onchange="selectDepart(this,1)">
									<option value="">请选择上级</option>
									<#list selectList as depart>
										 <option value="${depart.id}">${depart.name}</option>
									</#list>
							   </select>
				      </#if>
				</dd>
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
<script type="text/javascript">
 

function selectDepart(obj,type){
    if(type == 1){
        //先删除下级
	    $(obj).parent().parent().nextAll().remove(); 
    }else{
    	//先删除下级
	    $(obj).nextAll().remove(); 
    }
    if($(obj).val() == ""){
 	     return
    }
    $("#parentId").val($(obj).val());
	//查找下一级
	$.ajax({
		url : '${contextPath}/admin/categoryinfo/childCategoryInfo.do?id=' + $(obj).val(),
		type : 'POST',
		async : false,
		dataType : "json",
		async : false,
		data : null,
		success : function(data) {
			 if(data != null && data.length > 0){
				 var options = "<option value=''>请选择上级</option>";					
			     for(var i=0;i<data.length;i++){
			         options = options + "<option value='"+data[i].id+"'>"+data[i].name+"</option>";
				 }
				 if(type == 1){
				 	$(obj).parent().parent().parent().parent().find("dd").append("<select class='combox required' onchange='selectDepart(this,2)'>"+options+"</select>");
				 }else{
				 	$(obj).parent().append("<select class='combox required' onchange='selectDepart(this,2)'>"+options+"</select>");
				 }	
			 }
		}
	});
}

</script>

