package net.maku.platform.vo;

import lombok.Data;
import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import com.fhs.core.trans.vo.TransPojo;
import java.time.LocalDateTime;;

/**
 * 版本管理
 *
 * @author 环游 babamu@126.com
 * <a href="https://maku.net">MAKU</a>
 */
@Data
public class AppVersionExcelVO implements TransPojo {
	@ExcelProperty("主键ID")
	private Integer id;

	@ExcelProperty("版本名称，如0.0.1")
	private String versionName;

	@ExcelProperty("版本号，用于比较更新")
	private Integer versionCode;

	@ExcelProperty("发布类型，如正式版/开发版/远程调试/热更新")
	private String releaseType;

	@ExcelProperty("包类型，如APK/AAB")
	private String packageType;

	@ExcelProperty("下载地址")
	private String downloadUrl;

	@ExcelProperty("版本说明")
	private String releaseNote;

}