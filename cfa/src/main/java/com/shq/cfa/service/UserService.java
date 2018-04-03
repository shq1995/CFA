package com.shq.cfa.service;

import java.util.List;

import com.shq.cfa.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;



/**
 * @author shuihuaqi
 * @create 2018-03-27 10:40
 * @desc User 服务接口
 **/
public interface UserService {
  /**
   * 保存用户
   * @param user
   * @return
   */
  User saveUser(User user);

  /**
   * 删除用户
   * @param id
   * @return
   */
  void removeUser(Integer id);

  /**
   * 删除列表里面的用户
   * @param users
   * @return
   */
  void removeUsersInBatch(List<User> users);

  /**
   * 更新用户
   * @param user
   * @return
   */
  User updateUser(User user);

  /**
   * 根据id获取用户
   * @param id
   * @return
   */
  User getUserById(Integer id);

  /**
   * 获取用户列表
   * @param
   * @return
   */
  List<User> listUsers();

  /**
   * 根据用户名进行分页模糊查询
   * @param name,pageable
   * @return
   */
  Page<User> listUsersByNameLike(String name, Pageable pageable);

  /**
   * 根据id获取用户
   * @param username
   * @return
   */
  User getUserByName(String username);

}
