package com.ds.project.front.film.controller;

import java.util.ArrayList;
import java.util.List;

import com.ds.project.front.article.domain.DsArticle;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import com.ds.framework.aspectj.lang.annotation.Log;
import com.ds.framework.aspectj.lang.enums.BusinessType;
import com.ds.project.front.film.domain.DsFilm;
import com.ds.project.front.film.service.IDsFilmService;
import com.ds.framework.web.controller.BaseController;
import com.ds.framework.web.domain.AjaxResult;
import com.ds.common.utils.poi.ExcelUtil;
import com.ds.framework.web.page.TableDataInfo;
import org.springframework.web.multipart.MultipartFile;

/**
 * 影视管理Controller
 * 
 * @author wkk
 * @date 2025-02-01
 */
@Controller
@RequestMapping("/front/film")
public class DsFilmController extends BaseController
{
    private String prefix = "front/film";

    @Autowired
    private IDsFilmService dsFilmService;

    @RequiresPermissions("front:film:view")
    @GetMapping()
    public String film()
    {
        return prefix + "/film";
    }

    /**
     * 查询影视管理列表
     */
    @RequiresPermissions("front:film:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(DsFilm dsFilm)
    {
        startPage();
        List<DsFilm> list = dsFilmService.selectDsFilmList(dsFilm);
        return getDataTable(list);
    }

    /**
     * 导出影视管理列表
     */
    @RequiresPermissions("front:film:export")
    @Log(title = "影视管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(DsFilm dsFilm)
    {
        List<DsFilm> list = dsFilmService.selectDsFilmList(dsFilm);
        ExcelUtil<DsFilm> util = new ExcelUtil<DsFilm>(DsFilm.class);
        return util.exportExcel(list, "影视管理数据");
    }

    /**
     * 新增影视管理
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存影视管理
     */
    @RequiresPermissions("front:film:add")
    @Log(title = "影视管理", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(DsFilm dsFilm)
    {
        return toAjax(dsFilmService.insertDsFilm(dsFilm));
    }

    /**
     * 修改影视管理
     */
    @RequiresPermissions("front:film:edit")
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        DsFilm dsFilm = dsFilmService.selectDsFilmById(id);
        mmap.put("dsFilm", dsFilm);
        return prefix + "/edit";
    }

    /**
     * 修改保存影视管理
     */
    @RequiresPermissions("front:film:edit")
    @Log(title = "影视管理", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(DsFilm dsFilm)
    {
        return toAjax(dsFilmService.updateDsFilm(dsFilm));
    }

    /**
     * 删除影视管理
     */
    @RequiresPermissions("front:film:remove")
    @Log(title = "影视管理", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(dsFilmService.deleteDsFilmByIds(ids));
    }


    /**
     * 获取推荐影视
     * @return
     */
    @GetMapping( "/getRecommendFilm")
    @ResponseBody
    public List<DsFilm> getRecommendFilm(@RequestParam("id") String id){
        DsFilm dsFilm = new DsFilm();
        dsFilm.setChronologicalDivision(id);
        dsFilm.setRecommend(1L);
        ArrayList<DsFilm> moreDsFilms = new ArrayList<>();
        List<DsFilm> dsFilms = dsFilmService.selectDsFilmList(dsFilm);
        //让前端无限连续轮播
        for (int i = 0; i < 999; i++) {
            moreDsFilms.addAll(dsFilms);
            if(moreDsFilms.size()>9999){
                break;
            }
        }
        return moreDsFilms;
    }



    @PostMapping("/selectFilm")
    @ResponseBody
    public  List<DsFilm>  selectFilm(DsFilmFrom dsFilm)
    {


        System.out.println(dsFilm.toString());


        DsFilm dsFilm1 = new DsFilm();
        List<String> shiq = new ArrayList<>();
        dsFilm1.setTvSeries(dsFilm.getKeyword()); // 名称影视
        shiq.addAll(dsFilm.getPeriods());

        if("电影".equals(dsFilm.getFilmType())){
            //电影
            dsFilm1.setKind("0");

        }else {
            dsFilm1.setKind("1");
        }


        List<DsFilm> list = dsFilmService.selectDsFilmListOfNew(dsFilm1,shiq);
        return list;
    }





    @GetMapping("/importTemplate")
    @ResponseBody
    public AjaxResult importTemplate()
    {
        ExcelUtil<DsFilm> util = new ExcelUtil<DsFilm>(DsFilm.class);
        return util.importTemplateExcel("影视数据");
    }





    @PostMapping("/importData")
    @ResponseBody
    public AjaxResult importData(MultipartFile file, boolean updateSupport) throws Exception
    {
        ExcelUtil<DsFilm> util = new ExcelUtil<DsFilm>(DsFilm.class);
        List<DsFilm> userList = util.importExcel(file.getInputStream());
        String message = dsFilmService.importUser(userList, updateSupport);
        return AjaxResult.success(message);
    }














    class DsFilmFrom{
        private String filmType;


        private String keyword;
        private List<String > periods;


        public String getFilmType() {
            return filmType;
        }

        public void setFilmType(String filmType) {
            this.filmType = filmType;
        }

        public String getKeyword() {
            return keyword;
        }

        public void setKeyword(String keyword) {
            this.keyword = keyword;
        }

        public List<String> getPeriods() {
            return periods;
        }

        public void setPeriods(List<String> periods) {
            this.periods = periods;
        }
    }



}
