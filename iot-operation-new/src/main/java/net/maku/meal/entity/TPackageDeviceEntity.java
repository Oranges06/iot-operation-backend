package net.maku.meal.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import com.baomidou.mybatisplus.annotation.*;
import java.time.LocalDateTime;;

/**
 * 套餐设备
 *
 * @author cry babamu@126.com
 * <a href="https://maku.net">MAKU</a>
 */

@Data
@TableName("t_package_device")
public class TPackageDeviceEntity {
	/**
	* 主键
	*/
	@TableId
	@TableField(value = "id")
	private Integer id;

	/**
	* 套餐id
	*/
	@TableField(value = "package_id")
	private Integer packageId;

	/**
	* 设备id
	*/
	@TableField(value = "device_type")
	private Integer deviceType;

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
	@TableLogic
	@TableField(value = "deleted", fill = FieldFill.INSERT)
	private Integer deleted;

}