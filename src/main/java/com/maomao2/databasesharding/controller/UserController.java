package com.maomao2.databasesharding.controller;

import com.alibaba.fastjson.JSON;
import com.maomao2.databasesharding.dao.UserDao;
import com.maomao2.databasesharding.mapper.pkg2.UserMapper;
import com.maomao2.databasesharding.model.User;
import com.maomao2.databasesharding.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Springboot之返回json数据格式
 * 1. @Controller + setResponse。 通过HttpServletResponse 获取到输出流后，写出数据到客户端
 * 2. @Controller +@RequestBody
 * 3. @RestController
 */
@Controller
@RequestMapping("/Users")
//@RestController
public class UserController {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserDao userDao;

    @RequestMapping("/find")
    @ResponseBody
    public String get(HttpServletResponse response, @RequestParam Long id) {
        User userMo = userMapper.selectUserById(id);
        User userMo1 = userDao.findUserById(id);
        String result = "userMapper: " + JSON.toJSONString(userMo) + ", userDao: " + JSON.toJSONString(userMo1);
        setResponse(response, result);
        return null;
    }

    private void setResponse(HttpServletResponse response, String data) {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = null;
        try {
            out = response.getWriter();
        } catch (IOException e) {
            e.printStackTrace();
        }
        out.println(data);
        out.flush();
        out.close();
    }

    @Resource
    private UserService userService;

    //Spring Web MVC能够自动将请求参数绑定到功能处理方法的命令/表单对象上。
    @RequestMapping
    @ResponseBody
    public User get(HttpServletRequest request, Model model) {
        int userId = Integer.parseInt(request.getParameter("id"));
        User user = this.userService.getUserById(userId);
        return user;
    }

    @PostMapping
    @ResponseBody
    public boolean create(@RequestBody User user) {
        return userService.addUser(user);
    }
}
