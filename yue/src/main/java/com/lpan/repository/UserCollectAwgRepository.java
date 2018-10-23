package com.lpan.repository;

import com.lpan.domain.UserCollectAwg;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserCollectAwgRepository extends JpaRepository<UserCollectAwg, String> {

    public Page<UserCollectAwg> getAllByUserId(String userId, Pageable pageable);

    public void deleteById(String id);

    @Query(value = "select * from usercollectawg where userId=?2 and awgID=?1", nativeQuery = true)
    public UserCollectAwg collExists(String awgId, String userId);
}
