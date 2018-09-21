package com.lpan.service;

import com.lpan.domain.Activity;
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

    public Page<Activity> conditionSearch(String str, String activityTypeId, String place, String startTime, double maxTicketPrice, double minTicketPrice, int sex, int maxAge, int minAge, int page, int size) {

        Specification querySpecifi = new Specification<Activity>() {
            @Override
            public Predicate toPredicate(Root<Activity> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {

                List<Predicate> predicates = new ArrayList<>();
                if (null != activityTypeId && !"".equals(activityTypeId)) {
                    // 联表的字段条件查询
                    predicates.add(criteriaBuilder.equal(root.get("activityType").get("id"), activityTypeId));
                }
                if (null != place && !"".equals(place)) {
                    predicates.add(criteriaBuilder.like(root.get("place"), "%" + place + "%"));
                }
                if (null != startTime && !"".equals(startTime)) {
                    predicates.add(criteriaBuilder.like(root.get("startTime"), "%" + startTime + "%"));
                }
                if (0 != maxTicketPrice) {
                    predicates.add(criteriaBuilder.le(root.get("ticketPrice"), maxTicketPrice));// 小于等于
                    predicates.add(criteriaBuilder.ge(root.get("ticketPrice"), minTicketPrice));// 大于等于
                }
                if (maxTicketPrice == 0 && minTicketPrice != 0) {
                    predicates.add(criteriaBuilder.ge(root.get("ticketPrice"), minTicketPrice));
                }
                if (sex != 2) { // 不限性别
                    predicates.add(criteriaBuilder.equal(root.get("userInfo").get("sex"), sex));
                }
                if (0 != maxAge) {
                    predicates.add(criteriaBuilder.le(root.get("userInfo").get("age"), maxAge));// 小于等于
                    predicates.add(criteriaBuilder.ge(root.get("userInfo").get("age"), minAge));// 大于等于
                }
                if (maxAge == 0 && minAge != 0) {
                    predicates.add(criteriaBuilder.ge(root.get("userInfo").get("age"), minAge));
                }
                if (str != null && !"".equals(str)) {
                    // 联表模糊查询
                    predicates.add(criteriaBuilder.like(root.get("activityType").get("activityTypeName"), "%" + str + "%"));

                    predicates.add(criteriaBuilder.like(root.get("userInfo").get("nickName"), "%" + str + "%"));
                    predicates.add(criteriaBuilder.like(root.get("explain"), "%" + str + "%"));
                    predicates.add(criteriaBuilder.like(root.get("activityName"), "%" + str + "%"));
                    predicates.add(criteriaBuilder.like(root.get("place"), "%" + str + "%"));
                    predicates.add(criteriaBuilder.like(root.get("startTime"), "%" + str + "%"));
                    predicates.add(criteriaBuilder.like(root.get("ticketPrice"), "%" + str + "%"));
                }

                // 这下面的五行代码，是因为当predicates中没有东西，也就是无条件查询时，sql最后莫名其妙会多一个WHERE 0=1,然后肯定什么都查不到啊！
                // 但是有条件的时候就不会出现这种问题，百度不到答案，只好自己在加一个相当于是废话的条件：activityId not null 加了这个，就不会出现where 0=1这样的事件了。。
                Predicate ps = criteriaBuilder.or(predicates.toArray(new Predicate[predicates.size()]));
                predicates.clear();

                predicates.add(ps);
                predicates.add(criteriaBuilder.isNotNull(root.get("id")));
                ps = criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));

                return ps;
            }
        };

        Pageable pageable = PageRequest.of(page, size);
        Page<Activity> result = activityRepository.findAll(querySpecifi, pageable);
        return result;
    }

    public List<Map<String, String>> test() {
        return activityRepository.test();
    }

    public boolean saveActivity(Activity activity) {
        try {
            activityRepository.save(activity);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }


}
