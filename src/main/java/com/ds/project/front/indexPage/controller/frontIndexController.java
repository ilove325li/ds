package com.ds.project.front.indexPage.controller;


import com.ds.project.front.article.domain.DsArticle;
import com.ds.project.front.article.mapper.DsArticleMapper;
import com.ds.project.front.film.domain.DsFilm;
import com.ds.project.front.film.mapper.DsFilmMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author Administrator
 */
@Controller
public class frontIndexController {

    @Autowired
    private DsFilmMapper dsFilmMapper;

    @Autowired
    private DsArticleMapper dsArticleMapper;

    /**
     * 用户端首页
     * @param model
     * @return
     */
    @GetMapping("/front/index")
    private String index(Model model) {
        return "front/index";
    }


    /**
     * 跳转影视详情页
     * @param model
     * @return
     */
    @GetMapping("/front/goToFilmDetail")
    private String goToFilmDetail(Model model, @RequestParam("id") Integer id) {
        DsFilm dsFilm = dsFilmMapper.selectDsFilmById(Long.valueOf(id));
        model.addAttribute("dsFilm", dsFilm);
        return "front/film/filmDetail";
    }


    /**
     * 跳转影视详情页
     * @param model
     * @return
     */
    @GetMapping("/front/goToliterature")
    private String goToliterature(Model model, @RequestParam(value = "searchTerms" ,defaultValue = "") String searchTerms, @RequestParam("key") String searchKey) {
        model.addAttribute("literature",searchTerms );
        model.addAttribute("searchKey",searchKey );
        return "front/article/literature";
    }




    /**
     * 跳转影视详情页
     * @param model
     * @return
     */
    @GetMapping("/front/goToArticleDetail")
    private String goToArticleDetail(Model model, @RequestParam(value = "id") Integer id ){

        DsArticle dsArticle = dsArticleMapper.selectDsArticleById(id.longValue());
        model.addAttribute("dsArticle",dsArticle );
        return "front/article/articleDetile";
    }












    /**
     * 跳转影视详情页

     * @return
     */
    @GetMapping("/front/goToFilmDate")
    private String goToFilm(Model model){

        return "front/film/filmDate";
    }




}
