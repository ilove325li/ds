package com.ds.project.front.me.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ds.framework.aspectj.lang.annotation.Excel;
import com.ds.framework.web.domain.BaseEntity;

/**
 * 关于我们对象 ds_about_me
 * 
 * @author wkk
 * @date 2025-02-12
 */
public class DsAboutMe extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /**  */
    private Long id;

    /** 内容 */
    @Excel(name = "内容")
    private String text;

    /** 联系方式 */
    @Excel(name = "联系方式")
    private String phone;

    /** 通讯地址 */
    @Excel(name = "通讯地址")
    private String address;

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }
    public void setText(String text)
    {
        this.text = text;
    }

    public String getText()
    {
        return text;
    }
    public void setPhone(String phone)
    {
        this.phone = phone;
    }

    public String getPhone()
    {
        return phone;
    }
    public void setAddress(String address)
    {
        this.address = address;
    }

    public String getAddress()
    {
        return address;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("text", getText())
            .append("phone", getPhone())
            .append("address", getAddress())
            .toString();
    }
}
