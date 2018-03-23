package com.shq.cfa.controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author shuihuaqi
 * @create 2018-03-21 14:26
 * @desc Spring Boot 测试
 **/
@RestController
//@EnableAutoConfiguration
public class TestContoller {
  @RequestMapping("/hello")
  public String hello(){
    return "hello";
  }
  /*public static void main(String[] args){
    //运行
    SpringApplication.run(TestContoller.class,args);
  }*/
}
