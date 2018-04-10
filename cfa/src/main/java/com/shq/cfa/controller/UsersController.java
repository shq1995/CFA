package com.shq.cfa.controller;

import com.shq.cfa.entity.Authority;
import com.shq.cfa.entity.User;
import com.shq.cfa.service.AuthorityService;
import com.shq.cfa.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
                        Model model){
       // Pageable pageable = new PageRequest(pageIndex, pageSize);
        Page<User> users = userService.findUserNoCriteria(pageIndex,pageSize);
        //放在请求域中
       // model.addAttribute("datas",pageable);
        model.addAttribute("datas",users);
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
        //放在请求域中
        model.addAttribute("datas",users);
        // thymeleaf默认就会拼串
        // classpath:/templates/xxxx.html
        return "user/list";
    }

    @GetMapping("/auths")
    public String  authList(Model model){
        List<Authority> authorities = authorityService.listAuthoritys();
        model.addAttribute("authorities",authorities);
        return "authority/list";
    }

    @GetMapping("/authadd")
    public String toAddauthPage(Model model){
        return "authority/add";
    }

    @PostMapping("/auth")
    public String addAuth(Authority auth,BindingResult bindingResult){
        System.out.println("保存的角色信息："+auth);
        authorityService.saveAuth(auth);
        return "redirect:/auths";
    }

    @GetMapping("/auth/{id}")
    public String toEditAuthPage(@PathVariable("id") Integer id,Model model){
        Authority auth = authorityService.getAuthorityById(id);
        model.addAttribute("auth",auth);
        return "authority/add";
    }

    @PutMapping("/auth")
    public String updateAuth(Authority auth,BindingResult bindingResult){
        System.out.println("修改的角色数据："+auth);
        authorityService.saveAuth(auth);
        return "redirect:/auths";
    }

    @DeleteMapping("/auth/{id}")
    public String deleteAuth(@PathVariable("id") Integer id){
        authorityService.removeAuth(id);
        return "redirect:/auths";
    }

    //来到员工添加页面
    @GetMapping("/user")
    public String toAddPage(Model model){

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
    public String updateUser(User user,BindingResult bindingResult){
        System.out.println("修改的人员数据："+user);
        userService.saveUser(user);
        return "redirect:/users";
    }

    //员工删除
    @DeleteMapping("/user/{id}")
    public String deleteUser(@PathVariable("id") Integer id){
        userService.removeUser(id);
        return "redirect:/users";
    }



}
