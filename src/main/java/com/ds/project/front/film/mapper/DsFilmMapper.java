package com.ds.project.front.film.mapper;

import java.util.List;
import com.ds.project.front.film.domain.DsFilm;
import org.apache.ibatis.annotations.Param;

/**
 * 影视管理Mapper接口
 * 
 * @author wkk
 * @date 2025-02-01
 */
public interface DsFilmMapper 
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
     * 删除影视管理
     * 
     * @param id 影视管理主键
     * @return 结果
     */
    public int deleteDsFilmById(Long id);

    /**
     * 批量删除影视管理
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteDsFilmByIds(String[] ids);

    List<DsFilm> selectDsFilmListOfNew(@Param("dsFilm") DsFilm dsFilm,@Param("kinds") List<String> kinds,@Param("shiq") List<String> shiqi);
}
