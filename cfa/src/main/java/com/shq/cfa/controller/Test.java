package com.shq.cfa.controller;

/**
 * @author shuihuaqi
 * @create 2018-04-13 15:26
 * @desc
 **/
public class Test {
  public static void main(String[] args){
    String str = "朋友这些年一个人，风也过，雨也走，有过泪，有过错, 还记得坚持甚么，真爱过才会懂，会寂寞会回首，终有梦终有你在心中。"
            +"朋友一生一起走，那些日子不再有，一句话，一辈子，一生情，一杯酒。朋友不曾孤单过，一声朋友你会懂，还有伤，还有痛朋友，还要走，还有我。";

    str =  str+"-";

    boolean arr = str.contains("朋友");
    System.out.println(arr);
    /* if(str.endsWith("朋友")){
System.out.println(arr.length);
     }else{
       System.out.println(arr.length-1);
     }*/

  }
}
