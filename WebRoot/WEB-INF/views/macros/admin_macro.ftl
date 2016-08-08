<#macro header title>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>白蚁监测管理平台</title>
    <link href="${contextPath}/favicon.ico" rel="shortcut icon" type="image/x-icon" />
	<link href="${contextPath}/themes/default/style.css" rel="stylesheet" type="text/css" media="screen"/>
	<link href="${contextPath}/themes/css/core.css" rel="stylesheet" type="text/css" media="screen"/>
	<link href="${contextPath}/themes/css/print.css" rel="stylesheet" type="text/css" media="print"/>
	<link href="${contextPath}/js/uploadify/css/uploadify.css" rel="stylesheet" type="text/css" media="screen"/>
	<!--[if IE]>
	<link href="${contextPath}/themes/css/ieHack.css" rel="stylesheet" type="text/css" media="screen"/>
	<![endif]-->

	<!--[if lte IE 9]>
	<script src="${contextPath}/js/dwz/speedup.js" type="text/javascript"></script>
	<![endif]-->

	<script src="${contextPath}/js/jquery-1.7.2.js" type="text/javascript"></script>
	<script src="${contextPath}/js/jquery.cookie.js" type="text/javascript"></script>
	<script src="${contextPath}/js/jquery.validate.js" type="text/javascript"></script>
	<script src="${contextPath}/js/jquery.bgiframe.js" type="text/javascript"></script>
	<script src="${contextPath}/js/xheditor/xheditor-1.2.1.min.js" type="text/javascript"></script>
	<script src="${contextPath}/js/xheditor/xheditor_lang/zh-cn.js" type="text/javascript"></script>
	<script src="${contextPath}/js/uploadify/scripts/jquery.uploadify.js" type="text/javascript"></script>

	<!-- svg图表  supports Firefox 3.0+, Safari 3.0+, Chrome 5.0+, Opera 9.5+ and Internet Explorer 6.0+ -->
	<script type="text/javascript" src="${contextPath}/js/chart/raphael.js"></script>
	<script type="text/javascript" src="${contextPath}/js/chart/g.raphael.js"></script>
	<script type="text/javascript" src="${contextPath}/js/chart/g.bar.js"></script>
	<script type="text/javascript" src="${contextPath}/js/chart/g.line.js"></script>
	<script type="text/javascript" src="${contextPath}/js/chart/g.pie.js"></script>
	<script type="text/javascript" src="${contextPath}/js/chart/g.dot.js"></script>
	
	<script src="${contextPath}/js/dwz/dwz.core.js" type="text/javascript"></script>
	<script src="${contextPath}/js/dwz/dwz.util.date.js" type="text/javascript"></script>
	<script src="${contextPath}/js/dwz/dwz.validate.method.js" type="text/javascript"></script>
	<script src="${contextPath}/js/dwz/dwz.regional.zh.js" type="text/javascript"></script>
	<script src="${contextPath}/js/dwz/dwz.barDrag.js" type="text/javascript"></script>
	<script src="${contextPath}/js/dwz/dwz.drag.js" type="text/javascript"></script>
	<script src="${contextPath}/js/dwz/dwz.tree.js" type="text/javascript"></script>
	<script src="${contextPath}/js/dwz/dwz.accordion.js" type="text/javascript"></script>
	<script src="${contextPath}/js/dwz/dwz.ui.js" type="text/javascript"></script>
	<script src="${contextPath}/js/dwz/dwz.theme.js" type="text/javascript"></script>
	<script src="${contextPath}/js/dwz/dwz.switchEnv.js" type="text/javascript"></script>
	<script src="${contextPath}/js/dwz/dwz.alertMsg.js" type="text/javascript"></script>
	<script src="${contextPath}/js/dwz/dwz.contextmenu.js" type="text/javascript"></script>
	<script src="${contextPath}/js/dwz/dwz.navTab.js" type="text/javascript"></script>
	<script src="${contextPath}/js/dwz/dwz.tab.js" type="text/javascript"></script>
	<script src="${contextPath}/js/dwz/dwz.resize.js" type="text/javascript"></script>
	<script src="${contextPath}/js/dwz/dwz.dialog.js" type="text/javascript"></script>
	<script src="${contextPath}/js/dwz/dwz.dialogDrag.js" type="text/javascript"></script>
	<script src="${contextPath}/js/dwz/dwz.sortDrag.js" type="text/javascript"></script>
	<script src="${contextPath}/js/dwz/dwz.cssTable.js" type="text/javascript"></script>
	<script src="${contextPath}/js/dwz/dwz.stable.js" type="text/javascript"></script>
	<script src="${contextPath}/js/dwz/dwz.taskBar.js" type="text/javascript"></script>
	<script src="${contextPath}/js/dwz/dwz.ajax.js" type="text/javascript"></script>
	<script src="${contextPath}/js/dwz/dwz.pagination.js" type="text/javascript"></script>
	<script src="${contextPath}/js/dwz/dwz.database.js" type="text/javascript"></script>
	<script src="${contextPath}/js/dwz/dwz.datepicker.js" type="text/javascript"></script>
	<script src="${contextPath}/js/dwz/dwz.effects.js" type="text/javascript"></script>
	<script src="${contextPath}/js/dwz/dwz.panel.js" type="text/javascript"></script>
	<script src="${contextPath}/js/dwz/dwz.checkbox.js" type="text/javascript"></script>
	<script src="${contextPath}/js/dwz/dwz.history.js" type="text/javascript"></script>
	<script src="${contextPath}/js/dwz/dwz.combox.js" type="text/javascript"></script>
	<script src="${contextPath}/js/dwz/dwz.print.js" type="text/javascript"></script>
	<script src="${contextPath}/js/dwz/dwz.util.number.js" type="text/javascript"></script>
	
	<script src="${contextPath}/js/dwz/dwz.regional.zh.js" type="text/javascript"></script>
	<script src="${contextPath}/js/dekan/time.js" type="text/javascript"></script>
	
	<script type="text/javascript">
		$(function(){
			DWZ.init("${contextPath}/js/dwz.frag.xml", {
				//loginUrl:"${contextPath}/login_dialog.html", loginTitle:"登录",	// 弹出登录对话框
				loginUrl:"${contextPath}/admin/welcome/index.do",	// 跳到登录页面
				statusCode:{ok:200, error:300, timeout:301}, //【可选】
				pageInfo:{pageNum:"pager.pageNumber", numPerPage:"pager.pageSize", orderField:"orderField", orderDirection:"orderDirection"}, //【可选】
				debug:false,	// 调试模式 【true|false】
				callback:function(){
					initEnv();
					$("#themeList").theme({themeBase:"${contextPath}/themes"}); // themeBase 相对于index页面的主题base路径
				}
			});
			setInterval("getTime()", 1000);  
		});
	</script>


