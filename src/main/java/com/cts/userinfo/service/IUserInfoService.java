package com.cts.userinfo.service;

import com.cts.userinfo.vo.UserInfo;

import java.util.List;


public interface IUserInfoService {

    UserInfo createUserInfo(UserInfo customer);

    List<UserInfo> readAllUsers();

    UserInfo updateUserInfo(Long userId, UserInfo customer);

    boolean deleteUserInfo(Long id);

}
