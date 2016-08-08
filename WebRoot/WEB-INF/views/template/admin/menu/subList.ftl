<div class="pageHeader">
	<form id="pagerForm" onsubmit="return navTabSearch(this);" action="${contextPath}/admin/menu/subList.do?navTabId=${(navTabId)!}" method="post">
	<input type="hidden" name="pager.pageNumber" value="${pager.pageNumber}" />
	<input type="hidden" name="pager.pageSize" value="${pager.pageSize}" />
	<input type="hidden" name="id" value="${id}" />
	<div class="searchBar">
		<table class="searchContent">
			<tr>
				<td>
					名称：<input type="text" id="searchName" name="search.name" value="${(search.name)!}" />
				</td>
				<td>
					编码：<input type="text" id="searchCode" name="search.code" value="${(search.code)!}" />
				</td>
			</tr>
		</table>
		<div class="subBar">
			<ul>
				<li><div class="buttonActive"><div class="buttonContent"><button type="submit">查 询</button></div></div></li>
			</ul>
		</div>
	</div>
	</form>
</div>
<div class="pageContent">
	<div class="panelBar">
		<ul class="toolBar">
		</ul>
	</div>
	<table class="table" width="100%" layoutH="138">
		<thead>
			<tr>
				<th width="80">序号</th>
				<th width="100">名称</th>
				<th width="80">编码</th>
				<th width="80">地址</th>
				<th width="80">排序</th>
				<th width="80">功能按钮</th>
			</tr>
		</thead>
		<tbody>
		    <#if (pager.results)??>
	        <#list pager.results as obj>
				<tr target="sid_user" rel="${(obj.id)!}">
					<td>${(obj_index + 1)!}</td>
					<td>${(obj.name)!}</td>
					<td>${(obj.code)!}</td>
					<td>${(obj.linkurl)!}</td>
					<td>${(obj.sortNo)!}</td>
					<td>
						<#if (obj.subPurviews)??&&(obj.subPurviews)?exists>
							<#list (obj.subPurviews)! as child>
	                       	 	<#if (child.type) == 2>	
	                        		  ${(child.name)!} 
	                        	</#if>
				            </#list>
						</#if>
					</td>
				</tr>
			 </#list>
			<#else>
        	    <tr>
                 	<td colspan="4" align="center">${action.getText("msg.no.data")}</td>
                </tr>
	        </#if>
		</tbody>
	</table>
	 <@a.pagination />  
</div>
