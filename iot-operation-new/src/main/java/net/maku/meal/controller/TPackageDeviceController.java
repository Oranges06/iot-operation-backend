package net.maku.meal.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import net.maku.framework.common.utils.PageResult;
import net.maku.framework.common.utils.Result;
import net.maku.framework.operatelog.annotations.OperateLog;
import net.maku.framework.operatelog.enums.OperateTypeEnum;
import net.maku.meal.service.TPackageDeviceService;
import net.maku.meal.query.TPackageDeviceQuery;
import net.maku.meal.vo.TPackageDeviceVO;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import java.util.List;

/**
 * 套餐设备
 *
 * @author cry babamu@126.com
 * <a href="https://maku.net">MAKU</a>
 */
@RestController
@RequestMapping("/meal/device")
@Tag(name="套餐设备")
@AllArgsConstructor
public class TPackageDeviceController {
    private final TPackageDeviceService tPackageDeviceService;

    @GetMapping("page")
    @Operation(summary = "分页")
    @PreAuthorize("hasAuthority('meal:device:page')")
    public Result<PageResult<TPackageDeviceVO>> page(@ParameterObject @Valid TPackageDeviceQuery query){
        PageResult<TPackageDeviceVO> page = tPackageDeviceService.page(query);

        return Result.ok(page);
    }


    @GetMapping("{id}")
    @Operation(summary = "信息")
    @PreAuthorize("hasAuthority('meal:device:info')")
    public Result<TPackageDeviceVO> get(@PathVariable("id") Long id){
        TPackageDeviceVO data = tPackageDeviceService.get(id);

        return Result.ok(data);
    }

    @PostMapping
    @Operation(summary = "保存")
    @OperateLog(type = OperateTypeEnum.INSERT)
    @PreAuthorize("hasAuthority('meal:device:save')")
    public Result<String> save(@RequestBody TPackageDeviceVO vo){
        tPackageDeviceService.save(vo);

        return Result.ok();
    }

    @PutMapping
    @Operation(summary = "修改")
    @OperateLog(type = OperateTypeEnum.UPDATE)
    @PreAuthorize("hasAuthority('meal:device:update')")
    public Result<String> update(@RequestBody @Valid TPackageDeviceVO vo){
        tPackageDeviceService.update(vo);

        return Result.ok();
    }

    @DeleteMapping
    @Operation(summary = "删除")
    @OperateLog(type = OperateTypeEnum.DELETE)
    @PreAuthorize("hasAuthority('meal:device:delete')")
    public Result<String> delete(@RequestBody List<Long> idList){
        tPackageDeviceService.delete(idList);

        return Result.ok();
    }


    @GetMapping("export")
    @Operation(summary = "导出")
    @OperateLog(type = OperateTypeEnum.EXPORT)
    @PreAuthorize("hasAuthority('meal:device:export')")
    public void export() {
        tPackageDeviceService.export();
    }
}