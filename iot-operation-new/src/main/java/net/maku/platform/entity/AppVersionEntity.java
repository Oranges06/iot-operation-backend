package net.maku.platform.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import com.baomidou.mybatisplus.annotation.*;
import java.time.LocalDateTime;;

/**
 * 版本管理
 *
 * @author 环游 babamu@126.com
 * <a href="https://maku.net">MAKU</a>
 */

@Data
@TableName("app_version")
public class AppVersionEntity {
	/**
	* 主键ID
	*/
	@TableId
	@TableField(value = "id")
	private Integer id;

	/**
	* 版本名称，如0.0.1
	*/
	@TableField(value = "version_name")
	private String versionName;

	/**
	* 版本号，用于比较更新
	*/
	@TableField(value = "version_code")
	private Integer versionCode;

	/**
	* 发布类型，如正式版/开发版/远程调试/热更新
	*/
	@TableField(value = "release_type")
	private String releaseType;

	/**
	* 包类型，如APK/AAB
	*/
	@TableField(value = "package_type")
	private String packageType;

	/**
	* 下载地址
	*/
	@TableField(value = "download_url")
	private String downloadUrl;

	/**
	* 版本说明
	*/
	@TableField(value = "release_note")
	private String releaseNote;

	/**
	* 创建时间
	*/
	@TableField(value = "create_time", fill = FieldFill.INSERT)
	private LocalDateTime createTime;

	/**
	* 更新时间
	*/
	@TableField(value = "update_time", fill = FieldFill.INSERT_UPDATE)
	private LocalDateTime updateTime;

	/**
	* 删除标识
	*/
	@TableField(value = "deleted", fill = FieldFill.INSERT)
	private Integer deleted;

}