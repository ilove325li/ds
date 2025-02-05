package com.ds.project.front.terms.controller;

import java.util.ArrayList;
import java.util.List;

import com.ds.project.front.title.domain.DsTitle;
import com.ds.project.front.title.service.IDsTitleService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ds.framework.aspectj.lang.annotation.Log;
import com.ds.framework.aspectj.lang.enums.BusinessType;
import com.ds.project.front.terms.domain.DsSearchArticleTerms;
import com.ds.project.front.terms.service.IDsSearchArticleTermsService;
import com.ds.framework.web.controller.BaseController;
import com.ds.framework.web.domain.AjaxResult;
import com.ds.common.utils.poi.ExcelUtil;
import com.ds.framework.web.page.TableDataInfo;

/**
 * 文章搜索词管理Controller
 * 
 * @author wkk
 * @date 2025-02-02
 */
@Controller
@RequestMapping("/front/terms")
public class DsSearchArticleTermsController extends BaseController
{
    private String prefix = "front/terms";
    @Autowired
    private IDsTitleService dsTitleService;
    @Autowired
    private IDsSearchArticleTermsService dsSearchArticleTermsService;

    @RequiresPermissions("front:terms:view")
    @GetMapping()
    public String terms()
    {
        return prefix + "/terms";
    }

