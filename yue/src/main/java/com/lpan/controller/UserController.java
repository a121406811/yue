package com.lpan.controller;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.lpan.service.UserService;
import org.apache.commons.lang.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/user")
@ResponseBody
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("login")
    public Map<String, String> login(HttpServletRequest request, String code, String userInfo) {

        // 生成sessionID  返回给客户端，客户端通过sessionID可找到自己账号的openid和session_key
        String randomNum = RandomStringUtils.random(16, "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890.,;'[]=-+_?><:!@#$%^&*()");
        Date date = new Date();
        String sessionId = randomNum + date.getTime();

        // 以sessionID为key，openid与sessionkey为值存储到session中，并设置超时时间为半个小时
        Map<String, String> wxOpenidAndSessionkey = userService.getOpenidAndSessionkey(code);
        HttpSession session = request.getSession();
        session.setAttribute(sessionId,wxOpenidAndSessionkey);
        session.setMaxInactiveInterval(1800);

        // 如果用户第一次登陆，则绑定用户与微信号
        userService.bindUserAndWx(wxOpenidAndSessionkey.get("openid"));

        Map<String, String> map = new HashMap<String, String>();
        map.put("sessionId", sessionId);
        return map;
    }


    @RequestMapping("/needValidate/test")
    public String test(){
        String a = "interceptor";
        return a ;
    }
}
