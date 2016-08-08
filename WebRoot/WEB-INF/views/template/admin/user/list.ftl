<div class="pageHeader">
	<form id="pagerForm" onsubmit="return navTabSearch(this);" action="${contextPath}/admin/user/list.do?navTabId=${(navTabId)!}" method="post">
	<input type="hidden" name="pager.pageNumber" value="${pager.pageNumber}" />
	<input type="hidden" name="pager.pageSize" value="${pager.pageSize}" />
	<div class="searchBar">
		<table class="searchContent">
			<tr>
				<td>
					用户名：<input type="text" id="searchName" name="search.name" value="${(search.name)!}" />
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
			<li><a class="add" href="${contextPath}/admin/user/add.do?navTabId=${(navTabId)!}" target="navTab" rel="adduser" title="添加管理员"><span>添加</span></a></li>
		    <li class="line">line</li>
		    <li><a class="delete" href="${contextPath}/admin/user/addpurview.do?navTabId=${(navTabId)!}&id={sid_user}" target="navTab"  rel="addpurview" title="分配菜单权限"><span>分配菜单权限</span></a></li>
		    <li class="line">line</li>
		    <li><a class="add" href="${contextPath}/admin/user/addcategoryinfo.do?navTabId=${(navTabId)!}" target="navTab" rel="addcategoryinfo" title="分配分类关联"><span>分配分类关联</span></a></li>
		    <li class="line">line</li>
			<li><a class="edit" href="${contextPath}/admin/user/edit.do?navTabId=${(navTabId)!}&id={sid_user}" target="navTab" rel="edituser" title="修改管理员"><span>修改</span></a></li>
			<li class="line">line</li>
			<li><a class="delete" href="${contextPath}/admin/user/delete.do?navTabId=${(navTabId)!}&id={sid_user}" target="ajaxTodo" title="确定要删除吗?"><span>删除</span></a></li>
			<li class="line">line</li>
			<li><a class="icon" href="${contextPath}/admin/user/resetpwd.do?navTabId=${(navTabId)!}&id={sid_user}" target="ajaxTodo" title="确定要重置密码码?"><span>密码重置</span></a></li>
		</ul>
	</div>
	<table class="table" width="100%" layoutH="138">
		<thead>
			<tr>
				<th width="80">序号</th>
				<th width="100">用户名</th>
				<th width="80">姓名</th>
				<th width="80">角色</th>
				<th width="80">状态</th>
			</tr>
		</thead>
		<tbody>
		    <#if (pager.results)??>
	        <#list pager.results as obj>
				<tr target="sid_user" rel="${(obj.id)!}">
					<td>${(obj_index + 1)!}</td>
					<td>${(obj.userName)!}</td>
					<td>${(obj.name)!}</td>
					<td>${(obj.userRoleProp.roleInfo.name)!}</td>
					<td><#if obj?exists && obj.isAccountLocked?? && obj.isAccountLocked!=null && obj.isAccountLocked.value==0>
		                                <#if obj?exists&&(obj.isAccountEnabled)?exists&&(obj.isAccountEnabled)??&&obj.isAccountEnabled.value==0>禁用<#else>正常</#if>
		                                <#else>锁定</#if></td>
				</tr>
			 </#list>
			<#else>
        	    <tr>
                 	<td colspan="5" align="center">${action.getText("msg.no.data")}</td>
                </tr>
	        </#if>
		</tbody>
	</table>
	 <@a.pagination />  
</div>
