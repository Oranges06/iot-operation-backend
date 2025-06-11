package net.maku.meal.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import lombok.AllArgsConstructor;
import net.maku.framework.common.utils.PageResult;
import net.maku.framework.mybatis.service.impl.BaseServiceImpl;
import net.maku.meal.convert.TPackageDeviceConvert;
import net.maku.meal.entity.TPackageDeviceEntity;
import net.maku.meal.query.TPackageDeviceQuery;
import net.maku.meal.vo.TPackageDeviceVO;
import net.maku.meal.dao.TPackageDeviceDao;
import net.maku.meal.service.TPackageDeviceService;
import com.fhs.trans.service.impl.TransService;
import net.maku.framework.common.utils.ExcelUtils;
import net.maku.meal.vo.TPackageDeviceExcelVO;
import net.maku.framework.common.excel.ExcelFinishCallBack;
import org.springframework.web.multipart.MultipartFile;
import cn.hutool.core.util.ObjectUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 套餐设备
 *
 * @author cry babamu@126.com
 * <a href="https://maku.net">MAKU</a>
 */
@Service
@AllArgsConstructor
public class TPackageDeviceServiceImpl extends BaseServiceImpl<TPackageDeviceDao, TPackageDeviceEntity> implements TPackageDeviceService {
    private final TransService transService;

    @Override
    public PageResult<TPackageDeviceVO> page(TPackageDeviceQuery query) {
        IPage<TPackageDeviceEntity> page = baseMapper.selectPage(getPage(query), getWrapper(query));

        return new PageResult<>(TPackageDeviceConvert.INSTANCE.convertList(page.getRecords()), page.getTotal());
    }


    private LambdaQueryWrapper<TPackageDeviceEntity> getWrapper(TPackageDeviceQuery query){
        LambdaQueryWrapper<TPackageDeviceEntity> wrapper = Wrappers.lambdaQuery();

        return wrapper;
    }


    @Override
    public TPackageDeviceVO get(Long id) {
        TPackageDeviceEntity entity = baseMapper.selectById(id);
        TPackageDeviceVO vo = TPackageDeviceConvert.INSTANCE.convert(entity);

        return vo;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void save(TPackageDeviceVO vo) {
        TPackageDeviceEntity entity = TPackageDeviceConvert.INSTANCE.convert(vo);

        baseMapper.insert(entity);


    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(TPackageDeviceVO vo) {
        TPackageDeviceEntity entity = TPackageDeviceConvert.INSTANCE.convert(vo);

        updateById(entity);


    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(List<Long> idList) {
        removeByIds(idList);

    }


    @Override
    public void export() {
    List<TPackageDeviceExcelVO> excelList = TPackageDeviceConvert.INSTANCE.convertExcelList(list());
        transService.transBatch(excelList);
        ExcelUtils.excelExport(TPackageDeviceExcelVO.class, "套餐设备", null, excelList);
    }

}