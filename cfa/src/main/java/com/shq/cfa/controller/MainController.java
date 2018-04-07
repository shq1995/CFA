package com.shq.cfa.controller;

import com.shq.cfa.component.MyLocaleResolver;
import com.shq.cfa.entity.User;
import com.shq.cfa.service.AuthorityService;
import com.shq.cfa.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.LocaleResolver;

import javax.servlet.http.HttpSession;

/**
 * @author shuihuaqi
 * @create 2018-03-27 10:32
 * @desc 主页控制器
 **/
@Controller
public class MainController {
	
	private static final Integer ROLE_USER_AUTHORITY_ID = 1;
	
	@Autowired
	private UserService userService;
	@Autowired
	private AuthorityService authorityService;

	@GetMapping("/")
	public String root() {
		return "redirect:/login";
	}

	/**
	 * 获取登录界面
	 * @return
	 */
	@GetMapping("/login")
	public String login() {
		return "login";
	}

	/**
	 * 获取登录界面
	 * @return
	 */
	@GetMapping("/main")
	public String main() {
		return "main";
	}

	@PostMapping("/auth")
	public String auth(Model model, HttpSession session, @RequestParam String username, @RequestParam String password) {
		User user = userService.getUserByName(username);
		if (user != null) {
			if (user.getPassword().equals(password)) {
				session.setAttribute("loginUser",user.getName());
				return "redirect:/main";
			}
		}
		return "redirect:/login-error";
	}

	@GetMapping("/login-error")
	public String loginError(Model model) {
		model.addAttribute("loginError", true);
		model.addAttribute("errorMsg", "登陆失败，账号或者密码错误！");
		return "login";
	}

	@Bean
	public LocaleResolver localeResolver(){

		return new MyLocaleResolver();
	}
}
