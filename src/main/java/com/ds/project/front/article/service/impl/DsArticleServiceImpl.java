package com.ds.project.front.article.service.impl;

import java.util.List;

import com.ds.common.exception.ServiceException;
import com.ds.common.utils.StringUtils;
import com.ds.common.utils.bean.BeanValidators;
import com.ds.common.utils.security.ShiroUtils;
import com.ds.project.system.user.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ds.project.front.article.mapper.DsArticleMapper;
import com.ds.project.front.article.domain.DsArticle;
import com.ds.project.front.article.service.IDsArticleService;
import com.ds.common.utils.text.Convert;

/**
 * 文章管理Service业务层处理
 * 
 * @author wkk
 * @date 2025-01-30
 */
@Service
public class DsArticleServiceImpl implements IDsArticleService 
{
    @Autowired
    private DsArticleMapper dsArticleMapper;

    /**
     * 查询文章管理
     * 
     * @param id 文章管理主键
     * @return 文章管理
     */
    @Override
    public DsArticle selectDsArticleById(Long id)
    {
        return dsArticleMapper.selectDsArticleById(id);
    }

    /**
     * 查询文章管理列表
     * 
     * @param dsArticle 文章管理
     * @return 文章管理
     */
    @Override
    public List<DsArticle> selectDsArticleList(DsArticle dsArticle)
    {
        return dsArticleMapper.selectDsArticleList(dsArticle);
    }

    /**
     * 新增文章管理
     * 
     * @param dsArticle 文章管理
     * @return 结果
     */
    @Override
    public int insertDsArticle(DsArticle dsArticle)
    {
        return dsArticleMapper.insertDsArticle(dsArticle);
    }

    /**
     * 修改文章管理
     * 
     * @param dsArticle 文章管理
     * @return 结果
     */
    @Override
    public int updateDsArticle(DsArticle dsArticle)
    {
        return dsArticleMapper.updateDsArticle(dsArticle);
    }

    /**
     * 批量删除文章管理
     * 
     * @param ids 需要删除的文章管理主键
     * @return 结果
     */
    @Override
    public int deleteDsArticleByIds(String ids)
    {
        return dsArticleMapper.deleteDsArticleByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除文章管理信息
     * 
     * @param id 文章管理主键
     * @return 结果
     */
    @Override
    public int deleteDsArticleById(Long id)
    {
        return dsArticleMapper.deleteDsArticleById(id);
    }

    @Override
    public String importUser(List<DsArticle> userList, boolean updateSupport)   {
        if (StringUtils.isNull(userList) || userList.size() == 0)
        {
            throw new ServiceException("导入用户数据不能为空！");
        }

        for (DsArticle dsArticle : userList){
            dsArticleMapper.insertDsArticle(dsArticle);
        }

        return "导入完毕！";
    }
}
