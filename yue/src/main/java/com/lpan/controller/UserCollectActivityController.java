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
    public String save(UserCollectActivity userCollectActivity) {
        userCollectActivity.setId(UUID.randomUUID().toString());
        boolean b = userCollectActivityService.collExists(userCollectActivity.getActivity().getId(), userCollectActivity.getUserId());
        String result = null;
        if (b == true) { // 查询此收藏是否已存在
            result = "exists";
        } else {
            boolean save = userCollectActivityService.save(userCollectActivity);
            if (save = true) {
                result = "save success";
            } else {
                result = "save fail";
            }
        }
        return result;
    }

    // 获取用户收藏活动列表
    @RequestMapping("getAllByUserId")
    public Page<UserCollectActivity> getAllByUserId(String userId, int page, int size) {
        return userCollectActivityService.getAllByUserId(userId, page, size);
    }

    // 删除用户的收藏活动
    @RequestMapping("deleteById")
    public boolean deleteById(String id) {
        return userCollectActivityService.deleteById(id);
    }
}
