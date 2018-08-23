package com.lpan.service;

import com.lpan.repository.UserRepository;
import org.apache.commons.lang.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class UserService {

    private static final String APPID = "wxb7af7dfdf8468680";
    private static final String APPSECRET = "cef5f771c9a87b2ef3fc4dafaf192ee7";
    private static Map<String, Object> userLoginInfo = new HashMap<String, Object>();


    @Autowired
    private UserRepository userRepository;

    public String login(String code) {

        RestTemplate rest = new RestTemplate();
        String url = "https://api.weixin.qq.com/sns/jscode2session?appid=" + APPID + "&secret=" + APPSECRET + "&js_code=" + code + "&grant_type=authorization_code";
        ResponseEntity<String> exchange = rest.exchange(url, HttpMethod.GET, null, String.class);
        String body = exchange.getBody();
        String[] obj = body.split("\"");
        Map<String, String> map = new HashMap<String, String>();
        map.put(obj[1], obj[3]);
        map.put(obj[5], obj[7]);
        // 生成sessionID  返回给客户端，客户端通过sessionID可找到自己账号的openid和session_key
        String randomNum = RandomStringUtils.random(16, "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890.,;'[]=-+_?><:!@#$%^&*()");
        Date date = new Date();
        String sessionId = randomNum + date.getTime();

        userLoginInfo.put(sessionId, map);
        return sessionId;
    }
}
