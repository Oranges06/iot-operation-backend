package net.maku.tenant.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.List;
import lombok.Data;
import java.io.Serializable;
import net.maku.framework.common.utils.DateUtils;
import java.time.LocalDateTime;;

/**
 * 用户管理
 *
 * @author cry babamu@126.com
 * <a href="https://maku.net">MAKU</a>
 */
@Data
@Schema(description = "用户管理")
public class TenantVO implements Serializable {
	private static final long serialVersionUID = 1L;

	@Schema(description = "id")
	private Long id;

	@Schema(description = "用户名")
	private String username;

	@Schema(description = "密码")
	private String password;

	@Schema(description = "姓名")
	private String realName;

	@Schema(description = "头像")
	private String avatar;

	@Schema(description = "性别   0：男   1：女   2：未知")
	private Integer gender;

	@Schema(description = "邮箱")
	private String email;

	@Schema(description = "手机号")
	private String mobile;

	@Schema(description = "机构ID")
	private Long orgId;

	@Schema(description = "超级管理员   0：否   1：是")
	private Integer superAdmin;

	@Schema(description = "状态  0：停用   1：正常")
	private Integer status;

	@Schema(description = "租户ID")
	private Long tenantId;

	@Schema(description = "版本号")
	private Integer version;

	@Schema(description = "删除标识  0：正常   1：已删除")
	private Integer deleted;

	@Schema(description = "创建者")
	private Long creator;

	@Schema(description = "创建时间")
	@JsonFormat(pattern = DateUtils.DATE_TIME_PATTERN)
	private LocalDateTime createTime;

	@Schema(description = "更新者")
	private Long updater;

	@Schema(description = "更新时间")
	@JsonFormat(pattern = DateUtils.DATE_TIME_PATTERN)
	private LocalDateTime updateTime;

}