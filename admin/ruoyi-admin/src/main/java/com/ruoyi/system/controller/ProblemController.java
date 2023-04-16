package com.ruoyi.system.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.system.domain.Problem;
import com.ruoyi.system.service.IProblemService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 问题管理Controller
 * 
 * @author felix
 * @date 2023-04-16
 */
@RestController
@RequestMapping("/system/problem")
public class ProblemController extends BaseController
{
    @Autowired
    private IProblemService problemService;

    /**
     * 查询问题管理列表
     */
    @PreAuthorize("@ss.hasPermi('system:problem:list')")
    @GetMapping("/list")
    public TableDataInfo list(Problem problem)
    {
        startPage();
        List<Problem> list = problemService.selectProblemList(problem);
        return getDataTable(list);
    }

    /**
     * 导出问题管理列表
     */
    @PreAuthorize("@ss.hasPermi('system:problem:export')")
    @Log(title = "问题管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Problem problem)
    {
        List<Problem> list = problemService.selectProblemList(problem);
        ExcelUtil<Problem> util = new ExcelUtil<Problem>(Problem.class);
        util.exportExcel(response, list, "问题管理数据");
    }

    /**
     * 获取问题管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:problem:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(problemService.selectProblemById(id));
    }

    /**
     * 新增问题管理
     */
    @PreAuthorize("@ss.hasPermi('system:problem:add')")
    @Log(title = "问题管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Problem problem)
    {
        return toAjax(problemService.insertProblem(problem));
    }

    /**
     * 修改问题管理
     */
    @PreAuthorize("@ss.hasPermi('system:problem:edit')")
    @Log(title = "问题管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Problem problem)
    {
        return toAjax(problemService.updateProblem(problem));
    }

    /**
     * 删除问题管理
     */
    @PreAuthorize("@ss.hasPermi('system:problem:remove')")
    @Log(title = "问题管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(problemService.deleteProblemByIds(ids));
    }
}
