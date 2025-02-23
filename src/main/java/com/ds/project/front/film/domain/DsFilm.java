package com.ds.project.front.film.domain;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import com.ds.project.system.dict.domain.DictData;
import com.ds.project.system.dict.utils.DictUtils;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ds.framework.aspectj.lang.annotation.Excel;
import com.ds.framework.web.domain.BaseEntity;
import org.springframework.util.StringUtils;

/**
 * 影视管理对象 ds_film
 * 
 * @author wkk
 * @date 2025-02-01
 */
public class DsFilm extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /**  */
    private Long id;

    /** 年度（以播出时间为准） */
    @Excel(name = "年度")
    private Date annual;

    /** 电视剧 */
    @Excel(name = "影视名称")
    private String tvSeries;

    /** 海报图 */
    @Excel(name = "海报图")
    private String img;

    /** 主题内容以内容准确为目标 */
    @Excel(name = "剧情简介")
    private String topicContent;

    /** 影视类型（0谍战、1悬疑、2刑侦、3历史、4古装、5武侠、6军旅、7战争、8喜剧、9青春、10言情、11偶像、12家庭、13年代、14革命、15农村、16都市、17其他、18传记、19剧情） */
    @Excel(name = "影视类型", readConverterExp = "0=谍战,1=悬疑,2=刑侦,3=历史,4=古装,5=武侠,6=军旅,7=战争,8=喜剧,9=青春,10=言情,11=偶像,12=家庭,13=年代,14=革命,15=农村,16=都市,17=其他,18=传记,19=剧情")
    private String type;

    /** 导演 */
    @Excel(name = "导演")
    private String director;

    /** 编剧 */
    @Excel(name = "编剧")
    private String screenwriter;

    /** 主要演员（酌情保留4-5人） */
    @Excel(name = "主要演员")
    private String actor;

    /** 集数（以电视首播版本为准） */
    @Excel(name = "集数")
    private Long episodeNum;

    /** 提名理由（基础：2024年4月17日版本（奖项修改）现状：2024年5月7日版本（说明：蓝色内容为核实无误内容；黄色内容为新增、修正和删除「见删除线」内容；红色为「无主流奖项获奖情况」） */
    @Excel(name = "提名理由")
    private String reasons;

    /** 年代划分 */
    @Excel(name = "年代划分",readConverterExp = "0=新民主主义革命时期,1=社会主义革命和建设时期,2=改革开放和社会主义现代化建设新时期,3=中国特色社会主义新时代,4=伟大建党精神")
    private String chronologicalDivision;

    /** 链接 */
    @Excel(name = "链接")
    private String url;

    /** 影视分类（0电影 1电视剧） */
    @Excel(name = "影视分类", readConverterExp = "0=电影,1=电视剧")
    private String kind;

    /** 是否推荐（0否，1是） */
    @Excel(name = "是否推荐", readConverterExp = "0=否,1=是")
    private Long recommend;

    public String getAwardInformation() {
        return awardInformation;
    }

    public void setAwardInformation(String awardInformation) {
        this.awardInformation = awardInformation;
    }

    /** 获奖信息 */
    @Excel(name = "获奖信息")
    private String awardInformation;

    /** 排序值 */
    @Excel(name = "排序值")
    private Long sortNum;

    public Long getSortNum() {
        return sortNum;
    }

    public void setSortNum(Long sortNum) {
        this.sortNum = sortNum;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }
    public void setAnnual(Date annual)
    {
        this.annual = annual;
    }

    public Date getAnnual()
    {
        return annual;
    }
    public void setTvSeries(String tvSeries)
    {
        this.tvSeries = tvSeries;
    }

    public String getTvSeries()
    {
        return tvSeries;
    }
    public void setImg(String img)
    {
        this.img = img;
    }

    public String getImg()
    {
        return img;
    }
    public void setTopicContent(String topicContent)
    {
        this.topicContent = topicContent;
    }

    public String getTopicContent()
    {
        return topicContent;
    }
    public void setType(String type)
    {
        this.type = type;
    }

    public String getType()
    {
        return type;
    }
    public void setDirector(String director)
    {
        this.director = director;
    }

    public String getDirector()
    {
        return director;
    }
    public void setScreenwriter(String screenwriter)
    {
        this.screenwriter = screenwriter;
    }

    public String getScreenwriter()
    {
        return screenwriter;
    }
    public void setActor(String actor)
    {
        this.actor = actor;
    }

    public String getActor()
    {
        return actor;
    }
    public void setEpisodeNum(Long episodeNum)
    {
        this.episodeNum = episodeNum;
    }

    public Long getEpisodeNum()
    {
        return episodeNum;
    }
    public void setReasons(String reasons)
    {
        this.reasons = reasons;
    }

    public String getReasons()
    {
        return reasons;
    }
    public void setChronologicalDivision(String chronologicalDivision)
    {
        this.chronologicalDivision = chronologicalDivision;
    }

    public String getChronologicalDivision()
    {
        return chronologicalDivision;
    }
    public void setUrl(String url)
    {
        this.url = url;
    }

    public String getUrl()
    {
        return url;
    }
    public void setKind(String kind)
    {
        this.kind = kind;
    }

    public String getKind()
    {
        return kind;
    }
    public void setRecommend(Long recommend)
    {
        this.recommend = recommend;
    }

    public Long getRecommend()
    {
        return recommend;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("annual", getAnnual())
            .append("tvSeries", getTvSeries())
            .append("img", getImg())
            .append("topicContent", getTopicContent())
            .append("type", getType())
            .append("director", getDirector())
            .append("screenwriter", getScreenwriter())
            .append("actor", getActor())
            .append("episodeNum", getEpisodeNum())
            .append("reasons", getReasons())
            .append("chronologicalDivision", getChronologicalDivision())
            .append("url", getUrl())
            .append("kind", getKind())
            .append("recommend", getRecommend())
            .toString();
    }


    // 封装多选影视类型
    public String getDisposeType(){
        Map<String, String> collect = DictUtils.getDictCache("ds_film_type").stream().collect(Collectors.toMap(DictData::getDictValue, DictData::getDictLabel));
        StringBuilder stringBuilder = new StringBuilder();

        if(StringUtils.hasText(type)){
            List<String> list = Arrays.asList(type.split(","));
            for (String s: list){
                String s1 = collect.get(s);
                if(StringUtils.hasText(s1)){

                    if(StringUtils.hasText(stringBuilder)){
                        stringBuilder.append("/").append(s1);
                    }else {
                        stringBuilder.append(s1);
                    }

                }

            }

        }

        return stringBuilder.toString();
    }
}
