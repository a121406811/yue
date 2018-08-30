package com.lpan.repository;

import com.lpan.domain.Activity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ActivityRepository extends JpaRepository<Activity,String> {

    List<Activity> getAllByActivityName(String activityName);

    // 无条件分页查询首页展示信息
//    @Modifying 此注解在修改数据时使用，也就是在update和delete时使用
    @Query(value = "select a.id,u.nickName,u.portrait,a.activityName,a.startTime,a.explain,a.place,a.ticketPrice from userinfo u,activityinfo a where a.userId=u.userId limit ?1,?2", nativeQuery = true)
    public List<Activity> findHomePageMsg(int startPage, int endPage);

    Page<Activity> findAll(Pageable pageable);

}
