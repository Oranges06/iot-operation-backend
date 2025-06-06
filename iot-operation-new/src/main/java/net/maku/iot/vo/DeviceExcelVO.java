package net.maku.iot.vo;

import lombok.Data;
import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import com.fhs.core.trans.vo.TransPojo;
import java.util.Date;

/**
 * 设备
 *
 * @author cry babamu@126.com
 * <a href="https://maku.net">MAKU</a>
 */
@Data
public class DeviceExcelVO implements TransPojo {

	@ExcelProperty("主键")
	private Integer id;

	@ExcelProperty("设备id")
	private String deviceId;

	@ExcelProperty("设备名称")
	private String name;

	@ExcelProperty("类型 1 灯 2 温湿度传感器 3 蜂鸣器  4 红外传感器")
	private Integer type;

	@ExcelProperty("开关 0-开 1-关")
	private Integer isSwitched;

	@ExcelProperty("状态 0-在线 1-离线")
	private Integer status;

	@ExcelProperty("温度")
	private Float temperature;

	@ExcelProperty("湿度")
	private Float humidity;

	@ExcelProperty("租户id")
	private Integer tenantId;

	@ExcelProperty("管理员id")
	private Integer adminId;

}