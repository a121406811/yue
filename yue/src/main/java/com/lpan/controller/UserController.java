package com.lpan.controller;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.lpan.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/user")
@ResponseBody
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("login")
    public Map<String,String> login(String code,String userInfo){

        String sessionId = userService.login(code);
        Map<String,String> map = new HashMap<String, String>();
        map.put("sessionId",sessionId);
        return map;
    }
}
