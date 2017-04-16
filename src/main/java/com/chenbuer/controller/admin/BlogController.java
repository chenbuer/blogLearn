package com.chenbuer.controller.admin;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.chenbuer.entity.Blog;
import com.chenbuer.entity.PageBean;
import com.chenbuer.service.BlogService;
import com.chenbuer.util.AdminResponse;
import com.chenbuer.util.DateUtil;
import com.chenbuer.util.ResponseUtil;
import com.chenbuer.util.StringUtil;

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
	
	@RequestMapping("/list")
	public void list(@RequestParam(value="page",required=false)String page,
			@RequestParam(value="size",required=false)String size,
			HttpServletResponse response) throws Exception{
		if(StringUtil.isEmpty(page)){
			page="1";
		}
		if(StringUtil.isEmpty(size)){
			size="5";
//			size=new FinalParam().ONE_PAGE_SIZE;
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), Integer.parseInt(size));
		Map map=new HashMap();
		map.put("start", pageBean.getStart());
		map.put("pageSize", pageBean.getPageSize());
		List<Blog> blogs=blogService.listBlogWithPage(map);
		for (Blog blog : blogs) {
			blog.setReleaseDateStr(new DateUtil().formatDate("yyyy-MM-dd", blog.getReleaseDate()));
		}
		//关闭引用支持，参考https://github.com/alibaba/fastjson/wiki/%E5%BE%AA%E7%8E%AF%E5%BC%95%E7%94%A8
		ResponseUtil.write(response, JSON.toJSONString(blogs,SerializerFeature.DisableCircularReferenceDetect));
	}
	
	@RequestMapping("/delete")
	public void delete(@RequestParam(value="ids")String ids,
			HttpServletResponse response) throws Exception{
		AdminResponse ret=new AdminResponse();
		try {

			String []idsString=ids.split(",");
			for (String id: idsString) {
				blogService.delete(Integer.parseInt(id));
			}
			
			ret.setSuccess(true);
			ResponseUtil.write(response,JSON.toJSONString(ret));
		} catch (Exception e) {
			ret.setSuccess(false);
			ResponseUtil.write(response, JSON.toJSONString(ret));
		}
	}
	
	
}
