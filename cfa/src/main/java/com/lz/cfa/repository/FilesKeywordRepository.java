package com.lz.cfa.repository;

import com.lz.cfa.entity.FilesKeyword;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;


/**
 * @author
 * @create 2018-03-27 10:38
 * @desc 案卷关键字
 **/
public interface FilesKeywordRepository extends JpaRepository<FilesKeyword, Integer>,JpaSpecificationExecutor<FilesKeyword> {
  FilesKeyword findByTypeAndKeyword(Integer type,String keyWord);
  List<FilesKeyword> findByType(Integer type);
}

