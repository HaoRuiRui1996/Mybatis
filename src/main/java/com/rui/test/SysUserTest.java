package com.rui.test;

import com.rui.model.mapper.SysRoleMapper;
import com.rui.model.mapper.SysUserMapper;
import com.rui.model.mapper.UserMapper;
import com.rui.model.pojo.SysRole;
import com.rui.model.pojo.SysUser;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.*;

public class SysUserTest extends BaseMapperTest {

    private Logger logger = Logger.getLogger(SysUserTest.class);

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

    @Test
    public void selectByUser() {
        List<SysUser> users;
        SqlSession sqlSession = getSqlSession();
        try {
            //获取UserMapper接口
            SysUserMapper sysUserMapper = sqlSession.getMapper(SysUserMapper.class);
            SysUser user = new SysUser();
            //user.setUserEmail("test@qq.com");
            users = sysUserMapper.selectByUser(user);
        } finally {
            sqlSession.close();
        }
        for (SysUser sysUser :
                users) {
            logger.info(sysUser);
        }
    }

    @Test
    public void selectByUserIdOrName() {
        List<SysUser> users;
        SqlSession sqlSession = getSqlSession();
        try {
            //获取UserMapper接口
            SysUserMapper sysUserMapper = sqlSession.getMapper(SysUserMapper.class);
            SysUser user = new SysUser();
            user.setUserName("test");
            //user.setUserEmail("test@qq.com");
            users = sysUserMapper.selectByUserIdOrName(user);
        } finally {
            sqlSession.close();
        }
        for (SysUser sysUser :
                users) {
            logger.info(sysUser);
        }
    }

    @Test
    public void selectByUserIds() {
        List<SysUser> users;
        SqlSession sqlSession = getSqlSession();
        try {
            //获取UserMapper接口
            SysUserMapper sysUserMapper = sqlSession.getMapper(SysUserMapper.class);
            List<Long> ids = new ArrayList<>();
            ids.add(1L);
            ids.add(2L);
            users = sysUserMapper.selectByUserIds(ids);
        } finally {
            sqlSession.close();
        }
        for (SysUser sysUser :
                users) {
            logger.info(sysUser);
        }
    }

    @Test
    public void insert(){
        SysUser user = new SysUser();
        user.setUserName("哇哈哈");
        user.setUserPassword("123456");
        user.setCreateTime(new Date());
        user.setUserEmail("123@qq.com");
        user.setHeadImg(new byte[]{1,2,3,});
        user.setUserInfo("test insert");
        System.out.println(user);
        SqlSession sqlSession = getSqlSession();
        try {
            SysUserMapper userMapper = sqlSession.getMapper(SysUserMapper.class);
            int result = userMapper.insert(user);
            Assert.assertEquals(1, result);
            //默认的sqlSession是不自动提交的
            //sqlSession.commit();
        } finally {
            sqlSession.rollback();
            sqlSession.close();
        }
    }

    @Test
    public void insert2(){
        SysUser user = new SysUser();
        user.setUserName("哇哈哈");
        user.setUserPassword("123456");
        user.setCreateTime(new Date());
        user.setUserEmail("123@qq.com");
        user.setHeadImg(new byte[]{1,2,3,});
        user.setUserInfo("test insert");
        System.out.println(user);
        SqlSession sqlSession = getSqlSession();
        try {
            SysUserMapper userMapper = sqlSession.getMapper(SysUserMapper.class);
            int result = userMapper.insert2(user);
            Assert.assertEquals(1, result);
            Assert.assertNotNull(user.getId());
            logger.info(user.getId());
            //默认的sqlSession是不自动提交的
            //sqlSession.commit();
        } finally {
            sqlSession.rollback();
            sqlSession.close();
        }
    }

    @Test
    public void insert3(){
        SysUser user = new SysUser();
        user.setUserName("哇哈哈");
        user.setUserPassword("123456");
        user.setCreateTime(new Date());
        user.setUserEmail("123@qq.com");
        user.setHeadImg(new byte[]{1,2,3,});
        user.setUserInfo("test insert");
        System.out.println(user);
        SqlSession sqlSession = getSqlSession();
        try {
            SysUserMapper userMapper = sqlSession.getMapper(SysUserMapper.class);
            int result = userMapper.insert3(user);
            Assert.assertEquals(1, result);
            Assert.assertNotNull(user.getId());
            logger.info(user.getId());
            //默认的sqlSession是不自动提交的
            //sqlSession.commit();
        } finally {
            sqlSession.rollback();
            sqlSession.close();
        }
    }

