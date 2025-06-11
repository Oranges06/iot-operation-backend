package net.maku.meal.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import net.maku.framework.common.utils.PageResult;
import net.maku.framework.common.utils.Result;
import net.maku.framework.operatelog.annotations.OperateLog;
import net.maku.framework.operatelog.enums.OperateTypeEnum;
import net.maku.meal.service.TPackageService;
import net.maku.meal.query.TPackageQuery;
import net.maku.meal.vo.TPackageVO;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import java.util.List;

/**
 * 套餐管理
 *
 * @author cry babamu@126.com
 * <a href="https://maku.net">MAKU</a>
 */
@RestController
@RequestMapping("/meal/package")
@Tag(name="套餐管理")
@AllArgsConstructor
public class TPackageController {
    private final TPackageService tPackageService;

    @GetMapping("page")
    @Operation(summary = "分页")
    @PreAuthorize("hasAuthority('meal:package:page')")
    public Result<PageResult<TPackageVO>> page(@ParameterObject @Valid TPackageQuery query){
        PageResult<TPackageVO> page = tPackageService.page(query);

        return Result.ok(page);
    }


    @GetMapping("{id}")
    @Operation(summary = "信息")
    @PreAuthorize("hasAuthority('meal:package:info')")
    public Result<TPackageVO> get(@PathVariable("id") Long id){
        TPackageVO data = tPackageService.get(id);

        return Result.ok(data);
    }

    @PostMapping
    @Operation(summary = "保存")
    @OperateLog(type = OperateTypeEnum.INSERT)
    @PreAuthorize("hasAuthority('meal:package:save')")
    public Result<String> save(@RequestBody TPackageVO vo){
        tPackageService.save(vo);

        return Result.ok();
    }

    @PutMapping
    @Operation(summary = "修改")
    @OperateLog(type = OperateTypeEnum.UPDATE)
    @PreAuthorize("hasAuthority('meal:package:update')")
    public Result<String> update(@RequestBody @Valid TPackageVO vo){
        tPackageService.update(vo);

        return Result.ok();
    }

    @DeleteMapping
    @Operation(summary = "删除")
    @OperateLog(type = OperateTypeEnum.DELETE)
    @PreAuthorize("hasAuthority('meal:package:delete')")
    public Result<String> delete(@RequestBody List<Long> idList){
        tPackageService.delete(idList);

        return Result.ok();
    }


    @GetMapping("export")
    @Operation(summary = "导出")
    @OperateLog(type = OperateTypeEnum.EXPORT)
    @PreAuthorize("hasAuthority('meal:package:export')")
    public void export() {
        tPackageService.export();
    }
}