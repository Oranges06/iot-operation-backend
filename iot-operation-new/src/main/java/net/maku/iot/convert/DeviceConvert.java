package net.maku.iot.convert;

import net.maku.iot.entity.DeviceEntity;
import net.maku.iot.vo.DeviceVO;
import net.maku.iot.vo.DeviceExcelVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * 设备
 *
 * @author cry babamu@126.com
 * <a href="https://maku.net">MAKU</a>
 */
@Mapper
public interface DeviceConvert {
    DeviceConvert INSTANCE = Mappers.getMapper(DeviceConvert.class);

    DeviceEntity convert(DeviceVO vo);

    DeviceVO convert(DeviceEntity entity);

    List<DeviceVO> convertList(List<DeviceEntity> list);

    List<DeviceEntity> convertList2(List<DeviceVO> list);

    List<DeviceExcelVO> convertExcelList(List<DeviceEntity> list);

    List<DeviceEntity> convertExcelList2(List<DeviceExcelVO> list);
}