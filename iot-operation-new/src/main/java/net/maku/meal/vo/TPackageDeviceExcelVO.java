package net.maku.meal.vo;

import lombok.Data;
import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import com.fhs.core.trans.vo.TransPojo;
import java.time.LocalDateTime;;

/**
 * 套餐设备
 *
 * @author cry babamu@126.com
 * <a href="https://maku.net">MAKU</a>
 */
@Data
public class TPackageDeviceExcelVO implements TransPojo {
	@ExcelIgnore
	private Integer id;

	@ExcelProperty("套餐id")
	private Integer packageId;

	@ExcelProperty("设备id")
	private Integer deviceType;

}