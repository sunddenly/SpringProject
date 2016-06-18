package com.hebut.dao;

import com.hebut.entity.User;

/**
 * Created by jxy on 2016/6/5.
 */
public interface UserDao {
    public User findByName(String name);
}
