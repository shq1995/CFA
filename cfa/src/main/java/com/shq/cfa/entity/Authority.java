package com.shq.cfa.entity;

import javax.persistence.*;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.UpdateTimestamp;

import java.sql.Timestamp;
import java.util.Date;

/**
 * @author shuihuaqi
 * @create 2018-02-27 10:32
 * @desc User 权限
 **/
@Entity // 实体
@Data
@DynamicUpdate
public class Authority {

	private static final long serialVersionUID = 1L;

	@Id // 主键
	@GeneratedValue(strategy = GenerationType.IDENTITY) // 自增长策略
	private Integer id; // 用户的唯一标识

	@Column(nullable = false) // 映射为字段，值不能为空
	private String name;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(updatable = false)
	@org.hibernate.annotations.CreationTimestamp  // 由数据库自动创建时间
	private Date createTime;

	//@Temporal(TemporalType.TIMESTAMP)
	//@org.hibernate.annotations.CreationTimestamp
	@UpdateTimestamp// 由数据库自动创建时间
	private Date updateTime;

	public Authority() {
	}

	public Authority(String name, Timestamp createTime, Timestamp updateTime) {
		this.name = name;
		this.createTime = createTime;
		this.updateTime = updateTime;
	}
}
