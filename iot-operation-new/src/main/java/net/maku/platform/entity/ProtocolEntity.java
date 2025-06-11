package net.maku.platform.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import com.baomidou.mybatisplus.annotation.*;
import java.time.LocalDateTime;;

/**
 * 协议管理
 *
 * @author 环游 babamu@126.com
 * <a href="https://maku.net">MAKU</a>
 */

@Data
@TableName("protocol")
public class ProtocolEntity {
	/**
	* 主键ID
	*/
	@TableId
	@TableField(value = "id")
	private Integer id;

	/**
	* 协议名称
	*/
	@TableField(value = "name")
	private String name;

	/**
	* 协议描述
	*/
	@TableField(value = "description")
	private String description;

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