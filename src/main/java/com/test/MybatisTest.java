package com.test;

import com.dao.UserDao;
import com.domain.User;
import com.service.UserService;
import com.service.impl.UserServiceImpl;
import javafx.application.Application;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.InputStream;
import java.util.List;

public class MybatisTest {
    @Test
    public void run1() throws Exception{
        InputStream in = Resources.getResourceAsStream("mybatis.xml");
        //2.获取SqlSessionFactory
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        //3.获取SqlSession对象
        SqlSession sqlSession = factory.openSession();
        //4.获取dao的代理对象
       UserDao userDao = sqlSession.getMapper(UserDao.class);

        List<User> users = userDao.queryAll();
        for(User user : users){
            System.out.println(user);
        }
        //提交事务
        sqlSession.commit();
        //6.释放资源
        sqlSession.close();
        in.close();
    }
}
