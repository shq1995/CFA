package com.shq.cfa.repository;

import com.shq.cfa.entity.Authority;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;


/**
 * @author shuihuaqi
 * @create 2018-03-27 10:32
 * @desc Authority 仓库
 **/
public interface AuthorityRepository extends JpaRepository<Authority, Integer>,JpaSpecificationExecutor<Authority> {
}
