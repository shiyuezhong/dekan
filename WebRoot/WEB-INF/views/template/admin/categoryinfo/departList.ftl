<script type="text/javascript">
function changeName(obj,name,id){
    $(obj).parent().html("<input type='text' onblur='saveDepart(this,"+id+",1)' value='"+name+"'  maxlength='10'/>");
}
function changeCode(obj,code,id){
    $(obj).parent().html("<input type='text' onblur='saveDepart(this,"+id+",2)' value='"+code+"' maxlength='10'/>");
}

function saveDepart(obj,id,type){
    if($(obj).val() == "" || id == ""){
       if(type == 1){
 	      alert("请输入名称");
          return;
        }
        if(type == 2){
 	      alert("请输入编码");
          return;
        }
    }
    var url = "";
    if(type == 1){
 	     url = '${contextPath}/admin/categoryinfo/updateCategoryInfo.do?id=' + id+'&name='+ $(obj).val();
    }
    if(type == 2){
 	     url = '${contextPath}/admin/categoryinfo/updateCategoryInfo.do?id=' + id+'&code='+ $(obj).val();
    }
	//保存
	$.ajax({
		url : url,
		type : 'POST',
		async : false,
		dataType : "json",
		async : false,
		data : null,
		success : function(data) {
		    if(data.statusCode != 200){
		    	alert(data.message);
		    }else{
				if(type == 1){
		 	    	 $(obj).parent().html("<span onclick='changeName(this,\""+$(obj).val()+"\","+id+")'>"+$(obj).val()+"</span>");
		        }
		        if(type == 2){
		 	    	 $(obj).parent().html("<span onclick='changeCode(this,\""+$(obj).val()+"\","+id+")'>"+$(obj).val()+"</span>");
		        }
	        }
		 }
	});
}

function deleteDepart(obj,id){
    var msg=confirm("你确定删除此记录吗？");
	if(msg){
	    //删除
		$.ajax({
			url :  url = '${contextPath}/admin/categoryinfo/delete.do?id=' + id,
			type : 'POST',
			async : false,
			dataType : "json",
			async : false,
			data : null,
			success : function(data) {
		 	       $(obj).parent().parent().parent().remove();
		 	      
				  // var href = '${contextPath}/admin/categoryinfo/departList.do';
			      //$('.unitBox').load(href);
           }
		});
	} 
}
</script>
<div class="pageHeader">
	<form id="pagerForm" onsubmit="return navTabSearch(this);" action="${contextPath}/admin/categoryinfo/departList.do?navTabId=${(navTabId)!}" method="post">
	<input type="hidden" name="pager.pageNumber" value="${pager.pageNumber}" />
	<input type="hidden" name="pager.pageSize" value="${pager.pageSize}" />
	<div class="searchBar">
		<table class="searchContent">
			<tr>
				<td>
					部门名称：<input type="text" id="searchName" name="search.name" value="${(search.name)!}" maxlength="10"/>
				</td>
				<td>
					编码：<input type="text" id="searchCode" name="search.code" value="${(search.code)!}" maxlength="10"/>
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
	<table class="table" width="100%" layoutH="138">
		<thead>
			<tr>
				<th width="80">序号</th>
				<th width="100">部门名称</th>
				<th width="80">编码</th>
				<th width="80">上级</th>
				<th width="80">操作</th>
			</tr>
		</thead>
		<tbody>
		    <#if (pager.results)??>
	        <#list pager.results as obj>
				<tr target="sid_user" rel="${(obj.id)!}">
					<td>${(obj_index + 1)!}</td>
					<td><span onclick="changeName(this,'${(obj.name)!}','${(obj.id)!}')">${(obj.name)!'未填写'}</span></td>
					<td><span onclick="changeCode(this,'${(obj.code)!}','${(obj.id)!}')">${(obj.code)!'未填写'}</span></td>
					<td>${(obj.parent.name)!}</td>
					<td><a href="#" onclick="deleteDepart(this,'${(obj.id)!}')">删除</a></td>
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
