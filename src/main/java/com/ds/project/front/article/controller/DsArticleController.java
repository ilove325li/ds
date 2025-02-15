package com.ds.project.front.article.controller;

import java.util.List;

import com.ds.framework.web.domain.BaseEntity;
import com.ds.project.front.article.mapper.DsArticleMapper;
import com.ds.project.system.user.domain.User;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import com.ds.framework.aspectj.lang.annotation.Log;
import com.ds.framework.aspectj.lang.enums.BusinessType;
import com.ds.project.front.article.domain.DsArticle;
import com.ds.project.front.article.service.IDsArticleService;
import com.ds.framework.web.controller.BaseController;
import com.ds.framework.web.domain.AjaxResult;
import com.ds.common.utils.poi.ExcelUtil;
import com.ds.framework.web.page.TableDataInfo;
import org.springframework.web.multipart.MultipartFile;

/**
 * 文章管理Controller
 * 
 * @author wkk
 * @date 2025-01-30
 */
@Controller
@RequestMapping("/front/article")
public class DsArticleController extends BaseController
{
    private String prefix = "front/article";

    @Autowired
    private IDsArticleService dsArticleService;


    @Autowired
    private DsArticleMapper dsArticleMapper;

    @RequiresPermissions("front:article:view")
    @GetMapping()
    public String article()
    {
        return prefix + "/article";
    }

    /**
     * 查询文章管理列表
     */
    @RequiresPermissions("front:article:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(DsArticle dsArticle)
    {
        startPage();
        List<DsArticle> list = dsArticleService.selectDsArticleList(dsArticle);
        return getDataTable(list);
    }

    /**
     * 导出文章管理列表
     */
    @RequiresPermissions("front:article:export")
    @Log(title = "文章管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(DsArticle dsArticle)
    {
        List<DsArticle> list = dsArticleService.selectDsArticleList(dsArticle);
        ExcelUtil<DsArticle> util = new ExcelUtil<DsArticle>(DsArticle.class);
        return util.exportExcel(list, "文章管理数据");
    }

    /**
     * 新增文章管理
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存文章管理
     */
    @RequiresPermissions("front:article:add")
    @Log(title = "文章管理", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(DsArticle dsArticle)
    {
        return toAjax(dsArticleService.insertDsArticle(dsArticle));
    }

    /**
     * 修改文章管理
     */
    @RequiresPermissions("front:article:edit")
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        DsArticle dsArticle = dsArticleService.selectDsArticleById(id);
        mmap.put("dsArticle", dsArticle);
        return prefix + "/edit";
    }

    /**
     * 修改保存文章管理
     */
    @RequiresPermissions("front:article:edit")
    @Log(title = "文章管理", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(DsArticle dsArticle)
    {
        return toAjax(dsArticleService.updateDsArticle(dsArticle));
    }

    /**
     * 删除文章管理
     */
    @RequiresPermissions("front:article:remove")
    @Log(title = "文章管理", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(dsArticleService.deleteDsArticleByIds(ids));
    }







    @PostMapping("/selectArticle")
    @ResponseBody
    public TableDataInfo selectArticle(String searchTerms,String key )
    {

        String text =searchTerms;

        System.out.println(text);
        System.out.println(key);




//             <option style="display: inline" value="0" selected>全文</option>
//                                    <option style="display: inline" value="1">标题</option>
//                                    <option style="display: inline" value="2">关键字</option>



        DsArticle dsArticle = new DsArticle();

        if("0,0".equals(key)){
            // 全文
            // 字段：全文，关键字，提名，，摘要
            if(StringUtils.hasText(text)){
                dsArticle.setArticleText(text);
                dsArticle.setKeyword(text);
                dsArticle.setTitle(text);
                dsArticle.setSummary(text);
                dsArticle.setFullTextWords(text);
            }
        } else if ("1,1".equals(key)){
            // 标题
            if(StringUtils.hasText(text)){
                dsArticle.setTitle(text);
            }
        } else if ("2,2".equals(key)){
            // 关键字
            if(StringUtils.hasText(text)){
                dsArticle.setKeyword(text);
            }
        }

        

        startPage();
        List<DsArticle> list = dsArticleMapper.selectDsArticleListOfUserSite(dsArticle);
        return getDataTable(list);
    }











    @GetMapping("/importTemplate")
    @ResponseBody
    public AjaxResult importTemplate()
    {
        ExcelUtil<DsArticle> util = new ExcelUtil<DsArticle>(DsArticle.class);
        return util.importTemplateExcel("文章数据");
    }





    @PostMapping("/importData")
    @ResponseBody
    public AjaxResult importData(MultipartFile file, boolean updateSupport) throws Exception
    {

        // 获取上传文件的原始文件名
        String fileName = file.getOriginalFilename();
        String[] split = fileName.split(".xlsx");
        System.out.println("上传的文件名是: " + split[0]);

        ExcelUtil<DsArticle> util = new ExcelUtil<DsArticle>(DsArticle.class);
        List<DsArticle> userList = util.importExcel(file.getInputStream());

        for (DsArticle dsArticle : userList){
            dsArticle.setFullTextWords (split[0]);
        }

        String message = dsArticleService.importUser(userList, updateSupport);
        return AjaxResult.success(message);
    }

}
