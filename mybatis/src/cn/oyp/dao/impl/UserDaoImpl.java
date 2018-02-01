package cn.oyp.dao.impl;

import cn.oyp.dao.IUserDao;
import cn.oyp.mybatis.po.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class UserDaoImpl implements IUserDao {

   //注入sqlSeesionFactory
    private SqlSessionFactory sqlSessionFactory;

    public UserDaoImpl(SqlSessionFactory sqlSessionFactory) {
       // this.sqlSessionFactory = sqlSessionFactory;

    }

    @Override
    public User getUserById(int id) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        sqlSession.selectOne("");


        return null;
    }

    @Override
    public void insertUser(User user) {

    }
}
