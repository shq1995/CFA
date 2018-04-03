package com.shq.cfa.repository;

import com.shq.cfa.entity.Files;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.shq.cfa.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;


 /**
 * @author shuihuaqi
 * @create 2018-03-27 10:32
 * @desc 案卷 仓库
 **/
public interface FilesRepository extends JpaRepository<Files, Integer>{
}
