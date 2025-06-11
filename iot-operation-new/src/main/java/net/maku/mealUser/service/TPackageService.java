package net.maku.mealUser.service;

import net.maku.framework.common.utils.PageResult;
import net.maku.framework.mybatis.service.BaseService;
import net.maku.mealUser.entity.TPackageEntity;
import net.maku.mealUser.query.TPackageQuery;
import net.maku.mealUser.vo.TPackageVO;

import java.util.List;
import java.util.Map;

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

    Map<Integer,String> getPackageNameList();

    void export();
}