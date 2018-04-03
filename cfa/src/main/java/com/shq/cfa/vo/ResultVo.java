package com.shq.cfa.vo;

import lombok.Data;

/**
 * @author shuihuaqi
 * @create 2018-04-03 15:48
 * @desc
 **/
@Data
public class ResultVo<T> {
  /**
   * 错误码
   */
  private Integer code;
  /**
   * 提示信息
   */
  private String msg;
  /**
   * 具体内容
   */
  private T data;
}
