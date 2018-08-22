package com.lpan.repository;

import com.lpan.domain.Activity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ActivityRepository extends JpaRepository<Activity,String> {

    List<Activity> getAllByActivityName(String activityName);

}
