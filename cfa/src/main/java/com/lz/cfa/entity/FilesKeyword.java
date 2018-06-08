package com.lz.cfa.entity;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.sql.Timestamp;
import java.util.Date;

/**
 * @author
 * @create 2018-02-27 14:50
 * @desc 案件关键字实体
 **/
@Entity
@Data
@DynamicUpdate
public class FilesKeyword {
  private static final Integer serialVersionUID = 1;

  @Id // 主键
  @GeneratedValue(strategy = GenerationType.IDENTITY) // 自增长策略
  private Integer id; // 案件关键字的唯一标识

  @Column(nullable = false) // 映射为字段，值不能为空
  private Integer type;

  @NotBlank(message = "关键字不能为空!")
  @Size(min=2, max=50,message = "关键字长度必须是2到50之间!")
  @Column(nullable = false) // 映射为字段，值不能为空
  private String keyword;

  @NotNull(message = "关键字权重不能为空！")
  @Column(nullable = false) // 映射为字段，值不能为空
  private Float weight;

  @Temporal(TemporalType.TIMESTAMP)
  @Column(updatable = false)
  @org.hibernate.annotations.CreationTimestamp  // 由数据库自动创建时间
  private Date createTime;

  //@Temporal(TemporalType.TIMESTAMP)
  //@org.hibernate.annotations.UpdateTimestamp
  @UpdateTimestamp //由数据库自动创建时间
  private Date updateTime;

  public FilesKeyword() {

  }

  public FilesKeyword(Integer type, String keyword, Float weight, Timestamp createTime, Timestamp updateTime) {
    this.type = type;
    this.keyword = keyword;
    this.weight = weight;
    this.createTime = createTime;
    this.updateTime = updateTime;
  }
}
