package com.lpan.repository;

import com.lpan.domain.UserAndUrgentLinkman;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserAndUrgentLinkmanRepository extends JpaRepository<UserAndUrgentLinkman, String> {

    @Query(value = "select * from userandurgentlinkman where userId=?1", nativeQuery = true)
    public List<UserAndUrgentLinkman> findByUserId(String userId);


}
