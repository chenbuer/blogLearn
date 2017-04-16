<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>博客管理</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/jquery-easyui-1.5.1/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/jquery-easyui-1.5.1/themes/icon.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/blog.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/static/jquery-easyui-1.5.1/jquery.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/jquery-easyui-1.5.1/jquery.easyui.min.js"></script>
<script type="text/javascript">

function formatBlogType(val, rowData, rowIndex) {
	return rowData.blogType.typeName;
}

function deleteBlog(){
	var selectedRows = $("#datagrid").datagrid("getSelections");
	if(selectedRows.length == 0) {
		$.messager.alert("系统提示", "请选择要删除的数据");
		return;
	}
	var idsStr = [];
	for(var i = 0; i < selectedRows.length; i++) {
		idsStr.push(selectedRows[i].id);
	}
	var ids = idsStr.join(","); //1,2,3,4
	$.messager.confirm('确认信息','您确认要删除这<font color="red"><strong>'+selectedRows.length+'</strong></font>条信息？',function(r){
	    if (r){
			$.post("${pageContext.request.contextPath}/admin/blog/delete.do",
					{"ids":ids},
					function(result){
						if(result.success){
							$.messager.alert("提示信息","成功删除选择的数据");
							$("#datagrid").datagrid("reload");
						}else{
							$.messager.alert("系统提示","删除失败，请联系管理员");
						}
					},"json");
	    }
	});
}


</script>
</head>
<body>
	<div id="p" class="easyui-panel" title="博客管理界面" fitColums="true">
		<table class="easyui-datagrid" fitColumns="true" id="datagrid" toolbar="#mytoolbar"
	    url='${pageContext.request.contextPath}/admin/blog/list.do'>
		    <thead>
				<tr>
					<th data-options="field:'checkbox',width:100" checkbox="true"></th>
					<th data-options="field:'id',width:25">id</th>
					<th data-options="field:'title',width:100">标题</th>
					<th data-options="field:'blogType',width:100" formatter="formatBlogType">类型</th>
					<th data-options="field:'content',width:200">内容</th>
					<th data-options="field:'releaseDateStr',width:100">发布时间</th>
					<th data-options="field:'keyWord',width:100">关键字</th>
				</tr>
		    </thead>
		</table>
		
		
		
	</div>
	
	
	<div id="mytoolbar">
		&nbsp;&nbsp;&nbsp;标题：&nbsp;<input Class="easyui-textbox" id="searchTitle">
		<a id="btn" href="javascript:searchBlog()" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-search'">搜索</a>
		<a id="btn" href="javascript:deleteBlog()" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-remove'">删除</a>
		<a id="btn" href="javascript:updateBlog()" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-edit'">修改</a>
	</div>
</body>
</html>