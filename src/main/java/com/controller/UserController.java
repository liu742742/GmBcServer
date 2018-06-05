package com.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
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
    public Map<String, Object> login(@RequestBody Map<String, Object> data) {
        Map<String, Object> map = new HashMap<String, Object>();
        String username = ((String) data.get("username")).trim();
        String password = ((String) data.get("password")).trim();
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
    public Map<String, Object> insert(@RequestBody Map<String, Object> data) {
        Map<String, Object> map = new HashMap<String, Object>();
        String username = ((String) data.get("username")).trim();
        String password = ((String) data.get("password")).trim();
        String address = ((String) data.get("address")).trim();
        User user = userService.selectByPrimaryUsername(username);
        if (user != null) {
            System.err.println("用户名已存在");
            map.put("ret", 2);
            map.put("msg", "用户名已存在");
        } else {
            user = userService.selectByPrimaryAddress(address);
            if (user.getId() != null) {
                System.err.println("区块链地址已存在");
                map.put("ret", 3);
                map.put("msg", "区块链地址已存在");
            } else {
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
            }
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
    public Map<String, Object> update(@RequestBody Map<String, Object> data) {
        Map<String, Object> map = new HashMap<String, Object>();
        User user = new User();
        user.setId(Integer.parseInt(((String) data.get("id")).trim()));
        user.setUsername(((String) data.get("username")).trim());
        user.setPassword(((String) data.get("password")).trim());
        user.setAddress(((String) data.get("address")).trim());
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
    public Map<String, Object> select(@RequestBody Map<String, Object> data) {
        Map<String, Object> map = new HashMap<String, Object>();
        User user = new User();
        user = userService.selectByPrimaryKey(Integer.parseInt(((String) data.get("id")).trim()));
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
