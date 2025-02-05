package com.ds.project.front.terms.domain;

import io.swagger.models.auth.In;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ds.framework.aspectj.lang.annotation.Excel;
import com.ds.framework.web.domain.BaseEntity;

/**
 * 文章搜索词管理对象 ds_search_article_terms
 * 
 * @author wkk
 * @date 2025-02-02
 */
public class DsSearchArticleTerms extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /**  */
    private Long id;

    /** 搜索词 */
    @Excel(name = "搜索词")
    private String searchTerms;

    /** 小标题 */
    @Excel(name = "小标题")
    private String subheading;

    /** 大标题（四个时期） */
    @Excel(name = "大标题", readConverterExp = "四=个时期")
    private String bigHeadline;

    /** 简介 */
    @Excel(name = "简介")
    private String briefIntroduction;

    public Integer getTitleId() {
        return titleId;
    }

    public void setTitleId(Integer titleId) {
        this.titleId = titleId;
    }

    private Integer titleId;

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }
    public void setSearchTerms(String searchTerms)
    {
        this.searchTerms = searchTerms;
    }

    public String getSearchTerms()
    {
        return searchTerms;
    }
    public void setSubheading(String subheading)
    {
        this.subheading = subheading;
    }

    public String getSubheading()
    {
        return subheading;
    }
    public void setBigHeadline(String bigHeadline)
    {
        this.bigHeadline = bigHeadline;
    }

    public String getBigHeadline()
    {
        return bigHeadline;
    }
    public void setBriefIntroduction(String briefIntroduction)
    {
        this.briefIntroduction = briefIntroduction;
    }

    public String getBriefIntroduction()
    {
        return briefIntroduction;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("searchTerms", getSearchTerms())
            .append("subheading", getSubheading())
            .append("bigHeadline", getBigHeadline())
            .append("briefIntroduction", getBriefIntroduction())
            .toString();
    }
}
