package com.ds.project.front.film.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ds.project.front.film.mapper.DsFilmMapper;
import com.ds.project.front.film.domain.DsFilm;
import com.ds.project.front.film.service.IDsFilmService;
import com.ds.common.utils.text.Convert;

/**
 * 影视管理Service业务层处理
 * 
 * @author wkk
 * @date 2025-02-01
 */
@Service
public class DsFilmServiceImpl implements IDsFilmService 
{
    @Autowired
    private DsFilmMapper dsFilmMapper;

    /**
     * 查询影视管理
     * 
     * @param id 影视管理主键
     * @return 影视管理
     */
    @Override
    public DsFilm selectDsFilmById(Long id)
    {
        return dsFilmMapper.selectDsFilmById(id);
    }

    /**
     * 查询影视管理列表
     * 
     * @param dsFilm 影视管理
     * @return 影视管理
     */
    @Override
    public List<DsFilm> selectDsFilmList(DsFilm dsFilm)
    {
        return dsFilmMapper.selectDsFilmList(dsFilm);
    }

    /**
     * 新增影视管理
     * 
     * @param dsFilm 影视管理
     * @return 结果
     */
    @Override
    public int insertDsFilm(DsFilm dsFilm)
    {
        return dsFilmMapper.insertDsFilm(dsFilm);
    }

    /**
     * 修改影视管理
     * 
     * @param dsFilm 影视管理
     * @return 结果
     */
    @Override
    public int updateDsFilm(DsFilm dsFilm)
    {
        return dsFilmMapper.updateDsFilm(dsFilm);
    }

    /**
     * 批量删除影视管理
     * 
     * @param ids 需要删除的影视管理主键
     * @return 结果
     */
    @Override
    public int deleteDsFilmByIds(String ids)
    {
        return dsFilmMapper.deleteDsFilmByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除影视管理信息
     * 
     * @param id 影视管理主键
     * @return 结果
     */
    @Override
    public int deleteDsFilmById(Long id)
    {
        return dsFilmMapper.deleteDsFilmById(id);
    }

    @Override
    public List<DsFilm> selectDsFilmListOfNew(DsFilm dsFilm, List<String> shiqi) {
        List<DsFilm> dsFilms = dsFilmMapper.selectDsFilmListOfNew(dsFilm, shiqi);
        return dsFilmMapper.selectDsFilmListOfNew( dsFilm,  shiqi);
    }
}
