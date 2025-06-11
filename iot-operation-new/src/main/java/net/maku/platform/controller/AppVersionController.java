package net.maku.platform.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import net.maku.framework.common.utils.PageResult;
import net.maku.framework.common.utils.Result;
import net.maku.framework.operatelog.annotations.OperateLog;
import net.maku.framework.operatelog.enums.OperateTypeEnum;
import net.maku.platform.service.AppVersionService;
import net.maku.platform.query.AppVersionQuery;
import net.maku.platform.vo.AppVersionVO;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import java.util.List;

/**
 * 版本管理
 *
 * @author 环游 babamu@126.com
 * <a href="https://maku.net">MAKU</a>
 */
@RestController
@RequestMapping("/platform/version")
@Tag(name="版本管理")
@AllArgsConstructor
public class AppVersionController {
    private final AppVersionService appVersionService;

    @GetMapping("page")
    @Operation(summary = "分页")
    @PreAuthorize("hasAuthority('platform:version:page')")
    public Result<PageResult<AppVersionVO>> page(@ParameterObject @Valid AppVersionQuery query){
        PageResult<AppVersionVO> page = appVersionService.page(query);

        return Result.ok(page);
    }


    @GetMapping("{id}")
    @Operation(summary = "信息")
    @PreAuthorize("hasAuthority('platform:version:info')")
    public Result<AppVersionVO> get(@PathVariable("id") Long id){
        AppVersionVO data = appVersionService.get(id);

        return Result.ok(data);
    }

    @PostMapping
    @Operation(summary = "保存")
    @OperateLog(type = OperateTypeEnum.INSERT)
    @PreAuthorize("hasAuthority('platform:version:save')")
    public Result<String> save(@RequestBody AppVersionVO vo){
        appVersionService.save(vo);

        return Result.ok();
    }

    @PutMapping
    @Operation(summary = "修改")
    @OperateLog(type = OperateTypeEnum.UPDATE)
    @PreAuthorize("hasAuthority('platform:version:update')")
    public Result<String> update(@RequestBody @Valid AppVersionVO vo){
        appVersionService.update(vo);

        return Result.ok();
    }

    @DeleteMapping
    @Operation(summary = "删除")
    @OperateLog(type = OperateTypeEnum.DELETE)
    @PreAuthorize("hasAuthority('platform:version:delete')")
    public Result<String> delete(@RequestBody List<Long> idList){
        appVersionService.delete(idList);

        return Result.ok();
    }


    @GetMapping("export")
    @Operation(summary = "导出")
    @OperateLog(type = OperateTypeEnum.EXPORT)
    @PreAuthorize("hasAuthority('platform:version:export')")
    public void export() {
        appVersionService.export();
    }
}