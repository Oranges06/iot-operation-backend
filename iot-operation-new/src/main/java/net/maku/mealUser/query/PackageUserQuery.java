package net.maku.mealUser.query;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import net.maku.framework.common.query.Query;

;

/**
 * 套餐分配查询
 *
 * @author 阿沐 babamu@126.com
 * <a href="https://maku.net">MAKU</a>
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Schema(description = "套餐分配查询")
public class PackageUserQuery extends Query {
    @Schema(description = "套餐名")
    private String packageName;

    @Schema(description = "用户id")
    private Integer userId;

}