package net.maku.meal.convert;

import net.maku.meal.entity.TPackageDeviceEntity;
import net.maku.meal.vo.TPackageDeviceVO;
import net.maku.meal.vo.TPackageDeviceExcelVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * 套餐设备
 *
 * @author cry babamu@126.com
 * <a href="https://maku.net">MAKU</a>
 */
@Mapper
public interface TPackageDeviceConvert {
    TPackageDeviceConvert INSTANCE = Mappers.getMapper(TPackageDeviceConvert.class);

    TPackageDeviceEntity convert(TPackageDeviceVO vo);

    TPackageDeviceVO convert(TPackageDeviceEntity entity);

    List<TPackageDeviceVO> convertList(List<TPackageDeviceEntity> list);

    List<TPackageDeviceEntity> convertList2(List<TPackageDeviceVO> list);

    List<TPackageDeviceExcelVO> convertExcelList(List<TPackageDeviceEntity> list);

    List<TPackageDeviceEntity> convertExcelList2(List<TPackageDeviceExcelVO> list);
}