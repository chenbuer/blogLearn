<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/static/bootstrap3/css/bootstrap.min.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/static/bootstrap3/css/bootstrap-theme.min.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/static/css/blog.css">
<script
	src="${pageContext.request.contextPath}/static/bootstrap3/js/jquery-1.11.2.min.js"></script>
<script
	src="${pageContext.request.contextPath}/static/bootstrap3/js/bootstrap.min.js"></script>
<title>陈不二的博客</title>
<style type="text/css">
body {
	padding-top: 10px;
	padding-bottom: 40px;
}
</style>
</head>
<body>
	<div class="container">
		<jsp:include page="/pages/FE/template/header.jsp"></jsp:include>

		<jsp:include page="/pages/FE/template/navigator.jsp"></jsp:include>

		<div class="row">
			<div class="col-md-9">
				<div class="data_list">
					<div class="data_list_title">
						<img
							src="${pageContext.request.contextPath}/static/images/download_icon.png" />
						源码下载
					</div>
				下载毛毛啊，还没写完呢
					
				</div>
				
			</div>





			<div class="col-md-3">
				<jsp:include page="/pages/FE/template/siderBar.jsp"></jsp:include>
			</div>
		</div>

		<jsp:include page="/pages/FE/template/footer.jsp"></jsp:include>


	</div>
</body>
</html>