package net.maku.meal.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import com.baomidou.mybatisplus.annotation.*;
import java.time.LocalDateTime;;

/**
 * 套餐管理
 *
 * @author cry babamu@126.com
 * <a href="https://maku.net">MAKU</a>
 */

@Data
@TableName("t_package")
public class TPackageEntity {
	/**
	* 主键
	*/
	@TableId
	@TableField(value = "id")
	private Integer id;

	/**
	* 套餐名
	*/
	@TableField(value = "name")
	private String name;

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