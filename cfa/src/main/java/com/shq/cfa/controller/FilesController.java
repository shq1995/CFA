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

    @GetMapping("/administrationadd")
    public String toAdministrationAddPage(Model model){
        return "file/administrationAdd";
    }

    @GetMapping("/securityadd")
    public String toSecurityAddPage(Model model){
        return "file/securityAdd";
    }

    @GetMapping("/civiladd")
    public String toCivilAddPage(Model model){
        return "file/civilAdd";
    }

    @GetMapping("/penaladd")
    public String toPenalAddPage(Model model){
        return "file/penalAdd";
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
        System.out.println("保存的案件信息："+file);
        //保存案件
        filesService.saveFile(file);
        // redirect: 表示重定向到一个地址  /代表当前项目路径
        // forward: 表示转发到一个地址
        return "file/add";
    }
    @PostMapping("/penalfile")
    public String addPenalFile(Files file, BindingResult bindingResult){
        System.out.println("保存的案件信息："+file);
        file.setType("刑事案卷");
        //保存案件
        filesService.saveFile(file);
        // redirect: 表示重定向到一个地址  /代表当前项目路径
        // forward: 表示转发到一个地址
        return "file/penalList";
    }
    @PostMapping("/securityfile")
    public String addSecurityFile(Files file, BindingResult bindingResult){
        System.out.println("保存的案件信息："+file);
        file.setType("治安案卷");
        //保存案件
        filesService.saveFile(file);
        // redirect: 表示重定向到一个地址  /代表当前项目路径
        // forward: 表示转发到一个地址
        return "file/securityList";
    }
    @PostMapping("/civilfile")
    public String addCivilFile(Files file, BindingResult bindingResult){
        System.out.println("保存的案件信息："+file);
        file.setType("民事案卷");
        //保存案件
        filesService.saveFile(file);
        // redirect: 表示重定向到一个地址  /代表当前项目路径
        // forward: 表示转发到一个地址
        return "file/civilList";
    }
    @PostMapping("/administrationfile")
    public String addAdministrationFile(Files file, BindingResult bindingResult){
        System.out.println("保存的案件信息："+file);
        file.setType("行政案卷");
        //保存案件
        filesService.saveFile(file);
        // redirect: 表示重定向到一个地址  /代表当前项目路径
        // forward: 表示转发到一个地址
        return "file/administrationList";
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
    @GetMapping("/administrationfiledetail/{id}")
    public String fileAdministrationDetail(@PathVariable("id") Integer id,Model model){
        Files file = filesService.getFileById(id);
        model.addAttribute("file",file);
        return "file/administrationFileDetail";
    }

    @GetMapping("/penalfiledetail/{id}")
    public String filePenalDetail(@PathVariable("id") Integer id,Model model){
        Files file = filesService.getFileById(id);
        model.addAttribute("file",file);
        return "file/penalFileDetail";
    }

    @GetMapping("/securityfiledetail/{id}")
    public String fileSecurityDetail(@PathVariable("id") Integer id,Model model){
        Files file = filesService.getFileById(id);
        model.addAttribute("file",file);
        return "file/securityFileDetail";
    }

    @GetMapping("/civilfiledetail/{id}")
    public String fileCivilDetail(@PathVariable("id") Integer id,Model model){
        Files file = filesService.getFileById(id);
        model.addAttribute("file",file);
        return "file/civilFileDetail";
    }

    //案卷修改；
    @PutMapping("/penalfile")
    public String updatePenalFile(Files file,BindingResult bindingResult){
        System.out.println("修改的案件数据："+file);
        filesService.saveFile(file);
        return "redirect:/penalList";
    }

    @PutMapping("/civilfile")
    public String updateCivilFile(Files file,BindingResult bindingResult){
        System.out.println("修改的案件数据："+file);
        filesService.saveFile(file);
        return "redirect:/civilList";
    }

    @PutMapping("/securityfile")
    public String updateSecurityFile(Files file,BindingResult bindingResult){
        System.out.println("修改的案件数据："+file);
        filesService.saveFile(file);
        return "redirect:/securityList";
    }

    @PutMapping("/administrationfile")
    public String updateAdministrationFile(Files file,BindingResult bindingResult){
        System.out.println("修改的案件数据："+file);
        filesService.saveFile(file);
        return "redirect:/administrationList";
    }
    //案卷删除
    @DeleteMapping("/file/{id}")
    public String deleteFile(@PathVariable("id") Integer id){
        filesService.removeFile(id);
        return "redirect:/files";
    }



}
