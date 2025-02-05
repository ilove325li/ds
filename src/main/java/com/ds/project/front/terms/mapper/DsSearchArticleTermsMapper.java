package com.ds.project.front.terms.mapper;

import java.util.List;
import com.ds.project.front.terms.domain.DsSearchArticleTerms;
import org.apache.ibatis.annotations.Param;

/**
 * 文章搜索词管理Mapper接口
 * 
 * @author wkk
 * @date 2025-02-02
 */
public interface DsSearchArticleTermsMapper 
{
    /**
     * 查询文章搜索词管理
     * 
     * @param id 文章搜索词管理主键
     * @return 文章搜索词管理
     */
    public DsSearchArticleTerms selectDsSearchArticleTermsById(Long id);

    /**
     * 查询文章搜索词管理列表
     * 
     * @param dsSearchArticleTerms 文章搜索词管理
     * @return 文章搜索词管理集合
     */
    public List<DsSearchArticleTerms> selectDsSearchArticleTermsList(@Param("terms")DsSearchArticleTerms dsSearchArticleTerms, @Param("titleList")List<Integer> titleList);

    /**
     * 新增文章搜索词管理
     * 
     * @param dsSearchArticleTerms 文章搜索词管理
     * @return 结果
     */
    public int insertDsSearchArticleTerms(DsSearchArticleTerms dsSearchArticleTerms);

    /**
     * 修改文章搜索词管理
     * 
     * @param dsSearchArticleTerms 文章搜索词管理
     * @return 结果
     */
    public int updateDsSearchArticleTerms(DsSearchArticleTerms dsSearchArticleTerms);

    /**
     * 删除文章搜索词管理
     * 
     * @param id 文章搜索词管理主键
     * @return 结果
     */
    public int deleteDsSearchArticleTermsById(Long id);

    /**
     * 批量删除文章搜索词管理
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteDsSearchArticleTermsByIds(String[] ids);

    List<DsSearchArticleTerms> subheadingsOfAllPeriods(String id);

    List<DsSearchArticleTerms> selectDsSearchArticleTermsByTitleId(String id);
}
