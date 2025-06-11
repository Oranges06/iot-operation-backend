package net.maku.mealUser.entity;

import lombok.Data;
import com.baomidou.mybatisplus.annotation.*;
import java.time.LocalDateTime;;

/**
 * 套餐分配
 *
 * @author 阿沐 babamu@126.com
 * <a href="https://maku.net">MAKU</a>
 */

@Data
@TableName("t_package_user")
public class PackageUserEntity {
	/**
	* 主键
	*/
	@TableId
	@TableField(value = "id")
	private Integer id;

	/**
	* 套餐名
	*/
	@TableField(value = "package_id")
	private Integer packageId;

	/**
	* 用户id
	*/
	@TableField(value = "user_id")
	private Integer userId;

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