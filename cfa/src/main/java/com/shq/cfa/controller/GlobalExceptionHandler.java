package com.shq.cfa.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**

 * @author shuihuaqi

 * @create 2018-03-21 14:58

 * @desc 拦截异常

 **/
@ControllerAdvice
public class GlobalExceptionHandler {
  @ResponseBody //拦截是json的返回结果
   public Map<String,Object> exceptionHandler(){
    Map<String,Object> result =  new HashMap<String,Object>();
    result.put("code",500);
    result.put("msg","系统错误,请稍后重试！");
     return null;
   }
}
