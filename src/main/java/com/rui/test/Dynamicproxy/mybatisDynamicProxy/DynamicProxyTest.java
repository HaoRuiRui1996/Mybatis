package com.rui.test.Dynamicproxy.mybatisDynamicProxy;

import com.rui.model.mapper.SysUserMapper;
import com.rui.model.pojo.SysUser;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;
import java.lang.reflect.Proxy;
import java.util.List;

public class DynamicProxyTest {
    public static void main(String[] args) throws IOException {
        Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
        SqlSession sqlSession = sessionFactory.openSession();

        MybatisInvocationHandler handler = new MybatisInvocationHandler(sqlSession);

        SysUserMapper sysUserMapper = (SysUserMapper) Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(),
                new Class[] {SysUserMapper.class}, handler);
        List<SysUser> users = sysUserMapper.selectAll();
        for (SysUser user : users) {
            System.out.println(user);
        }
    }
}
