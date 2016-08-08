<div class="pageContent">
    <form method="post" action="${contextPath}/admin/user/savepurview.do" class="pageForm required-validate" onsubmit="return validateCallback(this, navTabAjaxDone);">
    <input type="hidden" name="id" value="${id}"/>
    <table class="table" width="100%" layoutH="40">
        <tbody>
			<#if (mainPurviews)??>
			<#list mainPurviews as pur>
			   <tr>
					<td  rowspan="${(pur.subPurviews)?size+1}" width="300px">
					<input type="checkbox" name="purviewIds" <#if purviewIdMap.get('${pur.id}') != null>checked="checked"</#if> onclick="checkPurView(this,1,${pur.id})" class="parent${pur.id}" value="${pur.id}"/>
					${(pur.name)!}     
					</td> 
					<#if (pur.subPurviews)??&&(pur.subPurviews)?exists>
							<#list (pur.subPurviews)! as child>
			               	 	<#if (child.type) == 1>	
			                		 <tr>
				                		 <td width="150px"><input type="checkbox" name="purviewIds" <#if purviewIdMap.get('${child.id}') != null>checked="checked"</#if> onclick="checkPurView(this,2,${pur.id})" class="pur${pur.id}" value="${child.id}"/>${(child.name)!}</td> 
				        		         <#if (child.subPurviews)??&&(child.subPurviews)?exists>
				        		         	<td>
												<#list (child.subPurviews)! as function>
												      <#if (function.type) == 2>
												            <input type="checkbox" name="purviewIds" <#if purviewIdMap.get('${function.id}') != null>checked="checked"</#if> onclick="checkPurView(this,3,${pur.id})" class="pur${pur.id}" value="${function.id}"/>${(function.name)!}&nbsp;
												      </#if>	
						                        </#list>
						                    </td>
										 </#if>
									 </tr>
			                	</#if>
				            </#list>
					</#if>
				</tr>
				<tr><td colspan="3"></td></tr>
		    </#list>
			<#else>
			    <tr>
		         	<td colspan="3" align="center">${action.getText("msg.no.data")}</td>
		        </tr>
		    </#if>
		</tbody>
	</table>
	<div class="formBar">
			<ul>
				<li><div class="buttonActive"><div class="buttonContent"><button type="submit">保存</button></div></div></li>
				<li><div class="button"><div class="buttonContent"><button type="button" class="close">取消</button></div></div></li>
			</ul>
	</div>
	</form>
</div>

<script>
//保存
function save(){
    var purViewIds = "";
	$("input:checkbox").each(function() {
 		if($(this).attr("checked")) { 
 				purViewIds = purViewIds + $(this).val() + ","; 
 		} 
	});
	alert(purViewIds);
}

//选中
function checkPurView(obj,type,childclass){
   var purclass = 'pur'+childclass;
   if(type == 1){
         if($(obj).is(':checked')){
	   		 $("."+purclass).attr("checked","checked");
         }else{
	   		 $("."+purclass).attr("checked",false);
         }
   }else if(type == 2){
   		 if($(obj).is(':checked')){
   		      $(obj).parent().parent().parent().find("."+purclass).attr("checked","checked");
   		      var parentclass = 'parent'+childclass;
   		      $("."+parentclass).attr("checked","checked");
   		 }else{
   			  $(obj).parent().parent().parent().find("."+purclass).attr("checked",false);
   		 }
   }else if(type == 3){
   		 if($(obj).is(':checked')){
   		      $(obj).parent().parent().prev().find("."+purclass).attr("checked","checked");
   		      var parentclass = 'parent'+childclass;
   		      $("."+parentclass).attr("checked","checked");
   		 }
   }
}
</script>
