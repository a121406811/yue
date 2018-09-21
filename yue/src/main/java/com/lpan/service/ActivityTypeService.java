package com.lpan.service;

import com.lpan.domain.ActivityType;
import com.lpan.repository.ActivityTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActivityTypeService {

    @Autowired
    private ActivityTypeRepository activityTypeRepository;

    public List<ActivityType> findAll(){
        List<ActivityType> all = activityTypeRepository.findAll();
        return all;
    }
}
