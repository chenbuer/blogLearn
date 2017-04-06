package com.chenbuer.service.impl;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import com.chenbuer.entity.Blog;
import com.chenbuer.entity.BlogType;
import com.chenbuer.entity.Link;
import com.chenbuer.entity.User;
import com.chenbuer.service.BlogService;
import com.chenbuer.service.BlogTypeService;
import com.chenbuer.service.LinkService;
import com.chenbuer.service.UserService;

@Component
public class InitComponent implements ServletContextListener,ApplicationContextAware{

	private static ApplicationContext applicationContext;
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext=applicationContext;
	}

	public void contextInitialized(ServletContextEvent servletContextEvent) {
		UserService userService=(UserService) applicationContext.getBean("userService");
		ServletContext application=servletContextEvent.getServletContext();
		//��ȡ��������Ϣ
		User blogger=userService.find();
		blogger.setPassword(null);//����Ƚ����У����
		application.setAttribute("blogger", blogger);
		
		LinkService linkService = (LinkService) applicationContext.getBean("linkService");
		//��ȡ����������������Ϣ�洢��application��
		List<Link> linkList=linkService.list();
		application.setAttribute("linkList", linkList);
		
		BlogTypeService blogTypeService = (BlogTypeService) applicationContext.getBean("blogTypeService");
		//��ȡ������`��������`�洢��application��
		List<BlogType> blogTypeCountList=blogTypeService.countList();
		application.setAttribute("blogTypeCountList", blogTypeCountList);

		BlogService blogService = (BlogService) applicationContext.getBean("blogService");
		//��ȡ������`��������`�洢��application��
		List<Blog> blogCountList=blogService.countList();
		application.setAttribute("blogCountList", blogCountList);
	}

	public void contextDestroyed(ServletContextEvent servletContextEvent) {
		
	}

}
