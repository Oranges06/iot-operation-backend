package net.maku.iot.dao;

import net.maku.framework.mybatis.dao.BaseDao;
import net.maku.iot.entity.DeviceEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 设备
 *
 * @author cry babamu@126.com
 * <a href="https://maku.net">MAKU</a>
 */
@Mapper
public interface DeviceDao extends BaseDao<DeviceEntity> {

}