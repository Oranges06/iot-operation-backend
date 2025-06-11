package net.maku.tenant.convert;

import net.maku.tenant.entity.TenantEntity;
import net.maku.tenant.vo.TenantVO;
import net.maku.tenant.vo.TenantExcelVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * 用户管理
 *
 * @author cry babamu@126.com
 * <a href="https://maku.net">MAKU</a>
 */
@Mapper
public interface TenantConvert {
    TenantConvert INSTANCE = Mappers.getMapper(TenantConvert.class);

    TenantEntity convert(TenantVO vo);

    TenantVO convert(TenantEntity entity);

    List<TenantVO> convertList(List<TenantEntity> list);

    List<TenantEntity> convertList2(List<TenantVO> list);

    List<TenantExcelVO> convertExcelList(List<TenantEntity> list);

    List<TenantEntity> convertExcelList2(List<TenantExcelVO> list);
}