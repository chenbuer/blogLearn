<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>chenbuerBlog_后台管理</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/jquery-easyui-1.5.1/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/jquery-easyui-1.5.1/themes/icon.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/blog.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/static/jquery-easyui-1.5.1/jquery.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/jquery-easyui-1.5.1/jquery.easyui.min.js"></script>
<script type="text/javascript">
function openTab(text,url,iconCls){
	if($("#tabs").tabs("exists",text)){
		$("#tabs").tabs("select",text);
	}else{
		var content="<iframe frameborder=0 scrolling='auto' style='width:100%;height:100%' src='${pageContext.request.contextPath}/admin/"+url+"'></iframe>";
		$("#tabs").tabs("add",{
			title:text,
			iconCls:iconCls,
			closable:true,
			content:content
		});
	}
}
</script>
</head>
	<body class="easyui-layout">
		<div region="north" style="height: 60px; background: #0593d3; padding: 10px" data-options="border:false" >
			<table style="width: 100%">
				<tr>
					<td>陈不二博客的后台管理系统</td>
					<td style="float: right">你好：<strong><font color='red'>${user.userName }</font></strong></td>
				</tr>
			</table>
		</div>
		
		<div region="west" style="width: 200px" title="导航菜单" split="true">
			<div class="easyui-accordion" data-options="fit:true,border:false">
				<div title="常用操作" data-options="selected:true,iconCls:'icon-item'" style="padding: 10px">
					<a href="javascript:openTab('写博客','writeBlog.jsp','icon-writeblog')" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-writeblog'" style="width: 150px">写博客</a>
					<a href="javascript:openTab('评论审核','commentReview.jsp','icon-review')" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-review'" style="width: 150px">评论审核</a>
				</div>
				<div title="博客管理"  data-options="iconCls:'icon-bkgl'" style="padding:10px;">
					<a href="javascript:openTab('写博客','writeBlog.jsp','icon-writeblog')" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-writeblog'" style="width: 150px;">写博客</a>
					<a href="javascript:openTab('博客信息管理','blogManage.jsp','icon-bkgl')" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-bkgl'" style="width: 150px;">博客信息管理</a>
				</div>
				<div title="博客类别管理" data-options="iconCls:'icon-bklb'" style="padding:10px">
					<a href="javascript:openTab('博客类别信息管理','blogTypeManage.jsp','icon-bklb')" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-bklb'" style="width: 150px;">博客类别信息管理</a>
				</div>
				<div title="评论管理"  data-options="iconCls:'icon-plgl'" style="padding:10px">
					<a href="javascript:openTab('评论审核','commentReview.jsp','icon-review')" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-review'" style="width: 150px">评论审核</a>
					<a href="javascript:openTab('评论信息管理','commentManage.jsp','icon-plgl')" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-plgl'" style="width: 150px;">评论信息管理</a>
				</div>
				<div title="个人信息管理"  data-options="iconCls:'icon-grxx'" style="padding:10px">
					<a href="javascript:openTab('修改个人信息','modifyInfo.jsp','icon-grxxxg')" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-grxxxg'" style="width: 150px;">修改个人信息</a>
				</div>
				<div title="系统管理"  data-options="iconCls:'icon-system'" style="padding:10px">
				    <a href="javascript:openTab('友情链接管理','linkManage.jsp','icon-link')" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-link'" style="width: 150px">友情链接管理</a>
					<a href="javascript:openPasswordModifyDialog()" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-modifyPassword'" style="width: 150px;">修改密码</a>
					<a href="javascript:refreshSystemCache()" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-refresh'" style="width: 150px;">刷新系统缓存</a>
					<a href="javascript:logout()" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-exit'" style="width: 150px;">安全退出</a>
				</div>
			</div>
		</div>
		
		<div region='center' data-options="iconCls:'icon-ok'">
	        <div class="easyui-tabs" data-options="fit:true,border:false,plain:true" id="tabs">
	            <div align="center" title="首页" style="padding-top: 100px" data-options="iconCls:'icon-home'"><font color="red" size="10">欢迎使用</font></div>
	        </div>
	    </div>
	
	
	
		<div data-options="region:'south',border:false"	style="text-align:center;height: 50px; background: #fff1e0; padding: 10px;"><font color="blue">陈不二的博客后台管理系统</font></div>
	</body>
</html>