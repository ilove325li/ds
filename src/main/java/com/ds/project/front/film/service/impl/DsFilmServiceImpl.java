package com.ds.project.front.film.service.impl;

import java.util.List;

import com.ds.common.exception.ServiceException;
import com.ds.common.utils.StringUtils;
import com.ds.framework.web.service.DictService;
import com.ds.project.front.article.domain.DsArticle;
import com.ds.project.system.dict.service.IDictDataService;
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
    @Autowired
    private DictService dictService;
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
    public List<DsFilm> selectDsFilmListOfNew(DsFilm dsFilm,List<String> kinds, List<String> shiqi) {
//        List<DsFilm> dsFilms = dsFilmMapper.selectDsFilmListOfNew(dsFilm, shiqi);
        return dsFilmMapper.selectDsFilmListOfNew(dsFilm, kinds,  shiqi);
    }

    @Override
    public String importUser(List<DsFilm> userList, boolean updateSupport) {
        if (StringUtils.isNull(userList) || userList.size() == 0)
        {
            throw new ServiceException("导入用户数据不能为空！");
        }


int rowNum = 0;
        for (DsFilm dsFilm : userList){

            if(!org.springframework.util.StringUtils.hasText(dsFilm.getChronologicalDivision())){
                System.out.println(dsFilm.getTvSeries());
                throw new RuntimeException(rowNum+",年代划分是必填的，剧名《"+dsFilm.getTvSeries()+"》");
            }

            dsFilm.setImg(null);
            dsFilmMapper.insertDsFilm(dsFilm);
            rowNum++;
        }

        return "导入完毕！";
    }
}
