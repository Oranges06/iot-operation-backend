package net.maku.iot.query;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import net.maku.framework.common.query.Query;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * 设备查询
 *
 * @author cry babamu@126.com
 * <a href="https://maku.net">MAKU</a>
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Schema(description = "设备查询")
public class DeviceQuery extends Query {
    @Schema(description = "设备id")
    private String deviceId;

    @Schema(description = "设备名称")
    private String name;

    @Schema(description = "类型 1 灯 2 温湿度传感器 3 蜂鸣器  4 红外传感器")
    private Integer type;

    @Schema(description = "管理员id")
    private Integer adminId;

    @Schema(description = "租户id")
    private Integer tenantId;

}