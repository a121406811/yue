package com.lpan.service;

import com.lpan.domain.UserInfo;
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

    @Autowired
    private UserRepository userRepository;

    // 获取到微信小程序的openid和sessionkey
    public Map<String,String> getOpenidAndSessionkey(String code) {

        RestTemplate rest = new RestTemplate();
        String url = "https://api.weixin.qq.com/sns/jscode2session?appid=" + APPID + "&secret=" + APPSECRET + "&js_code=" + code + "&grant_type=authorization_code";
        ResponseEntity<String> exchange = rest.exchange(url, HttpMethod.GET, null, String.class);
        String body = exchange.getBody();
        String[] obj = body.split("\"");
        Map<String, String> map = new HashMap<String, String>();
        String openId = obj[3];
        map.put(obj[1], openId);
        map.put(obj[5], obj[7]);

        return map;
    }

    // 如果用户是第一次登陆，创建用户，随机生成用户ID绑定微信号；如果不是第一次，则什么也不用做
    public void bindUserAndWx(String openId) {
        UserInfo user = userRepository.getByWxOpenID(openId);
        if (user == null) {
            UserInfo userInfo = new UserInfo(openId);
            userRepository.save(userInfo);
        }
    }

}
