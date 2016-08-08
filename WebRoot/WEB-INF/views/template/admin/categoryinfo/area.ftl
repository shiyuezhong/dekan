<link rel="stylesheet" type="text/css" href="${contextPath}/js/tree_themes/SimpleTree.css"/>
<script type="text/javascript" src="${contextPath}/js/tree_themes/SimpleTree.js"></script>
<script type="text/javascript">
$(function(){
	$(".st_tree").SimpleTree({
		click:function(a){
		}
	});
});
</script>
<div class="pageContent"  style="position:absolute; height:600px; width:100%;overflow:auto">
	 <div class="st_tree">
		<ul>
			<li><a href="#">中国</a></li>
			<#if (pager.results)??>
			 <ul>
		         <#list pager.results as obj>
						<li><a href="#">${(obj.name)!}</a></li>
						<#if (obj.subCategoryInfos)??&&(obj.subCategoryInfos)?exists && (obj.subCategoryInfos?size > 0)>
						    <ul>
								<#list (obj.subCategoryInfos)! as child>
		                        		<li><a href="#">${(child.name)!}</a></li>
							                <#if (child.subCategoryInfos)??&&(child.subCategoryInfos)?exists && (child.subCategoryInfos?size > 0)>
											    <ul>
													<#list (child.subCategoryInfos)! as child1>
							                        		<li><a href="#">${(child1.name)!}</a></li>
										            </#list>
											    </ul>
											</#if>
					            </#list>
						    </ul>
						</#if>
				 </#list>
			 </ul>
	        </#if>
		</ul>
	 </div>
	</table>
</div>
