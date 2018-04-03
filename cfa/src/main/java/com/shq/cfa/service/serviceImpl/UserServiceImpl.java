package com.shq.cfa.service.serviceImpl;

import java.util.List;

import javax.transaction.Transactional;

import com.shq.cfa.entity.User;
import com.shq.cfa.repository.UserRepository;
import com.shq.cfa.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
  public Page<User> listUsersByNameLike(String name, Pageable pageable) {
    // 模糊查询
    name = "%" + name + "%";
    Page<User> users = userRepository.findByNameLike(name, pageable);
    return users;
  }

  @Override
  public User getUserByName(String username) {
    return userRepository.findByUsername(username);
  }
}
