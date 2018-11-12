package com.rui.test;

import com.rui.model.mapper.SysUserMapper;
import com.rui.model.mapper.UserMapper;
import com.rui.model.pojo.SysRole;
import com.rui.model.pojo.SysUser;
import org.apache.ibatis.session.SqlSession;
import org.junit.Assert;
import org.junit.Test;

import java.util.Collections;
import java.util.List;

public class SysUserTest extends BaseMapperTest {

    @Test
    public void testSelectAll() {
        List<SysUser> sysUser;
        SqlSession sqlSession = getSqlSession();
        try {
            sysUser = sqlSession.selectList("com.rui.model.mapper.SysUserMapper.selectAll");
        } finally {
            sqlSession.close();
        }
        for (SysUser user : sysUser) {
            System.out.println(user);
        }
    }

    @Test
    public void testSelectById() {
        SysUser sysUser;
        SqlSession sqlSession = getSqlSession();
        try {
            //获取UserMapper接口
            SysUserMapper sysUserMapper = sqlSession.getMapper(SysUserMapper.class);
            sysUser = sysUserMapper.selectById(1L);
        } finally {
            sqlSession.close();
        }
        Assert.assertNotNull(sysUser);
        Assert.assertEquals("admin", sysUser.getUserName());
        System.out.println(sysUser);
    }

    @Test
    public void selectRolesByUserId() {
        SqlSession sqlSession = getSqlSession();
        List<SysRole> sysRoles;
        try {
            //获取UserMapper接口
            SysUserMapper sysUserMapper = sqlSession.getMapper(SysUserMapper.class);
            sysRoles = sysUserMapper.selectRolesByUserId(1L);
        } finally {
            sqlSession.close();
        }
        for (SysRole sysRole : sysRoles) {
            System.out.println(sysRole);
        }
    }
}
