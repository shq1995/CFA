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

import java.util.List;

@Controller
public class FilesTypeController {
    @Autowired
    private FilesTypeService filesTypeService;


    //查询所有人员返回列表页面
    @GetMapping("/filesTypes")
    public String  list(@RequestParam(value="pageIndex",required=false,defaultValue="0") int pageIndex,
                        @RequestParam(value="pageSize",required=false,defaultValue="10") int pageSize,
                        Model model){
        Page<FilesType> filesTypes = filesTypeService.findFilesTypeNoCriteria(pageIndex,pageSize);
        model.addAttribute("datas",filesTypes);
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
    public String addUser(FilesType filesType,BindingResult bindingResult){
        filesTypeService.saveFilesType(filesType);
        return "redirect:/filesTypes";
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
        return "filesType/add";
    }
    //删除
    @DeleteMapping("/filesType/{id}")
    public String deleteUser(@PathVariable("id") Integer id){
        filesTypeService.removeFilesTppe(id);
        return "redirect:/filesTypes";
    }
}
