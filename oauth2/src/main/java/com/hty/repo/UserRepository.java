package com.hty.repo;

import com.hty.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author hty
 * @date 2023-07-18 21:39
 * @email 1156388927@qq.com
 * @description
 * @other 更多请看www.autunomy.top
 */

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
    User findByUserName(String username);
}
