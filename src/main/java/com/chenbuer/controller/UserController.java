package com.chenbuer.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.chenbuer.entity.Blog;
import com.chenbuer.entity.PageBean;
import com.chenbuer.entity.User;
import com.chenbuer.service.BlogService;
import com.chenbuer.service.UserService;
import com.chenbuer.util.CryptographyUtil;
import com.chenbuer.util.PageUtil;

/**
 * �û�controller��
 * 
 * @author czy
 *
 */
@Controller
@RequestMapping("/user")
public class UserController {

	@Resource
	private UserService userService;

	@RequestMapping("login")
	public String login(User user, HttpServletRequest request) {
		// ��shiro�������û���֤
		Subject subject = SecurityUtils.getSubject();
		UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(user.getUserName(),
				CryptographyUtil.md5(user.getPassword(), "chenbuer"));
		try {
			subject.login(usernamePasswordToken);
			return "redirect:/admin/admin.jsp";
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("user", user);
			request.setAttribute("errorInfo", "�û������������!");
			//���������Ҫд�ģ���ʼ�Լ�����
			return "login";
		}
		
	}
	
	/**
	 * ǰ̨�鿴���ڲ�����controller��
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping("aboutMe")
	public String aboutMe(ModelMap model, HttpServletRequest request) {
		User blogger=userService.find();
		model.addAttribute("blogger", blogger);
		return "/FE/aboutMe";
		
	}
}
