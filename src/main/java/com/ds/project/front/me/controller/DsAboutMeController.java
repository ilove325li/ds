package com.ds.project.front.me.controller;

import java.util.List;
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
import com.ds.project.front.me.domain.DsAboutMe;
import com.ds.project.front.me.service.IDsAboutMeService;
import com.ds.framework.web.controller.BaseController;
import com.ds.framework.web.domain.AjaxResult;
import com.ds.common.utils.poi.ExcelUtil;
import com.ds.framework.web.page.TableDataInfo;

/**
 * 关于我们Controller
 * 
 * @author wkk
 * @date 2025-02-12
 */
@Controller
@RequestMapping("/front/me")
public class DsAboutMeController extends BaseController
{
    private String prefix = "front/me";

    @Autowired
    private IDsAboutMeService dsAboutMeService;

    @RequiresPermissions("front:me:view")
    @GetMapping()
    public String me()
    {
        return prefix + "/me";
    }

    /**
     * 查询关于我们列表
     */
    @RequiresPermissions("front:me:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(DsAboutMe dsAboutMe)
    {
        startPage();
        List<DsAboutMe> list = dsAboutMeService.selectDsAboutMeList(dsAboutMe);
        return getDataTable(list);
    }

    /**
     * 导出关于我们列表
     */
    @RequiresPermissions("front:me:export")
    @Log(title = "关于我们", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(DsAboutMe dsAboutMe)
    {
        List<DsAboutMe> list = dsAboutMeService.selectDsAboutMeList(dsAboutMe);
        ExcelUtil<DsAboutMe> util = new ExcelUtil<DsAboutMe>(DsAboutMe.class);
        return util.exportExcel(list, "关于我们数据");
    }

    /**
     * 新增关于我们
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存关于我们
     */
    @RequiresPermissions("front:me:add")
    @Log(title = "关于我们", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(DsAboutMe dsAboutMe)
    {
        return toAjax(dsAboutMeService.insertDsAboutMe(dsAboutMe));
    }

    /**
     * 修改关于我们
     */
    @RequiresPermissions("front:me:edit")
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        DsAboutMe dsAboutMe = dsAboutMeService.selectDsAboutMeById(id);
        mmap.put("dsAboutMe", dsAboutMe);
        return prefix + "/edit";
    }

    /**
     * 修改保存关于我们
     */
    @RequiresPermissions("front:me:edit")
    @Log(title = "关于我们", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(DsAboutMe dsAboutMe)
    {
        return toAjax(dsAboutMeService.updateDsAboutMe(dsAboutMe));
    }

    /**
     * 删除关于我们
     */
    @RequiresPermissions("front:me:remove")
    @Log(title = "关于我们", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(dsAboutMeService.deleteDsAboutMeByIds(ids));
    }
}
