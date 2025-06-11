package net.maku.meal.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.List;
import lombok.Data;
import java.io.Serializable;
import net.maku.framework.common.utils.DateUtils;
import java.time.LocalDateTime;;

/**
 * 套餐管理
 *
 * @author cry babamu@126.com
 * <a href="https://maku.net">MAKU</a>
 */
@Data
@Schema(description = "套餐管理")
public class TPackageVO implements Serializable {
	private static final long serialVersionUID = 1L;

	@Schema(description = "主键")
	private Integer id;

	@Schema(description = "套餐名")
	private String name;

	@Schema(description = "创建时间")
	@JsonFormat(pattern = DateUtils.DATE_TIME_PATTERN)
	private LocalDateTime createTime;

	@Schema(description = "更新时间")
	@JsonFormat(pattern = DateUtils.DATE_TIME_PATTERN)
	private LocalDateTime updateTime;

	@Schema(description = "删除标识")
	private Integer deleted;
	
	@Schema(description = "套餐包含的设备列表")
	private List<TPackageDeviceVO> deviceList;

}