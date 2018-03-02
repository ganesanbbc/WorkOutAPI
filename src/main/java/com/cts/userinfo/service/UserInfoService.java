package com.cts.userinfo.service;

import com.cts.userinfo.dao.UserInfoDAO;
import com.cts.userinfo.vo.UserInfo;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserInfoService implements IUserInfoService {


    @Autowired
    UserInfoDAO dao;

    @Override
    public UserInfo createUserInfo(UserInfo userInfo) {
        return dao.saveAndFlush(userInfo);
    }

    @Override
    public List<UserInfo> readAllUsers() {


        List<UserInfo> demoList = new ArrayList();
        demoList.add(new UserInfo("ganesh101", ""));
        return demoList;
//        return dao.findAll();
    }

    @Override
    public UserInfo updateUserInfo(long userId, UserInfo userInfo) {
        UserInfo oldUserinfo = dao.findOne(userId);
        BeanUtils.copyProperties(userInfo, oldUserinfo);
        return dao.saveAndFlush(userInfo);
    }

    @Override
    public boolean deleteUserInfo(long id) {
        UserInfo userinfo = dao.findOne(id);
        dao.delete(userinfo);
        return true;
    }
}
