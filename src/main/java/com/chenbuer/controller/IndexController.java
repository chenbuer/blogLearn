package com.chenbuer.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.chenbuer.entity.Blog;
import com.chenbuer.entity.PageBean;
import com.chenbuer.service.BlogService;

@Controller
@RequestMapping("/")
public class IndexController {

	@Resource
	private BlogService blogService;

	@RequestMapping("/index")
	public String getIndexContent(@RequestParam(value = "page",required=false) String page,ModelMap model) throws Exception {
 		if (page == null||page.length() == 0) {
			page = "1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 2);
		Map map=new HashMap();
		map.put("start", pageBean.getStart());
		map.put("pageSize", pageBean.getPageSize());
		List<Blog> blogPageList=blogService.listBlogWithPage(map);
		
		model.addAttribute("blogPageList", blogPageList);

		return "index";
	}

}
