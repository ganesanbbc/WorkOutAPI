package com.cts.userinfo.service;

import com.cts.userinfo.dao.UserInfoDAO;
import com.cts.userinfo.vo.UserInfo;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
    public UserInfo updateUserInfo(Long userId, UserInfo userInfo) {

//        Optional<UserInfo> oldUserinfo = dao.findOne(userId);
        BeanUtils.copyProperties(userInfo, dao.findOne(userId));
        return dao.saveAndFlush(userInfo);
    }

    @Override
    public boolean deleteUserInfo(Long userId) {
//        Optional<UserInfo> oldUserinfo = dao.findById(userId);
        dao.delete(dao.findOne(userId));
        return true;
    }
}
