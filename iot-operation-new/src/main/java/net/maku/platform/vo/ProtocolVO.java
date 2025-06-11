package net.maku.platform.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.List;
import lombok.Data;
import java.io.Serializable;
import net.maku.framework.common.utils.DateUtils;
import java.time.LocalDateTime;;

/**
 * 协议管理
 *
 * @author 环游 babamu@126.com
 * <a href="https://maku.net">MAKU</a>
 */
@Data
@Schema(description = "协议管理")
public class ProtocolVO implements Serializable {
	private static final long serialVersionUID = 1L;

	@Schema(description = "主键ID")
	private Integer id;

	@Schema(description = "协议名称")
	private String name;

	@Schema(description = "协议描述")
	private String description;

	@Schema(description = "创建时间")
	@JsonFormat(pattern = DateUtils.DATE_TIME_PATTERN)
	private LocalDateTime createTime;

	@Schema(description = "更新时间")
	@JsonFormat(pattern = DateUtils.DATE_TIME_PATTERN)
	private LocalDateTime updateTime;

	@Schema(description = "删除标识")
	private Integer deleted;

}