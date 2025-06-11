package net.maku.meal.convert;

import net.maku.meal.entity.TPackageEntity;
import net.maku.meal.vo.TPackageVO;
import net.maku.meal.vo.TPackageExcelVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * 套餐管理
 *
 * @author cry babamu@126.com
 * <a href="https://maku.net">MAKU</a>
 */
@Mapper
public interface TPackageConvert {
    TPackageConvert INSTANCE = Mappers.getMapper(TPackageConvert.class);

    TPackageEntity convert(TPackageVO vo);

    TPackageVO convert(TPackageEntity entity);

    List<TPackageVO> convertList(List<TPackageEntity> list);

    List<TPackageEntity> convertList2(List<TPackageVO> list);

    List<TPackageExcelVO> convertExcelList(List<TPackageEntity> list);

    List<TPackageEntity> convertExcelList2(List<TPackageExcelVO> list);
}