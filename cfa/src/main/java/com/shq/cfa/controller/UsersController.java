package com.shq.cfa.controller;

import com.shq.cfa.entity.Authority;
import com.shq.cfa.entity.User;
import com.shq.cfa.service.AuthorityService;
import com.shq.cfa.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@Controller
public class UsersController {
    @Autowired
    private UserService userService;

    @Autowired
    private AuthorityService authorityService;

    //查询所有人员返回列表页面
    @GetMapping("/users")
    public String  list(Model model){
        //Pageable pageable = new PageRequest(pageIndex, pageSize);
        //Page<User> page = userService.listUsersByNameLike(name, pageable);
        //List<User> list = page.getContent();	// 当前所在页面数据列表
        //model.addAttribute("page", page);
        List<User> users = userService.listUsers();

        //放在请求域中
        model.addAttribute("users",users);
        // thymeleaf默认就会拼串
        // classpath:/templates/xxxx.html
        return "user/list";
    }

    //来到员工添加页面
    @GetMapping("/user")
    public String toAddPage(Model model){
        //来到添加页面,查出所有的部门，在页面显示
        Collection<Authority> authoritys = authorityService.listAuthoritys();
        model.addAttribute("authoritys",authoritys);
        return "user/add";
    }

    //员工添加
    //SpringMVC自动将请求参数和入参对象的属性进行一一绑定；要求请求参数的名字和javaBean入参的对象里面的属性名是一样的
    @PostMapping("/user")
    public String addUser(User user,BindingResult bindingResult){
        //来到员工列表页面

        System.out.println("保存的员工信息："+user);
        //保存员工
        userService.saveUser(user);
        // redirect: 表示重定向到一个地址  /代表当前项目路径
        // forward: 表示转发到一个地址
        return "redirect:/users";
    }

    //来到修改页面，查出当前员工，在页面回显
    @GetMapping("/user/{id}")
    public String toEditPage(@PathVariable("id") Integer id,Model model){
        User user = userService.getUserById(id);
        model.addAttribute("user",user);

        //页面要显示所有的部门列表
        //Collection<Authority> departments = authorityService.listAuthoritys();
        //model.addAttribute("departments",departments);
        //回到修改页面(add是一个修改添加二合一的页面);
        return "user/add";
    }
    @GetMapping("/userdetail/{id}")
    public String userDetail(@PathVariable("id") Integer id,Model model){
        User user = userService.getUserById(id);
        model.addAttribute("user",user);
        return "user/detail";
    }

    //员工修改；需要提交员工id；
    @PutMapping("/user")
    public String updateEmployee(User user,BindingResult bindingResult){
        System.out.println("修改的人员数据："+user);
        userService.saveUser(user);
        return "redirect:/users";
    }

    //员工删除
    @DeleteMapping("/user/{id}")
    public String deleteEmployee(@PathVariable("id") Integer id){
        userService.removeUser(id);
        return "redirect:/users";
    }



}
