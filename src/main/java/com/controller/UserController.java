package com.controller;


import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.entity.User;
import com.service.UserService;

/**
 * creation time 2018 05 18 
 * @author User742742
 * 
 */
@RestController
public class UserController{
    public static List<User> listUser;
    
    @Autowired
    UserService userService;

    /**
     * 登录
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "/login",method=RequestMethod.POST)
    public JSONObject login(HttpServletRequest request,HttpServletResponse response) {
        try {
            String username = new String((request.getParameter("username")).getBytes("ISO-8859-1"),"UTF-8");
            String password = new String((request.getParameter("password")).getBytes("ISO-8859-1"),"UTF-8");
            System.out.println(username);
            System.out.println(password);
            System.out.println(request.getHeader("Referer"));
            if (request.getHeader("Referer")!=null) {
                System.out.println(listUser);
                if (listUser == null) {
                    listUser = userService.select();
                } 
                for (User user : listUser) {
                    if(user.getUsername().equals(username)) {
                        if(user.getPassword().equals(password)) {
                            System.err.println("登录成功");
                            JSONObject json = JSON.parseObject("{ret=0,username="+user.getUsername()
                            +",password="+user.getPassword()+",address="+user.getAddress()+"}");
                            return json;
                        }
                        System.err.println("密码错误");
                        JSONObject json = JSON.parseObject("{ret=1}");
                        return json;
                    }
                    System.err.println("用户不存在");
                    JSONObject json = JSON.parseObject("{ret=2}");
                    return json;
                }
                System.err.println("数据库错误");
                JSONObject json = JSON.parseObject("{ret=3}");
                return json;
            }
            System.err.println("非法进入");
            JSONObject json = JSON.parseObject("{ret=6}");
            return json;
        } catch (UnsupportedEncodingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.err.println("编码错误");
            JSONObject json = JSON.parseObject("{ret=4}");
            return json;
        } catch(Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.err.println("系统错误");
            JSONObject json = JSON.parseObject("{ret=5}");
            return json;
        }
    }

   

    @RequestMapping(value = "/userInsert",method=RequestMethod.POST)
    public int insert(Object record) {
        // TODO Auto-generated method stub
        return 0;
    }

    @RequestMapping(value = "/userUpdata",method=RequestMethod.POST)
    public int update(Object record) {
        // TODO Auto-generated method stub
        return 0;
    }

    @RequestMapping(value = "/userSelect",method=RequestMethod.POST)
    public List<?> select(Integer... id) {
        // TODO Auto-generated method stub
        return null;
    }
    @RequestMapping(value = "/userDelect",method=RequestMethod.POST)
    public int delect(int id) {
        // TODO Auto-generated method stub
        return 0;
    }
    
}
