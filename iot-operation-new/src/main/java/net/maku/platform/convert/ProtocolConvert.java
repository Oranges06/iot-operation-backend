package net.maku.platform.convert;

import net.maku.platform.entity.ProtocolEntity;
import net.maku.platform.vo.ProtocolVO;
import net.maku.platform.vo.ProtocolExcelVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * 协议管理
 *
 * @author 环游 babamu@126.com
 * <a href="https://maku.net">MAKU</a>
 */
@Mapper
public interface ProtocolConvert {
    ProtocolConvert INSTANCE = Mappers.getMapper(ProtocolConvert.class);

    ProtocolEntity convert(ProtocolVO vo);

    ProtocolVO convert(ProtocolEntity entity);

    List<ProtocolVO> convertList(List<ProtocolEntity> list);

    List<ProtocolEntity> convertList2(List<ProtocolVO> list);

    List<ProtocolExcelVO> convertExcelList(List<ProtocolEntity> list);

    List<ProtocolEntity> convertExcelList2(List<ProtocolExcelVO> list);
}