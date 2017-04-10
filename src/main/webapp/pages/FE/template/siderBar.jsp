<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
			<div class="data_list">
					<div class="data_list_title">
						<img
							src="${pageContext.request.contextPath}/static/images/user_icon.png" />
						博主信息
					</div>
					<div class="user_image">
						<!-- <img src="${pageContext.request.contextPath}/static/userImages/20160202095456.png"/> -->
						<img
							src="http://www.sinaimg.cn/dy/slidenews/4_img/2014_39/704_1429733_253181.jpg" />
					</div>
					<div class="nickName">${blogger.userName }</div>
					<div class="userSign">${blogger.sign }</div>
				</div>

				<div class="data_list">
					<div class="data_list_title">
						<img
							src="${pageContext.request.contextPath}/static/images/byType_icon.png" />
						按日志类别
					</div>
					<div class="datas">
						<ul>
							<c:forEach var="blogType" items="${blogTypeCountList }">
								<li><span><a href="/index.html?typeId=${blogType.id }">${blogType.typeName }(${blogType.blogCount })</a></span></li>
							</c:forEach>

						</ul>
					</div>
				</div>



				<div class="data_list">
					<div class="data_list_title">
						<img
							src="${pageContext.request.contextPath}/static/images/byDate_icon.png" />
						按日期类别
					</div>
					<div class="datas">
						<ul>
							<c:forEach items="${blogCountList }" var="blog">
								<li><span><a
										href="/index.html?releaseDateStr=${blog.releaseDateStr }">${blog.releaseDateStr }(${blog.blogCount })</a></span></li>
							</c:forEach>
						</ul>
					</div>
				</div>

				<div class="data_list">
					<div class="data_list_title">
						<img
							src="${pageContext.request.contextPath}/static/images/link_icon.png" />
						友情链接test
					</div>
					<div class="datas">
						<ul>

							<c:forEach items="${linkList }" var="link">
								<li><span><a href="${link.linkUrl }" target="_blank">${link.linkName }</a></span></li>
							</c:forEach>
						</ul>
					</div>
				</div>
