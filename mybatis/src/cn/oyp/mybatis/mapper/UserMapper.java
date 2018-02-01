package cn.oyp.mybatis.mapper;

import cn.oyp.mybatis.po.User;

import java.util.List;

public interface UserMapper {
    User getUserById(int id);
    List<User> getUserByName(String username);
    void insertUser(User user);
    void deleteUser(int id);
    void updateUser(User user);
}
