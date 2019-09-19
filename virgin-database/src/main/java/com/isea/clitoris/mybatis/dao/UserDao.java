package com.isea.clitoris.mybatis.dao;

import com.isea.clitoris.mybatis.domain.User;

public interface UserDao {
    User selectUserById(int id) throws Exception;

    int insert2User(User user) throws Exception;
}
