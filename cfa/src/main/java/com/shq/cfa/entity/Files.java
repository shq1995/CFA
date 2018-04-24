package com.shq.cfa.entity;

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
import org.hibernate.validator.constraints.NotBlank;
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

	@NotBlank(message = "标题不能为空！")
	@Column(nullable = false) // 映射为字段，值不能为空
	private String title;

	@Pattern(regexp = "^[ ]|[\\u4e00-\\u9fa5]*|[\\u4e00-\\u9fa5]+[，][\\u4e00-\\u9fa5]+$", message = "关键字必须由中文逗号隔开！")
	@Column(nullable = false) // 映射为字段，值不能为空
	private String keyword;

	@Column
	private Integer type;

	@NotBlank(message = "案号不能为空！")
	@Size(min=2, max=50,message = "案号长度必须在2到50之间！")
	@Column(nullable = false, length = 50) // 映射为字段，值不能为空
	private String number;

	@NotNull(message = "收诉状日期不能为空！")
	@Temporal(TemporalType.DATE)// 映射为字段，值不能为空
	private Date putDate;

	@NotBlank(message = "负责人不能为空！")
	@Column(nullable = false) // 映射为字段，值不能为空
	private String principal;

	@NotBlank(message = "原告不能为空！")
	@Column(nullable = false) // 映射为字段，值不能为空
	private String accuser;

	@NotBlank(message = "被告不能为空！")
	@Column(nullable = false) // 映射为字段，值不能为空
	private String defendant;

	@NotBlank(message = "承办人不能为空！")
	@Column(nullable = false) // 映射为字段，值不能为空
	private String agent;

	@NotBlank(message = "承办部门不能为空！")
	@Column(nullable = false) // 映射为字段，值不能为空
	private String agentDepartment;

	@NotNull(message = "承办时间不能为空！")
	@Column(nullable = false) // 映射为字段，值不能为空
	@Temporal(TemporalType.DATE)
	private Date agentDate;

	@NotNull(message = "案件来源不能为空！")
	@Column(nullable = false) // 映射为字段，值不能为空
	private String source;

	@NotBlank(message = "诉讼请求不能为空！")
	@Column(nullable = false) // 映射为字段，值不能为空
	private String request;

	@NotNull(message = "起诉次数不能为空！")
	@Column(nullable = false) // 映射为字段，值不能为空
	private Integer frequency;

	@NotBlank(message = "立案案由不能为空！")
	@Column(nullable = false) // 映射为字段，值不能为空
	private String startCause;

	@NotBlank(message = "立案案由描述不能为空！")
	@Column(nullable = false) // 映射为字段，值不能为空
	private String startDesc;

	@Column(nullable = false) // 映射为字段，值不能为空
	@Temporal(TemporalType.DATE)
	private Date endTime;

	@NotBlank(message = "结案案由不能为空！")
	@Column(nullable = false) // 映射为字段，值不能为空
	private String endCause;

	@NotBlank(message = "结案案由描述不能为空！")
	@Column(nullable = false) // 映射为字段，值不能为空
	private String endDesc;

	@NotBlank(message = "受理费不能为空！")
	@Column(nullable = false) // 映射为字段，值不能为空
	private String pay;

	@NotBlank(message = "案件特征不能为空！")
	@Size(min=2, max=300,message = "案件特征长度必须是2到300之间！")
	@Column(nullable = false) // 映射为字段，值不能为空
	private String summary;

	@NotBlank(message = "案件描述内容不能为空！")
	@Column(nullable = false) // 映射为字段，值不能为空
	private String content;

	@Column(nullable = false)
	private Integer basics;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(updatable = false)
	@org.hibernate.annotations.CreationTimestamp  // 由数据库自动创建时间
	private Date createTime;

	//@Temporal(TemporalType.TIMESTAMP)
	//@org.hibernate.annotations.CreationTimestamp
	@UpdateTimestamp// 由数据库自动创建时间
	private Date updateTime;

	
	protected Files() {
		// TODO Auto-generated constructor stub
	}

	public Files(String title, String keyword, Integer type, String number, Date putDate, String principal, String accuser, String defendant, String agent, String agentDepartment, Date agentDate, String source, String request, Integer frequency, String startCause, String startDesc, Date endTime, String endCause, String endDesc, String pay, String summary, String content, Date createTime, Date updateTime,Integer basics) {
		this.title = title;
		this.keyword = keyword;
		this.type = type;
		this.number = number;
		this.putDate = putDate;
		this.principal = principal;
		this.accuser = accuser;
		this.defendant = defendant;
		this.agent = agent;
		this.agentDepartment = agentDepartment;
		this.agentDate = agentDate;
		this.source = source;
		this.request = request;
		this.frequency = frequency;
		this.startCause = startCause;
		this.startDesc = startDesc;
		this.endTime = endTime;
		this.endCause = endCause;
		this.endDesc = endDesc;
		this.pay = pay;
		this.summary = summary;
		this.content = content;
		this.basics = basics;
		this.createTime = createTime;
		this.updateTime = updateTime;
	}
}
