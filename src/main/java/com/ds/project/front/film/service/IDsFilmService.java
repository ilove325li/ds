package com.ds.project.front.film.service;

import java.util.List;

import com.ds.project.front.film.controller.DsFilmController;
import com.ds.project.front.film.domain.DsFilm;

/**
 * 影视管理Service接口
 * 
 * @author wkk
 * @date 2025-02-01
 */
public interface IDsFilmService 
{
    /**
     * 查询影视管理
     * 
     * @param id 影视管理主键
     * @return 影视管理
     */
    public DsFilm selectDsFilmById(Long id);

    /**
     * 查询影视管理列表
     * 
     * @param dsFilm 影视管理
     * @return 影视管理集合
     */
    public List<DsFilm> selectDsFilmList(DsFilm dsFilm);

    /**
     * 新增影视管理
     * 
     * @param dsFilm 影视管理
     * @return 结果
     */
    public int insertDsFilm(DsFilm dsFilm);

    /**
     * 修改影视管理
     * 
     * @param dsFilm 影视管理
     * @return 结果
     */
    public int updateDsFilm(DsFilm dsFilm);

    /**
     * 批量删除影视管理
     * 
     * @param ids 需要删除的影视管理主键集合
     * @return 结果
     */
    public int deleteDsFilmByIds(String ids);

    /**
     * 删除影视管理信息
     * 
     * @param id 影视管理主键
     * @return 结果
     */
    public int deleteDsFilmById(Long id);

    List<DsFilm> selectDsFilmListOfNew(DsFilm dsFilm,List<String> shiqi);

    String importUser(List<DsFilm> userList, boolean updateSupport);
}
