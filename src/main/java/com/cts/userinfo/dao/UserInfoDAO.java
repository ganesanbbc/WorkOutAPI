package com.cts.userinfo.dao;

import com.cts.userinfo.vo.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserInfoDAO extends JpaRepository<UserInfo, Long> {
}
