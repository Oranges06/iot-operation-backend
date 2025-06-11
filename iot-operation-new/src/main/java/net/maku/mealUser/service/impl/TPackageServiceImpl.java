package net.maku.mealUser.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import lombok.AllArgsConstructor;
import net.maku.framework.common.utils.PageResult;
import net.maku.framework.mybatis.service.impl.BaseServiceImpl;
import com.fhs.trans.service.impl.TransService;
import net.maku.framework.common.utils.ExcelUtils;
import net.maku.mealUser.convert.TPackageConvert;
import net.maku.mealUser.dao.PackageUserDao;
import net.maku.mealUser.dao.TPackageDao;
import net.maku.mealUser.entity.TPackageEntity;
import net.maku.mealUser.query.TPackageQuery;
import net.maku.mealUser.service.TPackageService;
import net.maku.mealUser.vo.TPackageExcelVO;
import net.maku.mealUser.vo.TPackageVO;
import cn.hutool.core.util.ObjectUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 套餐管理
 *
 * @author cry babamu@126.com
 * <a href="https://maku.net">MAKU</a>
 */
@Service
@AllArgsConstructor
public class TPackageServiceImpl extends BaseServiceImpl<TPackageDao, TPackageEntity> implements TPackageService {
    private final TransService transService;
    private final PackageUserDao packageUserDao;

    @Override
    public PageResult<TPackageVO> page(TPackageQuery query) {
        IPage<TPackageEntity> page = baseMapper.selectPage(getPage(query), getWrapper(query));

        return new PageResult<>(TPackageConvert.INSTANCE.convertList(page.getRecords()), page.getTotal());
    }


    private LambdaQueryWrapper<TPackageEntity> getWrapper(TPackageQuery query){
        LambdaQueryWrapper<TPackageEntity> wrapper = Wrappers.lambdaQuery();
        wrapper.like(ObjectUtil.isNotEmpty(query.getName()), TPackageEntity::getName, query.getName());

        return wrapper;
    }


    @Override
    public TPackageVO get(Long id) {
        TPackageEntity entity = baseMapper.selectById(id);
        TPackageVO vo = TPackageConvert.INSTANCE.convert(entity);

        return vo;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void save(TPackageVO vo) {
        TPackageEntity entity = TPackageConvert.INSTANCE.convert(vo);

        baseMapper.insert(entity);


    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(TPackageVO vo) {
        TPackageEntity entity = TPackageConvert.INSTANCE.convert(vo);
        updateById(entity);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(List<Long> idList) {
        removeByIds(idList);

    }


    @Override
    public void export() {
    List<TPackageExcelVO> excelList = TPackageConvert.INSTANCE.convertExcelList(list());
        transService.transBatch(excelList);
        ExcelUtils.excelExport(TPackageExcelVO.class, "套餐管理", null, excelList);
    }

    @Override
    public Map<Integer, String> getPackageNameList() {
        return baseMapper.selectList(null).stream()
                .filter(pkg -> pkg.getId() != null && pkg.getName() != null)
                .collect(Collectors.toMap(TPackageEntity::getId, TPackageEntity::getName));
    }


}