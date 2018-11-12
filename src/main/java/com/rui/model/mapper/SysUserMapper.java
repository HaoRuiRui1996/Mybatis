package com.rui.model.mapper;

import com.rui.model.pojo.SysRole;
import com.rui.model.pojo.SysUser;

import java.util.List;

public interface SysUserMapper {

    SysUser selectById(Long id);

    List<SysUser> selectAll();

    List<SysRole> selectRolesByUserId(Long id);
}