    /**
     * 查询文章搜索词管理列表
     */
    @RequiresPermissions("front:terms:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(DsSearchArticleTerms dsSearchArticleTerms)
    {


        List<Integer> titleList;

        // ============================获取层级=========================

        Integer titleId = dsSearchArticleTerms.getTitleId();

        if(dsSearchArticleTerms.getTitleId()==null || dsSearchArticleTerms.getTitleId()==100){
            titleList = null;
        }else {
            titleList = new ArrayList<>();


            DsTitle dsTitle = dsTitleService.selectDsTitleById(Long.valueOf(dsSearchArticleTerms.getTitleId()));

        // 标题父id
        Integer titleParentId = Integer.valueOf(dsTitle.getParentId().intValue()) ;




            if(titleParentId==100){
                // 二级
//                titleList.add(titleParentId);
                List<DsTitle> dsTitleList = dsTitleService.selectDsTitleByParentId(Long.valueOf(dsSearchArticleTerms.getTitleId()));

                List<Integer> list = dsTitleList.stream().map(s ->  s.getId().intValue()).toList();
                titleList.addAll(list);
            } else {
                // 三级
                titleList.add(dsSearchArticleTerms.getTitleId());

            }



}
// =====================================================








        startPage();
        List<DsSearchArticleTerms> list = dsSearchArticleTermsService.selectDsSearchArticleTermsList(dsSearchArticleTerms,titleList);
        return getDataTable(list);
    }

    /**
     * 导出文章搜索词管理列表
     */
    @RequiresPermissions("front:terms:export")
    @Log(title = "文章搜索词管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(DsSearchArticleTerms dsSearchArticleTerms)
    {
        List<DsSearchArticleTerms> list = dsSearchArticleTermsService.selectDsSearchArticleTermsList(dsSearchArticleTerms,null);
        ExcelUtil<DsSearchArticleTerms> util = new ExcelUtil<DsSearchArticleTerms>(DsSearchArticleTerms.class);
        return util.exportExcel(list, "文章搜索词管理数据");
    }

    /**
     * 新增文章搜索词管理
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存文章搜索词管理
     */
    @RequiresPermissions("front:terms:add")
    @Log(title = "文章搜索词管理", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(DsSearchArticleTerms dsSearchArticleTerms)
    {



        // ============================判断他输入的小标题是否正确=========================
        // 大标题
        String bigTitle = "";
        // 小标题
        String smallTitle = "";
        if(dsSearchArticleTerms.getTitleId()==100){
            throw new RuntimeException("只能在层级3中添加小标题");
        }

        DsTitle dsTitle = dsTitleService.selectDsTitleById(Long.valueOf(dsSearchArticleTerms.getTitleId()));
        smallTitle = dsTitle.getTitle();

        // 标题id
        Integer titleId = Integer.valueOf(dsTitle.getParentId().intValue()) ;

        // 层级
        int num = 0;

        for(;;){
            if(titleId!=100){
                DsTitle dsTitle1 = dsTitleService.selectDsTitleById(Long.valueOf(titleId));
                titleId = dsTitle1.getParentId().intValue();
                num++;

                if(!StringUtils.hasText(bigTitle)){
                    bigTitle = dsTitle1.getTitle();
                }
            } else {
                break;
            }
        }

        if(num!=1){
            throw new RuntimeException("只能在层级3中添加小标题");
        }

        dsSearchArticleTerms.setBigHeadline(bigTitle);
        dsSearchArticleTerms.setSubheading(smallTitle);
// ============================判断他输入的小标题是否正确=========================










        return toAjax(dsSearchArticleTermsService.insertDsSearchArticleTerms(dsSearchArticleTerms));
    }

    /**
     * 修改文章搜索词管理
     */
    @RequiresPermissions("front:terms:edit")
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        DsSearchArticleTerms dsSearchArticleTerms = dsSearchArticleTermsService.selectDsSearchArticleTermsById(id);
        mmap.put("dsSearchArticleTerms", dsSearchArticleTerms);
        return prefix + "/edit";
    }

    /**
     * 修改保存文章搜索词管理
     */
    @RequiresPermissions("front:terms:edit")
    @Log(title = "文章搜索词管理", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(DsSearchArticleTerms dsSearchArticleTerms)
    {











        // ============================判断他输入的小标题是否正确=========================
        // 大标题
        String bigTitle = "";
        // 小标题
        String smallTitle = "";
        if(dsSearchArticleTerms.getTitleId()==100){
            throw new RuntimeException("只能在层级3中添加小标题");
        }

        DsTitle dsTitle = dsTitleService.selectDsTitleById(Long.valueOf(dsSearchArticleTerms.getTitleId()));
        smallTitle = dsTitle.getTitle();

        // 标题id
        Integer titleId = Integer.valueOf(dsTitle.getParentId().intValue()) ;

        // 层级
        int num = 0;

        for(;;){
            if(titleId!=100){
                DsTitle dsTitle1 = dsTitleService.selectDsTitleById(Long.valueOf(titleId));
                titleId = dsTitle1.getParentId().intValue();
                num++;

                if(!StringUtils.hasText(bigTitle)){
                    bigTitle = dsTitle1.getTitle();
                }
            } else {
                break;
            }
        }

        if(num!=1){
            throw new RuntimeException("只能在层级3中添加小标题");
        }

        dsSearchArticleTerms.setBigHeadline(bigTitle);
        dsSearchArticleTerms.setSubheading(smallTitle);
// ============================判断他输入的小标题是否正确=========================







        return toAjax(dsSearchArticleTermsService.updateDsSearchArticleTerms(dsSearchArticleTerms));
    }

    /**
     * 删除文章搜索词管理
     */
    @RequiresPermissions("front:terms:remove")
    @Log(title = "文章搜索词管理", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(dsSearchArticleTermsService.deleteDsSearchArticleTermsByIds(ids));
    }


    /**
     * 选择部门树
     *
     * @param titleId D
     */
    @RequiresPermissions("system:user:list")
    @GetMapping("/selectTitleTreenew/{titleId}")
    public String selectTitleTreenew(@PathVariable("titleId") Long titleId, ModelMap mmap)
    {
        mmap.put("title", dsTitleService.selectDeptById(titleId));
        return prefix + "/titleTree";
    }



//    /**
//     * 获取指定时期的全文搜索词
//     */
//    @GetMapping( "/subheadingsOfAllPeriods")
//    @ResponseBody
//    public List<DsSearchArticleTerms> subheadingsOfAllPeriods(String id)
//    {
//
//
//
////        this.subheadingsOfAllPeriods(0) // 新民主主义革命时期
////        this.subheadingsOfAllPeriods(1) // 社会主义革命和建设时期
////        this.subheadingsOfAllPeriods(2) // 改革开放和社会主义现代化建设新时期
////        this.subheadingsOfAllPeriods(3) // 中国特色社会主义新时代
//
//
//
//        switch (id){
//            case "0": id = "新民主主义革命时期"; break;
//            case "1": id = "社会主义革命和建设时期"; break;
//            case "2": id = "改革开放和社会主义现代化建设新时期"; break;
//            case "3": id = "中国特色社会主义新时代"; break;
//            default: throw new RuntimeException("未知时期");
//        }
//
//
//
//
//        List<DsSearchArticleTerms> dsSearchArticleTerms = dsSearchArticleTermsService.subheadingsOfAllPeriods(id);
//        dsSearchArticleTerms.addAll(dsSearchArticleTerms);
//        return dsSearchArticleTerms;
//    }





    /**
     * 获取指定时期的全文搜索词
     */
    @GetMapping( "/getSearchTermsByTitleId")
    @ResponseBody
    public List<DsSearchArticleTerms> getSearchTermsByTitleId(String id)
    {

        List<DsSearchArticleTerms> list = dsSearchArticleTermsService.selectDsSearchArticleTermsByTitleId(id);

        list.addAll(list);
        list.addAll(list);
        list.addAll(list);

        return list;
    }




}
