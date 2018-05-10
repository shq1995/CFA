package com.shq.cfa.service;

import com.shq.cfa.entity.FilesKeyword;
import org.springframework.data.domain.Page;

import java.util.List;

public interface FilesKeywordService {

  FilesKeyword findOne(Integer id);

  FilesKeyword save(FilesKeyword filesKeyword);
  FilesKeyword update(FilesKeyword filesKeyword);

  FilesKeyword findByTypeAndKeyword(Integer type,String keyword);

  List<FilesKeyword> findAll();

  List<FilesKeyword> findByType(Integer type);

  void  removeFilesKeyword(Integer id);

  Page<FilesKeyword> findKeywordNoCriteria(Integer page,Integer size);

  Page<FilesKeyword> findKeywordCriteria(Integer page,Integer size,Integer type,String keyword);

}
