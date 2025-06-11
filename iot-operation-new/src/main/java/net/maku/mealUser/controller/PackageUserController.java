package net.maku.mealUser.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import net.maku.framework.common.utils.PageResult;
import net.maku.framework.common.utils.Result;
import net.maku.framework.operatelog.annotations.OperateLog;
import net.maku.framework.operatelog.enums.OperateTypeEnum;
import net.maku.mealUser.service.PackageUserService;
import net.maku.mealUser.query.PackageUserQuery;
import net.maku.mealUser.vo.PackageUserVO;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import java.util.List;

/**
 * 套餐分配
 *
 * @author 阿沐 babamu@126.com
 * <a href="https://maku.net">MAKU</a>
 */
@RestController
@RequestMapping("/meal/packageUser")
@Tag(name="套餐分配")
@AllArgsConstructor
public class PackageUserController {
    private final PackageUserService packageUserService;

    @GetMapping("page")
    @Operation(summary = "分页")
    @PreAuthorize("hasAuthority('meal:packageUser:page')")
    public Result<PageResult<PackageUserVO>> page(@ParameterObject @Valid PackageUserQuery query){
        PageResult<PackageUserVO> page = packageUserService.page(query);

        return Result.ok(page);
    }


    @GetMapping("{id}")
    @Operation(summary = "信息")
    @PreAuthorize("hasAuthority('meal:packageUser:info')")
    public Result<PackageUserVO> get(@PathVariable("id") Long id){
        PackageUserVO data = packageUserService.get(id);

        return Result.ok(data);
    }

    @PostMapping
    @Operation(summary = "保存")
    @OperateLog(type = OperateTypeEnum.INSERT)
    @PreAuthorize("hasAuthority('meal:packageUser:save')")
    public Result<String> save(@RequestBody PackageUserVO vo){
        packageUserService.save(vo);

        return Result.ok();
    }

    @PutMapping
    @Operation(summary = "修改")
    @OperateLog(type = OperateTypeEnum.UPDATE)
    @PreAuthorize("hasAuthority('meal:packageUser:update')")
    public Result<String> update(@RequestBody @Valid PackageUserVO vo){
        packageUserService.update(vo);
        return Result.ok();
    }

    @DeleteMapping
    @Operation(summary = "删除")
    @OperateLog(type = OperateTypeEnum.DELETE)
    @PreAuthorize("hasAuthority('meal:packageUser:delete')")
    public Result<String> delete(@RequestBody List<Long> idList){
        packageUserService.delete(idList);

        return Result.ok();
    }


    @GetMapping("export")
    @Operation(summary = "导出")
    @OperateLog(type = OperateTypeEnum.EXPORT)
    @PreAuthorize("hasAuthority('meal:packageUser:export')")
    public void export() {
        packageUserService.export();
    }
}