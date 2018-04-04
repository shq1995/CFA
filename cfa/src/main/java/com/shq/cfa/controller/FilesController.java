package com.shq.cfa.controller;

import com.shq.cfa.entity.Files;
import com.shq.cfa.entity.User;
import com.shq.cfa.service.AuthorityService;
import com.shq.cfa.service.FilesService;
import com.shq.cfa.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class FilesController {
    @Autowired
    private FilesService filesService;

    @Autowired
    private AuthorityService authorityService;

    @GetMapping("/files")
    public String  list(Model model){
        List<Files> files = filesService.listFiles();
        model.addAttribute("files",files);
        return "file/list";
    }
    //来到案件添加页面
    @GetMapping("/file")
    public String toAddPage(Model model){
        return "file/add";
    }

    //来到刑事案件页面
    @GetMapping("/penal")
    public String toPagePenal(Model model){
        List<Files> files = filesService.findByType("刑事案卷");
        model.addAttribute("files",files);
        return "file/penalList";
    }
    //来到刑事案件页面
    @GetMapping("/civil")
    public String toPageCivil(Model model){
        List<Files> files = filesService.findByType("民事案卷");
        model.addAttribute("files",files);
        return "file/civilList";
    }
    //来到刑事案件页面
    @GetMapping("/security")
    public String toPageSecurity(Model model){
        List<Files> files = filesService.findByType("治安案卷");
        model.addAttribute("files",files);
        return "file/securityList";
    }
    //来到刑事案件页面
    @GetMapping("/administration")
    public String toPageAdministration(Model model){
        List<Files> files = filesService.findByType("行政案卷");
        model.addAttribute("files",files);
        return "file/administrationList";
    }

    //案件添加
    //SpringMVC自动将请求参数和入参对象的属性进行一一绑定；要求请求参数的名字和javaBean入参的对象里面的属性名是一样的
    @PostMapping("/file")
    public String addFile(Files file, BindingResult bindingResult){
        //来到案件列表页面

        System.out.println("保存的案件信息："+file);
        //保存案件
        filesService.saveFile(file);
        // redirect: 表示重定向到一个地址  /代表当前项目路径
        // forward: 表示转发到一个地址
        return "file/add";
    }

    @GetMapping("/file/{id}")
    public String toEditPage(@PathVariable("id") Integer id,Model model){
        Files file = filesService.getFileById(id);
        model.addAttribute("file",file);
        return "file/add";
    }
    @GetMapping("/filedetail/{id}")
    public String fileDetail(@PathVariable("id") Integer id,Model model){
        Files file = filesService.getFileById(id);
        model.addAttribute("file",file);
        return "file/detail";
    }

    //案卷修改；
    @PutMapping("/file")
    public String updateFile(Files file,BindingResult bindingResult){
        System.out.println("修改的案件数据："+file);
        filesService.saveFile(file);
        return "redirect:/files";
    }

    //案卷删除
    @DeleteMapping("/file/{id}")
    public String deleteFile(@PathVariable("id") Integer id){
        filesService.removeFile(id);
        return "redirect:/files";
    }



}