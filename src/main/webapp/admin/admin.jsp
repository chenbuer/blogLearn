<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>chenbuerBlog_后台管理</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/static/jquery-easyui-1.5.1/themes/default/easyui.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/static/jquery-easyui-1.5.1/themes/icon.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/static/jquery-easyui-1.5.1/demo/demo.css">
<script type="text/javascript"
	src="${pageContext.request.contextPath}/static/jquery-easyui-1.5.1/jquery.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/static/jquery-easyui-1.5.1/jquery.easyui.min.js"></script>
</head>
<body>
<body class="easyui-layout">
	<div region="north" style="height: 60px; background: #0593d3; padding: 10px" data-options="border:false" >
		<table style="width: 100%">
			<tr>
				<td>陈不二博客的后台管理系统</td>
				<td style="float: right">你好：<strong>${user.userName }</strong></td>
			</tr>
		</table>
	</div>
	<div region="west" data-options="split:true,title:'导航菜单'" style="width: 255px; padding: 10px;">
		<div class="easyui-accordion" data-options="fit:true,border:false">
			<div title="常用操作" style="padding: 10px;">
				写博客
			</div>
			<div title="博客管理" data-options="selected:true" style="padding: 10px;">
				 内容二
			</div>
			<div title="博客类型管理" style="padding: 10px">
				内容三
			</div>
		</div>

	</div>
	
	<div region='center' data-options="iconCls:'icon-ok'">
        <div class="easyui-tabs" data-options="fit:true,border:false,plain:true">
            <div title="首页" data-options="" style="padding:10px">欢迎使用</div>
        </div>
    </div>



	<div data-options="region:'south',border:false"	style="text-align:center;height: 50px; background: #fff1e0; padding: 10px;"><font color="blue">陈不二的博客后台管理系统</font></div>
</body>
</html>