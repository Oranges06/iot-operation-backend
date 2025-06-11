package net.maku.platform.dao;

import net.maku.framework.mybatis.dao.BaseDao;
import net.maku.platform.entity.ProtocolEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 协议管理
 *
 * @author 环游 babamu@126.com
 * <a href="https://maku.net">MAKU</a>
 */
@Mapper
public interface ProtocolDao extends BaseDao<ProtocolEntity> {

}