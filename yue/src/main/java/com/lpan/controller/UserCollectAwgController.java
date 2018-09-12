package com.lpan.controller;

import com.lpan.domain.UserCollectAwg;
import com.lpan.service.UserCollectAwgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/userCollectAwg")
public class UserCollectAwgController {

    @Autowired
    private UserCollectAwgService userCollectAwgService;

    // 新增
    @RequestMapping("save")
    public boolean save(UserCollectAwg userCollectAwg) {
        return userCollectAwgService.save(userCollectAwg);
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
