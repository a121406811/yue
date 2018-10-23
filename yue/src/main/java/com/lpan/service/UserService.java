package com.lpan.service;

import com.lpan.domain.UserAndUrgentLinkman;
import com.lpan.domain.UserInfo;
import com.lpan.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.web.client.RestTemplate;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

@Service
@Transactional(rollbackFor = Exception.class)// 指在遇到Exception时就会回滚，而如果不标注rollbackOn，只会在抛RuntimeException时回滚。
public class UserService {

    private static final String APPID = "wxb7af7dfdf8468680";
    private static final String APPSECRET = "cef5f771c9a87b2ef3fc4dafaf192ee7";

    @Autowired
    private UserRepository userRepository;

    // 获取到微信小程序的openid和sessionkey
    public Map<String, String> getOpenidAndSessionkey(String code) {

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

    // 如果用户是第一次登陆，创建用户，随机生成用户ID绑定微信号；如果不是第一次，则对比微信昵称与头像,如果有改变，则更新
    public UserInfo bindUserAndWx(String openId, Map<String, String> wxUserinfo) {
        UserInfo user = userRepository.getByWxOpenID(openId);
        if (user == null) {
            user = new UserInfo(openId, wxUserinfo.get("nickName"), wxUserinfo.get("avatarUrl"), Integer.parseInt(wxUserinfo.get("gender")));
            userRepository.save(user);
        } else {
            int state = 0;
            if (!wxUserinfo.get("nickName").equals(user.getWxNickName())) {
                user.setWxNickName(wxUserinfo.get("nickName"));
                state++;
            }
            if (!wxUserinfo.get("avatarUrl").equals(user.getWxPortrait())) {
                user.setWxPortrait(wxUserinfo.get("avatarUrl"));
                state++;
            }
            if (state != 0) {
                userRepository.save(user);
            }
        }
        return user;
    }

    // 更新个人信息
    public boolean updateUserMsg(UserInfo userInfo, File file) throws IOException {
        InputStream is = null;
        OutputStream os = null;
        File saveFile = null;
        try {
            // 设置头像保存
            is = new FileInputStream(file);
            File saveFilepPath = new File("src\\main\\resources\\static\\" + userInfo.getUserId());
            saveFile = new File("src\\main\\resources\\static\\" + userInfo.getUserId() + "\\por.jpg");
            if (!saveFilepPath.exists()) {
                saveFilepPath.mkdir();
            }
            if (saveFile.exists()) {
                saveFile.delete();
            }
            os = new FileOutputStream(saveFile);
            byte[] buff = new byte[1024 * 4];
            for (int length = is.read(buff); length != -1; length = is.read(buff)) {
                os.write(buff, 0, length);
            }
            os.flush();
            is.close();
            os.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return false;
        }
        userInfo.setPortrait(saveFile.getPath());
        userRepository.save(userInfo);
        return true;
    }

    // 根据openid获取用户信息
    public UserInfo getUserInfoByWxOpenId(String wxOpenId) {
        UserInfo user = userRepository.getByWxOpenID(wxOpenId);
        return user;
    }

    public UserInfo getOne(String userId) {
        return userRepository.getOne(userId);
    }
}
