package com.shq.cfa.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author shuihuaqi
 * @create 2018-03-23 14:53
 * @desc
 **/
@Entity(name = "tb_emp")
public class EmpEntity {
  @Id
  @GeneratedValue
  private Integer id;
  @Column
  private String name;
  @Column
  private String sax;
  @Column
  private Integer age;

  public void setId(Integer id) {
    this.id = id;
  }

  public void setSax(String sax) {
    this.sax = sax;
  }

  public void setAge(Integer age) {
    this.age = age;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  @Column

  private String address;
  @Column
  private String email;

  public Integer getId() {
    return id;
  }

  public String getSax() {
    return sax;
  }

  public String getAddress() {
    return address;
  }

  public String getEmail() {
    return email;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getAge() {
    return age;
  }

  @Override
  public String toString() {
    return "EmpEntity{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", sax='" + sax + '\'' +
            ", age=" + age +
            ", address='" + address + '\'' +
            ", email='" + email + '\'' +
            '}';
  }

  public void setAge(int age) {
    this.age = age;
  }
}

