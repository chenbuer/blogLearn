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

<link rel="stylesheet" href="${pageContext.request.contextPath}/static/kindeditor/themes/default/default.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/static/kindeditor/plugins/code/prettify.css" />
<script charset="utf-8" src="${pageContext.request.contextPath}/static/kindeditor/kindeditor.js"></script>
<script charset="utf-8" src="${pageContext.request.contextPath}/static/kindeditor/lang/zh_CN.js"></script>
<script charset="utf-8" src="${pageContext.request.contextPath}/static/kindeditor/plugins/code/prettify.js"></script>


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
					<textarea id="editor" name="content" type="text/plain" style="width:95%; height:500px;">
						博客内容...
					</textarea>
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
		var editor = KindEditor.create('#editor');
	
		KindEditor.ready(function(K) {
			var options = {
			        filterMode : true
			};
			var editor = K.create("#editor",options);
			prettyPrint();
		});
		
		function submitData() {
			var title = $("#title").val();
			var typeId = $("#typeId").combobox("getValue");
			var content = editor.html();
			var summary = editor.text().substr(0, 155);
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
			var editor = KindEditor.create('#editor');
			$("#title").val("");
			$("#typeId").combobox("setValue", "");
			editor.html('');
			$("#keyWord").val("");
		}
	</script>
</body>
</html>