package net.maku.platform.service;

import net.maku.framework.common.utils.PageResult;
import net.maku.framework.mybatis.service.BaseService;
import net.maku.platform.vo.AppVersionVO;
import net.maku.platform.query.AppVersionQuery;
import net.maku.platform.entity.AppVersionEntity;
import java.util.List;

/**
 * 版本管理
 *
 * @author 环游 babamu@126.com
 * <a href="https://maku.net">MAKU</a>
 */
public interface AppVersionService extends BaseService<AppVersionEntity> {

    PageResult<AppVersionVO> page(AppVersionQuery query);

    AppVersionVO get(Long id);


    void save(AppVersionVO vo);

    void update(AppVersionVO vo);

    void delete(List<Long> idList);


    void export();
}