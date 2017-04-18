package com.chenbuer.controller.admin;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.chenbuer.config.FinalParam;
import com.chenbuer.entity.AdminBlogList;
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
			if(blog.getId()==null){
				//新增
				blogService.save(blog);
			}else{
				//修改
				blogService.update(blog);
			}
			retObj.setSuccess(true);
		} catch (Exception e) {
			retObj.setSuccess(false);
		}
		
		
		ResponseUtil.write(response, JSON.toJSONString(retObj));
	}
	
	@RequestMapping("/list")
	public void list(@RequestParam(value="page",required=false)String page,
			@RequestParam(value="rows",required=false)String size,//每一页有多少item
			@RequestParam(value="title",required=false)String title,//每一页有多少item
			HttpServletResponse response) throws Exception{
		if(StringUtil.isEmpty(page)){
			page="1";
		}
		if(StringUtil.isEmpty(size)){
			size=new FinalParam().ONE_PAGE_SIZE;
		}
		int total=blogService.getBlogCount(null);
		PageBean pageBean=new PageBean(Integer.parseInt(page), Integer.parseInt(size));
		Map map=new HashMap();
		map.put("start", pageBean.getStart());
		map.put("pageSize", pageBean.getPageSize());
		if(StringUtil.isNotEmpty(title)){
			map.put("title", "%"+title+"%");
			//总数也要重新计算
			Map totleMap=new HashMap();
			totleMap.put("title", "%"+title+"%");
			total=blogService.getBlogCount(totleMap);
		}
		List<Blog> blogs=blogService.listBlogWithPage(map);
		for (Blog blog : blogs) {
			blog.setReleaseDateStr(new DateUtil().formatDate("yyyy-MM-dd", blog.getReleaseDate()));
		}
		//关闭引用支持，参考https://github.com/alibaba/fastjson/wiki/%E5%BE%AA%E7%8E%AF%E5%BC%95%E7%94%A8
		AdminBlogList rows=new AdminBlogList();
		rows.setRows(blogs);
		rows.setTotal(total);
		ResponseUtil.write(response, JSON.toJSONString(rows,SerializerFeature.DisableCircularReferenceDetect));
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
	
	@RequestMapping("/findById")
	@ResponseBody
	public Object findById(@RequestParam(value="id")String id,HttpServletResponse response) throws Exception{
		Blog blog=blogService.findById(Integer.parseInt(id));
		return JSON.toJSONString(blog);
	}
	
}
