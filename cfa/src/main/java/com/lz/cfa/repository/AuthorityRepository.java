package com.lz.cfa.repository;

import com.lz.cfa.entity.Authority;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;


/**
 * @author
 * @create 2018-03-27 10:32
 * @desc Authority 仓库
 **/
public interface AuthorityRepository extends JpaRepository<Authority, Integer>,JpaSpecificationExecutor<Authority> {
}
