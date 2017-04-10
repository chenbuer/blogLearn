package com.chenbuer.controller.admin;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.chenbuer.service.UserService;

/**
 * adminÓÃ»§¿ØÖÆÆ÷
 * @author czy
 *
 */
@Controller
@RequestMapping("/admin/blog")
public class AdminUserController {

	@Resource
	UserService userService;
	
}
