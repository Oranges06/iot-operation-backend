package net.maku.mealUser.dao;

import net.maku.framework.mybatis.dao.BaseDao;
import net.maku.mealUser.entity.PackageUserEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 套餐分配
 *
 * @author 阿沐 babamu@126.com
 * <a href="https://maku.net">MAKU</a>
 */
@Mapper
public interface PackageUserDao extends BaseDao<PackageUserEntity> {

}