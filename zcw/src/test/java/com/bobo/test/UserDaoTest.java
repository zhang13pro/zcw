package com.bobo.test;

import com.bobo.bean.User;
import com.bobo.portal.user.dao.impl.UserDao;
import org.junit.Test;


/**
 * @Author: bobobo
 * @Date: 2019/8/8 9:47
 * @Version：1.0
 */
public class UserDaoTest {
    @Test
    public void test1(){
        UserDao dao = new UserDao();
        User user = new User();
        user.setUsername("王二");
        user.setUserpswd("54382333");
        user.setLoginacct("wanger");
        user.setCreatetime("2019-08-08");
        user.setEmail("1796@qq.com");
        dao.addUser(user);
    }
}
