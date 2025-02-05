package com.ds.project.front.terms.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ds.project.front.terms.mapper.DsSearchArticleTermsMapper;
import com.ds.project.front.terms.domain.DsSearchArticleTerms;
import com.ds.project.front.terms.service.IDsSearchArticleTermsService;
import com.ds.common.utils.text.Convert;

/**
 * 文章搜索词管理Service业务层处理
 * 
 * @author wkk
 * @date 2025-02-02
 */
@Service
public class DsSearchArticleTermsServiceImpl implements IDsSearchArticleTermsService 
{
    @Autowired
    private DsSearchArticleTermsMapper dsSearchArticleTermsMapper;

    /**
     * 查询文章搜索词管理
     * 
     * @param id 文章搜索词管理主键
     * @return 文章搜索词管理
     */
    @Override
    public DsSearchArticleTerms selectDsSearchArticleTermsById(Long id)
    {
        return dsSearchArticleTermsMapper.selectDsSearchArticleTermsById(id);
    }

    /**
     * 查询文章搜索词管理列表
     * 
     * @param dsSearchArticleTerms 文章搜索词管理
     * @return 文章搜索词管理
     */
    @Override
    public List<DsSearchArticleTerms> selectDsSearchArticleTermsList(DsSearchArticleTerms dsSearchArticleTerms,List<Integer> titleList)
    {
        return dsSearchArticleTermsMapper.selectDsSearchArticleTermsList(dsSearchArticleTerms,titleList);
    }

    /**
     * 新增文章搜索词管理
     * 
     * @param dsSearchArticleTerms 文章搜索词管理
     * @return 结果
     */
    @Override
    public int insertDsSearchArticleTerms(DsSearchArticleTerms dsSearchArticleTerms)
    {
        return dsSearchArticleTermsMapper.insertDsSearchArticleTerms(dsSearchArticleTerms);
    }

    /**
     * 修改文章搜索词管理
     * 
     * @param dsSearchArticleTerms 文章搜索词管理
     * @return 结果
     */
    @Override
    public int updateDsSearchArticleTerms(DsSearchArticleTerms dsSearchArticleTerms)
    {
        return dsSearchArticleTermsMapper.updateDsSearchArticleTerms(dsSearchArticleTerms);
    }

    /**
     * 批量删除文章搜索词管理
     * 
     * @param ids 需要删除的文章搜索词管理主键
     * @return 结果
     */
    @Override
    public int deleteDsSearchArticleTermsByIds(String ids)
    {
        return dsSearchArticleTermsMapper.deleteDsSearchArticleTermsByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除文章搜索词管理信息
     * 
     * @param id 文章搜索词管理主键
     * @return 结果
     */
    @Override
    public int deleteDsSearchArticleTermsById(Long id)
    {
        return dsSearchArticleTermsMapper.deleteDsSearchArticleTermsById(id);
    }

    @Override
    public List<DsSearchArticleTerms> subheadingsOfAllPeriods(String id) {

        return dsSearchArticleTermsMapper.subheadingsOfAllPeriods( id);
    }

    @Override
    public List<DsSearchArticleTerms> selectDsSearchArticleTermsByTitleId(String id) {
        return dsSearchArticleTermsMapper.selectDsSearchArticleTermsByTitleId(id);
    }
}
