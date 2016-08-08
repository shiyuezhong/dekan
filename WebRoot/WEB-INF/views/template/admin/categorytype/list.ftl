<div class="pageHeader">
	<form id="pagerForm" onsubmit="return navTabSearch(this);" action="${contextPath}/admin/category/list.do?navTabId=${(navTabId)!}" method="post">
	<input type="hidden" name="pager.pageNumber" value="${pager.pageNumber}" />
	<input type="hidden" name="pager.pageSize" value="${pager.pageSize}" />
	<div class="searchBar">
		<table class="searchContent">
			<tr>
				<td>
					分类名称：<input type="text" id="searchName" name="search.name" value="${(search.name)!}" />
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
			<li><a class="add" href="${contextPath}/admin/category/add.do?navTabId=${(navTabId)!}" target="navTab" rel="adduser" title="添加分类"><span>添加</span></a></li>
		    <li><a class="delete" href="${contextPath}/admin/category/delete.do?navTabId=${(navTabId)!}&id={sid_user}" target="ajaxTodo" title="确定要删除吗?"><span>删除</span></a></li>
			<li><a class="edit" href="${contextPath}/admin/category/edit.do?navTabId=${(navTabId)!}&id={sid_user}" target="navTab" rel="edituser" title="修改分类"><span>修改</span></a></li>
		</ul>
	</div>
	<table class="table" width="100%" layoutH="138">
		<thead>
			<tr>
				<th width="80">序号</th>
				<th width="100">分类名称</th>
				<th width="80">描述</th>
			</tr>
		</thead>
		<tbody>
		    <#if (pager.results)??>
	        <#list pager.results as obj>
				<tr target="sid_user" rel="${(obj.id)!}">
					<td>${(obj_index + 1)!}</td>
					<td>${(obj.name)!}</td>
					<td>${(obj.description)!}</td>
				</tr>
			 </#list>
			<#else>
        	    <tr>
                 	<td colspan="3" align="center">${action.getText("msg.no.data")}</td>
                </tr>
	        </#if>
		</tbody>
	</table>
	 <@a.pagination />  
</div>
