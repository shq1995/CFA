package com.lz.cfa.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * @author
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

  @NotBlank(message = "部门不能为空!")
  @Column(nullable = false)
  private String department;

  @NotNull(message = "性别不能为空!")
  @Column(nullable = false)
  private Integer sex;

  @Column(nullable = true)
  @Temporal(TemporalType.DATE)
  private Date birthday;
@Size(min = 11, max = 11,message="请输入11位的手机号码!")
  @Column(nullable = true, length = 11)
  private String phone;

  @Column(nullable = true)
  private String nation;

  @Column(nullable = true)
  private String code;

  @Column(nullable = true)
  private String politics;

  @NotBlank(message = "姓名不能为空!")
  @Column(nullable = false)
  private String name;

  @NotBlank(message = "邮箱不能为空!")
  @Email(message = "邮箱格式不对!")
  @Column(nullable = false)
  private String email;

  @NotBlank(message = "账号不能为空!")
  @Length(min = 2, max = 20, message="账号长度不能小于5位大于20位!")
  @Column(nullable = false, unique = true)
  private String username; // 用户账号，用户登录时的唯一标识

  @NotBlank(message = "密码不能为空!")
  @Length(min = 2, max = 20, message="密码不能小于6位大于15位!")
  @Pattern(regexp = "^[\\da-zA-Z]*\\d+[a-zA-Z]+[\\da-zA-Z]*$", message = "密码必须由字母与数字组成！")
  @Column(nullable = false)
  private String password; // 登录时密码

  private String avatar; // 头像图片地址

  @Column(nullable = true)
  private String address;

  @NotNull(message = "角色不能为空!")
  @Column(nullable = false)
  private Integer auth;

  @Temporal(TemporalType.TIMESTAMP)
  @Column(updatable = false)
  @org.hibernate.annotations.CreationTimestamp  // 由数据库自动创建时间
  private Date createTime;

  //@Temporal(TemporalType.TIMESTAMP)
  //@org.hibernate.annotations.CreationTimestamp  // 由数据库自动创建时间
  @UpdateTimestamp
  private Date updateTime;

  protected User() { // JPA 的规范要求无参构造函数；设为 protected 防止直接使用
  }

  public User(String department, Integer sex, Date birthday, String phone, String nation, String code, String politics, String name, String email, String username, String password, String avatar, String address, Integer auth, Date createTime, Date updateTime) {
    this.department = department;
    this.sex = sex;
    this.birthday = birthday;
    this.phone = phone;
    this.nation = nation;
    this.code = code;
    this.politics = politics;
    this.name = name;
    this.email = email;
    this.username = username;
    this.password = password;
    this.avatar = avatar;
    this.address = address;
    this.auth = auth;
    this.createTime = createTime;
    this.updateTime = updateTime;
  }
}
