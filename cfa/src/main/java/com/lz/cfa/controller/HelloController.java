package com.lz.cfa.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author
 * @create 2018-03-27 10:32
 * @desc Hello World控制器
 **/
@RestController
public class HelloController {

	@RequestMapping("/hello")
	public String hello() {
	    return "Hello World!";
	}
 
}
 