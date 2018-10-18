package com.lpan.controller;

import com.lpan.domain.UserInfo;
import com.lpan.service.UserService;
import org.apache.commons.lang.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.util.Calendar;
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
    public Map<String, Object> login(HttpServletRequest request, String code, String userInfo) {

//        {"nickName":"、","gender":1,"language":"zh_CN","city":"Shantou","province":"Guangdong","country":"China","avatarUrl":"https://wx.qlogo.cn/mmopen/vi_32/ugBoV3VerYMKNgg8L9BSLwJNROrKaOfVZ0pn3Vot4C2wXpAib30rRQFnsv1x39YmPEgeibAKP6iaRJGlxPptH85xw/132"}

        // 存放微信的用户信息
        Map<String, String> wxUserinfo = new HashMap<String, String>();
        String[] split = userInfo.split("\"");
        wxUserinfo.put(split[1], split[3]);
        wxUserinfo.put(split[5], split[6].substring(1, 2));
        wxUserinfo.put(split[7], split[9]);
        wxUserinfo.put(split[11], split[13]);
        wxUserinfo.put(split[15], split[17]);
        wxUserinfo.put(split[19], split[21]);
        wxUserinfo.put(split[23], split[25]);

        // 生成sessionID  返回给客户端，客户端通过sessionID可找到自己账号的openid和session_key
        String randomNum = RandomStringUtils.random(16, "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890.,;'[]=-+_?><:!@#$%^&*()");
        Date date = new Date();
        String sessionId = randomNum + date.getTime();

        // 以sessionID为key，openid与sessionkey为值存储到session中，并设置超时时间为半个小时
        Map<String, String> wxOpenidAndSessionkey = userService.getOpenidAndSessionkey(code);
        HttpSession session = request.getSession();
        session.setAttribute(sessionId, wxOpenidAndSessionkey);
        session.setMaxInactiveInterval(1800);

        // 如果用户第一次登陆，则绑定用户与微信号
        UserInfo user = userService.bindUserAndWx(wxOpenidAndSessionkey.get("openid"), wxUserinfo);

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("sessionId", sessionId);
        map.put("userInfo", user);
        return map;
    }

    // 用户修改个人信息
    @RequestMapping("save")
    public boolean updateUserMsg(UserInfo userInfo, File file) throws IOException {
        // 根据生日，设置年龄
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(userInfo.getBirthday());
        int birthday = calendar.get(Calendar.YEAR);
        calendar.setTime(new Date());
        int day = calendar.get(Calendar.YEAR);
        int age = day - birthday;
        userInfo.setAge(age);

        return userService.updateUserMsg(userInfo, file);
    }

    @RequestMapping("/needValidate/test")
    public String test() {
        String a = "interceptor";
        return a;
    }

    public static void main(String[] args) throws IOException {
        File file = new File("src\\main\\resources\\static\\user1");
        if (!file.exists()) {
            file.mkdir();
        }
        System.out.println(file.getPath());
    }

}
