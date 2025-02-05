package com.ds.project.front.article.mapper;

import java.util.List;
import com.ds.project.front.article.domain.DsArticle;

/**
 * 文章管理Mapper接口
 * 
 * @author wkk
 * @date 2025-01-30
 */
public interface DsArticleMapper 
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
     * 删除文章管理
     * 
     * @param id 文章管理主键
     * @return 结果
     */
    public int deleteDsArticleById(Long id);

    /**
     * 批量删除文章管理
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteDsArticleByIds(String[] ids);
}
