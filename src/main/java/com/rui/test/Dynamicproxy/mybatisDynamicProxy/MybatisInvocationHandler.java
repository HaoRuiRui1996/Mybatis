package com.rui.test.Dynamicproxy.mybatisDynamicProxy;

import com.rui.model.mapper.SysUserMapper;
import com.rui.model.pojo.SysUser;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.List;

public class MybatisInvocationHandler implements InvocationHandler {
    private static Logger logger = Logger.getLogger(MybatisInvocationHandler.class);
    private SqlSession sqlSession;

    public MybatisInvocationHandler(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        logger.info("方法执行前");
        List<SysUser> users = sqlSession.selectList(SysUserMapper.class.getCanonicalName()
                + "." + method.getName());
        logger.info("方法执行后");
        return users;

    }
}
