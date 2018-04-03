package com.shq.cfa.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import javax.persistence.*;
import javax.validation.constraints.Size;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * @author shuihuaqi
 * @create 2018-02-27 10:31
 * @desc User 实体
 **/
@Entity // 实体
@DynamicUpdate
@Data
public class User implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id // 主键
  @GeneratedValue(strategy = GenerationType.IDENTITY) // 自增长策略
  private Integer id; // 用户的唯一标识

  @Column
  private String department;

  @Column(nullable = true, length = 1)
  private Integer sex;

  @Column(nullable = true)
  @Temporal(TemporalType.DATE)
  private Date birthday;

  @Column(nullable = true, length = 11)
  private String phone;

  @Column(nullable = true)
  private String nation;

  @Column(nullable = true)
  private String code;

  @Column(nullable = true)
  private String politics;

  @NotBlank(message = "姓名不能为空")
  @Length(min = 2, max = 20, message="长度不能小于2位大于20位")
  @Column(nullable = false, length = 20)
  private String name;

  @NotBlank(message = "邮箱不能为空")
  @Size(max = 50)
  @Email(message = "邮箱格式不对")
  @Column(nullable = false, length = 50, unique = true)
  private String email;

  @NotEmpty(message = "账号不能为空")
  @Length(min = 2, max = 20, message="长度不能小于2位大于20位")
  @Column(nullable = false, length = 20, unique = true)
  private String username; // 用户账号，用户登录时的唯一标识

  @NotBlank(message = "密码不能为空")
  @Size(max = 100)
  @Column(nullable = false)
  private String password; // 登录时密码

  @Column(length = 200)
  private String avatar; // 头像图片地址

  @Column(nullable = true)
  private String address;

  @Temporal(TemporalType.TIMESTAMP)
  @Column(updatable = false)
  @org.hibernate.annotations.CreationTimestamp  // 由数据库自动创建时间
  private Date createTime;

  @Temporal(TemporalType.TIMESTAMP)
  @org.hibernate.annotations.CreationTimestamp  // 由数据库自动创建时间
  private Date updateTime;

  protected User() { // JPA 的规范要求无参构造函数；设为 protected 防止直接使用
  }

  public User( String department, Integer sex, Date birthday, String phone, String nation, String code, String address, String politics, String name, String email, String username, String password,Timestamp createTime, Timestamp updateTime) {
    this.department = department;
    this.sex = sex;
    this.birthday = birthday;
    this.phone = phone;
    this.nation = nation;
    this.code = code;
    this.address = address;
    this.politics = politics;
    this.name = name;
    this.email = email;
    this.username = username;
    this.password = password;
    this.createTime = createTime;
    this.updateTime = updateTime;
  }
}