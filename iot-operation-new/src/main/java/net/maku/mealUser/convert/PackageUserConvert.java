package net.maku.mealUser.convert;

import net.maku.mealUser.entity.PackageUserEntity;
import net.maku.mealUser.vo.PackageUserVO;
import net.maku.mealUser.vo.PackageUserExcelVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * 套餐分配
 *
 * @author 阿沐 babamu@126.com
 * <a href="https://maku.net">MAKU</a>
 */
@Mapper
public interface PackageUserConvert {
    PackageUserConvert INSTANCE = Mappers.getMapper(PackageUserConvert.class);

    PackageUserEntity convert(PackageUserVO vo);

    PackageUserVO convert(PackageUserEntity entity);

    List<PackageUserVO> convertList(List<PackageUserEntity> list);

    List<PackageUserEntity> convertList2(List<PackageUserVO> list);

    List<PackageUserExcelVO> convertExcelList(List<PackageUserEntity> list);

    List<PackageUserEntity> convertExcelList2(List<PackageUserExcelVO> list);
}