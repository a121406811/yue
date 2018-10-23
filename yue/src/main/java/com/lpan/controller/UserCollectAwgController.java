package com.lpan.controller;

import com.lpan.domain.UserCollectAwg;
import com.lpan.service.UserCollectAwgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/userCollectAwg")
public class UserCollectAwgController {

    @Autowired
    private UserCollectAwgService userCollectAwgService;

    // 新增
    @RequestMapping("save")
    public String save(UserCollectAwg userCollectAwg) {
        userCollectAwg.setId(UUID.randomUUID().toString());
        boolean b = userCollectAwgService.collExists(userCollectAwg.getActivityWantGo().getId(), userCollectAwg.getUserId());
        String result = null;
        if (b == true) {
            result = "exists";
        } else {
            boolean save = userCollectAwgService.save(userCollectAwg);
            if (save == true) {
                result = "save success";
            } else {
                result = "save fail";
            }
        }
        return result;
    }

    // 根据用户ID查询收藏用户
    @RequestMapping("getAllByUserId")
    public Page<UserCollectAwg> getAllByUserId(String userId, int page, int size) {
        return userCollectAwgService.getAllByUserId(userId, page, size);
    }

    // 根据用户收藏用户表的ID删除收藏用户
    @RequestMapping("deleteById")
    public boolean deleteById(String id) {
        return userCollectAwgService.deleteById(id);
    }

}
