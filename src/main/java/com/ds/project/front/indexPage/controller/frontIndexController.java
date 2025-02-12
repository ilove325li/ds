package com.ds.project.front.indexPage.controller;


import com.ds.project.front.article.domain.DsArticle;
import com.ds.project.front.article.mapper.DsArticleMapper;
import com.ds.project.front.film.domain.DsFilm;
import com.ds.project.front.film.mapper.DsFilmMapper;
import com.ds.project.front.me.domain.DsAboutMe;
import com.ds.project.front.me.mapper.DsAboutMeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Administrator
 */
@Controller
public class frontIndexController {

    @Autowired
    private DsFilmMapper dsFilmMapper;

    @Autowired
    private DsArticleMapper dsArticleMapper;

    @Autowired
    private DsAboutMeMapper dsAboutMeMapper;

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
        ArrayList<String> urls = new ArrayList<>();
        if (StringUtils.hasText(dsFilm.getUrl())) {
            if(dsFilm.getUrl().contains(";")){
                String[] split = dsFilm.getUrl().split(";");
                List<String> list = Arrays.asList(split);
                urls.addAll(list);

            }else {
                urls.add(dsFilm.getUrl());
            }

        }

        model.addAttribute("dsFilm", dsFilm);
        model.addAttribute("urls", urls);
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




    /**
     *

     * @return
     */
    @GetMapping("/front/goToAboutMe")
    private String goToAboutMe(Model model){
        List<DsAboutMe> dsAboutMes = dsAboutMeMapper.selectDsAboutMeList(null);

        model.addAttribute("dsAboutMe",dsAboutMes.get(0));
        return "front/me/aboutMe";
    }
}
