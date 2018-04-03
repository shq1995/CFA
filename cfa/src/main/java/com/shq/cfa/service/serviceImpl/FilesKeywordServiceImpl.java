package com.shq.cfa.service.serviceImpl;

import com.shq.cfa.entity.FilesKeyword;
import com.shq.cfa.repository.FilesKeywordRepository;
import com.shq.cfa.service.FilesKeywordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author shuihuaqi
 * @create 2018-04-03 15:01
 * @desc
 **/
@Service
public class FilesKeywordServiceImpl implements FilesKeywordService{
  @Autowired
  private FilesKeywordRepository repository;

  @Override
  public FilesKeyword findOne(Integer id) {
    return repository.findOne(id);
  }

  @Override
  public FilesKeyword save(FilesKeyword filesKeyword) {
    return repository.save(filesKeyword);
  }

  @Override
  public FilesKeyword findByKeywordLike(String keyword) {
    return repository.findByKeywordLike(keyword);
  }

  @Override
  public List<FilesKeyword> findAll() {
    return repository.findAll();
  }

  @Override
  public List<FilesKeyword> findByTypeLike(String type) {
    return repository.findByTypeLike(type);
  }
}
