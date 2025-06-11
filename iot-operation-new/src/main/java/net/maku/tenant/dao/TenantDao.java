package net.maku.tenant.dao;

import net.maku.framework.mybatis.dao.BaseDao;
import net.maku.tenant.entity.TenantEntity;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 用户管理
 *
 * @author cry babamu@126.com
 * <a href="https://maku.net">MAKU</a>
 */
@Mapper
public interface TenantDao extends BaseDao<TenantEntity> {
    @Insert("INSERT INTO sys_user_role (user_id, role_id) VALUES (#{tenantId}, 5)")
    void insertRoleForTenant(@Param("tenantId") Long tenantId);

}