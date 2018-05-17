package com.shq.cfa.controller;

import com.shq.cfa.entity.Files;
import com.shq.cfa.entity.FilesKeyword;
import com.shq.cfa.entity.FilesType;
import com.shq.cfa.service.FilesKeywordService;
import com.shq.cfa.service.FilesService;
import com.shq.cfa.service.FilesTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class FilesTypeController {
    @Autowired
    private FilesTypeService filesTypeService;


    //查询所有人员返回列表页面
    @GetMapping("/filesTypes")
    public String  list(@RequestParam(value="pageIndex",required=false,defaultValue="0") int pageIndex,
                        @RequestParam(value="pageSize",required=false,defaultValue="10") int pageSize,
                        Model model,@ModelAttribute("msg") String message){
        Page<FilesType> filesTypes = filesTypeService.findFilesTypeNoCriteria(pageIndex,pageSize);
        model.addAttribute("datas",filesTypes);
        model.addAttribute("msg", message);
        return "filesType/list";
    }

    @GetMapping("/findFilesTypeQuery")
    public String  listUserQuery(@RequestParam(value="pageIndex",required=false,defaultValue="0") int pageIndex,
                                 @RequestParam(value="pageSize",required=false,defaultValue="10") int pageSize,
                                 @RequestParam(value="name",required=false,defaultValue="") String name,
                                 Model model){
        Page<FilesType> filesTypes = filesTypeService.findFilesTypeCriteria(pageIndex,pageSize,name);
        model.addAttribute("datas",filesTypes);
        return "filesType/list";
    }


    //来到添加页面
    @GetMapping("/filesType")
    public String toAddPage(Model model){
        return "filesType/add";
    }

    //添加
    @PostMapping("/filesType")
    public ModelAndView addUser(Model model, RedirectAttributes attrs, @Valid FilesType filesType, BindingResult bindingResult){
        System.out.println("保存的案卷类型信息："+filesType);
        //保存案卷类型
        if (bindingResult.hasErrors()) {
            model.addAttribute("err", bindingResult.getFieldError().getDefaultMessage());
            System.out.println(bindingResult.getFieldError().getDefaultMessage());
            Map<String,Object> map = new HashMap<>();
            map.put("type",filesType);
            return new ModelAndView("filesType/add",map);
        }
        if ((filesTypeService.getFilesTypeByName(filesType.getName()))!=null){
            model.addAttribute("err", "案卷名称已存在！");
            Map<String,Object> map = new HashMap<>();
            map.put("type",filesType);
            return new ModelAndView("filesType/add",map);
        }
            filesType.setBasics(2);
        filesTypeService.saveFilesType(filesType);
        attrs.addAttribute("msg", "案卷类型添加成功！");
        return new ModelAndView ("redirect:/filesTypes");
    }

    @GetMapping("/filesTypedetail/{id}")
    public String userDetail(@PathVariable("id") Integer id,Model model){
        FilesType filesType = filesTypeService.getFilesTypeById(id);
        model.addAttribute("type",filesType);
        return "filesType/detail";
    }

    @GetMapping("/filesType/{id}")
    public String toEditPage(@PathVariable("id") Integer id,Model model){
        FilesType filesType = filesTypeService.getFilesTypeById(id);
        model.addAttribute("type",filesType);
        return "filesType/edit";
    }

    @PutMapping("/filesType")
    public ModelAndView updateUser(Model model,RedirectAttributes attrs,@Valid FilesType filesType,BindingResult bindingResult){
        System.out.println("修改的案卷类型数据："+filesType);
        if (bindingResult.hasErrors()) {
            model.addAttribute("err", bindingResult.getFieldError().getDefaultMessage());
            System.out.println(bindingResult.getFieldError().getDefaultMessage());
            Map<String,Object> map = new HashMap<>();
            map.put("type",filesType);
            return new ModelAndView("filesType/edit",map);
        }
        filesType.setBasics(2);
        filesTypeService.saveFilesType(filesType);
        attrs.addAttribute("msg", "案卷类型修改成功！");
        return new ModelAndView ("redirect:/filesTypes");
    }
    //删除
    @DeleteMapping("/filesType/{id}")
    public ModelAndView deleteUser(RedirectAttributes attrs,@PathVariable("id") Integer id){
        filesTypeService.removeFilesTppe(id);
        attrs.addAttribute("msg", "案卷类型删除成功！");
        return new ModelAndView ("redirect:/filesTypes");
    }
}
