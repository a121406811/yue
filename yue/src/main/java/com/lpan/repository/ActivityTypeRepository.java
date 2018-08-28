package com.lpan.repository;

import com.lpan.domain.ActivityType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ActivityTypeRepository extends JpaRepository<ActivityType,String> {

    public List<ActivityType> findAll();
}
