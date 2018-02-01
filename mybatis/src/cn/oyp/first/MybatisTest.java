package cn.oyp.first;

import cn.oyp.mybatis.po.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

public class MybatisTest {
    private SqlSessionFactory sqlSessionFactory = null;

    @Before
    public void init() throws IOException {
        //第一步 创建一个 SQLSessionFactoryBuilder 对象
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        //第二步 加载配置文件
        InputStream inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        //第三步 创建SQLSessionFactory对象
        sqlSessionFactory = sqlSessionFactoryBuilder.build(inputStream);
    }
    @Test
    public void getUserById() throws IOException {
        //第四步 创建SQLSession 对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //第五步 使用 SqlSession 对象执行查询 得到 User 对象
        User user = sqlSession.selectOne("getUserById", 10);
        //第六步 打印结果
        System.out.println(user);
        //第七步 释放资源
        sqlSession.close();
    }

    @Test
    public void getUserByName(){
        //创建一个 sqlSession 对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //执行查询
        List<User> list = sqlSession.selectList("getUserByName","张");
        for (User user : list) {
            System.out.println(user);
        }
        //释放资源
        sqlSession.close();
    }

    @Test
    public void addUser(){
        //创建一个 sqlSession 对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //创建 User对象
        User user = new User();
        user.setUsername("小乔");
        user.setBirthday(new Date());
        user.setSex("2");
        user.setAddress("上海");
        //插入用户
        sqlSession.insert("insertUser",user);
        System.out.println(user.getId());
        //提交事务
        sqlSession.commit();
        //释放资源
        sqlSession.close();
    }

    @Test
    public void deleteUser(){
        //创建一个 sqlSession 对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //删除用户
        sqlSession.delete("deleteUser",16);
        //提交事务
        sqlSession.commit();
        //释放资源
        sqlSession.close();
    }

    @Test
    public void updateUser(){
        //创建一个 sqlSession 对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //创建一个User对象
        User user = new User();
        user.setUsername("赵四");
       user.setId(27);
        //更新用户
        sqlSession.update("updateUser",user);
        //提交事务
        sqlSession.commit();
        //释放资源
        sqlSession.close();
    }
}
