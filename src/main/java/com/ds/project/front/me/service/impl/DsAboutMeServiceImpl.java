package com.ds.project.front.me.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ds.project.front.me.mapper.DsAboutMeMapper;
import com.ds.project.front.me.domain.DsAboutMe;
import com.ds.project.front.me.service.IDsAboutMeService;
import com.ds.common.utils.text.Convert;

/**
 * 关于我们Service业务层处理
 * 
 * @author wkk
 * @date 2025-02-12
 */
@Service
public class DsAboutMeServiceImpl implements IDsAboutMeService 
{
    @Autowired
    private DsAboutMeMapper dsAboutMeMapper;

    /**
     * 查询关于我们
     * 
     * @param id 关于我们主键
     * @return 关于我们
     */
    @Override
    public DsAboutMe selectDsAboutMeById(Long id)
    {
        return dsAboutMeMapper.selectDsAboutMeById(id);
    }

    /**
     * 查询关于我们列表
     * 
     * @param dsAboutMe 关于我们
     * @return 关于我们
     */
    @Override
    public List<DsAboutMe> selectDsAboutMeList(DsAboutMe dsAboutMe)
    {
        return dsAboutMeMapper.selectDsAboutMeList(dsAboutMe);
    }

    /**
     * 新增关于我们
     * 
     * @param dsAboutMe 关于我们
     * @return 结果
     */
    @Override
    public int insertDsAboutMe(DsAboutMe dsAboutMe)
    {
        return dsAboutMeMapper.insertDsAboutMe(dsAboutMe);
    }

    /**
     * 修改关于我们
     * 
     * @param dsAboutMe 关于我们
     * @return 结果
     */
    @Override
    public int updateDsAboutMe(DsAboutMe dsAboutMe)
    {
        return dsAboutMeMapper.updateDsAboutMe(dsAboutMe);
    }

    /**
     * 批量删除关于我们
     * 
     * @param ids 需要删除的关于我们主键
     * @return 结果
     */
    @Override
    public int deleteDsAboutMeByIds(String ids)
    {
        return dsAboutMeMapper.deleteDsAboutMeByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除关于我们信息
     * 
     * @param id 关于我们主键
     * @return 结果
     */
    @Override
    public int deleteDsAboutMeById(Long id)
    {
        return dsAboutMeMapper.deleteDsAboutMeById(id);
    }
}
