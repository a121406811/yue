package com.lpan.controller;

import com.lpan.domain.AreaInfo;
import com.lpan.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@ResponseBody
public class AreaController {

    @Autowired
    private AreaService areaService;

    public List<AreaInfo> findAll(){
        List<AreaInfo> all = areaService.findAll();
        return all;
    }
}
