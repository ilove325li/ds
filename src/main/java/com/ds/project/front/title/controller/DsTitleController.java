package com.ds.project.front.title.controller;

import java.util.ArrayList;
import java.util.List;

import com.ds.project.front.terms.domain.DsSearchArticleTerms;
import com.ds.project.system.dept.domain.Dept;
import com.ds.project.system.dept.service.IDeptService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ds.framework.aspectj.lang.annotation.Log;
import com.ds.framework.aspectj.lang.enums.BusinessType;
import com.ds.project.front.title.domain.DsTitle;
import com.ds.project.front.title.service.IDsTitleService;
import com.ds.framework.web.controller.BaseController;
import com.ds.framework.web.domain.AjaxResult;
import com.ds.common.utils.poi.ExcelUtil;
import com.ds.common.utils.StringUtils;
import com.ds.framework.web.domain.Ztree;

/**
 * 党史标题管理Controller
 * 
 * @author wkk
 * @date 2025-02-02
 */
@Controller
@RequestMapping("/front/title")
public class DsTitleController extends BaseController
{
    private String prefix = "front/title";

    @Autowired
    private IDsTitleService dsTitleService;

    @RequiresPermissions("front:title:view")
    @GetMapping()
    public String title()
    {
        return prefix + "/title";
    }

    /**
     * 查询党史标题管理树列表
     */
    @RequiresPermissions("front:title:list")
    @PostMapping("/list")
    @ResponseBody
    public List<DsTitle> list(DsTitle dsTitle)
    {
        List<DsTitle> list = dsTitleService.selectDsTitleList(dsTitle);
        return list;
    }

    /**
     * 导出党史标题管理列表
     */
    @RequiresPermissions("front:title:export")
    @Log(title = "党史标题管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(DsTitle dsTitle)
    {
        List<DsTitle> list = dsTitleService.selectDsTitleList(dsTitle);
        ExcelUtil<DsTitle> util = new ExcelUtil<DsTitle>(DsTitle.class);
        return util.exportExcel(list, "党史标题管理数据");
    }

    /**
     * 新增党史标题管理
     */
    @GetMapping(value = { "/add/{id}", "/add/" })
    public String add(@PathVariable(value = "id", required = false) Long id, ModelMap mmap)
    {
        if (StringUtils.isNotNull(id))
        {
            mmap.put("dsTitle", dsTitleService.selectDsTitleById(id));
        }
        return prefix + "/add";
    }

    /**
     * 新增保存党史标题管理
     */
    @RequiresPermissions("front:title:add")
    @Log(title = "党史标题管理", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(DsTitle dsTitle)
    {
        return toAjax(dsTitleService.insertDsTitle(dsTitle));
    }

    /**
     * 修改党史标题管理
     */
    @RequiresPermissions("front:title:edit")
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        DsTitle dsTitle = dsTitleService.selectDsTitleById(id);
        mmap.put("dsTitle", dsTitle);
        return prefix + "/edit";
    }

    /**
     * 修改保存党史标题管理
     */
    @RequiresPermissions("front:title:edit")
    @Log(title = "党史标题管理", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(DsTitle dsTitle)
    {
        return toAjax(dsTitleService.updateDsTitle(dsTitle));
    }

    /**
     * 删除
     */
    @RequiresPermissions("front:title:remove")
    @Log(title = "党史标题管理", businessType = BusinessType.DELETE)
    @GetMapping("/remove/{id}")
    @ResponseBody
    public AjaxResult remove(@PathVariable("id") Long id)
    {
        return toAjax(dsTitleService.deleteDsTitleById(id));
    }

    /**
     * 选择党史标题管理树
     */
    @GetMapping(value = { "/selectTitleTree/{id}", "/selectTitleTree/" })
    public String selectTitleTree(@PathVariable(value = "id", required = false) Long id, ModelMap mmap)
    {
        if (StringUtils.isNotNull(id))
        {
            mmap.put("dsTitle", dsTitleService.selectDsTitleById(id));
        }
        return prefix + "/tree";
    }

    /**
     * 加载党史标题管理树列表
     */
    @GetMapping("/treeData")
    @ResponseBody
    public List<Ztree> treeData()
    {
        List<Ztree> ztrees = dsTitleService.selectDsTitleTree();
        return ztrees;
    }


    @Autowired
    private IDeptService deptService;

    /**
     * 加载部门列表树
     */
    @RequiresPermissions("system:user:list")
    @GetMapping("/titleTreeData")
    @ResponseBody
    public List<Ztree> titleTreeData()
    {
        List<Ztree> ztrees = dsTitleService.selectDeptTree();
//        List<Ztree> ztrees = deptService.selectDeptTree(new Dept());
        return ztrees;
    }




    /**
     * 获取指定时期的全文搜索词
     */
    @GetMapping( "/subheadingsOfAllPeriods")
    @ResponseBody
    public List<DsTitle> subheadingsOfAllPeriods(String id)
    {



//        this.subheadingsOfAllPeriods(0) // 新民主主义革命时期
//        this.subheadingsOfAllPeriods(1) // 社会主义革命和建设时期
//        this.subheadingsOfAllPeriods(2) // 改革开放和社会主义现代化建设新时期
//        this.subheadingsOfAllPeriods(3) // 中国特色社会主义新时代



        switch (id){
            case "0": id = "新民主主义革命时期"; break;
            case "1": id = "社会主义革命和建设时期"; break;
            case "2": id = "改革开放和社会主义现代化建设新时期"; break;
            case "3": id = "中国特色社会主义新时代"; break;
            default: throw new RuntimeException("未知时期");
        }

        List<DsTitle> dsTitlesList = dsTitleService.selectDsTitleByTitle(id);
        List<DsTitle> dsTitles1 = dsTitleService.selectDsTitleByParentId(dsTitlesList.get(0).getId());
        return dsTitles1;
    }

}
