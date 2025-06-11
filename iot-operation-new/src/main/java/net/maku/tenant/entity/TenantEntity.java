package net.maku.tenant.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import com.baomidou.mybatisplus.annotation.*;
import java.time.LocalDateTime;;

/**
 * 用户管理
 *
 * @author cry babamu@126.com
 * <a href="https://maku.net">MAKU</a>
 */

@Data
@TableName("sys_user")
public class TenantEntity {
	/**
	* id
	*/
	@TableId
	@TableField(value = "id")
	private Long id;

	/**
	* 用户名
	*/
	@TableField(value = "username")
	private String username;

	/**
	* 密码
	*/
	@TableField(value = "password")
	private String password;

	/**
	* 姓名
	*/
	@TableField(value = "real_name")
	private String realName;

	/**
	* 头像
	*/
	@TableField(value = "avatar")
	private String avatar;

	/**
	* 性别   0：男   1：女   2：未知
	*/
	@TableField(value = "gender")
	private Integer gender;

	/**
	* 邮箱
	*/
	@TableField(value = "email")
	private String email;

	/**
	* 手机号
	*/
	@TableField(value = "mobile")
	private String mobile;

	/**
	* 机构ID
	*/
	@TableField(value = "org_id")
	private Long orgId;

	/**
	* 超级管理员   0：否   1：是
	*/
	@TableField(value = "super_admin")
	private Integer superAdmin;

	/**
	* 状态  0：停用   1：正常
	*/
	@TableField(value = "status")
	private Integer status;

	/**
	* 租户ID
	*/
	@TableField(value = "tenant_id")
	private Long tenantId;

	/**
	* 版本号
	*/
	@TableField(value = "version", fill = FieldFill.INSERT)
	private Integer version;

	/**
	* 删除标识  0：正常   1：已删除
	*/
	@TableField(value = "deleted", fill = FieldFill.INSERT)
	private Integer deleted;

	/**
	* 创建者
	*/
	@TableField(value = "creator", fill = FieldFill.INSERT)
	private Long creator;

	/**
	* 创建时间
	*/
	@TableField(value = "create_time", fill = FieldFill.INSERT)
	private LocalDateTime createTime;

	/**
	* 更新者
	*/
	@TableField(value = "updater", fill = FieldFill.INSERT_UPDATE)
	private Long updater;

	/**
	* 更新时间
	*/
	@TableField(value = "update_time", fill = FieldFill.INSERT_UPDATE)
	private LocalDateTime updateTime;

}