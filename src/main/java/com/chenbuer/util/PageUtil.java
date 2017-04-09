package com.chenbuer.util;

public class PageUtil {

	public static String getPageCode(String targetUrl, // Ŀ��url
			long totalNum, // �ܼ�¼��
			int currentPage, // ��ǰҳ
			int pageSize, // ÿҳ��ʾ��¼��
			String param) { // ����
		// ������ҳ��
		long totalPage = totalNum % pageSize == 0 ? totalNum / pageSize : totalNum / pageSize + 1;
		if (totalPage == 0) {
			return "δ��ѯ������";
		} else {
			StringBuffer pageCode = new StringBuffer();
			if (currentPage > 1) {
				pageCode.append("<li><a href='" + targetUrl + "?page=1&" + param + "'>��ҳ</a></li>");
				pageCode.append(
						"<li><a href='" + targetUrl + "?page=" + (currentPage - 1) + "&" + param + "'>��һҳ</a></li>");
			} else {
				pageCode.append("<li class='disabled'><a>��ҳ</a></li>");
				pageCode.append("<li class='disabled'><a>��һҳ</a></li>");
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
			//ȫ����ʾ
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
						"<li><a href='" + targetUrl + "?page=" + (currentPage + 1) + "&" + param + "'>��һҳ</a></li>");
				pageCode.append("<li><a href='" + targetUrl + "?page=" + totalPage + "&" + param + "'>βҳ</a></li>");
			} else {
				pageCode.append("<li class='disabled'><a>��һҳ</a></li>");
				pageCode.append("<li class='disabled'><a>βҳ</a></li>");
			}
			return pageCode.toString();
		}
	}

}
