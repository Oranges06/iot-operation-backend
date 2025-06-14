package net.maku.iot.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import net.maku.framework.common.utils.PageResult;
import net.maku.framework.common.utils.Result;
import net.maku.framework.operatelog.annotations.OperateLog;
import net.maku.framework.operatelog.enums.OperateTypeEnum;
import net.maku.iot.service.DeviceService;
import net.maku.iot.query.DeviceQuery;
import net.maku.iot.vo.DeviceVO;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import java.util.List;

/**
 * 设备
 *
 * @author cry babamu@126.com
 * <a href="https://maku.net">MAKU</a>
 */
@RestController
@RequestMapping("/iot/device")
@Tag(name="设备")
@AllArgsConstructor
public class DeviceController {
    private final DeviceService deviceService;

    @GetMapping("page")
    @Operation(summary = "分页")
    @PreAuthorize("hasAuthority('iot:device:page')")
    public Result<PageResult<DeviceVO>> page(@ParameterObject @Valid DeviceQuery query){
        PageResult<DeviceVO> page = deviceService.page(query);

        return Result.ok(page);
    }


    @GetMapping("{id}")
    @Operation(summary = "信息")
    @PreAuthorize("hasAuthority('iot:device:info')")
    public Result<DeviceVO> get(@PathVariable("id") Long id){
        DeviceVO data = deviceService.get(id);

        return Result.ok(data);
    }

    @PostMapping
    @Operation(summary = "保存")
    @OperateLog(type = OperateTypeEnum.INSERT)
    @PreAuthorize("hasAuthority('iot:device:save')")
    public Result<String> save(@RequestBody DeviceVO vo){
        deviceService.save(vo);

        return Result.ok();
    }

    @PutMapping
    @Operation(summary = "修改")
    @OperateLog(type = OperateTypeEnum.UPDATE)
    @PreAuthorize("hasAuthority('iot:device:update')")
    public Result<String> update(@RequestBody @Valid DeviceVO vo){
        deviceService.update(vo);

        return Result.ok();
    }

    @DeleteMapping
    @Operation(summary = "删除")
    @OperateLog(type = OperateTypeEnum.DELETE)
    @PreAuthorize("hasAuthority('iot:device:delete')")
    public Result<String> delete(@RequestBody List<Long> idList){
        deviceService.delete(idList);

        return Result.ok();
    }


    @GetMapping("export")
    @Operation(summary = "导出")
    @OperateLog(type = OperateTypeEnum.EXPORT)
    @PreAuthorize("hasAuthority('iot:device:export')")
    public void export() {
        deviceService.export();
    }
}