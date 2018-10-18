package com.lpan.controller;

import com.lpan.domain.UserCollectActivity;
import com.lpan.service.UserCollectActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("userCollectActivity")
public class UserCollectActivityController {

    @Autowired
    private UserCollectActivityService userCollectActivityService;

    // 新增用户收藏活动
    @RequestMapping("save")
    public boolean save(UserCollectActivity userCollectActivity) {
        userCollectActivity.setId(UUID.randomUUID().toString());
        return userCollectActivityService.save(userCollectActivity);
    }

    // 获取用户收藏活动列表
    @RequestMapping("getAllByUserId")
    public Page<UserCollectActivity> getAllByUserId(String userId, int page, int size) {
        return userCollectActivityService.getAllByUserId(userId, page, size);
    }

    // 删除用户的收藏活动
    public boolean deleteById(String id) {
        return userCollectActivityService.deleteById(id);
    }
}
