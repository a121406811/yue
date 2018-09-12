package com.lpan.repository;

import com.lpan.domain.ActivityWantGo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ActivityWantGoRepository extends JpaRepository<ActivityWantGo, String> {

    @Query(value = "select count(id) from activityWantGo where activityId = ?1", nativeQuery = true)
    public int getCountByActivityId(String activityId);

//    public List<String> getUserIdsByActivityId(String activityId, Pageable pageable);

    @Query(value = "select a.* from activityWantGo a where activityId = ?1", nativeQuery = true)
    public Page<ActivityWantGo> findByActivityId(String activityId, Pageable pageable);
}
