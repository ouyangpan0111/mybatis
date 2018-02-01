package cn.oyp.dao;

import cn.oyp.mybatis.po.User;

public interface IUserDao {
     User getUserById(int id);
     void insertUser(User user);
}
