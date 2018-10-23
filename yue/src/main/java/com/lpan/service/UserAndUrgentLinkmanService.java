package com.lpan.service;

import com.lpan.domain.UserAndUrgentLinkman;
import com.lpan.repository.UserAndUrgentLinkmanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserAndUrgentLinkmanService {

    @Autowired
    private UserAndUrgentLinkmanRepository userAndUrgentLinkmanRepository;

    public boolean save(UserAndUrgentLinkman userAndUrgentLinkman){
        try {
            userAndUrgentLinkmanRepository.save(userAndUrgentLinkman);
        }catch (Exception e){
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

    public boolean delete(String id){
        try {
            userAndUrgentLinkmanRepository.deleteById(id);
        }catch (Exception e){
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

    public List<UserAndUrgentLinkman> findByUserId(String userId){
        return userAndUrgentLinkmanRepository.findByUserId(userId);
    }

    public UserAndUrgentLinkman getById(String id){
        return userAndUrgentLinkmanRepository.getOne(id);
    }

}
