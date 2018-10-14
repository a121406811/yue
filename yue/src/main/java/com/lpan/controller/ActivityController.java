package com.lpan.controller;

import com.lpan.domain.Activity;
import com.lpan.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/activity")
public class ActivityController {

    @Autowired
    private ActivityService activityService;

    @RequestMapping("findAll")
    public List<Activity> findAll() {
        List<Activity> all = activityService.findAll();
        return all;
    }

    // 项目详情
    @RequestMapping("getById")
    public Activity getById(String id) {
        return activityService.getById(id);
    }

    // 无条件分页查询首页展示信息
    @RequestMapping("findHomePageMsg")
    public Page<Activity> findHomePageMsg(int page, int size) {
        return activityService.findHomePageMsg(page, size);
    }

    // 分页模糊查询，即搜索功能
    @RequestMapping("search")
    public Page<List<Map<String, String>>> search(String str, int page, int size) {
        str = "%" + str + "%";
        return activityService.search(str, page, size);
    }

    // 有选择条件（活动类型，地点，时间，费用）的搜索
    @RequestMapping("conditionSearch")
    public Page<Activity> conditionSearch(String str, String activityTypeId, String place, String startTime, double maxTicketPrice, double minTicketPrice, int sex, int maxAge, int minAge, int page, int size) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm");
        Date date = null;
        if (startTime != null && !"".equals(startTime)) {
            try {
                date = sdf.parse(startTime);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return activityService.conditionSearch(str, activityTypeId, place, date, maxTicketPrice, minTicketPrice, sex, maxAge, minAge, page, size);
    }

    // 添加活动
    @RequestMapping("saveActivity")
    public boolean saveActivity(Activity activity) {
        long i = activity.getEndTime().getTime() - activity.getStartTime().getTime();
        long hour = i / (1000 * 60 * 60);
        activity.setActivityTime(hour + "小时");
        return activityService.saveActivity(activity);
    }

    @RequestMapping("test")
    public List<Map<String, String>> test() {
//        return "连接成功oooooook" + ":" + new Date();
        List<Map<String, String>> test = activityService.test();
        return test;
    }


    public static void main(String[] args) {
        System.out.println(new Date());
    }
}
