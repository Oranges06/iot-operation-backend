package net.maku.tenant.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import lombok.AllArgsConstructor;
import net.maku.framework.common.utils.PageResult;
import net.maku.framework.mybatis.service.impl.BaseServiceImpl;
import net.maku.tenant.convert.TenantConvert;
import net.maku.tenant.entity.TenantEntity;
import net.maku.tenant.query.TenantQuery;
import net.maku.tenant.vo.TenantVO;
import net.maku.tenant.dao.TenantDao;
import net.maku.tenant.service.TenantService;
import com.fhs.trans.service.impl.TransService;
import net.maku.framework.common.utils.ExcelUtils;
import net.maku.tenant.vo.TenantExcelVO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import cn.hutool.core.util.ObjectUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 用户管理
 *
 * @author cry babamu@126.com
 * <a href="https://maku.net">MAKU</a>
 */
@Service
@AllArgsConstructor
public class TenantServiceImpl extends BaseServiceImpl<TenantDao, TenantEntity> implements TenantService {
    private final TransService transService;

    @Override
    public PageResult<TenantVO> page(TenantQuery query) {
        IPage<TenantEntity> page = baseMapper.selectPage(getPage(query), getWrapper(query));

        return new PageResult<>(TenantConvert.INSTANCE.convertList(page.getRecords()), page.getTotal());
    }


    private LambdaQueryWrapper<TenantEntity> getWrapper(TenantQuery query){
        LambdaQueryWrapper<TenantEntity> wrapper = Wrappers.lambdaQuery();
        wrapper.like(ObjectUtil.isNotEmpty(query.getUsername()), TenantEntity::getUsername, query.getUsername());
        wrapper.like(ObjectUtil.isNotEmpty(query.getRealName()), TenantEntity::getRealName, query.getRealName());
        wrapper.like(ObjectUtil.isNotEmpty(query.getMobile()), TenantEntity::getMobile, query.getMobile());
        wrapper.inSql(TenantEntity::getId,
                "SELECT user_id FROM sys_user_role WHERE role_id = 5"
        );
        return wrapper;
    }


    @Override
    public TenantVO get(Long id) {
        TenantEntity entity = baseMapper.selectById(id);
        TenantVO vo = TenantConvert.INSTANCE.convert(entity);

        return vo;
    }


    @Override
    @Transactional(rollbackFor = Exception.class)
    public void save(TenantVO vo) {
        TenantEntity entity = TenantConvert.INSTANCE.convert(vo);
        baseMapper.insert(entity);
        Long tenantId = entity.getId();

        baseMapper.insertRoleForTenant(tenantId);

    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(TenantVO vo) {
        TenantEntity entity = TenantConvert.INSTANCE.convert(vo);

        updateById(entity);


    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(List<Long> idList) {
        removeByIds(idList);

    }


    @Override
    public void export() {
    List<TenantExcelVO> excelList = TenantConvert.INSTANCE.convertExcelList(list());
        transService.transBatch(excelList);
        ExcelUtils.excelExport(TenantExcelVO.class, "租户管理", null, excelList);
    }

}