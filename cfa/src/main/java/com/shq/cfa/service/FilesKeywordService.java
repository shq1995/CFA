package com.shq.cfa.service;

import com.shq.cfa.entity.FilesKeyword;

import java.util.List;

public interface FilesKeywordService {

  FilesKeyword findOne(Integer id);

  FilesKeyword save(FilesKeyword filesKeyword);

  FilesKeyword findByKeywordLike(String keyword);

  List<FilesKeyword> findAll();

  List<FilesKeyword> findByTypeLike(String type);
  void  removeFilesKeyword(Integer id);

}
