package com.shq.cfa.app;

import com.shq.cfa.controller.TestContoller;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


/**
 * @author shuihuaqi
 * @create 2018-03-23 15:12
 * @desc
 **/
@ComponentScan(basePackages = "com.shq.cfa.controller")
@EnableJpaRepositories(basePackages = "com.shq.cfa.dao")
@EntityScan("com.shq.cfa.entity")
@EnableAutoConfiguration
public class App {
  public static void main(String[] args){
    //运行
    SpringApplication.run(App.class,args);
  }
}
