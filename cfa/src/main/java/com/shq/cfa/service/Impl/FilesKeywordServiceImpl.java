package com.shq.cfa.service.Impl;

import com.shq.cfa.entity.FilesKeyword;
import com.shq.cfa.repository.FilesKeywordRepository;
import com.shq.cfa.service.FilesKeywordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import java.util.ArrayList;
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
  @Transactional
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
  public List<FilesKeyword> findByType(String type) {
    return repository.findByType(type);
  }
  @Transactional
  @Override
  public void removeFilesKeyword(Integer id) {
    repository.delete(id);
  }

  @Override
  public Page<FilesKeyword> findKeywordNoCriteria(Integer page, Integer size) {
    Pageable pageable = new PageRequest(page, size, Sort.Direction.ASC, "id");
    return repository.findAll(pageable);
  }

  @Override
  public Page<FilesKeyword> findKeywordCriteria(Integer page, Integer size, final String type,String keyword) {
    Pageable pageable = new PageRequest(page, size, Sort.Direction.ASC, "id");
    Page<FilesKeyword> userPage = repository.findAll(new Specification<FilesKeyword>(){
      @Override
      public Predicate toPredicate(Root<FilesKeyword> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        List<Predicate> list = new ArrayList<Predicate>();
        if(null!=type&&!"".equals(type)){
          list.add(criteriaBuilder.like(root.get("type").as(String.class),  "%"+type+"%"));
        }
        if(null!=keyword&&!"".equals(keyword)){
          list.add(criteriaBuilder.like(root.get("keyword").as(String.class), "%"+keyword+"%"));
        }
        Predicate[] p = new Predicate[list.size()];
        return criteriaBuilder.and(list.toArray(p));
      }
    },pageable);
    return userPage;
  }
}
