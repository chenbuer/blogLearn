package com.chenbuer.controller.admin;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSON;
import com.chenbuer.entity.Blog;
import com.chenbuer.service.BlogService;
import com.chenbuer.util.AdminResponse;
import com.chenbuer.util.ResponseUtil;

@Controller
@RequestMapping("/admin/blog")
public class BlogController {

	@Resource
	BlogService blogService;
	
	@RequestMapping("/save")
	public void save(Blog blog,HttpServletResponse response) throws Exception{
		AdminResponse retObj=new AdminResponse();
		try {
			blogService.save(blog);
			retObj.setSuccess(true);
		} catch (Exception e) {
			retObj.setSuccess(false);
		}
		
		ResponseUtil.write(response, JSON.toJSONString(retObj));
	}
}
