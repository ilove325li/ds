package com.ds.project.front.article.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ds.framework.aspectj.lang.annotation.Excel;
import com.ds.framework.web.domain.BaseEntity;

/**
 * 文章管理对象 ds_article
 * 
 * @author wkk
 * @date 2025-01-30
 */
public class DsArticle extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /**  */
    private Long id;

    /** 来源库 */
    @Excel(name = "SrcDatabase-来源库")
    private String srcDatabase;

    /** 题名 */
    @Excel(name = "Title-题名")
    private String title;

    /** 作者 */
    @Excel(name = "Author-作者")
    private String author;

    /** 单位 */
    @Excel(name = "Organ-单位")
    private String organ;

    /** 文献来源 */
    @Excel(name = "Source-文献来源")
    private String source;

    /** 关键词 */
    @Excel(name = "Keyword-关键词")
    private String keyword;

    /** 摘要 */
    @Excel(name = "Summary-摘要")
    private String summary;

    /** 发表时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "PubTime-发表时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date pubTime;
    /** 全文词 */
    @Excel(name = "全文词")
    private String fullTextWords;
    /** 全文 */
    @Excel(name = "URL-网址")
    private String articleText;

    public String getFullTextWords() {
        return fullTextWords;
    }

    public void setFullTextWords(String fullTextWords) {
        this.fullTextWords = fullTextWords;
    }



    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }
    public void setSrcDatabase(String srcDatabase)
    {
        this.srcDatabase = srcDatabase;
    }

    public String getSrcDatabase()
    {
        return srcDatabase;
    }
    public void setTitle(String title)
    {
        this.title = title;
    }

    public String getTitle()
    {
        return title;
    }
    public void setAuthor(String author)
    {
        this.author = author;
    }

    public String getAuthor()
    {
        return author;
    }
    public void setOrgan(String organ)
    {
        this.organ = organ;
    }

    public String getOrgan()
    {
        return organ;
    }
    public void setSource(String source)
    {
        this.source = source;
    }

    public String getSource()
    {
        return source;
    }
    public void setKeyword(String keyword)
    {
        this.keyword = keyword;
    }

    public String getKeyword()
    {
        return keyword;
    }
    public void setSummary(String summary)
    {
        this.summary = summary;
    }

    public String getSummary()
    {
        return summary;
    }
    public void setPubTime(Date pubTime)
    {
        this.pubTime = pubTime;
    }

    public Date getPubTime()
    {
        return pubTime;
    }
    public void setArticleText(String articleText)
    {
        this.articleText = articleText;
    }

    public String getArticleText()
    {
        return articleText;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("srcDatabase", getSrcDatabase())
            .append("title", getTitle())
            .append("author", getAuthor())
            .append("organ", getOrgan())
            .append("source", getSource())
            .append("keyword", getKeyword())
            .append("summary", getSummary())
            .append("pubTime", getPubTime())
            .append("articleText", getArticleText())
            .toString();
    }
}
