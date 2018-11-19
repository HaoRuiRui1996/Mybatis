package com.rui.test;

import com.rui.model.mapper.SysRoleMapper;
import com.rui.model.pojo.SysRole;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;

import java.util.Date;
import java.util.List;


public class SysRoleTest extends BaseMapperTest{

    private static Logger logger = Logger.getLogger(SysRoleTest.class);

    @Test
    public void selectById() {
        SqlSession sqlSession = getSqlSession();
        try {
            SysRoleMapper sysRoleMapper = sqlSession.getMapper(SysRoleMapper.class);
            SysRole role = sysRoleMapper.selectById(1L);
            System.out.println("0:" + role);
            SysRole role1 = sysRoleMapper.selectById(1L);
            System.out.println("1:" + role1);
        } finally {
            sqlSession.close();
        }
        sqlSession = getSqlSession();
        try {
            SysRoleMapper sysRoleMapper = sqlSession.getMapper(SysRoleMapper.class);
            SysRole role = sysRoleMapper.selectById(1L);
            System.out.println("0:" + role);
            SysRole role1 = sysRoleMapper.selectById(1L);
            System.out.println("1:" + role1);
        } finally {
            sqlSession.close();
        }
    }

    @Test
    public void selectAll() {
        SqlSession sqlSession = getSqlSession();
        try {
            SysRoleMapper sysRoleMapper = sqlSession.getMapper(SysRoleMapper.class);
            List<SysRole> roles = sysRoleMapper.selectAll();
            for (SysRole role :
                 roles) {
                logger.info(role);
            }
        } finally {
            sqlSession.close();
        }
    }

    @Test
    public void insert() {
        SqlSession sqlSession = getSqlSession();
        try {
            SysRoleMapper sysRoleMapper = sqlSession.getMapper(SysRoleMapper.class);
            SysRole role = new SysRole();
            role.setEnabled(1);
            role.setCreateBy(2L);
            role.setCreateTime(new Date());
            role.setRoleName("admin");
            int result = sysRoleMapper.insert(role);
            Assert.assertEquals(1, result);
        } finally {
            sqlSession.close();
        }
    }

    @Test
    public void insert1() {
        SqlSession sqlSession = getSqlSession();
        try {
            SysRoleMapper sysRoleMapper = sqlSession.getMapper(SysRoleMapper.class);
            SysRole role = new SysRole();
            role.setEnabled(1);
            role.setCreateBy(2L);
            role.setCreateTime(new Date());
            role.setRoleName("admin");
            int result = sysRoleMapper.insert1(role);
            Assert.assertEquals(1, result);
            logger.info(role);
        } finally {
            sqlSession.close();
        }
    }

    @Test
    public void insert2() {
        SqlSession sqlSession = getSqlSession();
        try {
            SysRoleMapper sysRoleMapper = sqlSession.getMapper(SysRoleMapper.class);
            SysRole role = new SysRole();
            role.setEnabled(1);
            role.setCreateBy(2L);
            role.setCreateTime(new Date());
            role.setRoleName("admin");
            int result = sysRoleMapper.insert2(role);
            Assert.assertEquals(1, result);
            logger.info(role);
        } finally {
            sqlSession.close();
        }
    }

    @Test
    public void update() {
        SqlSession sqlSession = getSqlSession();
        try {
            SysRoleMapper sysRoleMapper = sqlSession.getMapper(SysRoleMapper.class);
            SysRole role = sysRoleMapper.selectById(1L);
            role.setRoleName("普通用户");
            int result = sysRoleMapper.update(role);
            Assert.assertEquals(1, result);
            logger.info(role);
        } finally {
            sqlSession.close();
        }
    }

    @Test
    public void delete() {
        SqlSession sqlSession = getSqlSession();
        try {
            SysRoleMapper sysRoleMapper = sqlSession.getMapper(SysRoleMapper.class);
            SysRole role = sysRoleMapper.selectById(1L);
            int result = sysRoleMapper.delete(role);
            Assert.assertEquals(1, result);
            logger.info(role);
        } finally {
            sqlSession.close();
        }
    }
}
