package net.maku.mealUser.vo;

import lombok.Data;
import com.alibaba.excel.annotation.ExcelProperty;
import com.fhs.core.trans.vo.TransPojo;
;

/**
 * 套餐分配
 *
 * @author 阿沐 babamu@126.com
 * <a href="https://maku.net">MAKU</a>
 */
@Data
public class PackageUserExcelVO implements TransPojo {


	@ExcelProperty("主键")
	private Integer id;

	@ExcelProperty("套餐名")
	private String packageId;

	@ExcelProperty("用户id")
	private Integer userId;

}