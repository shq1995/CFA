package com.lz.cfa.repository;

import com.lz.cfa.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;


/**
 * @author
 * @create 2018-03-27 10:38
 * @desc 用户仓库
 **/
public interface UserRepository extends JpaRepository<User, Integer>,JpaSpecificationExecutor<User> {


  User findByUsername(String username);
}

