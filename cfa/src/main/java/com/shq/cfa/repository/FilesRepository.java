package com.shq.cfa.repository;

import com.shq.cfa.entity.Files;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.shq.cfa.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;


/**
 * @author shuihuaqi
 * @create 2018-03-27 10:32
 * @desc 案卷 仓库
 **/
public interface FilesRepository extends JpaRepository<Files, Integer>,JpaSpecificationExecutor<Files> {
 //按照类型查询
 List<Files> findByType(String type);

 List<Files> findByTitle(String title);
 //按照来源模糊查询
 List<Files> findBySourceLike(String source);
 //按照原告模糊查询
 List<Files> findByAccuserLike(String accuser);
}
