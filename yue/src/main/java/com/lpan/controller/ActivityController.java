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
import java.util.UUID;

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

    // 有选择条件（活动类型，地点，时间，费用）的搜索(此方法传入的startTime的格式为：yyyy/MM/dd(或者只有年或月)  搜索只能精确天数！)
    @RequestMapping("conditionSearch")
    public Page<Activity> conditionSearch(String str, String activityTypeId, String place, String startTime, double maxTicketPrice, double minTicketPrice, int sex, int maxAge, int minAge, int page, int size) {
        // 数据库的date类型经过cast(startTime as char)转换后，变成 yyyy/MM/dd HH:mm:ss格式，所以这里要把格式进行转换
        String dateStr = startTime.replace("/", "-");
        return activityService.conditionSearch(str, activityTypeId, place, dateStr, maxTicketPrice, minTicketPrice, sex, maxAge, minAge, page, size);
    }

    // 添加活动
    @RequestMapping("saveActivity")
    public boolean saveActivity(Activity activity) {
        long i = activity.getEndTime().getTime() - activity.getStartTime().getTime();
        long hour = i / (1000 * 60 * 60);
        activity.setActivityTime(hour + "小时");
        activity.setId(UUID.randomUUID().toString());
        return activityService.saveActivity(activity);
    }

    @RequestMapping("test")
    public List<Map<String, String>> test() {
//        return "连接成功oooooook" + ":" + new Date();
        List<Map<String, String>> test = activityService.test();
        return test;
    }

    // 查看自己发布的活动
    @RequestMapping("findMyActivity")
    public List<Activity> findMyActivity(String userId) {
        return activityService.findMyActivity(userId);
    }

    public static void main(String[] args) {
        System.out.println(new Date());
    }
}
