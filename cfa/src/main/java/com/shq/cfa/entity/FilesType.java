package com.shq.cfa.entity;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.sql.Timestamp;
import java.util.Date;

/**
 * @author shuihuaqi
 * @create 2018-02-27 14:48
 * @desc 案件类型实体
 **/
@Entity
@Data
@DynamicUpdate
public class FilesType {
  private static final long serialVersionUID = 1L;

  @Id // 主键
  @GeneratedValue(strategy = GenerationType.IDENTITY) // 自增长策略
  private Integer id; // 案件类型的唯一标识

  @NotEmpty(message = "分类名称不能为空")
  @Size(min=2, max=50)
  @Column(nullable = false, length = 50) // 映射为字段，值不能为空
  private String name;

  @NotEmpty(message = "说明不能为空")
  @Size(min=2, max=50)
  @Column(nullable = false, length = 50) // 映射为字段，值不能为空
  private String state;

  @NotEmpty(message = "序号不能为空")
  @Column(nullable = false) // 映射为字段，值不能为空
  private String number;

  @NotEmpty(message = "简称不能为空")
  @Column(nullable = false) // 映射为字段，值不能为空
  private String abbreviation;

  @Temporal(TemporalType.TIMESTAMP)
  @Column(updatable = false)
  @org.hibernate.annotations.CreationTimestamp  // 由数据库自动创建时间
  private Date createTime;

  //@Temporal(TemporalType.TIMESTAMP)
  //@org.hibernate.annotations.CreationTimestamp  // 由数据库自动创建时间
  @UpdateTimestamp
  private Date updateTime;

  public FilesType() {
  }

  public FilesType(String name, String state, String number, String abbreviation, Timestamp createTime, Timestamp updateTime) {
    this.name = name;
    this.state = state;
    this.number = number;
    this.abbreviation = abbreviation;
    this.createTime = createTime;
    this.updateTime = updateTime;
  }
}
