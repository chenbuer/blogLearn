package com.chenbuer.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.chenbuer.entity.Blog;
import com.chenbuer.entity.PageBean;
import com.chenbuer.service.BlogService;
import com.chenbuer.util.PageUtil;
import com.chenbuer.util.StringUtil;
import com.sun.xml.internal.ws.message.RelatesToHeader;

@Controller
@RequestMapping("/")
public class IndexController {
	
	private final Integer ONE_PAGE_SIZE=2;

	@Resource
	private BlogService blogService;

	@RequestMapping("/index")
	public String getIndexContent(@RequestParam(value = "page",required=false) String page,//��ҳ
									@RequestParam(value = "typeId",required=false) String typeId,//����־����ѯ��ʾ
									@RequestParam(value = "releaseDateStr",required=false) String releaseDateStr,//����������ѯ��ʾ
									HttpServletRequest request, 
									ModelMap model) throws Exception {
		StringBuffer param=new StringBuffer();
 		if (StringUtil.isEmpty(page)) {
			page = "1";
		}
		//��ȡ����ҳ������
 		PageBean pageBean=new PageBean(Integer.parseInt(page), 2);
		Map map=new HashMap();
		map.put("start", pageBean.getStart());
		map.put("pageSize", pageBean.getPageSize());
		if(StringUtil.isNotEmpty(typeId)){
			map.put("typeId", Integer.parseInt(typeId));
		}
		if(StringUtil.isNotEmpty(releaseDateStr)){
			map.put("releaseDateStr", releaseDateStr);
		}
		List<Blog> blogPageList=blogService.listBlogWithPage(map);
		model.addAttribute("blogPageList", blogPageList);
		//��ȡ����ҳ����
 		if(StringUtil.isNotEmpty(typeId)){
 			param.append("typeId="+typeId+"&");
 		}
 		if(StringUtil.isNotEmpty(releaseDateStr)){
 			param.append("releaseDateStr="+releaseDateStr+"&");
 		}
 		Map pageMap=new HashMap();
 		if(StringUtil.isNotEmpty(typeId)){
 			pageMap.put("typeId", Integer.parseInt(typeId));
		}
		if(StringUtil.isNotEmpty(releaseDateStr)){
			pageMap.put("releaseDateStr", releaseDateStr);
		}
 		String pageCode=new PageUtil().getPageCode("/blog/index.html",blogService.getBlogCount(pageMap),Integer.parseInt(page),ONE_PAGE_SIZE,param.toString());
		model.addAttribute("pageCode", pageCode);
		return "index";
	}

	/**
	 * Դ������ҳ��
	 * @return
	 */
	@RequestMapping("download")
	public String download(){
		return "download";
	}

}
