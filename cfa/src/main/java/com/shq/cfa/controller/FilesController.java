package com.shq.cfa.controller;

import com.shq.cfa.entity.Files;
import com.shq.cfa.entity.FilesKeyword;
import com.shq.cfa.entity.FilesType;
import com.shq.cfa.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
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
    private FilesKeywordService filesKeywordService;

    @Autowired
    private FilesTypeService filesTypeService;

    @GetMapping("/files")
    public String  list(@RequestParam(value="pageIndex",required=false,defaultValue="0") int pageIndex,
                        @RequestParam(value="pageSize",required=false,defaultValue="10") int pageSize,
                        Model model){
        Page<Files> files = filesService.findFilesNoCriteria(pageIndex,pageSize);
        List<FilesType> filesTypes = filesTypeService.findAll();
        model.addAttribute("datas",files);
        model.addAttribute("types",filesTypes);
        return "file/list";
    }
    @GetMapping("/findFilesQuery")
    public String  listKeywordQuery(@RequestParam(value="pageIndex",required=false,defaultValue="0") int pageIndex,
                                    @RequestParam(value="pageSize",required=false,defaultValue="10") int pageSize,
                                    @RequestParam(value="title",required=false,defaultValue="") String title,
                                    @RequestParam(value="number",required=false,defaultValue="") String number,
                                    Model model){
        Page<Files> files = filesService.findFileCriteria(pageIndex,pageSize,title,number);
        //放在请求域中
        model.addAttribute("datas",files);
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
    public String toPagePenal(@RequestParam(value="pageIndex",required=false,defaultValue="0") int pageIndex,
                              @RequestParam(value="pageSize",required=false,defaultValue="10") int pageSize,
                              Model model){
        Page<Files> files = filesService.findFilesTypeCriteria(pageIndex,pageSize,"刑事案卷");
        model.addAttribute("datas",files);
        return "file/penalList";
    }
    @GetMapping("/penalQuery")
    public String toPagePenalCondition(@RequestParam(value="pageIndex",required=false,defaultValue="0") int pageIndex,
                              @RequestParam(value="pageSize",required=false,defaultValue="10") int pageSize,
                                       @RequestParam(value="title",required=false,defaultValue="") String title,
                                       @RequestParam(value="number",required=false,defaultValue="") String number,
                              Model model){
        Page<Files> files = filesService.findFilesCriteria(pageIndex,pageSize,title,number,"刑事案卷");
        model.addAttribute("datas",files);
        return "file/penalList";
    }
    //来到刑事案件页面
    @GetMapping("/civil")
    public String toPageCivil(@RequestParam(value="pageIndex",required=false,defaultValue="0") int pageIndex,
                              @RequestParam(value="pageSize",required=false,defaultValue="10") int pageSize,
                             Model model){
        Page<Files> files = filesService.findFilesTypeCriteria(pageIndex,pageSize,"民事案卷");
        model.addAttribute("datas",files);
        return "file/civilList";
    }
    @GetMapping("/civilQuery")
    public String toPageCivilCondition(@RequestParam(value="pageIndex",required=false,defaultValue="0") int pageIndex,
                              @RequestParam(value="pageSize",required=false,defaultValue="10") int pageSize,
                                       @RequestParam(value="title",required=false,defaultValue="") String title,
                                       @RequestParam(value="number",required=false,defaultValue="") String number,
                              Model model){
        Page<Files> files = filesService.findFilesCriteria(pageIndex,pageSize,title,number,"民事案卷");
        model.addAttribute("datas",files);
        return "file/civilList";
    }
    //来到刑事案件页面
    @GetMapping("/security")
    public String toPageSecurity(@RequestParam(value="pageIndex",required=false,defaultValue="0") int pageIndex,
                                 @RequestParam(value="pageSize",required=false,defaultValue="10") int pageSize,
                                 Model model){
        Page<Files> files = filesService.findFilesTypeCriteria(pageIndex,pageSize,"治安案卷");
        model.addAttribute("datas",files);
        return "file/securityList";
    }
    @GetMapping("/securityQuery")
    public String toPageSecurityCondition(@RequestParam(value="pageIndex",required=false,defaultValue="0") int pageIndex,
                                       @RequestParam(value="pageSize",required=false,defaultValue="10") int pageSize,
                                       @RequestParam(value="title",required=false,defaultValue="") String title,
                                       @RequestParam(value="number",required=false,defaultValue="") String number,
                                       Model model){
        Page<Files> files = filesService.findFilesCriteria(pageIndex,pageSize,title,number,"治安案卷");
        model.addAttribute("datas",files);
        return "file/securityList";
    }
    //来到刑事案件页面
    @GetMapping("/administration")
    public String toPageAdministration(@RequestParam(value="pageIndex",required=false,defaultValue="0") int pageIndex,
                                       @RequestParam(value="pageSize",required=false,defaultValue="10") int pageSize,
                                       Model model){
        Page<Files> files = filesService.findFilesTypeCriteria(pageIndex,pageSize,"行政案卷");
        model.addAttribute("datas",files);
        return "file/administrationList";
    }
    @GetMapping("/administrationQuery")
    public String toPageAdministrationCondition(@RequestParam(value="pageIndex",required=false,defaultValue="0") int pageIndex,
                                          @RequestParam(value="pageSize",required=false,defaultValue="10") int pageSize,
                                          @RequestParam(value="title",required=false,defaultValue="") String title,
                                          @RequestParam(value="number",required=false,defaultValue="") String number,
                                          Model model){
        Page<Files> files = filesService.findFilesCriteria(pageIndex,pageSize,title,number,"行政案卷");
        model.addAttribute("datas",files);
        return "file/administrationList";
    }
    //案件添加
    @PostMapping("/file")
    public String addFile(Model model,Files file, BindingResult bindingResult){
        System.out.println("保存的案件信息："+file);
        //保存案件
        int index = 0;
        Float weights = 0f;
        String content = file.getStartCause() + file.getStartDesc() + file.getEndCause() + file.getSummary();
        List<FilesType> filesTypes = filesTypeService.findAll();
        for (FilesType filesType : filesTypes){
            List<FilesKeyword> keywords = filesKeywordService.findByType(filesType.getId());
            Float weight = 0f;
            for (FilesKeyword keyword: keywords){
                boolean include = content.contains(keyword.getKeyword());
                if (include){
                    weight += keyword.getWeight();
                }
            }
            if (weight >= weights){
                weights = weight;
                index += 1;
            }
        }
        List<FilesKeyword> keywords = filesKeywordService.findByType(index);
        for (FilesKeyword keyword: keywords){
            boolean include = content.contains(keyword.getKeyword());
            if (include){
                keyword.setWeight(keyword.getWeight()+0.01f);
                filesKeywordService.save(keyword);
            }
        }
        file.setType(index);
        FilesType type = filesTypeService.getFilesTypeById(index);
        filesService.saveFile(file);
        model.addAttribute("msg", "案卷已归入"+type.getName());
        return "file/add";
    }
    @PostMapping("/penalfile")
    public String addPenalFile(Files file, BindingResult bindingResult){
        System.out.println("保存的案件信息："+file);
        file.setType(2);
        //保存案件
        filesService.saveFile(file);
        // redirect: 表示重定向到一个地址  /代表当前项目路径
        // forward: 表示转发到一个地址
        return "file/penalList";
    }
    @PostMapping("/securityfile")
    public String addSecurityFile(Files file, BindingResult bindingResult){
        System.out.println("保存的案件信息："+file);
        file.setType(3);
        //保存案件
        filesService.saveFile(file);
        // redirect: 表示重定向到一个地址  /代表当前项目路径
        // forward: 表示转发到一个地址
        return "file/securityList";
    }
    @PostMapping("/civilfile")
    public String addCivilFile(Files file, BindingResult bindingResult){
        System.out.println("保存的案件信息："+file);
        file.setType(1);
        //保存案件
        filesService.saveFile(file);
        // redirect: 表示重定向到一个地址  /代表当前项目路径
        // forward: 表示转发到一个地址
        return "file/civilList";
    }
    @PostMapping("/administrationfile")
    public String addAdministrationFile(Files file, BindingResult bindingResult){
        System.out.println("保存的案件信息："+file);
        file.setType(4);
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
