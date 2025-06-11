package net.maku.meal.service;

import net.maku.framework.common.utils.PageResult;
import net.maku.framework.mybatis.service.BaseService;
import net.maku.meal.vo.TPackageDeviceVO;
import net.maku.meal.query.TPackageDeviceQuery;
import net.maku.meal.entity.TPackageDeviceEntity;
import java.util.List;

/**
 * 套餐设备
 *
 * @author cry babamu@126.com
 * <a href="https://maku.net">MAKU</a>
 */
public interface TPackageDeviceService extends BaseService<TPackageDeviceEntity> {

    PageResult<TPackageDeviceVO> page(TPackageDeviceQuery query);

    TPackageDeviceVO get(Long id);


    void save(TPackageDeviceVO vo);

    void update(TPackageDeviceVO vo);

    void delete(List<Long> idList);


    void export();
}