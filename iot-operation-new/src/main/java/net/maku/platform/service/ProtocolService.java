package net.maku.platform.service;

import net.maku.framework.common.utils.PageResult;
import net.maku.framework.mybatis.service.BaseService;
import net.maku.platform.vo.ProtocolVO;
import net.maku.platform.query.ProtocolQuery;
import net.maku.platform.entity.ProtocolEntity;
import java.util.List;

/**
 * 协议管理
 *
 * @author 环游 babamu@126.com
 * <a href="https://maku.net">MAKU</a>
 */
public interface ProtocolService extends BaseService<ProtocolEntity> {

    PageResult<ProtocolVO> page(ProtocolQuery query);

    ProtocolVO get(Long id);


    void save(ProtocolVO vo);

    void update(ProtocolVO vo);

    void delete(List<Long> idList);


    void export();
}