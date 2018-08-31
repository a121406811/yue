package com.lpan.controller;

import com.lpan.domain.AreaInfo;
import com.lpan.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@ResponseBody
@RequestMapping("/area")
public class AreaController {

    @Autowired
    private AreaService areaService;

    @RequestMapping("findAll")
    public List<AreaInfo> findAll(){
        List<AreaInfo> all = areaService.findAll();
        return all;
    }
}
