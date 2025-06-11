package net.maku.meal.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import lombok.AllArgsConstructor;
import net.maku.framework.common.utils.PageResult;
import net.maku.framework.mybatis.service.impl.BaseServiceImpl;
import net.maku.meal.convert.TPackageConvert;
import net.maku.meal.entity.TPackageEntity;
import net.maku.meal.query.TPackageQuery;
import net.maku.meal.vo.TPackageVO;
import net.maku.meal.dao.TPackageDao;
import net.maku.meal.service.TPackageService;
import com.fhs.trans.service.impl.TransService;
import net.maku.framework.common.utils.ExcelUtils;
import net.maku.meal.vo.TPackageExcelVO;
import net.maku.framework.common.excel.ExcelFinishCallBack;
import org.springframework.web.multipart.MultipartFile;
import cn.hutool.core.util.ObjectUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.ArrayList;
import net.maku.meal.entity.TPackageDeviceEntity;
import net.maku.meal.service.TPackageDeviceService;
import net.maku.meal.convert.TPackageDeviceConvert;
import net.maku.meal.vo.TPackageDeviceVO;

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
    private final TPackageDeviceService packageDeviceService;

    @Override
    public PageResult<TPackageVO> page(TPackageQuery query) {
        IPage<TPackageEntity> page = baseMapper.selectPage(getPage(query), getWrapper(query));
        List<TPackageVO> voList = TPackageConvert.INSTANCE.convertList(page.getRecords());
        if (voList != null && !voList.isEmpty()) {
            for (TPackageVO vo : voList) {
                LambdaQueryWrapper<TPackageDeviceEntity> wrapper = Wrappers.lambdaQuery();
                wrapper.eq(TPackageDeviceEntity::getPackageId, vo.getId());
                List<TPackageDeviceEntity> deviceEntities = packageDeviceService.list(wrapper);
                if (deviceEntities != null && !deviceEntities.isEmpty()) {
                    List<TPackageDeviceVO> deviceVOList = TPackageDeviceConvert.INSTANCE.convertList(deviceEntities);
                    vo.setDeviceList(deviceVOList);
                }
            }
        }
        // 控制台打印最终返回的数据
        System.out.println("分页返回数据: " + voList);
        return new PageResult<>(voList, page.getTotal());
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
        
        // 查询套餐关联的设备类型列表
        LambdaQueryWrapper<TPackageDeviceEntity> wrapper = Wrappers.lambdaQuery();
        wrapper.eq(TPackageDeviceEntity::getPackageId, id);
        List<TPackageDeviceEntity> deviceEntities = packageDeviceService.list(wrapper);
        
        // 转换为VO对象并设置到套餐VO中
        if (deviceEntities != null && !deviceEntities.isEmpty()) {
            List<TPackageDeviceVO> deviceVOList = TPackageDeviceConvert.INSTANCE.convertList(deviceEntities);
            vo.setDeviceList(deviceVOList);
        }

        return vo;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void save(TPackageVO vo) {
        TPackageEntity entity = TPackageConvert.INSTANCE.convert(vo);
        baseMapper.insert(entity);

        // 新增套餐设备关联
        if (vo.getDeviceList() != null && !vo.getDeviceList().isEmpty()) {
            for (TPackageDeviceVO deviceVO : vo.getDeviceList()) {
                TPackageDeviceEntity deviceEntity = TPackageDeviceConvert.INSTANCE.convert(deviceVO);
                deviceEntity.setPackageId(entity.getId());
                deviceEntity.setDeleted(0);
                packageDeviceService.save(deviceEntity);
            }
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(TPackageVO vo) {
        TPackageEntity entity = TPackageConvert.INSTANCE.convert(vo);
        updateById(entity);

        LambdaQueryWrapper<TPackageDeviceEntity> wrapper = Wrappers.lambdaQuery();
        wrapper.eq(TPackageDeviceEntity::getPackageId, entity.getId());
        packageDeviceService.remove(wrapper);

        if (vo.getDeviceList() != null && !vo.getDeviceList().isEmpty()) {
            for (TPackageDeviceVO deviceVO : vo.getDeviceList()) {
                TPackageDeviceEntity deviceEntity = TPackageDeviceConvert.INSTANCE.convert(deviceVO);
                deviceEntity.setPackageId(entity.getId());
                deviceEntity.setDeleted(0);
                packageDeviceService.save(deviceEntity);
            }
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(List<Long> idList) {
        // 逻辑删除套餐
        removeByIds(idList);

        // 逻辑删除套餐设备关联
        LambdaQueryWrapper<TPackageDeviceEntity> wrapper = Wrappers.lambdaQuery();
        wrapper.in(TPackageDeviceEntity::getPackageId, idList);
        packageDeviceService.remove(wrapper);
    }


    @Override
    public void export() {
        List<TPackageEntity> entityList = list();
        List<TPackageExcelVO> excelList = TPackageConvert.INSTANCE.convertExcelList(entityList);
        // 设置设备类型ID字符串
        for (int i = 0; i < excelList.size(); i++) {
            TPackageExcelVO excelVO = excelList.get(i);
            TPackageEntity entity = entityList.get(i);
            LambdaQueryWrapper<TPackageDeviceEntity> wrapper = Wrappers.lambdaQuery();
            wrapper.eq(TPackageDeviceEntity::getPackageId, entity.getId());
            List<TPackageDeviceEntity> deviceEntities = packageDeviceService.list(wrapper);
            if (deviceEntities != null && !deviceEntities.isEmpty()) {
                StringBuilder sb = new StringBuilder();
                for (TPackageDeviceEntity device : deviceEntities) {
                    if (sb.length() > 0) sb.append(",");
                    sb.append(device.getDeviceType());
                }
                excelVO.setDeviceTypes(sb.toString());
            } else {
                excelVO.setDeviceTypes("");
            }
        }
        transService.transBatch(excelList);
        ExcelUtils.excelExport(TPackageExcelVO.class, "套餐管理", null, excelList);
    }

}