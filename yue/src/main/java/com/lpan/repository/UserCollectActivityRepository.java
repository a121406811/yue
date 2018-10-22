package com.lpan.repository;

import com.lpan.domain.UserCollectActivity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserCollectActivityRepository extends JpaRepository<UserCollectActivity, String> {

    public Page<UserCollectActivity> getAllByUserId(String userId, Pageable pageable);

    @Query(value = "select * from usercollectactivity  where activityId = ?1 and userId=?2", nativeQuery = true)
    public UserCollectActivity collExists(String activityId, String userId);
}
