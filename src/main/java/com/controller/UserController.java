package com.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.entity.User;
import com.service.UserService;

/**
 * 用户名、密码操作 creation time 2018 05 25
 * 
 * @author User742742
 * 
 */
@RestController
public class UserController {

    @Autowired
    UserService userService;

    /**
     * 登录
     * 
     * @param data
     * @return
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
    public Map<String, Object> login(HttpServletRequest request, HttpServletResponse response) {
        Map<String, Object> map = new HashMap<String, Object>();
        String username = request.getParameter("username").trim();
        String password = request.getParameter("password").trim();
        User user = userService.selectByPrimaryUsernameAndPassword(username, password);
        if (user != null) {
            System.err.println("登录成功");
            map.put("ret", 0);
            map.put("address", user.getAddress());
            map.put("msg", "登录成功");
        } else {
            System.err.println("用户名或密码错误");
            map.put("ret", 1);
            map.put("msg", "用户名或密码错误");
        }
        return map;
    }

    /**
     * 注册
     * 
     * @param data
     * @return
     */
    @RequestMapping(value = "/signup", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
    public Map<String, Object> insert(HttpServletRequest request, HttpServletResponse response) {
        Map<String, Object> map = new HashMap<String, Object>();
        String username = request.getParameter("username").trim();
        String password = request.getParameter("password").trim();
        String address = request.getParameter("address").trim();
        User user = userService.selectByPrimaryUsername(username);
        if (user != null) {
            System.err.println("用户名已存在");
            map.put("ret", 2);
            map.put("msg", "用户名已存在");
            return map;
        }

        user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setAddress(address);
        if (userService.insertSelective(user) == 1) {
            System.err.println("新增成功");
            map.put("ret", 0);
            map.put("msg", "新增成功");
        } else {
            System.err.println("新增失败");
            map.put("ret", 1);
            map.put("msg", "新增失败");
        }
        return map;
    }

    /**
     * 修改
     * 
     * @param data
     * @return
     */
    @RequestMapping(value = "/userUpdata", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
    public Map<String, Object> update(HttpServletRequest request, HttpServletResponse response) {
        Map<String, Object> map = new HashMap<String, Object>();
        User user = new User();
        user.setId(Integer.parseInt(request.getParameter("id").trim()));
        user.setUsername(request.getParameter("username").trim());
        user.setPassword(request.getParameter("password").trim());
        user.setAddress(request.getParameter("address").trim());
        if (userService.updateByPrimaryKeySelective(user) == 1) {
            System.err.println("修改成功");
            map.put("ret", 0);
            map.put("user", user);
            map.put("msg", "修改成功");
        } else {
            System.err.println("修改失败");
            map.put("ret", 1);
            map.put("msg", "修改失败");
        }
        return map;
    }

    /**
     * 查询本人
     * 
     * @param data
     * @return
     */
    @RequestMapping(value = "/userSelect", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
    public Map<String, Object> select(HttpServletRequest request, HttpServletResponse response) {
        Map<String, Object> map = new HashMap<String, Object>();
        User user = new User();
        user = userService.selectByPrimaryKey(Integer.parseInt(request.getParameter("id").trim()));
        if (user != null) {
            System.err.println("根据id查询成功");
            map.put("ret", 0);
            map.put("user", user);
            map.put("msg", "根据id查询成功");
        } else {
            System.err.println("用户不存在");
            map.put("ret", 1);
            map.put("msg", "用户不存在");
        }
        return map;
    }
}
