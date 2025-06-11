package net.maku.tenant.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import net.maku.framework.common.utils.PageResult;
import net.maku.framework.common.utils.Result;
import net.maku.framework.operatelog.annotations.OperateLog;
import net.maku.framework.operatelog.enums.OperateTypeEnum;
import net.maku.tenant.service.TenantService;
import net.maku.tenant.query.TenantQuery;
import net.maku.tenant.vo.TenantVO;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import java.util.List;

/**
 * 用户管理
 *
 * @author cry babamu@126.com
 * <a href="https://maku.net">MAKU</a>
 */
@RestController
@RequestMapping("/new/tenant")
@Tag(name="用户管理")
@AllArgsConstructor
public class TenantController {
    private final TenantService tenantService;

    @GetMapping("page")
    @Operation(summary = "分页")
    @PreAuthorize("hasAuthority('tenant:tenant:page')")
    public Result<PageResult<TenantVO>> page(@ParameterObject @Valid TenantQuery query){
        PageResult<TenantVO> page = tenantService.page(query);

        return Result.ok(page);
    }


    @GetMapping("{id}")
    @Operation(summary = "信息")
    @PreAuthorize("hasAuthority('tenant:tenant:info')")
    public Result<TenantVO> get(@PathVariable("id") Long id){
        TenantVO data = tenantService.get(id);

        return Result.ok(data);
    }

    @PostMapping
    @Operation(summary = "保存")
    @OperateLog(type = OperateTypeEnum.INSERT)
    @PreAuthorize("hasAuthority('tenant:tenant:save')")
    public Result<String> save(@RequestBody TenantVO vo){
        tenantService.save(vo);

        return Result.ok();
    }

    @PutMapping
    @Operation(summary = "修改")
    @OperateLog(type = OperateTypeEnum.UPDATE)
    @PreAuthorize("hasAuthority('tenant:tenant:update')")
    public Result<String> update(@RequestBody @Valid TenantVO vo){
        tenantService.update(vo);

        return Result.ok();
    }

    @DeleteMapping
    @Operation(summary = "删除")
    @OperateLog(type = OperateTypeEnum.DELETE)
    @PreAuthorize("hasAuthority('tenant:tenant:delete')")
    public Result<String> delete(@RequestBody List<Long> idList){
        tenantService.delete(idList);

        return Result.ok();
    }


    @GetMapping("export")
    @Operation(summary = "导出")
    @OperateLog(type = OperateTypeEnum.EXPORT)
    @PreAuthorize("hasAuthority('tenant:tenant:export')")
    public void export() {
        tenantService.export();
    }
}