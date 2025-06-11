package net.maku.mealUser.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import net.maku.framework.common.utils.PageResult;
import net.maku.framework.common.utils.Result;
import net.maku.framework.operatelog.annotations.OperateLog;
import net.maku.framework.operatelog.enums.OperateTypeEnum;
import net.maku.mealUser.service.TPackageService;
import net.maku.mealUser.query.TPackageQuery;
import net.maku.mealUser.vo.TPackageVO;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import java.util.List;
import java.util.Map;

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
    public Result<PageResult<TPackageVO>> page(@ParameterObject @Valid TPackageQuery query){
        PageResult<TPackageVO> page = tPackageService.page(query);

        return Result.ok(page);
    }


    @GetMapping("{id}")
    @Operation(summary = "信息")
    public Result<TPackageVO> get(@PathVariable("id") Long id){
        TPackageVO data = tPackageService.get(id);

        return Result.ok(data);
    }

    @PostMapping
    @Operation(summary = "保存")
    @OperateLog(type = OperateTypeEnum.INSERT)
    public Result<String> save(@RequestBody TPackageVO vo){
        tPackageService.save(vo);

        return Result.ok();
    }

    @PutMapping
    @Operation(summary = "修改")
    @OperateLog(type = OperateTypeEnum.UPDATE)
    public Result<String> update(@RequestBody @Valid TPackageVO vo){
        tPackageService.update(vo);

        return Result.ok();
    }

    @DeleteMapping
    @Operation(summary = "删除")
    @OperateLog(type = OperateTypeEnum.DELETE)
    public Result<String> delete(@RequestBody List<Long> idList){
        tPackageService.delete(idList);

        return Result.ok();
    }


    @GetMapping("export")
    @Operation(summary = "导出")
    @OperateLog(type = OperateTypeEnum.EXPORT)
    public void export() {
        tPackageService.export();
    }

    @GetMapping("nameList")
    @Operation(summary = "套餐名列表")
    public Result<Map<Integer,String>> getNameList(){
        return Result.ok(tPackageService.getPackageNameList());
    }
}