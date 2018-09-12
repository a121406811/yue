package com.lpan.repository;

import com.lpan.domain.UserInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<UserInfo,String> {

    public UserInfo getByWxOpenID(String openId);

//    public Page<UserInfo> getUserByIds(List<String> ids, Pageable pageable);

}
