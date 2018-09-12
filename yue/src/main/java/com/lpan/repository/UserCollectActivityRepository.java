package com.lpan.repository;

import com.lpan.domain.UserCollectActivity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserCollectActivityRepository extends JpaRepository<UserCollectActivity, String> {

    public Page<UserCollectActivity> getAllByUserId(String userId, Pageable pageable);
}
