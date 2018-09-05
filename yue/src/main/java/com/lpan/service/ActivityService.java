package com.lpan.service;

import com.lpan.domain.Activity;
import com.lpan.domain.ActivityType;
import com.lpan.repository.ActivityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.Date;
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

    public List<Activity> conditionSearch(String str, String activityTypeId, String place, String startTime, double maxTicketPrice, double minTicketPrice, int sex, int maxAge, int minAge) {
        List<Activity> resultList = null;
        Specification querySpecifi = new Specification<Activity>() {
            @Override
            public Predicate toPredicate(Root<Activity> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {

                List<Predicate> predicates = new ArrayList<>();
                if (null != activityTypeId && !"".equals(activityTypeId)) {
//                    Join<Activity, ActivityType> joinTeacher = root.join("ActivityType", JoinType.LEFT);
                    predicates.add(criteriaBuilder.equal(root.get("activityType").get("id"), activityTypeId));
                }
                if (null != place && !"".equals(place)) {
                    predicates.add(criteriaBuilder.like(root.get("place"), "%" + place + "%"));
                }
                if (null != startTime && !"".equals(startTime)) {
                    predicates.add(criteriaBuilder.like(root.get("startTime"), "%" + startTime + "%"));
                }
                if (0 != maxTicketPrice) {
                    predicates.add(criteriaBuilder.le(root.get("maxTicketPrice"), maxTicketPrice));// 小于等于
                    predicates.add(criteriaBuilder.ge(root.get("minTicketPrice"), minTicketPrice));// 大于等于
                }
                if (maxTicketPrice == 0 && minTicketPrice != 0) {
                    predicates.add(criteriaBuilder.ge(root.get("minTicketPrice"), minTicketPrice));
                }
                if (sex != 2) { // 不限性别
                    predicates.add(criteriaBuilder.equal(root.get("sex"), sex));
                }
                if (0 != maxAge) {
                    predicates.add(criteriaBuilder.le(root.get("maxAge"), maxAge));// 小于等于
                    predicates.add(criteriaBuilder.ge(root.get("minAge"), minAge));// 大于等于
                }
                if (maxAge == 0 && minAge != 0) {
                    predicates.add(criteriaBuilder.ge(root.get("minAge"), minAge));
                }
                if (str != null && !"".equals(str)) {
                    // 联表模糊查询
//                    Join<Activity, ActivityType> joinTeacheracher = root.join("ActivityType", JoinType.LEFT);
                    predicates.add(criteriaBuilder.like(root.get("activityType").get("activityTypeName"), "%" + str + "%"));

                    predicates.add(criteriaBuilder.like(root.get("userInfo").get("nickName"), "%" + str + "%"));
                    predicates.add(criteriaBuilder.like(root.get("explain"), "%" + str + "%"));
                    predicates.add(criteriaBuilder.like(root.get("activityName"), "%" + str + "%"));
                    predicates.add(criteriaBuilder.like(root.get("place"), "%" + str + "%"));
                    predicates.add(criteriaBuilder.like(root.get("startTime"), "%" + str + "%"));
                    predicates.add(criteriaBuilder.like(root.get("ticketPrice"), "%" + str + "%"));
                }

                return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
            }
        };
        resultList = this.activityRepository.findAll(querySpecifi);
        return resultList;
    }

    public List<Map<String, String>> test() {
        return activityRepository.test();
    }

}
