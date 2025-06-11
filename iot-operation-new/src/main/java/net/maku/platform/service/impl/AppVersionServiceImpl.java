package net.maku.platform.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import lombok.AllArgsConstructor;
import net.maku.framework.common.utils.PageResult;
import net.maku.framework.mybatis.service.impl.BaseServiceImpl;
import net.maku.platform.convert.AppVersionConvert;
import net.maku.platform.entity.AppVersionEntity;
import net.maku.platform.query.AppVersionQuery;
import net.maku.platform.vo.AppVersionVO;
import net.maku.platform.dao.AppVersionDao;
import net.maku.platform.service.AppVersionService;
import com.fhs.trans.service.impl.TransService;
import net.maku.framework.common.utils.ExcelUtils;
import net.maku.platform.vo.AppVersionExcelVO;
import net.maku.framework.common.excel.ExcelFinishCallBack;
import org.springframework.web.multipart.MultipartFile;
import cn.hutool.core.util.ObjectUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 版本管理
 *
 * @author 环游 babamu@126.com
 * <a href="https://maku.net">MAKU</a>
 */
@Service
@AllArgsConstructor
public class AppVersionServiceImpl extends BaseServiceImpl<AppVersionDao, AppVersionEntity> implements AppVersionService {
    private final TransService transService;

    @Override
    public PageResult<AppVersionVO> page(AppVersionQuery query) {
        IPage<AppVersionEntity> page = baseMapper.selectPage(getPage(query), getWrapper(query));

        return new PageResult<>(AppVersionConvert.INSTANCE.convertList(page.getRecords()), page.getTotal());
    }


    private LambdaQueryWrapper<AppVersionEntity> getWrapper(AppVersionQuery query){
        LambdaQueryWrapper<AppVersionEntity> wrapper = Wrappers.lambdaQuery();

        return wrapper;
    }


    @Override
    public AppVersionVO get(Long id) {
        AppVersionEntity entity = baseMapper.selectById(id);
        AppVersionVO vo = AppVersionConvert.INSTANCE.convert(entity);

        return vo;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void save(AppVersionVO vo) {
        AppVersionEntity entity = AppVersionConvert.INSTANCE.convert(vo);

        baseMapper.insert(entity);


    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(AppVersionVO vo) {
        AppVersionEntity entity = AppVersionConvert.INSTANCE.convert(vo);

        updateById(entity);


    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(List<Long> idList) {
        removeByIds(idList);

    }


    @Override
    public void export() {
    List<AppVersionExcelVO> excelList = AppVersionConvert.INSTANCE.convertExcelList(list());
        transService.transBatch(excelList);
        ExcelUtils.excelExport(AppVersionExcelVO.class, "版本管理", null, excelList);
    }

}