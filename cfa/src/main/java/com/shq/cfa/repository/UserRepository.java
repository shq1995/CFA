package com.shq.cfa.repository;

import com.shq.cfa.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;


/**
 * @author shuihuaqi
 * @create 2018-03-27 10:38
 * @desc 用户仓库
 **/
public interface UserRepository extends JpaRepository<User, Integer>{

  /**
   * 根据用户名分页查询用户列表
   * @param name
   * @param pageable
   * @return
   */
  Page<User> findByNameLike(String name, Pageable pageable);

  User findByUsername(String username);
}

