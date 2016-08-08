<@a.header "${action.getText('ui.manage')}"></@a.header >
<body scroll="no">
	<div id="layout">
		<div id="header">
			<!-- 头部 -->	
			<@a.toper />
			<!-- 头部菜单 -->	
		</div>
		<div id="leftside">
			<div id="sidebar_s">
				<div class="collapse">
					<div class="toggleCollapse"><div></div></div>
				</div>
			</div>
			<div id="sidebar">
				<!--菜单-->
				<@a.menu/>
			</div>
		</div>
		<div id="container">
			<div id="navTab" class="tabsPage">
				<div class="tabsPageHeader">
					<div class="tabsPageHeaderContent"><!-- 显示左右控制时添加 class="tabsPageHeaderMargin" -->
						<ul class="navTab-tab">
							<li tabid="main" class="main"><a href="javascript:;"><span><span class="home_icon">我的主页</span></span></a></li>
						</ul>
					</div>
					<div class="tabsLeft">left</div><!-- 禁用只需要添加一个样式 class="tabsLeft tabsLeftDisabled" -->
					<div class="tabsRight">right</div><!-- 禁用只需要添加一个样式 class="tabsRight tabsRightDisabled" -->
					<div class="tabsMore">more</div>
				</div>
				<ul class="tabsMoreList">
					<li><a href="javascript:;">我的主页</a></li>
				</ul>
				<div class="navTab-panel tabsPageContent layoutBox">
					<div class="page unitBox">
						<div class="accountInfo">
							<div class="right">
								<!--<p>待办工作32项，消息212条</p>-->
								<p id="timer"></p>
							</div>
							<p><span>最新消息 </span></p>
							<p><a href="#" target="dialog">>>白蚁监测管理平台上线！！</a></p>
							</div>
					</div>
				</div>
			</div>
		</div>
	</div>
 <!--底部-->
 <@a.footer />  
</body>
</html>