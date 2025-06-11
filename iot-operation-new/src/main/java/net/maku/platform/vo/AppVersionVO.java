package net.maku.platform.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.List;
import lombok.Data;
import java.io.Serializable;
import net.maku.framework.common.utils.DateUtils;
import java.time.LocalDateTime;;

/**
 * 版本管理
 *
 * @author 环游 babamu@126.com
 * <a href="https://maku.net">MAKU</a>
 */
@Data
@Schema(description = "版本管理")
public class AppVersionVO implements Serializable {
	private static final long serialVersionUID = 1L;

	@Schema(description = "主键ID")
	private Integer id;

	@Schema(description = "版本名称，如0.0.1")
	private String versionName;

	@Schema(description = "版本号，用于比较更新")
	private Integer versionCode;

	@Schema(description = "发布类型，如正式版/开发版/远程调试/热更新")
	private String releaseType;

	@Schema(description = "包类型，如APK/AAB")
	private String packageType;

	@Schema(description = "下载地址")
	private String downloadUrl;

	@Schema(description = "版本说明")
	private String releaseNote;

	@Schema(description = "创建时间")
	@JsonFormat(pattern = DateUtils.DATE_TIME_PATTERN)
	private LocalDateTime createTime;

	@Schema(description = "更新时间")
	@JsonFormat(pattern = DateUtils.DATE_TIME_PATTERN)
	private LocalDateTime updateTime;

	@Schema(description = "删除标识")
	private Integer deleted;

}