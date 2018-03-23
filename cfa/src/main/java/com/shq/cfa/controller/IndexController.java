package com.shq.cfa.controller;

import com.shq.cfa.dao.EmpDao;
import com.shq.cfa.entity.EmpEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author shuihuaqi
 * @create 2018-03-23 15:06
 * @desc
 **/
@RestController
public class IndexController {
  @Autowired
  private EmpDao empDao;
  @RequestMapping("/index")
  public String index(Integer id){
    EmpEntity empEntity = empDao.findOne(id);
    return empEntity.toString();
  }

}
