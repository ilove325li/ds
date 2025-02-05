package com.ds.project.front.title.service.impl;

import java.lang.reflect.Array;
import java.util.List;
import java.util.ArrayList;

import com.ds.common.constant.UserConstants;
import com.ds.common.utils.StringUtils;
import com.ds.framework.web.domain.Ztree;
import com.ds.project.system.dept.domain.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ds.project.front.title.mapper.DsTitleMapper;
import com.ds.project.front.title.domain.DsTitle;
import com.ds.project.front.title.service.IDsTitleService;
import com.ds.common.utils.text.Convert;

import static com.ds.common.utils.uuid.Seq.getId;
import static org.apache.commons.lang3.StringUtils.split;

/**
 * 党史标题管理Service业务层处理
 * 
 * @author wkk
 * @date 2025-02-02
 */
@Service
public class DsTitleServiceImpl implements IDsTitleService 
{
    @Autowired
    private DsTitleMapper dsTitleMapper;

    /**
     * 查询党史标题管理
     * 
     * @param id 党史标题管理主键
     * @return 党史标题管理
     */
    @Override
    public DsTitle selectDsTitleById(Long id)
    {
        return dsTitleMapper.selectDsTitleById(id);
    }

    /**
     * 查询党史标题管理列表
     * 
     * @param dsTitle 党史标题管理
     * @return 党史标题管理
     */
    @Override
    public List<DsTitle> selectDsTitleList(DsTitle dsTitle)
    {
        return dsTitleMapper.selectDsTitleList(dsTitle);
    }

    /**
     * 新增党史标题管理
     * 
     * @param dsTitle 党史标题管理
     * @return 结果
     */
    @Override
    public int insertDsTitle(DsTitle dsTitle)
    {
        DsTitle dsTitle1 = dsTitleMapper.selectDsTitleById(dsTitle.getParentId());

        Long id = dsTitle1.getId();


        //=======  判断简介的==============

        if(dsTitle.getBriefIntroduction()==""){
            dsTitle.setBriefIntroduction(null);
        }

        if(dsTitle.getBriefIntroduction()!=null){
            if(dsTitle1.getId()==100){
                throw new RuntimeException("只能在三级分类中添加简介");
            }
        }


        //=====================



        // 统计层级数
        int num = 1;

        for (;;){
        if(!(id==100)){
            DsTitle dsTitle2 = dsTitleMapper.selectDsTitleById(id);
            id = dsTitle2.getParentId();
            num++;
        }else {
            break;
        }
        }
        if(num == 3){
            throw new RuntimeException("最多只能有三个层级，层级超过3个");
        }

        return dsTitleMapper.insertDsTitle(dsTitle);
    }

    /**
     * 修改党史标题管理
     * 
     * @param dsTitle 党史标题管理
     * @return 结果
     */
    @Override
    public int updateDsTitle(DsTitle dsTitle)
    {

        if(dsTitle.getBriefIntroduction()==""){
            dsTitle.setBriefIntroduction(null);
        }

        if(dsTitle.getBriefIntroduction()!=null){

            DsTitle dsTitle1 = dsTitleMapper.selectDsTitleById(dsTitle.getId());

            if(dsTitle1.getParentId()==100){
                throw new RuntimeException("只能在三级分类中添加简介");
            }

        }

        return dsTitleMapper.updateDsTitle(dsTitle);
    }

    /**
     * 批量删除党史标题管理
     * 
     * @param ids 需要删除的党史标题管理主键
     * @return 结果
     */
    @Override
    public int deleteDsTitleByIds(String ids)
    {
        return dsTitleMapper.deleteDsTitleByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除党史标题管理信息
     * 
     * @param id 党史标题管理主键
     * @return 结果
     */
    @Override
    public int deleteDsTitleById(Long id)
    {
        return dsTitleMapper.deleteDsTitleById(id);
    }

    /**
     * 查询党史标题管理树列表
     * 
     * @return 所有党史标题管理信息
     */
    @Override
    public List<Ztree> selectDsTitleTree()
    {
        List<DsTitle> dsTitleList = dsTitleMapper.selectDsTitleList(new DsTitle());
        List<Ztree> ztrees = new ArrayList<Ztree>();
        for (DsTitle dsTitle : dsTitleList)
        {
            Ztree ztree = new Ztree();
            ztree.setId(dsTitle.getId());
            ztree.setpId(dsTitle.getParentId());
            ztree.setName(dsTitle.getTitle());
            ztree.setTitle(dsTitle.getTitle());
            ztrees.add(ztree);
        }
        return ztrees;
    }

    @Override
    public List<Ztree> selectDeptTree() {
        List<DsTitle> deptList = dsTitleMapper.selectDsTitleList(new DsTitle());
        List<Ztree> ztrees = initZtree(deptList);
        return ztrees;
    }

    @Override
    public DsTitle selectDeptById(Long deptId) {
        DsTitle dsTitle = dsTitleMapper.selectDsTitleById(deptId);

        return dsTitle;
    }

    @Override
    public List<DsTitle> selectDsTitleByParentId(Long aLong) {

        return dsTitleMapper.selectDsTitleByParentId(aLong);
    }

    @Override
    public List<DsTitle> selectDsTitleByTitle(String title) {
        return dsTitleMapper.selectDsTitleByTitle(title);
    }


    /**
     * 对象转部门树
     *
     * @param deptList 部门列表
     * @return 树结构列表
     */
    public List<Ztree> initZtree(List<DsTitle> deptList)
    {
        return initZtree(deptList, null);
    }

    /**
     * 对象转部门树
     *
     * @param deptList 部门列表
     * @param roleDeptList 角色已存在菜单列表
     * @return 树结构列表
     */
    public List<Ztree> initZtree(List<DsTitle> deptList, List<String> roleDeptList)
    {
        List<Ztree> ztrees = new ArrayList<Ztree>();
        boolean isCheck = StringUtils.isNotNull(roleDeptList);
        for (DsTitle dept : deptList)
        {
//            if (UserConstants.DEPT_NORMAL.equals(dept.getStatus()))
//            {
                Ztree ztree = new Ztree();
                ztree.setId(dept.getId());
                ztree.setpId(dept.getParentId());
                ztree.setName(dept.getTitle());
                ztree.setTitle(dept.getTitle());
                if (isCheck)
                {
                    ztree.setChecked(roleDeptList.contains(dept.getId() + dept.getTitle()));
                }
                ztrees.add(ztree);
//            }
        }
        return ztrees;
    }

}
