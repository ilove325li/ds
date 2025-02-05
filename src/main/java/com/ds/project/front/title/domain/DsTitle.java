package com.ds.project.front.title.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ds.framework.aspectj.lang.annotation.Excel;
import com.ds.framework.web.domain.TreeEntity;

/**
 * 党史标题管理对象 ds_title
 * 
 * @author wkk
 * @date 2025-02-02
 */
public class DsTitle extends TreeEntity
{
    private static final long serialVersionUID = 1L;

    /**  */
    private Long id;

    /** 小标题、时期 */
    @Excel(name = "小标题、时期")
    private String title;


    /** 小标题、时期 */
    @Excel(name = "小标题、时期")
    private String ancestors;

    public String getBriefIntroduction() {
        return briefIntroduction;
    }

    public void setBriefIntroduction(String briefIntroduction) {
        this.briefIntroduction = briefIntroduction;
    }

    @Excel(name = "简介")
    private String briefIntroduction;


    @Override
    public String getAncestors() {
        return ancestors;
    }

    @Override
    public void setAncestors(String ancestors) {
        this.ancestors = ancestors;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }
    public void setTitle(String title)
    {
        this.title = title;
    }

    public String getTitle()
    {
        return title;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("title", getTitle())
            .append("parentId", getParentId())
            .append("ancestors", getAncestors())
            .toString();
    }
}
