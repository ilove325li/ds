package com.ds.project.front.me.service;

import java.util.List;
import com.ds.project.front.me.domain.DsAboutMe;

/**
 * 关于我们Service接口
 * 
 * @author wkk
 * @date 2025-02-12
 */
public interface IDsAboutMeService 
{
    /**
     * 查询关于我们
     * 
     * @param id 关于我们主键
     * @return 关于我们
     */
    public DsAboutMe selectDsAboutMeById(Long id);

    /**
     * 查询关于我们列表
     * 
     * @param dsAboutMe 关于我们
     * @return 关于我们集合
     */
    public List<DsAboutMe> selectDsAboutMeList(DsAboutMe dsAboutMe);

    /**
     * 新增关于我们
     * 
     * @param dsAboutMe 关于我们
     * @return 结果
     */
    public int insertDsAboutMe(DsAboutMe dsAboutMe);

    /**
     * 修改关于我们
     * 
     * @param dsAboutMe 关于我们
     * @return 结果
     */
    public int updateDsAboutMe(DsAboutMe dsAboutMe);

    /**
     * 批量删除关于我们
     * 
     * @param ids 需要删除的关于我们主键集合
     * @return 结果
     */
    public int deleteDsAboutMeByIds(String ids);

    /**
     * 删除关于我们信息
     * 
     * @param id 关于我们主键
     * @return 结果
     */
    public int deleteDsAboutMeById(Long id);
}
