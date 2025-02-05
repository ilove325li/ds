package com.ds.project.front.title.mapper;

import java.util.List;
import com.ds.project.front.title.domain.DsTitle;

/**
 * 党史标题管理Mapper接口
 * 
 * @author wkk
 * @date 2025-02-02
 */
public interface DsTitleMapper 
{
    /**
     * 查询党史标题管理
     * 
     * @param id 党史标题管理主键
     * @return 党史标题管理
     */
    public DsTitle selectDsTitleById(Long id);

    /**
     * 查询党史标题管理列表
     * 
     * @param dsTitle 党史标题管理
     * @return 党史标题管理集合
     */
    public List<DsTitle> selectDsTitleList(DsTitle dsTitle);

    /**
     * 新增党史标题管理
     * 
     * @param dsTitle 党史标题管理
     * @return 结果
     */
    public int insertDsTitle(DsTitle dsTitle);

    /**
     * 修改党史标题管理
     * 
     * @param dsTitle 党史标题管理
     * @return 结果
     */
    public int updateDsTitle(DsTitle dsTitle);

    /**
     * 删除党史标题管理
     * 
     * @param id 党史标题管理主键
     * @return 结果
     */
    public int deleteDsTitleById(Long id);

    /**
     * 批量删除党史标题管理
     *
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteDsTitleByIds(String[] ids);

    /**
     * 根据父亲id获取子id
     * @param aLong
     * @return
     */
    List<DsTitle> selectDsTitleByParentId(Long aLong);

    List<DsTitle> selectDsTitleByTitle(String title);
}
