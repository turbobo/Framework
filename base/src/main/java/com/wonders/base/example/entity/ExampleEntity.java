package com.wonders.base.example.entity;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @Description  实体范例
 * @Author  swq
 * @Date 2020-02-26 13:03:16
 */

@Entity  //表明该类 (ExampleEntity) 为一个实体类，它默认对应数据库中的表名是example_entity
@Data    //所有Java代码中不需要生成getters and setters，而在编译的时候会自动生成getters and setters
/*当实体类与其映射的数据库表名不同名时需要使用 @Table注解说明，该标注与 @Entity 注解并列使用，
置于实体类声明语句之前，可写于单独语句行，也可与声明语句同行。
@Table注解的常用选项是 name，用于指明数据库的表名*/
@Table ( name ="GOV_BASE_EXAMPLE" )
//这里配置实体类的描述
@ApiModel(value = "测试实体类", description = "用于测试的实体类")   //在实体类上边使用，标记类时swagger的解析类
public class ExampleEntity implements Serializable {

	private static final long serialVersionUID =  7091861924682577534L;
	//主键
	@Id
	//就像@Table注解用来标识实体类与数据表的对应关系类似，@Column注解来标识实体类中属性与数据表中字段的对应关系。
	@Column(name = "ST_ID" ,unique = true ,nullable = false)
	@GeneratedValue(generator = "idGenerator")  //提供了主键的生成策略。
	/*@GenericGenerator注解是hibernate所提供的自定义主键生成策略生成器，
	由@GenericGenerator实现多定义的策略。所以，它要配合@GeneratedValue一起使用，
	并且@GeneratedValue注解中的”generator”属性要与@GenericGenerator注解中name属性一致，
	strategy属性表示hibernate的主键生成策略，
	*/
	@GenericGenerator(name = "idGenerator" ,strategy = "uuid")
	//这里配置实体类的属性描述
	@ApiModelProperty(value = "用户id", name = "stId", example = "qwertyuio")   //使用在被 @ApiModel 注解的模型类的属性上
	private String stId;

	@Column(name = "ST_NAME" )
	@ApiModelProperty(value = "用户名", name = "stName", example = "ZhangSan")
	private String stName;

	@ApiModelProperty(value = "用户身份证号", name = "stIdCard", example = "123456")
	@Column(name = "ST_ID_CARD" )
	private String stIdCard;

	@ApiModelProperty(value = "用户地址", name = "stAddress", example = "上海市")
	@Column(name = "ST_ADDRESS" )
	private String stAddress;

	@ApiModelProperty(value = "创建人id", name = "creatorId", example = "qwewqewqeqwe")
	@Column(name = "ST_CREATOR_ID")
	protected String creatorId;

	/** 创建人名称 */
	@ApiModelProperty(value = "创建人名称", name = "creatorName", example = "LiSi")
	@Column(name = "ST_CREATOR_NAME")
	protected String creatorName;

	/** 创建时间 */
	@ApiModelProperty(value = "创建时间", name = "createTime", example = "2020-04-28")
	@Column(name = "DT_CREATE_TIME")
	protected Date createTime;

	/** 更新时间，默认是当前时间 */
	@ApiModelProperty(value = "更新时间，默认是当前时间", name = "updateTime", example = "2020-04-28")
	@Column(name = "DT_UPDATE_TIME")
	protected Date updateTime = new Date();

	/** 状态 0 表示删除, 1表示可操作 */
	@ApiModelProperty(value = "状态 0 表示删除, 1表示可操作", name = "status", example = "1")
	@Column(name = "ST_STATUS")
	protected Integer status = 1;

	public String getStId() {
		return stId;
	}

	public void setStId(String stId) {
		this.stId = stId;
	}

	public String getStName() {
		return stName;
	}

	public void setStName(String stName) {
		this.stName = stName;
	}

	public String getStIdCard() {
		return stIdCard;
	}

	public void setStIdCard(String stIdCard) {
		this.stIdCard = stIdCard;
	}

	public String getStAddress() {
		return stAddress;
	}

	public void setStAddress(String stAddress) {
		this.stAddress = stAddress;
	}

	public String getCreatorId() {
		return creatorId;
	}

	public void setCreatorId(String creatorId) {
		this.creatorId = creatorId;
	}

	public String getCreatorName() {
		return creatorName;
	}

	public void setCreatorName(String creatorName) {
		this.creatorName = creatorName;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String toString(){
		return "ExampleEntity[stId="+stId+", stName="+stName+"]";
	}
}
