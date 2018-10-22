package com.lpan.service;

import com.lpan.domain.UserCollectActivity;
import com.lpan.repository.UserCollectActivityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class UserCollectActivityService {

    @Autowired
    private UserCollectActivityRepository userCollectActivityRepository;

    public boolean save(UserCollectActivity userCollectActivity) {
        try {
            userCollectActivityRepository.save(userCollectActivity);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

    public Page<UserCollectActivity> getAllByUserId(String userId, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return userCollectActivityRepository.getAllByUserId(userId, pageable);
    }

    public boolean deleteById(String id) {
        try {
            userCollectActivityRepository.deleteById(id);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

    // 查询这个收藏是否已经存在
    public boolean collExists(String activityId, String userId) {
        UserCollectActivity userCollectActivity = userCollectActivityRepository.collExists(activityId, userId);
        if (userCollectActivity == null) {
            return false;
        }
        return true;
    }

}
