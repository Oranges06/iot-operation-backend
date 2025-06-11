package net.maku.platform.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import lombok.AllArgsConstructor;
import net.maku.framework.common.utils.PageResult;
import net.maku.framework.mybatis.service.impl.BaseServiceImpl;
import net.maku.platform.convert.ProtocolConvert;
import net.maku.platform.entity.ProtocolEntity;
import net.maku.platform.query.ProtocolQuery;
import net.maku.platform.vo.ProtocolVO;
import net.maku.platform.dao.ProtocolDao;
import net.maku.platform.service.ProtocolService;
import com.fhs.trans.service.impl.TransService;
import net.maku.framework.common.utils.ExcelUtils;
import net.maku.platform.vo.ProtocolExcelVO;
import net.maku.framework.common.excel.ExcelFinishCallBack;
import org.springframework.web.multipart.MultipartFile;
import cn.hutool.core.util.ObjectUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 协议管理
 *
 * @author 环游 babamu@126.com
 * <a href="https://maku.net">MAKU</a>
 */
@Service
@AllArgsConstructor
public class ProtocolServiceImpl extends BaseServiceImpl<ProtocolDao, ProtocolEntity> implements ProtocolService {
    private final TransService transService;

    @Override
    public PageResult<ProtocolVO> page(ProtocolQuery query) {
        IPage<ProtocolEntity> page = baseMapper.selectPage(getPage(query), getWrapper(query));

        return new PageResult<>(ProtocolConvert.INSTANCE.convertList(page.getRecords()), page.getTotal());
    }


    private LambdaQueryWrapper<ProtocolEntity> getWrapper(ProtocolQuery query){
        LambdaQueryWrapper<ProtocolEntity> wrapper = Wrappers.lambdaQuery();

        return wrapper;
    }


    @Override
    public ProtocolVO get(Long id) {
        ProtocolEntity entity = baseMapper.selectById(id);
        ProtocolVO vo = ProtocolConvert.INSTANCE.convert(entity);

        return vo;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void save(ProtocolVO vo) {
        ProtocolEntity entity = ProtocolConvert.INSTANCE.convert(vo);

        baseMapper.insert(entity);


    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(ProtocolVO vo) {
        ProtocolEntity entity = ProtocolConvert.INSTANCE.convert(vo);

        updateById(entity);


    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(List<Long> idList) {
        removeByIds(idList);

    }


    @Override
    public void export() {
    List<ProtocolExcelVO> excelList = ProtocolConvert.INSTANCE.convertExcelList(list());
        transService.transBatch(excelList);
        ExcelUtils.excelExport(ProtocolExcelVO.class, "协议管理", null, excelList);
    }

}