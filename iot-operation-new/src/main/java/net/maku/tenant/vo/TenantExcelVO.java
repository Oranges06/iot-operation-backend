package net.maku.tenant.vo;

import com.fhs.core.trans.anno.Trans;
import com.fhs.core.trans.constant.TransType;
import lombok.Data;
import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import com.fhs.core.trans.vo.TransPojo;
import java.time.LocalDateTime;;

/**
 * 用户管理
 *
 * @author cry babamu@126.com
 * <a href="https://maku.net">MAKU</a>
 */
@Data
public class TenantExcelVO implements TransPojo {
	@ExcelIgnore
	private Long id;

	@ExcelProperty("用户名")
	private String username;

	@ExcelProperty("姓名")
	private String realName;

	@ExcelProperty("头像")
	private String avatar;

	@ExcelProperty("性别   0：男   1：女   2：未知")
	private String genderLabel;

	@ExcelIgnore
	@Trans(type = TransType.DICTIONARY, key = "user_gender", ref = "genderLabel")
	private Integer gender;

	@ExcelProperty("邮箱")
	private String email;

	@ExcelProperty("手机号")
	private String mobile;

	@ExcelProperty("超级管理员   0：否   1：是")
	private String superAdminLabel;

	@ExcelIgnore
	@Trans(type = TransType.DICTIONARY, key = "user_super_admin", ref = "superAdminLabel")
	private Integer superAdmin;

	@ExcelProperty("状态  0：停用   1：正常")
	private String statusLabel;

	@ExcelIgnore
	@Trans(type = TransType.DICTIONARY, key = "user_status", ref = "statusLabel")
	private Integer status;

}