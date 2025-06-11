package net.maku.iot.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.List;
import lombok.Data;
import java.io.Serializable;
import net.maku.framework.common.utils.DateUtils;
import java.util.Date;

/**
 * 设备
 *
 * @author cry babamu@126.com
 * <a href="https://maku.net">MAKU</a>
 */
@Data
@Schema(description = "设备")
public class DeviceVO implements Serializable {
	private static final long serialVersionUID = 1L;

	@Schema(description = "主键")
	private Integer id;

	@Schema(description = "设备id")
	private String deviceId;

	@Schema(description = "设备名称")
	private String name;

	@Schema(description = "类型 1 灯 2 温湿度传感器 3 蜂鸣器  4 红外传感器")
	private Integer type;

	@Schema(description = "开关 0-开 1-关")
	private Integer isSwitched;

	@Schema(description = "状态 0-在线 1-离线")
	private Integer status;

	@Schema(description = "温度")
	private Float temperature;

	@Schema(description = "湿度")
	private Float humidity;

	@Schema(description = "租户id")
	private Integer tenantId;

	@Schema(description = "管理员id")
	private Integer adminId;

}