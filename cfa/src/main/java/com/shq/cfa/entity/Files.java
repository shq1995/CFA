package com.shq.cfa.entity;

import java.io.Serializable;

import java.sql.Timestamp;
import java.util.Date;
import javax.persistence.*;
import javax.validation.constraints.Size;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * @author shuihuaqi
 * @create 2018-02-27 10:38
 * @desc 案件 实体
 **/
@Entity // 实体
@Data
@DynamicUpdate
public class Files implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id // 主键
	@GeneratedValue(strategy = GenerationType.IDENTITY) // 自增长策略
	private Integer id; // 案件的唯一标识
	
	@NotEmpty(message = "标题不能为空")
	@Size(min=2, max=50)
	@Column(nullable = false, length = 50) // 映射为字段，值不能为空
	private String title;

	@NotEmpty(message = "案号不能为空")
	@Size(min=2, max=50)
	@Column(nullable = false, length = 50) // 映射为字段，值不能为空
	private String number;

	@NotEmpty(message = "收诉状日期不能为空")
	@Column(nullable = false) // 映射为字段，值不能为空
	private Date put_date;

	@NotEmpty(message = "负责人不能为空")
	@Column(nullable = false) // 映射为字段，值不能为空
	private String principal;

	@NotEmpty(message = "原告不能为空")
	@Column(nullable = false) // 映射为字段，值不能为空
	private String accuser;

	@NotEmpty(message = "被告不能为空")
	@Column(nullable = false) // 映射为字段，值不能为空
	private String defendant;

	@NotEmpty(message = "承办人不能为空")
	@Column(nullable = false) // 映射为字段，值不能为空
	private String agent;

	@NotEmpty(message = "承办部门不能为空")
	@Column(nullable = false) // 映射为字段，值不能为空
	private String agent_department;

	@NotEmpty(message = "承办时间不能为空")
	@Column(nullable = false) // 映射为字段，值不能为空
	private Date agent_date;

	@NotEmpty(message = "案件来源不能为空")
	@Column(nullable = false) // 映射为字段，值不能为空
	private Date source;

	@NotEmpty(message = "诉讼请求不能为空")
	@Column(nullable = false) // 映射为字段，值不能为空
	private String request;

	@NotEmpty(message = "起诉次数不能为空")
	@Column(nullable = false) // 映射为字段，值不能为空
	private String frequency;

	@NotEmpty(message = "立案案由不能为空")
	@Column(nullable = false) // 映射为字段，值不能为空
	private String start_cause;

	@NotEmpty(message = "立案案由不能为空")
	@Column(nullable = false) // 映射为字段，值不能为空
	private String start_desc;

	@NotEmpty(message = "结案时间不能为空")
	@Column(nullable = false) // 映射为字段，值不能为空
	private Date end_time;

	@NotEmpty(message = "结案案由不能为空")
	@Column(nullable = false) // 映射为字段，值不能为空
	private String end_case;

	@NotEmpty(message = "结案案由不能为空")
	@Column(nullable = false) // 映射为字段，值不能为空
	private String end_desc;

	@NotEmpty(message = "受理费不能为空")
	@Column(nullable = false) // 映射为字段，值不能为空
	private String pay;

	@NotEmpty(message = "案件特征不能为空")
	@Size(min=2, max=300)
	@Column(nullable = false) // 映射为字段，值不能为空
	private String summary;

	@Lob  // 大对象，映射 MySQL 的 Long Text 类型
	@Basic(fetch=FetchType.LAZY) // 懒加载
	@NotEmpty(message = "案件描述内容不能为空")
	@Size(min=2)
	@Column(nullable = false) // 映射为字段，值不能为空
	private String content;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(updatable = false)
	@org.hibernate.annotations.CreationTimestamp  // 由数据库自动创建时间
	private Date createTime;

	@Temporal(TemporalType.TIMESTAMP)
	@org.hibernate.annotations.CreationTimestamp  // 由数据库自动创建时间
	private Date updateTime;

	
	protected Files() {
		// TODO Auto-generated constructor stub
	}

	public Files(String title, String number, Date put_date, String principal, String accuser, String defendant, String agent, String agent_department, Date agent_date, Date source, String request, String frequency, String start_cause, String start_desc, Date end_time, String end_case, String end_desc, String pay, String summary, String content, Timestamp createTime, Timestamp updateTime) {
		this.title = title;
		this.number = number;
		this.put_date = put_date;
		this.principal = principal;
		this.accuser = accuser;
		this.defendant = defendant;
		this.agent = agent;
		this.agent_department = agent_department;
		this.agent_date = agent_date;
		this.source = source;
		this.request = request;
		this.frequency = frequency;
		this.start_cause = start_cause;
		this.start_desc = start_desc;
		this.end_time = end_time;
		this.end_case = end_case;
		this.end_desc = end_desc;
		this.pay = pay;
		this.summary = summary;
		this.content = content;
		this.createTime = createTime;
		this.updateTime = updateTime;

	}
}
