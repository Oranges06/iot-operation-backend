package net.maku.platform.convert;

import net.maku.platform.entity.AppVersionEntity;
import net.maku.platform.vo.AppVersionVO;
import net.maku.platform.vo.AppVersionExcelVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * 版本管理
 *
 * @author 环游 babamu@126.com
 * <a href="https://maku.net">MAKU</a>
 */
@Mapper
public interface AppVersionConvert {
    AppVersionConvert INSTANCE = Mappers.getMapper(AppVersionConvert.class);

    AppVersionEntity convert(AppVersionVO vo);

    AppVersionVO convert(AppVersionEntity entity);

    List<AppVersionVO> convertList(List<AppVersionEntity> list);

    List<AppVersionEntity> convertList2(List<AppVersionVO> list);

    List<AppVersionExcelVO> convertExcelList(List<AppVersionEntity> list);

    List<AppVersionEntity> convertExcelList2(List<AppVersionExcelVO> list);
}