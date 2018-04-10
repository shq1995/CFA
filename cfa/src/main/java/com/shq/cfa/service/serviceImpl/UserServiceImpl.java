package com.shq.cfa.service.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import com.shq.cfa.entity.User;
import com.shq.cfa.repository.UserRepository;
import com.shq.cfa.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

/**
 * @author shuihuaqi
 * @create 2018-03-27 10:42
 * @desc User 服务
 **/
@Service
public class UserServiceImpl implements UserService{

  @Autowired
  private UserRepository userRepository;

  @Transactional
  @Override
  public User saveUser(User user) {
    return userRepository.save(user);
  }

  @Transactional
  @Override
  public void removeUser(Integer id) {
    userRepository.delete(id);
  }

  @Transactional
  @Override
  public void removeUsersInBatch(List<User> users) {
    userRepository.deleteInBatch(users);
  }

  @Transactional
  @Override
  public User updateUser(User user) {
    return userRepository.save(user);
  }

  @Override
  public User getUserById(Integer id) {
    return userRepository.getOne(id);
  }

  @Override
  public List<User> listUsers() {
    return userRepository.findAll();
  }


  @Override
  public User getUserByName(String username) {
    return userRepository.findByUsername(username);
  }

  @Override
  public Page<User> findUserNoCriteria(Integer page, Integer size) {
    Pageable pageable = new PageRequest(page, size, Sort.Direction.ASC, "id");
    return userRepository.findAll(pageable);
  }

  @Override
  public Page<User> findUserByNameLike(Integer page, Integer size,String name) {
    Pageable pageable = new PageRequest(page, size, Sort.Direction.ASC, "id");
    Page<User> userPage = userRepository.findAll(new Specification<User>(){
      @Override
      public Predicate toPredicate(Root<User> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        List<Predicate> list = new ArrayList<Predicate>();
        list.add(criteriaBuilder.like(root.get("name").as(String.class), "%"+name+"%"));
        Predicate[] p = new Predicate[list.size()];
        return criteriaBuilder.and(list.toArray(p));
      }
    },pageable);
    return userPage;
  }
}
