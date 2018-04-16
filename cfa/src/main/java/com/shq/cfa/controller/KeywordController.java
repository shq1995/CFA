package com.shq.cfa.controller;

import com.shq.cfa.entity.FilesKeyword;
import com.shq.cfa.entity.FilesType;
import com.shq.cfa.service.FilesKeywordService;
import com.shq.cfa.service.FilesTypeService;
import javassist.compiler.ast.Keyword;
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
public class KeywordController {
    @Autowired
    private FilesKeywordService filesKeywordService;

    @Autowired
    private FilesTypeService filesTypeService;

    @GetMapping("/keywords")
    public String  list(@RequestParam(value="pageIndex",required=false,defaultValue="0") int pageIndex,
                        @RequestParam(value="pageSize",required=false,defaultValue="10") int pageSize,
                        Model model,@ModelAttribute("msg") String message){
        Page<FilesKeyword> keywords = filesKeywordService.findKeywordNoCriteria(pageIndex,pageSize);
        //放在请求域中
        List<FilesType> filesTypes = filesTypeService.findAll();
        model.addAttribute("datas",keywords);
        model.addAttribute("types",filesTypes);
        model.addAttribute("msg", message);
        return "keyword/list";
    }
    @GetMapping("/findKeywordQuery")
    public String  listKeywordQuery(@RequestParam(value="pageIndex",required=false,defaultValue="0") int pageIndex,
                                 @RequestParam(value="pageSize",required=false,defaultValue="10") int pageSize,
                                    @RequestParam(value="type",required=false,defaultValue="") String type,
                                    @RequestParam(value="keyword",required=false,defaultValue="") String keyword,
                                 Model model){
        Page<FilesKeyword> keywords = filesKeywordService.findKeywordCriteria(pageIndex,pageSize,type,keyword);
        //放在请求域中
        model.addAttribute("datas",keywords);
        return "keyword/list";
    }

    @GetMapping("/keyword")
    public String toAddPage(Model model){
        List<FilesType> filesTypes = filesTypeService.findAll();
        model.addAttribute("types",filesTypes);
        return "keyword/add";
    }

    @PostMapping("/keyword")
    public ModelAndView addUser(Model model, RedirectAttributes attrs, @Valid FilesKeyword filesKeyword, BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            model.addAttribute("err", bindingResult.getFieldError().getDefaultMessage());
            System.out.println(bindingResult.getFieldError().getDefaultMessage());
            List<FilesType> filesTypes = filesTypeService.findAll();
            model.addAttribute("types",filesTypes);
            Map<String,Object> map = new HashMap<>();
            map.put("filesKeyword",filesKeyword);
            return new ModelAndView("keyword/add",map);
        }
        if ((filesKeywordService.findByTypeAndKeyword(filesKeyword.getType(),filesKeyword.getKeyword()))!=null){
            FilesType filesType = filesTypeService.getFilesTypeById(filesKeyword.getType());
            model.addAttribute("err", filesType.getName()+"里该关键字已存在！");
            Map<String,Object> map = new HashMap<>();
            map.put("filesKeyword",filesKeyword);
            return new ModelAndView("keyword/add",map);
        }
        System.out.println("保存的关键字信息："+filesKeyword);
        filesKeywordService.save(filesKeyword);
        attrs.addAttribute("msg", "关键字添加成功！");
        return new ModelAndView("redirect:/keywords");
    }

    @GetMapping("/keyword/{id}")
    public String toEditPage(@PathVariable("id") Integer id,Model model){
        FilesKeyword filesKeyword = filesKeywordService.findOne(id);
        List<FilesType> filesTypes = filesTypeService.findAll();
        model.addAttribute("types",filesTypes);
        model.addAttribute("filesKeyword",filesKeyword);
        return "keyword/edit";
    }

    @PutMapping("/keyword")
    public ModelAndView updateUser(Model model,RedirectAttributes attrs,@Valid FilesKeyword filesKeyword,BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            model.addAttribute("err", bindingResult.getFieldError().getDefaultMessage());
            System.out.println(bindingResult.getFieldError().getDefaultMessage());
            List<FilesType> filesTypes = filesTypeService.findAll();
            model.addAttribute("types",filesTypes);
            Map<String,Object> map = new HashMap<>();
            map.put("filesKeyword",filesKeyword);
            return new ModelAndView("keyword/edit");
        }
        System.out.println("修改的关键字数据："+filesKeyword);
        filesKeywordService.save(filesKeyword);
        attrs.addAttribute("msg", "关键字修改成功！");
        return new ModelAndView ("redirect:/keywords");
    }

    //员工删除
    @DeleteMapping("/keyword/{id}")
    public ModelAndView deleteUser(RedirectAttributes attrs,@PathVariable("id") Integer id){
        filesKeywordService.removeFilesKeyword(id);
        attrs.addAttribute("msg", "关键字删除成功！");
        return new ModelAndView ("redirect:/keywords");
    }



}
