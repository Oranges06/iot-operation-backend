package net.maku.platform.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import net.maku.framework.common.utils.PageResult;
import net.maku.framework.common.utils.Result;
import net.maku.framework.operatelog.annotations.OperateLog;
import net.maku.framework.operatelog.enums.OperateTypeEnum;
import net.maku.platform.service.ProtocolService;
import net.maku.platform.query.ProtocolQuery;
import net.maku.platform.vo.ProtocolVO;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import java.util.List;

/**
 * 协议管理
 *
 * @author 环游 babamu@126.com
 * <a href="https://maku.net">MAKU</a>
 */
@RestController
@RequestMapping("/platform/protocol")
@Tag(name="协议管理")
@AllArgsConstructor
public class ProtocolController {
    private final ProtocolService protocolService;

    @GetMapping("page")
    @Operation(summary = "分页")
    @PreAuthorize("hasAuthority('platform:protocol:page')")
    public Result<PageResult<ProtocolVO>> page(@ParameterObject @Valid ProtocolQuery query){
        PageResult<ProtocolVO> page = protocolService.page(query);

        return Result.ok(page);
    }


    @GetMapping("{id}")
    @Operation(summary = "信息")
    @PreAuthorize("hasAuthority('platform:protocol:info')")
    public Result<ProtocolVO> get(@PathVariable("id") Long id){
        ProtocolVO data = protocolService.get(id);

        return Result.ok(data);
    }

    @PostMapping
    @Operation(summary = "保存")
    @OperateLog(type = OperateTypeEnum.INSERT)
    @PreAuthorize("hasAuthority('platform:protocol:save')")
    public Result<String> save(@RequestBody ProtocolVO vo){
        protocolService.save(vo);

        return Result.ok();
    }

    @PutMapping
    @Operation(summary = "修改")
    @OperateLog(type = OperateTypeEnum.UPDATE)
    @PreAuthorize("hasAuthority('platform:protocol:update')")
    public Result<String> update(@RequestBody @Valid ProtocolVO vo){
        protocolService.update(vo);

        return Result.ok();
    }

    @DeleteMapping
    @Operation(summary = "删除")
    @OperateLog(type = OperateTypeEnum.DELETE)
    @PreAuthorize("hasAuthority('platform:protocol:delete')")
    public Result<String> delete(@RequestBody List<Long> idList){
        protocolService.delete(idList);

        return Result.ok();
    }


    @GetMapping("export")
    @Operation(summary = "导出")
    @OperateLog(type = OperateTypeEnum.EXPORT)
    @PreAuthorize("hasAuthority('platform:protocol:export')")
    public void export() {
        protocolService.export();
    }
}