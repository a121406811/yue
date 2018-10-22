package com.lpan.repository;

import com.lpan.domain.Activity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Map;

public interface ActivityRepository extends JpaRepository<Activity, String>, JpaSpecificationExecutor<Activity> {

    List<Activity> getAllByActivityName(String activityName);

    // 无条件分页查询首页展示信息
//    @Modifying 此注解在修改数据时使用，也就是在update和delete时使用
    @Query(value = "select a.id,u.nickName,u.portrait,a.activityName,a.startTime,a.explain,a.place,a.ticketPrice from userinfo u,activityinfo a where a.userId=u.userId ", nativeQuery = true)
    public List<Map<String, String>> test();

    // 获取项目详情
    public Activity getById(String id);

//    Page<Activity> findAll(Pageable pageable);

    // 搜索
    @Query(value = "SELECT * FROM (SELECT u.userId,u.nickName,u.portrait,a.id,a.activityName,a.activityTypeId,a.place,a.peopleNum,a.startTime,a.endTime,a.ticketPrice,a.`explain`,atype.activityTypeName FROM userinfo u,activityinfo a,activitytype atype WHERE u.userId=a.userId AND a.activityTypeId=atype.id) r WHERE CONCAT(IFNULL(nickName,''),IFNULL(`explain`,''),IFNULL(`activityName`,''),IFNULL(activityTypeName,''),IFNULL(place,''),IFNULL(startTime,''),IFNULL(ticketPrice,'')) LIKE ?1", nativeQuery = true)
    public Page<List<Map<String, String>>> search(Pageable pageable, String str);

    @Query(value = "SELECT * from activityInfo where userId=?1", nativeQuery = true)
    public List<Activity> findMyActivity(String userId);
}
