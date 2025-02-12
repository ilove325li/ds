package com.ds.project.front.me.mapper;

import java.util.List;
import com.ds.project.front.me.domain.DsAboutMe;

/**
 * 关于我们Mapper接口
 * 
 * @author wkk
 * @date 2025-02-12
 */
public interface DsAboutMeMapper 
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
     * 删除关于我们
     * 
     * @param id 关于我们主键
     * @return 结果
     */
    public int deleteDsAboutMeById(Long id);

    /**
     * 批量删除关于我们
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteDsAboutMeByIds(String[] ids);
}
