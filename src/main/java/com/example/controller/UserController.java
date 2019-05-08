package com.example.controller;

import com.example.pojo.User;
import com.example.repository.UserRepository;
import com.example.userService.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.xml.crypto.Data;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Controller
@RequestMapping("/admin/user")
public class UserController {

    @Resource(name = "userService")
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    /**
     * 简单的测试mybatis
     *
     * @return
     */
    @RequestMapping(value = "/test", method = RequestMethod.GET)
    @ResponseBody
    public String getUser() {
        User user = userService.selectOne("419c8ac023a211e9a00a00ffd4afd5a8");
        return user.getName();
    }


    /**
     * mvc跳转jsp或者html页面
     *
     * @return
     */
    @RequestMapping(value = "/hello")
    public String hello() {
//      ModelAndView view = new ModelAndView("index");
        System.out.println("fff");
        return "index";
    }

    /**
     * 测试spring-data-jpa
     */
    @RequestMapping(value = "/add")
    @ResponseBody
    public String testJpa() {
        User user = new User();
        user.setId("999999");
        user.setName("测试jpa");
        user.setAddress("朝阳");
        user.setAge("22");
        User save = userRepository.save(user);
        return save.toString();
    }

    /**
     * 测试spring-data-jpa
     */
    @RequestMapping(value = "/findAll")
    @ResponseBody
    public void findAll() {
        List<User> list = userRepository.findAll();
        for (int i = 0; i < list.size(); i++) {
            User user = list.get(i);
            System.out.println(user.getName());
        }
    }

    /**
     * 测试spring-data-jpa
     */
    @RequestMapping(value = "findOne")
    @ResponseBody
    public void findOne() {
        Optional<User> optional = userRepository.findById("999999");
        System.out.println(optional.get().getName());
    }

    @RequestMapping(value = "testZone")
    @ResponseBody
    public User testZone() {
        User user = new User();
        user.setId("898989");
        userService.insert(user);

        return user;


    }

}
