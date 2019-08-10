package com.bobo.portal.user.servlet;

import com.bobo.bean.User;
import com.bobo.common.BaseServlet;
import com.bobo.portal.user.dao.impl.UserDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

/**
 * @Author: bobobo
 * @Date: 2019/8/8 9:21
 * @Version：1.0
 */
@WebServlet({"/userServlet.do"})
public class UserServlet extends BaseServlet{

    private static final long serialVersionUID = 1L;
    private UserDao userDao = null;

    @Override
    public void init() throws ServletException {
        super.init();
        userDao = (UserDao) applicationContext.getBean("userDao");
    }

    /*注册方法*/
    //该方法的url是 http://www.zc.com/userServlet.do?method=regUser
    public String regUser(HttpServletRequest request, HttpServletResponse response) {
        try {
            request.setCharacterEncoding("GBK");
            String loginacct = request.getParameter("loginacct");
            String userpswd = request.getParameter("userpswd");
            String email = request.getParameter("email");
            String username = request.getParameter("username");
            String name = new String(username.getBytes("iso-8859-1"),"UTF-8");
            String userType = request.getParameter("userType");
            User user = new User(loginacct,userpswd,username,email);
            int num =userDao.addUser(user);
            if(num>=1) {
                return "index.html";
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return "error.html";
    }

    /*登陆方法*/
    public String dologin(HttpServletRequest request, HttpServletResponse response){
        PrintWriter out = null;
        try {
            out = response.getWriter();
            String loginacct = request.getParameter("loginacct");
            String userpswd = request.getParameter("userpswd");
            User user = new User(loginacct, userpswd, null, null);
            User loguser = userDao.loginUser(user);
            if (loguser == null){
                out.print("error");  //表示状态 纯文本
            }else {
                out.print("ok");
            }
        } catch (IOException e) {
            e.printStackTrace();
            return "error.html";
        }

        return null;
    }
}
