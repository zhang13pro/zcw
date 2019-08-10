package com.bobo.common;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;
import java.lang.reflect.Method;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author: bobobo
 * @Date: 2019/8/8 9:23
 * @Version：1.0
 */

/**
 * 基础的servlet类 其他的子类继承该类
 * @author fujiansheng
 *
 */
public class BaseServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    public static ApplicationContext applicationContext = null;

    static{
        applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
    }

    /*@Override
    public void init() throws ServletException {
        super.init();
        applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");

    }*/

    @Override
    public void service(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("GBK");
        response.setCharacterEncoding("GBK");
        //http://www.zcw.com/userServlet?method=adduser
        String method = request.getParameter("method");
        if (null == method || "".equals(method) || method.trim().equals("")) {
            method = "execute";
        }

        // 注意:此处的this代表的是子类的对象
        // System.out.println(this);
        // 子类对象字节码对象
        Class<? extends BaseServlet> clazz = this.getClass();

        try {
            // 查找子类对象对应的字节码中的名称为method的方法.这个方法的参数类型是:HttpServletRequest.class,HttpServletResponse.class
            Method md = clazz.getMethod(method, HttpServletRequest.class, HttpServletResponse.class);
            if(null!=md){
                String jspPath = (String) md.invoke(this, request, response);
                if (null != jspPath) {
                    request.getRequestDispatcher(jspPath).forward(request, response);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 默认方法 子类需要重写
    protected String execute(HttpServletRequest request,
                             HttpServletResponse response) throws ServletException, IOException {
        return "index.html";
    }
}
