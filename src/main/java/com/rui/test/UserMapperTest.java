package com.rui.test;

import com.rui.model.pojo.SysUser;
import com.rui.model.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

public class UserMapperTest extends BaseMapperTest {
    private static SqlSessionFactory sqlSessionFactory;

    @Test
    public void testSelectAll() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            List<User> users = sqlSession.selectList("selectAll");
            for (User user : users) {
                System.out.println(user);
            }
        } finally {
            sqlSession.close();
        }
    }
}
