package com.shq.cfa.controller;

import com.shq.cfa.entity.Authority;
import com.shq.cfa.entity.User;
import com.shq.cfa.service.AuthorityService;
import com.shq.cfa.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.thymeleaf.expression.Maps;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class UsersController {
    @Autowired
    private UserService userService;

    @Autowired
    private AuthorityService authorityService;

    //查询所有人员返回列表页面
    @GetMapping("/users")
    public String  list(@RequestParam(value="pageIndex",required=false,defaultValue="0") int pageIndex,
                        @RequestParam(value="pageSize",required=false,defaultValue="10") int pageSize,
                        Model model,@ModelAttribute("msg") String message){
       // Pageable pageable = new PageRequest(pageIndex, pageSize);
        Page<User> users = userService.findUserNoCriteria(pageIndex,pageSize);
        //放在请求域中
       // model.addAttribute("datas",pageable);
        model.addAttribute("datas",users);
        model.addAttribute("msg", message);
        // thymeleaf默认就会拼串
        // classpath:/templates/xxxx.html
        return "user/list";
    }

    @GetMapping("/findUserQuery")
    public String  listUserQuery(@RequestParam(value="pageIndex",required=false,defaultValue="0") int pageIndex,
                        @RequestParam(value="pageSize",required=false,defaultValue="10") int pageSize,
                                 @RequestParam(value="name",required=false,defaultValue="") String name,
                        Model model){
        Page<User> users = userService.findUserByNameLike(pageIndex,pageSize,name);
        List<Authority> authority = authorityService.listAuthoritys();
        //放在请求域中
        model.addAttribute("datas",users);
        model.addAttribute("auth",authority);
        // thymeleaf默认就会拼串
        // classpath:/templates/xxxx.html
        return "user/list";
    }

    @GetMapping("/auths")
    public String  authList(Model model,@ModelAttribute("msg") String message){
        List<Authority> authorities = authorityService.listAuthoritys();
        model.addAttribute("authorities",authorities);
        model.addAttribute("msg", message);
        return "authority/list";
    }

    @GetMapping("/authadd")
    public String toAddauthPage(Model model){
        return "authority/add";
    }

    @PostMapping("/auth")
    public ModelAndView addAuth(Model model,RedirectAttributes attrs,@Valid Authority auth, BindingResult bindingResult){
        System.out.println("保存的角色信息："+auth);
        if (bindingResult.hasErrors()) {
            model.addAttribute("err", bindingResult.getFieldError().getDefaultMessage());
            System.out.println(bindingResult.getFieldError().getDefaultMessage());
            return new ModelAndView("authority/add");
        }
        authorityService.saveAuth(auth);
        attrs.addAttribute("msg", "角色添加成功！");
        return new ModelAndView ("redirect:/auths");
    }

    @GetMapping("/auth/{id}")
    public String toEditAuthPage(@PathVariable("id") Integer id,Model model){
        Authority auth = authorityService.getAuthorityById(id);
        model.addAttribute("auth",auth);
        return "authority/add";
    }

    @PutMapping("/auth")
    public ModelAndView updateAuth(Model model,RedirectAttributes attrs,@Valid Authority auth, BindingResult bindingResult){
        System.out.println("修改的角色数据："+auth);
        if (bindingResult.hasErrors()) {
            model.addAttribute("err", bindingResult.getFieldError().getDefaultMessage());
            System.out.println(bindingResult.getFieldError().getDefaultMessage());
            return new ModelAndView("authority/add");
        }
        authorityService.saveAuth(auth);
        attrs.addAttribute("msg", "角色修改成功！");
        return new ModelAndView ("redirect:/auths");
    }

    @DeleteMapping("/auth/{id}")
    public ModelAndView deleteAuth(RedirectAttributes attrs,@PathVariable("id") Integer id){
        authorityService.removeAuth(id);
        attrs.addAttribute("msg", "角色删除成功！");
        return new ModelAndView ("redirect:/auths");
    }

    //来到员工添加页面
    @GetMapping("/user")
    public String toAddPage(Model model){
        List<Authority> authority = authorityService.listAuthoritys();
        model.addAttribute("auth",authority);
        return "user/add";
    }

    //员工添加
    //SpringMVC自动将请求参数和入参对象的属性进行一一绑定；要求请求参数的名字和javaBean入参的对象里面的属性名是一样的
    @PostMapping("/user")
    public ModelAndView addUser(Model model,RedirectAttributes attrs,@Valid User user,BindingResult bindingResult){
        //来到员工列表页面

        System.out.println("保存的员工信息："+user);
        //保存员工
        if (bindingResult.hasErrors()) {
            model.addAttribute("err", bindingResult.getFieldError().getDefaultMessage());
            System.out.println(bindingResult.getFieldError().getDefaultMessage());
            List<Authority> authority = authorityService.listAuthoritys();
            model.addAttribute("auth",authority);
            Map<String,Object> map = new HashMap<>();
            map.put("user",user);
            return new ModelAndView("user/add");
        }
        if ((userService.getUserByName(user.getName()))!=null){
            model.addAttribute("err", "账号已存在！");
            Map<String,Object> map = new HashMap<>();
            map.put("user",user);
            return new ModelAndView("user/add");
        }
        userService.saveUser(user);
        // redirect: 表示重定向到一个地址  /代表当前项目路径
        // forward: 表示转发到一个地址
        attrs.addAttribute("msg", "用户添加成功！");
        return new ModelAndView ("redirect:/users");
    }

    //来到修改页面，查出当前员工，在页面回显
    @GetMapping("/user/{id}")
    public String toEditPage(@PathVariable("id") Integer id,Model model){
        User user = userService.getUserById(id);
        List<Authority> authority = authorityService.listAuthoritys();
        model.addAttribute("auth",authority);
        model.addAttribute("user",user);

        //页面要显示所有的部门列表
        //Collection<Authority> departments = authorityService.listAuthoritys();
        //model.addAttribute("departments",departments);
        //回到修改页面(add是一个修改添加二合一的页面);
        return "user/edit";
    }
    @GetMapping("/userdetail/{id}")
    public String userDetail(@PathVariable("id") Integer id,Model model){
        User user = userService.getUserById(id);
        Authority authority = authorityService.getAuthorityById(user.getAuth());
        model.addAttribute("user",user);
        model.addAttribute("auth",authority);
        return "user/detail";
    }

    //员工修改；需要提交员工id；
    @PutMapping("/user")
    public ModelAndView updateUser(Model model,RedirectAttributes attrs,@Valid User user,BindingResult bindingResult){
        System.out.println("修改的人员数据："+user);
        if (bindingResult.hasErrors()) {
            model.addAttribute("err", bindingResult.getFieldError().getDefaultMessage());
            System.out.println(bindingResult.getFieldError().getDefaultMessage());
            List<Authority> authority = authorityService.listAuthoritys();
            model.addAttribute("auth",authority);
            Map<String,Object> map = new HashMap<>();
            map.put("user",user);
            return new ModelAndView("user/edit");
        }
        userService.saveUser(user);
        attrs.addAttribute("msg", "用户修改成功！");
        return new ModelAndView ("redirect:/users");
    }

    //员工删除
    @DeleteMapping("/user/{id}")
    public ModelAndView deleteUser(RedirectAttributes attrs,@PathVariable("id") Integer id){
        userService.removeUser(id);
        attrs.addAttribute("msg", "用户删除成功！");
        return new ModelAndView ("redirect:/users");
    }



}
