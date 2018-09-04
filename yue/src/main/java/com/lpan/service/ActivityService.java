package com.lpan.service;

import com.lpan.domain.Activity;
import com.lpan.repository.ActivityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Predicate;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
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

    // 项目详情
    public Activity getById(String id) {
        return activityRepository.getById(id);
    }

    // 无条件分页查询
    public Page<Activity> findHomePageMsg(int page, int size) {
        List<Activity> list = new ArrayList<Activity>();
        // 根据id来排序
        Sort sort = new Sort(Sort.Direction.DESC, "id");
        Pageable pageable = PageRequest.of(page, size, sort);
        Page<Activity> pages = activityRepository.findAll(pageable);
        return pages;
    }

    public Page<List<Map<String, String>>> search(String str, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page pages = activityRepository.findAll(pageable);
        return activityRepository.search(pageable, str);
    }

//    public Page<List<Map<String,String>>> conditionSearch(String str,String activityTypeId,String place,String startTime,String ticketPrice,int sex,int age){
//
//    }


    public List<Map<String, String>> test() {
        return activityRepository.test();
    }

}
