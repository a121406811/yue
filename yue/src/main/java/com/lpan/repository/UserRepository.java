package com.lpan.repository;

import com.lpan.domain.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<UserInfo,String> {

    public UserInfo getByWxOpenID(String openId);

//    public Page<UserInfo> getUserByIds(List<String> ids, Pageable pageable);

}
