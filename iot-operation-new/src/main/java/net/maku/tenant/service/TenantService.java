package net.maku.tenant.service;

import net.maku.framework.common.utils.PageResult;
import net.maku.framework.mybatis.service.BaseService;
import net.maku.tenant.vo.TenantVO;
import net.maku.tenant.query.TenantQuery;
import net.maku.tenant.entity.TenantEntity;
import java.util.List;

/**
 * 用户管理
 *
 * @author cry babamu@126.com
 * <a href="https://maku.net">MAKU</a>
 */
public interface TenantService extends BaseService<TenantEntity> {

    PageResult<TenantVO> page(TenantQuery query);

    TenantVO get(Long id);


    void save(TenantVO vo);

    void update(TenantVO vo);

    void delete(List<Long> idList);


    void export();
}