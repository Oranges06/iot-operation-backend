package net.maku.meal.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.List;
import lombok.Data;
import java.io.Serializable;
import net.maku.framework.common.utils.DateUtils;
import java.time.LocalDateTime;

/**
 * 套餐设备
 *
 * @author cry babamu@126.com
 * <a href="https://maku.net">MAKU</a>
 */
@Data
@Schema(description = "套餐设备")
public class TPackageDeviceVO implements Serializable {
	private static final long serialVersionUID = 1L;

	@Schema(description = "主键")
	private Integer id;

	@Schema(description = "套餐id")
	private Integer packageId;

	@Schema(description = "设备类型")
	private Integer deviceType;

	@Schema(description = "创建时间")
	@JsonFormat(pattern = DateUtils.DATE_TIME_PATTERN)
	private LocalDateTime createTime;

	@Schema(description = "更新时间")
	@JsonFormat(pattern = DateUtils.DATE_TIME_PATTERN)
	private LocalDateTime updateTime;

	@Schema(description = "删除标识")
	private Integer deleted;

}