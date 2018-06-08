package com.lz.cfa.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.lz.cfa.component.MyLocaleResolver;
import com.lz.cfa.entity.*;
import com.lz.cfa.service.*;
import com.lz.cfa.entity.*;
import com.lz.cfa.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author
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
	@Autowired
	private FilesTypeService filesTypeService;
	@Autowired
	private FilesService filesService;
	@Autowired
	private FilesKeywordService filesKeywordService;

	@GetMapping("/")
	public String root() {
		return "redirect:/login";
	}

	/**
	 * 获取登录界面
	 * @return
	 */
	@GetMapping("/login")
	public String login(HttpServletRequest request, HttpSession session) {
		Object user = request.getSession().getAttribute("loginUser");
		session.removeAttribute("loginUser");
		return "login";
	}

	/**
	 * 获取登录界面
	 * @return
	 */
	@GetMapping("/main")
	public ModelAndView main(Model model) {
		List<FilesType> filesTypes = filesTypeService.findAll();
		Map<String,Object> map = new HashMap<>();
		JSONArray xarray = new JSONArray();
		JSONArray yarray = new JSONArray();
		JSONArray zarray = new JSONArray();
		JSONArray barray = new JSONArray();
		for (FilesType filesType : filesTypes){
			List<Files> files = filesService.findByType(filesType.getId());
			List<FilesKeyword> filesKeywords = filesKeywordService.findByType(filesType.getId());
			xarray.add(filesType.getName());
			yarray.add(files.size());
			zarray.add(filesKeywords.size());
			JSONObject json = new JSONObject();
			json.put("value",filesKeywords.size());
			json.put("name",filesType.getName());
			barray.add(json);
		}
		map.put("xarray", xarray.toJSONString());
		map.put("yarray", yarray.toJSONString());
		map.put("zarray", zarray.toJSONString());
		map.put("barray", barray.toJSONString());
		return new ModelAndView("main",map);
	}

	@PostMapping("/login")
	public String auth(Model model, HttpSession session, @RequestParam String username, @RequestParam String password) {
		User user = userService.getUserByName(username);
		//System.out.println(user.getAuth());
		//System.out.println(authority.getName());
		if (user != null) {
			Authority authority = authorityService.getAuthorityById(user.getAuth());
			if (user.getPassword().equals(password)) {
				session.setAttribute("loginUser",user.getName());
				session.setAttribute("loginUserId",user.getId());
				session.setAttribute("authName",authority.getName());
				return "redirect:/main";
			}
		}
		model.addAttribute("loginError", true);
		model.addAttribute("errorMsg", "登陆失败，账号或者密码错误！");
		return "login";
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
