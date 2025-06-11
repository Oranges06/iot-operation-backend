package net.maku.meal.service;

import net.maku.framework.common.utils.PageResult;
import net.maku.framework.mybatis.service.BaseService;
import net.maku.meal.vo.TPackageVO;
import net.maku.meal.query.TPackageQuery;
import net.maku.meal.entity.TPackageEntity;
import java.util.List;

/**
 * 套餐管理
 *
 * @author cry babamu@126.com
 * <a href="https://maku.net">MAKU</a>
 */
public interface TPackageService extends BaseService<TPackageEntity> {

    PageResult<TPackageVO> page(TPackageQuery query);

    TPackageVO get(Long id);


    void save(TPackageVO vo);

    void update(TPackageVO vo);

    void delete(List<Long> idList);


    void export();
}