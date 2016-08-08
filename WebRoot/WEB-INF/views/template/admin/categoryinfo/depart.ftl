<link rel="stylesheet" type="text/css" href="${contextPath}/js/tree_themes/SimpleTree.css"/>
<script type="text/javascript" src="${contextPath}/js/tree_themes/SimpleTree.js"></script>
<script type="text/javascript">
$(function(){
	$(".st_tree").SimpleTree({
		click:function(a){
		}
	});
});

function add(obj,pid){
    $(obj).parent().parent().find("ul").eq(0).append("<li class='folder'><a><input type='text' onblur='saveDepart(this,"+pid+")'/></a></li>");
}

function saveDepart(obj,pid){
    if($(obj).val() == "" || pid == ""){
 	     $(obj).parent().remove();
         return;
    }
	//保存
	$.ajax({
		url : '${contextPath}/admin/categoryinfo/saveCategoryInfo.do?id=' + pid+'&name='+ $(obj).val(),
		type : 'POST',
		async : false,
		dataType : "json",
		async : false,
		data : null,
		success : function(data) {
			$(obj).parent().html($(obj).val());
		}
	});
}

</script>
<div class="panelBar">
		<ul class="toolBar">
			<li><a class="add" href="${contextPath}/admin/categoryinfo/add.do?navTabId=${(navTabId)!}" target="navTab" rel="adddepart" title="添加"><span>添加</span></a></li>
		    <li class="line">line</li>
			<li><a class="edit" href="${contextPath}/admin/categoryinfo/departList.do?navTabId=${(navTabId)!}" target="navTab" rel="editdepart" title="查看"><span>查看</span></a></li>
		</ul>
</div>
<div class="pageContent"  style="position:absolute; height:600px; width:100%;overflow:auto">
	 <div class="st_tree">
		<ul>
			<#if (pager.results)??>
		         <#list pager.results as obj>
						<li><a href="#">${(obj.name)!}</a></li>
						<#if (obj.subCategoryInfos)??&&(obj.subCategoryInfos)?exists>
						    <ul>
								<#list (obj.subCategoryInfos)! as child>
		                        		<li><a href="#">${(child.name)!}</a></li>
							                <#if (child.subCategoryInfos)??&&(child.subCategoryInfos)?exists && (child.subCategoryInfos?size > 0)>
											    <ul>
													<#list (child.subCategoryInfos)! as child1>
							                        		<li><a href="#">${(child1.name)!}</a>   <span style="display:none;" onclick="add(this,${(child1.id)});">&nbsp;&nbsp;+</span></li>
							                        		<#if (child1.subCategoryInfos)??&&(child1.subCategoryInfos)?exists && (child1.subCategoryInfos?size > 0)>
															    <ul>
																	<#list (child1.subCategoryInfos)! as child2>
											                        		<li><a href="#">${(child2.name)!}</a>  <span style="display:none;" onclick="add(this,${(child2.id)});">&nbsp;&nbsp;+</span></li>
											                        		<#if (child2.subCategoryInfos)??&&(child2.subCategoryInfos)?exists && (child2.subCategoryInfos?size > 0)>
																			    <ul>
																					<#list (child2.subCategoryInfos)! as child3>
															                        		<li><a href="#">${(child3.name)!}</a>  <span style="display:none;" onclick="add(this,${(child3.id)});">&nbsp;&nbsp;+</span></li>
															                        		<#if (child3.subCategoryInfos)??&&(child3.subCategoryInfos)?exists && (child3.subCategoryInfos?size > 0)>
																							    <ul>
																									<#list (child3.subCategoryInfos)! as child4>
																			                        		<li><a href="#">${(child4.name)!}</a></li>
																						            </#list>
																							    </ul>
																							</#if>
																		            </#list>
																			    </ul>
																			</#if>
														            </#list>
															    </ul>
															</#if>
										            </#list>
											    </ul>
											</#if>
					            </#list>
						    </ul>
						</#if>
				 </#list>
	        </#if>
		</ul>
	 </div>
	</table>
</div>
