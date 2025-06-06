package net.maku.iot.service;

import net.maku.framework.common.utils.PageResult;
import net.maku.framework.mybatis.service.BaseService;
import net.maku.iot.vo.DeviceVO;
import net.maku.iot.query.DeviceQuery;
import net.maku.iot.entity.DeviceEntity;
import java.util.List;

/**
 * 设备
 *
 * @author cry babamu@126.com
 * <a href="https://maku.net">MAKU</a>
 */
public interface DeviceService extends BaseService<DeviceEntity> {

    PageResult<DeviceVO> page(DeviceQuery query);

    DeviceVO get(Long id);


    void save(DeviceVO vo);

    void update(DeviceVO vo);

    void delete(List<Long> idList);


    void export();
}