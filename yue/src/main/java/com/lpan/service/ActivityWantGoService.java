package com.lpan.service;

import com.lpan.domain.ActivityWantGo;
import com.lpan.repository.ActivityWantGoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ActivityWantGoService {

    @Autowired
    private ActivityWantGoRepository activityWantGoRepository;

    public boolean save(ActivityWantGo activityWantGo) {
        try {
            activityWantGoRepository.save(activityWantGo);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

    public int getCountByActivityId(String activityId) {
        return activityWantGoRepository.getCountByActivityId(activityId);
    }

    public Page<ActivityWantGo> getUserInfoByActivityId(String activityId, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<ActivityWantGo> result = activityWantGoRepository.findByActivityId(activityId, pageable);
        return result;
    }

    // 查询这个活动想去人是否已经存在
    public boolean collExists(String activityId, String userId) {
        ActivityWantGo activityWantGo = activityWantGoRepository.collExists(activityId, userId);
        if (activityWantGo == null) {
            return false;
        }
        return true;
    }


}
