package com.lpan.service;

import com.lpan.domain.Activity;
import com.lpan.repository.ActivityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@Service
public class ActivityService {

    @Autowired
    private ActivityRepository activityRepository;

    public List<Activity> findAll() {
        List<Activity> all = activityRepository.findAll();
        return all;
    }

    // 无条件分页查询
    public List<Activity> findHomePageMsg(int page, int size) {
        List<Activity> list = new ArrayList<Activity>();
        // 根据id来排序
        Sort sort = new Sort(Sort.Direction.DESC, "id");
        Pageable pageable = PageRequest.of(page, size, sort);
        Page<Activity> pages = activityRepository.findAll(pageable);
        Iterator<Activity> it = pages.iterator();
        while (it.hasNext()) {
            list.add(it.next());
        }
        return list;
    }

    public  List<Map<String,String>> test(){
        return activityRepository.test();
    }

}
