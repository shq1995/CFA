package com.shq.cfa.repository;

import com.shq.cfa.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;


/**
 * @author shuihuaqi
 * @create 2018-03-27 10:38
 * @desc 用户仓库
 **/
public interface UserRepository extends JpaRepository<User, Integer>,JpaSpecificationExecutor<User> {


  User findByUsername(String username);
}

