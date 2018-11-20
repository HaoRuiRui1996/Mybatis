package com.rui.model.mapper;

import com.rui.model.pojo.SysRole;
import com.rui.model.pojo.SysUser;
import org.apache.ibatis.annotations.CacheNamespaceRef;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface SysUserMapper {

    SysUser selectById(Long id);

    //foreach查找
    List<SysUser> selectByUserIds(List<Long> ids);

    List<SysUser> selectAll();

    List<SysRole> selectRolesByUserId(Long id);

    SysUser selectRolesByUserId2(Long id);

    List<SysUser> selectByUser(SysUser user);

    List<SysUser> selectByUserIdOrName(SysUser user);

    int insert(SysUser user);

    //使用jdbc方式返回主键自增值
    int insert2(SysUser user);

    //使用SelectKey返回主键自增的值
    int insert3(SysUser user);

    //用foreach实现批量插入
    int insertUsers( List<SysUser> users);

    int updateById(SysUser user);

    int updateByMap(@Param("map") Map<String, Object> map, @Param("id") Long id);

    int updateByIdSelective(SysUser user);

    int deleteById(Long id);

    List<SysRole> selectRolesByUser(@Param("userId") Long userId, @Param("enabled") Integer enabled);

    List<SysRole> selectRolesByUserAndRole(@Param("user") SysUser user, @Param("role") SysRole role);
}