</head>
</#macro>

<#macro toper>
	<div class="headerNav">
	<a class="logo" href="#">${systemName}</a>
	<ul class="nav">
		<li><a href="#">${(admin.name)!}</a></li>
		<li><a href="#" target="_blank" width="600">公司网站</a></li>
		<li><a href="${contextPath}/admin/user/changepwd.do" target="dialog" width="600">密码修改</a></li>
		<li><a href="${contextPath}/admin/welcome/logout.do">退出</a></li>
	</ul>
	<ul class="themeList" id="themeList">
		<li theme="default"><div class="selected">蓝色</div></li>
		<li theme="green"><div>绿色</div></li>
		<!--<li theme="red"><div>红色</div></li>-->
		<li theme="purple"><div>紫色</div></li>
		<li theme="silver"><div>银色</div></li>
		<li theme="azure"><div>天蓝</div></li>
	</ul>
</div>
</#macro>

<!--菜单-->
<#macro menu>
  	<div class="toggleCollapse"><h2>主菜单</h2><div>收缩</div></div>
	<div class="accordion" fillSpace="sidebar">
		<#list (mainPurviews)! as pur>
			<#if (pur.type) == 1>
				<div class="accordionHeader">
					<h2><span>Folder</span>${(pur.name)!}</h2>
				</div>
				<#if (pur.subPurviews)??&&(pur.subPurviews)?exists>
					<div class="accordionContent">
					<ul class="tree treeFolder">
						<#list (pur.subPurviews)! as child>
                       	 	<#if (child.type) == 1>	
                        		<li><a href="${contextPath}${(child.linkurl)!}?navTabId=${(child.code)!}" target="navTab" rel="${(child.code)!}">${(child.name)!}</a></li>
                        	</#if>
			            </#list>
					</ul>
					</div>
				</#if>
			</#if>
		</#list>
	</div>
</#macro>

<#macro pagination>
	<div class="panelBar">
		<div class="pages">
			<span>显示</span>
			<select class="combox" name="numPerPage" onchange="navTabPageBreak({numPerPage:this.value})">
				<#list pageSizes as num>
					<option value="${num}" <#if num == pager.pageSize>selected</#if>>${num}</option>
				</#list>
			</select>
			<span>条，共${(pager.totalCount)!0}条</span>
		</div>
		<div class="pagination" targetType="navTab" totalCount="${(pager.totalCount)!0}" numPerPage="${(pager.pageSize)!0}" pageNumShown="5" currentPage="${(pager.pageNumber)!1}"></div>
	</div>
</#macro>

<#macro paginationTab relId>
	<div class="panelBar">
		<div class="pages">
			<span>显示</span>
			<select class="combox" name="numPerPage" onchange="navTabPageBreak({numPerPage:this.value}, '${relId}')">
				<#list pageSizes as num>
					<option value="${num}" <#if num == pager.pageSize>selected</#if>>${num}</option>
				</#list>
			</select>
			<span>条，共${(pager.totalCount)!0}条</span>
		</div>
		<div class="pagination"  rel="${relId}" totalCount="${(pager.totalCount)!0}" numPerPage="${(pager.pageSize)!0}" pageNumShown="5" currentPage="${(pager.pageNumber)!1}"></div>
	</div>
</#macro>

<#macro footer>
 	<div id="footer">${action.getText("ui.copyrights")}</div>
</#macro>
    