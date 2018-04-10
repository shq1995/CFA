package com.shq.cfa.controller;

import com.shq.cfa.entity.FilesKeyword;
import com.shq.cfa.service.AuthorityService;
import com.shq.cfa.service.FilesKeywordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;


@Controller
public class KeywordController {
    @Autowired
    private FilesKeywordService filesKeywordService;

    @Autowired
    private AuthorityService authorityService;

    //查询关键字返回列表页面
/*    @GetMapping("/keywords")
    public String  list(Model model){
        List<FilesKeyword> filesKeywords = filesKeywordService.findAll();
        //放在请求域中
        model.addAttribute("filesKeywords",filesKeywords);
        return "keyword/list";
    }*/
    @GetMapping("/keywords")
    public String  list(@RequestParam(value="pageIndex",required=false,defaultValue="0") int pageIndex,
                        @RequestParam(value="pageSize",required=false,defaultValue="10") int pageSize,
                        Model model){
        // Pageable pageable = new PageRequest(pageIndex, pageSize);
        Page<FilesKeyword> keywords = filesKeywordService.findKeywordNoCriteria(pageIndex,pageSize);
        //放在请求域中
        // model.addAttribute("datas",pageable);
        model.addAttribute("datas",keywords);
        // thymeleaf默认就会拼串
        // classpath:/templates/xxxx.html
        return "keyword/list";
    }
    @GetMapping("/findKeywordQuery")
    public String  listKeywordQuery(@RequestParam(value="pageIndex",required=false,defaultValue="0") int pageIndex,
                                 @RequestParam(value="pageSize",required=false,defaultValue="10") int pageSize,
                                    @RequestParam(value="name",required=false,defaultValue="") String type,
                                    @RequestParam(value="name",required=false,defaultValue="") String keyword,
                                 Model model){
        Page<FilesKeyword> keywords = filesKeywordService.findKeywordCriteria(pageIndex,pageSize,type,keyword);
        //放在请求域中
        model.addAttribute("datas",keywords);
        return "keyword/list";
    }

    @GetMapping("/keyword")
    public String toAddPage(Model model){

        return "keyword/add";
    }

    @PostMapping("/keyword")
    public String addUser(FilesKeyword filesKeyword,BindingResult bindingResult){
        System.out.println("保存的关键字信息："+filesKeyword);
        filesKeywordService.save(filesKeyword);
        // redirect: 表示重定向到一个地址  /代表当前项目路径
        // forward: 表示转发到一个地址
        return "redirect:/keywords";
    }

    @GetMapping("/keyword/{id}")
    public String toEditPage(@PathVariable("id") Integer id,Model model){
        FilesKeyword filesKeyword = filesKeywordService.findOne(id);
        model.addAttribute("filesKeyword",filesKeyword);
        return "keyword/edit";
    }

    @PutMapping("/keyword")
    public String updateUser(FilesKeyword filesKeyword,BindingResult bindingResult){
        System.out.println("修改的关键字数据："+filesKeyword);
        filesKeywordService.save(filesKeyword);
        return "redirect:/keywords";
    }

    //员工删除
    @DeleteMapping("/keyword/{id}")
    public String deleteUser(@PathVariable("id") Integer id){
        filesKeywordService.removeFilesKeyword(id);
        return "redirect:/keywords";
    }



}
