package com.chenbuer.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.chenbuer.service.UserService;

/**
 * ”√ªßcontroller≤„
 * @author czy
 *
 */
@Controller
@RequestMapping("/user")
public class UserController {

	@Resource
	private UserService userService;
}
