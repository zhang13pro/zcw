package com.bobo.portal.user.dao;

import com.bobo.bean.User;

/**
 * @Author: bobobo
 * @Date: 2019/8/9 8:58
 * @Version：1.0
 */
public interface IUserDao {
    int addUser(User user);

    User loginUser(User user);
}
