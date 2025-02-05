package com.ds.project.front.title.service;

import java.util.List;
import com.ds.project.front.title.domain.DsTitle;
import com.ds.framework.web.domain.Ztree;

/**
 * 党史标题管理Service接口
 * 
 * @author wkk
 * @date 2025-02-02
 */
public interface IDsTitleService 
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
     * 批量删除党史标题管理
     * 
     * @param ids 需要删除的党史标题管理主键集合
     * @return 结果
     */
    public int deleteDsTitleByIds(String ids);

    /**
     * 删除党史标题管理信息
     * 
     * @param id 党史标题管理主键
     * @return 结果
     */
    public int deleteDsTitleById(Long id);

    /**
     * 查询党史标题管理树列表
     * 
     * @return 所有党史标题管理信息
     */
    public List<Ztree> selectDsTitleTree();

    List<Ztree> selectDeptTree();

    DsTitle selectDeptById(Long deptId);

    List<DsTitle> selectDsTitleByParentId(Long aLong);

    List<DsTitle> selectDsTitleByTitle(String title);
}
