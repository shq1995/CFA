package com.shq.cfa.repository;

import com.shq.cfa.entity.FilesKeyword;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


/**
 * @author shuihuaqi
 * @create 2018-03-27 10:38
 * @desc 案卷关键字
 **/
public interface FilesKeywordRepository extends JpaRepository<FilesKeyword, Integer>{
  FilesKeyword findByKeywordLike(String keyWord);
  List<FilesKeyword> findByTypeLike(String type);
}

