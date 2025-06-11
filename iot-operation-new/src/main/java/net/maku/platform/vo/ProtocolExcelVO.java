package net.maku.platform.vo;

import lombok.Data;
import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import com.fhs.core.trans.vo.TransPojo;
import java.time.LocalDateTime;;

/**
 * 协议管理
 *
 * @author 环游 babamu@126.com
 * <a href="https://maku.net">MAKU</a>
 */
@Data
public class ProtocolExcelVO implements TransPojo {

	@ExcelProperty("主键ID")
	private Integer id;

	@ExcelProperty("协议名称")
	private String name;

	@ExcelProperty("协议描述")
	private String description;

}