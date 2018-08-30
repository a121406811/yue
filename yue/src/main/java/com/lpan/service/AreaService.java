package com.lpan.service;

import com.lpan.domain.AreaInfo;
import com.lpan.repository.AreaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AreaService {

    @Autowired
    private AreaRepository areaRepository;

    public List<AreaInfo> findAll(){
        List<AreaInfo> all = areaRepository.findAll();
        return all;
    }
}
