package net.maku.platform.dao;

import net.maku.framework.mybatis.dao.BaseDao;
import net.maku.platform.entity.AppVersionEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 版本管理
 *
 * @author 环游 babamu@126.com
 * <a href="https://maku.net">MAKU</a>
 */
@Mapper
public interface AppVersionDao extends BaseDao<AppVersionEntity> {

}