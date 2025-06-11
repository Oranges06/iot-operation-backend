package net.maku.mealUser.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import lombok.AllArgsConstructor;
import net.maku.framework.common.utils.PageResult;
import net.maku.framework.mybatis.service.impl.BaseServiceImpl;
import net.maku.mealUser.convert.PackageUserConvert;
import net.maku.mealUser.dao.TPackageDao;
import net.maku.mealUser.entity.PackageUserEntity;
import net.maku.mealUser.entity.TPackageEntity;
import net.maku.mealUser.query.PackageUserQuery;
import net.maku.mealUser.vo.PackageUserVO;
import net.maku.mealUser.dao.PackageUserDao;
import net.maku.mealUser.service.PackageUserService;
import com.fhs.trans.service.impl.TransService;
import net.maku.framework.common.utils.ExcelUtils;
import net.maku.mealUser.vo.PackageUserExcelVO;
import cn.hutool.core.util.ObjectUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 套餐分配
 *
 * @author 阿沐 babamu@126.com
 * <a href="https://maku.net">MAKU</a>
 */
@Service
@AllArgsConstructor
public class PackageUserServiceImpl extends BaseServiceImpl<PackageUserDao, PackageUserEntity> implements PackageUserService {
    private final TransService transService;
    private final TPackageDao tPackageDao;

    @Override
    public PageResult<PackageUserVO> page(PackageUserQuery query) {
        IPage<PackageUserEntity> page = baseMapper.selectPage(getPage(query), getWrapper(query));

        List<PackageUserVO> voList = PackageUserConvert.INSTANCE.convertList(page.getRecords());

        // 获取所有 packageId
        Set<Integer> packageIds = voList.stream()
                .map(PackageUserVO::getPackageId)
                .filter(Objects::nonNull)
                .collect(Collectors.toSet());

        if (!packageIds.isEmpty()) {
            // 查询所有相关套餐信息
            Map<Integer, String> packageNameMap = tPackageDao.selectBatchIds(packageIds).stream()
                    .collect(Collectors.toMap(TPackageEntity::getId, TPackageEntity::getName));

            // 填充 packageName，判断是否存在该套餐
            voList.forEach(vo -> {
                String name = packageNameMap.get(vo.getPackageId());
                vo.setPackageName(name != null ? name : "套餐不存在");
            });
        }

        return new PageResult<>(voList, page.getTotal());
    }


    private LambdaQueryWrapper<PackageUserEntity> getWrapper(PackageUserQuery query) {
        LambdaQueryWrapper<PackageUserEntity> wrapper = Wrappers.lambdaQuery();

        // 根据 packageName 查询对应的 packageId 列表
        if (ObjectUtil.isNotEmpty(query.getPackageName())) {
            LambdaQueryWrapper<TPackageEntity> packageWrapper = Wrappers.lambdaQuery();
            packageWrapper.like(TPackageEntity::getName, query.getPackageName());

            List<TPackageEntity> packages = tPackageDao.selectList(packageWrapper);
            List<Integer> packageIds = packages.stream()
                    .map(TPackageEntity::getId)
                    .collect(Collectors.toList());

            if (!packageIds.isEmpty()) {
                wrapper.in(PackageUserEntity::getPackageId, packageIds);
            } else {
                // 如果没有查到套餐，强制不返回数据
                wrapper.eq(PackageUserEntity::getPackageId, -1);
            }
        }

        // 其他条件
        wrapper.like(ObjectUtil.isNotEmpty(query.getUserId()), PackageUserEntity::getUserId, query.getUserId());

        return wrapper;
    }



    @Override
    public PackageUserVO get(Long id) {
        PackageUserEntity entity = baseMapper.selectById(id);
        PackageUserVO vo = PackageUserConvert.INSTANCE.convert(entity);

        return vo;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void save(PackageUserVO vo) {
        PackageUserEntity entity = PackageUserConvert.INSTANCE.convert(vo);

        baseMapper.insert(entity);


    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(PackageUserVO vo) {
        PackageUserEntity entity = PackageUserConvert.INSTANCE.convert(vo);

        updateById(entity);


    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(List<Long> idList) {
        removeByIds(idList);

    }


    @Override
    public void export() {
    List<PackageUserExcelVO> excelList = PackageUserConvert.INSTANCE.convertExcelList(list());
        transService.transBatch(excelList);
        ExcelUtils.excelExport(PackageUserExcelVO.class, "套餐分配", null, excelList);
    }

}