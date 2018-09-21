package com.lpan.controller;

import com.lpan.domain.UserAndUrgentLinkman;
import com.lpan.service.UserAndUrgentLinkmanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/userAndUrgentLinkman")
public class UserAndUrgentLinkmanController {

    @Autowired
    private UserAndUrgentLinkmanService userAndUrgentLinkmanService;

    @RequestMapping("save")
    public boolean save(UserAndUrgentLinkman userAndUrgentLinkman) {
        return userAndUrgentLinkmanService.save(userAndUrgentLinkman);
    }

    @RequestMapping("delete")
    public boolean delete(String id) {
        return userAndUrgentLinkmanService.delete(id);
    }

}
