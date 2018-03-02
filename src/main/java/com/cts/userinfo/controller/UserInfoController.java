package com.cts.userinfo.controller;


import com.cts.userinfo.service.UserInfoService;
import com.cts.userinfo.vo.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserInfoController {

    public interface EndPoint {
        String ROOT = "/";
        String CREATE_USER = "/createUser";
        String READ_USER = "/readUser";
        String UPDATE_USER = "/updateUser/{id}";
        String DELETE_USER = "/deleteUser/{id}";
    }

    @Autowired
    UserInfoService service;


    @GetMapping(value = {EndPoint.ROOT, EndPoint.READ_USER})
    public List<UserInfo> readUsers(Model model) {
        return service.readAllUsers();
    }

    @RequestMapping(method = RequestMethod.POST, value = "/createUser")
    public UserInfo createUser(@RequestBody UserInfo userInfo) {
        return service.createUserInfo(userInfo);
    }

    @PostMapping(value = EndPoint.UPDATE_USER)
    public UserInfo updateUser(@PathVariable long userId, @RequestBody UserInfo userInfo) {
        return service.updateUserInfo(userId, userInfo);
    }

    @GetMapping(value = EndPoint.DELETE_USER)
    public boolean deleteUser(@PathVariable long userId) {
        return service.deleteUserInfo(userId);
    }
}
