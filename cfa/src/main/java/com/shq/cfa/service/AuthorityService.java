package com.shq.cfa.service;


import com.shq.cfa.entity.Authority;

import java.util.List;


/**
 * @author shuihuaqi
 * @create 2018-03-27 10:32
 * @desc Authority 服务接口.
 **/
public interface AuthorityService {
	 
	
	/**
	 * 根据id获取 Authority
	 * @param id
	 * @return
	 */
	Authority getAuthorityById(Integer id);

	List<Authority> listAuthoritys();
}
