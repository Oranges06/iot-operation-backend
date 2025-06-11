package net.maku.mealUser.vo;

import lombok.Data;
import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import com.fhs.core.trans.vo.TransPojo;
import java.time.LocalDateTime;;

/**
 * 套餐管理
 *
 * @author cry babamu@126.com
 * <a href="https://maku.net">MAKU</a>
 */
@Data
public class TPackageExcelVO implements TransPojo {
	@ExcelIgnore
	private Integer id;

	@ExcelProperty("套餐名")
	private String name;

}