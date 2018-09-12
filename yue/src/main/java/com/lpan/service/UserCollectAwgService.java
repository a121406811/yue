package com.lpan.service;

import com.lpan.domain.UserCollectAwg;
import com.lpan.repository.UserCollectAwgRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class UserCollectAwgService {

    @Autowired
    private UserCollectAwgRepository userCollectAwgRepository;

    public boolean save(UserCollectAwg userCollectAwg) {
        try {
            userCollectAwgRepository.save(userCollectAwg);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

    public Page<UserCollectAwg> getAllByUserId(String userId, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return userCollectAwgRepository.getAllByUserId(userId, pageable);
    }

    public boolean deleteById(String id){
        try{
            userCollectAwgRepository.deleteById(id);
        }catch (Exception e){
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }
}
