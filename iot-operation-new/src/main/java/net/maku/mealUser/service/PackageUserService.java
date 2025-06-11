package net.maku.mealUser.service;

import net.maku.framework.common.utils.PageResult;
import net.maku.framework.mybatis.service.BaseService;
import net.maku.mealUser.vo.PackageUserVO;
import net.maku.mealUser.query.PackageUserQuery;
import net.maku.mealUser.entity.PackageUserEntity;
import java.util.List;

/**
 * 套餐分配
 *
 * @author 阿沐 babamu@126.com
 * <a href="https://maku.net">MAKU</a>
 */
public interface PackageUserService extends BaseService<PackageUserEntity> {

    PageResult<PackageUserVO> page(PackageUserQuery query);

    PackageUserVO get(Long id);

    void save(PackageUserVO vo);

    void update(PackageUserVO vo);

    void delete(List<Long> idList);


    void export();
}