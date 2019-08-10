package com.bobo.portal.user.dao.impl;

import com.bobo.bean.User;
import com.bobo.common.DBUtils;
import com.bobo.portal.user.dao.IUserDao;
import org.apache.ibatis.session.SqlSession;

/**
 * @Author: bobobo
 * @Date: 2019/8/8 9:26
 * @Version：1.0
 */
public class UserDao implements IUserDao {

    private SqlSession sqlSession = DBUtils.getSqlSession();
    private String ns = "com.bobo.mapper.UserMapper.";

    @Override
    public int addUser(User user) {
        int num = 0;
        num = sqlSession.insert(ns+"addUser", user);
        return num;
    }

    @Override
    public User loginUser(User user) {
        return sqlSession.selectOne(ns+"loginUser", user);
    }
}
