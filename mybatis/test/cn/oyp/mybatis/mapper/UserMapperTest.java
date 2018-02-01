package cn.oyp.mybatis.mapper;

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

public class UserMapperTest {
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
    public void getUserById() throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //获得代理对象
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = userMapper.getUserById(10);
        System.out.println(user);

        //释放资源
        sqlSession.close();
    }

    @Test
    public void getUserByName() throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //获得代理对象
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<User> list = userMapper.getUserByName("张");
        for (User user : list) {
            System.out.println(user);
        }

        sqlSession.close();
    }

    @Test
    public void insertUser() throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //获得代理对象
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        //创建一个user对象
        User user = new User();
        user.setUsername("赵四");
        user.setAddress("辽宁");
        user.setSex("1");
        user.setBirthday(new Date());

        userMapper.insertUser(user);

       // System.out.println(user.getId());
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void deleteUser() throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //获得代理对象
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
       userMapper.deleteUser(27);

       sqlSession.commit();
        sqlSession.close();
    }
    @Test
    public void updateUser() throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //获得代理对象
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        User user =  new User();
        user.setUsername("刘能");
        user.setId(33);
        userMapper.updateUser(user);

        sqlSession.commit();
        sqlSession.close();
    }


}
