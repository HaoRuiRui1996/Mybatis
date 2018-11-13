package com.rui.model.mapper;

import com.rui.model.pojo.SysRole;
import com.rui.model.pojo.SysUser;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SysUserMapper {

    SysUser selectById(Long id);

    List<SysUser> selectAll();

    List<SysRole> selectRolesByUserId(Long id);

    int insert(SysUser user);

    //使用jdbc方式返回主键自增值
    int insert2(SysUser user);

    //使用SelectKey返回主键自增的值
    int insert3(SysUser user);

    int updateById(SysUser user);

    int deleteById(Long id);

    List<SysRole> selectRolesByUser(@Param("userId") Long userId, @Param("enabled") Integer enabled);
}