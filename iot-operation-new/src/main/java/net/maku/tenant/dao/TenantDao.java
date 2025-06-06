package net.maku.tenant.dao;

import net.maku.framework.mybatis.dao.BaseDao;
import net.maku.tenant.entity.TenantEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 用户管理
 *
 * @author cry babamu@126.com
 * <a href="https://maku.net">MAKU</a>
 */
@Mapper
public interface TenantDao extends BaseDao<TenantEntity> {

}