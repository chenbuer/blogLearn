package com.chenbuer.util;

public class PageUtil {

	public static String getPageCode(String targetUrl, // 目标url
			long totalNum, // 总记录数
			int currentPage, // 当前页
			int pageSize, // 每页显示记录数
			String param) { // 参数
		// 计算总页数
		long totalPage = totalNum % pageSize == 0 ? totalNum / pageSize : totalNum / pageSize + 1;
		if (totalPage == 0) {
			return "未查询到数据";
		} else {
			StringBuffer pageCode = new StringBuffer();
			if (currentPage > 1) {
				pageCode.append("<li><a href='" + targetUrl + "?page=1&" + param + "'>首页</a></li>");
				pageCode.append(
						"<li><a href='" + targetUrl + "?page=" + (currentPage - 1) + "&" + param + "'>上一页</a></li>");
			} else {
				pageCode.append("<li class='disabled'><a>首页</a></li>");
				pageCode.append("<li class='disabled'><a>上一页</a></li>");
			}
			
//			for (int i = currentPage - 2; i <= currentPage + 2; i++) {
//				if (i < 1 || i > totalPage) {
//					continue;
//				}
//				if (i == currentPage) {
//					pageCode.append("<li class='active'><a href='" + targetUrl + "?page=" + i + "&" + param + "'>" + i
//							+ "</a></li>");
//				} else {
//					pageCode.append("<li><a href='" + targetUrl + "?page=" + i + "&" + param + "'>" + i + "</a></li>");
//				}
//			}
			//全都显示
			for (int i = 1; i <= totalPage; i++) {
				
				if (i == currentPage) {
					pageCode.append("<li class='active'><a href='" + targetUrl + "?page=" + i + "&" + param + "'>" + i
							+ "</a></li>");
				} else {
					pageCode.append("<li><a href='" + targetUrl + "?page=" + i + "&" + param + "'>" + i + "</a></li>");
				}
			}
			
			if (currentPage < totalPage) {
				pageCode.append(
						"<li><a href='" + targetUrl + "?page=" + (currentPage + 1) + "&" + param + "'>下一页</a></li>");
				pageCode.append("<li><a href='" + targetUrl + "?page=" + totalPage + "&" + param + "'>尾页</a></li>");
			} else {
				pageCode.append("<li class='disabled'><a>下一页</a></li>");
				pageCode.append("<li class='disabled'><a>尾页</a></li>");
			}
			return pageCode.toString();
		}
	}

}