    @Test
    public void insertUsers() {
        SysUser userA = new SysUser();
        userA.setUserName("哇哈哈");
        userA.setUserPassword("123456");
        userA.setCreateTime(new Date());
        userA.setUserEmail("123@qq.com");
        userA.setHeadImg(new byte[]{1,2,3,});
        userA.setUserInfo("test insert");
        System.out.println(userA);
        SysUser userB = new SysUser();
        userB.setUserName("哇哈哈");
        userB.setUserPassword("123456");
        userB.setCreateTime(new Date());
        userB.setUserEmail("123@qq.com");
        userB.setHeadImg(new byte[]{1,2,3,});
        userB.setUserInfo("test insert");
        System.out.println(userB);
        SqlSession sqlSession = getSqlSession();
        try {
            SysUserMapper userMapper = sqlSession.getMapper(SysUserMapper.class);
            List<SysUser> users = new ArrayList<>();
            users.add(userA);
            users.add(userB);
            int result = userMapper.insertUsers(users);
            Assert.assertEquals(2, result);
            for (SysUser user : users) {
                System.out.println(user);
            }
            //默认的sqlSession是不自动提交的
            //sqlSession.commit();
        } finally {
            sqlSession.rollback();
            sqlSession.close();
        }
    }

    @Test
    public void updateById() {
        SqlSession sqlSession = getSqlSession();
        try {
            SysUserMapper sysUserMapper = sqlSession.getMapper(SysUserMapper.class);
            SysUser user = sysUserMapper.selectById(2L);
            logger.info("修改前" + user);
            user.setUserPassword("222222");
            int result = sysUserMapper.updateById(user);
            Assert.assertEquals(1, result);
            user = sysUserMapper.selectById(2L);
            logger.info("修改后：" + user);
        } finally {
            sqlSession.rollback();
            sqlSession.close();
        }

    }

    @Test
    public void updateByMap() {
        SqlSession sqlSession = getSqlSession();
        try {
            SysUserMapper sysUserMapper = sqlSession.getMapper(SysUserMapper.class);
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("user_password", "222222");

            int result = sysUserMapper.updateByMap(map, 1L);
            Assert.assertEquals(1, result);
            SysUser user = sysUserMapper.selectById(1L);
            logger.info("修改后：" + user);
        } finally {
            sqlSession.rollback();
            sqlSession.close();
        }

    }


    @Test
    public void updateByIdSelective() {
        SqlSession sqlSession = getSqlSession();
        try {
            SysUserMapper sysUserMapper = sqlSession.getMapper(SysUserMapper.class);
            SysUser user = new SysUser();
            user.setId(1L);
            user.setUserPassword("22222");
            logger.info("修改前" + user);
            int result = sysUserMapper.updateByIdSelective(user);
            Assert.assertEquals(1, result);
            logger.info("修改后：" + user);
        } finally {
            sqlSession.rollback();
            sqlSession.close();
        }

    }

    @Test
    public void deleteById() {
        SqlSession sqlSession = getSqlSession();
        try {
            SysUserMapper sysUserMapper = sqlSession.getMapper(SysUserMapper.class);
            SysUser user1 = sysUserMapper.selectById(2L);
            Assert.assertNotNull(user1);
            logger.info("user1: " + user1);
            Assert.assertEquals(1, sysUserMapper.deleteById(2L));
            Assert.assertNull(sysUserMapper.selectById(2L));
        } finally {
            sqlSession.rollback();
            sqlSession.close();
        }
    }

    @Test
    public  void selectRolesByUser() {
        List<SysRole> sysRoles;
        SqlSession sqlSession = getSqlSession();
        try {
            SysUserMapper sysRoleMapper = sqlSession.getMapper(SysUserMapper.class);
            sysRoles = sysRoleMapper.selectRolesByUser(1L, 1);
        } finally {
            sqlSession.close();
        }
        for (SysRole role : sysRoles) {
            System.out.println(role);
        }
    }

    @Test
    public void selectRolesByUserAndRole() {
        List<SysRole> sysRoles;
        SqlSession sqlSession = getSqlSession();
        try {
            SysUserMapper sysRoleMapper = sqlSession.getMapper(SysUserMapper.class);
            SysUser user = new SysUser();
            user.setId(1L);
            SysRole role = new SysRole();
            role.setEnabled(1);
            sysRoles = sysRoleMapper.selectRolesByUserAndRole(user, role);
        } finally {
            sqlSession.close();
        }
        for (SysRole role : sysRoles) {
            System.out.println(role);
        }
    }

    @Test
    public void testDirtyDate() {
        SqlSession sqlSession = getSqlSession();
        try {
            SysUserMapper sysUserMapper = sqlSession.getMapper(SysUserMapper.class);
            List<SysRole> role1 = sysUserMapper.selectRolesByUserId(1L);
            for (SysRole role :
                    role1) {
                System.out.println(role);
            }
        } finally {
            sqlSession.close();
        }

        SqlSession sqlSession1 = getSqlSession();
        try {
            SysRoleMapper sysRoleMapper = sqlSession1.getMapper(SysRoleMapper.class);
            SysRole sysRole = sysRoleMapper.selectById(1L);
            sysRole.setRoleName("管理员");
            sysRoleMapper.update(sysRole);
            sqlSession1.commit();
        } finally {
            sqlSession1.close();
        }

        SqlSession sqlSession2 = getSqlSession();
        try {
            SysUserMapper sysUserMapper = sqlSession2.getMapper(SysUserMapper.class);
            List<SysRole> role1 = sysUserMapper.selectRolesByUserId(1L);
            for (SysRole role :
                    role1) {
                System.out.println(role);
            }
        } finally {
            sqlSession2.close();
        }
    }

}
