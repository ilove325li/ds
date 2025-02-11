package com.ds.project.front.article.service;

import java.util.List;
import com.ds.project.front.article.domain.DsArticle;
import com.ds.project.system.user.domain.User;

/**
 * 文章管理Service接口
 * 
 * @author wkk
 * @date 2025-01-30
 */
public interface IDsArticleService 
{
    /**
     * 查询文章管理
     * 
     * @param id 文章管理主键
     * @return 文章管理
     */
    public DsArticle selectDsArticleById(Long id);

    /**
     * 查询文章管理列表
     * 
     * @param dsArticle 文章管理
     * @return 文章管理集合
     */
    public List<DsArticle> selectDsArticleList(DsArticle dsArticle);

    /**
     * 新增文章管理
     * 
     * @param dsArticle 文章管理
     * @return 结果
     */
    public int insertDsArticle(DsArticle dsArticle);

    /**
     * 修改文章管理
     * 
     * @param dsArticle 文章管理
     * @return 结果
     */
    public int updateDsArticle(DsArticle dsArticle);

    /**
     * 批量删除文章管理
     * 
     * @param ids 需要删除的文章管理主键集合
     * @return 结果
     */
    public int deleteDsArticleByIds(String ids);

    /**
     * 删除文章管理信息
     * 
     * @param id 文章管理主键
     * @return 结果
     */
    public int deleteDsArticleById(Long id);

    String importUser(List<DsArticle> userList, boolean updateSupport);
}
