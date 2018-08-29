package com.lpan.service;

import com.lpan.domain.Activity;
import com.lpan.repository.ActivityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActivityService {

    @Autowired
    private ActivityRepository activityRepository;

    public List<Activity> findAll(){
        List<Activity> all = activityRepository.findAll();
        return all;
    }
}
