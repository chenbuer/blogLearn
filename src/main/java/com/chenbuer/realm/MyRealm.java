package com.chenbuer.realm;

import javax.annotation.Resource;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import com.chenbuer.entity.User;
import com.chenbuer.service.UserService;

/**
 * 自定义shiro Realm
 * 
 * @author czy
 *
 */
public class MyRealm extends AuthorizingRealm {

	@Resource
	private UserService userService;

	/**
	 * 为当前用户获取角色和权限
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * 验证
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		//通过用户登录的token获取用户的用户名
		String userName=(String) token.getPrincipal();
		User user=userService.getUserByUserName(userName);
		if(user!=null){
			SecurityUtils.getSubject().getSession().setAttribute("user", user);
			AuthenticationInfo authenticationInfo=new SimpleAuthenticationInfo(user.getUserName(),user.getPassword(),"xx"); 
			return authenticationInfo;
		}else{
			return null;
		}
	}

}
