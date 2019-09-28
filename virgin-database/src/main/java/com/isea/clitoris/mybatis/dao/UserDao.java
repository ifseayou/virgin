package com.isea.clitoris.mybatis.dao;

import com.isea.clitoris.mybatis.domain.User;

import java.io.Serializable;
import java.util.List;

public interface UserDao<T extends Serializable> {
    User selectUserById(int id) throws Exception;

    int insert2User(User user) throws Exception;

    int insertByList(List<T> list) throws Exception;
}
