<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>写博客页面</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/jquery-easyui-1.5.1/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/jquery-easyui-1.5.1/themes/icon.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/blog.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/static/jquery-easyui-1.5.1/jquery.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/jquery-easyui-1.5.1/jquery.easyui.min.js"></script>

<script type="text/javascript" charset="utf-8" src="${pageContext.request.contextPath}/static/ueditor/ueditor.config.js"></script>
<script type="text/javascript" charset="utf-8" src="${pageContext.request.contextPath}/static/ueditor/ueditor.all.min.js">
	
</script>
<!--建议手动加在语言，避免在ie下有时因为加载语言失败导致编辑器加载失败-->
<!--这里加载的语言文件会覆盖你在配置项目里添加的语言类型，比如你在配置项目里配置的是英文，这里加载的中文，那最后就是中文-->
<script type="text/javascript" charset="utf-8" src="${pageContext.request.contextPath}/static/ueditor/lang/zh-cn/zh-cn.js"></script>

<script type="text/javascript">
function submitData() {
	var title = $("#title").val();
	var typeId = $("#typeId").combobox("getValue");
	var content = UE.getEditor('editor').getContent();
	var summary = UE.getEditor('editor').getContentTxt().substr(0, 155);
	var keyWord = $("#keyWord").val();
	if (title == null || title == '') {
		$.messager.alert("系统提示", "请输入标题！");
	} else if (typeId == null || typeId == '') {
		$.messager.alert("系统提示", "请选择博客类型！");
	} else if (content == null || content == '') {
		$.messager.alert("系统提示", "请编辑博客内容！");
	} else {
		$.post("${pageContext.request.contextPath}/admin/blog/save.do",
				{
					'title' : title,
					'typeId' : typeId,
					'content' : content,
					'summary' : summary,
					'keyWord' : keyWord,
				}, function(result) {
					if (result.success) {
						clearValues();
						$.messager.alert("系统提示", "博客发布成功！");
					} else {
						$.messager.alert("系统提示", "博客发布失败！");
					}
				}, "json");
	}
}

function clearValues() {
	$("#title").val("");
	$("#typeId").combobox("setValue", "");
	UE.getEditor("editor").setContent("");
	$("#keyWord").val("");
}
</script>

</head>

<body style="margin: 10px; font-family: microsoft yahei">

	<div id="p" class="easyui-panel" title="编写博客" style="padding: 10px;">
		
		<table cellspacing="20px">
			<tr>
				<td width="80px">博客标题：</td>
				<td><input class="easyui-textbox" id="title" name="title" style="width:400px" /></td>
			</tr>
			<tr>
				<td>所属类别：</td>
				<td>
					<select id="typeId" class="easyui-combobox" name="typeId" style="width:200px">
					    <option value="">请选择博客类别...</option>
					    <c:forEach var='blogType' items="${blogTypeCountList }" >
					    	<option value=${blogType.id }>${blogType.typeName }</option>
					    </c:forEach>
					</select>
				</td>
			</tr>
			<tr>
				<td valign="top">博客内容：</td>
				<td>
					<script id="editor" name="content" type="text/plain" style="width:95%; height:500px;">
						博客内容...
					</script>
				</td>
			</tr>
			
			<tr>
				<td>关键字：</td>
				<td><input class="easyui-textbox" id="keyWord" name="keyWord"
					style="width:400px" />&nbsp;&nbsp;&nbsp;多个关键字的话请用空格隔开</td>
			</tr>
			
			<tr>
				<td></td>
				<td><a href="javascript:submitData()" class="easyui-linkbutton"
					data-options="iconCls:'icon-submit'">发布博客</a></td>
			</tr>
		</table>
	</div>



	<!-- 实例化编辑器 -->
	<script type="text/javascript">
		var ue = UE.getEditor('editor');
	</script>
</body>
</html>