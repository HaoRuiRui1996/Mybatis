package com.rui.model.mapper;

import com.rui.model.pojo.SysRolePrivilege;
import com.rui.model.pojo.SysRolePrivilegeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysRolePrivilegeMapper {
    int countByExample(SysRolePrivilegeExample example);

    int deleteByExample(SysRolePrivilegeExample example);

    int insert(SysRolePrivilege record);

    int insertSelective(SysRolePrivilege record);

    List<SysRolePrivilege> selectByExample(SysRolePrivilegeExample example);

    int updateByExampleSelective(@Param("record") SysRolePrivilege record, @Param("example") SysRolePrivilegeExample example);

    int updateByExample(@Param("record") SysRolePrivilege record, @Param("example") SysRolePrivilegeExample example);
}